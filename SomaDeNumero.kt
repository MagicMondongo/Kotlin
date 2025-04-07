fun main() {
    // Solicita o primeiro número
    print("Digite o primeiro número: ")
    val numero1 = readLine()?.toDoubleOrNull() ?: 0.0

    // Solicita o segundo número
    print("Digite o segundo número: ")
    val numero2 = readLine()?.toDoubleOrNull() ?: 0.0

    // Calcula a soma
    val soma = numero1 + numero2

    // Exibe o resultado
    print("A soma de $numero1 e $numero2 é igual a $soma")
}