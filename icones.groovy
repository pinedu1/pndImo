Set<String> foi = []
def x = [
        [1,null,"empresa","Empresa"]
        ,[2,"Empresas","empresa","Cadastro da Empresa"]
        ,[3,"Lojas","loja","Lojas"]
        ,[4,"ParametroSistemas","confParametro","Parametros e configurações"]
        ,[5,"PapelParedes","papelParede","Papéis de Parede"]
        ,[6,null,"utilitarios","Utilitários"]
        ,[7,"Mensagens","mensagem","Mensagens"]
        ,[8,"MensagemDiretas","mensagemDireta","Mensagem Direta"]
        ,[9,"Agendas","agenda","Agenda"]
        ,[10,null,"preferencias","Preferências"]
        ,[11,"AlterarSenha","changePassword","Alterar senha"]
        ,[12,"AlterarTema","changeTheme","Alterar Tema"]
        ,[14,"PapelParedes","papelParede","Papel de Parede"]
        ,[15,null,"controleAcessos","Segurança"]
        ,[16,"Users","user","Cadastro de Usuários"]
        ,[17,"Grupos","grupo","Cadastro de Grupos"]
        ,[18,"Roles","role","Cadastro de Regras"]
        ,[19,"UsuariosAtivos","user","Usuários ativos"]
        ,[20,"Menus","menu","Cadastro de Menus"]
        ,[21,"Logout","logout","Logout"]
        ,[22,null,"interessado","Interessados"]
        ,[23,"CadastroInteressadosCorretores","interessado","Cadastro de Interessados"]
        ,[25,"RelatorioInteressadoListas","interessadoRel","Listagem de Interessados"]
        ,[26,"RelatorioInteressadoAtendimentos","interessadoRel","Primeiro Atendimento"]
        ,[27,"RelatorioInteressadoContatos","interessadoRel","Último Contato"]
        ,[28,"RelatorioInteressadoIncompletos","interessadoRel","Interesses não Definidos"]
        ,[29,"RelatorioInteressadoExpiracaos","interessadoRel","Expiração de Interessados"]
        ,[30,"RelatorioInteressadoNovasEntradas","interessadoRel","Novas Entradas de Imóveis"]
        ,[31,"RelatorioInteressadoInativo","interessadoRel","Interessados Excluídos"]
        ,[33,null,"interessado","Gerência de Interessados"]
        ,[34,"InteressadoExpiradoPromover","interessadoCor","Promover interessados expirados"]
        ,[35,"RelatorioInteressadoExcluido","interessadoExcluido","Acompanhamento de Excluídos"]
        ,[36,null,"interessado","Entradas de Interessados"]
        ,[37,"PreInteressados","interessadoSite","Interessados via Site"]
        ,[38,null,"imovel","Imóveis Condomínios e Edifícios"]
        ,[39,null,"imovel","Controle de Imóveis"]
        ,[40,"Imoveis","imovel","Cadastros de Imóveis"]
        ,[41,"CorretorConsultaImoveis","imovel","Consulta Imóvel"]
        ,[42,"PesquisaImovelEndereco","pesquisaEndereco","Pesquisa Imóveis por Endereço"]
        ,[44,"RelatorioFichaImovel","imovelRel","Ficha do Imóvel"]
        ,[45,"RelatorioImovelLista","imovelRel","Listagem de Imóveis"]
        ,[46,"RelatorioImovelAtualizacao","imovelRel","Atualizar Preços"]
        ,[47,"RelatorioImovelSemAnuncio","imovelRel","Imóveis sem anúncio no período"]
        ,[49,null,"corretor","Captação de Imóveis"]
        ,[50,"TransferirCaptacoes","transferir","Transferir Captações"]
        ,[52,null,"estatisticaCaptacao","Estatísticas de Captação"]
        ,[53,"EstatisticaCaptacoes","estatisticaCaptacao","...Por Corretor"]
        ,[55,"ImovelFotos","fotoImovel","Cadastro de Fotos em Imóveis"]
        ,[56,"RelatorioImovelSemFotos","fotoImovelRel","Imóveis sem Fotos"]
        ,[58,null,"imovelExcluido","Imóveis Excluídos"]
        ,[59,"ImoveisExcluidos","imovelExcluido","Imóveis Excluídos"]
        ,[61,"RelatorioImovelListaExcluidos","imovelExcluidoRel","Listagem de Imóveis Excluídos"]
        ,[62,"PesquisaImovelEnderecoExcluidos","pesquisaEnderecoExcluido","Pesquisa Imóveis Excluídos por Endereço"]
        ,[64,"","imovelInternet","Entrada de Pré Imóveis"]
        ,[65,"ImoveisInternet","imovelInternet","Pré Imóveis à Verificar"]
        ,[66,"","fichaComprada","Fichas Compradas"]
        ,[67,"FichasCompradas","fichaCompradaCCI","Importar Fichas Compradas"]
        ,[68,null,"edificio","Controle de Edifícios"]
        ,[69,"Edificios","edificio","Cadastros de Edifícios"]
        ,[70,"CorretorConsultaEdificios","edificio","Consulta Edifícios/Loteamentos"]
        ,[72,"RelatorioFichaEdificio","edificioRel","Ficha do Edifício"]
        ,[73,"RelatorioEdificioLista","edificioRel","Listagem de Edifícios"]
        ,[75,"EdificioFotos","fotoImovel","Cadastro de Fotos em Edifícios"]
        ,[76,"RelatorioEdificioSemFotos","fotoImovelRel","Edifícios sem Fotos"]
        ,[77,null,"condominio","Controle de Condomínios"]
        ,[78,"Condominios","condominio","Cadastros de Condomínios/Empreendimentos"]
        ,[79,"CorretorConsultaCondominios","condominio","Consulta Condomínios/Empreendimentos"]
        ,[81,"RelatorioFichaCondominio","condominioRel","Ficha do Condomínio"]
        ,[82,"RelatorioCondominioLista","condominioRel","Listagem de Condomínios"]
        ,[84,"CondominioFotos","fotoImovel","Cadastro de Fotos em Condomínios"]
        ,[85,"RelatorioCondominioSemFotos","fotoImovelRel","Condomínios sem Fotos"]
        ,[86,null,"anuncio","Anúncios"]
        ,[87,null,"anuncios","Controle de Anúncios"]
        ,[88,"Anuncios","anuncio","Anunciar Imóvel"]
        ,[90,"RelatorioAnuncioLista","anuncioRel","Listagem de Anúncios por Período"]
        ,[91,"RelatorioAnuncioCadastroLista","anuncioRel","Anúncios por data de Criação"]
        ,[93,"RelatorioCampanhaSemAnuncio","anuncioRel","Campanhas sem Anúncios no Período"]
        ,[94,"RelatorioImovelComAnuncio","anuncioRel","Imóveis anunciados do período"]
        ,[95,"RelatorioRetornoInteressadoCampanha","anuncioRel","Retorno de Interessados por Campanha"]
        ,[96,null,"placaImovel","Controle de Placas"]
        ,[97,"ImovelPlacas","placaImovel","Placas em Imóveis"]
        ,[98,"ImovelPlacasRetirar","placaImovel","Solicitar Retirada"]
        ,[100,"RelatorioImovelVerificacaoPlaca","placaImovelRel","Placas em Imóveis à verificar"]
        ,[101,"RelatorioImovelSemPlaca","placaImovelRel","Imóveis sem Placas"]
        ,[168,"RegiaoCorretagems","regiao","Regiões"]
        ,[102,"RelatorioImovelPlacaRetirar","placaImovelRel","Placas em Imóveis à retirar"]
        ,[103,null,"imovelPromocao","Promoção de Imóveis"]
        ,[104,"ImovelPromocoes","imovelPromocao","Adicionar Imóvel em Promoção"]
        ,[105,null,"portal","Portais"]
        ,[106,null,"zap","Zap"]
        ,[107,"SelecaoImoveisZap","zap","Seleciona Imóveis Zap"]
        ,[109,"ConfiguraZap","zap","Configura Zap"]
        ,[110,"ConfiguraTipoImovelZap","zap","Tipo de Imóvel Zap"]
        ,[111,"ConfiguraTipoDependenciaZap","zap","Tipo de Dependências Zap"]
        ,[112,null,"imovelWeb","Portal Imóvel Web"]
        ,[113,"SelecaoImoveisImoWeb","imovelWeb","Seleciona Imóveis ImóvelWeb"]
        ,[115,"ConfiguraImovelWeb","imovelWeb","Configura ImóvelWeb"]
        ,[116,"ConfiguraTipoImovelImovelWeb","imovelWeb","Tipo de Imóvel ImóvelWeb"]
        ,[117,"ConfiguraTipoDependenciaImovelWeb","imovelWeb","Tipo de Dependências ImóvelWeb"]
        ,[118,"ConfiguraTipoDependenciaEmpreImovelWeb","imovelWeb","Tipo de Dependências Empreendimentos ImóvelWeb"]
        ,[119,null,"tiqueImovel","Portal TiqueImóvel"]
        ,[120,"SelecaoImoveisTiqueImovel","tiqueImovel","Seleciona Imóveis TiqueImovel"]
        ,[122,"ConfiguraTiqueImovel","tiqueImovel","Configura TiqueImovel"]
        ,[123,"ConfiguraTipoImovelTiqueImovel","tiqueImovel","Tipo de Imóvel TiqueImovel"]
        ,[124,"ConfiguraTipoDependenciaTiqueImovel","tiqueImovel","Tipo de Dependências TiqueImovel"]
        ,[125,null,"vivaReal","Portal VivaReal"]
        ,[126,"SelecaoImoveisVivaReal","vivaReal","Seleciona Imóveis VivaReal"]
        ,[128,"ConfiguraVivaReal","vivaReal","Configura VivaReal"]
        ,[129,"ConfiguraTipoImovelVivaReal","vivaReal","Tipo de Imóvel VivaReal"]
        ,[130,"ConfiguraTipoDependenciaVivaReal","vivaReal","Tipo de Dependências VivaReal"]
        ,[131,null,"proposta","Propostas"]
        ,[132,"Propostas","proposta","Cadastro de Propostas"]
        ,[134,"RelatorioPropostaExpiracao","propostaRel","Expiração de Propostas"]
        ,[135,"RelatorioPropostaLista","propostaRel","Listagem de Propostas"]
        ,[136,"RelatorioPropostaPendenteLista","propostaRel","Listagem de Propostas Pendentes"]
        ,[137,null,"venda","Vendas"]
        ,[138,"Vendas","venda","Cadastro de Venda"]
        ,[140,"VendaDistribuicaoComissoes","vendaRel","Distribuição de Comissões no período"]
        ,[141,null,"confParametro","Ferramentas"]
        ,[142,null,"chaves","Controle de Chaves"]
        ,[143,"ControleChaves","chaves","Quadro de Chaves"]
        ,[144,null,"telefone","Registro de Ligações"]
        ,[145,"RegistroLigacoes","telefone","Cadastro Ligações"]
        ,[147,"RelatorioRegistroLigacoes","telefoneRel","Listagem de Ligações"]
        ,[149,"NotaPromissorias","notapromissoria","Nota Promissória"]
        ,[150,null,"conf","Configurações"]
        ,[151,null,"imovel","Imóveis"]
        ,[152,"CarteiraImoveis","carteira","Carteira para Imóveis"]
        ,[169,"BairroCorretagems","bairro","Bairros"]
        ,[153,"FinalidadeImoveis","finalidadeImovel","Finalidade de Imóveis"]
        ,[154,"SegmentoImoveis","segmentoImovel","Segmento de Imóveis"]
        ,[155,"Concorrentes","concorrente","Concorrentes"]
        ,[156,"ClasseImoveis","classeImovel","Classificação de Imóveis"]
        ,[157,"QuadroChaves","chaves","Quadro de Chaves"]
        ,[158,null,"interessado","Interessados/Compradores"]
        ,[159,"ClasseInteressados","classeInteressado","Classificação para Interessados"]
        ,[160,null,"corretorEquipe","Corretores/Equipes"]
        ,[161,"Corretores","corretorCadastro","Cadastro de Corretores"]
        ,[162,"Equipes","equipe","Cadastro de Equipes"]
        ,[163,null,"tipoImovel","Tipo de Imóveis"]
        ,[164,"TipoImoveis","tipoImovel","Tipo de Imóveis"]
        ,[165,"TipoDependencias","tipoDependencia","Tipo de Dependências"]
        ,[166,"cidade","cidade","Cidades, Regiões e Bairros"]
        ,[167,"CidadeCorretagems","cidade","Cidades"]
        ,[178,"Estados","mailbox","Estados"]
        ,[170,null,"anuncios","Anúncios/Veículos de Comunicação"]
        ,[171,"Campanhas","campanhas","Campanhas de Marketing"]
        ,[172,"VeiculoComunicacaos","veiculoComunicacao","Veículos de Comunicações"]
        ,[173,"MidiaTipos","midiaTipo","Tipo de Mídias"]
        ,[174,null,"pessoa","Pessoas e Relacionados"]
        ,[175,"Pessoas","pessoa","Pessoas"]
        ,[176,"TipoEnderecos","tipoEndereco","Tipo de Endereçamento"]
        ,[177,null,"mailbox","Correios"]
        ,[179,"Cidades","mailbox","Cidades"]
        ,[180,"Bairros","mailbox","Bairros"]
        ,[181,"Logradouros","mailbox","Logradouros"]
        ,[182,"TipoLogradouros","mailbox","Tipo de Logradouros"]
        ,[183,"TextoRelatorios","textoRelatorio","Textos para relatórios"]
]

def my = [
    ['classe': 'add', 'image': 'add.png']
    , ['classe': 'cancel', 'image': 'cancel.png']
    , ['classe': 'carteira', 'image': 'carteira.png']
    , ['classe': 'chaves', 'image': 'chaves.png']
    , ['classe': 'clear', 'image': 'clear.png']
    , ['classe': 'coin', 'image': 'coins.png']
    , ['classe': 'coinAdd', 'image': 'coins_add.png']
    , ['classe': 'coinRem', 'image': 'coins_delete.png']
    , ['classe': 'concorrente', 'image': 'link.png']
    , ['classe': 'conf', 'image': 'control.png']
    , ['classe': 'corretor', 'image': 'corretor.png']
    , ['classe': 'delete', 'image': 'delete.png']
    , ['classe': 'devolver', 'image': 'devolver.png']
    , ['classe': 'diversos', 'image': 'plugin.png']
    , ['classe': 'edit', 'image': 'edit.png']
    , ['classe': 'foto', 'image': 'picture.png']
    , ['classe': 'fotoAdd', 'image': 'foto_add.png']
    , ['classe': 'fotoDel', 'image': 'foto_del.png']
    , ['classe': 'fotoEdificio', 'image': 'picture.png']
    , ['classe': 'fotoEdit', 'image': 'foto_edit.png']
    , ['classe': 'fotoGo', 'image': 'foto_go.png']
    , ['classe': 'fotoImovel', 'image': 'picture.png']
    , ['classe': 'fotoSave', 'image': 'foto_save.png']
    , ['classe': 'help', 'image': 'help.png']
    , ['classe': 'imovel', 'image': 'imovel.png']
    , ['classe': 'imprime', 'image': 'printer.png']
    , ['classe': 'loja', 'image': 'loja.png']
    , ['classe': 'mailbox', 'image': 'mailbox.png']
    , ['classe': 'mapa', 'image': 'mapa.png']
    , ['classe': 'moedaIndice', 'image': 'moedaIndices.png']
    , ['classe': 'new', 'image': 'new.png']
    , ['classe': 'notapromissoria', 'image': 'Check.png']
    , ['classe': 'pessoa', 'image': 'pessoa.png']
    , ['classe': 'placaImovel', 'image': 'vende-se.png']
    , ['classe': 'preview', 'image': 'preview.png']
    , ['classe': 'receber', 'image': 'receber.png']
    , ['classe': 'retirar', 'image': 'retirar.png']
    , ['classe': 'retomar', 'image': 'retomar.png']
    , ['classe': 'save', 'image': 'disk.png']
    , ['classe': 'search', 'image': 'search.png']
    , ['classe': 'secretaria', 'image': 'Books_3.png']
    , ['classe': 'wand', 'image': 'wand.png']
    , ['classe': 'administrativos', 'image': 'administrativos.png']
    , ['classe': 'menu', 'image': 'menu.png']
    , ['classe': 'item', 'image': 'item.png']
]
///home/eduardo/workspace-sts/vendas/web-app/images/16x16
Map myMap = [:]
Map myMapRev = [:]
my.each{
    myMap[it.classe] = it.image
    myMapRev[it.image] = it.classe
}

File[] files = new File("/home/eduardo/workspace-sts/vendas/web-app/images/16x16").listFiles()
files.each{ File f->
    if ( myMapRev.containsKey( f.name ) ) return
    String n = f.name.split(/\./)[0]
    myMap[n] = f.name
    if ( foi.contains(n) ) return
    foi.add(n)
    println ".$n\t\t\t{background-image: url(\"../images/16x16/${f.name}\") !important;} /* $f.name */"
}
x.each{
    String classe = it[2]
    String nome = it[3]
    if ( ! myMap.containsKey( classe ) ) {
        if ( foi.contains(classe) ) return
        foi.add(classe)
        println ".${classe}\t\t\t{background-image: url(\"../images/16x16/${classe}.png\") !important;} /* $nome */"
    }
}