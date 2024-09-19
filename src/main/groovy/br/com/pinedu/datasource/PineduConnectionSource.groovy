package br.com.pinedu.datasource

import groovy.transform.CompileStatic
import org.grails.config.PropertySourcesConfig
import org.grails.datastore.mapping.core.connections.AbstractConnectionSources
import org.grails.datastore.mapping.core.connections.ConnectionSource
import org.grails.datastore.mapping.core.connections.ConnectionSourceFactory
import org.grails.datastore.mapping.core.connections.ConnectionSourceSettings
import org.springframework.core.env.PropertyResolver
import java.util.concurrent.ConcurrentHashMap

@CompileStatic
class PineduConnectionSource<T, S extends ConnectionSourceSettings> extends AbstractConnectionSources<T, S> {
	private static PineduConnectionSource INSTANCE = null
	protected final Map<String, ConnectionSource<T, S>> connectionSourceMap = new ConcurrentHashMap<>( )
	static PineduConnectionSource getInstance( ) {
		return PineduConnectionSource.INSTANCE
	}
	static void setInstance( PineduConnectionSource pineduConnectionSource ) {
		if ( PineduConnectionSource.INSTANCE != null ) {
			throw new IllegalArgumentException( "Não é possivel haver duas instancias da classe: br.com.pinedu.datasource.PineduConnectionSource" )
		}
		PineduConnectionSource.INSTANCE = pineduConnectionSource
	}
	PineduConnectionSource( ConnectionSource<T, S> defaultConnectionSource, ConnectionSourceFactory<T, S> connectionSourceFactory, PropertyResolver configuration ) {
		super( defaultConnectionSource, connectionSourceFactory, configuration )

		PineduConnectionSource.setInstance( this )
		this.connectionSourceMap.put( ConnectionSource.DEFAULT, defaultConnectionSource )

		for( String name : getConnectionSourceNames( connectionSourceFactory, configuration ) ) {
			if( name.equals( "dataSource" ) ) continue // data source is reserved name for the default
			ConnectionSource<T, S> connectionSource = connectionSourceFactory.create( name, configuration, defaultConnectionSource.getSettings( ) )
			if( connectionSource != null ) {
				this.connectionSourceMap.put( name, connectionSource )
			}
		}
	}
	@Override
	Iterable<ConnectionSource<T, S>> getAllConnectionSources( ) {
		return Collections.unmodifiableCollection( this.connectionSourceMap.values( ) )
	}
	@Override
	ConnectionSource<T, S> getConnectionSource( String name ) {
		return this.connectionSourceMap.get( name )
	}
	/*
	PropertyResolver é da implementação:
	PropertySourcesConfig
	Tem construtora que cria a partir de Map
	 */
	@Override
	ConnectionSource<T, S> addConnectionSource( String name, PropertyResolver configuration ) {
		//
		if( name == null ) {
			throw new IllegalArgumentException( "Argument [name] cannot be null" )
		}
		if( configuration == null ) {
			throw new IllegalArgumentException( "Argument [configuration] cannot be null" )
		}
		if( 'dataSource'.equals( name ) ) {
			throw new IllegalArgumentException( "Não é possível adicionar um Tenant com o nome: 'dataSource'" )
		}
		if( 'default'.equalsIgnoreCase( name ) ) {
			throw new IllegalArgumentException( "Não é possível adicionar um Tenant com o nome: 'default'" )
		}
		if ( this.connectionSourceMap.containsKey( name ) ) {
			throw new IllegalArgumentException( "Já existe um Tenant com este nome: '${name}'" )
		}
		ConnectionSource<T, S> connectionSource = connectionSourceFactory.createRuntime( name, configuration, ( S )this.defaultConnectionSource.getSettings( ) )
		if( connectionSource == null ) {
			throw new IllegalStateException( "ConnectionSource factory returned null" )
		}
		this.connectionSourceMap.put( name, connectionSource )

		for( listener in listeners ) {
			listener.newConnectionSource( connectionSource )
		}
		return connectionSource
	}
}
