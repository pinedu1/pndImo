package br.com.pinedu.cfg

import br.com.pinedu.ClienteTenant
import br.com.pinedu.ClienteTenantPropriedades
import br.com.pinedu.tenant.PineduTenantThreadLocalContext
import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import org.springframework.context.ApplicationContext

@CompileStatic
class PineduConfigTenantService {
    private static final DBCREATE_MODE = 'none'
    GrailsApplication grailsApplication
    PineduTenantThreadLocalContext pineduTenantThreadLocalContext
    ApplicationContext applicationContext

    @CompileDynamic
    private String getConfigPath() {
        return grailsApplication.config.info?.app?.config?.locations
    }
    @CompileDynamic
    private String getContextPath() {
        return grailsApplication.config.info?.app?.context?.locations
    }
    @CompileDynamic
    private String getConfigFileName() {
        return grailsApplication.config.info?.app?.config?.configFileName
    }
    @CompileDynamic
    private String getApplicationName() {
        return grailsApplication.config.info.app.name
    }
    @CompileDynamic
    public Boolean isMultiTenancy() {
        String mode = grailsApplication.getConfig().getProperty("grails.gorm.multiTenancy.mode", String.class);

        return !( mode == null || ''.equals( mode) )
    }
    @CompileDynamic
    public void inicializaThreadContext() {
        pineduTenantThreadLocalContext.init("${configPath}/${configFileName}")
    }

    /*
    * Exporta todos os bancos de dados Cadastrados em:
    * Client-Tenant, para aquivo de properties.
    * Este arquivo será criado no boot da aplicação
    * e recarregado ao adicionar novos clientes
    */
    public void atualizaConfigTenants() {
        String configPath=getConfigPath()
        if ( ''.equals( configPath ) ) {
            throw new Exception( 'PINEDU_001: Diretiva do caminho de configuração do Sistema não encontrada!' )
        }
        def file = new File("${configPath}/${configFileName}")
        def dir = file.parentFile
        if (!dir.exists()) {
            dir.mkdirs() // Cria os diretórios necessários
        }
        if (file.exists()) file.delete()
        def formattedContent = new StringBuilder()
        Set<String> propertiesMaster = ['serverBaseUrl', 'posicaoLogo', 'documentRoot', 'pathMedia', 'maximoSimultaneos']

        formattedContent.append("# Configurações da Aplicação\n")
        formattedContent.append("server.servlet.context-path=/app\n")
        formattedContent.append("grails.gorm.reactor.events=false\n")
        formattedContent.append("hibernate.multiTenancy=DATABASE\n")
        formattedContent.append("hibernate.multiTenancy.tenantResolverClass=br.com.pinedu.tenant.PineduTenantResolver\n")
        formattedContent.append("grails.gorm.connectionSourcesClass=br.com.pinedu.datasource.PineduConnectionSource\n")  // Veja https://gorm.grails.org/latest/hibernate/manual/index.html#multiTenancy
        formattedContent.append("grails.gorm.multiTenancy.mode=DATABASE\n")
        formattedContent.append("grails.gorm.multiTenancy.tenantResolverClass=br.com.pinedu.tenant.PineduTenantResolver\n")
        formattedContent.append("grails.plugin.databasemigration.updateAllOnStart=true\n")
        formattedContent.append("grails.plugin.databasemigration.updateOnStartFileName=changelog.groovy\n")
        formattedContent.append("grails.plugin.databasemigration.changelogFileName=changelog.groovy\n")
        formattedContent.append("# DataBases\n\n")
        ClienteTenant.list().each{ClienteTenant clienteTenantInstance->
            String ctx = clienteTenantInstance.contexto.toUpperCase()
            formattedContent.append("# Cliente: ${clienteTenantInstance.nome}\n")
            Properties properties = new Properties()
            properties.setProperty("${ctx}.contexto", clienteTenantInstance.contexto)
            properties.setProperty("${ctx}.nome", clienteTenantInstance.nome)
            properties.setProperty("${ctx}.telefone", clienteTenantInstance.telefone)
            properties.setProperty("${ctx}.email", clienteTenantInstance.email)
            properties.setProperty("${ctx}.ativo", "${Boolean.TRUE.equals(clienteTenantInstance.ativo)}")
            properties.setProperty("${ctx}.promocao", "${Boolean.TRUE.equals(clienteTenantInstance.promocao)}")

            ClienteTenantPropriedades.mapFromClienteTenant(clienteTenantInstance).each{item->
                if ( propertiesMaster.contains(item.key as String) ) {
                    properties.setProperty("${ctx}.${item.key}", "${item.value}")
                } else {
                    properties.setProperty("dataSources.${ctx}.${item.key}", "${item.value}")
                }
            }
            properties.keySet().toList().sort().each { key ->
                formattedContent.append("${key}=${properties.getProperty(key as String)}\n")
            }
            formattedContent.append('#\n')
        }
        file.withWriter('UTF-8') { writer ->
            writer.write(formattedContent.toString())
        }
    }
    @Transactional
    void inclueDummyTenants() {
        ["joao", "pedro", "antonio", "jose", "felipe", "alberto"].each {
            ClienteTenant clienteTenantInstance = new ClienteTenant(nome: it, contexto: it, cpf: "14026400808", ativo: true, sistema: false, telefone: "11994662171", email: "${it}@local.net", password: "senhasenhasenha")
            clienteTenantInstance.save(flush: true, failOnError: true)
            inclueDummyTenantContext(clienteTenantInstance)
        }
    }
    @Transactional
    void inclueDummyTenantContext(ClienteTenant clienteTenantInstance) {
        String domainPosName = 'local.net'
        String contexto = clienteTenantInstance.contexto
        Map app = [
                contexto: contexto
                , serverBaseUrl: "http://${contexto}.${domainPosName}"
                , posicaoLogo: "inferior-direito"
                , documentRoot: "${contextPath}/${contexto}/public_html"
                , pathMedia: "${contextPath}/${contexto}/media"
                , maximoSimultaneos: 5
        ]
        Map dataBase = [
                url: "jdbc:postgresql://localhost:5432/${contexto}?ApplicationName=${applicationName}_DB:${contexto}"
                , username: contexto
                , password: "${contexto}-\$P\$R%ccG!xo9%JFwet"
                , dbCreate: DBCREATE_MODE
                //, driverClassName: 'org.postgresql.Driver'
                //, dialect: 'org.hibernate.dialect.PostgreSQL95Dialect'
                //, pooled: true
                //, jmxExport: true
                //, dialect: 'org.hibernate.dialect.PostgreSQL12Dialect'
                //, logSql: false
                //, formatSql: true
                //, 'properties.jmxEnabled': true
                //, 'properties.initialSize': 1
                //, 'properties.maxActive': 5
                //, 'properties.minIdle': 2
                //, 'properties.maxIdle': 4
                //, 'properties.maxWait': 10000
                //, 'properties.maxAge': 10 * 60000
                //, 'properties.timeBetweenEvictionRunsMillis': 5000
                //, 'properties.minEvictableIdleTimeMillis': 60000
                //, 'properties.numTestsPerEvictionRun': 3
                //, 'properties.validationQuery': 'SELECT 1;'
                //, 'properties.validationQueryTimeout': 3
                //, 'properties.validationInterval': 15000
                //, 'properties.testOnBorrow': true
                //, 'properties.testWhileIdle': true
                //, 'properties.testOnReturn': false
                //, 'properties.jdbcInterceptor': 'ConnectionState;StatementCache(max=50)'
                //, 'properties.defaultTransactionIsolation': 'java.sql.Connection.TRANSACTION_READ_COMMITTED'
        ]
        app.each {key, value->
            ClienteTenantPropriedades clienteTenantPropriedadesInstance = new ClienteTenantPropriedades(chave: key, valor: value, cliente: clienteTenantInstance)
            if ( clienteTenantInstance.propriedades == null ) {
                clienteTenantInstance.propriedades = new HashSet<ClienteTenantPropriedades>()
            }
            clienteTenantInstance.propriedades.add( clienteTenantPropriedadesInstance )
            clienteTenantPropriedadesInstance.save()
        }
        dataBase.each {key, value->
            ClienteTenantPropriedades clienteTenantPropriedadesInstance = new ClienteTenantPropriedades(chave: key, valor: value, cliente: clienteTenantInstance)
            if ( clienteTenantInstance.propriedades == null ) {
                clienteTenantInstance.propriedades = new HashSet<ClienteTenantPropriedades>()
            }
            clienteTenantInstance.propriedades.add( clienteTenantPropriedadesInstance )
            clienteTenantPropriedadesInstance.save()
        }
        clienteTenantInstance.save(failOnError: true, flush: true)
    }
}