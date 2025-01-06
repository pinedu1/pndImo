databaseChangeLog = {
	changeSet(author: "eduardo", id: "INICIAL_VIEWS") {
		grailsChange {
			change {
				sql.execute("""
				CREATE VIEW vw_click_parametro_referencia AS SELECT COUNT(cp.value) AS qtde, cp.key AS key, cp.value AS referencia FROM click_parametro AS cp WHERE cp.key = 'referencia' GROUP BY cp.value, cp.key;
				CREATE VIEW buffer_tipo_imovel AS
					SELECT 
						DISTINCT(ti.id) AS tipo_imovel_id
						, ti.nome AS nome
						, ti.sigla AS sigla
						, ctr.tipo_contrato AS tipo_contrato
						, i.status_imovel as status_imovel
					FROM imovel AS i
					INNER JOIN tipo_imovel AS ti ON i.tipo_imovel_id = ti.id
					INNER JOIN imovel_contrato AS ctr ON ctr.imovel_id=i.id
					WHERE (ctr.data_atualizacao + ( (interval '1 day') * ( SELECT validade_imovel_internet FROM parametros_sistema WHERE id = 1 ))::interval ) >= now();
				CREATE VIEW buffer_cidade AS 
					SELECT 
						DISTINCT(cc.id) AS cidade_id
						, cc.nome AS nome
						, ctr.tipo_contrato AS tipo_contrato
						, ti.id AS tipo_imovel_id
						, i.status_imovel AS status_imovel
					FROM imovel as i
					INNER JOIN imovel_endereco AS ie on i.endereco_id=ie.id
					INNER JOIN bairro_corretagem as bc on ie.bairro_corretagem_id=bc.id
					INNER JOIN regiao_corretagem as rc on rc.id=bc.regiao_id
					INNER JOIN cidade_corretagem as cc on cc.id=rc.cidade_id
					INNER JOIN tipo_imovel as ti on ti.id=i.tipo_imovel_id
					INNER JOIN imovel_contrato as ctr on ctr.imovel_id=i.id
					WHERE (ctr.data_atualizacao + '1 day'::interval * (( SELECT parametros_sistema.validade_imovel_internet FROM parametros_sistema WHERE parametros_sistema.id = 1))::double precision) >= now();
				CREATE VIEW buffer_regiao AS 
					SELECT 
						DISTINCT(rc.id) AS regiao_id
						, rc.nome AS nome
						, cc.id AS cidade_id
						, ctr.tipo_contrato AS tipo_contrato
						, ti.id AS tipo_imovel_id
						, i.status_imovel AS status_imovel
					FROM imovel as i
					INNER JOIN imovel_endereco AS ie on i.endereco_id=ie.id
					INNER JOIN bairro_corretagem as bc on ie.bairro_corretagem_id=bc.id
					INNER JOIN regiao_corretagem as rc on rc.id=bc.regiao_id
					INNER JOIN cidade_corretagem as cc on cc.id=rc.cidade_id
					INNER JOIN tipo_imovel as ti on ti.id=i.tipo_imovel_id
					INNER JOIN imovel_contrato as ctr on ctr.imovel_id=i.id
					WHERE (ctr.data_atualizacao + '1 day'::interval * (( SELECT parametros_sistema.validade_imovel_internet FROM parametros_sistema WHERE parametros_sistema.id = 1))::double precision) >= now();
				CREATE VIEW buffer_faixa_valor AS 
					SELECT 
						DISTINCT(fx.id) AS faixa_valor_id
						,fx.valor_inicial AS valor_inicial
						,fx.valor_final AS valor_final
						, cc.id AS cidade_id
						, rc.id AS regiao_id
						, ti.id AS tipo_imovel_id
						, ctr.tipo_contrato AS tipo_contrato
						, i.status_imovel AS status_imovel
					FROM imovel AS i
					INNER JOIN imovel_endereco as ie on i.endereco_id=ie.id
					INNER JOIN bairro_corretagem as bc on ie.bairro_corretagem_id=bc.id
					INNER JOIN regiao_corretagem as rc on bc.regiao_id=rc.id
					INNER JOIN cidade_corretagem cc on rc.cidade_id=cc.id
					INNER JOIN tipo_imovel as ti on i.tipo_imovel_id=ti.id
					INNER JOIN imovel_contrato as ctr on i.id=ctr.imovel_id
					INNER JOIN faixa_valor as fx on fx.tipo_contrato = ctr.tipo_contrato
					WHERE ( (ctr.data_atualizacao + '1 day'::interval * (( SELECT parametros_sistema.validade_imovel_internet FROM parametros_sistema WHERE parametros_sistema.id = 1))::double precision) >= now() ) AND
						( 
							( ctr.valor between fx.valor_inicial AND fx.valor_final ) OR 
							( ((fx.valor_inicial IS NULL) OR (fx.valor_inicial <= 0)) AND (ctr.valor <= fx.valor_final) ) OR
							( ((fx.valor_final IS NULL) OR (fx.valor_final <= 0)) AND (ctr.valor >= fx.valor_inicial) )
						);
				""")
			}
		}
	}

}