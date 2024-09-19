
<%@ page import="br.com.pinedu.PessoaTelefone" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pessoaTelefone.label', default: 'PessoaTelefone')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pessoaTelefone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pessoaTelefone" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="telefone" title="${message(code: 'pessoaTelefone.telefone.label', default: 'Telefone')}" />
					
						<g:sortableColumn property="observacoes" title="${message(code: 'pessoaTelefone.observacoes.label', default: 'Observacoes')}" />
					
						<th><g:message code="pessoaTelefone.pessoa.label" default="Pessoa" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pessoaTelefoneInstanceList}" status="i" var="pessoaTelefoneInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pessoaTelefoneInstance.id}">${fieldValue(bean: pessoaTelefoneInstance, field: "telefone")}</g:link></td>
					
						<td>${fieldValue(bean: pessoaTelefoneInstance, field: "observacoes")}</td>
					
						<td>${fieldValue(bean: pessoaTelefoneInstance, field: "pessoa")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pessoaTelefoneInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
