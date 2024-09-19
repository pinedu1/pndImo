package br.com.pinedu



import static org.springframework.http.HttpStatus.*
import grails.gorm.transactions.Transactional

@Transactional(readOnly = true)
class PessoaEnderecoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PessoaEndereco.list(params), model:[pessoaEnderecoInstanceCount: PessoaEndereco.count()]
    }

    def show(PessoaEndereco pessoaEnderecoInstance) {
        respond pessoaEnderecoInstance
    }

    def create() {
        respond new PessoaEndereco(params)
    }

    @Transactional
    def save(PessoaEndereco pessoaEnderecoInstance) {
        if (pessoaEnderecoInstance == null) {
            notFound()
            return
        }

        if (pessoaEnderecoInstance.hasErrors()) {
            respond pessoaEnderecoInstance.errors, view:'create'
            return
        }

        pessoaEnderecoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pessoaEndereco.label', default: 'PessoaEndereco'), pessoaEnderecoInstance.id])
                redirect pessoaEnderecoInstance
            }
            '*' { respond pessoaEnderecoInstance, [status: CREATED] }
        }
    }

    def edit(PessoaEndereco pessoaEnderecoInstance) {
        respond pessoaEnderecoInstance
    }

    @Transactional
    def update(PessoaEndereco pessoaEnderecoInstance) {
        if (pessoaEnderecoInstance == null) {
            notFound()
            return
        }

        if (pessoaEnderecoInstance.hasErrors()) {
            respond pessoaEnderecoInstance.errors, view:'edit'
            return
        }

        pessoaEnderecoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PessoaEndereco.label', default: 'PessoaEndereco'), pessoaEnderecoInstance.id])
                redirect pessoaEnderecoInstance
            }
            '*'{ respond pessoaEnderecoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PessoaEndereco pessoaEnderecoInstance) {

        if (pessoaEnderecoInstance == null) {
            notFound()
            return
        }

        pessoaEnderecoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PessoaEndereco.label', default: 'PessoaEndereco'), pessoaEnderecoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoaEndereco.label', default: 'PessoaEndereco'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
