package br.com.pinedu

import grails.gorm.MultiTenant
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes=['id'])
@ToString(includes=['id'], includeNames=true, includePackage=false)
class Teste implements MultiTenant<Teste> {
    String nome
    static constraints = {
    }
    static mapping = {
        table 'teste'
    }
}