package br.com.pinedu

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TesteSpec extends Specification implements DomainUnitTest<Teste> {

     void "test domain constraints"() {
        when:
        Teste domain = new Teste()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
