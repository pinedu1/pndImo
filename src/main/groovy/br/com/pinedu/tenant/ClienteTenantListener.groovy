package br.com.pinedu.tenant

import br.com.pinedu.ClienteTenant
import br.com.pinedu.ClienteTenantPropriedades
import grails.converters.JSON
import grails.events.annotation.gorm.Listener
import groovy.util.logging.Slf4j
import org.grails.datastore.mapping.engine.event.PostInsertEvent
import org.grails.datastore.mapping.engine.event.PostUpdateEvent
import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.beans.factory.annotation.Autowired

@Slf4j
class ClienteTenantListener {
	@Autowired
	HibernateDatastore hibernateDatastore

	@Listener(ClienteTenant) // <1>
	void onClienteTenantPostInsertEvent(PostInsertEvent event) { // <2>
		println "#" * 80
		println "onClienteTenantPostInsertEvent(PostInsertEvent event)"
		println "#" * 80
/*
		String id = event.getEntityAccess().getPropertyValue("id")
		Map mapaProperties = ClienteTenantPropriedades.mapFromClienteTenantId( id )
		println mapaProperties as JSON
		DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(contexto, mapaProperties)
		hibernateDatastore.getConnectionSources().addConnectionSource(databaseConfiguration.dataSourceName, databaseConfiguration.configuration) // <4>
*/
	}
	@Listener(ClienteTenant) // <1>
	void onClienteTenantPostUpdateEvent(PostUpdateEvent event) { // <2>
		println "#" * 80
		println "onClienteTenantPostUpdateEvent(PostUpdateEvent event)"
		String id = event.getEntityAccess().getPropertyValue("id")
		String contexto = event.getEntityAccess().getPropertyValue("contexto")
		Map mapaProperties = ClienteTenantPropriedades.mapFromClienteTenantId( id )
		DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(contexto, mapaProperties)
		hibernateDatastore.getConnectionSources().addConnectionSource(databaseConfiguration.dataSourceName, databaseConfiguration.configuration) // <4>
		println "#" * 80
	}
}
