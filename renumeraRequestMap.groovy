// Define os arquivos de entrada e saída
def inputFile = new File('/pinedu/modelo/requestmap.csv')
def outputFile = new File('/pinedu/modelo/requestmap_renumerado.csv')

// Abre o arquivo de saída para gravação
outputFile.withWriter { writer ->
    // Contador para renumeração
    int lineNumber = 0

    // Lê o arquivo de entrada linha por linha
    inputFile.eachLine { line ->
        // Se for a primeira linha (cabeçalho), apenas escreve sem alterações
        if (lineNumber == 0) {
            writer.println(line)
        } else {
            // Expressão regular para encontrar o número entre aspas na primeira coluna
            def newLine = line.replaceFirst(/"(\d+)"/, "\"${lineNumber}\"")
            writer.println(newLine) // Escreve a linha renumerada no arquivo de saída
        }
        lineNumber++ // Incrementa o contador
    }
}

println "Arquivo renumerado gerado com sucesso: ${outputFile.absolutePath}"

