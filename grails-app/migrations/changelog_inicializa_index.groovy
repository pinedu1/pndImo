databaseChangeLog = {
	changeSet(author: "eduardo", id: "INICIAL_SETUP_UNIQUE") {
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_ANUNCIOCODIGO_COL", tableName: "anuncio")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_APLICACAOCODIGO_COL", tableName: "aplicacao")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_APLICACAONOME_COL", tableName: "aplicacao")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_CARTEIRA_IMOVELNOME_COL", tableName: "carteira_imovel")
		addUniqueConstraint(columnNames: "cep1f", constraintName: "UC_CIDADECEP1F_COL", tableName: "cidade")
		addUniqueConstraint(columnNames: "cep1i", constraintName: "UC_CIDADECEP1I_COL", tableName: "cidade")
		addUniqueConstraint(columnNames: "cep2f", constraintName: "UC_CIDADECEP2F_COL", tableName: "cidade")
		addUniqueConstraint(columnNames: "cep2i", constraintName: "UC_CIDADECEP2I_COL", tableName: "cidade")
		addUniqueConstraint(columnNames: "cep", constraintName: "UC_CIDADECEP_COL", tableName: "cidade")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_CIDADE_CORRETAGEMNOME_COL", tableName: "cidade_corretagem")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_CLASSE_IMOVELNOME_COL", tableName: "classe_imovel")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_CLASSE_INTERESSADONOME_COL", tableName: "classe_interessado")
		addUniqueConstraint(columnNames: "email", constraintName: "UC_CLIENTEEMAIL_COL", tableName: "cliente")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_CONCORRENTECODIGO_COL", tableName: "concorrente")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_CONDOMINIOCODIGO_COL", tableName: "condominio")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_CORRETORCODIGO_COL", tableName: "corretor")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_EDIFICIOCODIGO_COL", tableName: "edificio")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_EQUIPENOME_COL", tableName: "equipe")
		addUniqueConstraint(columnNames: "cep1f", constraintName: "UC_ESTADOCEP1F_COL", tableName: "estado")
		addUniqueConstraint(columnNames: "cep1i", constraintName: "UC_ESTADOCEP1I_COL", tableName: "estado")
		addUniqueConstraint(columnNames: "cep2f", constraintName: "UC_ESTADOCEP2F_COL", tableName: "estado")
		addUniqueConstraint(columnNames: "cep2i", constraintName: "UC_ESTADOCEP2I_COL", tableName: "estado")
		addUniqueConstraint(columnNames: "chavedne", constraintName: "UC_ESTADOCHAVEDNE_COL", tableName: "estado")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_ESTADONOME_COL", tableName: "estado")
		addUniqueConstraint(columnNames: "uf", constraintName: "UC_ESTADOUF_COL", tableName: "estado")
		addUniqueConstraint(columnNames: "tipo", constraintName: "UC_FICHA_COMPRADA_CCI_TITIPO_COL", tableName: "ficha_comprada_cci_ti")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_FINALIDADE_IMOVELNOME_COL", tableName: "finalidade_imovel")
		addUniqueConstraint(columnNames: "referencia", constraintName: "UC_IMOVELREFERENCIA_COL", tableName: "imovel")
		addUniqueConstraint(columnNames: "tag", constraintName: "UC_IMOVEL_WEB_TAGTAG_COL", tableName: "imovel_web_tag")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_INTERESSADOCODIGO_COL", tableName: "interessado")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_LOJACODIGO_COL", tableName: "loja")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_MOEDACODIGO_COL", tableName: "moeda")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_PESSOACODIGO_COL", tableName: "pessoa")
		addUniqueConstraint(columnNames: "codigo", constraintName: "UC_PROPOSTACODIGO_COL", tableName: "proposta")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_QUADRO_CHAVESNOME_COL", tableName: "quadro_chaves")
		addUniqueConstraint(columnNames: "authority", constraintName: "UC_REGRAAUTHORITY_COL", tableName: "regra")
		addUniqueConstraint(columnNames: "nome", constraintName: "UC_SEGMENTO_IMOVELNOME_COL", tableName: "segmento_imovel")
		addUniqueConstraint(columnNames: "contexto", constraintName: "UC_TENANTCONTEXTO_COL", tableName: "tenant")
		addUniqueConstraint(columnNames: "sigla", constraintName: "UC_TIPO_DEPENDENCIASIGLA_COL", tableName: "tipo_dependencia")
		addUniqueConstraint(columnNames: "chavedne", constraintName: "UC_TIPO_LOGRADOUROCHAVEDNE_COL", tableName: "tipo_logradouro")
		addUniqueConstraint(columnNames: "tag", constraintName: "UC_TIQUE_IMOVEL_TAGTAG_COL", tableName: "tique_imovel_tag")
		addUniqueConstraint(columnNames: "tipo_imovel_id", constraintName: "UC_TIQUE_IMOVEL_TIPO_IMOVELTIPO_IMOVEL_ID_COL", tableName: "tique_imovel_tipo_imovel")
		addUniqueConstraint(columnNames: "username", constraintName: "UC_USUARIOUSERNAME_COL", tableName: "usuario")
		addUniqueConstraint(columnNames: "tipo_imovel_id", constraintName: "UC_VIVA_REAL_TIPO_IMOVELTIPO_IMOVEL_ID_COL", tableName: "viva_real_tipo_imovel")
		addUniqueConstraint(columnNames: "tipo_imovel_id", constraintName: "UC_ZAP_TIPO_IMOVELTIPO_IMOVEL_ID_COL", tableName: "zap_tipo_imovel")
		addUniqueConstraint(columnNames: "http_method, url", constraintName: "UK3d11b687954e6645e90db4e23cb4", tableName: "requestmap")
	}
	changeSet(author: "eduardo", id: "INICIAL_SETUP_INDEXES") {
		createIndex(indexName: "idxAcompDtCria", tableName: "acompanhamento") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxAcompImoImo", tableName: "acompanhamento") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxAcompIntInt", tableName: "acompanhamento") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxAcompPropProp", tableName: "acompanhamento") {
			column(name: "proposta_id")
		}
		createIndex(indexName: "idxAcompTit", tableName: "acompanhamento") {
			column(name: "titulo")
		}
		createIndex(indexName: "idxAcompVndVnd", tableName: "acompanhamento") {
			column(name: "venda_id")
		}
		createIndex(indexName: "idxAgCorp", tableName: "agenda") {
			column(name: "corporativa")
		}
		createIndex(indexName: "idxAgGrup", tableName: "agenda") {
			column(name: "grupo_id")
		}
		createIndex(indexName: "idxAgNom", tableName: "agenda") {
			column(name: "nome")
		}
		createIndex(indexName: "idxAgUsr", tableName: "agenda") {
			column(name: "user_id")
		}
		createIndex(indexName: "idxAnunCamp", tableName: "anuncio") {
			column(name: "campanha_id")
		}
		createIndex(indexName: "idxAnunCart", tableName: "anuncio") {
			column(name: "carteira_id")
		}
		createIndex(indexName: "idxAnunImoAnu", tableName: "anuncio_imovel") {
			column(name: "anuncio_id")
		}
		createIndex(indexName: "idxAnunImoAtiv", tableName: "anuncio_imovel") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxAnunImoImo", tableName: "anuncio_imovel") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxAnunLoja", tableName: "anuncio") {
			column(name: "loja_id")
		}
		createIndex(indexName: "idxAnunVeic", tableName: "anuncio") {
			column(name: "veiculacao")
		}
		createIndex(indexName: "idxArqNome", tableName: "arquivo") {
			column(name: "nome")
		}
		createIndex(indexName: "idxBaiChaveDNE", tableName: "bairro") {
			column(name: "chavedne")
		}
		createIndex(indexName: "idxBaiCid", tableName: "bairro") {
			column(name: "cidade_id")
		}
		createIndex(indexName: "idxBaiDis", tableName: "bairro") {
			column(name: "distrito_id")
		}
		createIndex(indexName: "idxBaiNome", tableName: "bairro") {
			column(name: "nome")
		}
		createIndex(indexName: "idxBairCorretBai", tableName: "bairro_corretagem") {
			column(name: "bairro_id")
		}
		createIndex(indexName: "idxBairCorretNome", tableName: "bairro_corretagem") {
			column(name: "nome")
		}
		createIndex(indexName: "idxBairCorretReg", tableName: "bairro_corretagem") {
			column(name: "regiao_id")
		}
		createIndex(indexName: "idxBairroNomeNormalizado", tableName: "bairro") {
			column(name: "nome_normalizado")
		}
		createIndex(indexName: "idxCamVei", tableName: "campanha") {
			column(name: "veiculo_id")
		}
		createIndex(indexName: "idxCanal", tableName: "email_background") {
			column(name: "canal")
		}
		createIndex(indexName: "idxCartImovAtiv", tableName: "carteira_imovel") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxChDevPosCh", tableName: "chaves_devolver") {
			column(name: "chaves_id")
		}
		createIndex(indexName: "idxChDevPosImo", tableName: "chaves_devolver") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxChDevPosSt", tableName: "chaves_devolver") {
			column(name: "status_imovel")
		}
		createIndex(indexName: "idxCidCep", tableName: "cidade", unique: "true") {
			column(name: "cep")
		}
		createIndex(indexName: "idxCidChaveDNE", tableName: "cidade") {
			column(name: "chavedne")
		}
		createIndex(indexName: "idxCidCorretUf", tableName: "cidade_corretagem") {
			column(name: "uf_id")
		}
		createIndex(indexName: "idxCidNome", tableName: "cidade") {
			column(name: "nome")
		}
		createIndex(indexName: "idxCidSit", tableName: "cidade") {
			column(name: "situacao")
		}
		createIndex(indexName: "idxCidTipo", tableName: "cidade") {
			column(name: "tipo")
		}
		createIndex(indexName: "idxCidUF", tableName: "cidade") {
			column(name: "uf_id")
		}
		createIndex(indexName: "idxCidadeNomeNormalizado", tableName: "cidade") {
			column(name: "nome_normalizado")
		}
		createIndex(indexName: "idxClasImoAtiv", tableName: "classe_imovel") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxClasIntAtiv", tableName: "classe_interessado") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxCliCook", tableName: "cliente") {
			column(name: "cookie")
		}
		createIndex(indexName: "idxCliTenProp", tableName: "tenant_properties") {
			column(name: "cliente_id")
		}
		createIndex(indexName: "idxCliTenChave", tableName: "tenant_properties") {
			column(name: "chave")
		}
		createIndex(indexName: "idxClienteHash", tableName: "cliente") {
			column(name: "hash")
		}
		createIndex(indexName: "idxCodNome", tableName: "pessoa") {
			column(name: "cod_nome")
		}
		createIndex(indexName: "idxConcAtivo", tableName: "concorrente") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxConcCreci", tableName: "concorrente") {
			column(name: "creci")
		}
		createIndex(indexName: "idxConcPes", tableName: "concorrente") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxCondAdm", tableName: "condominio") {
			column(name: "administradora_id")
		}
		createIndex(indexName: "idxCondNome", tableName: "condominio") {
			column(name: "nome")
		}
		createIndex(indexName: "idxCondNomeNormalizado", tableName: "condominio") {
			column(name: "nome_normalizado")
		}
		createIndex(indexName: "idxCondPes", tableName: "condominio") {
			column(name: "pessoa_juridica_id")
		}
		createIndex(indexName: "idxCondSind", tableName: "condominio") {
			column(name: "sindico_id")
		}
		createIndex(indexName: "idxConfig", tableName: "email_background") {
			column(name: "config")
		}
		createIndex(indexName: "idxCorrAtivo", tableName: "corretor") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxCorrCreci", tableName: "corretor") {
			column(name: "creci")
		}
		createIndex(indexName: "idxCorrPes", tableName: "corretor") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxCpf", tableName: "pessoa") {
			column(name: "cpf")
		}
		createIndex(indexName: "idxCpfConj", tableName: "pessoa") {
			column(name: "cpf_conjuge")
		}
		createIndex(indexName: "idxDepCond", tableName: "imovel_dependencia") {
			column(name: "condominio_id")
		}
		createIndex(indexName: "idxDepEdif", tableName: "imovel_dependencia") {
			column(name: "edificio_id")
		}
		createIndex(indexName: "idxDepImo", tableName: "imovel_dependencia") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxDepTipDep", tableName: "imovel_dependencia") {
			column(name: "tipo_dependencia_id")
		}
		createIndex(indexName: "idxDistCid", tableName: "cidade") {
			column(name: "cidade_pai_id")
		}
		createIndex(indexName: "idxDptoComisCor", tableName: "venda_departamento_comissao") {
			column(name: "corretor_id")
		}
		createIndex(indexName: "idxDptoComisDep", tableName: "venda_departamento_comissao") {
			column(name: "departamento")
		}
		createIndex(indexName: "idxDptoComisPes", tableName: "venda_departamento_comissao") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxDptoComisVnd", tableName: "venda_departamento_comissao") {
			column(name: "venda_id")
		}
		createIndex(indexName: "idxEdiModelDepEdif", tableName: "edificio_modelo_dependencia") {
			column(name: "edificio_id")
		}
		createIndex(indexName: "idxEdiModelDepTipDep", tableName: "edificio_modelo_dependencia") {
			column(name: "tipo_dependencia_id")
		}
		createIndex(indexName: "idxEdiModelDepValBooDep", tableName: "edificio_modelo_dependencia") {
			column(name: "valor_boolean")
		}
		createIndex(indexName: "idxEdiModelDepValFloDep", tableName: "edificio_modelo_dependencia") {
			column(name: "valor_float")
		}
		createIndex(indexName: "idxEdiModelDepValIntDep", tableName: "edificio_modelo_dependencia") {
			column(name: "valor_inteiro")
		}
		createIndex(indexName: "idxEdiModelDepValMulDep", tableName: "edificio_modelo_dependencia") {
			column(name: "valor_multiplo")
		}
		createIndex(indexName: "idxEdiModelDepValTxtDep", tableName: "edificio_modelo_dependencia") {
			column(name: "valor_texto")
		}
		createIndex(indexName: "idxEdifCond", tableName: "edificio") {
			column(name: "condominio_id")
		}
		createIndex(indexName: "idxEdifNome", tableName: "edificio") {
			column(name: "nome")
		}
		createIndex(indexName: "idxEdifNomeNormalizado", tableName: "edificio") {
			column(name: "nome_normalizado")
		}
		createIndex(indexName: "idxEdifSind", tableName: "edificio") {
			column(name: "zelador_id")
		}
		createIndex(indexName: "idxEdifSindico", tableName: "edificio") {
			column(name: "sindico_id")
		}
		createIndex(indexName: "idxEdifTipPad", tableName: "edificio") {
			column(name: "tipo_imovel_padrao_id")
		}
		createIndex(indexName: "idxEmaUsuResp", tableName: "email_background") {
			column(name: "usuario_responsavel_id")
		}
		createIndex(indexName: "idxEmailBackStt", tableName: "email_background") {
			column(name: "status_envio")
		}
		createIndex(indexName: "idxEmailBackTent", tableName: "email_background") {
			column(name: "tentativa_envio")
		}
		createIndex(indexName: "idxEmpPes", tableName: "empresa") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxEquiAtiv", tableName: "equipe") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxEquiNome", tableName: "equipe") {
			column(name: "nome")
		}
		createIndex(indexName: "idxEquiNomeNorm", tableName: "equipe") {
			column(name: "nome_normalizado")
		}
		createIndex(indexName: "idxEquiCart", tableName: "equipe") {
			column(name: "carteira_id")
		}
		createIndex(indexName: "idxEquiLoj", tableName: "equipe") {
			column(name: "loja_id")
		}
		createIndex(indexName: "idxEquiSig", tableName: "equipe") {
			column(name: "sigla")
		}
		createIndex(indexName: "idxEquiSis", tableName: "equipe") {
			column(name: "sistema")
		}
		createIndex(indexName: "idxEquiGetPrin", tableName: "equipe_gerente") {
			column(name: "principal")
		}
		createIndex(indexName: "idxEvtAgen", tableName: "evento") {
			column(name: "agenda_id")
		}
		createIndex(indexName: "idxEvtFim", tableName: "evento") {
			column(name: "data_final")
		}
		createIndex(indexName: "idxEvtIm", tableName: "evento") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxEvtIni", tableName: "evento") {
			column(name: "data_inicio")
		}
		createIndex(indexName: "idxEvtInt", tableName: "evento") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxEvtJob", tableName: "evento") {
			column(name: "job")
		}
		createIndex(indexName: "idxEvtLmbm", tableName: "evento") {
			column(name: "lembre_me")
		}
		createIndex(indexName: "idxEvtLmbt", tableName: "evento") {
			column(name: "ultimo_lembrete")
		}
		createIndex(indexName: "idxEvtProp", tableName: "evento") {
			column(name: "proposta_id")
		}
		createIndex(indexName: "idxEvtTit", tableName: "evento") {
			column(name: "titulo")
		}
		createIndex(indexName: "idxEvtUsr", tableName: "evento") {
			column(name: "user_id")
		}
		createIndex(indexName: "idxEvtVnd", tableName: "evento") {
			column(name: "venda_id")
		}
		createIndex(indexName: "idxFichaCompCCIAcod", tableName: "ficha_comprada_cci_importados") {
			column(name: "acodigos")
		}
		createIndex(indexName: "idxFinImovAtiv", tableName: "finalidade_imovel") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxFxValTipCtr", tableName: "faixa_valor") {
			column(name: "tipo_contrato")
		}
		createIndex(indexName: "idxImoAnoConst", tableName: "imovel") {
			column(name: "ano_construcao")
		}
		createIndex(indexName: "idxImoAtu", tableName: "imovel_contrato") {
			column(name: "valor")
			column(name: "data_atualizacao")
		}
		createIndex(indexName: "idxImoAval", tableName: "imovel") {
			column(name: "avaliacao_id")
		}
		createIndex(indexName: "idxImoCapCap", tableName: "imovel_captacao") {
			column(name: "captador_id")
			column(name: "principal")
		}
		createIndex(indexName: "idxImoCapImo", tableName: "imovel_captacao") {
			column(name: "imovel_id")
			column(name: "captador_id")
			column(name: "principal")
		}
		createIndex(indexName: "idxImoCapMovCor", tableName: "imovel_captacao_movimento") {
			column(name: "corretor_id")
		}
		createIndex(indexName: "idxImoCapMovDt", tableName: "imovel_captacao_movimento") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxImoCapMovImo", tableName: "imovel_captacao_movimento") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxImoCapMovMov", tableName: "imovel_captacao_movimento") {
			column(name: "movimento")
		}
		createIndex(indexName: "idxImoCapMovPerc", tableName: "imovel_captacao_movimento") {
			column(name: "percentual")
		}
		createIndex(indexName: "idxImoCapPrin", tableName: "imovel_captacao") {
			column(name: "principal")
		}
		createIndex(indexName: "idxImoCarteira", tableName: "imovel") {
			column(name: "carteira_id")
		}
		createIndex(indexName: "idxImoChaCam", tableName: "imovel_chamado") {
			column(name: "campanha_id")
		}
		createIndex(indexName: "idxImoChaDtCre", tableName: "imovel_chamado") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxImoChaImo", tableName: "imovel_chamado") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxImoChaInt", tableName: "imovel_chamado") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxImoCond", tableName: "imovel") {
			column(name: "condominio_id")
		}
		createIndex(indexName: "idxImoCondo", tableName: "imovel") {
			column(name: "valor_condominio")
		}
		createIndex(indexName: "idxImoCtr", tableName: "imovel_contrato") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxImoCtrCtr", tableName: "imovel_contrato") {
			column(name: "tipo_contrato")
			column(name: "valor")
		}
		createIndex(indexName: "idxImoCtrSlug", tableName: "imovel_contrato") {
			column(name: "slug")
		}
		createIndex(indexName: "idxImoCtrVal", tableName: "imovel_contrato") {
			column(name: "valor")
		}
		createIndex(indexName: "idxImoDtCap", tableName: "imovel") {
			column(name: "data_captacao")
		}
		createIndex(indexName: "idxImoEdif", tableName: "imovel") {
			column(name: "edificio_id")
		}
		createIndex(indexName: "idxImoEnd", tableName: "imovel") {
			column(name: "endereco_id")
		}
		createIndex(indexName: "idxImoEndApt", tableName: "imovel_endereco") {
			column(name: "apartamento")
		}
		createIndex(indexName: "idxImoEndBairro", tableName: "imovel_endereco") {
			column(name: "bairro")
		}
		createIndex(indexName: "idxImoEndBairroCorr", tableName: "imovel_endereco") {
			column(name: "bairro_corretagem_id")
		}
		createIndex(indexName: "idxImoEndBloc", tableName: "imovel_endereco") {
			column(name: "bloco")
		}
		createIndex(indexName: "idxImoEndCep", tableName: "imovel_endereco") {
			column(name: "cep")
		}
		createIndex(indexName: "idxImoEndCid", tableName: "imovel_endereco") {
			column(name: "cidade")
		}
		createIndex(indexName: "idxImoEndLastGeo", tableName: "imovel_endereco") {
			column(name: "ultima_verificacao_geocode")
		}
		createIndex(indexName: "idxImoEndLogId", tableName: "imovel_endereco") {
			column(name: "logradourodne_id")
		}
		createIndex(indexName: "idxImoEndNomeLog", tableName: "imovel_endereco") {
			column(name: "logradouro")
		}
		createIndex(indexName: "idxImoEndNomeLogNormalizado", tableName: "imovel_endereco") {
			column(name: "logradouro_normalizado")
		}
		createIndex(indexName: "idxImoEndNum", tableName: "imovel_endereco") {
			column(name: "numero")
		}
		createIndex(indexName: "idxImoEndPad", tableName: "imovel_endereco") {
			column(name: "padronizado")
		}
		createIndex(indexName: "idxImoEndUf", tableName: "imovel_endereco") {
			column(name: "estado")
		}
		createIndex(indexName: "idxImoEndZon", tableName: "imovel_endereco") {
			column(name: "zoneamento")
		}
		createIndex(indexName: "idxImoEvoCtr", tableName: "imovel_evolucao_preco") {
			column(name: "tipo_contrato")
		}
		createIndex(indexName: "idxImoEvoDtCria", tableName: "imovel_evolucao_preco") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxImoEvoImo", tableName: "imovel_evolucao_preco") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxImoEvoValAnt", tableName: "imovel_evolucao_preco") {
			column(name: "valor_antigo")
		}
		createIndex(indexName: "idxImoEvoValNov", tableName: "imovel_evolucao_preco") {
			column(name: "valor_novo")
		}
		createIndex(indexName: "idxImoExcDtExc", tableName: "imovel_exclusao") {
			column(name: "data_exclusao")
		}
		createIndex(indexName: "idxImoExcImoConc", tableName: "imovel_exclusao") {
			column(name: "concorrente_id")
		}
		createIndex(indexName: "idxImoExcImoCorr", tableName: "imovel_exclusao") {
			column(name: "corretor_responsavel_id")
		}
		createIndex(indexName: "idxImoExclusividade", tableName: "imovel") {
			column(name: "exclusividade_id")
		}
		createIndex(indexName: "idxImoFilCond", tableName: "imovel_filme") {
			column(name: "condominio_id")
		}
		createIndex(indexName: "idxImoFilEdif", tableName: "imovel_filme") {
			column(name: "edificio_id")
		}
		createIndex(indexName: "idxImoFilImo", tableName: "imovel_filme") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxImoFilUrl", tableName: "imovel_filme") {
			column(name: "url")
		}
		createIndex(indexName: "idxImoFin", tableName: "imovel") {
			column(name: "finalidade_id")
		}
		createIndex(indexName: "idxImoFotArq", tableName: "imovel_foto") {
			column(name: "foto_id")
		}
		createIndex(indexName: "idxImoFotCond", tableName: "imovel_foto") {
			column(name: "condominio_id")
		}
		createIndex(indexName: "idxImoFotDstk", tableName: "imovel_foto") {
			column(name: "destaque")
		}
		createIndex(indexName: "idxImoFotEdif", tableName: "imovel_foto") {
			column(name: "edificio_id")
		}
		createIndex(indexName: "idxImoFotImo", tableName: "imovel_foto") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxImoIndicador", tableName: "imovel") {
			column(name: "indicador_id")
		}
		createIndex(indexName: "idxImoIntCha", tableName: "imovel_interessado_chamado") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxImoIptu", tableName: "imovel") {
			column(name: "valor_iptu")
		}
		createIndex(indexName: "idxImoLj", tableName: "imovel") {
			column(name: "loja_id")
		}
		createIndex(indexName: "idxImoLstUpt", tableName: "imovel") {
			column(name: "last_updated")
		}
		createIndex(indexName: "idxImoMatAgua", tableName: "imovel") {
			column(name: "matricula_agua")
		}
		createIndex(indexName: "idxImoMatEner", tableName: "imovel") {
			column(name: "matricula_energia")
		}
		createIndex(indexName: "idxImoMatGaz", tableName: "imovel") {
			column(name: "matricula_gaz")
		}
		createIndex(indexName: "idxImoMatIPTU", tableName: "imovel") {
			column(name: "matriculaiptu")
		}
		createIndex(indexName: "idxImoNovo", tableName: "imovel") {
			column(name: "novo")
		}
		createIndex(indexName: "idxImoPadConst", tableName: "imovel") {
			column(name: "padrao_construcao")
		}
		createIndex(indexName: "idxImoPermitPlac", tableName: "imovel") {
			column(name: "permite_placa")
		}
		createIndex(indexName: "idxImoPlacaAnun", tableName: "imovel_placa") {
			column(name: "anuncio_id")
		}
		createIndex(indexName: "idxImoPlacaAtiv", tableName: "imovel_placa") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxImoPlacaCod", tableName: "imovel_placa") {
			column(name: "codigo_placa")
		}
		createIndex(indexName: "idxImoPlacaCol", tableName: "imovel_placa") {
			column(name: "colocacao")
		}
		createIndex(indexName: "idxImoPlacaCor", tableName: "imovel_placa_corretor") {
			column(name: "imovel_placa_corretores_id")
		}
		createIndex(indexName: "idxImoPlacaLoja", tableName: "imovel_placa") {
			column(name: "loja_id")
		}
		createIndex(indexName: "idxImoPlacaProxVis", tableName: "imovel_placa") {
			column(name: "proxima_vistoria")
		}
		createIndex(indexName: "idxImoPlacaRetirar", tableName: "imovel_placa") {
			column(name: "retirar_id")
		}
		createIndex(indexName: "idxImoPlacaUltVis", tableName: "imovel_placa") {
			column(name: "ultima_vistoria")
		}
		createIndex(indexName: "idxImoPlacaVal", tableName: "imovel_placa") {
			column(name: "valor_placa")
		}
		createIndex(indexName: "idxImoPro", tableName: "imovel") {
			column(name: "proprietario_id")
		}
		createIndex(indexName: "idxImoPromIMo", tableName: "imovel_promocao") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxImoPromLoja", tableName: "imovel_promocao") {
			column(name: "loja_id")
		}
		createIndex(indexName: "idxImoPromTipCtr", tableName: "imovel_promocao") {
			column(name: "tipo_contrato")
		}
		createIndex(indexName: "idxImoPropCli", tableName: "imovel_proprietario") {
			column(name: "cliente_id")
		}
		createIndex(indexName: "idxImoPropEma", tableName: "imovel_proprietario") {
			column(name: "email")
		}
		createIndex(indexName: "idxImoPropNom", tableName: "imovel_proprietario") {
			column(name: "nome")
		}
		createIndex(indexName: "idxImoPropPes", tableName: "imovel_proprietario") {
			column(name: "proprietario_id")
		}
		createIndex(indexName: "idxImoPropTel", tableName: "imovel_proprietario") {
			column(name: "telefone")
		}
		createIndex(indexName: "idxImoProxAtu", tableName: "imovel_contrato") {
			column(name: "valor")
			column(name: "prox_atualizacao")
		}
		createIndex(indexName: "idxImoSaldo", tableName: "imovel") {
			column(name: "saldo_id")
		}
		createIndex(indexName: "idxImoSeg", tableName: "imovel") {
			column(name: "segmento_id")
		}
		createIndex(indexName: "idxImoStatus", tableName: "imovel") {
			column(name: "status_imovel")
		}
		createIndex(indexName: "idxImoTipoImovel", tableName: "imovel") {
			column(name: "tipo_imovel_id")
		}
		createIndex(indexName: "idxImoUni", tableName: "imovel") {
			column(name: "permite_unidades")
		}
		createIndex(indexName: "idxImoWeb", tableName: "imovel") {
			column(name: "enviar_web")
		}
		createIndex(indexName: "idxImoWebImo", tableName: "imovel_web_imovel") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxImoWebTpImoCatTip", tableName: "imovel_web_tipo_imovel_categoria") {
			column(name: "tipo_imovel_id")
		}
		createIndex(indexName: "idxIntAtivo", tableName: "interessado") {
			column(name: "ativo")
			column(name: "loja_id")
		}
		createIndex(indexName: "idxIntCamp", tableName: "interessado") {
			column(name: "campanha_id")
		}
		createIndex(indexName: "idxIntCha", tableName: "interessado") {
			column(name: "imovel_chamado_id")
		}
		createIndex(indexName: "idxIntCla", tableName: "interessado") {
			column(name: "classificacao_id")
		}
		createIndex(indexName: "idxIntCliente", tableName: "interessado") {
			column(name: "cliente_id")
		}
		createIndex(indexName: "idxIntCook", tableName: "interessado") {
			column(name: "cookie")
		}
		createIndex(indexName: "idxIntCor", tableName: "interessado") {
			column(name: "corretor_id")
		}
		createIndex(indexName: "idxIntCria", tableName: "interessado") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxIntEmaEnd", tableName: "interessado_email") {
			column(name: "endereco")
		}
		createIndex(indexName: "idxIntEmaNome", tableName: "interessado_email") {
			column(name: "nome")
		}
		createIndex(indexName: "idxIntEndBai", tableName: "interessado_endereco") {
			column(name: "bairro")
		}
		createIndex(indexName: "idxIntEndCep", tableName: "interessado_endereco") {
			column(name: "cep")
		}
		createIndex(indexName: "idxIntEndCid", tableName: "interessado_endereco") {
			column(name: "cidade")
		}
		createIndex(indexName: "idxIntEndCompl", tableName: "interessado_endereco") {
			column(name: "complemento")
		}
		createIndex(indexName: "idxIntEndInt", tableName: "interessado_endereco") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxIntEndLog", tableName: "interessado_endereco") {
			column(name: "logradouro")
		}
		createIndex(indexName: "idxIntEndLogDNE", tableName: "interessado_endereco") {
			column(name: "logradourodne_id")
		}
		createIndex(indexName: "idxIntEndNum", tableName: "interessado_endereco") {
			column(name: "numero")
		}
		createIndex(indexName: "idxIntEndTip", tableName: "interessado_endereco") {
			column(name: "tipo")
		}
		createIndex(indexName: "idxIntEndUf", tableName: "interessado_endereco") {
			column(name: "uf")
		}
		createIndex(indexName: "idxIntExcCon", tableName: "interessado_exclusao") {
			column(name: "concorrente_id")
		}
		createIndex(indexName: "idxIntExcCor", tableName: "interessado_exclusao") {
			column(name: "corretor_id")
		}
		createIndex(indexName: "idxIntExcDtCria", tableName: "interessado_exclusao") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxIntExcDtTrans", tableName: "interessado_exclusao") {
			column(name: "data_transacao")
		}
		createIndex(indexName: "idxIntExcImo", tableName: "interessado_exclusao") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxIntExcInstExc", tableName: "interessado_exclusao_instantaneo") {
			column(name: "exclusao_id")
		}
		createIndex(indexName: "idxIntExcInstImo", tableName: "interessado_exclusao_instantaneo") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxIntExcInstRef", tableName: "interessado_exclusao_instantaneo") {
			column(name: "referencia")
		}
		createIndex(indexName: "idxIntExcInt", tableName: "interessado_exclusao") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxIntExcValTans", tableName: "interessado_exclusao") {
			column(name: "valor_transacao")
		}
		createIndex(indexName: "idxIntGer", tableName: "interessado") {
			column(name: "gerente_id")
		}
		createIndex(indexName: "idxIntNome", tableName: "interessado") {
			column(name: "nome")
		}
		createIndex(indexName: "idxIntNomeConj", tableName: "interessado") {
			column(name: "nome_conjuge")
		}
		createIndex(indexName: "idxIntNomeNormalizado", tableName: "interessado") {
			column(name: "nome_normalizado")
		}
		createIndex(indexName: "idxIntOfeCorretor", tableName: "interessado_oferta") {
			column(name: "corretor_id")
		}
		createIndex(indexName: "idxIntOfeDateCreated", tableName: "interessado_oferta") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxIntOfeImovel", tableName: "interessado_oferta") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxIntOfeInteressado", tableName: "interessado_oferta") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxIntOfeTipoOferta", tableName: "interessado_oferta") {
			column(name: "tipo_oferta")
		}
		createIndex(indexName: "idxIntPes", tableName: "interessado") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxIntRecbEmail", tableName: "interessado") {
			column(name: "recebe_email")
		}
		createIndex(indexName: "idxIntTelInt", tableName: "interessado_telefone") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxIntTelRam", tableName: "interessado_telefone") {
			column(name: "ramal")
		}
		createIndex(indexName: "idxIntTelTel", tableName: "interessado_telefone") {
			column(name: "telefone")
		}
		createIndex(indexName: "idxIntTipoCtr", tableName: "interessado") {
			column(name: "tipo_contrato")
		}
		createIndex(indexName: "idxIntUltCtt", tableName: "interessado") {
			column(name: "ultimo_contato")
		}
		createIndex(indexName: "idxInteAtenMot", tableName: "interessado_atendimento") {
			column(name: "motivo")
		}
		createIndex(indexName: "idxInteCart", tableName: "interesse") {
			column(name: "carteira_id")
		}
		createIndex(indexName: "idxInteFin", tableName: "interesse") {
			column(name: "finalidade_imovel_id")
		}
		createIndex(indexName: "idxIntePct", tableName: "interesse") {
			column(name: "pacote")
		}
		createIndex(indexName: "idxInteSeg", tableName: "interesse") {
			column(name: "segmento_id")
		}
		createIndex(indexName: "idxInteValCond", tableName: "interesse") {
			column(name: "valor_condominio")
		}
		createIndex(indexName: "idxInteValIptu", tableName: "interesse") {
			column(name: "valor_iptu")
		}
		createIndex(indexName: "idxInteValMax", tableName: "interesse") {
			column(name: "maximo")
		}
		createIndex(indexName: "idxInteValMin", tableName: "interesse") {
			column(name: "minimo")
		}
		createIndex(indexName: "idxLogCep", tableName: "logradouro") {
			column(name: "cep")
		}
		createIndex(indexName: "idxLogChaveDNE", tableName: "logradouro") {
			column(name: "chavedne")
		}
		createIndex(indexName: "idxLogNome", tableName: "logradouro") {
			column(name: "nome")
		}
		createIndex(indexName: "idxLogNomeNormal", tableName: "logradouro") {
			column(name: "nome_normalizado")
		}
		createIndex(indexName: "idxLogPai", tableName: "logradouro") {
			column(name: "logradouro_pai_id")
		}
		createIndex(indexName: "idxLogTipoLog", tableName: "logradouro") {
			column(name: "tipo_log_id")
		}
		createIndex(indexName: "idxLogCid", tableName: "logradouro") {
			column(name: "cidade_id")
		}
		createIndex(indexName: "idxLogBaiIni", tableName: "logradouro") {
			column(name: "bairro_ini_id")
		}
		createIndex(indexName: "idxLogBaiFim", tableName: "logradouro") {
			column(name: "bairro_fim_id")
		}
		createIndex(indexName: "idxLojaCart", tableName: "loja") {
			column(name: "carteira_id")
		}
		createIndex(indexName: "idxLojaPes", tableName: "loja") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxMensCC", tableName: "mensagem") {
			column(name: "cc")
		}
		createIndex(indexName: "idxMensDest", tableName: "mensagem") {
			column(name: "user_name_destino")
		}
		createIndex(indexName: "idxMensDestReceb", tableName: "mensagem_destinatario") {
			column(name: "recebida")
		}
		createIndex(indexName: "idxMensDestStat", tableName: "mensagem_destinatario") {
			column(name: "status")
		}
		createIndex(indexName: "idxMensGrp", tableName: "mensagem") {
			column(name: "nome_grupo_destino")
		}
		createIndex(indexName: "idxMensMensOrig", tableName: "mensagem") {
			column(name: "mensagem_origem_id")
		}
		createIndex(indexName: "idxMensOrig", tableName: "mensagem") {
			column(name: "user_name_origem")
		}
		createIndex(indexName: "idxMensRec", tableName: "mensagem") {
			column(name: "recepcao")
		}
		createIndex(indexName: "idxMensTip", tableName: "mensagem") {
			column(name: "tipo_mensagem")
		}
		createIndex(indexName: "idxMenuApl", tableName: "menu") {
			column(name: "aplicacao_id")
		}
		createIndex(indexName: "idxMenuNome", tableName: "menu") {
			column(name: "nome")
		}
		createIndex(indexName: "idxMenuPai", tableName: "menu") {
			column(name: "pai_id")
		}
		createIndex(indexName: "idxMenuPos", tableName: "menu") {
			column(name: "posicao")
		}
		createIndex(indexName: "idxMoeAtv", tableName: "moeda") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxMoeIndData", tableName: "moeda_indice") {
			column(name: "data")
		}
		createIndex(indexName: "idxMoeIndMoe", tableName: "moeda_indice") {
			column(name: "moeda_id")
			column(name: "data")
		}
		createIndex(indexName: "idxNome", tableName: "pessoa") {
			column(name: "nome")
		}
		createIndex(indexName: "idxNomeConj", tableName: "pessoa") {
			column(name: "nome_conjuge")
		}
		createIndex(indexName: "idxNotaAva", tableName: "nota_promissoria_pessoa") {
			column(name: "avalista_id")
		}
		createIndex(indexName: "idxNotaBene", tableName: "nota_promissoria") {
			column(name: "beneficiario_id")
		}
		createIndex(indexName: "idxNotaEmit", tableName: "nota_promissoria_pessoa") {
			column(name: "emitente_id")
		}
		createIndex(indexName: "idxNotaImpDt", tableName: "nota_promissoria") {
			column(name: "ultima_impressao")
		}
		createIndex(indexName: "idxNotaParcData", tableName: "nota_promissoria_parcela") {
			column(name: "data")
		}
		createIndex(indexName: "idxNotaParcNota", tableName: "nota_promissoria_parcela") {
			column(name: "nota_id")
		}
		createIndex(indexName: "idxNotaParcParc", tableName: "nota_promissoria_parcela") {
			column(name: "parcela")
		}
		createIndex(indexName: "idxNotaParcVal", tableName: "nota_promissoria_parcela") {
			column(name: "valor")
		}
		createIndex(indexName: "idxPesBcoBco", tableName: "pessoa_banco") {
			column(name: "banco_id")
		}
		createIndex(indexName: "idxPesBcoPes", tableName: "pessoa_banco") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxPesEndBai", tableName: "pessoa_endereco") {
			column(name: "bairro")
		}
		createIndex(indexName: "idxPesEndCep", tableName: "pessoa_endereco") {
			column(name: "cep")
		}
		createIndex(indexName: "idxPesEndCid", tableName: "pessoa_endereco") {
			column(name: "cidade")
		}
		createIndex(indexName: "idxPesEndCompl", tableName: "pessoa_endereco") {
			column(name: "complemento")
		}
		createIndex(indexName: "idxPesEndLog", tableName: "pessoa_endereco") {
			column(name: "logradouro")
		}
		createIndex(indexName: "idxPesEndLogDNE", tableName: "pessoa_endereco") {
			column(name: "logradourodne_id")
		}
		createIndex(indexName: "idxPesEndNum", tableName: "pessoa_endereco") {
			column(name: "numero")
		}
		createIndex(indexName: "idxPesEndPes", tableName: "pessoa_endereco") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxPesEndTip", tableName: "pessoa_endereco") {
			column(name: "tipo")
		}
		createIndex(indexName: "idxPesEndUf", tableName: "pessoa_endereco") {
			column(name: "uf")
		}
		createIndex(indexName: "idxPesTelEnd", tableName: "pessoa_email") {
			column(name: "endereco")
		}
		createIndex(indexName: "idxPesTelNome", tableName: "pessoa_email") {
			column(name: "nome")
		}
		createIndex(indexName: "idxPesTelPes", tableName: "pessoa_telefone") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxPesTelRam", tableName: "pessoa_telefone") {
			column(name: "ramal")
		}
		createIndex(indexName: "idxPesTelTel", tableName: "pessoa_telefone") {
			column(name: "telefone")
		}
		createIndex(indexName: "idxPessBloqEmail", tableName: "pessoa") {
			column(name: "bloquear_envio_email")
		}
		createIndex(indexName: "idxPlacaRetDtCria", tableName: "imovel_placa_retirada") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxPlacaRetDtRet", tableName: "imovel_placa_retirada") {
			column(name: "data_retirada")
		}
		createIndex(indexName: "idxPlacaRetMot", tableName: "imovel_placa_retirada") {
			column(name: "motivo")
		}
		createIndex(indexName: "idxPlacaRetResp", tableName: "imovel_placa_retirada") {
			column(name: "responsavel")
		}
		createIndex(indexName: "idxPlacaRetSol", tableName: "imovel_placa_retirada") {
			column(name: "solicitador")
		}
		createIndex(indexName: "idxPropCor", tableName: "proposta") {
			column(name: "corretor_id")
		}
		createIndex(indexName: "idxPropExp", tableName: "proposta") {
			column(name: "expira")
		}
		createIndex(indexName: "idxPropImo", tableName: "proposta") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxPropInt", tableName: "proposta") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxPropLib", tableName: "proposta") {
			column(name: "liberacao")
		}
		createIndex(indexName: "idxPropOfeTipo", tableName: "proposta_oferta") {
			column(name: "tipo_oferta")
		}
		createIndex(indexName: "idxPropOfeTitulo", tableName: "proposta_oferta") {
			column(name: "titulo")
		}
		createIndex(indexName: "idxPropStt", tableName: "proposta") {
			column(name: "status")
		}
		createIndex(indexName: "idxPropTipCtr", tableName: "proposta") {
			column(name: "tipo_contrato")
		}
		createIndex(indexName: "idxPropVal", tableName: "proposta") {
			column(name: "valor")
		}
		createIndex(indexName: "idxQdrChAtiv", tableName: "quadro_chaves") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxQdrChPosMot", tableName: "quadro_chaves_posicao") {
			column(name: "motivo_retirada")
		}
		createIndex(indexName: "idxQdrChPosPos", tableName: "quadro_chaves_posicao") {
			column(name: "posicao")
		}
		createIndex(indexName: "idxQdrChPosPosReceb", tableName: "quadro_chaves_posicao") {
			column(name: "recebimento")
		}
		createIndex(indexName: "idxQdrChPosPosReti", tableName: "quadro_chaves_posicao") {
			column(name: "retirada")
		}
		createIndex(indexName: "idxQdrChPosPosReto", tableName: "quadro_chaves_posicao") {
			column(name: "retomada")
		}
		createIndex(indexName: "idxQdrChPosQuadro", tableName: "quadro_chaves_posicao") {
			column(name: "quadro_chaves_id")
		}
		createIndex(indexName: "idxQdrChPosSt", tableName: "quadro_chaves_posicao") {
			column(name: "status")
		}
		createIndex(indexName: "idxRecepTelDataCria", tableName: "recepcao_telefonema") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxRecepTelNome", tableName: "recepcao_telefonema") {
			column(name: "nome")
		}
		createIndex(indexName: "idxRecepTelNomeUsuCria", tableName: "recepcao_telefonema") {
			column(name: "nome_usu_criador")
		}
		createIndex(indexName: "idxRecepTelNomeUsuDest", tableName: "recepcao_telefonema") {
			column(name: "nome_usu_destino")
		}
		createIndex(indexName: "idxRecepTelOrig", tableName: "recepcao_telefonema") {
			column(name: "origem")
		}
		createIndex(indexName: "idxRecepTelStt", tableName: "recepcao_telefonema") {
			column(name: "status")
		}
		createIndex(indexName: "idxRecepTelTipLig", tableName: "recepcao_telefonema") {
			column(name: "tipo_ligacao")
		}
		createIndex(indexName: "idxRegCorretCid", tableName: "regiao_corretagem") {
			column(name: "cidade_id")
		}
		createIndex(indexName: "idxRegCorretNome", tableName: "regiao_corretagem") {
			column(name: "nome")
		}
		createIndex(indexName: "idxReqMapAttr", tableName: "requestmap") {
			column(name: "config_attribute")
		}
		createIndex(indexName: "idxReqMapUrl", tableName: "requestmap") {
			column(name: "url")
		}
		createIndex(indexName: "idxRg", tableName: "pessoa") {
			column(name: "rg")
		}
		createIndex(indexName: "idxRgConj", tableName: "pessoa") {
			column(name: "rg_conjuge")
		}
		createIndex(indexName: "idxSegImovAtiv", tableName: "segmento_imovel") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxSegImovPad", tableName: "segmento_imovel") {
			column(name: "padrao")
		}
		createIndex(indexName: "idxSexo", tableName: "pessoa") {
			column(name: "sexo")
		}
		createIndex(indexName: "idxTIROrdemReg", tableName: "tipo_rel_dep") {
			column(name: "ordem")
		}
		createIndex(indexName: "idxTipDepAtiv", tableName: "tipo_dependencia") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxTipDepFinalidade", tableName: "tipo_dependencia") {
			column(name: "finalidade_id")
		}
		createIndex(indexName: "idxTipDepItVal", tableName: "tipo_dependencia_itens") {
			column(name: "valor")
		}
		createIndex(indexName: "idxTipDepNome", tableName: "tipo_dependencia") {
			column(name: "nome")
		}
		createIndex(indexName: "idxTipDepOrdem", tableName: "tipo_dependencia") {
			column(name: "ordem")
		}
		createIndex(indexName: "idxTipDepPosicao", tableName: "tipo_dependencia") {
			column(name: "posicao")
		}
		createIndex(indexName: "idxTipDepRelativo", tableName: "tipo_dependencia") {
			column(name: "relativo")
		}
		createIndex(indexName: "idxTipDepTipoCampo", tableName: "tipo_dependencia") {
			column(name: "tipo_campo")
		}
		createIndex(indexName: "idxTipEndAtiv", tableName: "tipo_endereco") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxTipEndNome", tableName: "tipo_endereco") {
			column(name: "nome")
		}
		createIndex(indexName: "idxTipLogAtivo", tableName: "tipo_logradouro") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxTipLogNome", tableName: "tipo_logradouro") {
			column(name: "nome")
		}
		createIndex(indexName: "idxTipLogSigla", tableName: "tipo_logradouro") {
			column(name: "sigla")
		}
		createIndex(indexName: "idxTipRelLigDep", tableName: "tipo_rel_dep") {
			column(name: "dependencia_id")
		}
		createIndex(indexName: "idxTipRelLigRel", tableName: "tipo_rel_dep") {
			column(name: "relativo_id")
		}
		createIndex(indexName: "idxTipRelRelativo", tableName: "tipo_imovel_relativo") {
			column(name: "relativo")
		}
		createIndex(indexName: "idxTipRelTipNome", tableName: "tipo_imovel_relativo") {
			column(name: "tipo_imovel_id")
		}
		createIndex(indexName: "idxTipoPessoa", tableName: "pessoa") {
			column(name: "tipo_pessoa")
		}
		createIndex(indexName: "idxTiqueImo", tableName: "tique_imovel_imovel") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxUfCep", tableName: "estado", unique: "true") {
			column(name: "cep1i")
		}
		createIndex(indexName: "idxUfNome", tableName: "estado", unique: "true") {
			column(name: "nome")
		}
		createIndex(indexName: "idxUsuCart", tableName: "usuario") {
			column(name: "carteira_id")
		}
		createIndex(indexName: "idxUsuCor", tableName: "usuario") {
			column(name: "corretor_id")
		}
		createIndex(indexName: "idxUsuEnab", tableName: "usuario") {
			column(name: "enabled")
		}
		createIndex(indexName: "idxUsuExp", tableName: "usuario") {
			column(name: "account_expired")
		}
		createIndex(indexName: "idxUsuLj", tableName: "usuario") {
			column(name: "loja_id")
		}
		createIndex(indexName: "idxUsuLock", tableName: "usuario") {
			column(name: "account_locked")
		}
		createIndex(indexName: "idxUsuPasExp", tableName: "usuario") {
			column(name: "password_expired")
		}
		createIndex(indexName: "idxUsuPess", tableName: "usuario") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxUsuSenha", tableName: "usuario") {
			column(name: "password")
		}
		createIndex(indexName: "idxUsuUltBlock", tableName: "usuario") {
			column(name: "ultimo_bloqueio")
		}
		createIndex(indexName: "idxValBooDep", tableName: "imovel_dependencia") {
			column(name: "valor_boolean")
		}
		createIndex(indexName: "idxValBooDepInte", tableName: "interesse_dependencia") {
			column(name: "valor_boolean")
		}
		createIndex(indexName: "idxValFloDep", tableName: "imovel_dependencia") {
			column(name: "valor_float")
		}
		createIndex(indexName: "idxValFloDepInte", tableName: "interesse_dependencia") {
			column(name: "valor_float")
		}
		createIndex(indexName: "idxValIntDep", tableName: "imovel_dependencia") {
			column(name: "valor_inteiro")
		}
		createIndex(indexName: "idxValIntDepInte", tableName: "interesse_dependencia") {
			column(name: "valor_inteiro")
		}
		createIndex(indexName: "idxValMulDep", tableName: "imovel_dependencia") {
			column(name: "valor_multiplo")
		}
		createIndex(indexName: "idxValMultDepInte", tableName: "interesse_dependencia") {
			column(name: "valor_multiplo")
		}
		createIndex(indexName: "idxValTxtDep", tableName: "imovel_dependencia") {
			column(name: "valor_texto")
		}
		createIndex(indexName: "idxVecComNome", tableName: "veiculo_comunicacao") {
			column(name: "nome")
		}
		createIndex(indexName: "idxVecComPes", tableName: "veiculo_comunicacao") {
			column(name: "pessoa_id")
		}
		createIndex(indexName: "idxVisAtiv", tableName: "visita") {
			column(name: "ativo")
		}
		createIndex(indexName: "idxVisCorr", tableName: "visita") {
			column(name: "corretor_id")
		}
		createIndex(indexName: "idxVisImovel", tableName: "visita") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxVisInteressado", tableName: "visita") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxVisStatus", tableName: "visita") {
			column(name: "status_visita")
		}
		createIndex(indexName: "idxVivReaImo", tableName: "viva_real_imovel") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxVndCod", tableName: "venda") {
			column(name: "codigo")
		}
		createIndex(indexName: "idxVndComp", tableName: "venda") {
			column(name: "comprador_id")
		}
		createIndex(indexName: "idxVndDtVnd", tableName: "venda") {
			column(name: "data_venda")
		}
		createIndex(indexName: "idxVndEnvDIMOB", tableName: "venda") {
			column(name: "enviardimob")
		}
		createIndex(indexName: "idxVndImgTit", tableName: "venda_imagem") {
			column(name: "titulo")
		}
		createIndex(indexName: "idxVndImgVnd", tableName: "venda_imagem") {
			column(name: "venda_id")
		}
		createIndex(indexName: "idxVndImo", tableName: "venda") {
			column(name: "imovel_id")
		}
		createIndex(indexName: "idxVndInt", tableName: "venda") {
			column(name: "interessado_id")
		}
		createIndex(indexName: "idxVndParcParc", tableName: "venda_parcela") {
			column(name: "parcela")
		}
		createIndex(indexName: "idxVndParcVen", tableName: "venda_parcela") {
			column(name: "vencimento")
		}
		createIndex(indexName: "idxVndParcVnd", tableName: "venda_parcela") {
			column(name: "venda_id")
		}
		createIndex(indexName: "idxVndPro", tableName: "venda") {
			column(name: "proposta_id")
		}
		createIndex(indexName: "idxVndStt", tableName: "venda") {
			column(name: "status")
		}
		createIndex(indexName: "idxVndVend", tableName: "venda") {
			column(name: "vendedor_id")
		}
		createIndex(indexName: "idxWpAction", tableName: "wordpress_click") {
			column(name: "action")
		}
		createIndex(indexName: "idxWpCookie", tableName: "wordpress_click") {
			column(name: "cookie")
		}
		createIndex(indexName: "idxWpDt", tableName: "wordpress_click") {
			column(name: "date_created")
		}
		createIndex(indexName: "idxZapImo", tableName: "zap_imovel") {
			column(name: "imovel_id")
		}
	}
}