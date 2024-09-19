package br.com.pinedu

import grails.converters.JSON
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@EqualsAndHashCode(includes=['chave', 'cliente'])
@ToString(includes=['chave', 'cliente'], includeNames=true, includePackage=false)
class ClienteTenantPropriedades implements Serializable {
    String chave
    String valor
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    ClienteTenant cliente
    static belongsTo = [ cliente: ClienteTenant ]
    static constraints = {
        chave nullable: false
        valor nullable: true
        cliente nullable: false
    }
    static mapping = {
        table 'cliente_tenant_propriedades'
        version false
        id composite: ['chave', 'cliente']
        cliente	index: 'idxCliTenProp'
    }
    static List<Map<String, Object>> fromClienteTenantId( String id ) {
        return executeQuery('SELECT new map(ctp.chave AS chave, ctp.valor AS valor) FROM ClienteTenantPropriedades AS ctp WHERE ctp.cliente.id = :clienteId ORDER BY ctp.chave ASC', [clienteId: id])
    }
    static Map<String, Object> mapFromClienteTenantId( String id ) {
        return toMap( fromClienteTenantId( id ) )
    }
    static List<Map<String, Object>> fromClienteTenant( ClienteTenant clienteTenantInstance ) {
        return executeQuery('SELECT new map(ctp.chave AS chave, ctp.valor AS valor) FROM ClienteTenantPropriedades AS ctp WHERE ctp.cliente.id = :clienteId ORDER BY ctp.chave ASC', [clienteId: clienteTenantInstance.id])
    }
    static Map<String, Object> mapFromClienteTenant( ClienteTenant clienteTenantInstance ) {
        return toMap( fromClienteTenant( clienteTenantInstance ) )
    }
    static List<Map<String, Object>> fromClienteContexto( String contexto ) {
        return executeQuery('SELECT new map(ctp.chave AS chave, ctp.valor AS valor) FROM ClienteTenantPropriedades AS ctp JOIN ctp.cliente AS ct WHERE ct.contexto = :contexto ORDER BY ctp.chave ASC', [contexto: contexto ] )
    }
    static Map<String, Object> mapFromClienteContexto( String contexto ) {
        return toMap( fromClienteContexto( contexto ) )
    }
    static List<Map<String, Object>> all( ) {
        return executeQuery('SELECT new map(ct.contexto AS contexto, ctp.chave AS chave, ctp.valor AS valor) FROM ClienteTenantPropriedades AS ctp JOIN ctp.cliente AS ct ORDER BY ct.contexto, ctp.chave ASC')
    }
    static Map<String, Object> mapFromAll( ) {
        return toMap( all( ) )
    }
    static Map<String, Object> toMap(List<Map<String, Object>> entries) {
        Map<String, Object> props = [:]
        entries.each{Map item->
            props.put(item.chave as String, item.valor)
        }
        return props
    }
}