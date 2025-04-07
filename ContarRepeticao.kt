fun main() {
    println("=== CONTADOR DE PALAVRAS ===")

    // Solicita o texto ao usuário
    print("Digite o texto: ")
    val texto = readLine() ?: ""

    // Solicita a palavra a ser buscada
    print("Digite a palavra para contar: ")
    val palavra = readLine() ?: ""

    // Realiza a contagem
    val ocorrencias = contarPalavras(texto, palavra)

    // Exibe o resultado
    println("\nA palavra '$palavra' aparece $ocorrencias vezes no texto.")
}

fun contarPalavras(texto: String, palavra: String): Int {
    if (texto.isEmpty() || palavra.isEmpty()) return 0

    var count = 0
    var index = 0

    while (index <= texto.length - palavra.length) {
        // Verifica se a substring atual corresponde à palavra
        if (texto.substring(index, index + palavra.length).equals(palavra, ignoreCase = true)) {
            count++
            index += palavra.length // Pula o tamanho da palavra encontrada
        } else {
            index++
        }
    }

    return count
}