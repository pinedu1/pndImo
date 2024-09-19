<!DOCTYPE html>
<%@ page import="br.com.pinedu.Pessoa" %>
<html>
<head>
	<meta name="layout" content="main"/>
	<g:set var="entityName" value="${message(code: 'pessoa.label', default: 'Pessoa')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-pessoa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
	</ul>
</div>
<div id="list-pessoa" class="content scaffold-list" role="main">
	<h1><g:message code="default.list.label" args="[entityName]" /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<table>
		<thead>
		<tr>

			<g:sortableColumn property="nome" title="${message(code: 'pessoa.nome.label', default: 'Nome')}" />
			<g:sortableColumn property="nomeNormalizado" title="${message(code: 'pessoa.nomeNormalizado.label', default: 'Nome Normalizado')}" />
			<g:sortableColumn property="nascimento" title="${message(code: 'pessoa.nascimento.label', default: 'Nascimento')}" />
			<g:sortableColumn property="sexo" title="${message(code: 'pessoa.sexo.label', default: 'Sexo')}" />
			<g:sortableColumn property="tipoPessoa" title="${message(code: 'pessoa.tipoPessoa.label', default: 'Tipo Pessoa')}" />
			<g:sortableColumn property="estadoCivil" title="${message(code: 'pessoa.estadoCivil.label', default: 'Estado Civil')}" />

		</tr>
		</thead>
		<tbody>
		<g:each in="${pessoaList}" status="i" var="pessoaInstance">
			<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
				<td><g:link action="show" id="${pessoaInstance.id}">${fieldValue(bean: pessoaInstance, field: "nome")}</g:link></td>
				<td>${fieldValue(bean: pessoaInstance, field: "nomeNormalizado")}</td>
				<td><g:formatDate date="${pessoaInstance.nascimento}" format="dd/MM/yyyy"  /></td>
				<td>${fieldValue(bean: pessoaInstance, field: "sexo")}</td>
				<td>${fieldValue(bean: pessoaInstance, field: "tipoPessoa")}</td>
				<td>${fieldValue(bean: pessoaInstance, field: "estadoCivil")}</td>
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<g:paginate total="${pessoaInstanceCount ?: 0}" />
	</div>
</div>
</body>
</html>
