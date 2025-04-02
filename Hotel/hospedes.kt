package hotel

val hospedes = mutableListOf<String>()

fun cadastrarHospedes() {
    println("\n=== CADASTRO DE HÓSPEDES ===")
    val diaria = lerDoublePositivo("Qual o valor padrão da diária?")

    var gratuidades = 0
    var meias = 0
    var valorTotal = 0.0

    while (true) {
        print("Qual o nome do Hóspede? (digite 'PARE' para encerrar) ")
        val nome = readLine() ?: ""
        if (nome.equals("PARE", ignoreCase = true)) break

        val idade = lerIntPositivo("Qual a idade do Hóspede?")

        when {
            idade < 6 -> {
                println("$nome possui gratuidade")
                gratuidades++
            }
            idade > 60 -> {
                println("$nome paga meia")
                meias++
                valorTotal += diaria / 2
            }
            else -> {
                println("$nome cadastrado(a) com sucesso.")
                valorTotal += diaria
            }
        }
    }

    println("\n$usuarioLogado, o valor total das hospedagens é: R$${"%.2f".format(valorTotal)}; $gratuidades gratuidade(s); $meias meia(s)")
}

fun gerenciarCadastros() {
    var opcao: Int
    do {
        println("\n=== CADASTRO DE HÓSPEDES ===")
        println("1. Cadastrar")
        println("2. Pesquisar")
        println("3. Listar")
        println("4. Sair")
        print("Escolha uma opção: ")

        opcao = when (readLine()?.toIntOrNull()) {
            1 -> {
                if (hospedes.size >= 15) {
                    println("Máximo de cadastros atingido")
                    1
                } else {
                    print("Qual o nome do Hóspede? ")
                    val nome = readLine() ?: ""
                    hospedes.add(nome)
                    println("Hóspede $nome cadastrado(a) com sucesso!")
                    1
                }
            }
            2 -> {
                print("Qual o nome do Hóspede? ")
                val nome = readLine() ?: ""
                if (hospedes.contains(nome)) {
                    println("Hóspede $nome foi encontrado(a)!")
                } else {
                    println("Hóspede não encontrado(a)!")
                }
                2
            }
            3 -> {
                println("\n=== LISTA DE HÓSPEDES ===")
                hospedes.forEach { println(it) }
                3
            }
            4 -> 0
            else -> {
                println("Opção inválida!")
                -1
            }
        }
    } while (opcao != 4)
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