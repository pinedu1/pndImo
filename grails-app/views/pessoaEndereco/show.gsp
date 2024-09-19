
<%@ page import="br.com.pinedu.PessoaEndereco" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pessoaEndereco.label', default: 'PessoaEndereco')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pessoaEndereco" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pessoaEndereco" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pessoaEndereco">
			
				<g:if test="${pessoaEnderecoInstance?.uf}">
				<li class="fieldcontain">
					<span id="uf-label" class="property-label"><g:message code="pessoaEndereco.uf.label" default="Uf" /></span>
					
						<span class="property-value" aria-labelledby="uf-label"><g:fieldValue bean="${pessoaEnderecoInstance}" field="uf"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pessoaEnderecoInstance?.cidade}">
				<li class="fieldcontain">
					<span id="cidade-label" class="property-label"><g:message code="pessoaEndereco.cidade.label" default="Cidade" /></span>
					
						<span class="property-value" aria-labelledby="cidade-label"><g:fieldValue bean="${pessoaEnderecoInstance}" field="cidade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pessoaEnderecoInstance?.bairro}">
				<li class="fieldcontain">
					<span id="bairro-label" class="property-label"><g:message code="pessoaEndereco.bairro.label" default="Bairro" /></span>
					
						<span class="property-value" aria-labelledby="bairro-label"><g:fieldValue bean="${pessoaEnderecoInstance}" field="bairro"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pessoaEnderecoInstance?.logradouro}">
				<li class="fieldcontain">
					<span id="logradouro-label" class="property-label"><g:message code="pessoaEndereco.logradouro.label" default="Logradouro" /></span>
					
						<span class="property-value" aria-labelledby="logradouro-label"><g:fieldValue bean="${pessoaEnderecoInstance}" field="logradouro"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pessoaEnderecoInstance?.numero}">
				<li class="fieldcontain">
					<span id="numero-label" class="property-label"><g:message code="pessoaEndereco.numero.label" default="Numero" /></span>
					
						<span class="property-value" aria-labelledby="numero-label"><g:fieldValue bean="${pessoaEnderecoInstance}" field="numero"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pessoaEnderecoInstance?.complemento}">
				<li class="fieldcontain">
					<span id="complemento-label" class="property-label"><g:message code="pessoaEndereco.complemento.label" default="Complemento" /></span>
					
						<span class="property-value" aria-labelledby="complemento-label"><g:fieldValue bean="${pessoaEnderecoInstance}" field="complemento"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pessoaEnderecoInstance?.cep}">
				<li class="fieldcontain">
					<span id="cep-label" class="property-label"><g:message code="pessoaEndereco.cep.label" default="Cep" /></span>
					
						<span class="property-value" aria-labelledby="cep-label"><g:fieldValue bean="${pessoaEnderecoInstance}" field="cep"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pessoaEnderecoInstance?.pessoa}">
				<li class="fieldcontain">
					<span id="pessoa-label" class="property-label"><g:message code="pessoaEndereco.pessoa.label" default="Pessoa" /></span>
					
						<span class="property-value" aria-labelledby="pessoa-label"><g:link controller="pessoa" action="show" id="${pessoaEnderecoInstance?.pessoa?.id}">${pessoaEnderecoInstance?.pessoa?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:pessoaEnderecoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${pessoaEnderecoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
