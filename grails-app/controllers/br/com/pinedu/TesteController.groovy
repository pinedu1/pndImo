package br.com.pinedu

import grails.converters.JSON
import grails.gorm.multitenancy.CurrentTenant

@CurrentTenant
class TesteController {

    def index() {
        Map resp = [sucess: true, teste: Teste.get(1)]
        render resp as JSON
    }
}