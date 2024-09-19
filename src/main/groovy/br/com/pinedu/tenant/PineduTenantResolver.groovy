package br.com.pinedu.tenant

import groovy.transform.CompileStatic
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletWebRequest
import org.hibernate.context.spi.CurrentTenantIdentifierResolver
import javax.servlet.http.HttpServletRequest
@CompileStatic
class PineduTenantResolver implements TenantResolver, CurrentTenantIdentifierResolver {
	/*
	O nome do servidor será chave para o TENANT
	Por exemplo, no servidor cada cliente terá seu nome de domínio definido como:

	joao.pinedu.srv.br
	antonio.pinedu.srv.br
	samanta.pinedu.srv.br

	O resultado será:

	*JOAO*.pinedu.srv.br

	Nota: o sufixo do domínio poderá variar: Ex: local.net, imowps.com...
	*/
	static String resolveTenantIdFromNameOfServer(HttpServletRequest httpServletRequest) {
		String tenantId = ''
		String subdomain = httpServletRequest.getRequestURL().toString()
		String requestURI = httpServletRequest.getRequestURI()
		if ( requestURI ) {
			requestURI = requestURI.toLowerCase()
		}
		def i = requestURI.length()
		if(i > 0) {
			subdomain = subdomain.substring( 0, subdomain.length() -i )
		}
		subdomain = subdomain.substring(subdomain.indexOf("/") + 2);
		if( subdomain.indexOf(".") > -1 ) {
			tenantId = subdomain.substring(0, subdomain.indexOf("."))
		}
		println tenantId.toUpperCase()
		return tenantId.toUpperCase()
	}
	/*
	O APACHE HTTPD será configurado com VirtualHosts
	Cada VirtualHost deve força a configuração de variavel do HEADER:

	<LocationMatch "/app" >
		Header add X-Tenant-ID JOAO
		RequestHeader set X-Tenant-ID JOAO
	</LocationMatch>

	*/
	static String resolveTenantIdFromHeaderDirective(HttpServletRequest httpServletRequest) {
		String tenantId = ''
		// Tenta pelo HEADER
		String contexto = httpServletRequest.getHeader("X-Tenant-ID");
		if ( contexto ) {
			tenantId = contexto.toUpperCase()
		}
		return tenantId
	}
	/*
	Será enviado parametro no request: X-CONTEXTO
	Ex: ?nome-lala&apelido=bb&idade=19&X-CONTEXTO=JOAO
	*/
	static String resolveTenantIdFromHeaderParameter(HttpServletRequest httpServletRequest) {
		String tenantId = ''
		// Tenta pelos paramentros
		Map<String, String[]> parameterMap = httpServletRequest.getParameterMap()
		if (  parameterMap.containsKey('X-CONTEXTO' ) ) {
			String contexto = parameterMap.get( 'X-CONTEXTO' )?.first()
			if ( contexto ) {
				tenantId = contexto.toUpperCase()
			}
		}
		return tenantId
	}

	static String resolveTenantId(HttpServletRequest request) {
		return resolveTenantIdFromHeaderDirective(request) ?:
				resolveTenantIdFromNameOfServer(request) ?:
						resolveTenantIdFromHeaderParameter(request)
	}

	@Override
	Serializable resolveTenantIdentifier() throws TenantNotFoundException {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes()
		String tenantId = ''
		if ( requestAttributes instanceof ServletWebRequest ) {
			HttpServletRequest httpServletRequest = ((ServletWebRequest) requestAttributes).getRequest()
			tenantId = PineduTenantResolver.resolveTenantId( httpServletRequest )
			if ( tenantId == null || tenantId.isEmpty() ) {
				throw new TenantNotFoundException("*** Tenant *** Não foi encontrado !!!")
			}
			/*
			Encontrado ou pelo menos resolvido o TENANT_ID
			Atribui ao ThreadLocal
			Este ThreadLocal armazena as propriedades relativas aos TENANTS configurados, como
			   nome, pathMedia, domainRootPath, numero de usuários...
			*/
			PineduTenantThreadLocalContext.set( tenantId )
		}
		/*
		A Lógica implementada, deve ser	deve ser atribuído antes para o CONTEXTO

		Se quiser chamar o dataSource PADRAO:
			set('DEFAULT')

		Se quiser chamar qq outro cliente:
			set('JOAO')
		*/
		return PineduTenantThreadLocalContext.get()
	}
/**
 * Resolve the current tenant identifier.
 *
 * @return The current tenant identifier
 */

	@Override
	String resolveCurrentTenantIdentifier() {
		return resolveTenantIdentifier()
	}

	/**
	 * Should we validate that the tenant identifier on "current sessions" that already exist when
	 * {@link CurrentSessionContext#currentSession()} is called matches the value returned here from
	 * {@link #resolveCurrentTenantIdentifier()}?
	 *
	 * @return {@code true} indicates that the extra validation will be performed; {@code false} indicates it will not.
	 *
	 * @see org.hibernate.context.TenantIdentifierMismatchException
	 */
	@Override
	boolean validateExistingCurrentSessions() {
		return true
	}
}
