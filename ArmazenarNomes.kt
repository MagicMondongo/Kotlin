fun main() {
    val listaNomes = mutableListOf<String>()
    val regex = Regex("^[a-zA-ZÀ-ú\\s]+\$")  // Permite letras, acentos e espaços

    println("=== Cadastro de Nomes ===")
    println("Digite os nomes (ou 'sair' para encerrar):")

    while (true) {
        print("Nome: ")
        val input = readLine()?.trim()

        when {
            input.equals("sair", ignoreCase = true) -> break
            input.isNullOrEmpty() -> println("Erro: Nome não pode ser vazio!")
            !input.matches(regex) -> println("Erro: Digite apenas letras do alfabeto!")
            else -> listaNomes.add(input)
        }
    }

    if (listaNomes.isEmpty()) {
        println("\nNenhum nome foi cadastrado.")
    } else {

        listaNomes.sort()

        println("\nNomes cadastrados (ordem alfabética):")
        listaNomes.forEachIndexed { index, nome ->
            println("${index + 1}. $nome")
        }
    }
}