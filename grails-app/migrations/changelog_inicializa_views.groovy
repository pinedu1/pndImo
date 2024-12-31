databaseChangeLog = {
	changeSet(author: "eduardo", id: "INICIAL_VIEWS") {
		grailsChange {
			change {
				sql.execute("""
				CREATE VIEW vw_click_parametro_referencia AS SELECT COUNT(cp.value) AS qtde, cp.key AS key, cp.value AS referencia FROM click_parametro AS cp WHERE cp.key = 'referencia' GROUP BY cp.value, cp.key; 
				""")
			}
		}
	}

}