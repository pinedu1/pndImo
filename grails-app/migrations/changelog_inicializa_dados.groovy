databaseChangeLog = {
	changeSet(author: "eduardo", id: "INIT_GPB") {
		grailsChange {
			change {
				sql.execute("""
				COPY estado (id,version,cep2i,sistema,abrvact,cep1f,chavecep,cep2f,nome,cep1i,uf,chavedne,ativo) FROM '/pinedu/modelo/estado.csv' with csv header;
				COPY tipo_logradouro (id,version,sigla,sistema,nome,ativo,chavedne) FROM '/pinedu/modelo/tipo_logradouro.csv' with csv header;
				COPY cidade (id,version,sigladrect,cep2i,sistema,codibge,cidade_pai_id,cep2f,nome,uf_id,tipo,abrvact,cep,cep1f,situacao,cep1i,nome_normalizado,chavedne) FROM '/pinedu/modelo/cidade.csv' with csv header;
				COPY bairro (id,version,cep2i,sistema,cidade_id,cep2f,nome,abrvact,cep1f,cep1i,nome_normalizado,chavedne,distrito_id) FROM '/pinedu/modelo/bairro.csv' with csv header;
				COPY logradouro (id,version,sistema,bairro_ini_id,grande_usuario,numero_complemento,status_logradouro,cidade_id,nome_complemento,bairro_fim_id,inicio_trecho,nome,nome_lote,preposicao,paridade,final_trecho,titulo,logradouro_pai_id,abrvact,cep,tipo_log_id,complemento,nome_normalizado,chavedne,distrito_id) FROM '/pinedu/modelo/logradouro.csv' with csv header;
				""")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_PESSOA") {
		grailsChange {
			change {
				sql.execute("""
				COPY tipo_endereco (id,version,sistema,descricao,nome,ativo) FROM '/pinedu/modelo/tipo_endereco.csv' with csv header;
				COPY pessoa_endereco (id,version,bairro,tipo_endereco_id,sistema,cidade,date_created,last_updated,nome_usu_criador,uf,logradouro,numero,exterior,tipo,cep,logradourodne_id,complemento,pessoa_id,observacoes) FROM '/pinedu/modelo/pessoa_endereco.csv' with csv header;
				COPY pessoa_telefone (id,version,tipo_endereco_id,sistema,date_created,last_updated,nome_usu_criador,telefone,ramal,pessoa_id,observacoes) FROM '/pinedu/modelo/pessoa_telefone.csv' with csv header;
				COPY pessoa_email (id,version,tipo_endereco_id,sistema,date_created,last_updated,nome_usu_criador,nome,endereco,pessoa_id,observacoes) FROM '/pinedu/modelo/pessoa_email.csv' with csv header;
				COPY pessoa (id,codigo,version,nome,cod_nome,estado_civil,sistema,date_created,cod_nome_normalizado,last_updated,nome_usu_criador,email_padrao_id,sexo,ativo,foto_id,endereco_padrao_id,nacionalidade,telefone_padrao_id,nome_normalizado,cpf,tipo_pessoa,observacoes,nascimento) FROM '/pinedu/modelo/pessoa.csv'  WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				""")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_APLICACAO") {
		grailsChange {
			change {
				sql.execute("""
				COPY empresa (id,version,date_created,last_updated,nome_usu_criador,inscr_estadual,creci,marketing,pessoa_id,inscr_municipal,site,observacoes) FROM '/pinedu/modelo/empresa.csv' with csv header NULL 'NULL';
				COPY aplicacao (id,version,icone,descricao,codigo,nome,ativo,versao_major,versao_minor,versao_release,versao_nome) FROM '/pinedu/modelo/aplicacao.csv' with csv header;
				COPY carteira_imovel (id,version,sistema,padrao,descricao,nome,ativo) FROM '/pinedu/modelo/carteira_imovel.csv' with csv header;
				COPY loja (id,version,sistema,date_created,last_updated,nome_usu_criador,ativo,latitude,atuacao,ip_loja,carteira_id,longitude,codigo,creci,pessoa_id,observacoes,nome) FROM '/pinedu/modelo/loja.csv' with csv header NULL 'NULL';
				COPY corretor (id,version,sistema,date_created,last_updated,nome_usu_criador,ativo,categoria,corretorcp,codigo,creci,pessoa_id,observacoes) FROM '/pinedu/modelo/corretor.csv' with csv header;
				COPY concorrente (id,version,ativo,codigo,concorrentecp,creci,date_created,last_updated,nome_usu_criador,observacoes,pessoa_id,sistema) FROM '/pinedu/modelo/concorrente.csv' with csv header NULL 'NULL';
				COPY arquivo_binario (id, base64) FROM '/pinedu/modelo/arquivo_stream.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY arquivo( id, version, id_mask, stream_id, mime_type, tamanho, path, nome ) FROM '/pinedu/modelo/arquivo.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY empresa_imagem (imagem_id, empresa_id) FROM '/pinedu/modelo/empresa_imagem.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				""")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_EQUIPE") {
		grailsChange {
			change {
				sql.execute("""
				COPY equipe (id,version,ativo,carteira_id,date_created,descricao,grupo_id,last_updated,loja_id,nome,nome_usu_criador,sigla,sistema) FROM '/pinedu/modelo/equipe.csv' with csv header NULL 'NULL';
				COPY equipe_corretor (corretor_id,equipe_id) FROM '/pinedu/modelo/equipe_corretor.csv' with csv header NULL 'NULL';
				COPY equipe_gerente (gerente_id,equipe_id) FROM '/pinedu/modelo/equipe_gerente.csv' with csv header NULL 'NULL';
				""")
			}
		}
	}
	//COPY (SELECT tipo_contrato, departamento, parametro_sistema_id, percentual FROM parametro_sistema_comissao ORDER BY tipo_contrato ASC, departamento ASC ) TO '/pinedu/modelo/parametro_sistema_comissao.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL', FORCE_QUOTE ( departamento ) );
	//COPY ( SELECT classe_interessado_id, parametro_sistema_id, dias FROM parametro_classe_interessado ) TO '/pinedu/modelo/parametro_classe_interessado.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
	changeSet(author: "eduardo", id: "INIT_MIDIA") {
		grailsChange {
			change {
				sql.execute("""
				COPY moeda (id,version,ativo,codigo,descricao,nome,sistema) FROM '/pinedu/modelo/moeda.csv' with csv header NULL 'NULL';
				COPY agenda (id,version,cor,corporativa,date_created,descricao,grupo_id,last_updated,nome,oculto,sistema,user_id) FROM '/pinedu/modelo/agenda.csv' with csv header NULL 'NULL';
				COPY campanha (id,version,ativo,sistema,custo_total,descricao,exclusiva,fim,inicio,nome,perene,veiculo_id) FROM '/pinedu/modelo/campanha.csv' with csv header NULL 'NULL';
				COPY faixa_valor (id,version,descricao,padrao,tipo_contrato,valor_final,valor_inicial) FROM '/pinedu/modelo/faixa_valor.csv' with csv header NULL 'NULL';
				COPY midia_tipo (id,version,descricao,nome,sistema,unidade) FROM '/pinedu/modelo/midia_tipo.csv' with csv header NULL 'NULL';
				COPY parametros_sistema (id,version,cidade_id,cidade_corretagem_id,deduzir_despezas_comissoes,dias_devolucao_chaves,dias_expiracao_proposta,dias_limpar_thumb_nails,dias_prox_atu,dias_vistoria_placa,email_password,email_port,email_server,email_ssl,email_username,emails_por_minuto,moeda_avaliacao_id,ordem_fotografia_imovel,percentual_lancamento,percentual_locacao,percentual_venda,regiao_corretagem_id,rodizio_interessado,start_ssl,tamanho_quadro_chaves,tempo_verificar_mensagens,uf_id,validade_imovel_internet,valor_placa,start_tls,sugestao_interesse,wordpress_server,wordpress_path,wordpress_update,tipo_imovel_id,tipo_contrato,verificar_duplicidade_update_imovel,interessado_autocomplete_inativo,relatorio_visita_imprime_proprietario,incluir_interessado_sem_interesse,atualizar_interessado_sem_interesse,bloquear_corretor_automaticamente,dias_bloquear_corretor,ip_empresa,bloquear_login_fora_empresa,enviar_fotos_edificio_portais) FROM '/pinedu/modelo/parametros_sistema.csv' with csv header NULL 'NULL';
				COPY parametro_sistema_comissao ( tipo_contrato, departamento, parametro_sistema_id, percentual ) FROM '/pinedu/modelo/parametro_sistema_comissao.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY parametro_classe_interessado ( classe_interessado_id, parametro_sistema_id, dias ) FROM '/pinedu/modelo/parametro_classe_interessado.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY quadro_chaves (id,version,ativo,descricao,nome,padrao,sistema,tamanho) FROM '/pinedu/modelo/quadro_chaves.csv' with csv header NULL 'NULL';
				COPY quadro_chaves_posicao ( id, posicao, quadro_chaves_id, status, date_created, last_updated ) FROM '/pinedu/modelo/quadro_chaves_posicao.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY texto_sistema (id,version,chave,conteudo,titulo,sistema,ativo) FROM '/pinedu/modelo/texto_sistema.csv' with csv header NULL 'NULL';
				COPY veiculo_comunicacao (id,version,ativo,sistema,date_created,descricao,last_updated,nome,nome_usu_criador,pessoa_id) FROM '/pinedu/modelo/veiculo_comunicacao.csv' with csv header NULL 'NULL';
				""")
			}
		}
	}
	//COPY (SELECT id, replace(encode(binario, 'base64'), E'\n', '\n') AS imagem_base64 FROM arquivo_binario ) TO '/pinedu/modelo/arquivo_stream.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL', FORCE_QUOTE (id, imagem_base64));
	//COPY (SELECT id, version, id_mask, stream_id, mime_type, tamanho, path, nome FROM arquivo ) TO '/pinedu/modelo/arquivo.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL', FORCE_QUOTE (id, id_mask, stream_id, mime_type, path, nome ) );
	//COPY (SELECT user_id, preferencias_elt, preferencias_object, preferencias_idx FROM usuario_preferencias ) TO '/pinedu/modelo/usuario_preferencias.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL', FORCE_QUOTE ( preferencias_elt, preferencias_object, preferencias_idx ) );
	changeSet(author: "eduardo", id: "INIT_USUARIO") {
		grailsChange {
			change {
				sql.execute("""
				COPY regra (id,version,authority,descricao,sistema) FROM '/pinedu/modelo/regra.csv' with csv header NULL 'NULL';
				COPY usuario (id,version,sistema,username,password,pessoa_id,corretor_id,carteira_id,ativar_email,enabled,password_expired,account_expired,account_locked) FROM '/pinedu/modelo/usuario.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY requestmap (id,version,config_attribute,url) FROM '/pinedu/modelo/requestmap.csv' with csv header NULL 'NULL';
				COPY usuario_regra (user_id,role_id) FROM '/pinedu/modelo/usuario_regra.csv' with csv header NULL 'NULL';
				COPY grupo (id,version,sistema,descricao,nome,aplicacao_id,ativo) FROM '/pinedu/modelo/grupo.csv' with csv header NULL 'NULL';
				COPY grupo_regra (grupo_id,role_id) FROM '/pinedu/modelo/grupo_regra.csv' with csv header NULL 'NULL';
				COPY menu (id,version,sistema,icone,mneumonic,nome,selected,dica,aplicacao_id,pai_id,posicao,tipo,administrativo,alinhamento,\"action\",enabled) FROM '/pinedu/modelo/menu.csv' with csv header NULL 'NULL';
				COPY grupo_menu (grupo_id,menu_id) FROM '/pinedu/modelo/grupo_menu.csv' with csv header NULL 'NULL';
				COPY usuario_grupo (user_id,grupo_id) FROM '/pinedu/modelo/usuario_grupo.csv' with csv header NULL 'NULL';
				COPY usuario_menu (user_id,menu_id) FROM '/pinedu/modelo/usuario_menu.csv' with csv header NULL 'NULL';
				COPY usuario_atalho (user_id,menu_id,esquerda,topo) FROM '/pinedu/modelo/usuario_atalho.csv' with csv header NULL 'NULL';
				COPY usuario_preferencias ( user_id,preferencias_elt,preferencias_idx ) FROM '/pinedu/modelo/usuario_preferencias.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				""")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_CIDADECORRETAGEM") {
		grailsChange {
			change {
				sql.execute("""
				COPY bairro_corretagem (id,version,ativo,bairro_id,bairrocp,nome,regiao_id,sistema) FROM '/pinedu/modelo/bairro_corretagem.csv' with csv header NULL 'NULL';
				COPY regiao_corretagem (id,version,ativo,cidade_id,nome,regiaocp,sistema) FROM '/pinedu/modelo/regiao_corretagem.csv' with csv header NULL 'NULL';
				COPY cidade_corretagem (id,version,ativo,cidade_id,cidadecp,nome,sistema,uf_id) FROM '/pinedu/modelo/cidade_corretagem.csv' with csv header NULL 'NULL';
				""")
			}
		}
	}
	//COPY ( SELECT id,relativo,tipo_imovel_id FROM tipo_imovel_relativo ORDER by tipo_imovel_id asc, relativo asc ) TO '/pinedu/modelo/tipo_imovel_relativo.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL', FORCE_QUOTE ( id,relativo ) );
	//COPY ( SELECT dependencia_id,relativo_id,ordem FROM tipo_rel_dep ORDER BY relativo_id asc, ordem asc ) TO '/pinedu/modelo/tipo_rel_dep.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL', FORCE_QUOTE ( relativo_id ) );
	changeSet(author: "eduardo", id: "INIT_TIPOIMOVEL") {
		grailsChange {
			change {
				sql.execute("""
				COPY classe_imovel (id,version,ativo,descricao,nome,padrao,sistema) FROM '/pinedu/modelo/classe_imovel.csv' with csv header NULL 'NULL';
				COPY classe_interessado (id,version,ativo,descricao,nome,padrao,sistema) FROM '/pinedu/modelo/classe_interessado.csv' with csv header NULL 'NULL';
				COPY finalidade_imovel (id,version,ativo,descricao,nome,padrao,sistema) FROM '/pinedu/modelo/finalidade_imovel.csv' with csv header NULL 'NULL';
				COPY tipo_dependencia_itens (id,version,dependencia_id,nome,valor) FROM '/pinedu/modelo/tipo_dependencia_itens.csv' with csv header NULL 'NULL';
				COPY tipo_dependencia (id,version,ativo,dependencia_pai_id,descricao,finalidade_id,nome,ordem,posicao,relativo,sigla,sistema,tipo_campo) FROM '/pinedu/modelo/tipo_dependencia.csv' with csv header NULL 'NULL';
				COPY tipo_imovel ( id, version, ativar_condominio, ativar_edificio, ativar_empreendimento, ativo, campo_area_id, campo_grupo_id, campo_unidade_id, date_created, last_updated, nome, nome_usu_criador, ordem_anuncio, ordem_internet, sigla, siglacp, sistema, texto_anuncio ) FROM '/pinedu/modelo/tipo_imovel.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY tipo_imovel_relativo (id,relativo,tipo_imovel_id) FROM '/pinedu/modelo/tipo_imovel_relativo.csv' with csv header NULL 'NULL';
				COPY tipo_rel_dep (dependencia_id,relativo_id,ordem) FROM '/pinedu/modelo/tipo_rel_dep.csv' with csv header NULL 'NULL';
				COPY segmento_imovel (id, version, sistema, padrao, descricao, nome, ativo) FROM '/pinedu/modelo/segmento_imovel.csv' with csv header NULL 'NULL';
				""")
			}
		}
	}
	//COPY (SELECT user_id, preferencias_elt, preferencias_object, preferencias_idx FROM usuario_preferencias ) TO '/pinedu/modelo/usuario_preferencias.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL', FORCE_QUOTE ( preferencias_elt, preferencias_object, preferencias_idx ) );
	changeSet(author: "eduardo", id: "INIT_ACESSORIOS") {
		grailsChange {
			change {
				sql.execute("""
				COPY nota_promissoria ( id, version, ultima_impressao, date_created, last_updated, nome_usu_criador, emissao, praca, beneficiario_id, observacoes ) FROM '/pinedu/modelo/nota_promissoria.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY nota_promissoria_pessoa ( avalista_id, pessoa_id, emitente_id ) FROM '/pinedu/modelo/nota_promissoria_pessoa.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				COPY nota_promissoria_parcela ( id, version, parcela, valor, nota_id, data ) FROM '/pinedu/modelo/nota_promissoria_parcela.csv' WITH ( FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"', NULL 'NULL' );
				""")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_SEQUENCES") {
		grailsChange {
			change {
				sql.execute("""
					SELECT
						setval('seq_agenda', COALESCE( ( SELECT MAX( id ) FROM agenda ), 1 ) )
						, setval('seq_anuncio', COALESCE( ( SELECT MAX( id ) FROM anuncio ), 1 ) )
						, setval('seq_aplicacao', COALESCE( ( SELECT MAX( id ) FROM aplicacao ), 1 ) )
						, setval('seq_bairro', COALESCE( ( SELECT MAX( id ) FROM bairro ), 1 ) )
						, setval('seq_bairro_corret', COALESCE( ( SELECT MAX( id ) FROM bairro_corretagem ), 1 ) )
						, setval('seq_campanha', COALESCE( ( SELECT MAX( id ) FROM campanha ), 1 ) )
						, setval('seq_carteira_imovel', COALESCE( ( SELECT MAX( id ) FROM carteira_imovel ), 1 ) )
						, setval('seq_cidade', COALESCE( ( SELECT MAX( id ) FROM cidade ), 1 ) )
						, setval('seq_cidade_corret', COALESCE( ( SELECT MAX( id ) FROM cidade_corretagem ), 1 ) )
						, setval('seq_classe_imovel', COALESCE( ( SELECT MAX( id ) FROM classe_imovel ), 1 ) )
						, setval('seq_classe_interessado', COALESCE( ( SELECT MAX( id ) FROM classe_interessado ), 1 ) )
						, setval('seq_concorrente', COALESCE( ( SELECT MAX( id ) FROM concorrente ), 1 ) )
						, setval('seq_condominio', COALESCE( ( SELECT MAX( id ) FROM condominio ), 1 ) )
						, setval('seq_corretor', COALESCE( ( SELECT MAX( id ) FROM corretor ), 1 ) )
						, setval('seq_edificio', COALESCE( ( SELECT MAX( id ) FROM edificio ), 1 ) )
						, setval('seq_empresa', COALESCE( ( SELECT MAX( id ) FROM empresa ), 1 ) )
						, setval('seq_equipe', COALESCE( ( SELECT MAX( id ) FROM equipe ), 1 ) )
						, setval('seq_estado', COALESCE( ( SELECT MAX( id ) FROM estado ), 1 ) )
						, setval('seq_evento', COALESCE( ( SELECT MAX( id ) FROM evento ), 1 ) )
						, setval('seq_finalidade_imovel', COALESCE( ( SELECT MAX( id ) FROM finalidade_imovel ), 1 ) )
						, setval('seq_grupo', COALESCE( ( SELECT MAX( id ) FROM grupo ), 1 ) )
						, setval('seq_imovel', COALESCE( ( SELECT MAX( id ) FROM imovel ), 1 ) )
						, setval('seq_interessado', COALESCE( ( SELECT MAX( id ) FROM interessado ), 1 ) )
						, setval('seq_logradouro', COALESCE( ( SELECT MAX( id ) FROM logradouro ), 1 ) )
						, setval('seq_loja', COALESCE( ( SELECT MAX( id ) FROM loja ), 1 ) )
						, setval('seq_menu', COALESCE( ( SELECT MAX( id ) FROM menu ), 1 ) )
						, setval('seq_midia_tipo', COALESCE( ( SELECT MAX( id ) FROM midia_tipo ), 1 ) )
						, setval('seq_moeda', COALESCE( ( SELECT MAX( id ) FROM moeda ), 1 ) )
						, setval('seq_pessoa', COALESCE( ( SELECT MAX( id ) FROM pessoa ), 1 ) )
						, setval('seq_proposta', COALESCE( ( SELECT MAX( id ) FROM proposta ), 1 ) )
						, setval('seq_quadro_chaves', COALESCE( ( SELECT MAX( id ) FROM quadro_chaves ), 1 ) )
						, setval('seq_regiao_corret', COALESCE( ( SELECT MAX( id ) FROM regiao_corretagem ), 1 ) )
						, setval('seq_regra', COALESCE( ( SELECT MAX( id ) FROM regra ), 1 ) )
						, setval('seq_request_map', COALESCE( ( SELECT MAX( id ) FROM requestmap ), 1 ) )
						, setval('seq_segmento_imovel', COALESCE( ( SELECT MAX( id ) FROM segmento_imovel ), 1 ) )
						, setval('seq_tipo_dependencia', COALESCE( ( SELECT MAX( id ) FROM tipo_dependencia ), 1 ) )
						, setval('seq_tipo_endereco', COALESCE( ( SELECT MAX( id ) FROM tipo_endereco ), 1 ) )
						, setval('seq_tipo_imovel', COALESCE( ( SELECT MAX( id ) FROM tipo_imovel ), 1 ) )
						, setval('seq_tipo_logradouro', COALESCE( ( SELECT MAX( id ) FROM tipo_logradouro ), 1 ) )
						, setval('seq_usuario', COALESCE( ( SELECT MAX( id ) FROM usuario ), 1 ) )
						, setval('seq_veiculo_comunicacao', COALESCE( ( SELECT MAX( id ) FROM veiculo_comunicacao ), 1 ) )
						, setval('seq_venda', COALESCE( ( SELECT MAX( id ) FROM venda ), 1 ) );
				""")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_POS_AJUSTES") {
		grailsChange {
			change {
				sql.execute("""
				UPDATE tipo_imovel SET texto_anuncio = REPLACE(texto_anuncio, '\\n', E'\n');
				UPDATE nota_promissoria SET observacoes = REPLACE(observacoes, '\\n', E'\n');
				UPDATE texto_sistema SET conteudo = REPLACE(conteudo, '\\n', E'\n');
				UPDATE arquivo_binario SET binario = decode( replace( base64, '\\n', E'\\n' ), 'base64' );
				UPDATE cidade SET ativo = true;
				UPDATE bairro SET ativo = true;
				UPDATE logradouro SET ativo = true;
				ALTER TABLE arquivo_binario DROP COLUMN base64;
				""")
			}
		}
	}
}
