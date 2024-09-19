
<%@ page import="br.com.pinedu.Pessoa" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pessoa.label', default: 'Pessoa')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pessoa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pessoa" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pessoa">
			
				<g:if test="${pessoa?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="pessoa.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${pessoa}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pessoa?.nomeNormalizado}">
				<li class="fieldcontain">
					<span id="nomeNormalizado-label" class="property-label"><g:message code="pessoa.nomeNormalizado.label" default="Nome Normalizado" /></span>

						<span class="property-value" aria-labelledby="nomeNormalizado-label"><g:fieldValue bean="${pessoa}" field="nomeNormalizado"/></span>

				</li>
				</g:if>

				<g:if test="${pessoa?.nascimento}">
				<li class="fieldcontain">
					<span id="nascimento-label" class="property-label"><g:message code="pessoa.nascimento.label" default="Nascimento" /></span>

						<span class="property-value" aria-labelledby="nascimento-label"><g:formatDate date="${pessoa?.nascimento}" /></span>

				</li>
				</g:if>

				<g:if test="${pessoa?.sexo}">
				<li class="fieldcontain">
					<span id="sexo-label" class="property-label"><g:message code="pessoa.sexo.label" default="Sexo" /></span>

						<span class="property-value" aria-labelledby="sexo-label"><g:fieldValue bean="${pessoa}" field="sexo"/></span>

				</li>
				</g:if>

				<g:if test="${pessoa?.tipoPessoa}">
				<li class="fieldcontain">
					<span id="tipoPessoa-label" class="property-label"><g:message code="pessoa.tipoPessoa.label" default="Tipo Pessoa" /></span>

						<span class="property-value" aria-labelledby="tipoPessoa-label"><g:fieldValue bean="${pessoa}" field="tipoPessoa"/></span>

				</li>
				</g:if>

				<g:if test="${pessoa?.estadoCivil}">
				<li class="fieldcontain">
					<span id="estadoCivil-label" class="property-label"><g:message code="pessoa.estadoCivil.label" default="Estado Civil" /></span>

						<span class="property-value" aria-labelledby="estadoCivil-label"><g:fieldValue bean="${pessoa}" field="estadoCivil"/></span>

				</li>
				</g:if>

				<g:if test="${pessoa?.rg}">
				<li class="fieldcontain">
					<span id="rg-label" class="property-label"><g:message code="pessoa.rg.label" default="Rg" /></span>

						<span class="property-value" aria-labelledby="rg-label"><g:fieldValue bean="${pessoa}" field="rg"/></span>

				</li>
				</g:if>

				<g:if test="${pessoa?.cpf}">
				<li class="fieldcontain">
					<span id="cpf-label" class="property-label"><g:message code="pessoa.cpf.label" default="Cpf" /></span>

						<span class="property-value" aria-labelledby="cpf-label"><g:fieldValue bean="${pessoa}" field="cpf"/></span>

				</li>
				</g:if>

				<g:if test="${enderecos}">
				<li class="fieldcontain">
					<span id="enderecos-label" class="property-label"><g:message code="pessoa.enderecos.label" default="Enderecos" /></span>

						<g:each in="${enderecos}" var="e">
						<span class="property-value" aria-labelledby="enderecos-label"><g:link controller="pessoaEndereco" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

				<g:if test="${telefones}">
				<li class="fieldcontain">
					<span id="telefones-label" class="property-label"><g:message code="pessoa.telefones.label" default="Telefones" /></span>
						<g:each in="${telefones}" var="t">
						<span class="property-value" aria-labelledby="telefones-label"><g:link controller="pessoaTelefone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>

				</li>
				</g:if>

			</ol>
			<g:form url="[resource:pessoaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${pessoa}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
