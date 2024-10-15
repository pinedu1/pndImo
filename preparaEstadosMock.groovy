//id,version,cep2i,sistema,abrvact,cep1f,chavecep,cep2f,nome,cep1i,uf,chavedne,ativo
def estados = [
 "1,0,,f,,69999999,0,,Acre,69900000,AC,1,t"
, "2,0,,f,,57999999,0,,Alagoas,57000000,AL,2,t"
, "3,0,69400000,f,,69299999,0,69899999,Amazonas,69000000,AM,4,t"
, "4,0,,f,,68999999,0,,Amapá,68900000,AP,3,t"
, "5,0,,f,,48999999,0,,Bahia,40000000,BA,5,t"
, "6,0,,f,,63999999,0,,Ceará,60000000,CE,6,t"
, "7,0,73000000,f,,72799999,0,73699999,Distrito Federal,70000000,DF,7,t"
, "8,0,,f,,29999999,0,,Espírito Santo,29000000,ES,8,t"
, "9,0,73700000,f,,72999999,0,76799999,Goiás,72800000,GO,10,t"
, "10,0,,f,,65999999,0,,Maranhão,65000000,MA,11,t"
, "11,0,,f,,39999999,0,,Minas Gerais,30000000,MG,14,t"
, "12,0,,f,,79999999,0,,Mato Grosso do Sul,79000000,MS,13,t"
, "13,0,,f,,78899999,0,,Mato Grosso,78000000,MT,12,t"
, "14,0,,f,,68899999,0,,Pará,66000000,PA,15,t"
, "15,0,,f,,58999999,0,,Paraíba,58000000,PB,16,t"
, "16,0,,f,,56999999,0,,Pernambuco,50000000,PE,18,t"
, "17,0,,f,,64999999,0,,Piauí,64000000,PI,19,t"
, "18,0,,f,,87999999,0,,Paraná,80000000,PR,17,t"
, "19,0,,f,,28999999,0,,Rio de Janeiro,20000000,RJ,20,t"
, "20,0,,f,,59999999,0,,Rio Grande do Norte,59000000,RN,21,t"
, "21,0,,f,,76999999,0,,Rondônia,76800000,RO,23,t"
, "22,0,,f,,69399999,0,,Roraima,69300000,RR,9,t"
, "23,0,,f,,99999999,0,,Rio Grande do Sul,90000000,RS,22,t"
, "24,0,,f,,89999999,0,,Santa Catarina,88000000,SC,25,t"
, "25,0,,f,,49999999,0,,Sergipe,49000000,SE,27,t"
, "26,0,,f,,19999999,0,,São Paulo,01000000,SP,26,t"
, "27,0,,f,,77999999,0,,Tocantins,77000000,TO,24,t"
]
estados.each{ uf->
	def x=uf.split(/,/)
	println "new br.com.pinedu.gpb.Estado(id: ${x[0]}, uf: '${x[10]}',nome: '${x[8]}',cep1i: '${x[9]}',cep1f: '${x[5]}',cep2i: '${x[2]}',cep2f: '${x[4]}',abrvACT: '',chaveDNE: null,chaveCEP: null,sistema: true,ativo:true)"
}