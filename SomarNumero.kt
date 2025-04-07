import kotlin.random.Random

fun main() {
    var opcao: String

    do {
        println("\n=== MENU PRINCIPAL ===")
        println("a. Somar vários números reais")
        println("b. Gerar número aleatório em intervalo")
        println("s. Sair")
        print("Escolha uma opção: ")

        opcao = readLine()?.trim()?.lowercase() ?: ""

        when (opcao) {
            "a" -> somarNumerosReais()
            "b" -> gerarNumeroAleatorio()
            "s" -> println("Saindo do programa...")
            else -> println("Opção inválida! Tente novamente.")
        }
    } while (opcao != "s")
}

fun somarNumerosReais() {
    println("\n--- Soma de Números Reais ---")

    print("Quantos números deseja somar? ")
    val quantidade = readLine()?.toIntOrNull() ?: 0

    if (quantidade <= 0) {
        println("Quantidade inválida!")
        return
    }

    var soma = 0.0
    for (i in 1..quantidade) {
        print("Digite o número $i: ")
        val numero = readLine()?.toDoubleOrNull()

        if (numero == null) {
            println("Número inválido! Considerando como 0.")
        } else {
            soma += numero
        }
    }

    println("A soma dos $quantidade números é: $soma")
}

fun gerarNumeroAleatorio() {
    println("\n--- Gerador de Número Aleatório ---")

    print("Digite o valor mínimo (x): ")
    val x = readLine()?.toIntOrNull()

    print("Digite o valor máximo (y): ")
    val y = readLine()?.toIntOrNull()

    if (x == null || y == null || x > y) {
        println("Intervalo inválido!")
        return
    }

    val numeroAleatorio = Random.nextInt(x, y + 1)
    println("Número aleatório entre $x e $y: $numeroAleatorio")
}