open class Racao(
    open var preco: Double,
    open val peso: Double,
    open val sabor: String
) {
    open fun desconto() {
        preco *= 0.9
    }

    override fun toString(): String {
        return "Preço: R$${"%.2f".format(preco)}, Peso: ${peso}kg, Sabor: $sabor"
    }
}

class RacaoDeGato(
    override var preco: Double,
    override val peso: Double,
    override val sabor: String,
    val paraCastrado: Boolean,
    val ricaEmFerro: Boolean
) : Racao(preco, peso, sabor) {

    override fun desconto() {
        preco *= if (paraCastrado) 0.85 else 0.80
    }

    override fun toString(): String {
        return super.toString() +
                "\nPara gatos castrados: ${if (paraCastrado) "Sim" else "Não"}" +
                "\nRica em ferro: ${if (ricaEmFerro) "Sim" else "Não"}"
    }
}

class RacaoDeCachorro(
    override var preco: Double,
    override val peso: Double,
    override val sabor: String,
    val fortalecimentoDePelos: Boolean,
    val pedacosComCarne: Boolean
) : Racao(preco, peso, sabor) {

    override fun desconto() {
        preco *= if (pedacosComCarne) 0.95 else 0.75
    }

    override fun toString(): String {
        return super.toString() +
                "\nFortalecimento de pelos: ${if (fortalecimentoDePelos) "Sim" else "Não"}" +
                "\nContém pedaços de carne: ${if (pedacosComCarne) "Sim" else "Não"}"
    }
}

fun main() {

    val racaoGato1 = RacaoDeGato(
        preco = 120.0,
        peso = 5.0,
        sabor = "Salmão",
        paraCastrado = true,
        ricaEmFerro = true
    )

    val racaoGato2 = RacaoDeGato(
        preco = 100.0,
        peso = 3.0,
        sabor = "Frango",
        paraCastrado = false,
        ricaEmFerro = false
    )

    val racaoCachorro1 = RacaoDeCachorro(
        preco = 150.0,
        peso = 10.0,
        sabor = "Carne",
        fortalecimentoDePelos = true,
        pedacosComCarne = true
    )

    val racaoCachorro2 = RacaoDeCachorro(
        preco = 130.0,
        peso = 8.0,
        sabor = "Cordeiro",
        fortalecimentoDePelos = false,
        pedacosComCarne = false
    )


    val racoes = listOf(racaoGato1, racaoGato2, racaoCachorro1, racaoCachorro2)

    racoes.forEach { racao ->
        println("\n=== ANTES DO DESCONTO ===")
        println(racao)

        racao.desconto()

        println("\n=== APÓS O DESCONTO ===")
        println(racao)
        println("=".repeat(30))
    }
}