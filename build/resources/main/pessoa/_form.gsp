<%@ page import="br.com.pinedu.Pessoa" %>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="pessoa.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="75" required="" value="${pessoaInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoa, field: 'nascimento', 'error')} ">
	<label for="nascimento">
		<g:message code="pessoa.nascimento.label" default="Nascimento" />

	</label>
	<g:datePicker name="nascimento" precision="day"  value="${pessoa?.nascimento}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: pessoa, field: 'sexo', 'error')} required">
	<label for="sexo">
		<g:message code="pessoa.sexo.label" default="Sexo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sexo" from="${Pessoa.mapaSexo.keySet()}" required="" value="${pessoa?.sexo}" valueMessagePrefix="pessoa.sexo"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoa, field: 'tipoPessoa', 'error')} required">
	<label for="tipoPessoa">
		<g:message code="pessoa.tipoPessoa.label" default="Tipo Pessoa" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoPessoa" from="${Pessoa.mapaTipoPessoa.keySet()}" required="" value="${pessoa?.tipoPessoa}" valueMessagePrefix="pessoa.tipoPessoa"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoa, field: 'estadoCivil', 'error')} ">
	<label for="estadoCivil">
		<g:message code="pessoa.estadoCivil.label" default="Estado Civil" />

	</label>
	<g:select name="estadoCivil" from="${Pessoa.mapaEstadoCivil.keySet()}" value="${pessoa?.estadoCivil}" valueMessagePrefix="pessoa.estadoCivil" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoa, field: 'rg', 'error')} ">
	<label for="rg">
		<g:message code="pessoa.rg.label" default="Rg" />

	</label>
	<g:textField name="rg" maxlength="20" value="${pessoa?.rg}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoa, field: 'cpf', 'error')} ">
	<label for="cpf">
		<g:message code="pessoa.cpf.label" default="Cpf" />

	</label>
	<g:textField name="cpf" value="${pessoa?.cpf}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoa, field: 'enderecos', 'error')} ">
<label for="enderecos">
	<g:message code="pessoa.enderecos.label" default="Enderecos" />

</label>

