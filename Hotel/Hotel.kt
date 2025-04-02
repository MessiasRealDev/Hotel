package hotel

fun main() {
    autenticar()

    var opcao: Int
    do {
        println("\n=== MENU PRINCIPAL ===")
        println("1. Reservar quarto")
        println("2. Cadastrar família")
        println("3. Gerenciar hóspedes")
        println("4. Agendar evento")
        println("5. Calcular combustível")
        println("6. Manutenção de ar-condicionado")
        println("7. Sair")
        print("Escolha uma opção: ")

        opcao = when (readLine()?.toIntOrNull()) {
            1 -> { gerenciarQuartos(); 1 }
            2 -> { cadastrarHospedes(); 1 }
            3 -> { gerenciarCadastros(); 1 }
            4 -> { gerenciarEventos(); 1 }
            5 -> { calcularCombustivel(); 1 }
            6 -> { gerenciarManutencao(); 1 }
            7 -> {
                println("\nMuito obrigado e até logo, $usuarioLogado.")
                7
            }
            else -> {
                println("Opção inválida!")
                -1
            }
        }
    } while (opcao != 7)
}