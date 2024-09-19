databaseChangeLog = {
	changeSet(author: "eduardo (generated)", id: "CRIA_TABELA_EMAIL") {
		createTable(tableName: "EMAIL") {
			column(name: "ID", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "EMAIL_PK")
			}
			column(name: "ASSUNTO", type: "VARCHAR(2048)") {
				constraints(nullable: "false")
			}
			column(name: "CANAL", type: "VARCHAR(32)") {
				constraints(nullable: "false")
			}
			column(name: "CONFIG", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "CONTEUDO_HTML", type: "LONGTEXT")
			column(name: "CONTEUDO_TEXTO", type: "LONGTEXT")
			column(name: "DATA_ENVIO", type: "TIMESTAMP")
			column(name: "DATE_CREATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}
			column(name: "LAST_UPDATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}
			column(name: "PASSWORD", type: "VARCHAR(255)")
			column(name: "PORT", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "REMETENTE", type: "VARCHAR(255)")
			column(name: "EMAIL_REMETENTE", type: "VARCHAR(255)")
			column(name: "PRIORIDADE", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "RESULTADO_ENVIO", type: "LONGTEXT")
			column(name: "SERVER", type: "VARCHAR(255)")
			column(name: "USE_SSL", type: "BOOLEAN")
			column(name: "START_SSL", type: "BOOLEAN")
			column(name: "START_TLS", type: "BOOLEAN")
			column(name: "STATUS_ENVIO", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "TENTATIVA_ENVIO", type: "INT")
			column(name: "USERNAME", type: "VARCHAR(255)")
		}
	}
	changeSet(author: "eduardo (generated)", id: "CRIA_TABELA_EMAIL_ANEXO") {
		createTable(tableName: "EMAIL_ANEXO") {
			column(name: "ID", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "EMAIL_ANEXO_PK")
			}
			column(name: "BINARIO", type: "LONGBLOB")
			column(name: "EMAIL_ID", type: "VARCHAR(32)") {
				constraints(nullable: "false")
			}
			column(name: "MIME_TYPE", type: "VARCHAR(255)")
			column(name: "NOME", type: "VARCHAR(255)")
			column(name: "TIPO_ANEXO", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "URL", type: "VARCHAR(512)")
		}
	}
	changeSet(author: "eduardo (generated)", id: "CRIA_TABELA_EMAIL_DESTINATARIO") {
		createTable(tableName: "EMAIL_DESTINATARIO") {
			column(name: "ID", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "EMAIL_DESTINATARIO_PK")
			}
			column(name: "EMAIL_ID", type: "VARCHAR(32)") {
				constraints(nullable: "false")
			}
			column(name: "ENDERECO", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "NOME", type: "VARCHAR(255)")
		}
	}
	changeSet(author: "eduardo (generated)", id: "CRIA_TABELA_EMAIL_POOL") {
		createTable(tableName: "EMAIL_POOL") {
			column(name: "ID", type: "INT8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "EMAIL_POOL_PK")
			}
			column(name: "DATE_CREATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}
			column(name: "LAST_UPDATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}
			column(name: "LOCKED", type: "BOOLEAN")
		}
	}
	changeSet(author: "eduardo (generated)", id: "20140530-1") {
		createIndex(indexName: "IDXEMAILCANAL", tableName: "EMAIL", unique: "false") {
			column(name: "CANAL")
		}
	}
	changeSet(author: "eduardo (generated)", id: "20140530-2") {
		createIndex(indexName: "IDXEMAILCFG", tableName: "EMAIL", unique: "false") {
			column(name: "CONFIG")
		}
	}
	changeSet(author: "eduardo (generated)", id: "20140530-3") {
		createIndex(indexName: "IDXEMAILSTT", tableName: "EMAIL", unique: "false") {
			column(name: "STATUS_ENVIO")
		}
	}
	changeSet(author: "eduardo (generated)", id: "20140530-4") {
		createIndex(indexName: "IDXEMAILTENT", tableName: "EMAIL", unique: "false") {
			column(name: "TENTATIVA_ENVIO")
		}
	}
	changeSet(author: "eduardo (generated)", id: "20140530-5") {
		createIndex(indexName: "IDXEMAILANXTIPO", tableName: "EMAIL_ANEXO", unique: "false") {
			column(name: "TIPO_ANEXO")
		}
	}
	changeSet(author: "eduardo (generated)", id: "20140530-7") {
		addForeignKeyConstraint(baseColumnNames: "EMAIL_ID", baseTableName: "EMAIL_ANEXO", constraintName: "FK_EMAIL_ANEXO_TO_EMAIL", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "EMAIL", referencesUniqueColumn: "false")
	}
	changeSet(author: "eduardo (generated)", id: "20140530-8") {
		addForeignKeyConstraint(baseColumnNames: "EMAIL_ID", baseTableName: "EMAIL_DESTINATARIO", constraintName: "FK_EMAIL_DESTINATARIO_TO_EMAIL", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "EMAIL", referencesUniqueColumn: "false")
	}
	changeSet(author: "eduardo", id: "20141103-1") {
		addColumn(tableName: "EMAIL") {
			column(name: "AGENDADO_PARA", type: "TIMESTAMP")
		}
	}
	changeSet(author: "eduardo", id: "20141103-3") {
		createIndex(indexName: "IDXEMAILAGENPARA", tableName: "EMAIL", unique: "false") {
			column(name: "AGENDADO_PARA")
		}
	}
	changeSet(author: "eduardo", id: "20141103-4") {
		grailsChange {
			change {
				sql.executeUpdate "UPDATE EMAIL SET DATA_ENVIO = LAST_UPDATED WHERE DATA_ENVIO IS NULL AND STATUS_ENVIO <> 'A';"
			}
		}
	}
	changeSet(author: "eduardo", id: "20141211-1") {
		modifyDataType(columnName: "CANAL", newDataType: "VARCHAR(50)", tableName: "EMAIL")
	}
	changeSet(author: "eduardo", id: "20150105-1") {
		createIndex(indexName: "IDXDATAENVIO", tableName: "EMAIL", unique: "false") {
			column(name: "DATA_ENVIO")
		}
	}
	changeSet(author: "eduardo", id: "20150105-2") {
		createIndex(indexName: "IDXPRIORIDADE", tableName: "EMAIL", unique: "false") {
			column(name: "PRIORIDADE")
		}
	}
	changeSet(author: "eduardo", id: "20150105-3") {
		createIndex(indexName: "IDXREMETENTE", tableName: "EMAIL", unique: "false") {
			column(name: "REMETENTE")
		}
	}
	changeSet(author: "eduardo", id: "20150105-4") {
		createIndex(indexName: "IDXEMAILREMETENTE", tableName: "EMAIL", unique: "false") {
			column(name: "EMAIL_REMETENTE")
		}
	}
	changeSet(author: "eduardo", id: "20150105-5") {
		grailsChange {
			change {
				sql.executeUpdate "CREATE INDEX IDXPRIODTENV ON EMAIL (STATUS_ENVIO, DATA_ENVIO);"
			}
		}
	}
	changeSet(author: "eduardo (generated)", id: "CRIA_EMAIL_COPIA_OCULTA") {
		addColumn(tableName: "EMAIL") {
			column(name: "COPIA_OCULTA", type: "BOOLEAN")
		}
	}
	changeSet(author: "eduardo", id: "CRIA_EMAIL_RESPOSTA") {
		addColumn(tableName: "EMAIL") {
			column(name: "RESPOSTA_PARA", type: "VARCHAR(255)")
		}
		addColumn(tableName: "EMAIL") {
			column(name: "CONFIRMAR_LEITURA", type: "BOOLEAN")
		}
	}
}
