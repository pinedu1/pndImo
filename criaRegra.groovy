int index = 291
List<Map<String,String>> lista = [
	[action: 'CREATE', nome: 'Criar']
	, [action: 'DELETE', nome: 'Excluir']
	, [action: 'READ', nome: 'Recuperar']
	, [action: 'UPDATE', nome: 'Atualizar']
]
[ 'EMAIL' ].each{ domain->
	lista.each{ Map<String,String> mapaAcao->
		String acao = mapaAcao.action
		String nome = mapaAcao.nome
		println "${++index},0,\"ROLE_${domain}_${acao}\",\"Permite ${nome.toLowerCase().capitalize()} Existente\",True"
	}
}
index = 291
println "grupo_regra(grupo_id,role_id)"
List<Integer> grps = [1..4]
(3..3).each{ grupo_id->
	(index..(index+4)).each{ role_id->
		println "${grupo_id},${role_id}"
	}
}
index = 291
println "usuario_regra(user_id,role_id)"
(1..2).each{ user_id->
	(index..(index+4)).each{ role_id->
		println "${user_id},${role_id}"
	}
}

