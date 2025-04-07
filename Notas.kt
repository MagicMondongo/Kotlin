
class Notas {
    private val notas: MutableList<Double> = mutableListOf()


    fun adicionarNota(nota: Double) {
        when {
            nota < 0.0 -> println("Erro: Nota não pode ser negativa")
            nota > 5.0 -> println("Erro: Nota máxima é 5.0")
            else -> notas.add(nota)
        }
    }

    fun calcularMedia(): Double {
        return if (notas.isEmpty()) 0.0 else notas.average()
    }

    fun quantidadeAvaliacoes(): Int = notas.size


    fun listarNotas(): List<Double> = notas.toList()
}


class Restaurante(
    val nome: String,
    val endereco: String,
    val especialidade: String
) {
    val sistemaNotas = Notas()


    val mediaNotas: Double
        get() = sistemaNotas.calcularMedia()


    fun exibirDetalhes() {
        println("""
            =================================
            Restaurante: $nome
            Endereço: $endereco
            Especialidade: $especialidade
            Média de avaliações: ${"%.2f".format(mediaNotas)} 
            (${sistemaNotas.quantidadeAvaliacoes()} avaliações)
            =================================
        """.trimIndent())
    }
}


class Cliente(val nome: String) {
    fun avaliarRestaurante(restaurante: Restaurante, nota: Double) {
        println("$nome está avaliando ${restaurante.nome} com nota $nota")
        restaurante.sistemaNotas.adicionarNota(nota)
    }
}

fun main() {
    println("=== SISTEMA DE AVALIAÇÃO DE RESTAURANTES ===\n")


    val restauranteChique = Restaurante("Gourmet & Cia", "Av. Principal, 1000", "Cozha Internacional")
    val restauranteFastFood = Restaurante("Burguer King", "Rua Comercial, 500", "Lanches Rápidos")
    val restauranteCaseiro = Restaurante("Sabor da Vovó", "Travessa da Saudade, 50", "Comida Caseira")


    val cliente1 = Cliente("Ana Silva")
    val cliente2 = Cliente("Carlos Oliveira")
    val cliente3 = Cliente("Mariana Santos")
    val cliente4 = Cliente("João Pereira")


    cliente1.avaliarRestaurante(restauranteChique, 4.5)
    cliente2.avaliarRestaurante(restauranteChique, 5.0)
    cliente3.avaliarRestaurante(restauranteChique, 4.0)

    cliente1.avaliarRestaurante(restauranteFastFood, 3.0)
    cliente4.avaliarRestaurante(restauranteFastFood, 2.5)
    cliente2.avaliarRestaurante(restauranteFastFood, 4.0)

    cliente3.avaliarRestaurante(restauranteCaseiro, 5.0)
    cliente4.avaliarRestaurante(restauranteCaseiro, 4.5)
    cliente1.avaliarRestaurante(restauranteCaseiro, 5.0)
    cliente2.avaliarRestaurante(restauranteCaseiro, 4.0)

    cliente4.avaliarRestaurante(restauranteChique, -1.0)  // Nota negativa
    cliente3.avaliarRestaurante(restauranteFastFood, 6.0)  // Nota acima do máximo

    restauranteChique.exibirDetalhes()
    restauranteFastFood.exibirDetalhes()
    restauranteCaseiro.exibirDetalhes()

    println("\n=== VERIFICAÇÃO DOS CÁLCULOS ===")
    println("Restaurante Gourmet & Cia: (4.5 + 5.0 + 4.0) / 3 = ${(4.5 + 5.0 + 4.0) / 3}")
    println("Restaurante Burguer King: (3.0 + 2.5 + 4.0) / 3 = ${(3.0 + 2.5 + 4.0) / 3}")
    println("Restaurante Sabor da Vovó: (5.0 + 4.5 + 5.0 + 4.0) / 4 = ${(5.0 + 4.5 + 5.0 + 4.0) / 4}")
}
// Socorro eu não sei o que estou fazendo da minha vida