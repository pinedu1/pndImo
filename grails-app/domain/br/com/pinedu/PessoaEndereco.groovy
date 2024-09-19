package br.com.pinedu

import grails.gorm.MultiTenant
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@EqualsAndHashCode(includes=['id'])
@ToString(includes=['id'], includeNames=true, includePackage=false)
class PessoaEndereco implements Serializable, MultiTenant<PessoaEndereco> {
    static final long serialVersionUID = 1
    String uf
    String cidade
    String bairro
    String logradouro
    String numero
    String complemento
    String cep
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    Pessoa pessoa
    static belongsTo = [ pessoa: Pessoa ]
    static constraints = {
        uf				(blank: false, size: 1..2)
        cidade			(blank: false, size: 1..60)
        bairro			(blank: false, size: 1..60)
        logradouro		(blank: false, size: 1..60)
        numero			(blank: false, size: 1..20)
        complemento		(nullable: true, blank: true, size: 1..40)
        cep				(blank: false, size: 1..8)
    }
    static mapping = {
        table 'pessoa_endereco'
    }
    static List<PessoaEndereco> from(Pessoa pessoaInstance) {
        return PessoaEndereco.findAllByPessoa(pessoaInstance)
    }
}