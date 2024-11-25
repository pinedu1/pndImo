package br.com.pinedu

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class TesteControllerSpec extends Specification implements ControllerUnitTest<TesteController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
