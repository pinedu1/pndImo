import grails.core.GrailsApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import br.com.pinedu.datasource.PineduDataSourceConnectionSourcesMultiTenantFactoryBean

@Configuration
class ApplicationConfig {
	GrailsApplication grailsApplication
	Environment environment
	// O construtor pode ser usado para injetar GrailsApplication e Environment
	ApplicationConfig(GrailsApplication grailsApplication, Environment environment) {
		this.grailsApplication = grailsApplication
		this.environment = environment
	}

}
