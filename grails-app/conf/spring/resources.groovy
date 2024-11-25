import br.com.pinedu.datasource.PineduDataSourceConnectionSourcesMultiTenantFactoryBean
import br.com.pinedu.tenant.PineduTenantFilter
import br.com.pinedu.tenant.PineduTenantResolver
import br.com.pinedu.tenant.PineduTenantThreadLocalContext
import br.com.pinedu.tenant.PineduTenantUtils
import org.springframework.boot.web.servlet.FilterRegistrationBean

beans = {
	//applicationConfig(ApplicationConfig)
	//clienteTenantListener(ClienteTenantListener)
	//pineduCarregaProperties(PineduCarregaProperties)
	pineduTenantResolver(PineduTenantResolver) {
		//grailsApplication = ref('grailsApplication')
	}
	pineduTenantUtils(PineduTenantUtils)
	pineduTenantThreadLocalContext(PineduTenantThreadLocalContext)

	pineduDataSourceConnectionSourcesMultiTenantFactoryBean(PineduDataSourceConnectionSourcesMultiTenantFactoryBean) {
		this.configuration = ref('environment')
		this.applicationContext = ref('applicationContext')
	}
	// Configura o filtro para ser registrado como um DelegatingFilterProxy

	pineduTenantFilter(PineduTenantFilter)
	filterRegistrationBean(FilterRegistrationBean) {
		filter = ref('pineduTenantFilter')
		urlPatterns = ['/*']
	}

}
