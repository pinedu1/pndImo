<%@ page import="br.com.pinedu.PessoaTelefone" %>



<div class="fieldcontain ${hasErrors(bean: pessoaTelefoneInstance, field: 'telefone', 'error')} required">
	<label for="telefone">
		<g:message code="pessoaTelefone.telefone.label" default="Telefone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefone" maxlength="20" required="" value="${pessoaTelefoneInstance?.telefone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaTelefoneInstance, field: 'observacoes', 'error')} ">
	<label for="observacoes">
		<g:message code="pessoaTelefone.observacoes.label" default="Observacoes" />
		
	</label>
	<g:textField name="observacoes" value="${pessoaTelefoneInstance?.observacoes}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaTelefoneInstance, field: 'pessoa', 'error')} required">
	<label for="pessoa">
		<g:message code="pessoaTelefone.pessoa.label" default="Pessoa" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pessoa" name="pessoa.id" from="${br.com.pinedu.Pessoa.list()}" optionKey="id" required="" value="${pessoaTelefoneInstance?.pessoa?.id}" class="many-to-one"/>

</div>

