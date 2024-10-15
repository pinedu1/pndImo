import java.nio.file.*

class ConfigReloadService {

    def grailsApplication

    /**
     * Método para monitorar e recarregar o arquivo de configuração em tempo de execução
     */
    void monitorConfigFile() {
        Path configPath = Paths.get("/path/to/external-config.properties")
        FileSystem fs = configPath.getFileSystem()
        WatchService watchService = fs.newWatchService()

        configPath.parent.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY)

        Thread.start {
            while (true) {
                WatchKey key = watchService.take()
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.context().toString() == configPath.fileName.toString()) {
                        log.info("Arquivo de configuração alterado, recarregando...")
                        reloadExternalConfig()
                    }
                }
                key.reset()
            }
        }
    }

    /**
     * Método para recarregar o arquivo de configuração
     */
    def reloadExternalConfig() {
        def configFilePath = "/path/to/external-config.properties"
        File configFile = new File(configFilePath)
        if (configFile.exists()) {
            Properties externalConfig = new Properties()
            configFile.withInputStream { stream ->
                externalConfig.load(stream)
            }
            externalConfig.each { key, value ->
                grailsApplication.config[key] = value
            }
            log.info("Configurações externas recarregadas com sucesso.")
        } else {
            log.warn("Arquivo de configuração externo não encontrado: $configFilePath")
        }
    }
}


import org.springframework.jdbc.datasource.DriverManagerDataSource

def reloadDataSource(newDatabaseConfig) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource()
    dataSource.setDriverClassName(newDatabaseConfig.driverClassName)
    dataSource.setUrl(newDatabaseConfig.url)
    dataSource.setUsername(newDatabaseConfig.username)
    dataSource.setPassword(newDatabaseConfig.password)

    // Aqui, você pode reconfigurar o Hibernate ou outros componentes relacionados ao banco de dados
    grailsApplication.mainContext.beanFactory.registerSingleton('dataSource', dataSource)
    
    log.info("Novo DataSource registrado com sucesso.")
}

