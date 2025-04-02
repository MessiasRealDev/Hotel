package hotel

fun calcularCombustivel() {
    println("\n=== CÁLCULO DE COMBUSTÍVEL ===")

    val alcoolWayne = lerDoublePositivo("Valor do álcool no Wayne Oil:")
    val gasolinaWayne = lerDoublePositivo("Valor da gasolina no Wayne Oil:")
    val alcoolStark = lerDoublePositivo("Valor do álcool no Stark Petrol:")
    val gasolinaStark = lerDoublePositivo("Valor da gasolina no Stark Petrol:")

    val vantagemAlcoolWayne = alcoolWayne <= gasolinaWayne * 0.7
    val vantagemAlcoolStark = alcoolStark <= gasolinaStark * 0.7

    val custoWayne = if (vantagemAlcoolWayne) alcoolWayne * 42 else gasolinaWayne * 42
    val custoStark = if (vantagemAlcoolStark) alcoolStark * 42 else gasolinaStark * 42

    val (melhorPosto, melhorCombustivel) = when {
        custoWayne < custoStark ->
            if (vantagemAlcoolWayne) "Wayne Oil" to "álcool" else "Wayne Oil" to "gasolina"
        else ->
            if (vantagemAlcoolStark) "Stark Petrol" to "álcool" else "Stark Petrol" to "gasolina"
    }

    println("\n$usuarioLogado, é mais barato abastecer com $melhorCombustivel no posto $melhorPosto")
}

private fun lerDoublePositivo(msg: String): Double {
    while (true) {
        print("$msg ")
        try {
            return readLine()?.toDouble()?.takeIf { it > 0 } ?: throw Exception()
        } catch (e: Exception) {
            println("Valor inválido!")
        }
    }
}