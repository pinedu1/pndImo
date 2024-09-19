package br.com.pinedu

import grails.gorm.MultiTenant
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@EqualsAndHashCode(includes=['id'])
@ToString(includes=['id'], includeNames=true, includePackage=false)
class PessoaTelefone implements Serializable, MultiTenant<PessoaTelefone> {
    static final long serialVersionUID = 1
    String telefone
    String observacoes
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    Pessoa pessoa
    static belongsTo = [ pessoa: Pessoa ]

    static constraints = {
        telefone	(blank: false, size: 7..20)
        observacoes (nullable: true)
    }
    static mapping = {
        table 'pessoa_telefone'
        observacoes		type: 'text'
    }
    static List<PessoaTelefone> from(Pessoa pessoaInstance) {
        return PessoaTelefone.findAllByPessoa(pessoaInstance)
    }

}