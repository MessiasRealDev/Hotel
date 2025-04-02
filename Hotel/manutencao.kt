package hotel

data class Orcamento(val empresa: String, val valor: Double)

fun gerenciarManutencao() {
    val orcamentos = mutableListOf<Orcamento>()

    do {
        println("\n=== NOVO ORÇAMENTO ===")
        print("Nome da empresa: ")
        val empresa = readLine() ?: ""

        val valorUnitario = lerDoublePositivo("Valor por aparelho:")
        val quantidade = lerIntPositivo("Quantidade de aparelhos:")
        val desconto = lerDoublePositivo("Percentual de desconto:", 100.0)
        val minimo = lerIntPositivo("Mínimo para desconto:")

        var total = valorUnitario * quantidade
        if (quantidade > minimo) {
            total *= (1 - desconto / 100)
        }

        println("O serviço de $empresa custará R$${"%.2f".format(total)}")
        orcamentos.add(Orcamento(empresa, total))

        print("\nDeseja informar novos dados, $usuarioLogado? (S/N) ")
    } while (readLine()?.equals("s", true) == true)

    if (orcamentos.size >= 2) {
        val melhor = orcamentos.minByOrNull { it.valor }!!
        println("\nO orçamento de menor valor é o de ${melhor.empresa} por R$${"%.2f".format(melhor.valor)}")
    }
}

private fun lerDoublePositivo(msg: String, max: Double = Double.MAX_VALUE): Double {
    while (true) {
        print("$msg ")
        try {
            return readLine()?.toDouble()?.takeIf { it in 0.0..max } ?: throw Exception()
        } catch (e: Exception) {
            println("Valor inválido! Digite entre 0 e $max")
        }
    }
}

private fun lerIntPositivo(msg: String): Int {
    while (true) {
        print("$msg ")
        try {
            return readLine()?.toInt()?.takeIf { it > 0 } ?: throw Exception()
        } catch (e: Exception) {
            println("Valor inválido!")
        }
    }
}