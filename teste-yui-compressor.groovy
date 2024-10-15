@Grab(group='com.yahoo.platform.yui', module='yuicompressor', version='2.4.8')

import com.yahoo.platform.yui.compressor.JavaScriptCompressor
import java.io.StringReader
import java.io.StringWriter
import org.mozilla.javascript.ErrorReporter
import org.mozilla.javascript.EvaluatorException

//groovy -cp /home/eduardo/.gradle/caches/modules-2/files-2.1/com.yahoo.platform.yui/yuicompressor/2.4.8/900a7296bb52d740418d53274c1ecac5c83c760e/yuicompressor-2.4.8.jar teste-yui-compressor.groovy


// Função para combinar arquivos JavaScript
def combineJavaScriptFiles(filePaths, String finalScript) {
	def combinedJs = new StringBuilder()
	filePaths.each { filePath ->
		def fileContent = new File(filePath).text
		combinedJs.append(fileContent).append('\n')
	}
	combinedJs.append(finalScript).append('\n')
	return combinedJs.toString()
}

// Função para compressão de JavaScript com opções de minificação
def compressJavaScript(jsCode, isMinified = true, isMunged = true, isPreserveAllSemiColons = false, isDisableOptimizations = false) {
	try {
		def jsCompressor = new JavaScriptCompressor(new StringReader(jsCode), new CustomErrorReporter())
		def writer = new StringWriter()
		jsCompressor.compress(writer, isMinified ? -1 : 0, isMunged, isPreserveAllSemiColons, isDisableOptimizations, isPreserveAllSemiColons)
		return writer.toString()
	} catch (Exception e) {
		println "Erro na compressão: ${e.message}"
		return null
	}
}

// Caminhos para os arquivos JavaScript que você deseja combinar
List<String> jsFilePaths = [
	'/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/FiltersFeature.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/AcaoMensagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/MessageBroker.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/ajax/Simlet.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/ajax/Simlet.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/ajax/SimXhr.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/ajax/JsonSimlet.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/ajax/SimManager.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/menu/ListMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/menu/RangeMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/plugin/RowEditing.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/filter/Filter.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/filter/DateFilter.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/filter/ListFilter.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/filter/NumericFilter.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/filter/StringFilter.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/filter/BooleanFilter.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/grid/feature/Tileview.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/form/field/plugin/PasswordStrength.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/form/field/Month.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/statusbar/StatusBar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/CheckColumn.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/container/ButtonSegment.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/container/SwitchButtonSegment.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/form/MultiSelect.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/form/ItemSelector.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/form/field/HtmlEditor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/InputTextMask.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/GMapPanel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/ux/DataView/Animated.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/dd/StatusProxy.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/data/EventMappings.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/data/CalendarMappings.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/util/Date.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/dd/DragZone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/dd/DropZone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/dd/DayDragZone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/dd/DayDropZone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/data/EventModel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/template/BoxLayout.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/template/DayBody.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/template/DayHeader.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/template/Month.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/util/WeekEventRenderer.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/view/AbstractCalendar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/view/DayBody.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/view/MonthDayDetail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/view/Month.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/view/DayHeader.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/view/Day.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/view/Week.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/form/field/DateRange.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/form/field/ReminderCombo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/form/field/CalendarCombo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/form/EventDetails.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/form/EventWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/ext/src/calendar/CalendarPanel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/proposta/PropostaSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Arquivo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Aplicacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/FinalidadeImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/FinalidadeImovelSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Acompanhamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ClasseImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ClasseImovelSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoDependenciaItens.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoDependenciaRelativo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoDependenciaTipoCampo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoDependenciaPosicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoImovelRelativo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoImovelSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoLogradouro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoLogradouroSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoLogradouroSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Estado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/EstadoSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Cidade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CidadeSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CidadeSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Bairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/BairroSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/BairroSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Logradouro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CidadeCorretagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CidadeCorretagemSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CidadeCorretagemSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/RegiaoCorretagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/RegiaoCorretagemSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/BairroCorretagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/BairroCorretagemSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/BairroCorretagemSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoEnderecoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoEnderecoSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/PessoaEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/PessoaBanco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/PessoaEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/PessoaTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Pessoa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ContratoExclusividade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Corretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CorretorSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CorretorSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/MoedaIndice.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/MoedaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Moeda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/MidiaTipo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Grupo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Paridade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Concorrente.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ConcorrenteSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ConcorrenteSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/RodizioCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Role.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/QuadroChavesPosicaoStatus.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/QuadroChavesPosicaoMotivo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/QuadroChavesPosicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/QuadroChavesPosicaoSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/QuadroChaves.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoOcupacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoCidade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Loja.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/LojaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/LojaSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VeiculoComunicacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoRestante.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Empresa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Anuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TextoAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoPeriodo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CarteiraImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CarteiraImovelSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/PropostaOferta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Rodizio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoContrato.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Proposta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/AjudaMesclagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Menu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Campanha.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CampanhaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CampanhaSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/PadraoConstrucao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ClasseInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ClasseInteressadoSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoOferta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/AlinhamentoMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CategoriaCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/StatusImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/SituacaoCidade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/MidiaTipoUnidade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/MenuTree.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/FaixaValor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ParametroSistemaComissao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ParametroSistemaValidadeInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ParametroSistema.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/NotaPromissoriaParcela.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/MensagemAnexo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/User.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/UserAtivo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/StatusProposta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/NotaPromissoriaGeraParcela.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/SegmentoImovelSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/SegmentoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteresseDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Interesse.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/MotivoExclusao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/StatusLogradouro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Geoposicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Equipe.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Mensagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/MensagemPasta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/NotaPromissoria.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoOferta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoDuplicado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoVerificaDuplicado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Interessado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelExclusividade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelSaldo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelDependenciaSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelCaptacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelPlaca.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelProprietario.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelPortal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Imovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelEvolucaoPreco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelEstatisticaCaptacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelEntradas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/EdificioAutoComplete.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Edificio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/EdificioSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/EdificioSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CondominioAutoComplete.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Condominio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CondominioSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CondominioSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Evento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelExclusao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Agenda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/LembreMe.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VendaDepartamentoComissao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VendaDepartamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VendaParcela.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/StatusVenda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Venda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VendaDistribuicaoComissoesDepartamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VendaDistribuicaoComissoes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VendaDistribuicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/OrdemFotografia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoAutoComplete.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelExclusaoMotivo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/PropostaPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/EdificioPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CondominioPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoNovasEntradas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoContato.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/PropostaPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/EdificioPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelPlacaMotivoRetirada.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CondominioPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/AnuncioLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelPlacaRetirar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoNovasEntradas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/CampanhaSemAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoExclusaoImoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoExclusaoTransacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoExclusaoMotivo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/InteressadoExclusao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelPromocao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/RecepcaoTelefonema.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TipoLigacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/StatusLigacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/OrigemLigacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Visita.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ZapConf.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ZapTag.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ZapImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ZapTipoImovelCategoria.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ZapTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ZapTipoDestaque.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TextoSistema.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/FichaComprada.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelWebConf.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelWebImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelWebTag.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelWebTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelWebTipoImovelCategoria.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/ImovelWebTipoImovelCat.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TiqueImovelConf.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TiqueImovelImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TiqueImovelTag.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TiqueImovelTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/TiqueImovelTipoSubTipo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VivaRealConf.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VivaRealTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/VivaRealImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/Banco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/model/BancoSession.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AcompanhamentoInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AcompanhamentoProposta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AcompanhamentoVenda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Agenda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AjudaMesclagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AlinhamentoMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Anuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AnuncioImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AnuncioLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AnuncioResolveExclusivoInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/AplicacaoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Bairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/BairroCorretagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/BairroCorretagemLoadFromBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/BairroCorretagemSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/BairroCorretagemSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/BairroSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/BairroSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CadastroMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Campanha.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CampanhaRetornoInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CampanhaSemAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CampanhaSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CampanhaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CarteiraImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CarteiraImovelSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CarteiraImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CategoriaCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Cidade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CidadeCorretagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CidadeCorretagemSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CidadeCorretagemSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CidadeSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CidadeSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ClasseImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ClasseImovelSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ClasseImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ClasseInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ClasseInteressadoSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ClasseInteressadoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Concorrente.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ConcorrenteSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ConcorrenteSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Edificio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioAutoCompleteEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioAutoCompleteNome.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioDependenciaBoolean.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioDependenciaFloat.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioDependenciaInteiro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioDependenciaMultiplo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioDependenciaSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioDependenciaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioDependenciaTexto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioLoadSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioModeloDependenciaBoolean.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioModeloDependenciaFloat.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioModeloDependenciaInteiro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioModeloDependenciaMultiplo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioModeloDependenciaTexto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioSemFotoLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EdificioUnidades.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Condominio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioAutoCompleteNome.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioDependenciaBoolean.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioDependenciaFloat.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioDependenciaInteiro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioDependenciaSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioDependenciaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioLoadSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioSemFotoLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CondominioUnidades.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ControleChavesPosicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ControleChavesPosicaoDevolve.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ControleChavesPosicaoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ControleChavesPosicaoRecebe.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ControleChavesPosicaoRetira.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ControleChavesPosicaoRetoma.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Corretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorEquipeSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorForaRodizio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorGerente.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorGerenteEquipeSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorImovelSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorSemEquipeSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/CorretorSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/DistritoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Empresa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EmpresaImagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EmpresaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Equipe.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EquipeCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EquipeGerente.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EquipeLoad.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Estado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EstadoSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EstadoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Evento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/FaixaValor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/FichaComprada.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/FichaCompradaMemory.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/FinalidadeImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/FinalidadeImovelSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/FinalidadeImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Grupo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/GrupoLoad.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/GrupoMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/GrupoRole.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/GrupoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/GrupoUser.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Imovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelAjudaMesclagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelAtualizacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelCaptacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelCaptacaoMovimento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelChamado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelClick.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelComAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelEntradas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelEstatisticaCaptacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelEvolucaoPreco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelExclusaoMotivo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelInternet.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelLoadSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelOferta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPesquisaEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPesquisaEnderecoChamadoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPesquisaEnderecoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPesquisaEnderecoSimplesProposta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPesquisaEnderecoSimplesVenda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPlaca.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPlacaListaRetirar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPlacaMotivoRetirada.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPlacaRetirar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPortal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPromocao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPromocaoContrato.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPromocaoVenda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelPropostas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelSemAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelSemFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelSemPlaca.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelVerificacaoPlaca.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelVisita.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebConf.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebTagSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebTagTipoDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebTagTipoDependenciaEmpre.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebTipoDestaque.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebTipoImovelCat.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ImovelWebTipoImovelCategoria.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Interessado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoAtendimento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoAutoCompleteNome.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoAutoCompleteTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoClique.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoContato.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoCorretorExclusivoAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoDuplicado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoExcluidoOcorrencias.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoExclusao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoExclusaoImoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoExclusaoMotivo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoExclusaoTransacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoExpiracao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoExpirado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoInativo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoIncompleto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoInteresse.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoInteresseDependenciaBoolean.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoInteresseDependenciaFloat.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoInteresseDependenciaInteiro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoNovasEntradas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoOferta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoVerificaDuplicado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoVisita.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/InteressadoVisitaLoad.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/LembreMe.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Logradouro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/LogradouroCepSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/LogradouroLoad.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/LogradouroSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Loja.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/LojaSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/LojaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Mensagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MensagemDestinatario.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MensagemDestinatarioCC.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MensagemEnviada.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MensagemLida.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MensagemNaoLidas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MensagemNova.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MensagemPasta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MensagemReplica.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Menu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MenuCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MenuSecure.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MenuSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MenuTree.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MidiaTipo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MidiaTipoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MidiaTipoUnidade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Moeda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MoedaIndice.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MoedaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/MotivoExclusao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/NotaPromissoria.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/NotaPromissoriaCompleto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/NotaPromissoriaParcela.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/NotaPromissoriaPessoa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/OrdemFotografia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/OrigemLigacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PadraoConstrucao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ParametroSistema.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ParametroSistemaComissao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ParametroSistemaValidadeInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Paridade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Pessoa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/EstadoCivil.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/FormaPagamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PessoaEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PessoaEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PessoaBanco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PessoaNotaPromissoriaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PessoaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PessoaTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PreInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Proposta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PropostaExpiracao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PropostaLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/PropostaOferta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/QuadroChaves.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/QuadroChavesPosicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/QuadroChavesPosicaoMotivo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/QuadroChavesPosicaoSessionSimplesSelecione.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/QuadroChavesPosicaoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/QuadroChavesPosicaoSimplesSelecione.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/QuadroChavesPosicaoStatus.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/QuadroChavesSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RecepcaoTelefonema.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RegiaoCorretagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RegiaoCorretagemDistribuicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RegiaoCorretagemSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RegiaoCorretagemSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Rodizio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RodizioAdicionaCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RodizioCopia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RodizioCorretores.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RodizioRemoveCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RodizioRotacionaCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Role.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/RoleSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/SegmentoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/SegmentoImovelSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/SegmentoImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/SituacaoCidade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/StatusImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/StatusLigacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/StatusLogradouro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/StatusProposta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/StatusPropostaTodos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/StatusVenda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/StatusVisitaTodos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Tema.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TextoAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TextoSistema.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoCidade.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoContrato.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoDependenciaMemory.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoDependenciaPosicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoDependenciaRelativo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoDependenciaSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoDependenciaTipoCampo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoEnderecoSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoEnderecoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoGrupoEstCap.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoImovelCompleto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoImovelRelativo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoImovelSessionCompleto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoImovelSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoImovelSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoLigacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoLogradouro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoLogradouroSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoLogradouroSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoOcupacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoOferta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoPeriodo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoRestante.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TiqueImovelConf.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TiqueImovelImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TiqueImovelTagSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TiqueImovelTagTipoDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TiqueImovelTipoDestaque.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TiqueImovelTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TiqueImovelTipoSubTipo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TransfereCaptacaoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/User.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserAtivosSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserGrupo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserLoad.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserRole.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserRoleGrupo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserRoleNegado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserSecure.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/UserVerificaDuplo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VeiculoComunicacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VeiculoComunicacaoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Venda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaCompradorEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaCompradorEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaCompradorTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaParcela.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaDepartamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaDepartamentoComissao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaDistribuicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaDistribuicaoComissoes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaDistribuicaoComissoesDepartamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaVendedorEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaVendedorEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaVendedorTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VendaParcelaCalcula.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VivaRealConf.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VivaRealImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VivaRealTagSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VivaRealTagTipoDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VivaRealTipoDestaque.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VivaRealTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/VivaRealTipoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ZapConf.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ZapImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ZapTagSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ZapTagTipoDependencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ZapTipoDestaque.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ZapTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/ZapTipoImovelCategoria.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/TipoContaBanco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/Banco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/BancoSessionSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/store/BancoSimples.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/util/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/util/GoogleMapUtils.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/util/CadastraBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/util/ConsultaFieldAlpha.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/util/NumericField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/DesktopModalWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/DesktopWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/FitAllLayOut.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/PrintWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/HelpWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/StartMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/ToolThumb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/ToolWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/TrayClock.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/Desktop.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/TelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/EnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/EmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/BancoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/MapaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/CadastraBairroWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/AcompanhamentoContainer.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/desktop/AcompanhamentoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/Viewport.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pessoa/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pessoa/PessoaEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pessoa/PessoaBancoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pessoa/PessoaEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pessoa/PessoaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pessoa/PessoaFotoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pessoa/PessoaTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/loja/LojaEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/loja/LojaEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/loja/LojaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/loja/LojaFotoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/loja/LojaMapaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/loja/LojaTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/loja/LojaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/agenda/AgendaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/agenda/EventoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/agenda/TarefaPopUpWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncio/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncio/ConsultaImovelField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncio/AnuncioImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncio/AnuncioImovelGrid.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncio/AnuncioTextoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncio/AnuncioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncioLista/AnuncioCadastroListaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncioLista/AnuncioListaViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/anuncioLista/AnuncioListaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/bairro/BairroForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/bairro/BairroWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/bairroCorretagem/BairroCorretagemForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/bairroCorretagem/BairroCorretagemFundirWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/bairroCorretagem/BairroCorretagemWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/cadastroMenu/CadastroMenuForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/cadastroMenu/CadastroMenuWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/campanha/CampanhaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/campanha/CampanhaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/campanhaSemAnuncio/CampanhaSemAnuncioListaViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/campanhaSemAnuncio/CampanhaSemAnuncioListaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/carteiraImovel/CarteiraImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/carteiraImovel/CarteiraImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/chat/ChatConversationWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/chat/ChatSolicitacaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/cidade/CidadeForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/cidade/CidadeWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/cidadeCorretagem/CidadeCorretagemForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/cidadeCorretagem/CidadeCorretagemWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/classeImovel/ClasseImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/classeImovel/ClasseImovelGrid.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/classeImovel/ClasseImovelGridWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/classeInteressado/ClasseInteressadoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/classeInteressado/ClasseInteressadoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/concorrente/ConcorrenteEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/concorrente/ConcorrenteEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/concorrente/ConcorrenteForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/concorrente/ConcorrenteFotoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/concorrente/ConcorrenteTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/concorrente/ConcorrenteWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioCadastraBairroWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioMapaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioPessoaJuridica.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioPessoaJuridicaEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioPessoaJuridicaEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioPessoaJuridicaTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioSindico.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioSindicoEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioSindicoEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioSindicoTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioAdministradora.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioAdministradoraEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioAdministradoraEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioAdministradoraTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominio/CondominioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFoto/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFoto/CondominioFotoUploadForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFoto/FotoThumb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFoto/InfoCondominio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFoto/InfoFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFoto/CondominioFotoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioLista/ListaCondominioViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioLista/ListaCondominioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioListaSemFoto/ListaCondominioSemFotoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioListaSemFoto/ListaCondominioSemFotoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/controleChaves/ChavesPosicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/controleChaves/ControleChavesImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/controleChaves/ControleChavesPosicaoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/controleChaves/ControleChavesWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/corretor/CorretorEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/corretor/CorretorEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/corretor/CorretorForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/corretor/CorretorFotoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/corretor/CorretorTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/corretor/CorretorWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/FotoThumbEdificio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioCadastraBairroWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioEmailFormSindico.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioEnderecoFormSindico.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioFotoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioMapaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioPesquisaEnderecoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioSindico.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioTelefoneFormSindico.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioZelador.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFicha/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFicha/InfoCondominio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/condominioFicha/CondominioFichaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificio/EdificioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFicha/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFicha/InfoEdificio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFicha/EdificioFichaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFoto/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFoto/EdificioFotoUploadForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFoto/FotoThumb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFoto/InfoEdificio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFoto/InfoFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioFoto/EdificioFotoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioLista/ListaEdificioViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioLista/ListaEdificioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioListaSemFoto/ListaEdificioSemFotoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/edificioListaSemFoto/ListaEdificioSemFotoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/empresa/EmpresaEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/empresa/EmpresaEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/empresa/EmpresaTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/empresa/EmpresaFotoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/empresa/EmpresaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/equipe/EquipeCorretorSemEquipeWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/equipe/EquipeGerenteWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/equipe/EquipeForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/equipe/EquipeWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/estado/EstadoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/estado/EstadoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/estatisticaCaptacao/EstatisticaCaptacaoGrapfWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/estatisticaCaptacao/EstatisticaCaptacaoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/estatisticaCaptacao/EstatisticaCaptacaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/fichaComprada/FichaCompradaUploadForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/fichaComprada/FichaCompradaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/finalidadeImovel/FinalidadeImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/finalidadeImovel/FinalidadeImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/grupo/GrupoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/grupo/GrupoRoleSelectWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/grupo/GrupoUsuarioSelectWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/grupo/GrupoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelCadastraBairroWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/FotoThumbImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelAjudaMesclagemWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelCopiarReferenciaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelEntradasWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelEvolucaoPrecoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelFotoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelMapaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelMotivoExclusaoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelPatrocinioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelPessoaProprietario.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelPortalWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovel/ImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelAtualizacao/ListaImovelAtualizacaoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelAtualizacao/ListaImovelAtualizacaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelComAnuncio/ListaImovelComAnuncioViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelComAnuncio/ListaImovelComAnuncioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFicha/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFicha/ImovelFichaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFicha/InfoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFoto/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFoto/FotoThumb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFoto/ImovelFotoUploadForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFoto/InfoFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFoto/InfoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelFoto/ImovelFotoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelInternet/ImoveisInternetWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelLista/ListaImovelViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelLista/ListaImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPlaca/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPlaca/InfoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPlaca/ImovelPlacaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPlacaRetirar/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPlacaRetirar/InfoImovelPlacaRetirar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPlacaRetirar/ImovelPlacaRetirarWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPlacaRetirar/ListaImovelPlacaRetirarViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPlacaRetirar/ListaImovelPlacaRetirarWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPromocao/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPromocao/ImovelPromocaoImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPromocao/ImovelPromocaoImovelGrid.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelPromocao/ImovelPromocaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelSemAnuncio/ListaImovelSemAnuncioViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelSemAnuncio/ListaImovelSemAnuncioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelSemFoto/ListaImovelSemFotoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelSemFoto/ListaImovelSemFotoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelSemPlaca/ListaImovelSemPlacaViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelSemPlaca/ListaImovelSemPlacaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelVerificacaoPlaca/ListaImovelVerificacaoPlacaViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelVerificacaoPlaca/ListaImovelVerificacaoPlacaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelWebConf/ImovelWebConfForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelWebImovel/ConsultaImovelField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelWebImovel/ImovelWebImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelWebImovel/ImovelWebImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelWebTipoDependencia/ImovelWebTipoDependenciaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelWebTipoDependencia/ImovelWebTipoDependenciaEmpreWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/imovelWebTipoImovel/ImovelWebTipoImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoAtendimentos/AtendimentosViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoAtendimentos/AtendimentosWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoContato/ContatoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoContato/ContatoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/ConsultaImovelField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoAcompanhamentoWindowModal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoImovelChamadoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoImovelVisitaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoInteresseForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoPesquisaPrintWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoPesquisaTelefoneWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoVisitaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/ResultadoPesquisaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoCorretor/InteressadoCorretorForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoExcluido/ExcluidoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoExcluido/ExcluidoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoExpiracao/ExpiracaoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoExpiracao/ExpiracaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoInativo/InativoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoInativo/InativoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoIncompleto/IncompletoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoIncompleto/IncompletoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoLista/ListaViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoLista/ListaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoNovasEntradas/NovasEntradasViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoNovasEntradas/NovasEntradasWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoPromover/InteressadoPromoverGrid.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoPromover/InteressadoPromoverWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/CorretorExclusivoAnuncioSelectWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/FastTelefoneWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/InteressadoComboCorretorWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/InteressadoDuplicidadeWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/InteressadoEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/InteressadoEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/InteressadoMotivoExclusaoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/InteressadoTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/InteressadoRecepcaoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRecepcao/RodizioSituacaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRetornoCampanha/RetornoCampanhaViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/interessadoRetornoCampanha/RetornoCampanhaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/login/LoginWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/logradouro/LogradouroForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/logradouro/LogradouroWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/mensagem/MensagemBanner.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/mensagem/MensagemConteudo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/mensagem/MensagemListas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/mensagem/MensagemPopUpWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/mensagem/MensagemUserSelectWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/mensagem/MensagemFormWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/mensagem/MensagemWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/menu/MenuForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/menu/MenuWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/midiaTipo/MidiaTipoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/midiaTipo/MidiaTipoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/moeda/MoedaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/moeda/MoedaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/moedaIndice/MoedaIndiceForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/moedaIndice/MoedaIndiceWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/notaPromissoria/NotaPromissoriaEditaParcelaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/notaPromissoria/NotaPromissoriaParcelasForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/notaPromissoria/NotaPromissoriaPessoaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/notaPromissoria/NotaPromissoriaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/notaPromissoria/NotaPromissoriaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/papelParede/InfoFoto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/papelParede/PapelParedeThumb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/papelParede/PapelParedeUploadForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/papelParede/PapelParedeWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/parametroSistema/ParametroSistemaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pesquisaEndereco/PesquisaImovelEnderecoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/pesquisaEndereco/ResultadoPesquisaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/preInteressado/PreInteressadoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/proposta/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/proposta/ConsultaReferenciaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/proposta/PropostaAcompanhamentoWindowModal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/proposta/PropostaOfertaWindowModal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/proposta/PropostaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/propostaExpiracao/ListaPropostaExpiracaoViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/propostaExpiracao/ListaPropostaExpiracaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/propostaLista/ListaPropostaExpiracaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/propostaLista/ListaPropostaPendenteWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/propostaLista/ListaPropostaViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/propostaLista/ListaPropostaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/quadroChaves/QuadroChavesForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/quadroChaves/QuadroChavesWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/regiaoCorretagem/RegiaoCorretagemDistribuicaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/regiaoCorretagem/RegiaoCorretagemForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/regiaoCorretagem/RegiaoCorretagemFundirWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/regiaoCorretagem/RegiaoCorretagemWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/registroLigacoes/ListaRegistroLigacoesWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/registroLigacoes/RegistroLigacoesWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/rodizio/CorretorSelectWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/rodizio/RodizioForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/role/RoleForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/role/RoleGrid.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/role/RoleGridWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/segmentoImovel/SegmentoImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/segmentoImovel/SegmentoImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/textoRelatorio/TextoRelatorioForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/textoRelatorio/TextoRelatorioWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoDependencia/TipoDependenciaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoDependencia/TipoDependenciaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoEndereco/TipoEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoEndereco/TipoEnderecoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoImovel/TipoImovelAjudaMesclagemWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoImovel/TipoImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoImovel/TipoImovelFormCampos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoImovel/TipoImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoLogradouro/TipoLogradouroForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tipoLogradouro/TipoLogradouroWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tiqueImovelConf/TiqueImovelConfForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tiqueImovelImovel/ConsultaImovelField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tiqueImovelImovel/TiqueImovelImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tiqueImovelImovel/TiqueImovelImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tiqueImovelTipoDependencia/TiqueImovelTipoDependenciaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/tiqueImovelTipoImovel/TiqueImovelTipoImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/transferirCaptacao/TransfereImovelViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/transferirCaptacao/TransfereImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/user/UserAlterarSenhaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/user/UserAlterarTemaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/user/UserAtivosWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/user/UserForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/user/UserGrupoSelectWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/user/UserRoleSelectWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/user/UserWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/veiculoComunicacao/VeiculoComunicacaoEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/veiculoComunicacao/VeiculoComunicacaoEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/veiculoComunicacao/VeiculoComunicacaoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/veiculoComunicacao/VeiculoComunicacaoFotoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/veiculoComunicacao/VeiculoComunicacaoTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/veiculoComunicacao/VeiculoComunicacaoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/ConsultaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/ConsultaReferenciaField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaAcompanhamentoWindowModal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaCompradorEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaCompradorEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaCompradorTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaVendedorEmailForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaVendedorEnderecoForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaVendedorTelefoneForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaParcelasForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaEditaParcelaForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/venda/VendaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/vendaDistribuicaoComissoes/VendaDistribuicaoComissoesViewWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/vendaDistribuicaoComissoes/VendaDistribuicaoComissoesWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/vivaRealConf/VivaRealConfForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/vivaRealImovel/ConsultaImovelField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/vivaRealImovel/VivaRealImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/vivaRealImovel/VivaRealImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/vivaRealTipoDependencia/VivaRealTipoDependenciaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/vivaRealTipoImovel/VivaRealTipoImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/zapImovel/ConsultaImovelField.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/zapConf/ZapConfForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/zapImovel/ZapImovelForm.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/zapImovel/ZapImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/zapTipoDependencia/ZapTipoDependenciaWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/zapTipoImovel/ZapTipoImovelWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/view/banco/BancoWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/agenda/AgendaView.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/agenda/EventoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Agendas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelMesclagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/anuncio/AnuncioCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/anuncio/AnuncioCidadeRegiaoBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/anuncio/AnuncioImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/anuncio/AnuncioSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Anuncios.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/bairro/BairroCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Bairros.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/bairroCorretagem/BairroCorretagemCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/bairroCorretagem/BairroCorretagemUtil.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/BairroCorretagems.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/cadastroMenu/CadastroMenuCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/cadastroMenu/CadastroMenuContextMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CadastroMenus.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/campanha/CampanhaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Campanhas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/carteiraImovel/CarteiraImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CarteiraImoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Chat.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/cidade/CidadeCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Cidades.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/cidadeCorretagem/CidadeCorretagemCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/cidadeCorretagem/CidadeCorretagemPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CidadeCorretagems.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/classeImovel/ClasseImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ClasseImoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/classeInteressado/ClasseInteressadoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ClasseInteressados.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/concorrente/ConcorrenteCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/concorrente/ConcorrenteEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/concorrente/ConcorrenteEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/concorrente/ConcorrenteTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Concorrentes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominioFicha/CondominioPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominioFicha/CondominioConsulta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioCadastraBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioCidadeRegiaoBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioConsulta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioMapa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioPessoaJuridica.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioPessoaJuridicaEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioPessoaJuridicaEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioPessoaJuridicaTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioSindico.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioSindicoEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioSindicoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioSindicoTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioAdministradora.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioAdministradoraEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioAdministradoraEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioAdministradoraTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominio/CondominioSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Condominios.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominioFoto/CondominioFotoImagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominioFoto/CondominioFotoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/condominioFoto/CondominioFotoSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CondominioFotos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/controleChaves/ControleChavesCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/controleChaves/ControleChavesImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/controleChaves/ControleChavesImovelCidadeRegiaoBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/controleChaves/ControleChavesPosicao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ControleChaves.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/corretor/CorretorCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/corretor/CorretorEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/corretor/CorretorEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/corretor/CorretorPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/corretor/CorretorTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Corretores.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificioFicha/EdificioPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioCadastraBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioCidadeRegiaoBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioConsulta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioFotos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioMapa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioTipoImovelPadrao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioSindico.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioSindicoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioSindicoTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioSindicoEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioZelador.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificio/EdificioEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Edificios.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificioFicha/EdificioConsulta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificioFoto/EdificioFotoImagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificioFoto/EdificioFotoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/edificioFoto/EdificioFotoSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/EdificioFotos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/empresa/EmpresaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/empresa/EmpresaEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/empresa/EmpresaEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/empresa/EmpresaTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Empresas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/equipe/EquipeCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/equipe/EquipeCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/equipe/EquipeGerente.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/equipe/EquipePrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Equipes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/estado/EstadoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Estados.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/estatisticaCaptacao/MontaGrafico.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/fichaComprada/FichaCompradaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/fichaComprada/FichaCompradaDBF.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/finalidadeImovel/FinalidadeImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/grupo/GrupoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/grupo/GrupoMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/grupo/GrupoRole.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/grupo/GrupoUsuario.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Grupos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imoveisSite/ExibeImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ImoveisInternet.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelProprietario.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelCadastraBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelCaptacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelChave.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelCidadeRegiaoBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelCondominio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelConsulta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelCopiaReferencia.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelEdificio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelEvolucaoPreco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelExclusao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelFotos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelMapa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelPatrocinio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelPortal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelTipoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelToolBar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovel/ImovelValor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelFicha/ImovelPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Imoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelFicha/ImovelConsulta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelFoto/ImovelFotoImagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelFoto/ImovelFotoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelFoto/ImovelFotoSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ImovelFotos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelLista/CidadeRegiao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelLista/MenuContexto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelPlaca/ImovelPlacaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelPlaca/ImovelPlacaImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelPlaca/ImovelPlacaSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ImovelPlacas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelPlacaRetirar/ImovelPlacaImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelPlacaRetirar/ImovelPlacaRetirarCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ImovelPlacasRetirar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelPromocao/ImovelPromocaoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ImovelPromocoes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelWebConf/ImovelWebConfCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelWebImovel/ImovelWebImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelWebImovel/ImovelWebImovelExcel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelWebImovel/ImovelWebImovelImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelWebTipoDependencia/ImovelWebTipoDependenciaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/imovelWebTipoImovel/ImovelWebTipoImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoAcompanhamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoInteresses.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoNome.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoOfertaImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoPesquisa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoPesquisaTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/InteressadoVisitaImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoCorretor/MenuContexto.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoFastTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoImovelChamado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoImovelCidadeRegiao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoMotivoExclusao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoRodizio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/interessadoRecepcao/InteressadoTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CadastroInteressadosRecepcao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CadastroInteressadosCorretores.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/login/LoginActions.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Login.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Logout.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/logradouro/LogradouroCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Logradouros.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/loja/LojaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/loja/LojaEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/loja/LojaEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/loja/LojaTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Lojas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/mensagem/MensagemCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/mensagem/MensagemConteudo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/mensagem/MensagemMensagemUsuario.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/mensagem/MensagemPasta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Mensagens.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/menu/MenuCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Menus.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/midiaTipo/MidiaTipoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/MidiaTipos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/moeda/MoedaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Moedas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/moedaIndice/MoedaIndiceCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/MoedaIndices.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/notaPromissoria/NotaPromissoriaAvalista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/notaPromissoria/NotaPromissoriaBeneficiario.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/notaPromissoria/NotaPromissoriaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/notaPromissoria/NotaPromissoriaEmitente.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/notaPromissoria/NotaPromissoriaParcela.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/NotaPromissorias.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/papelParede/WallpaperImagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/PapelParedes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/parametroSistema/CidadeRegiao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/parametroSistema/FaixaValor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/parametroSistema/ParametroSistemaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/parametroSistema/TestarEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ParametroSistemas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pesquisaEndereco/PesquisaEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pesquisaEndereco/PesquisaEnderecoCidadeRegiao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pesquisaEndereco/PesquisaEnderecoCondominio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pesquisaEndereco/PesquisaEnderecoEdificio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pesquisaEndereco/PesquisaEnderecoPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/PesquisaImovelEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/PesquisaImovelEnderecoExcluidos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pessoa/PessoaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pessoa/PessoaEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pessoa/PessoaEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pessoa/PessoaTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/pessoa/PessoaBanco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Pessoas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/proposta/CidadeRegiaoBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/proposta/PropostaAcompanhamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/proposta/PropostaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/proposta/PropostaImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/proposta/PropostaInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/proposta/PropostaOferta.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/proposta/PropostaSwitchWindow.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Propostas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/quadroChaves/QuadroChavesCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/QuadroChaves.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/regiaoCorretagem/RegiaoCorretagemCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/regiaoCorretagem/RegiaoCorretagemPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/regiaoCorretagem/RegiaoCorretagemUtil.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RegiaoCorretagems.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/registroLigacoes/RegistroLigacoesCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/registroLigacoes/RegistroLigacoesPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RegistroLigacoes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/rodizio/RodizioCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/rodizio/RodizioCorretor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CadastroRodizios.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/role/RoleCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Roles.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/segmentoImovel/SegmentoImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/SegmentoImoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/textoRelatorios/TextoRelatoriosCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/TextoRelatorios.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tipoDependencia/TipoDependenciaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tipoDependencia/TipoDependenciaPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/TipoDependencias.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tipoEndereco/TipoEnderecoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/TipoEnderecos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tipoImovel/TipoImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tipoImovel/TipoImovelMesclagem.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tipoImovel/TipoImovelPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/TipoImoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tipoLogradouro/TipoLogradouroCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/TipoLogradouros.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/user/UserCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/user/UserEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/user/UserGrupo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/user/UserMenu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/user/UserPessoa.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/user/UserRole.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Users.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/veiculoComunicacao/VeiculoComunicacaoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/veiculoComunicacao/VeiculoComunicacaoEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/veiculoComunicacao/VeiculoComunicacaoEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/veiculoComunicacao/VeiculoComunicacaoTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/VeiculoComunicacaos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/CidadeRegiaoBairro.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaAcompanhamento.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaComissao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaComprador.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaCompradorEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaCompradorEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaCompradorTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaInteressado.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaVendedor.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaVendedorEmail.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaVendedorEndereco.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaVendedorTelefone.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VisualisarVenda.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/venda/VendaParcela.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Vendas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/viewport/Menu.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/viewport/MessageBus.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/viewport/Push.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/viewport/Store.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Viewport.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tiqueImovelConf/TiqueImovelConfCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tiqueImovelImovel/TiqueImovelImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tiqueImovelImovel/TiqueImovelImovelExcel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tiqueImovelImovel/TiqueImovelImovelImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tiqueImovelTipoDependencia/TiqueImovelTipoDependenciaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/tiqueImovelTipoImovel/TiqueImovelTipoImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/vivaRealConf/VivaRealConfCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/vivaRealImovel/VivaRealImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/vivaRealImovel/VivaRealImovelExcel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/vivaRealImovel/VivaRealImovelImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/vivaRealTipoDependencia/VivaRealTipoDependenciaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/vivaRealTipoImovel/VivaRealTipoImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/zapConf/ZapConfCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/zapImovel/ZapImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/zapImovel/ZapImovelExcel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/zapImovel/ZapImovelImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/zapTipoDependencia/ZapTipoDependenciaCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/zapTipoImovel/ZapTipoImovelCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraImovelWeb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoDependenciaEmpreImovelWeb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoDependenciaImovelWeb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoDependenciaTiqueImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoDependenciaVivaReal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoDependenciaZap.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoImovelImovelWeb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoImovelTiqueImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoImovelVivaReal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTipoImovelZap.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraTiqueImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraVivaReal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ConfiguraZap.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/SelecaoImoveisImoWeb.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/SelecaoImoveisTiqueImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/SelecaoImoveisVivaReal.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/SelecaoImoveisZap.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/EstatisticaCaptacoes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/FichasCompradas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/FinalidadeImoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioAnuncioCadastroLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioAnuncioLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioCampanhaSemAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioCondominioLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioCondominioSemFotos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioEdificioLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioEdificioSemFotos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioFichaCondominio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioFichaEdificio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioFichaImovel.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelAtualizacao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelComAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelListaExcluidos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelPlacaRetirar.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelSemAnuncio.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelSemFotos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelSemPlaca.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioImovelVerificacaoPlaca.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioInteressadoAtendimentos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioInteressadoContatos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioInteressadoExcluido.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioInteressadoExpiracaos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioInteressadoInativo.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioInteressadoIncompletos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioInteressadoListas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioInteressadoNovasEntradas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioPropostaExpiracao.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioPropostaLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioPropostaPendenteLista.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioRegistroLigacoes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioRetornoInteressadoCampanha.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/RelatorioVisitas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/VendaDistribuicaoComissoes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CorretorConsultaCondominios.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CorretorConsultaEdificios.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/CorretorConsultaImoveis.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ImoveisSite.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ImoveisExcluidos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/InteressadoExpiradoPromover.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/MensagemDiretas.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/PreInteressados.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/UsuariosAtivos.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/ShowTools.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/TransferirCaptacoes.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/AlterarSenha.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/AlterarTema.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/banco/BancoCRUD.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/banco/BancoPrint.js'
	, '/home/eduardo/vendas/imoveis/grails-app/assets/javascripts/app/controller/Bancos.js'
]
String finalScript = """
Ext.Loader.setConfig( {
	enabled: true
	,paths: {
		'Ext':'assets/ext/src', 'Pinedu': 'assets/app'
	}
} );
Ext.require( [
	'Ext.form.*'
	,'Ext.grid.*'
	,'Ext.data.*'
	,'Ext.ux.grid.FiltersFeature'
	,'Ext.toolbar.Paging'
	,'Ext.ux.ajax.JsonSimlet'
	,'Ext.ux.ajax.SimManager'
	,'Ext.tip.QuickTipManager'
	,'Ext.window.MessageBox'
	,'Ext.tip.*'
] );

/*
Ext.define( 'Ext.ux.MessageBroker', {
	extend: 'Ext.util.Observable'
	,statics: {
		instance: null
		,application: null
		,setInstance: function( i, application ) {
			this.instance = i;
			this.application = application;
		},
		sendMessage: function( msg, data ) {
			this.fireEvent( 'message',{"msg":msg,"data":data} );
		}
	}
	,constructor: function( config ){
		this.addEvents( {"message" : true} );
		if( config && config.listeners ) this.listeners = config.listeners;
		Ext.ux.MessageBroker.superclass.constructor.call( this, config );
	}
} );
Ext.define( 'Ext.ux.AcaoMensagem', {
	extend: 'Ext.util.Observable'
	,init: function( cmp ){
		this.cmp = cmp;
		this.cmp.on( 'render', this.onRender, this );
	}
	,onRender: function( ) {
		this.cmp.getToolbar( ).add( [
		 	{ xtype: 'tbspacer' }
		 	,
			{
				iconCls: 'accept'
				,scope: this
				,itemId: 'botaoAcao'
				,handler: function( ) {
					this.cmp.up( 'window' ).fireEvent( 'executarAcao', this, this.cmp );
				}
			}
		] );
	}
} );
*/
Ext.override( Ext.data.proxy.Server, { timeout: 10 * 60 * 1000 } );
Ext.BLANK_IMAGE_URL = 'assets/s.gif';
Ext.JSON.encodeDate = function( d ) {
	return Ext.Date.format( Ext.Date.add( d,Ext.Date.MINUTE, d.getTimezoneOffset( ) ), '"Y-m-d\\TG:H:i\\Z"' );
};
Ext.application( {
	name: 'Pinedu'
	,requires: [
		'Pinedu.controller.Viewport'
	]
	,mapaStatusImovel: {'D': 'Disponível', 'T': 'Temporário', 'E': 'Excluído', 'A': 'Alugado', 'P': 'Pré Imóvel', 'R': 'Recusado'}
	,windows: new Ext.util.MixedCollection( )
	,activeWindowCls: 'pinedu-desktop-active-win'
	,inactiveWindowCls: 'pinedu-desktop-inactive-win'
	,autoCreateViewport: true
	,launch: function( ) {
		try{ sessionStorage.clear( ); } catch( er ) {}
		Ext.QuickTips.init( );
		window.extApplication = this;
		this.appMask = new Ext.LoadMask( Ext.getBody( ), {msg: "Por favor aguarde! Carregando o aplicativo...", toFrontOnShow: true} );
		this.showMask( );
		var controller = this.getController( 'Viewport' );
	}
	,runAction:function( controllerName, actionName, eOpts ) {
		var controller = this.getController( controllerName );
		this.showMask( );
		controller.init( this );
		controller.actionName = controllerName;
		controller['action'+actionName]( this, eOpts );
	}
	,getViewport: function( ) {
		if ( typeof this.viewport == 'undefined' ) {
			this.viewport = Ext.ComponentQuery.query( 'viewport' )[0];
		}
		return this.viewport;
	}
	,getDesktop: function( ) {
		if ( typeof this.desktop == 'undefined' ) {
			var me = this;
			this.desktop = this.getViewport( ).down( 'desktop[name=desktop]' );
			this.desktop.down( 'button[name=showdesktop]' ).on( 'click', function( ) {me.showDesktop( );} );
			var fsButton = this.desktop.down( 'button[name=fullscreen]' );
			fsButton.on( 'click', function( ) {me.toggleFullScreen( fsButton );} );
			this.desktop.down( 'button[name=desktop-help]' ).on( 'click', function( ) {me.onShowHelp( 'desktop' );} );
			this.desktop.getEl( ).on( 'contextmenu', function( event, htmlElement, eOpts ) {
				if ( event.button == 2 ) {
					event.stopEvent( );
					var m = new Ext.menu.Menu( {floating: true} );
					m.add( Ext.create( 'Ext.menu.Item', {text: 'Lado a Lado', handler: me.tileWindows, scope: me, iconCls: 'pinedu-desktop-lado-lado', tooltip: 'Colocar todas as janelas ativas lado a lado', disabled: ( me.windows.getCount( ) <= 0 )} ) );
					m.add( Ext.create( 'Ext.menu.Item', {text: 'Em Cascata', handler: me.cascadeWindows, scope: me, iconCls: 'pinedu-desktop-cascade', tooltip: 'Colocar todas as janelas ativas em cascata', disabled: ( me.windows.getCount( ) <= 0 )} ) );
					m.add( Ext.create( 'Ext.menu.Item', {text: 'Minimizar Todas', handler: me.showDesktop, scope: me, iconCls: 'pinedu-desktop-icon', tooltip: 'Minimizar todas as janelas ativas', disabled: ( me.windows.getCount( ) <= 0 )} ) );
					m.add( Ext.create( 'Ext.menu.Separator' ) );
					m.add( Ext.create( 'Ext.menu.Item', {text: 'Fechar Todas', handler: me.closeAllWindows, scope: me, iconCls: 'pinedu-desktop-fechar', tooltip: 'Fechar todas as janelas ativas', disabled: ( me.windows.getCount( ) <= 0 )} ) );
					m.add( Ext.create( 'Ext.menu.Separator' ) );
					m.add( Ext.create( 'Ext.menu.Item', {text: 'Papel de Parede', handler: function( ) {me.runAction( 'PapelParedes', 'Index' );}, scope: me, iconCls: 'papelParede', tooltip: 'Alterar papel de parede'} ) );
					m.showAt( event.getXY( ) );
				}
			} ); 
		}
		return this.desktop;
	}
	,getWindowSpace: function( ) {
		if ( typeof this.windowSpace == 'undefined' ) {
			this.windowSpace = this.getDesktop( ).down( 'dataview[name=window-container]' );
		}
		return this.windowSpace;
	}
	,getTaskbar: function( ) {
		if ( typeof this.taskbar == 'undefined' ) {
			this.taskbar = this.getDesktop( ).down( 'toolbar[name=taskbar-container]' );
		}
		return this.taskbar;
	}
	,switchMainView: function( view, controller, onOpenView, onCloseView ) {
		var me = this;
		if ( this.activeView ) {
			this.returnView = this.activeView;
		}
		this.showMask( );
		controller.init( this );
		if ( typeof onOpenView == 'function' ) {
			onOpenView( );
		}
		if ( typeof onCloseView == 'function' ) {
			view.on( "close", function( panel, eOpts ) {
				var record;
				try {record = controller.getRecord( );}catch(e){}
				onCloseView( record );
			}, me );
		}
		this.setMainView( view, controller )
	}
	,setMainView: function( view, controller, notInTaskBar ) {
		var desktop = this.getDesktop( )
			, me = this;
		//this.getWindowSpace( ).add( view );
		//taskbar
		if ( notInTaskBar !== true && this.windows.contains( view ) === false ) {
			me.windows.each( function( win ) {
				win.removeCls( me.activeWindowCls );
				win.addCls( me.inactiveWindowCls );
			} );
			view.taskButton = this.addTaskButton( view, controller.actionName );
			view.on( {
				activate: me.updateActiveWindow
				,beforeshow: me.updateActiveWindow
				,focus: me.updateActiveWindow
				,deactivate: me.updateActiveWindow
				,beforeclose: me.onBeforeClose
				,minimize: me.onMinimizeWindow
				,destroy: me.onWindowClose
				,showHelp: me.onShowHelp
				,scope: me
			} );
			view.addCls( me.activeWindowCls );

			view.on( {
				afterrender: function ( ) {
					view.dd.xTickSize = me.xTickSize;
					view.dd.yTickSize = me.yTickSize;

					if ( view.resizer ) {
						view.resizer.widthIncrement = me.xTickSize;
						view.resizer.heightIncrement = me.yTickSize;
					}
				}
				,single: true
			} );
			this.windows.add( view );
		}
		view.toFront( true );
		this.activeView = view;
	}
	,closeWindowFromButtom: function( button ) {
		button.view.close( );
	}
	,minimizeWindowFromButtom: function( button ) {
		button.view.minimize( );
	}
	,maximizeWindowFromButtom: function( button ) {
		this.restoreWindowFromButtom( button );
		button.view.maximize( );
	}
	,restoreWindowFromButtom: function( button ) {
		if ( button.view.minimized || button.view.hidden ) {
			button.view.show( );
		} else {
			button.view.center( );
			button.view.toFront( );
		}
	}
	,addTaskButton: function( view, actionName ) {
		var me = this, button = Ext.create( 'Ext.button.Button', {
			cls: 'pinedu-toolbar-button'
			,scale: 'medium'
			,iconCls: view.iconCls
			,enableToggle: true
			,toggleGroup: 'all'
			,width: 150
			,text: Ext.util.Format.ellipsis( view.title, 25 )
			,textAlign: 'left'
			,listeners: {
				click: this.onTaskButtonClick
				,scope: this
			}
		} );
		button.view = view;
		me.windows.each( function( win ) {
			win.taskButton.toggle( false );
		} );
		button.toggle( true );
		this.getTaskbar( ).add( button );
		try {button.getEl( ).on( 'contextmenu', function( event, htmlElement, eOpts ) {eOpts.button = button, eOpts.actionName = actionName; me.onTaskButtomContextMenu( event, htmlElement, eOpts );} );} catch( e ){}
		return button;
	}
	,removeTaskButton: function( btn ) {
		var found;
		this.getTaskbar( ).items.each( function ( item ) {
			if ( item === btn ) {
				found = item;
			}
			return !found;
		} );
		if ( found ) {
			this.taskbar.remove( found );
		}
		return found;
	}
	,onTaskButtonClick: function( btn, event, eOpts ) {
		var view = btn.view;
		if ( !view ) return;
		if ( view.minimized || view.hidden ) {
			view.show( );
		} else if ( view.active ) {
			view.minimize( );
		} else {
			view.toFront( );
		}
	}
	,onTaskButtomContextMenu: function( event, htmlElement, eOpts ) {
		if ( event.button == 2 ) {
			event.stopEvent( );
			var m = new Ext.menu.Menu( {floating: true} ), me = this;
			m.add( Ext.create( 'Ext.menu.Item', {text: 'Criar Atalho', handler: 
				function( ) {
					Ext.Ajax.request( {
						url: 'user/adicionaAtalho'
						,params: { actionName: eOpts.actionName }
						,success: function( response ) {
							var obj = Ext.JSON.decode( response.responseText, true );
							me.getWindowSpace( ).getStore( ).add( Ext.create( 'Pinedu.model.Menu', obj.menus[0] ) );
						}
					} );
				
				}
				, scope: me, iconCls: 'pinedu-desktop-criar-atalho', tooltip: 'Criar atalho a este programa na área de trabalho'} ) );
			m.add( Ext.create( 'Ext.menu.Separator' ) );
			m.add( Ext.create( 'Ext.menu.Item', {text: 'Restaurar', handler: function( botao, event ) {me.restoreWindowFromButtom( eOpts.button );}, scope: me, iconCls: 'pinedu-desktop-restaurar', tooltip: 'Restaurar esta Janela', disabled: !( eOpts.button.view.hidden || eOpts.button.view.maximized )} ) );
			m.add( Ext.create( 'Ext.menu.Item', {text: 'Maximizar', handler: function( botao, event ) {me.maximizeWindowFromButtom( eOpts.button );}, scope: me, iconCls: 'pinedu-desktop-maximizar', tooltip: 'Maximizar esta Janela', disabled: eOpts.button.view.maximized} ) );
			m.add( Ext.create( 'Ext.menu.Item', {text: 'Minimizar', handler: function( botao, event ) {me.minimizeWindowFromButtom( eOpts.button );}, scope: me, iconCls: 'pinedu-desktop-minimizar', tooltip: 'Minimizar esta Janela', disabled: eOpts.button.view.hidden} ) );
			m.add( Ext.create( 'Ext.menu.Separator' ) );
			m.add( Ext.create( 'Ext.menu.Item', {text: 'Fechar', handler: function( botao, event ) {me.closeWindowFromButtom( eOpts.button );}, scope: me, iconCls: 'pinedu-desktop-fechar', tooltip: 'Fechar esta Janela'} ) );
			m.showAt( event.getXY( ) );
		}
	}
	,setTaskButtonActive: function( btn ) {
		if ( btn ) {
			btn.toggle( true );
		} else {
			this.getTaskbar( ).items.each( function ( item ) {
				if ( item.isButton ) {
					item.toggle( false );
				}
			} );
		}
	}
	,updateActiveWindow: function ( ) {
		var me = this 
			, activeWindow = me.getActiveWindow( ) 
			, last = me.lastActiveWindow;
			
/*		me.windows.each( function( win ) {
			win.taskButton.toggle( false );
		} );
*/		
		if ( activeWindow === last ) {
			return;
		}
		if ( last ) {
//			if ( last.getEl( ).dom ) {
//				last.addCls( me.inactiveWindowCls );
//				last.removeCls( me.activeWindowCls );
//			}
			last.active = false;
		}
		me.lastActiveWindow = activeWindow;
		if ( activeWindow ) {
//			activeWindow.addCls( me.activeWindowCls );
//			activeWindow.removeCls( me.inactiveWindowCls );
			activeWindow.minimized = false;
			activeWindow.active = true;
			if ( activeWindow.taskButton ) activeWindow.taskButton.toggle( true );
		}
		me.setTaskButtonActive( activeWindow && activeWindow.taskButton );
	}
	,onWindowClose: function( view ) {
		var me = this;
		try {
			me.windows.remove( view );
			me.removeTaskButton( view.taskButton );
			me.updateActiveWindow( );
			
		} catch( e ){}
	}
	,onBeforeClose: function( view ) {
		try {
			var combos = view.down( 'combobox' ), store;
			if ( combos != null ) {
				for ( var i = 0; i < combos.length; i++ ) {
					store = combos[i].getStore( );
					if ( !store.isFiltered( ) || store.remoteFilter ) continue;
					combos[i].getStore( ).clearFilter( true );
				}
			}
		} catch( er ){
			console.log( view );
			console.log( er );
		}
	}
	,onMinimizeWindow: function( view ){
		view.minimized = true;
		view.taskButton.toggle( false, true );
		view.hide( );
	}
	,getActiveWindow: function ( ) {
		var win = null, zmgr = this.getDesktopZIndexManager( );
		if ( zmgr ) {
			// We cannot rely on activate/deactive because that fires against non-Window components in the stack.
			zmgr.eachTopDown( function ( comp ) {
				if ( comp.isWindow && !comp.hidden ) {
					win = comp;
					return false;
				}
				return true;
			} );
		}
		return win;
	}
	,getDesktopZIndexManager: function ( ) {
		var windows = this.windows;
		// TODO - there has to be a better way to get this...
		return ( windows.getCount( ) && windows.getAt( 0 ).zIndexManager ) || null;
	}
	,showDesktop: function( ) {
		var me = this;
		this.windows.each( function ( view ) {
			if ( view.isWindow && !view.hidden ) {
				me.onMinimizeWindow( view );
			}
		} );
	}
	,cascadeWindows: function( ) {
		var x = 0, y = 48, zmgr = this.getDesktopZIndexManager( );
		zmgr.eachBottomUp( function( win ) {
			if ( win.isWindow && win.isVisible( ) && !win.maximized ) {
				win.setPosition( x, y );
				x += 32;
				y += 32;
			}
		} );
	}	
	,tileWindows: function( ) {
		var me = this, availWidth = window.innerWidth, availHeight = window.innerHeight - 200;
		var x = 0, y = 48, nextY = y;
		me.windows.each( function( win ) {
			if ( win.isVisible( ) && !win.maximized ) {
				if ( win.getHeight( ) > nextY ) {
					nextY = win.getHeight( );
				}
				if ( x > availWidth - 100 ) {
					x = 0;
					y = nextY;
				}
				if ( y > availHeight ) {
					x = 0;
					y = 48;
				}
				win.setPosition( x, y );
				x = x + win.getWidth( );
			}
		} );
	}
	,closeAllWindows: function( ) {
		this.windows.each( function( win ) { win.close( ); } );
	}
	//taskbar
	,updateWallPaper: function( record ) {
		var desktop = this.getWindowSpace( )
			, url;
		if ( record == null ) {
			url = Ext.BLANK_IMAGE_URL + '?a=1';
		} else {
			url = 'arquivo/thumb?local=' + record.get( 'path' ) + '&pasta=' + record.get( 'idMask' ) + '&nome=' + record.get( 'nome' );
		}
		desktop.setWallpaper( url, 'centered' );
	}
	//desktop
	/**
	 * Instala Atalhos
	 */
	,instalaAtalhosUsuario: function( user ) {
		var me = this, ws = this.getWindowSpace( );
		ws.bindStore( user.atalhos( ) );
		
		ws.on( 'itemkeydown',    function( view, record, item, index, event, eOpts ){ me.onDesktopShortCutKeyDown( view, record, item, index, event, eOpts ); } );
		//ws.on( 'itemmouseenter', function( view, record, item, index, event, eOpts ){ me.onDesktopShortMouseEnter( view, record, item, index, event, eOpts ); } );
		//ws.on( 'itemmouseleave', function( view, record, item, index, event, eOpts ){ me.onDesktopShortMouseLeave( view, record, item, index, event, eOpts ); } );
		ws.on( 'itemclick', function( view, record, item, index, event, eOpts ){ me.onDesktopShortClick( view, record, item, index, event, eOpts ); } );
		ws.on( 'itemdblclick', function( view, record, item, index, event, eOpts ){ me.runAction( record.get( 'action' ), 'Index' ); } );
		ws.on( 'itemcontextmenu', function( view, record, item, index, event, eOpts ){
			event.stopEvent( );
			if ( event.button === 2 ) {
				var m = new Ext.menu.Menu( {floating: true} );
				m.add( Ext.create( 'Ext.menu.Item', {text: 'Executar', handler: function( ) { me.runAction( record.get( 'action' ), 'Index' );}, scope: me, iconCls: 'pinedu-desktop-executar', tooltip: 'Executar programa'} ) );
				m.add( Ext.create( 'Ext.menu.Item', {text: 'Excluir atalho', handler: 
					function( ) {
						Ext.Ajax.request( {
							url: 'user/excluirAtalho'
							,params: { id: record.get( 'id' ) }
							,success: function( response ) {
								user.atalhos( ).remove( record );
							}
						} );
					}
					, scope: me, iconCls: 'pinedu-desktop-excluir-atalho', tooltip: 'Excluir Atalho para aplicativo'} ) );
				m.showAt( event.getXY( ) );
				return false;
			}
			return false;
		} );
	}
	,onDesktopShortClick: function( view, record, item, index, event, eOpts ) {
		if ( typeof view.selecionado != 'undefined' ) {
			Ext.fly( view.selecionado ).removeCls( 'pinedu-desktop-shortcut-x-view-selected' );
		}
		Ext.fly( item ).addCls( 'pinedu-desktop-shortcut-x-view-selected' );
		view.selecionado = item;
	}
	,onDesktopShortCutKeyDown: function( view, record, item, index, event, eOpts ) {
		var key = event.getKey( );
		if ( key == event.ENTER || ( key == event.SPACE ) ) {
			this.runAction( record.get( 'action' ), 'Index' );
		}
	}
	,onDesktopShortMouseEnter: function( view, record, item, index, event, eOpts ) {
		view.addCls( 'x-view-selector' );
	}
	,onDesktopShortMouseLeave: function( view, record, item, index, event, eOpts ) {
		view.removeCls( 'x-view-selector' );
	}
	,exibeInteressadoMensagem: function( codigo ) {
		this.showMask( );
		this.runAction( 'CadastroInteressadosCorretores', 'Index' );
	}
	,configuraParametroEmpresa: function( ) {
		this.showMask( );
		this.runAction( 'ParametroSistemas', 'Index' );
	}
	,configuraEmpresa: function( ) {
		this.showMask( );
		this.runAction( 'Empresas', 'Index' );
	}
	,showMask: function( ) {
		this.appMask.show( );
	}
	,hideMask: function( ) {
		this.appMask.hide( );
	}
	,hasPrivilegio: function( privilegio ) {
		if ( typeof this.privilegioMap == 'undefined' ) {
			this.privilegioMap = new Object( );
			var me = this;
			for ( var i = 0; i < this.user.authorities( ).count( ); i++ ) {
				me.privilegioMap[this.user.authorities( ).getAt( i ).get( 'authority' )] = true;
			}
			for ( var i = 0; i < this.user.authoritiesNegadas( ).count( ); i++ ) {
				me.privilegioMap[this.user.authoritiesNegadas( ).getAt( i ).get( 'authority' )] = false;
			}
		}
		return ( this.privilegioMap[privilegio] == true? true: false );
	}
	,onWrite: function( proxy, response, operation ) {
		var json = Ext.decode( response.response.responseText );
		var txt = '';
		if ( typeof json == "object" ) {
			txt = json.message
		} else {
			txt = json;
		}
		Ext.Msg.show( {
			title:'Sucesso!'
			,msg: txt
			,modal: true
			,icon: Ext.Msg.INFO
			,buttons:Ext.Msg.OK
		} ).toFront( true );
	}
	,onProxyException: function( proxy, response, operation ) {
		var json = Ext.decode( response.responseText );
		var errorTxt = '';
		if ( json.errors ) {
			if ( typeof json.errors == 'string' ) {
				errorTxt = json.errors;
			} else {
				Ext.Array.forEach( json.errors, function( error ) {
					errorTxt = errorTxt + '<p>Campo ' + error.id + ': ' + error.msg + '</p>';
				} );
			}
		} else {
			errorTxt = json.message;
		}
		errorTxt = errorTxt + '<p style="margin-top:10px;">A opera&ccedil;&atilde;o n&atilde;o foi conclu&iacute;da</p>';
		Ext.MessageBox.show( {
			title: 'Erro!',
			msg: errorTxt,
			icon: Ext.MessageBox.ERROR,
			buttons: Ext.Msg.OK,
			modal: true
		} );
	}
	,leAssociacoes: function( reader, origem, destino ) {
		reader.readAssociated( destino, origem.getData( true ) );
	}
	,callbackCacheStore: function( store, operation, myRecords ) {
		var i = 0, r = [], me = operation.scope.application, model = null, rec = null, ehArray = ( Object.prototype.toString.call( myRecords ) == '[object Array]' );
		if ( ehArray ) {
			for ( ; i < myRecords.length; i++ ) {
				rec = myRecords[i];
				model = Ext.create( store.model, rec.getData( true ) );
				me.leAssociacoes( store.getProxy( ).getReader( ), rec, model );
				r[i] = model;
			}
		} else {
			for ( ; i < myRecords.length; i++ ) {
				rec = myRecords.items[i];
				model = Ext.create( store.model, rec.getData( true ) );
				me.leAssociacoes( store.getProxy( ).getReader( ), rec, model );
				r[i] = model;
			}
		}
		store.loadRecords( r );
		store.loading = false;
		if ( typeof operation.callback == 'function' ) {
			Ext.callback( operation.callback, operation.scope, [r, operation, true] );
		}
	}
	,onStoreCacheLoad: function( theStore, store, records, success, eOpts ) {
		var i = 0, model = null, rec = null, r = [];
		if ( theStore.count( ) <= 0 ) {
			for ( ;i < records.length; i++ ) {
				rec = records[i];
				model = Ext.create( theStore.model, rec.getData( true ) );
				this.leAssociacoes( store.getProxy( ).getReader( ), rec, model );
				r[i] = model;
			}
			theStore.add( r );
			theStore.sync( );
		} else {
			var changed = false, indices = {};
			for ( i = 0; i < records.length; i++ ) {
				indices[records[i].data.id] = records[i].data.id;
			}
			for ( i = 0; i < records.length; i++ ) {
				rec = records[i];
				if ( typeof indices[rec.data.id] == 'undefined' ) {
					model = Ext.create( theStore.model, rec.getData( true ) );
					this.leAssociacoes( store.getProxy( ).getReader( ), rec, model );
					r[r.length] = model;
					changed = true;
				}
			}
			if ( changed == true ) {
				theStore.add( r );
				theStore.sync( );
			}
			indices = null;
		}
	}
	,controllers: []
	/**
	 * Full Screen API
	 */
	/**
	 * Check if window is in full screen mode.
	 * @return {Boolean} full screen mode
	 */
	,isInFullScreen: function( ) {
		if( document.fullScreenElement !==undefined ){
		   return !!document.fullScreenElement;
		}
		if( document.mozFullScreen !== undefined ){
			return !!document.mozFullScreen;
		}
		if( document.webkitIsFullScreen !== undefined ){
			return !!document.webkitIsFullScreen;
		}
		if( window['fullScreen'] !== undefined ) {
			return !!window.fullScreen;
		}
		if( window.navigator.standalone !== undefined ){
			return !!window.navigator.standalone;
		}
		//________________________________________________________
		// heuristic method
		// 5px height margin, just in case ( needed by e.g. IE )
		var heightMargin = 5;
		if( Ext.isWebKit && /Apple Computer/.test( navigator.vendor ) ) {
			// Safari in full screen mode shows the navigation bar,which is 40px
			heightMargin = 42;
		}
		return screen.width == window.innerWidth &&
			Math.abs( screen.height - window.innerHeight ) < heightMargin;
	}
	/**
	 * Switch to/from fullscreen mode.
	 * Must be triggered by mouse event
	 *
	 * @param {Boolean} b on/off fullscreen
	 */
	,setFullScreen: function( b ){
		if( b ){
			if ( document.documentElement.requestFullscreen ) {
				document.documentElement.requestFullscreen( );
			} else if ( document.body.requestFullscreen ) {
				document.body.requestFullscreen( );
			} else if ( document.documentElement.mozRequestFullScreen ) {
				document.documentElement.mozRequestFullScreen( );
			} else if ( document.documentElement.webkitRequestFullscreen ) {
				document.documentElement.webkitRequestFullscreen( Element.ALLOW_KEYBOARD_INPUT );
			} else if ( document.body.webkitRequestFullScreen ) {
				document.body.webkitRequestFullScreen( );
			} else if( typeof window.ActiveXObject != "undefined" ){
				// for Internet Explorer
				var wscript = new ActiveXObject( "WScript.Shell" );
				if( wscript != null ){
					wscript.SendKeys( "{F11}" );
				}
			}
		} else {
			if ( document.cancelFullScreen ) {
				document.cancelFullScreen( );
			} else if ( document.mozCancelFullScreen ) {
				document.mozCancelFullScreen( );
			} else if ( document.webkitCancelFullScreen ) {
				document.webkitCancelFullScreen( );
			} else if( document.exitFullscreen ){
				document.exitFullscreen( );
			} else if( typeof window.ActiveXObject != "undefined" ){
				// for Internet Explorer
				var wscript = new ActiveXObject( "WScript.Shell" );
				if( wscript != null ){
					wscript.SendKeys( "{F11}" );
				}
			}
		}
	}
	/**
	 * Toggle full screen mode.
	 * @return {Boolean} the new full-screen mode
	 */
	,toggleFullScreen:function( button ){
		var isInFullScreen = this.isInFullScreen( );
		if ( isInFullScreen ) {
			this.setFullScreen( false );
			button.setIconCls( 'pinedu-desktop-fullscreen' );
			button.setTooltip( {text: 'Exibir navegador em modo de Tela cheia'} ); 
		} else {
			this.setFullScreen( true );
			button.setIconCls( 'pinedu-desktop-exit-fullscreen' );
			button.setTooltip( {text: 'Sair do modo de Tela cheia'} ); 
		}
		return this.isInFullScreen( );
	}
	,imprimir: function( titulo, iconClass, url ) {
		var formPrint = Ext.create( 'Pinedu.view.desktop.PrintWindow', {title: titulo, iconCls: iconClass} );
		formPrint.down( 'box' ).autoEl.src = url.replace( /\"/g,'' );
		formPrint.show( );
	}
	,onShowHelp: function( widget, context, eOpts ) {
		var formHelp = Ext.create( 'Pinedu.view.desktop.HelpWindow' )
			,mask = 'widget.'
			,corte = widget.indexOf( mask )
			,viewportBox = this.getViewport( ).getBox( )
			,url = widget;
		if ( corte >= 0 ) {
			url = widget.substr( mask.length, widget.length );
		}
		console.log( helpUrl + '/' + url );
		formHelp.x = viewportBox.width - formHelp.width;
		formHelp.y = 0;
		formHelp.setHeight( viewportBox.height );
		formHelp.down( 'box' ).autoEl.src = helpUrl + '/' + url;
		formHelp.show( );
	}
	, novaPessoa: function( sexo, tipoPessoa ) {
		if ( typeof sexo == 'undefined' ) sexo = 'M'; 
		if ( typeof tipoPessoa == 'undefined' ) tipoPessoa = 'F'; 
		return Ext.create( 'Pinedu.model.Pessoa', {
			nome: ''
			, codNome: ''
			, tipoPessoa: tipoPessoa
			, sexo: sexo
			, ativo: true
			, codigo: 0
			, rg: ''
			, cpf: ''
			, observacoes: ''
			, ativo: true
			, nacionalidade: 'Brasileira'
			, estadoCivil: 'SOLTEIRO'
		} );
	}
	,novoCorrentista: function(tipoPessoa, sexo) {
		var correntista = Ext.create( 'Pinedu.model.Correntista', {
			ativo: true
			, cobraDoc: true
			, cobraCpmf: true
			, cobraCorreio: true
		} );
		correntista.pessoaHasOneInstance = this.novaPessoa( sexo, tipoPessoa);
		correntista.conjugeHasOneInstance = this.novaPessoa( sexo == 'M'? 'F': 'M' );
		return correntista
	}
} );

"""
// Apenas combinar e indentação (código legível)
def combinedJs = combineJavaScriptFiles(jsFilePaths, finalScript)
//
//def compressJavaScript(jsCode, isMinified = true, isMunged = true, isPreserveAllSemiColons = false, isDisableOptimizations = false) {
def combinedAndFormattedJs = compressJavaScript(combinedJs, false, true, true, false)
def combinedOutputFilePath = '/home/eduardo/app-debug.js'
new File(combinedOutputFilePath).write(combinedAndFormattedJs)
println "JavaScript combinado e formatado salvo em: $combinedOutputFilePath"

// Minificar e salvar o JavaScript em uma única linha
def minifiedJs = compressJavaScript(combinedJs, true)
def minifiedOutputFilePath = '/home/eduardo/app.min.js'
new File(minifiedOutputFilePath).write(minifiedJs)
println "JavaScript minificado (em uma linha) salvo em: $minifiedOutputFilePath"


// Classe personalizada para o ErrorReporter
class CustomErrorReporter implements ErrorReporter {
    @Override
    void warning(String message, String sourceName, int line, String lineSource, int lineOffset) {
        println "Aviso: ${message} (linha: ${line})"
    }

    @Override
    void error(String message, String sourceName, int line, String lineSource, int lineOffset) {
        println "Erro: ${message} (linha: ${line})"
    }

    @Override
    EvaluatorException runtimeError(String message, String sourceName, int line, String lineSource, int lineOffset) {
        println "Erro de execução: ${message} (linha: ${line})"
        return new EvaluatorException(message)
    }
}

