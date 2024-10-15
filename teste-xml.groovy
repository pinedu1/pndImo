@Grab('org.codehaus.groovy:groovy-xml:2.4.3')
import groovy.xml.XmlParser

def xmlString = '<dados><origem></origem><arquivo>LOGOTIPO1.JPG</arquivo></dados>'
//def xml = new XmlSlurper().parseText(xmlString)

def xml = new XmlParser().parseText(xmlString)

println "Origem: ${xml.origem.text()}"
println "Arquivo: ${xml.arquivo.text()}"
