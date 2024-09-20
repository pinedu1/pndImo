databaseChangeLog = {
	changeSet(author: "eduardo", id: "INIT_GPB_UF") {
		grailsChange {
			change {
				sql.execute("COPY estado FROM '/pinedu/modelo/estado.csv' with csv header;")
			}
			rollback {
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_GPB_TIP_LOG") {
		grailsChange {
			change {
				sql.execute("COPY tipo_logradouro FROM '/pinedu/modelo/tipo_logradouro.csv' with csv header;")
			}
			rollback {
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_GPB_CID") {
		grailsChange {
			change {
				sql.execute("COPY cidade FROM '/pinedu/modelo/cidade.csv' with csv header;")
			}
			rollback {
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_GPB_BAI") {
		grailsChange {
			change {
				sql.execute("COPY bairro FROM '/pinedu/modelo/bairro.csv' with csv header;")
			}
			rollback {
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_GPB_LOG") {
		grailsChange {
			change {
				sql.execute("COPY logradouro FROM '/pinedu/modelo/logradouro.csv' with csv header;")
			}
			rollback {
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_GPB_SEQUENCES") {
		grailsChange {
			change {
				sql.execute("""
					SELECT
						setval('seq_bairro', (SELECT COUNT(id) FROM bairro))
						, setval('seq_cidade', (SELECT COUNT(id) FROM cidade))
						, setval('seq_estado', (SELECT COUNT(id) FROM estado))
						, setval('seq_tipo_logradouro', (SELECT COUNT(id) FROM tipo_logradouro))
						, setval('seq_logradouro', (SELECT COUNT(id) FROM logradouro));
				""")
			}
			rollback {
			}
		}
	}
}