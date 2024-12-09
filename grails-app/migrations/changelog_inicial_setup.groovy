databaseChangeLog = {
	changeSet(author: "eduardo", id: "INICIAL_SETUP_SEQUENCES") {
		createSequence(incrementBy: "1", sequenceName: "hibernate_sequence", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_agenda", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_anuncio", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_aplicacao", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_bairro", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_bairro_corret", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_banco", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_campanha", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_carteira_imovel", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_cidade", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_cidade_corret", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_classe_imovel", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_classe_interessado", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_concorrente", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_condominio", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_contrato_exclusividade", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_corretor", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_edificio", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_empresa", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_equipe", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_estado", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_evento", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_finalidade_imovel", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_grupo", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_imovel", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_interessado", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_logradouro", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_loja", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_menu", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_midia_tipo", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_moeda", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_pessoa", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_proposta", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_quadro_chaves", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_regiao_corret", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_regra", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_request_map", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_segmento_imovel", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_tipo_dependencia", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_tipo_endereco", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_tipo_imovel", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_tipo_logradouro", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_usuario", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_veiculo_comunicacao", startValue: "1")
		createSequence(incrementBy: "1", sequenceName: "seq_venda", startValue: "1")
	}
	changeSet(author: "eduardo", id: "INICIAL_SETUP_TABLES") {
		createTable(tableName: "acompanhamento") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "acompanhamentoPK")
			}
			column(name: "titulo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "descricao", type: "CLOB")
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "responsavel", type: "VARCHAR(255)")
			column(name: "class", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "interessado_id", type: "BIGINT")
			column(name: "imovel_id", type: "BIGINT")
			column(name: "venda_id", type: "BIGINT")
			column(name: "proposta_id", type: "BIGINT")
		}
		createTable(tableName: "agenda") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "agendaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "oculto", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "grupo_id", type: "BIGINT")
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "cor", type: "INT")
			column(name: "user_id", type: "BIGINT")
			column(name: "corporativa", type: "BOOLEAN")
		}
		createTable(tableName: "anuncio") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "anuncioPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "campanha_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "carteira_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "valor", type: "NUMBER(10, 2)")
			column(name: "medida", type: "VARCHAR(255)")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "loja_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "veiculacao", type: "date") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "anuncio_corretor") {
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "anuncio_corretorPK")
			}
			column(name: "anuncio_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "anuncio_corretorPK")
			}
		}
		createTable(tableName: "anuncio_imovel") {
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "anuncio_imovelPK")
			}
			column(name: "anuncio_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "anuncio_imovelPK")
			}
			column(name: "valor", type: "NUMBER(12, 4)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "aplicacao") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "aplicacaoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "icone", type: "VARCHAR(255)")
			column(name: "descricao", type: "CLOB")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
			column(name: "versao_minor", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "versao_major", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "versao_nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "versao_release", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "arquivo") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "arquivoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "id_mask", type: "VARCHAR(255)")
			column(name: "stream_id", type: "VARCHAR(32)")
			column(name: "mime_type", type: "VARCHAR(255)")
			column(name: "tamanho", type: "BIGINT")
			column(name: "path", type: "VARCHAR(255)")
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "arquivo_binario") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "arquivo_binarioPK")
			}
			column(name: "binario", type: "BYTEA")
			column(name: "base64", type: "TEXT")
		}
		createTable(tableName: "bairro") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "bairroPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "cep2i", type: "VARCHAR(8)")
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "cidade_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "cep2f", type: "VARCHAR(8)")
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "abrvact", type: "VARCHAR(40)")
			column(name: "cep1f", type: "VARCHAR(8)")
			column(name: "cep1i", type: "VARCHAR(8)")
			column(name: "nome_normalizado", type: "VARCHAR(72)")
			column(name: "chavedne", type: "INT")
			column(name: "distrito_id", type: "BIGINT")
		}
		createTable(tableName: "bairro_corretagem") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "bairro_corretagemPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "bairro_id", type: "BIGINT")
			column(name: "sistema", type: "BOOLEAN")
			column(name: "regiao_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(40)") {
				constraints(nullable: "false")
			}
			column(name: "bairrocp", type: "BIGINT")
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "banco") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "bancoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "codigo", type: "VARCHAR(5)")
			column(name: "nome", type: "VARCHAR(70)") {
				constraints(nullable: "false")
			}
			column(name: "pessoa_id", type: "BIGINT")
			column(name: "ativo", type: "BOOLEAN")
			column(name: "site", type: "VARCHAR(70)")
		}
		createTable(tableName: "buffer_cidade") {
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_cidadePK")
			}
			column(name: "status_imovel", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_cidadePK")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_cidadePK")
			}
			column(name: "cidade_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_cidadePK")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "buffer_faixa_valor") {
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_faixa_valorPK")
			}
			column(name: "faixa_valor_id", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_faixa_valorPK")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_faixa_valorPK")
			}
			column(name: "cidade_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_faixa_valorPK")
			}
			column(name: "regiao_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_faixa_valorPK")
			}
			column(name: "status_imovel", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_faixa_valorPK")
			}
			column(name: "valor_inicial", type: "NUMBER(19, 2)") {
				constraints(nullable: "false")
			}
			column(name: "valor_final", type: "NUMBER(19, 2)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "buffer_regiao") {
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_regiaoPK")
			}
			column(name: "status_imovel", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_regiaoPK")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_regiaoPK")
			}
			column(name: "cidade_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_regiaoPK")
			}
			column(name: "regiao_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_regiaoPK")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "buffer_tipo_imovel") {
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_tipo_imovelPK")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_tipo_imovelPK")
			}
			column(name: "status_imovel", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buffer_tipo_imovelPK")
			}
			column(name: "sigla", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "campanha") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "campanhaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "veiculocp", type: "BIGINT")
			column(name: "descricao", type: "CLOB")
			column(name: "custo_total", type: "NUMBER(10, 2)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "inicio", type: "date")
			column(name: "ativo", type: "BOOLEAN")
			column(name: "veiculo_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "fim", type: "date")
			column(name: "exclusiva", type: "BOOLEAN")
			column(name: "perene", type: "BOOLEAN")
		}
		createTable(tableName: "campanha_midia_tipo") {
			column(name: "campanha_midias_associadas_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "midia_tipo_id", type: "BIGINT")
		}
		createTable(tableName: "carteira_imovel") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "carteira_imovelPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "padrao", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "chaves_devolver") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "chaves_devolverPK")
			}
			column(name: "status_imovel", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "chaves_id", type: "VARCHAR(32)") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "cidade") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cidadePK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sigladrect", type: "VARCHAR(255)")
			column(name: "cep2i", type: "VARCHAR(8)")
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "codibge", type: "INT")
			column(name: "cidade_pai_id", type: "BIGINT")
			column(name: "cep2f", type: "VARCHAR(8)")
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "uf_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo", type: "VARCHAR(1)")
			column(name: "abrvact", type: "VARCHAR(25)")
			column(name: "cep", type: "VARCHAR(8)")
			column(name: "cep1f", type: "VARCHAR(8)")
			column(name: "situacao", type: "VARCHAR(1)")
			column(name: "cep1i", type: "VARCHAR(8)")
			column(name: "nome_normalizado", type: "VARCHAR(72)")
			column(name: "chavedne", type: "INT")
		}
		createTable(tableName: "cidade_corretagem") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cidade_corretagemPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "cidade_id", type: "BIGINT")
			column(name: "nome", type: "VARCHAR(40)") {
				constraints(nullable: "false")
			}
			column(name: "uf_id", type: "BIGINT")
			column(name: "cidadecp", type: "BIGINT")
			column(name: "ativo", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "classe_imovel") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "classe_imovelPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "padrao", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "classe_interessado") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "classe_interessadoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "padrao", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "cliente") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "clientePK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "password_expired", type: "BOOLEAN")
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "account_expired", type: "BOOLEAN")
			column(name: "cookie", type: "VARCHAR(32)")
			column(name: "ultimo_login", type: "timestamp")
			column(name: "account_locked", type: "BOOLEAN")
			column(name: "password", type: "VARCHAR(255)")
			column(name: "hash", type: "VARCHAR(32)")
			column(name: "enabled", type: "BOOLEAN")
			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "ultimo_login_ip", type: "VARCHAR(255)")
		}
		createTable(tableName: "cliente_regra") {
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cliente_regraPK")
			}
			column(name: "cliente_id", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cliente_regraPK")
			}
		}
		createTable(tableName: "concorrente") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "concorrentePK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "concorrentecp", type: "BIGINT")
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(72)")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "creci", type: "VARCHAR(20)")
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "condominio") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "condominioPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "sindico_id", type: "BIGINT")
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "administradora_id", type: "BIGINT")
			column(name: "endereco_id", type: "VARCHAR(255)")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "nome_normalizado", type: "VARCHAR(72)")
			column(name: "pessoa_juridica_id", type: "BIGINT")
			column(name: "observacoes", type: "CLOB")
			column(name: "valor_condominio", type: "NUMBER(10, 2)")
		}
		createTable(tableName: "contrato_exclusividade") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "contrato_exclusividadePK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "titulo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "texto", type: "CLOB") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "corretor") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "corretorPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "ativo", type: "BOOLEAN")
			column(name: "categoria", type: "VARCHAR(1)")
			column(name: "corretorcp", type: "BIGINT")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "creci", type: "VARCHAR(20)")
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "edificio") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "edificioPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_imovel_padrao_id", type: "BIGINT")
			column(name: "ano_construcao", type: "INT")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "zelador_id", type: "BIGINT")
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "sindico_id", type: "BIGINT")
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "condominio_id", type: "BIGINT")
			column(name: "endereco_id", type: "VARCHAR(255)")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "nome_normalizado", type: "VARCHAR(72)")
			column(name: "observacoes", type: "CLOB")
			column(name: "valor_condominio", type: "NUMBER(10, 2)")
		}
		createTable(tableName: "edificio_modelo_dependencia") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "edificio_modelo_dependenciaPK")
			}
			column(name: "valor_texto", type: "VARCHAR(255)")
			column(name: "valor_inteiro", type: "INT")
			column(name: "edificio_id", type: "BIGINT")
			column(name: "valor_boolean", type: "BOOLEAN")
			column(name: "valor_float", type: "NUMBER(12, 6)")
			column(name: "tipo_dependencia_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "valor_multiplo", type: "INT")
		}
		createTable(tableName: "email") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "email_backgroundPK")
			}
			column(name: "start_ssl", type: "BOOLEAN")
			column(name: "canal", type: "VARCHAR(33)")
			column(name: "prioridade", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "conteudo_html", type: "CLOB")
			column(name: "tentativa_envio", type: "INT")
			column(name: "port", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "data_envio", type: "timestamp")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "status_envio", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "agendado_para", type: "timestamp")
			column(name: "conteudo_texto", type: "CLOB")
			column(name: "config", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "assunto", type: "CLOB") {
				constraints(nullable: "false")
			}
			column(name: "remetente", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "start_tls", type: "BOOLEAN")
			column(name: "usuario_responsavel_id", type: "BIGINT")
			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "server", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "resultado_envio", type: "CLOB")
			column(name: "ssl", type: "BOOLEAN")
			column(name: "email_remetente", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "email_destinatario") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "email_background_emailPK")
			}
			column(name: "endereco", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(255)")
			column(name: "email_id", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "email_anexo") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "email_background_imagemPK")
			}
			column(name: "imagem_id", type: "VARCHAR(255)")
			column(name: "mime_type", type: "VARCHAR(255)")
			column(name: "descricao", type: "VARCHAR(255)")
			column(name: "url", type: "VARCHAR(512)")
			column(name: "tipo_anexo", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(255)")
			column(name: "binario", type: "BYTEA")
			column(name: "email_id", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "empresa") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "empresaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(72)")
			column(name: "inscr_estadual", type: "VARCHAR(20)")
			column(name: "creci", type: "VARCHAR(20)")
			column(name: "marketing", type: "CLOB")
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "inscr_municipal", type: "VARCHAR(20)")
			column(name: "site", type: "VARCHAR(255)")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "empresa_imagem") {
			column(name: "empresa_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "empresa_imagemPK")
			}
			column(name: "imagem_id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "empresa_imagemPK")
			}
		}
		createTable(tableName: "entradas_diarias") {
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "entradas_diariasPK")
			}
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "entradas_diariasPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "entradas_diariasPK")
			}
		}
		createTable(tableName: "equipe") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "equipePK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sigla", type: "VARCHAR(10)") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}
			column(name: "descricao", type: "CLOB")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "sistema", type: "BOOLEAN")
			column(name: "nome_normalizado", type: "VARCHAR(50)")
			column(name: "ativo", type: "BOOLEAN")
			column(name: "carteira_id", type: "BIGINT")
			column(name: "loja_id", type: "BIGINT")
			column(name: "grupo_id", type: "BIGINT")
		}
		createTable(tableName: "equipe_corretor") {
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "equipe_corretorPK")
			}
			column(name: "equipe_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "equipe_corretorPK")
			}
		}
		createTable(tableName: "equipe_gerente") {
			column(name: "gerente_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "equipe_gerentePK")
			}
			column(name: "equipe_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "equipe_gerentePK")
			}
			column(name: "principal", type: "BOOLEAN")
		}
		createTable(tableName: "estado") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "estadoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "cep2i", type: "VARCHAR(8)")
			column(name: "sistema", type: "BOOLEAN")
			column(name: "abrvact", type: "VARCHAR(20)")
			column(name: "cep1f", type: "VARCHAR(8)")
			column(name: "chavecep", type: "INT")
			column(name: "cep2f", type: "VARCHAR(8)")
			column(name: "nome", type: "VARCHAR(30)") {
				constraints(nullable: "false")
			}
			column(name: "cep1i", type: "VARCHAR(8)")
			column(name: "uf", type: "VARCHAR(2)") {
				constraints(nullable: "false")
			}
			column(name: "chavedne", type: "INT")
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "evento") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "eventoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "imovel_id", type: "BIGINT")
			column(name: "data_final", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "data_inicio", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "dia_todo", type: "BOOLEAN")
			column(name: "job", type: "VARCHAR(255)")
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "descricao", type: "CLOB")
			column(name: "venda_id", type: "BIGINT")
			column(name: "ultimo_lembrete", type: "timestamp")
			column(name: "lembre_me", type: "VARCHAR(255)")
			column(name: "titulo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "agenda_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "local", type: "VARCHAR(255)")
			column(name: "url", type: "VARCHAR(255)")
			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "interessado_id", type: "BIGINT")
			column(name: "novo", type: "BOOLEAN")
			column(name: "proposta_id", type: "BIGINT")
		}
		createTable(tableName: "faixa_valor") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "faixa_valorPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "valor_inicial", type: "NUMBER(14, 2)")
			column(name: "padrao", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "valor_final", type: "NUMBER(14, 2)")
		}
		createTable(tableName: "ficha_comprada_cci_importados") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "ficha_comprada_cci_importadosPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "acodigos", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "responsavel", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "ficha_comprada_cci_ti") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "ficha_comprada_cci_tiPK")
			}
			column(name: "tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "finalidade_imovel") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "finalidade_imovelPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "padrao", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "grupo") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "grupoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(70)") {
				constraints(nullable: "false")
			}
			column(name: "aplicacao_id", type: "BIGINT")
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "grupo_menu") {
			column(name: "menu_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "grupo_menuPK")
			}
			column(name: "grupo_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "grupo_menuPK")
			}
		}
		createTable(tableName: "grupo_regra") {
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "grupo_regraPK")
			}
			column(name: "grupo_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "grupo_regraPK")
			}
		}
		createTable(tableName: "grupo_regra_negado") {
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "grupo_regra_negadoPK")
			}
			column(name: "grupo_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "grupo_regra_negadoPK")
			}
		}
		createTable(tableName: "imovel") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovelPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "status_imovel", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "desocupacao", type: "VARCHAR(20)")
			column(name: "titulo_edificio", type: "VARCHAR(40)")
			column(name: "edificio_id", type: "BIGINT")
			column(name: "matriculaiptu", type: "VARCHAR(30)")
			column(name: "referencia", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "exclusao_id", type: "VARCHAR(32)")
			column(name: "permite_intermediacao", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "horario_visita", type: "VARCHAR(40)")
			column(name: "proprietario_id", type: "VARCHAR(255)")
			column(name: "lancamento", type: "BOOLEAN")
			column(name: "valor_iptu", type: "NUMBER(10, 2)")
			column(name: "endereco_id", type: "VARCHAR(255)")
			column(name: "loja_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "data_captacao", type: "date") {
				constraints(nullable: "false")
			}
			column(name: "permite_placa", type: "BOOLEAN")
			column(name: "avaliacao_id", type: "VARCHAR(255)")
			column(name: "observacoes", type: "CLOB")
			column(name: "matricula_agua", type: "VARCHAR(30)")
			column(name: "finalidade_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ano_construcao", type: "INT")
			column(name: "indicador_id", type: "BIGINT")
			column(name: "exclusividade_id", type: "VARCHAR(255)")
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "enviar_web", type: "BOOLEAN")
			column(name: "memorial_descritivo", type: "CLOB")
			column(name: "saldo_id", type: "VARCHAR(255)")
			column(name: "condominio_id", type: "BIGINT")
			column(name: "segmento_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "chaves_id", type: "VARCHAR(32)")
			column(name: "matricula_gaz", type: "VARCHAR(30)")
			column(name: "placa_id", type: "VARCHAR(255)")
			column(name: "anuncio_renderizado", type: "CLOB")
			column(name: "carteira_id", type: "BIGINT")
			column(name: "tipo_ocupacao", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "permite_unidades", type: "BOOLEAN")
			column(name: "matricula_energia", type: "VARCHAR(30)")
			column(name: "padrao_construcao", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "descricao_chaves", type: "VARCHAR(40)")
			column(name: "anuncio", type: "CLOB")
			column(name: "novo", type: "BOOLEAN")
			column(name: "valor_condominio", type: "NUMBER(10, 2)")
		}
		createTable(tableName: "imovel_avaliacao") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_avaliacaoPK")
			}
			column(name: "valor_avaliacao", type: "NUMBER(10, 2)") {
				constraints(nullable: "false")
			}
			column(name: "data_avaliacao", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "classe_imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "avaliador_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacao", type: "CLOB")
		}
		createTable(tableName: "imovel_captacao") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_captacaoPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "captador_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "principal", type: "BOOLEAN")
			column(name: "percentual", type: "FLOAT8") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_captacao_movimento") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_captacao_movimentoPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "movimento", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "percentual", type: "FLOAT8") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_chamado") {
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_chamadoPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_chamadoPK")
			}
			column(name: "campanha_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_chamadoPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_contrato") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_contratoPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "valor", type: "NUMBER(14, 2)") {
				constraints(nullable: "false")
			}
			column(name: "slug", type: "VARCHAR(255)")
			column(name: "data_atualizacao", type: "date") {
				constraints(nullable: "false")
			}
			column(name: "prox_atualizacao", type: "date") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_dependencia") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_dependenciaPK")
			}
			column(name: "imovel_id", type: "BIGINT")
			column(name: "valor_texto", type: "VARCHAR(255)")
			column(name: "edificio_id", type: "BIGINT")
			column(name: "condominio_id", type: "BIGINT")
			column(name: "foto_id", type: "VARCHAR(255)")
			column(name: "valor_inteiro", type: "INT")
			column(name: "valor_boolean", type: "BOOLEAN")
			column(name: "valor_float", type: "NUMBER(20, 6)")
			column(name: "tipo_dependencia_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "valor_multiplo", type: "INT")
		}
		createTable(tableName: "imovel_endereco") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_enderecoPK")
			}
			column(name: "bairro", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}
			column(name: "cidade", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}
			column(name: "ponto_referencia", type: "CLOB")
			column(name: "estado", type: "VARCHAR(2)") {
				constraints(nullable: "false")
			}
			column(name: "padronizado", type: "BOOLEAN")
			column(name: "tipo_logradouro", type: "VARCHAR(40)")
			column(name: "logradouro", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "numero", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}
			column(name: "latitude", type: "NUMBER(19, 6)")
			column(name: "longitude", type: "NUMBER(19, 6)")
			column(name: "bairro_corretagem_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "cep", type: "VARCHAR(8)")
			column(name: "logradouro_normalizado", type: "VARCHAR(72)")
			column(name: "ultima_verificacao_geocode", type: "timestamp")
			column(name: "bloco", type: "VARCHAR(20)")
			column(name: "complemento", type: "VARCHAR(40)")
			column(name: "logradourodne_id", type: "BIGINT")
			column(name: "observacao", type: "CLOB")
			column(name: "zoneamento", type: "VARCHAR(20)")
			column(name: "apartamento", type: "VARCHAR(20)")
		}
		createTable(tableName: "imovel_evolucao_preco") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_evolucao_precoPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "valor_moeda", type: "NUMBER(20, 4)")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "area_imovel", type: "FLOAT4")
			column(name: "valor_novo", type: "NUMBER(20, 4)") {
				constraints(nullable: "false")
			}
			column(name: "valorm2", type: "NUMBER(20, 4)")
			column(name: "responsavel", type: "VARCHAR(255)")
			column(name: "percentual", type: "NUMBER(20, 6)")
			column(name: "valor_antigo", type: "NUMBER(20, 4)") {
				constraints(nullable: "false")
			}
			column(name: "valor_dolar", type: "NUMBER(20, 4)")
		}
		createTable(tableName: "imovel_exclusao") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_exclusaoPK")
			}
			column(name: "concorrente_id", type: "BIGINT")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "comprou_outro_imovel", type: "BOOLEAN")
			column(name: "responsavel", type: "VARCHAR(255)")
			column(name: "motivo_exclusao", type: "VARCHAR(2)") {
				constraints(nullable: "false")
			}
			column(name: "corretor_responsavel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "data_exclusao", type: "timestamp")
			column(name: "valor_transacao", type: "NUMBER(10, 2)")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "imovel_exclusividade") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_exclusividadePK")
			}
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "exclusividade_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "vencimento", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "observacao", type: "CLOB")
			column(name: "data", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_filme") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_filmePK")
			}
			column(name: "imovel_id", type: "BIGINT")
			column(name: "exibe_internet", type: "BOOLEAN")
			column(name: "edificio_id", type: "BIGINT")
			column(name: "descricao", type: "VARCHAR(60)")
			column(name: "url", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "filme_banner", type: "BOOLEAN")
			column(name: "condominio_id", type: "BIGINT")
			column(name: "ordem", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_foto") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_fotoPK")
			}
			column(name: "imovel_id", type: "BIGINT")
			column(name: "exibe_internet", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "edificio_id", type: "BIGINT")
			column(name: "descricao", type: "VARCHAR(60)")
			column(name: "mensagem", type: "CLOB")
			column(name: "condominio_id", type: "BIGINT")
			column(name: "ordem", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "foto_id", type: "VARCHAR(32)") {
				constraints(nullable: "false")
			}
			column(name: "destaque", type: "BOOLEAN")
			column(name: "foto_banner", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_interessado_chamado") {
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_interessado_chamadoPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_interessado_chamadoPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_placa") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_placaPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "codigo_placa", type: "VARCHAR(20)")
			column(name: "ativo", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "colocacao", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "proxima_vistoria", type: "date") {
				constraints(nullable: "false")
			}
			column(name: "ultima_vistoria", type: "date") {
				constraints(nullable: "false")
			}
			column(name: "loja_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "anuncio_id", type: "BIGINT")
			column(name: "retirar_id", type: "VARCHAR(255)")
			column(name: "valor_placa", type: "NUMBER(10, 2)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_placa_corretor") {
			column(name: "imovel_placa_corretores_id", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "corretor_id", type: "BIGINT")
		}
		createTable(tableName: "imovel_placa_retirada") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_placa_retiradaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "motivo", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "responsavel", type: "VARCHAR(70)")
			column(name: "solicitador", type: "VARCHAR(70)")
			column(name: "data_retirada", type: "timestamp")
		}
		createTable(tableName: "imovel_promocao") {
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_promocaoPK")
			}
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_promocaoPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "rating", type: "INT") {
				constraints(nullable: "false", defaultValue: "0")
			}
			column(name: "loja_id", type: "BIGINT")
		}
		createTable(tableName: "imovel_proprietario") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_proprietarioPK")
			}
			column(name: "proprietario_id", type: "BIGINT")
			column(name: "descricao", type: "CLOB")
			column(name: "telefone", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "cliente_id", type: "VARCHAR(255)")
			column(name: "email", type: "VARCHAR(70)")
		}
		createTable(tableName: "imovel_saldo") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_saldoPK")
			}
			column(name: "tipo_periodo", type: "VARCHAR(13)")
			column(name: "tipo_restante", type: "INT")
			column(name: "instituicao_financeira", type: "VARCHAR(50)")
			column(name: "saldo_valor", type: "NUMBER(10, 2)") {
				constraints(nullable: "false")
			}
			column(name: "tempo_restante", type: "INT")
			column(name: "observacao", type: "CLOB")
			column(name: "saldo_prestacao", type: "NUMBER(10, 2)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_web_conf") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_confPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "porta", type: "INT")
			column(name: "codigo_cliente", type: "VARCHAR(255)")
			column(name: "usuario", type: "VARCHAR(255)")
			column(name: "url", type: "VARCHAR(255)")
			column(name: "especial", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "status_publicacao", type: "CLOB")
			column(name: "senha", type: "VARCHAR(255)")
			column(name: "destaques", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "dias_publicacao", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ultima_publicacao", type: "timestamp")
			column(name: "max_imoveis", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "imovel_web_imovel") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_imovelPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ordem", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_destaque", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_web_tag") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_tagPK")
			}
			column(name: "obrigatorio", type: "BOOLEAN")
			column(name: "tipo", type: "VARCHAR(255)")
			column(name: "maximo", type: "NUMBER(22, 2)")
			column(name: "is_empreendimento", type: "BOOLEAN")
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "is_imovel", type: "BOOLEAN")
			column(name: "tag", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_web_tipo_imovel") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_tipo_imovelPK")
			}
			column(name: "sub_tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "imovel_web_tipo_imovel_categoria") {
			column(name: "imovel_web_tipo_imovel_id", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_tipo_imovel_categoriaPK")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_tipo_imovel_categoriaPK")
			}
			column(name: "categoria", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_tipo_imovel_categoriaPK")
			}
		}
		createTable(tableName: "imovel_web_tipo_imovel_tags") {
			column(name: "imovel_web_tipo_imovel_id", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_tipo_imovel_tagsPK")
			}
			column(name: "imovel_web_tag_id", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "imovel_web_tipo_imovel_tagsPK")
			}
		}
		createTable(tableName: "interessado") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessadoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp")
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "email_padrao_id", type: "VARCHAR(32)")
			column(name: "pre_interessado", type: "BOOLEAN")
			column(name: "recebe_email", type: "BOOLEAN")
			column(name: "campanha_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "cookie", type: "VARCHAR(32)")
			column(name: "ativo", type: "BOOLEAN")
			column(name: "endereco_padrao_id", type: "VARCHAR(32)")
			column(name: "nome_antigo", type: "VARCHAR(255)")
			column(name: "hora_contato", type: "VARCHAR(255)")
			column(name: "ultimo_contato", type: "date") {
				constraints(nullable: "false")
			}
			column(name: "gerente_id", type: "BIGINT")
			column(name: "conjuge_antigo", type: "VARCHAR(255)")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "loja_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "imovel_chamado_id", type: "BIGINT")
			column(name: "telefone_padrao_id", type: "VARCHAR(32)")
			column(name: "nome_normalizado", type: "VARCHAR(72)")
			column(name: "pessoa_id", type: "BIGINT")
			column(name: "classificacao_id", type: "BIGINT")
			column(name: "cliente_id", type: "VARCHAR(255)")
			column(name: "nome_conjuge", type: "VARCHAR(72)")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "interessado_atendimento") {
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_atendimentoPK")
			}
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_atendimentoPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_atendimentoPK")
			}
			column(name: "motivo", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "interessado_email") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_emailPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_endereco_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "nome", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}
			column(name: "endereco", type: "VARCHAR(70)") {
				constraints(nullable: "false")
			}
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "interessado_endereco") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_enderecoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "bairro", type: "VARCHAR(60)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_endereco_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "cidade", type: "VARCHAR(60)") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "uf", type: "VARCHAR(2)") {
				constraints(nullable: "false")
			}
			column(name: "logradouro", type: "VARCHAR(60)") {
				constraints(nullable: "false")
			}
			column(name: "numero", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}
			column(name: "exterior", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "tipo", type: "VARCHAR(40)") {
				constraints(nullable: "false")
			}
			column(name: "cep", type: "VARCHAR(8)") {
				constraints(nullable: "false")
			}
			column(name: "logradourodne_id", type: "BIGINT")
			column(name: "complemento", type: "VARCHAR(40)")
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "interessado_exclusao") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_exclusaoPK")
			}
			column(name: "imovel_id", type: "BIGINT")
			column(name: "concorrente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "condicoes_transacao", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "motivo_exclusao", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "data_transacao", type: "timestamp")
			column(name: "valor_transacao", type: "NUMBER(10, 2)")
			column(name: "interessado_id", type: "BIGINT")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "interessado_exclusao_instantaneo") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_exclusao_instantaneoPK")
			}
			column(name: "bairro", type: "VARCHAR(255)")
			column(name: "tipo_imovel_nome", type: "VARCHAR(255)")
			column(name: "cidade", type: "VARCHAR(255)")
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "artot", type: "FLOAT4")
			column(name: "proposta_ativa", type: "BOOLEAN")
			column(name: "tipo_logradouro", type: "VARCHAR(255)")
			column(name: "qtde_foto", type: "INT")
			column(name: "data_atualizacao", type: "timestamp")
			column(name: "referencia", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "arcons", type: "FLOAT4")
			column(name: "exclusao_id", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "logradouro", type: "VARCHAR(255)")
			column(name: "contrato", type: "VARCHAR(255)")
			column(name: "numero", type: "VARCHAR(255)")
			column(name: "sui", type: "INT")
			column(name: "dor", type: "INT")
			column(name: "valor", type: "NUMBER(19, 2)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_imovel_sigla", type: "VARCHAR(255)")
			column(name: "regiao", type: "VARCHAR(255)")
			column(name: "valor_iptu", type: "FLOAT4")
			column(name: "endereco", type: "VARCHAR(255)")
			column(name: "bloco", type: "VARCHAR(255)")
			column(name: "sal", type: "INT")
			column(name: "complemento", type: "VARCHAR(255)")
			column(name: "gar", type: "INT")
			column(name: "coz", type: "INT")
			column(name: "ban", type: "INT")
			column(name: "arterr", type: "FLOAT4")
			column(name: "arutil", type: "FLOAT4")
			column(name: "valor_condominio", type: "NUMBER(19, 2)")
			column(name: "apartamento", type: "VARCHAR(255)")
		}
		createTable(tableName: "interessado_oferta") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_ofertaPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "prioridade", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_oferta", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "data_envio", type: "timestamp")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "status_envio", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "mensagem_envio", type: "VARCHAR(255)")
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "email", type: "VARCHAR(255)")
		}
		createTable(tableName: "interessado_telefone") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessado_telefonePK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_endereco_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "telefone", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}
			column(name: "ramal", type: "VARCHAR(10)")
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "interesse") {
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessePK")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessePK")
			}
			column(name: "regiao_corretagem_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessePK")
			}
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interessePK")
			}
			column(name: "segmento_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "pacote", type: "BOOLEAN")
			column(name: "minimo", type: "NUMBER(14, 2)")
			column(name: "carteira_id", type: "BIGINT")
			column(name: "maximo", type: "NUMBER(14, 2)")
			column(name: "valor_iptu", type: "NUMBER(10, 2)")
			column(name: "finalidade_imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "valor_condominio", type: "NUMBER(10, 2)")
		}
		createTable(tableName: "interesse_dependencia") {
			column(name: "interesse_interessado_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interesse_dependenciaPK")
			}
			column(name: "interesse_tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interesse_dependenciaPK")
			}
			column(name: "interesse_regiao_corretagem_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interesse_dependenciaPK")
			}
			column(name: "interesse_tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interesse_dependenciaPK")
			}
			column(name: "tipo_dependencia_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "interesse_dependenciaPK")
			}
			column(name: "valor_inteiro", type: "INT")
			column(name: "valor_boolean", type: "BOOLEAN")
			column(name: "valor_float", type: "NUMBER(20, 6)")
			column(name: "valor_multiplo", type: "INT")
		}
		createTable(tableName: "logradouro") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "logradouroPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "bairro_ini_id", type: "BIGINT")
			column(name: "grande_usuario", type: "VARCHAR(1)")
			column(name: "numero_complemento", type: "VARCHAR(11)")
			column(name: "status_logradouro", type: "VARCHAR(1)")
			column(name: "cidade_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "nome_complemento", type: "VARCHAR(36)")
			column(name: "bairro_fim_id", type: "BIGINT")
			column(name: "inicio_trecho", type: "FLOAT4")
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "nome_lote", type: "VARCHAR(11)")
			column(name: "preposicao", type: "VARCHAR(255)")
			column(name: "paridade", type: "VARCHAR(1)")
			column(name: "final_trecho", type: "FLOAT4")
			column(name: "titulo", type: "VARCHAR(72)")
			column(name: "logradouro_pai_id", type: "BIGINT")
			column(name: "abrvact", type: "VARCHAR(40)")
			column(name: "cep", type: "VARCHAR(8)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_log_id", type: "BIGINT")
			column(name: "complemento", type: "VARCHAR(36)")
			column(name: "nome_normalizado", type: "VARCHAR(72)")
			column(name: "chavedne", type: "INT")
			column(name: "distrito_id", type: "BIGINT")
		}
		createTable(tableName: "loja") {
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "lojaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "ativo", type: "BOOLEAN")
			column(name: "latitude", type: "FLOAT4")
			column(name: "atuacao", type: "CLOB")
			column(name: "ip_loja", type: "VARCHAR(255)")
			column(name: "carteira_id", type: "BIGINT")
			column(name: "longitude", type: "FLOAT4")
			column(name: "creci", type: "VARCHAR(20)")
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "mensagem") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "mensagemPK")
			}
			column(name: "date_created", type: "timestamp")
			column(name: "tipo_mensagem", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_grupo_destino", type: "VARCHAR(255)")
			column(name: "conteudo", type: "CLOB") {
				constraints(nullable: "false")
			}
			column(name: "user_name_origem", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "titulo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "mensagem_origem_id", type: "VARCHAR(255)")
			column(name: "user_name_destino", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "action", type: "VARCHAR(255)")
			column(name: "recepcao", type: "timestamp")
			column(name: "cc", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "mensagem_anexo") {
			column(name: "mensagem_id", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "mensagem_anexoPK")
			}
			column(name: "arquivo_id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "mensagem_anexoPK")
			}
		}
		createTable(tableName: "mensagem_destinatario") {
			column(name: "mensagem_id", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "mensagem_destinatarioPK")
			}
			column(name: "user_name", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "mensagem_destinatarioPK")
			}
			column(name: "cc", type: "BOOLEAN") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "mensagem_destinatarioPK")
			}
			column(name: "status", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "recebida", type: "timestamp")
		}
		createTable(tableName: "menu") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "menuPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "icone", type: "VARCHAR(255)")
			column(name: "mneumonic", type: "CHAR(1)")
			column(name: "nome", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}
			column(name: "selected", type: "BOOLEAN")
			column(name: "dica", type: "VARCHAR(255)")
			column(name: "aplicacao_id", type: "BIGINT")
			column(name: "pai_id", type: "BIGINT")
			column(name: "posicao", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "tipo", type: "VARCHAR(10)")
			column(name: "administrativo", type: "BOOLEAN")
			column(name: "alinhamento", type: "VARCHAR(1)")
			column(name: "action", type: "VARCHAR(50)")
			column(name: "enabled", type: "BOOLEAN")
		}
		createTable(tableName: "menu_regra") {
			column(name: "menu_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "menu_regraPK")
			}
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "menu_regraPK")
			}
		}
		createTable(tableName: "midia_tipo") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "midia_tipoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}
			column(name: "unidade", type: "VARCHAR(3)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "miniatura") {
			column(name: "id_figura", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "miniaturaPK")
			}
			column(name: "marca_dagua_id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "miniaturaPK")
			}
			column(name: "largura", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "miniaturaPK")
			}
			column(name: "altura", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "miniaturaPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "ultimo_acesso", type: "timestamp")
			column(name: "binario", type: "BYTEA") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "moeda") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "moedaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "codigo", type: "VARCHAR(10)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(30)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "moeda_indice") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "moeda_indicePK")
			}
			column(name: "valor", type: "NUMBER(20, 4)") {
				constraints(nullable: "false")
			}
			column(name: "moeda_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "data", type: "date") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "nota_promissoria") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "nota_promissoriaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ultima_impressao", type: "timestamp")
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "emissao", type: "date") {
				constraints(nullable: "false")
			}
			column(name: "praca", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "beneficiario_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "nota_promissoria_parcela") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "nota_promissoria_parcelaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "parcela", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "valor", type: "NUMBER(10, 2)") {
				constraints(nullable: "false")
			}
			column(name: "nota_id", type: "VARCHAR(32)") {
				constraints(nullable: "false")
			}
			column(name: "data", type: "date") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "nota_promissoria_pessoa") {
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "emitente_id", type: "VARCHAR(32)") {
				constraints(nullable: "false")
			}
			column(name: "avalista_id", type: "VARCHAR(32)")
		}
		createTable(tableName: "parametro_classe_interessado") {
			column(name: "classe_interessado_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "parametro_classe_interessadoPK")
			}
			column(name: "parametro_sistema_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "parametro_classe_interessadoPK")
			}
			column(name: "dias", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "parametro_sistema_comissao") {
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "parametro_sistema_comissaoPK")
			}
			column(name: "departamento", type: "VARCHAR(15)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "parametro_sistema_comissaoPK")
			}
			column(name: "parametro_sistema_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "parametro_sistema_comissaoPK")
			}
			column(name: "percentual", type: "NUMBER(10, 4)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "parametros_sistema") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "parametros_sistemaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "start_ssl", type: "BOOLEAN")
			column(name: "bloquear_login_fora_empresa", type: "BOOLEAN")
			column(name: "regiao_corretagem_id", type: "BIGINT")
			column(name: "cidade_id", type: "BIGINT")
			column(name: "sugestao_interesse", type: "NUMBER(10, 4)")
			column(name: "ordem_fotografia_imovel", type: "VARCHAR(2)")
			column(name: "dias_limpar_thumb_nails", type: "INT")
			column(name: "wordpress_update", type: "BOOLEAN")
			column(name: "tipo_imovel_id", type: "BIGINT")
			column(name: "integracao_path", type: "VARCHAR(255)")
			column(name: "bloquear_corretor_automaticamente", type: "BOOLEAN")
			column(name: "email_password", type: "VARCHAR(255)")
			column(name: "verificar_duplicidade_update_imovel", type: "BOOLEAN")
			column(name: "percentual_lancamento", type: "NUMBER(10, 4)")
			column(name: "atualizar_interessado_sem_interesse", type: "BOOLEAN")
			column(name: "start_tls", type: "BOOLEAN")
			column(name: "integracao_server", type: "VARCHAR(255)")
			column(name: "incluir_interessado_sem_interesse", type: "BOOLEAN")
			column(name: "tempo_verificar_mensagens", type: "INT")
			column(name: "dias_bloquear_corretor", type: "INT")
			column(name: "integracao_ativar", type: "BOOLEAN")
			column(name: "email_ssl", type: "BOOLEAN")
			column(name: "integracao_empresa", type: "INT")
			column(name: "email_port", type: "INT")
			column(name: "tipo_contrato", type: "INT")
			column(name: "uf_id", type: "BIGINT")
			column(name: "rodizio_interessado", type: "BOOLEAN")
			column(name: "wordpress_path", type: "VARCHAR(255)")
			column(name: "cidade_corretagem_id", type: "BIGINT")
			column(name: "wordpress_server", type: "VARCHAR(255)")
			column(name: "enviar_fotos_edificio_portais", type: "BOOLEAN")
			column(name: "ip_empresa", type: "VARCHAR(255)")
			column(name: "relatorio_visita_imprime_proprietario", type: "BOOLEAN")
			column(name: "emails_por_minuto", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "dias_vistoria_placa", type: "INT")
			column(name: "email_server", type: "VARCHAR(255)")
			column(name: "email_username", type: "VARCHAR(255)")
			column(name: "deduzir_despezas_comissoes", type: "BOOLEAN")
			column(name: "cobrar_taxa_reserva", type: "BOOLEAN")
			column(name: "validade_imovel_internet", type: "INT")
			column(name: "tamanho_quadro_chaves", type: "INT")
			column(name: "dias_prox_atu", type: "INT")
			column(name: "moeda_avaliacao_id", type: "BIGINT")
			column(name: "dias_devolucao_chaves", type: "INT")
			column(name: "interessado_autocomplete_inativo", type: "BOOLEAN")
			column(name: "dias_expiracao_proposta", type: "INT")
			column(name: "percentual_locacao", type: "NUMBER(10, 4)")
			column(name: "percentual_venda", type: "NUMBER(10, 4)")
			column(name: "valor_placa", type: "NUMBER(10, 2)")
		}
		createTable(tableName: "pessoa") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pessoaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "estado_civil", type: "VARCHAR(25)")
			column(name: "twitter", type: "VARCHAR(255)")
			column(name: "sistema", type: "BOOLEAN")
			column(name: "inscricao", type: "VARCHAR(20)")
			column(name: "date_created", type: "timestamp")
			column(name: "cod_nome_normalizado", type: "VARCHAR(70)")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "rg", type: "VARCHAR(20)")
			column(name: "nome", type: "VARCHAR(70)") {
				constraints(nullable: "false")
			}
			column(name: "email_padrao_id", type: "VARCHAR(32)")
			column(name: "banco_padrao_id", type: "VARCHAR(32)")
			column(name: "sexo", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "foto_id", type: "VARCHAR(32)")
			column(name: "endereco_padrao_id", type: "VARCHAR(32)")
			column(name: "bloquear_envio_email", type: "BOOLEAN")
			column(name: "profissao", type: "VARCHAR(40)")
			column(name: "google_plus", type: "VARCHAR(255)")
			column(name: "skype", type: "VARCHAR(255)")
			column(name: "nacionalidade", type: "VARCHAR(20)")
			column(name: "nascimento_conjuge", type: "date")
			column(name: "cpf_conjuge", type: "VARCHAR(14)")
			column(name: "cod_nome", type: "VARCHAR(70)")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "rg_conjuge", type: "VARCHAR(20)")
			column(name: "telefone_padrao_id", type: "VARCHAR(32)")
			column(name: "face_book", type: "VARCHAR(255)")
			column(name: "nome_normalizado", type: "VARCHAR(70)")
			column(name: "cpf", type: "VARCHAR(14)")
			column(name: "tipo_pessoa", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "nome_conjuge", type: "VARCHAR(70)")
			column(name: "site", type: "VARCHAR(255)")
			column(name: "rg_data_expedicao", type: "timestamp")
			column(name: "observacoes", type: "CLOB")
			column(name: "rg_orgao_emissor", type: "VARCHAR(40)")
			column(name: "nascimento", type: "date")
		}
		createTable(tableName: "pessoa_banco") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pessoa_bancoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "conta", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "banco_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "forma_pagamento", type: "VARCHAR(18)") {
				constraints(nullable: "false")
			}
			column(name: "agencia", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_conta", type: "VARCHAR(8)") {
				constraints(nullable: "false")
			}
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "pessoa_email") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pessoa_emailPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_endereco_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "nome", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}
			column(name: "endereco", type: "VARCHAR(70)") {
				constraints(nullable: "false")
			}
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "pessoa_endereco") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pessoa_enderecoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "bairro", type: "VARCHAR(60)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_endereco_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "cidade", type: "VARCHAR(60)") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "uf", type: "VARCHAR(2)") {
				constraints(nullable: "false")
			}
			column(name: "logradouro", type: "VARCHAR(60)") {
				constraints(nullable: "false")
			}
			column(name: "numero", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}
			column(name: "exterior", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "tipo", type: "VARCHAR(40)") {
				constraints(nullable: "false")
			}
			column(name: "cep", type: "VARCHAR(8)") {
				constraints(nullable: "false")
			}
			column(name: "logradourodne_id", type: "BIGINT")
			column(name: "complemento", type: "VARCHAR(40)")
			column(name: "pessoa_id", type: "BIGINT")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "pessoa_telefone") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pessoa_telefonePK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_endereco_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "telefone", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}
			column(name: "ramal", type: "VARCHAR(10)")
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "proposta") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "propostaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "imovel_id", type: "BIGINT")
			column(name: "taxa_reserva", type: "NUMBER(19, 2)")
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "expira", type: "date")
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "ativacao", type: "timestamp")
			column(name: "liberacao", type: "date")
			column(name: "valor", type: "NUMBER(10, 2)")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "liberacao_responsavel", type: "VARCHAR(255)")
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "status", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "observacao", type: "CLOB")
		}
		createTable(tableName: "proposta_oferta") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "proposta_ofertaPK")
			}
			column(name: "titulo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_oferta", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "valor", type: "NUMBER(10, 2)") {
				constraints(nullable: "false")
			}
			column(name: "descricao", type: "CLOB")
			column(name: "proposta_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "quadro_chaves") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "quadro_chavesPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "padrao", type: "BOOLEAN")
			column(name: "tamanho", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "quadro_chaves_posicao") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "quadro_chaves_posicaoPK")
			}
			column(name: "motivo_retirada", type: "INT")
			column(name: "date_created", type: "timestamp")
			column(name: "retomada", type: "timestamp")
			column(name: "corretor_id", type: "BIGINT")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "retirada", type: "timestamp")
			column(name: "quadro_chaves_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "recebimento", type: "timestamp")
			column(name: "posicao", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "dt_operacao", type: "timestamp")
			column(name: "interessado_id", type: "BIGINT")
			column(name: "status", type: "INT")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "recepcao_telefonema") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "recepcao_telefonemaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_ligacao", type: "VARCHAR(8)")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "telefone", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(70)") {
				constraints(nullable: "false")
			}
			column(name: "origem", type: "VARCHAR(12)")
			column(name: "nome_usu_destino", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "ramal", type: "VARCHAR(10)")
			column(name: "ramal_destino", type: "VARCHAR(20)")
			column(name: "status", type: "VARCHAR(8)")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "regiao_corretagem") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "regiao_corretagemPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "cidade_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(40)") {
				constraints(nullable: "false")
			}
			column(name: "regiaocp", type: "BIGINT")
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "regra") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "regraPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "authority", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "requestmap") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "requestmapPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "http_method", type: "VARCHAR(255)")
			column(name: "config_attribute", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "url", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "rodizio") {
			column(name: "loja_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rodizioPK")
			}
			column(name: "data", type: "date") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rodizioPK")
			}
			column(name: "tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rodizioPK")
			}
		}
		createTable(tableName: "rodizio_corretor") {
			column(name: "rodizio_loja_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rodizio_corretorPK")
			}
			column(name: "rodizio_data", type: "date") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rodizio_corretorPK")
			}
			column(name: "rodizio_tipo_contrato", type: "INT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rodizio_corretorPK")
			}
			column(name: "corretor_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rodizio_corretorPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "segmento_imovel") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "segmento_imovelPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "padrao", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "tenant") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tenantPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp")
			column(name: "last_updated", type: "timestamp")
			column(name: "telefone", type: "VARCHAR(15)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(70)") {
				constraints(nullable: "false")
			}
			column(name: "contexto", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
			column(name: "password", type: "VARCHAR(80)") {
				constraints(nullable: "false")
			}
			column(name: "promocao", type: "BOOLEAN")
			column(name: "nome_normalizado", type: "VARCHAR(70)") {
				constraints(nullable: "false")
			}
			column(name: "cpf", type: "VARCHAR(14)")
			column(name: "email", type: "VARCHAR(80)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "tenant_properties") {
			column(name: "cliente_id", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tenant_propertiesPK")
			}
			column(name: "chave", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tenant_propertiesPK")
			}
			column(name: "valor", type: "VARCHAR(255)")
		}
		createTable(tableName: "texto_sistema") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "texto_sistemaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "titulo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "chave", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "conteudo", type: "CLOB") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "true")
			}
			column(name: "ativo", type: "BOOLEAN") {
				constraints(nullable: "true")
			}
		}
		createTable(tableName: "tipo_dependencia") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tipo_dependenciaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sigla", type: "VARCHAR(10)") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "relativo", type: "VARCHAR(15)") {
				constraints(nullable: "false")
			}
			column(name: "imovel_web_tag_id", type: "VARCHAR(32)")
			column(name: "ordem", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "tipo_campo", type: "VARCHAR(15)") {
				constraints(nullable: "false")
			}
			column(name: "posicao", type: "VARCHAR(15)") {
				constraints(nullable: "false")
			}
			column(name: "tique_imovel_tag_id", type: "VARCHAR(32)")
			column(name: "viva_real_tag_id", type: "VARCHAR(32)")
			column(name: "dependencia_pai_id", type: "BIGINT")
			column(name: "zap_tag_id", type: "VARCHAR(32)")
			column(name: "finalidade_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "tipo_dependencia_itens") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tipo_dependencia_itensPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "dependencia_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "valor", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "tipo_endereco") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tipo_enderecoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "descricao", type: "CLOB")
			column(name: "nome", type: "VARCHAR(25)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "tipo_imovel") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tipo_imovelPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ativar_edificio", type: "BOOLEAN")
			column(name: "sigla", type: "VARCHAR(6)") {
				constraints(nullable: "false")
			}
			column(name: "ativar_condominio", type: "BOOLEAN")
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "campo_area_id", type: "BIGINT")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "texto_anuncio", type: "CLOB")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "nome", type: "VARCHAR(40)") {
				constraints(nullable: "false")
			}
			column(name: "campo_unidade_id", type: "BIGINT")
			column(name: "siglacp", type: "VARCHAR(255)")
			column(name: "ativo", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "campo_grupo_id", type: "BIGINT")
			column(name: "ativar_empreendimento", type: "BOOLEAN")
			column(name: "ordem_anuncio", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ordem_internet", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "tipo_imovel_relativo") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tipo_imovel_relativoPK")
			}
			column(name: "relativo", type: "VARCHAR(15)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "tipo_logradouro") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tipo_logradouroPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sigla", type: "VARCHAR(40)") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
			column(name: "chavedne", type: "BIGINT")
		}
		createTable(tableName: "tipo_rel_dep") {
			column(name: "dependencia_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tipo_rel_depPK")
			}
			column(name: "relativo_id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tipo_rel_depPK")
			}
			column(name: "ordem", type: "INT")
		}
		createTable(tableName: "tique_imovel_conf") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tique_imovel_confPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "codigo_cliente", type: "VARCHAR(255)")
			column(name: "url", type: "VARCHAR(255)")
			column(name: "especial", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "status_publicacao", type: "CLOB")
			column(name: "senha", type: "VARCHAR(255)")
			column(name: "destaques", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "dias_publicacao", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ultima_publicacao", type: "timestamp")
			column(name: "max_imoveis", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "tique_imovel_imovel") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tique_imovel_imovelPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ordem", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_destaque", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "tique_imovel_tag") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tique_imovel_tagPK")
			}
			column(name: "obrigatorio", type: "BOOLEAN")
			column(name: "tipo", type: "VARCHAR(255)")
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tag", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "tique_imovel_tipo_imovel") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tique_imovel_tipo_imovelPK")
			}
			column(name: "sub_tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_imovel_id", type: "BIGINT")
		}
		createTable(tableName: "usuario") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuarioPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "email_port", type: "INT")
			column(name: "start_ssl", type: "BOOLEAN")
			column(name: "sistema", type: "BOOLEAN")
			column(name: "ativar_email", type: "BOOLEAN")
			column(name: "corretor_id", type: "BIGINT")
			column(name: "password_expired", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "account_expired", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "ultimo_login", type: "timestamp")
			column(name: "email_password", type: "VARCHAR(255)")
			column(name: "carteira_id", type: "BIGINT")
			column(name: "start_tls", type: "BOOLEAN")
			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "email_server", type: "VARCHAR(255)")
			column(name: "email_username", type: "VARCHAR(255)")
			column(name: "account_locked", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "loja_id", type: "BIGINT")
			column(name: "ultimo_bloqueio", type: "timestamp")
			column(name: "pessoa_id", type: "BIGINT")
			column(name: "email_ssl", type: "BOOLEAN")
			column(name: "enabled", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "email_remetente", type: "VARCHAR(255)")
			column(name: "ultimo_login_ip", type: "VARCHAR(255)")
		}
		createTable(tableName: "usuario_aplicacao") {
			column(name: "aplicacao_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_aplicacaoPK")
			}
			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_aplicacaoPK")
			}
		}
		createTable(tableName: "usuario_atalho") {
			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_atalhoPK")
			}
			column(name: "menu_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_atalhoPK")
			}
			column(name: "esquerda", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "topo", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "usuario_grupo") {
			column(name: "grupo_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_grupoPK")
			}
			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_grupoPK")
			}
		}
		createTable(tableName: "usuario_menu") {
			column(name: "menu_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_menuPK")
			}
			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_menuPK")
			}
		}
		createTable(tableName: "usuario_preferencias") {
			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "preferencias_elt", type: "varchar(255)") {
				constraints(nullable: "false")
			}
			column(name: "preferencias_object", type: "varchar(255)")
			column(name: "preferencias_idx", type: "varchar(255)")
		}
		createTable(tableName: "usuario_regra") {
			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_regraPK")
			}
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_regraPK")
			}
		}
		createTable(tableName: "usuario_regra_negado") {
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_regra_negadoPK")
			}
			column(name: "user_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usuario_regra_negadoPK")
			}
		}
		createTable(tableName: "veiculo_comunicacao") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "veiculo_comunicacaoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sistema", type: "BOOLEAN")
			column(name: "date_created", type: "timestamp")
			column(name: "descricao", type: "CLOB")
			column(name: "last_updated", type: "timestamp")
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "nome", type: "VARCHAR(72)") {
				constraints(nullable: "false")
			}
			column(name: "pessoa_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "venda") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "vendaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "cartorio", type: "NUMBER(12, 2)")
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "forum", type: "NUMBER(12, 2)")
			column(name: "outros", type: "NUMBER(12, 2)")
			column(name: "zelador", type: "NUMBER(12, 2)")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "pago", type: "BOOLEAN")
			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "nome_usu_criador", type: "VARCHAR(255)")
			column(name: "xerox", type: "NUMBER(12, 2)")
			column(name: "deduzir_despesas", type: "BOOLEAN")
			column(name: "procuracoes", type: "NUMBER(12, 2)")
			column(name: "total_parcela", type: "INT")
			column(name: "reconhecimento_firma", type: "NUMBER(12, 2)")
			column(name: "vendedor_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "comissao_venda", type: "NUMBER(12, 2)") {
				constraints(nullable: "false")
			}
			column(name: "comissaodimob", type: "NUMBER(12, 2)")
			column(name: "conducao", type: "NUMBER(12, 2)")
			column(name: "codigo", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "valor_cadastro", type: "NUMBER(12, 2)") {
				constraints(nullable: "false")
			}
			column(name: "enviardimob", type: "BOOLEAN")
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "status", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "anuncio", type: "NUMBER(12, 2)")
			column(name: "data_venda", type: "date") {
				constraints(nullable: "false")
			}
			column(name: "promissoria_id", type: "VARCHAR(32)")
			column(name: "valor_venda", type: "NUMBER(12, 2)") {
				constraints(nullable: "false")
			}
			column(name: "comprador_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "proposta_id", type: "BIGINT")
			column(name: "valordimob", type: "NUMBER(12, 2)")
			column(name: "observacoes", type: "CLOB")
		}
		createTable(tableName: "venda_departamento") {
			column(name: "venda_id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "venda_departamentoPK")
			}
			column(name: "departamento", type: "VARCHAR(15)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "venda_departamentoPK")
			}
			column(name: "percentual", type: "NUMBER(10, 4)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "venda_departamento_comissao") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "venda_departamento_comissaoPK")
			}
			column(name: "departamento", type: "VARCHAR(15)") {
				constraints(nullable: "false")
			}
			column(name: "corretor_id", type: "BIGINT")
			column(name: "venda_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "percentual", type: "NUMBER(10, 4)") {
				constraints(nullable: "false")
			}
			column(name: "pessoa_id", type: "BIGINT")
		}
		createTable(tableName: "venda_imagem") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "venda_imagemPK")
			}
			column(name: "titulo", type: "VARCHAR(60)")
			column(name: "imagem_id", type: "VARCHAR(32)") {
				constraints(nullable: "false")
			}
			column(name: "venda_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "venda_parcela") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "venda_parcelaPK")
			}
			column(name: "parcela", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "valor", type: "NUMBER(12, 2)") {
				constraints(nullable: "false")
			}
			column(name: "descricao", type: "CLOB")
			column(name: "venda_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "vencimento", type: "date") {
				constraints(nullable: "false")
			}
			column(name: "status", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "versao") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "versaoPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "minor", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "major", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "release", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "visita") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "visitaPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "opiniao", type: "CLOB")
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "corretor_id", type: "BIGINT")
			column(name: "responsavel", type: "VARCHAR(255)")
			column(name: "posicao_chave_id", type: "VARCHAR(32)")
			column(name: "ativo", type: "BOOLEAN")
			column(name: "data_opniao", type: "timestamp")
			column(name: "status_visita", type: "VARCHAR(1)") {
				constraints(nullable: "false")
			}
			column(name: "interessado_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "viva_real_conf") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "viva_real_confPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "codigo_cliente", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "url", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "especial", type: "INT")
			column(name: "status_publicacao", type: "CLOB")
			column(name: "senha", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "contador_remessa", type: "BIGINT")
			column(name: "destaques", type: "INT")
			column(name: "dias_publicacao", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ultima_publicacao", type: "timestamp")
			column(name: "max_imoveis", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "viva_real_imovel") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "viva_real_imovelPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ordem", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_destaque", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "viva_real_tag") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "viva_real_tagPK")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tag", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "viva_real_tipo_imovel") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "viva_real_tipo_imovelPK")
			}
			column(name: "tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_imovel_id", type: "BIGINT")
			column(name: "traducao", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "wordpress_click") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "wordpress_clickPK")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "action", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "cookie", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "wordpress_click_parametro") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "wordpress_click_parametroPK")
			}
			column(name: "click_id", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}
			column(name: "value", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "key", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "zap_conf") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "zap_confPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "codigo_cliente", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "url", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "status_publicacao", type: "CLOB")
			column(name: "senha", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "destaques", type: "INT")
			column(name: "dias_publicacao", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "ultima_publicacao", type: "timestamp")
			column(name: "max_imoveis", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "super_destaques", type: "INT")
			column(name: "ativo", type: "BOOLEAN")
		}
		createTable(tableName: "zap_imovel") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "zap_imovelPK")
			}
			column(name: "imovel_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "ordem", type: "INT") {
				constraints(nullable: "false")
			}
			column(name: "tipo_destaque", type: "INT") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "zap_tag") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "zap_tagPK")
			}
			column(name: "obrigatorio", type: "BOOLEAN") {
				constraints(nullable: "false")
			}
			column(name: "tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "maximo", type: "NUMBER(22, 2)") {
				constraints(nullable: "false")
			}
			column(name: "nome", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tag", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
		createTable(tableName: "zap_tipo_imovel") {
			column(name: "id", type: "VARCHAR(32)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "zap_tipo_imovelPK")
			}
			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
			column(name: "sub_tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tipo", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "categoria", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
			column(name: "tipo_imovel_id", type: "BIGINT")
			column(name: "campo_area_sigla", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}
}
