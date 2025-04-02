package hotel

const val NOME_HOTEL = "X-Mansion Hotel"
const val SENHA_CORRETA = "2678"
var usuarioLogado = ""

fun autenticar() {
    println("Bem vindo ao $NOME_HOTEL")
    print("Digite seu nome: ")
    usuarioLogado = readLine() ?: ""

    var tentativas = 3
    do {
        print("Digite sua senha: ")
        when (readLine()) {
            SENHA_CORRETA -> {
                println("\nBem vindo ao $NOME_HOTEL, $usuarioLogado. É um imenso prazer ter você por aqui!")
                return
            }
            else -> {
                tentativas--
                if (tentativas > 0) println("Senha incorreta! Tentativas restantes: $tentativas")
            }
        }
    } while (tentativas > 0)

    println("Acesso bloqueado!")
    kotlin.system.exitProcess(0)
}