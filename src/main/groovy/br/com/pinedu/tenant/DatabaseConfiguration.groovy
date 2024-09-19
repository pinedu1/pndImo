package br.com.pinedu.tenant

import groovy.transform.CompileStatic

@CompileStatic
class DatabaseConfiguration {
    private String dataSourceName
    private Map configuration
    DatabaseConfiguration() {}
    DatabaseConfiguration(String dataSourceName, Map configuration) {
        this.dataSourceName = dataSourceName
        this.configuration = configuration
    }
    public Map getConfiguration() {
        return configuration
    }
    public void setConfiguration(Map configuration) {
        this.configuration = configuration
    }
    public String getDataSourceName() {
        return dataSourceName
    }
    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName
    }
}