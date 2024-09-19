package br.com.pinedu

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes=['id'])
@ToString(includes=['id'], includeNames=true, includePackage=false)
class ClienteTenant implements Serializable {
    String id
    String nome
    String nomeNormalizado
    String contexto
    String cpf
    Date dateCreated
    Date lastUpdated
    Boolean ativo
    Boolean sistema
    String telefone
    String email
    String password
    Boolean promocao
    static hasMany = [ propriedades: ClienteTenantPropriedades ]
    static constraints = {
        nome (nullable: false, blank: false, size: 1..70)
        nomeNormalizado (nullable: false, blank: false, size: 1..70)
        contexto (unique:true, nullable: false, blank: false, size: 1..25)
        cpf(nullable: true, blank: true, size:9..14)
        dateCreated (nullable: true)
        lastUpdated (nullable: true)
        ativo (nullable: true)
        sistema (nullable: true)
        promocao (nullable: true)
        telefone (nullable: false, blank: false, size: 1..15)
        email (nullable: false, blank: false, email: true, size: 1..80)
        password (nullable: false, blank: false, size: 1..80)
    }
    public void setNome(String nome) {
        this.nome = nome
        this.nomeNormalizado = java.text.Normalizer.normalize( nome, java.text.Normalizer.Form.NFD )?.replaceAll( "[^\\p{ASCII}]", "" )?.replaceAll( /[^A-Za-z0-9]/, ' ' )?.replaceAll( /\s+/, ' ' )?.toUpperCase( );
    }
    def beforeInsert() {
        nomeNormalizado = java.text.Normalizer.normalize( nome, java.text.Normalizer.Form.NFD )?.replaceAll( "[^\\p{ASCII}]", "" )?.replaceAll( /[^A-Za-z0-9]/, ' ' )?.replaceAll( /\s+/, ' ' )?.toUpperCase( );
    }
    def beforeUpdate() {
        nomeNormalizado = java.text.Normalizer.normalize( nome, java.text.Normalizer.Form.NFD )?.replaceAll( "[^\\p{ASCII}]", "" )?.replaceAll( /[^A-Za-z0-9]/, ' ' )?.replaceAll( /\s+/, ' ' )?.toUpperCase( );
    }
    static mapping = {
        table 'cliente_tenant'
        id generator: 'uuid', sqlType: 'VARCHAR(32)'
        contexto index: 'idxCliTenCtx'
    }

}