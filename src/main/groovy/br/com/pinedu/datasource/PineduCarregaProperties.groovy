package br.com.pinedu.datasource

import groovy.transform.CompileDynamic
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.io.FileSystemResource;


@Configuration
class PineduCarregaProperties {
	@CompileDynamic
	private String getConfigPath() {
		return grailsApplication.config.info?.app?.config?.locations
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		String configPath=getConfigPath()
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		// Define o caminho para o arquivo .properties externo
		configurer.setLocations(new FileSystemResource("${configPath}/appImo.properties"));
		return configurer;
	}

	@Bean
	public PropertyResolver propertyResolver(PropertySourcesPlaceholderConfigurer configurer) {
		return new PropertySourcesPropertyResolver(configurer.getAppliedPropertySources());
	}
}
