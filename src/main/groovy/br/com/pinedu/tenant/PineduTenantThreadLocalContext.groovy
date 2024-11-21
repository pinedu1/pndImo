package br.com.pinedu.tenant

import grails.core.GrailsApplication
import groovy.transform.CompileStatic

import java.util.concurrent.ConcurrentHashMap

@CompileStatic
class PineduTenantThreadLocalContext {
	private static final ConcurrentHashMap<String, Map<String, Object>> MAPA_CONTEXTO = new ConcurrentHashMap()
	static final ThreadLocal<String> CONTEXT = new ThreadLocal<>()
	GrailsApplication grailsApplication

	static void set(String name) {
		if ( 'DEFAULT'.equals( name ) ) {
			CONTEXT.set(name)
			return
		}
		if ( (! PineduTenantThreadLocalContext.MAPA_CONTEXTO.containsKey( name ) ) ) {
			println PineduTenantThreadLocalContext.MAPA_CONTEXTO.keySet()
			throw new Exception("Contexto ${name}, não definido, verifique!!!")
		}
		if ( "".equals( name )) {
			throw new Exception("Não é possivel definir um contexto VAZIO. Use contexto DEFAULT no lugar")
		}
		CONTEXT.set(name)
	}
	static String get() {
		if ( "".equals( CONTEXT.get() ) ) {
			throw new Exception("Contexto não pode ser vazio!!! Defina-o primeiro com set(name), ou use contexto DEFAULT no lugar.")
		}
		return CONTEXT.get()
	}
	static void clear() {
		CONTEXT.remove()
	}
	static String getProperty(String name) {
		if ( "".equals( CONTEXT.get() ) ) {
			throw new Exception("Contexto não pode ser vazio!!! Defina-o primeiro com set(name), ou use contexto DEFAULT no lugar.")
		}
		if ( 'DEFAULT'.equals( CONTEXT.get() ) ) {
			return null
		}
		if ( ! MAPA_CONTEXTO.containsKey( CONTEXT.get() ) ) {
			throw new Exception("Contexto ${name}, não definido, verifique!!!")
		}
		Map m = MAPA_CONTEXTO.get( CONTEXT.get() )
		return MAPA_CONTEXTO.get( name )
	}
	static synchronized Map<String, Object> getEntries() {
		if ( "".equals( CONTEXT.get() ) ) {
			throw new Exception("Contexto não pode ser nulo!!! Defina-o primeiro com set(name)")
		}
		if ( ! MAPA_CONTEXTO.containsKey( CONTEXT.get() ) ) {
			throw new Exception("Contexto ${CONTEXT.get()}, não possui com propriedades, verifique!!!")
		}
		return MAPA_CONTEXTO.get( CONTEXT.get() )
	}
	static synchronized Set<String> getContextNames() {
		return MAPA_CONTEXTO.keySet()
	}
	static synchronized void addEntry(String nome, Map<String, Object> info) {
		MAPA_CONTEXTO.put(nome, info)
	}
	static void init(String configFile) {
		Set<String> entradasExcluidas = ['hibernate','server','dataSources','grails']
		try {
			if (configFile) {
				Properties properties = new Properties()
				FileInputStream file = new FileInputStream( configFile )
				properties.load(file);
				file.close()
				properties.removeAll {entry ->
					def keys = "${entry.key}".split(/\./)
					return entradasExcluidas.contains( keys[0] )
				}

				properties.each{key, value->
					LinkedList<String> deque = new LinkedList( "${key}".tokenize('.') )
					String ctx = deque.removeFirst()
					if ( !MAPA_CONTEXTO.containsKey( ctx ) ) {
						MAPA_CONTEXTO.put( ctx, new TreeMap<String, Object>() )
					}
					MAPA_CONTEXTO.get( ctx ).put( deque.join('.') , value )
				}
			}
		} catch (Exception ex) {
			println ex.printStackTrace()
		}
	}
}
