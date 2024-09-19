
<%@ page import="br.com.pinedu.PessoaEndereco" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pessoaEndereco.label', default: 'PessoaEndereco')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pessoaEndereco" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pessoaEndereco" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="uf" title="${message(code: 'pessoaEndereco.uf.label', default: 'Uf')}" />
					
						<g:sortableColumn property="cidade" title="${message(code: 'pessoaEndereco.cidade.label', default: 'Cidade')}" />
					
						<g:sortableColumn property="bairro" title="${message(code: 'pessoaEndereco.bairro.label', default: 'Bairro')}" />
					
						<g:sortableColumn property="logradouro" title="${message(code: 'pessoaEndereco.logradouro.label', default: 'Logradouro')}" />
					
						<g:sortableColumn property="numero" title="${message(code: 'pessoaEndereco.numero.label', default: 'Numero')}" />
					
						<g:sortableColumn property="complemento" title="${message(code: 'pessoaEndereco.complemento.label', default: 'Complemento')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pessoaEnderecoInstanceList}" status="i" var="pessoaEnderecoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pessoaEnderecoInstance.id}">${fieldValue(bean: pessoaEnderecoInstance, field: "uf")}</g:link></td>
					
						<td>${fieldValue(bean: pessoaEnderecoInstance, field: "cidade")}</td>
					
						<td>${fieldValue(bean: pessoaEnderecoInstance, field: "bairro")}</td>
					
						<td>${fieldValue(bean: pessoaEnderecoInstance, field: "logradouro")}</td>
					
						<td>${fieldValue(bean: pessoaEnderecoInstance, field: "numero")}</td>
					
						<td>${fieldValue(bean: pessoaEnderecoInstance, field: "complemento")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pessoaEnderecoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
