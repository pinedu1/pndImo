package br.com.pinedu



import static org.springframework.http.HttpStatus.*
import grails.gorm.transactions.Transactional

@Transactional(readOnly = true)
class PessoaTelefoneController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PessoaTelefone.list(params), model:[pessoaTelefoneInstanceCount: PessoaTelefone.count()]
    }

    def show(PessoaTelefone pessoaTelefoneInstance) {
        respond pessoaTelefoneInstance
    }

    def create() {
        respond new PessoaTelefone(params)
    }

    @Transactional
    def save(PessoaTelefone pessoaTelefoneInstance) {
        if (pessoaTelefoneInstance == null) {
            notFound()
            return
        }

        if (pessoaTelefoneInstance.hasErrors()) {
            respond pessoaTelefoneInstance.errors, view:'create'
            return
        }

        pessoaTelefoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pessoaTelefone.label', default: 'PessoaTelefone'), pessoaTelefoneInstance.id])
                redirect pessoaTelefoneInstance
            }
            '*' { respond pessoaTelefoneInstance, [status: CREATED] }
        }
    }

    def edit(PessoaTelefone pessoaTelefoneInstance) {
        respond pessoaTelefoneInstance
    }

    @Transactional
    def update(PessoaTelefone pessoaTelefoneInstance) {
        if (pessoaTelefoneInstance == null) {
            notFound()
            return
        }

        if (pessoaTelefoneInstance.hasErrors()) {
            respond pessoaTelefoneInstance.errors, view:'edit'
            return
        }

        pessoaTelefoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PessoaTelefone.label', default: 'PessoaTelefone'), pessoaTelefoneInstance.id])
                redirect pessoaTelefoneInstance
            }
            '*'{ respond pessoaTelefoneInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PessoaTelefone pessoaTelefoneInstance) {

        if (pessoaTelefoneInstance == null) {
            notFound()
            return
        }

        pessoaTelefoneInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PessoaTelefone.label', default: 'PessoaTelefone'), pessoaTelefoneInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoaTelefone.label', default: 'PessoaTelefone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
