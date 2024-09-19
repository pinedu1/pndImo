package br.com.pinedu

import grails.converters.JSON
import grails.gorm.multitenancy.CurrentTenant

import static org.springframework.http.HttpStatus.*
import grails.gorm.transactions.Transactional

@CurrentTenant
@Transactional(readOnly = true)
class PessoaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pessoa.list(params), model:[pessoaInstanceCount: Pessoa.count()]
    }

    def show(Pessoa pessoaInstance) {
        respond pessoaInstance, model: [enderecos: PessoaEndereco.from( pessoaInstance ), telefones: PessoaTelefone.from( pessoaInstance )]
    }

    def create() {
        respond new Pessoa(params)
    }

    def edit(Pessoa pessoaInstance) {
        respond pessoaInstance
    }
    @Transactional
    def save(Pessoa pessoaInstance) {
        if (pessoaInstance == null) {
            notFound()
            return
        }
        if (pessoaInstance.hasErrors()) {
            respond pessoaInstance.errors, view:'create'
            return
        }

        pessoaInstance.save(flush:true, failOnError: true)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), pessoaInstance.id])
                redirect pessoaInstance
            }
            '*' { respond pessoaInstance, [status: CREATED] }
        }
    }
    @Transactional
    def update(Pessoa pessoaInstance) {
        if (pessoaInstance == null) {
            notFound()
            return
        }

        if (pessoaInstance.hasErrors()) {
            respond pessoaInstance.errors, view:'edit'
            return
        }

        pessoaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pessoa.label', default: 'Pessoa'), pessoaInstance.id])
                redirect pessoaInstance
            }
            '*'{ respond pessoaInstance, [status: OK] }
        }
    }
    @Transactional
    def delete(Pessoa pessoaInstance) {

        if (pessoaInstance == null) {
            notFound()
            return
        }

        pessoaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pessoa.label', default: 'Pessoa'), pessoaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
