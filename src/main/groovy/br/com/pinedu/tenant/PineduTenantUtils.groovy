package br.com.pinedu.tenant

import grails.core.GrailsApplication

class PineduTenantUtils {
	GrailsApplication grailsApplication
	final Closure getCurrentTenant = {
		return PineduTenantThreadLocalContext.get()
	}
	Map<String, List<String>> getAllArtefacts() {
		Map<String, List<String>> artefatos = new TreeMap<String, List<Class>>()
		["Domain", "Controller", "Service"].each{
			String artefactType = it.toLowerCase()
			if ( !artefatos.containsKey(artefactType) ) {
				artefatos.put(artefactType, new LinkedList<String>())
			}
			artefatos.get(artefactType) << getAllArtefacts(it)
		}
		return artefatos
	}
	List<Class> getAllArtefacts(String artefactType) {
		def artefacts = grailsApplication.getArtefacts(artefactType) // Por exemplo: "Domain", "Controller", etc.
		return artefacts.collect { it.clazz }
	}
	// Exemplo para listar todos os Domain classes
	List<Class> getAllDomainClasses() {
		return getAllArtefacts("Domain")
	}
	// Exemplo para listar todos os Controllers
	List<Class> getAllControllerClasses() {
		return getAllArtefacts("Controller")
	}
	List<Class> getAllServiceClasses() {
		return getAllArtefacts("Service")
	}
	void iterateTenants(Closure callAble) {
		getRegisteredTenants().each { tenantId->
			executeInTenant(tenantId)
		}
	}
	List<String> getRegisteredTenants() {
		return grailsApplication.config.dataSources.keySet().sort().toList()
	}
}
