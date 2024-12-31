package br.com.pinedu

import br.com.pinedu.cfg.PineduConfigTenantService
import br.com.pinedu.cfg.Tenant
import br.com.pinedu.tenant.PineduTenantThreadLocalContext
import grails.converters.JSON
import java.text.SimpleDateFormat

class BootStrap {
    private static final Boolean DEBUG = Boolean.TRUE
    PineduConfigTenantService pineduConfigTenantService
    PineduTenantService pineduTenantService
    def init = { servletContext ->
        //return
        if ( pineduConfigTenantService.isMultiTenancy() ) {
            inicializaMultiTenant()
            if ( Boolean.TRUE.equals(DEBUG) ) {
                testaMultiTenant()
            }
        }
    }
    def destroy = {
    }
    private void inicializaMultiTenant() {
/*
        !!!  Esta função inclui no database PND, varios TENANTS, para teste
        !!! Não Executar
*/
        if ( false && Boolean.TRUE.equals(DEBUG) && Tenant.count() <= 0 ) {
            pineduConfigTenantService.inclueDummyTenants()
        }
        /*
        * Esta função no START do APP
        * Recolhe todos os TENANTS do SGBD:PND
        * E grava o arquivo:
        * /pinedu/config/appImo.properties
        *
        * Não está sendo executada ainda
        * Porque não estou gravando os Tenants no SGBD
        */
        if (false) {
            pineduConfigTenantService.atualizaConfigTenants()
        }

        /**
         * Esta função
         */
        pineduConfigTenantService.inicializaThreadContext()
    }
    private void testaMultiTenant() {
        println PineduTenantThreadLocalContext.getContextNames().sort() as JSON
        println "{"
        PineduTenantThreadLocalContext.getContextNames().sort().eachWithIndex{ String tenantId, i->
            PineduTenantThreadLocalContext.set( tenantId )
            print "${i>0?',':''}${PineduTenantThreadLocalContext.get()}:"
            println PineduTenantThreadLocalContext.getEntries() as JSON
        }
        println "}"

/*
        Closure salvaPessoa = { Map dados ->
            Pessoa.withTransaction { status ->
                try {
                    new Pessoa( dados ).save(failOnError: true, flush: true)
                } catch (Exception e) {
                    if (status != null && status.isRollbackOnly()) {
                        status.setRollbackOnly()
                    }
                    throw e
                }
            }
        }
        */
/*
        !!! Atenção !!!
        O curry, aplica os parametros a closure, criando uma segunda closure, com os paramentros fixados
        *//*

        pineduTenantService.inTenant( 'ALBERTO', salvaPessoa.curry( [ nome: 'ALBERTO MENDES', nascimento: new SimpleDateFormat("dd/MM/yyyy").parse('12/03/1975'), sexo: 'M', tipoPessoa: 'F', estadoCivil: 'CASADO', cpf: '12345678901', rg: '12.345.678-9' ] ) )
        pineduTenantService.inTenant( 'ANTONIO', salvaPessoa.curry( [ nome: 'ANTONIO PEREIRA', nascimento: new SimpleDateFormat("dd/MM/yyyy").parse('23/07/1380'), sexo: 'M', tipoPessoa: 'F', estadoCivil: 'SOLTEIRO', cpf: '23456789012', rg: '23.456.789-0' ] ) )
        pineduTenantService.inTenant( 'FELIPE', salvaPessoa.curry( [ nome: 'FELIPE SOARES', nascimento: new SimpleDateFormat("dd/MM/yyyy").parse('15/05/1385'), sexo: 'M', tipoPessoa: 'F', estadoCivil: 'CASADO', cpf: '34567890123', rg: '34.567.890-1' ] ) )
        pineduTenantService.inTenant( 'JOAO', salvaPessoa.curry( [ nome: 'JOAO NUNES', nascimento: new SimpleDateFormat("dd/MM/yyyy").parse('09/12/1379'), sexo: 'M', tipoPessoa: 'F', estadoCivil: 'SOLTEIRO', cpf: '45678901234', rg: '45.678.901-2' ] ) )
        pineduTenantService.inTenant( 'JOSE', salvaPessoa.curry( [ nome: 'JOSE FERNANDES', nascimento: new SimpleDateFormat("dd/MM/yyyy").parse('30/08/1372'), sexo: 'M', tipoPessoa: 'F', estadoCivil: 'CASADO', cpf: '56789012345', rg: '56.789.012-3' ] ) )
        pineduTenantService.inTenant( 'PEDRO', salvaPessoa.curry( [ nome: 'PEDRO VAZ', nascimento: new SimpleDateFormat("dd/MM/yyyy").parse('17/11/1377'), sexo: 'M', tipoPessoa: 'F', estadoCivil: 'CASADO', cpf: '67890123456', rg: '67.890.123-4' ] ) )
*/
    }
}
