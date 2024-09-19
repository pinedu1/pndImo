<%@ page import="br.com.pinedu.PessoaEndereco" %>



<div class="fieldcontain ${hasErrors(bean: pessoaEnderecoInstance, field: 'uf', 'error')} required">
	<label for="uf">
		<g:message code="pessoaEndereco.uf.label" default="Uf" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="uf" maxlength="2" required="" value="${pessoaEnderecoInstance?.uf}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaEnderecoInstance, field: 'cidade', 'error')} required">
	<label for="cidade">
		<g:message code="pessoaEndereco.cidade.label" default="Cidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cidade" maxlength="60" required="" value="${pessoaEnderecoInstance?.cidade}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaEnderecoInstance, field: 'bairro', 'error')} required">
	<label for="bairro">
		<g:message code="pessoaEndereco.bairro.label" default="Bairro" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="bairro" maxlength="60" required="" value="${pessoaEnderecoInstance?.bairro}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaEnderecoInstance, field: 'logradouro', 'error')} required">
	<label for="logradouro">
		<g:message code="pessoaEndereco.logradouro.label" default="Logradouro" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="logradouro" maxlength="60" required="" value="${pessoaEnderecoInstance?.logradouro}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaEnderecoInstance, field: 'numero', 'error')} required">
	<label for="numero">
		<g:message code="pessoaEndereco.numero.label" default="Numero" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="numero" maxlength="20" required="" value="${pessoaEnderecoInstance?.numero}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaEnderecoInstance, field: 'complemento', 'error')} ">
	<label for="complemento">
		<g:message code="pessoaEndereco.complemento.label" default="Complemento" />
		
	</label>
	<g:textField name="complemento" maxlength="40" value="${pessoaEnderecoInstance?.complemento}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaEnderecoInstance, field: 'cep', 'error')} required">
	<label for="cep">
		<g:message code="pessoaEndereco.cep.label" default="Cep" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cep" maxlength="8" required="" value="${pessoaEnderecoInstance?.cep}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaEnderecoInstance, field: 'pessoa', 'error')} required">
	<label for="pessoa">
		<g:message code="pessoaEndereco.pessoa.label" default="Pessoa" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pessoa" name="pessoa.id" from="${br.com.pinedu.Pessoa.list()}" optionKey="id" required="" value="${pessoaEnderecoInstance?.pessoa?.id}" class="many-to-one"/>

</div>

