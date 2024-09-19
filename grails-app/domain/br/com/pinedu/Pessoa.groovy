package br.com.pinedu

import grails.gorm.MultiTenant
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includes=['id'])
@ToString(includes=['id'], includeNames=true, includePackage=false)
class Pessoa implements Serializable, MultiTenant<Pessoa> {
    static final long serialVersionUID = 1
    String nome
    String nomeNormalizado
    Date nascimento
    String sexo
    String tipoPessoa
    String estadoCivil
    String cpf
    String rg
    static transients = ['mapaSexo', 'mapaTipoPessoa', 'mapaEstadoCivil']
    final static Map mapaTipoPessoa = ['F': 'Física', 'J': 'Jurídica']
    final static Map mapaSexo = ['M': 'Masculino', 'F': 'Feminino']
    final static Map mapaEstadoCivil = ['SOLTEIRO': 'Solteiro', 'CASADO': 'Casado', 'DESQUITADO': 'Desquitado', 'DIVORCIADO': 'Divorciado', 'VIUVO': 'Viúvo', 'OUTROS': 'Outros', 'SEPARADO_JUDICIALMENTE': 'Separado Judicialmente']
    static hasMany = [telefones: PessoaTelefone, enderecos: PessoaEndereco]
    static constraints = {
        nome (nullable: false, blank: false, size: 1..75)
        nomeNormalizado(nullable: true, blank: true, size: 1..75)
        nascimento(nullable: true, blank: true)
        sexo(blank: false, length: 1, inList: mapaSexo*.key)
        tipoPessoa(blank: false, length: 1, inList: mapaTipoPessoa*.key)
        estadoCivil(nullable: true, blank: false, size: 1..25, inList: mapaEstadoCivil*.key)
        rg(nullable: true, blank: true, size: 1..20)
        cpf(nullable: true, blank: true)
    }
    def beforeInsert() {
        nomeNormalizado = java.text.Normalizer.normalize( nome, java.text.Normalizer.Form.NFD )?.replaceAll( "[^\\p{ASCII}]", "" )?.replaceAll( /[^A-Za-z0-9]/, ' ' )?.replaceAll( /\s+/, ' ' )?.toUpperCase( );
    }
    def beforeUpdate() {
        nomeNormalizado = java.text.Normalizer.normalize( nome, java.text.Normalizer.Form.NFD )?.replaceAll( "[^\\p{ASCII}]", "" )?.replaceAll( /[^A-Za-z0-9]/, ' ' )?.replaceAll( /\s+/, ' ' )?.toUpperCase( );
    }
    static mapping = {
        table: 'pessoa'
    }
}