import java.time.LocalDateTime

fun main() {
    val motivator = DailyMotivator()
    motivator.printCurrentMotivationalMessage()
}

class DailyMotivator {
    // Lista de frases motivacionais organizadas por período do dia
    private val motivationalPhrases = mapOf(
        "madrugada" to listOf(
            "A madrugada é o momento perfeito para planejar um dia incrível!",
            "Antes do sol nascer, grandes sonhos são cultivados.",
            "A tranquilidade da madrugada é ideal para focar no que realmente importa."
        ),
        "manhã" to listOf(
            "Bom dia! Hoje é um novo dia cheio de oportunidades!",
            "A manhã é fresca, a mente está limpa - hora de conquistar o mundo!",
            "Seu dia será tão brilhante quanto o sol da manhã que você permitir."
        ),
        "tarde" to listOf(
            "Boa tarde! Mantenha o foco que o dia ainda está só começando!",
            "A energia da tarde é perfeita para superar desafios!",
            "Não importa quanto já fez hoje, ainda há tempo para coisas incríveis!"
        ),
        "noite" to listOf(
            "Boa noite! Celebre suas conquistas do dia!",
            "A noite é para descansar e se preparar para um amanhã ainda melhor!",
            "Reveja seus progressos e agradeça pelo dia que se encerra."
        )
    )

    // Determina o período do dia baseado na hora atual
    private fun getTimeOfDay(): String {
        val currentHour = LocalDateTime.now().hour

        return when (currentHour) {
            in 0..5 -> "madrugada"
            in 6..11 -> "manhã"
            in 12..17 -> "tarde"
            else -> "noite"
        }
    }

    // Seleciona uma frase aleatória para o período atual
    private fun getRandomMotivationalPhrase(timeOfDay: String): String {
        val phrases = motivationalPhrases[timeOfDay] ?: return "Hoje é um ótimo dia para ser incrível!"
        return phrases.random()
    }

    // Imprime a mensagem motivacional atual
    fun printCurrentMotivationalMessage() {
        val timeOfDay = getTimeOfDay()
        val phrase = getRandomMotivationalPhrase(timeOfDay)

        println("\n=== Mensagem Motivacional ===")
        println("Período: ${timeOfDay.capitalize()}")
        println("Frase: $phrase")
        println("============================\n")
    }
}