import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Calendar

val expressaoRegular =  Regex("[0-5]")

//Variavel Global
//Instância de um lista mutável vazia
var listaConvidados : MutableList<Convidado> = mutableListOf<Convidado>()
val lista = mutableListOf("b", "a", "c", "e", "d")


fun main() {
    val i = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)


    println(i)
    menu()
}

private fun menu(){
    do{
        println("--- MENU ---")
        println("1- CADASTRAR")
        println("2- LISTAR")
        println("3- EDITAR")
        println("4- EXCLUIR")
        println("5- BUSCA")
        println("0- SAIR")
        val opcao = readln()//Aqui precisa ser String
        //por causa do REGEX

        if (expressaoRegular.matches(opcao)){
            when (opcao.toInt()) {
                1 -> {
                    println("Cadastrando...")
                    cadastrar()
                }

                2 -> {
                    println("Listando...")
                    listar()
                }

                3 -> {
                    println("Editando...")
                    editar()
                }

                4 -> {
                    println("Excluindo...")
                    excluir()
                }

                5 -> {
                    println("Buscando...")
                    busca()
                }

                0 -> print("Saindo")
            }
        } else{
            println("\n\n\nOpção inválida")
        }

    }while(opcao != "0")//PRECISA SER STRING!
}

//QUESTÃO 1 - Valida para que o usuario
//somente digite LETRAS para escrever o nome
private fun cadastrar() {
    //Instância
    val convidado = Convidado()

    // Validação do nome
    var nomeValido = false
    while (!nomeValido) {
        print("Qual o seu nome? ")
        val nomeInput = readln().trim()

        if (nomeInput.matches(Regex("^[\\p{L} ]+\$"))) {
            convidado.nome = nomeInput
            nomeValido = true
        } else {
            println("Por favor, digite apenas letras e espaços para o nome.")
        }
    }

    print("Qual vai ser o presente? ")
    convidado.presente = readln()

    print("Qual sua restrição alimentar? ")
    convidado.alimentar = readln()

    listaConvidados.add(convidado)
}

/*fun algumaCoisa() : tipo esperasse que a função
* receba esse tipo no final dela com um return
* */
private fun listar() : String{
    var i = 0

    listaConvidados.sortBy {
        it.nome
    }

    if (validar()){
        listaConvidados.forEach { convidado ->
            print(
                "Posição: ${i++}" +
                        "Nome: ${convidado.nome}; " +
                        "Presente: ${convidado.presente} ; " +
                        "Restrição: ${convidado.alimentar}; " +
                        "Vai ir a festa? ${convidado.presenca} \n"
            )//FIM do PRINT
        }//FIM do FOREACH
    }//FIM do IF
    return "Listagem foi um sucesso"//esse é o meu retorna da função
}//FIM da FUNÇÃO LISTAR

/*QUESTÃO 2 - Validar para que a variavel posição seja sempre
numérica e a variavel resposta seja sempre "S" ou "N"*/
private fun editar(): Boolean {
    if (validar()) {
        listar()

        var posicao: Int
        while (true) {
            println("Digite a posição a ser editada: ")
            val entrada = readln()
            if (entrada.all { it.isDigit() }) {
                posicao = entrada.toInt()
                if (posicao in listaConvidados.indices) {
                    break
                } else {
                    println("Erro: posição fora do intervalo da lista.")
                }
            } else {
                println("Erro: Digite apenas números.")
            }
        }

        var resposta: String
        while (true) {
            println("O convidado vai? (S/N)")
            resposta = readln().trim().uppercase()
            if (resposta == "S" || resposta == "N") {
                break
            } else {
                println("Erro: Digite apenas 'S' ou 'N'.")
            }
        }

        listaConvidados[posicao].presenca = (resposta == "S")
        println("Presença atualizada com sucesso.")
    }
    return true

}

/*QUESTÃO 3 - Validar para que a variavel posição seja sempre
numérica*/
private fun excluir(): Boolean {
    if (listaConvidados.isEmpty()) {
        println("Lista de convidados vazia - Nenhum convidado para excluir")
        return false
    }

    listar()

    var posicaoValida = false
    var posicao = -1

    while (!posicaoValida) {
        print("Qual posição você deseja remover: ")
        val input = readln()

        if (input.matches(Regex("\\d+"))) {
            posicao = input.toInt()


            if (posicao in 0 until listaConvidados.size) {
                posicaoValida = true
            } else {
                println("Posição inválida. Digite um número entre 0 e ${listaConvidados.size - 1}")
            }
        } else {
            println("Entrada inválida. Por favor, digite apenas números.")
        }
    }

    listaConvidados.removeAt(posicao)
    println("Convidado excluído com sucesso!")
    return true
}


private fun busca() {
    if (!validar()) return  // Mantém a validação original da lista vazia

    var i = 0

    // Validação do input
    var buscaValida = false
    var busca = ""
    while (!buscaValida) {
        print("Digite o nome da pessoa que você busca: ")
        busca = readln().trim()

        if (busca.matches(Regex("^[\\p{L} ]+$"))) {  // Permite letras e espaços
            buscaValida = true
        } else {
            println("Por favor, digite apenas letras para o nome.")
        }
    }

    var encontrou = false
    listaConvidados.forEach { convidado ->
        // Busca case insensitive
        if (convidado.nome.contains(busca, ignoreCase = true)) {
            println("Posição: $i, Nome: ${convidado.nome}")
            encontrou = true
        }
        i++
    }

    if (!encontrou) {
        println("Nenhum convidado encontrado com esse nome.")
    }
}

private fun validar() : Boolean{
    if(listaConvidados.isEmpty()){
        println("Lista vazia! Finalizando...")
        return false
    }
    return true
}
