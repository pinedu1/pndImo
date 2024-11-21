databaseChangeLog = {
	changeSet(author: "eduardo", id: "TESTE") {
		createTable(tableName: "teste") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "testePK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_TESTE") {
		grailsChange {
			change {
				//println sql ==> org.grails.plugins.databasemigration.liquibase.GroovyChange
				sql.execute("INSERT INTO teste( id, version, nome ) VALUES (?, ?, ?);", [1, 0, sql.dataSourceName.replaceAll('dataSource_', '')])
			}
		}
	}
}
