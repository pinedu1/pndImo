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
				COPY pessoa (id,version,estado_civil,twitter,sistema,inscricao,date_created,cod_nome_normalizado,last_updated,nome_usu_criador,rg,nome,email_padrao_id,banco_padrao_id,sexo,ativo,foto_id,endereco_padrao_id,bloquear_envio_email,profissao,google_plus,skype,nacionalidade,nascimento_conjuge,cpf_conjuge,cod_nome,codigo,rg_conjuge,telefone_padrao_id,face_book,nome_normalizado,cpf,tipo_pessoa,nome_conjuge,site,rg_data_expedicao,observacoes,rg_orgao_emissor,nascimento) FROM '/pinedu/modelo/pessoa.csv' with csv header;
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
				COPY loja (id,version,sistema,date_created,last_updated,nome_usu_criador,ativo,latitude,atuacao,ip_loja,carteira_id,longitude,codigo,creci,pessoa_id,observacoes) FROM '/pinedu/modelo/loja.csv' with csv header;
				COPY corretor (id,version,sistema,date_created,last_updated,nome_usu_criador,ativo,categoria,corretorcp,codigo,creci,pessoa_id,observacoes) FROM '/pinedu/modelo/corretor.csv' with csv header;
				COPY concorrente (id,version,ativo,codigo,concorrentecp,creci,date_created,last_updated,nome_usu_criador,observacoes,pessoa_id,sistema) FROM '/pinedu/modelo/concorrente.csv' with csv header NULL 'NULL';
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
				COPY quadro_chaves (id,version,ativo,descricao,nome,padrao,sistema,tamanho) FROM '/pinedu/modelo/quadro_chaves.csv' with csv header NULL 'NULL';
				COPY texto_sistema (id,version,chave,conteudo,titulo,sistema,ativo) FROM '/pinedu/modelo/texto_sistema.csv' with csv header NULL 'NULL';
				COPY veiculo_comunicacao (id,version,ativo,sistema,date_created,descricao,last_updated,nome,nome_usu_criador,pessoa_id) FROM '/pinedu/modelo/veiculo_comunicacao.csv' with csv header NULL 'NULL';
				""")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_USUARIO") {
		grailsChange {
			change {
				sql.execute("""
				COPY usuario (id,version,email_port,start_ssl,sistema,ativar_email,corretor_id,password_expired,account_expired,ultimo_login,email_password,carteira_id,start_tls,username,email_server,email_username,account_locked,password,loja_id,ultimo_bloqueio,pessoa_id,email_ssl,enabled,email_remetente,ultimo_login_ip) FROM '/pinedu/modelo/usuario.csv' with csv header;
				COPY grupo (id,version,sistema,descricao,nome) FROM '/pinedu/modelo/grupo.csv' with csv header;
				COPY menu (id,version,sistema,icone,mneumonic,nome,selected,dica,aplicacao_id,pai_id,posicao,tipo,administrativo,alinhamento,\"action\",enabled) FROM '/pinedu/modelo/menu.csv' with csv header NULL 'NULL';
				COPY grupo_menu (grupo_id,menu_id) FROM '/pinedu/modelo/grupo_menu.csv' with csv header;
				COPY usuario_grupo (user_id,grupo_id) FROM '/pinedu/modelo/usuario_grupo.csv' with csv header;
				COPY usuario_menu (user_id,menu_id) FROM '/pinedu/modelo/usuario_menu.csv' with csv header;
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
	changeSet(author: "eduardo", id: "INIT_TIPOIMOVEL") {
		grailsChange {
			change {
				sql.execute("""
				COPY classe_imovel (id,version,ativo,descricao,nome,padrao,sistema) FROM '/pinedu/modelo/classe_imovel.csv' with csv header NULL 'NULL';
				COPY classe_interessado (id,version,ativo,descricao,nome,padrao,sistema) FROM '/pinedu/modelo/classe_interessado.csv' with csv header NULL 'NULL';
				COPY finalidade_imovel (id,version,ativo,descricao,nome,padrao,sistema) FROM '/pinedu/modelo/finalidade_imovel.csv' with csv header NULL 'NULL';
				COPY tipo_dependencia_itens (id,version,dependencia_id,nome,valor) FROM '/pinedu/modelo/tipo_dependencia_itens.csv' with csv header NULL 'NULL';
				COPY tipo_dependencia (id,version,ativo,dependencia_pai_id,descricao,finalidade_id,nome,ordem,posicao,relativo,sigla,sistema,tipo_campo) FROM '/pinedu/modelo/tipo_dependencia.csv' with csv header NULL 'NULL';
				COPY tipo_imovel (id,version,ativar_condominio,ativar_edificio,ativar_empreendimento,ativo,campo_area_id,campo_grupo_id,campo_unidade_id,date_created,last_updated,nome,nome_usu_criador,ordem_anuncio,ordem_internet,sigla,siglacp,sistema,texto_anuncio) FROM '/pinedu/modelo/tipo_imovel.csv' with csv header NULL 'NULL';
				COPY tipo_imovel_relativo (id,relativo,tipo_imovel_id) FROM '/pinedu/modelo/tipo_imovel_relativo.csv' with csv header NULL 'NULL';
				COPY tipo_rel_dep (dependencia_id,relativo_id,ordem) FROM '/pinedu/modelo/tipo_rel_dep.csv' with csv header NULL 'NULL';
				""")
			}
		}
	}
	changeSet(author: "eduardo", id: "INIT_SEQUENCES") {
		grailsChange {
			change {
				sql.execute("""
					SELECT
						setval('seq_agenda', (SELECT MAX( id ) FROM agenda))
						, setval('seq_anuncio', (SELECT MAX( id ) FROM anuncio))
						, setval('seq_aplicacao', (SELECT MAX( id ) FROM aplicacao))
						, setval('seq_bairro', (SELECT MAX( id ) FROM bairro))
						, setval('seq_bairro_corret', (SELECT MAX( id ) FROM bairro_corretagem))
						, setval('seq_banco', (SELECT MAX( id ) FROM banco))
						, setval('seq_campanha', (SELECT MAX( id ) FROM campanha))
						, setval('seq_carteira_imovel', (SELECT MAX( id ) FROM carteira_imovel))
						, setval('seq_cidade', (SELECT MAX( id ) FROM cidade))
						, setval('seq_cidade_corret', (SELECT MAX( id ) FROM cidade_corretagem))
						, setval('seq_classe_imovel', (SELECT MAX( id ) FROM classe_imovel))
						, setval('seq_classe_interessado', (SELECT MAX( id ) FROM classe_interessado))
						, setval('seq_concorrente', (SELECT MAX( id ) FROM concorrente))
						, setval('seq_condominio', (SELECT MAX( id ) FROM condominio))
						, setval('seq_contrato_exclusividade', (SELECT MAX( id ) FROM contrato_exclusividade))
						, setval('seq_corretor', (SELECT MAX( id ) FROM corretor))
						, setval('seq_edificio', (SELECT MAX( id ) FROM edificio))
						, setval('seq_empresa', (SELECT MAX( id ) FROM empresa))
						, setval('seq_equipe', (SELECT MAX( id ) FROM equipe))
						, setval('seq_estado', (SELECT MAX( id ) FROM estado))
						, setval('seq_evento', (SELECT MAX( id ) FROM evento))
						, setval('seq_finalidade_imovel', (SELECT MAX( id ) FROM finalidade_imovel))
						, setval('seq_grupo', (SELECT MAX( id ) FROM grupo))
						, setval('seq_imovel', (SELECT MAX( id ) FROM imovel))
						, setval('seq_interessado', (SELECT MAX( id ) FROM interessado))
						, setval('seq_logradouro', (SELECT MAX( id ) FROM logradouro))
						, setval('seq_loja', (SELECT MAX( id ) FROM loja))
						, setval('seq_menu', (SELECT MAX( id ) FROM menu))
						, setval('seq_midia_tipo', (SELECT MAX( id ) FROM midia_tipo))
						, setval('seq_moeda', (SELECT MAX( id ) FROM moeda))
						, setval('seq_pessoa', (SELECT MAX( id ) FROM pessoa))
						, setval('seq_proposta', (SELECT MAX( id ) FROM proposta))
						, setval('seq_quadro_chaves', (SELECT MAX( id ) FROM quadro_chaves))
						, setval('seq_regiao_corret', (SELECT MAX( id ) FROM regiao_corretagem))
						, setval('seq_regra', (SELECT MAX( id ) FROM regra))
						, setval('seq_request_map', (SELECT MAX( id ) FROM requestmap))
						, setval('seq_segmento_imovel', (SELECT MAX( id ) FROM segmento_imovel))
						, setval('seq_tipo_dependencia', (SELECT MAX( id ) FROM tipo_dependencia))
						, setval('seq_tipo_endereco', (SELECT MAX( id ) FROM tipo_endereco))
						, setval('seq_tipo_imovel', (SELECT MAX( id ) FROM tipo_imovel))
						, setval('seq_tipo_logradouro', (SELECT MAX( id ) FROM tipo_logradouro))
						, setval('seq_usuario', (SELECT MAX( id ) FROM usuario))
						, setval('seq_veiculo_comunicacao', (SELECT MAX( id ) FROM veiculo_comunicacao))
						, setval('seq_venda', (SELECT MAX( id ) FROM venda));
				""")
			}
		}
	}
}