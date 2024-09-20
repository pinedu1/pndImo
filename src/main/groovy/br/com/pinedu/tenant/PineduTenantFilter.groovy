package br.com.pinedu.tenant

import groovy.transform.CompileStatic
import org.springframework.web.context.request.ServletWebRequest
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

@CompileStatic
class PineduTenantFilter implements Filter {
	@Override
	void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig)
	}
	@Override
	void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		String tenantId = PineduTenantResolver.resolveTenantId( (HttpServletRequest) servletRequest )
		if ( ( ''.equals( tenantId ) || tenantId == null ) && 'localhost'.equals(servletRequest.getServerName() ) ) {
			tenantId = 'DEFAULT'
		}
		if (tenantId) {
			// Definir o locatário no contexto atual (usando um ThreadLocal ou outro mecanismo)
			PineduTenantThreadLocalContext.set(tenantId)
		} else {
			// Lidar com situações onde o locatário não é resolvido, por exemplo, redirecionar ou lançar exceção
			throw new IllegalStateException("Não foi possível identificar o tenant para o domínio: ${servletRequest.getServerName()}")
		}
		try {
			// Continuar com a requisição
			filterChain.doFilter(servletRequest, servletResponse)
		} finally {
			// Limpar o contexto do locatário após a requisição para evitar problemas em requisições subsequentes
			PineduTenantThreadLocalContext.clear()
		}
	}
	@Override
	void destroy() {
		super.destroy()
	}
}
