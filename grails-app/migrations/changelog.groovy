databaseChangeLog = {
    /*
    * SETUP inicial STORAGES PROCEDURES
    * */
    include file: 'changelog_storage_procedure.groovy'
    /*
    * SETUP inicial das tabelas e seus índices. Este CHANGELOG, inicia as tabelas
    * */
    include file: 'changelog_inicial_setup.groovy'
    /*
    * Inicia as tabelas vazias, com dados
    * Muito útil para Tabelas primárias de configuração
    * */
    include file: 'changelog_inicializa_dados.groovy'
    /*
    * Somente Indexa
    * */
    include file: 'changelog_inicializa_index.groovy'
    /*
    * Somente Constraints de FK
    * */
    include file: 'changelog_inicializa_FK.groovy'
    /*
    * Views
    * */
    include file: 'changelog_inicializa_views.groovy'
    /*
    * Teste para implementação
    * */
    include file: 'changelog_teste.groovy'
}
