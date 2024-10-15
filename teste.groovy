File out = new File("/pinedu/modelo/novas_regra.sql")
if ( out.exists() ) out.delete()
File reg = new File("/pinedu/modelo/regra.csv")
Map<String, String> regrasCadastradas = [:]
int z = 0
reg.eachLine { linha ->
	if ( z++ == 0 ) return
	String[] r = linha.replaceAll('"', '').split('\\,')
	String desc = r[3]
	String role = r[4]
	regrasCadastradas[role]=desc
}

Map<String, List<String>> mapaActionRegra = [
		'Agendas': ['ROLE_AGENDA']
		, 'Anuncios': ['ROLE_ANUNCIO']
		, 'BairroCorretagems': ['ROLE_BAIRROCORRETAGEM']
		, 'Bairros': ['ROLE_BAIRRO']
		, 'CadastroInteressadosCorretores': ['ROLE_INTERESSADO','ROLE_INTERESSADOATENDIMENTO']
		, 'CadastroInteressadosRecepcao': ['ROLE_INTERESSADO','ROLE_INTERESSADOATENDIMENTO']
		, 'CadastroRodizios': ['ROLE_RODIZIO']
		, 'Campanhas': ['ROLE_CAMPANHA']
		, 'CarteiraImoveis': ['ROLE_CARTEIRAIMOVEL']
		, 'CidadeCorretagems': ['ROLE_CIDADECORRETAGEM']
		, 'Cidades': ['ROLE_CIDADE']
		, 'ClasseImoveis': ['ROLE_CLASSEIMOVEL']
		, 'ClasseInteressados': ['ROLE_CLASSEINTERESSADO']
		, 'Concorrentes': ['ROLE_CONCORRENTE']
		, 'CondominioFotos': ['ROLE_CONDOMINIOFOTO']
		, 'Condominios': ['ROLE_CONDOMINIO']
		, 'Condominios': ['ROLE_CONDOMINIO']
		, 'ControleChaves': ['ROLE_QUADROCHAVES']
		, 'Corretores': ['ROLE_CORRETOR']
		, 'EdificioFotos': ['ROLE_EDIFICIOFOTO']
		, 'Edificios': ['ROLE_EDIFICIO']
		, 'Empresas': ['ROLE_EMPRESA']
		, 'Equipes': ['ROLE_EQUIPE']
		, 'Estados': ['ROLE_ESTADO']
		, 'FichasCompradas': ['ROLE_FICHACOMPRADA']
		, 'FinalidadeImoveis': ['ROLE_FINALIDADEIMOVEL']
		, 'Grupos': ['ROLE_GRUPO']
		, 'Imoveis': ['ROLE_IMOVEL', 'ROLE_IMOVEL_DADOS_PROPRIETARIO', 'ROLE_ALTERA_TEXTO_ANUNCIO']
		, 'ImovelFilmes': ['ROLE_IMOVELFOTO']
		, 'ImovelFotos': ['ROLE_IMOVELFOTO']
		, 'ImovelPlacasRetirar': ['ROLE_IMOVELPLACARETIRADA']
		, 'ImovelPlacas': ['ROLE_IMOVELPLACA']
		, 'ImovelPromocoes': ['ROLE_IMOVELPROMOCAO']
		, 'IndiceCorrecoes': ['ROLE_COTACAOINDICECORRECAO']
		, 'Indices': ['ROLE_INDICE']
		, 'Logradouros': ['ROLE_LOGRADOURO']
		, 'Lojas': ['ROLE_LOJA']
		, 'MidiaTipos': ['ROLE_MIDIATIPO']
		, 'MoedaIndices': ['ROLE_MOEDAINDICE']
		, 'Moedas': ['ROLE_MOEDA']
		, 'NotaPromissorias': ['ROLE_NOTAPROMISSORIA']
		, 'ParametroSistemas': ['ROLE_PARAMETROSISTEMA']
		, 'PeriodoReajustes': ['PERIODO_REAJUSTE']
		, 'Pessoas': ['ROLE_PESSOA']
		, 'PreInteressados': ['ROLE_PREINTERESSADO']
		, 'Propostas': ['ROLE_PROPOSTA']
		, 'QuadroChaves': ['ROLE_QUADROCHAVES']
		, 'RegiaoCorretagems': ['ROLE_REGIAOCORRETAGEM']
		, 'RegistroLigacoes': ['ROLE_RECEPCAOTELEFONEMA']
		, 'Roles': ['ROLE_ROLE']
		, 'SegmentoImoveis': ['ROLE_SEGMENTOIMOVEL']
		, 'SituacaoContratos': ['ROLE_SITUACAOCONTRATO']
		, 'TextoRelatorios': ['ROLE_TEXTOSISTEMA']
		, 'TipoContratos': ['ROLE_TIPOCONTRATO']
		, 'TipoDependencias': ['ROLE_TIPODEPENDENCIA']
		, 'TipoEnderecos': ['ROLE_TIPOENDERECO']
		, 'TipoImoveis': ['ROLE_TIPOIMOVEL']
		, 'TipoLogradouros': ['ROLE_TIPOLOGRADOURO']
		, 'User': ['ROLE_USER']
		, 'VeiculoComunicacaos': ['ROLE_VEICULOCOMUNICACAO']
		, 'Vendas': ['ROLE_VENDA']
]
Set<Map<String, String>> regrasIndividuais = [
	[regra: "ROLE_USER", descricao: "Usuários padrões do Sistema"]
	, [regra: "ROLE_ADMIN", descricao: "Administradores do Sistema"]
	, [regra: "ROLE_SUPERUSUARIO", descricao: "Superusuário do Sistema"]
	, [regra: "ROLE_IMPRESSAO", descricao: "Usuários que podem imprimir"]
	, [regra: "ROLE_IMOVEL_DADOS_PROPRIETARIO", descricao: "Usuário pode Visualizar dados de proprietário dos Imóveis"]
	, [regra: "ROLE_ALTERA_TEXTO_ANUNCIO", descricao: "Permitir alterar Texto do Anúncio"]
	, [regra: "ROLE_LOGIN_REMOTO", descricao: "Permitir Login Remoto (fora da Empresa)"]
]



out << "SELECT setval('seq_regra', 1, false);"
out << "\nINSERT INTO public.regra(id, version, authority, descricao, sistema) VALUES "
regrasIndividuais.eachWithIndex{regra, i->
	String ruleDesc = ''
	if ( regrasCadastradas.containsKey( regra.regra ) ) {
		ruleDesc = regrasCadastradas[regra.regra]
		regrasCadastradas.remove( regra.regra )
	}
	out << "\n\t${i>0?', ':''}(nextval('seq_regra'), 0, '${regra.regra}', '${ruleDesc?:regra.descricao}', true)"
}
int i = 1
mapaActionRegra.each{  action, r->
	r.each{String regraSintetica ->
		['CREATE','DELETE','READ','UPDATE'].each{op->
			String rule = "${regraSintetica}_${op}"
			String ruleDesc = ''
			if ( regrasCadastradas.containsKey( rule ) ) {
				ruleDesc = regrasCadastradas[rule]
				regrasCadastradas.remove( rule )
			}
			out << "\n\t${i>0?', ':''}(nextval('seq_regra'), 0, '${rule}', '${ruleDesc}', true)"
		}
	}
}

regrasCadastradas.sort{it.key}.each{regra,descricao->
	out << "\n\t, (nextval('seq_regra'), 0, '${regra}', '${descricao}', true)"
}
out << "\n;"
