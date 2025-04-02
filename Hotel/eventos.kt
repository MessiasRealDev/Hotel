package hotel

fun gerenciarEventos() {
    // Parte 1: Local do evento
    val convidados = lerIntPositivo("Qual o número de convidados para o seu evento?")
    if (convidados > 350) {
        println("Quantidade de convidados superior à capacidade máxima")
        return
    }

    val auditório = if (convidados <= 150) {
        "Laranja"
    } else if (convidados <= 220) {
        "Laranja (inclua mais ${convidados - 150} cadeiras)"
    } else {
        "Colorado"
    }
    println("Use o auditório $auditório")

    // Parte 2: Agenda
    print("Qual o dia do seu evento? ")
    val dia = readLine()?.lowercase()?.replace("á", "a") ?: ""

    val hora = lerIntPositivo("Qual a hora do seu evento?", 23)

    val disponivel = when (dia) {
        "sabado", "domingo" -> hora in 7..15
        else -> hora in 7..23
    }

    if (!disponivel) {
        println("Auditório indisponível")
        return
    }

    print("Qual o nome da empresa? ")
    val empresa = readLine() ?: ""
    println("Auditório reservado para $empresa: ${dia.capitalize()} às ${hora}h")

    val horas = lerIntPositivo("Qual a duração do evento em horas?")
    val garcons = kotlin.math.ceil(convidados / 12.0).toInt() +
            kotlin.math.ceil(horas / 2.0).toInt()
    val custoGarcons = garcons * 10.5 * horas
    println("São necessários $garcons garçons.")
    println("Custo: R$${"%.2f".format(custoGarcons)}")

    val cafe = convidados * 0.2
    val agua = convidados * 0.5
    val salgados = convidados * 7
    val custoBuffet = (cafe * 0.8) + (agua * 0.4) + (salgados * 0.34)

    println("\nO evento precisará de:")
    println("- ${"%.1f".format(cafe)} litros de café")
    println("- ${"%.1f".format(agua)} litros de água")
    println("- $salgados salgados")

    println("\n=== RESUMO FINAL ===")
    println("Auditório: $auditório")
    println("Empresa: $empresa")
    println("Data: ${dia.capitalize()} às ${hora}h")
    println("Duração: $horas horas")
    println("Convidados: $convidados")
    println("Custo total: R$${"%.2f".format(custoGarcons + custoBuffet)}")

    print("\n$usuarioLogado, deseja confirmar o evento? (S/N) ")
    if (readLine()?.equals("s", true) == true) {
        println("Reserva efetuada com sucesso!")
    } else {
        println("Reserva cancelada.")
    }
}

private fun lerIntPositivo(msg: String, max: Int = Int.MAX_VALUE): Int {
    while (true) {
        print("$msg ")
        try {
            return readLine()?.toInt()?.takeIf { it in 1..max } ?: throw Exception()
        } catch (e: Exception) {
            println("Valor inválido! Digite entre 1 e $max")
        }
    }
}