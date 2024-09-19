package br.com.pinedu

import br.com.pinedu.tenant.PineduTenantThreadLocalContext
import groovy.transform.CompileStatic
import grails.gorm.transactions.Transactional
import static grails.gorm.multitenancy.Tenants.*

@Transactional
@CompileStatic
class PineduTenantService {
    void inTenant(String tenantId, Closure callAble) {
        withId(tenantId) {
            try {
                callAble.call()
            } catch (Exception e) {
                throw e
            }
        }
    }
}