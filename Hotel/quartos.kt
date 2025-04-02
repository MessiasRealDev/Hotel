package hotel

val quartos = BooleanArray(20) { false }

fun gerenciarQuartos() {
    println("\n=== RESERVA DE QUARTOS ===")

    val diaria = lerDoublePositivo("Qual o valor padrão da diária?")
    val dias = lerIntPositivo("Quantas diárias serão necessárias?", 30)
    val total = diaria * dias

    println("O valor de $dias dias de hospedagem é de R$${"%.2f".format(total)}")
    print("Qual o nome do hóspede? ")
    val nomeHospede = readLine() ?: ""

    var reservaConfirmada = false

    while (!reservaConfirmada) {
        val numeroQuarto = lerIntPositivo("Qual o quarto para reserva? (1-20)", 20)

        if (quartos[numeroQuarto - 1]) {
            println("Quarto já está ocupado. Escolha outro.")
            mostrarStatusQuartos()
            continue
        }

        println("Quarto Livre.")
        print("$usuarioLogado, você confirma a hospedagem para $nomeHospede por $dias dias para o quarto $numeroQuarto por R$${"%.2f".format(total)}? (S/N) ")

        when (readLine()?.uppercase()) {
            "S" -> {
                quartos[numeroQuarto - 1] = true
                println("$usuarioLogado, reserva efetuada para $nomeHospede.")
                reservaConfirmada = true
            }
            else -> {
                print("Deseja tentar reservar outro quarto? (S/N) ")
                if (readLine()?.uppercase() != "S") break
            }
        }
    }

    mostrarStatusQuartos()
}

fun mostrarStatusQuartos() {
    print("Lista de quartos e suas ocupações: ")
    println(quartos.mapIndexed { index, ocupado ->
        "${index + 1}-${if (ocupado) "ocupado" else "livre"}"
    }.joinToString("; "))
}

private fun lerDoublePositivo(mensagem: String): Double {
    while (true) {
        print("$mensagem ")
        try {
            val valor = readLine()?.toDouble() ?: -1.0
            if (valor > 0) return valor
            println("Valor inválido, $usuarioLogado")
        } catch (e: Exception) {
            println("Valor inválido, $usuarioLogado")
        }
    }
}

private fun lerIntPositivo(mensagem: String, max: Int = Int.MAX_VALUE): Int {
    while (true) {
        print("$mensagem ")
        try {
            val valor = readLine()?.toInt() ?: -1
            if (valor in 1..max) return valor
            println("Valor inválido, $usuarioLogado. Digite entre 1 e $max")
        } catch (e: Exception) {
            println("Valor inválido, $usuarioLogado")
        }
    }
}