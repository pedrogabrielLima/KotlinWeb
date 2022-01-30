import kotlinx.browser.*
import org.w3c.dom.*


@JsName("limpa")
fun limpaTela() {
    val elemento = document.getElementById("elemento")
    if (elemento==null) {
        println("Elemento nao encontrado")
        return;
    }
    elemento.innerHTML = "";

}
var conteudoSalvo = ""

@JsName("salva")
fun salvaConteudo() {
    val elemento = document.getElementById("elemento")
    if (elemento==null) {
        println("Elemento nao encontrado")
        return;
    }
    conteudoSalvo = elemento.innerHTML;

}
@JsName("restaura")
fun restauraConteudo() {
    val elemento = document.getElementById("elemento")
    if (elemento==null) {
        println("Elemento nao encontrado")
        return;
    }
    elemento.innerHTML = conteudoSalvo;

}



@JsName("botaoPressionado")
fun botaoPressionado() {
    val elemento = document.getElementById("elemento")
    if (elemento==null) {
        println("Elemento nao encontrado")
        return;
    }
    f();
    elemento.innerHTML += """
       <br>Ola usuário
       <div style="border-style:solid;">
       Este texto está dentro<br>
       de um div com borda
       <script>
       Ola.f();
       </script>
       </div>
    """;
}
@JsName("f")
fun f() {
    println("Funcao f foi chamada")
}
@JsName("inserirNovo")
fun inserir() {
    val elemento = document.getElementById("gui")
    if (elemento==null) {
        println("GUI nao encontrado")
        return;
    }
    elemento.innerHTML = """
    <CENTER>Inserir novo usuário</CENTER>
    Digite o nome do usuario: <input></input><p>
    Digite o endereço do usuário: <input></input><p>
    Digite o telefone do usuário: <input></input><p>
    <CENTER><button>Inserir usuario</button> <button>Cancelar</button></CENTER>
    """;

}

fun main() {
    val elemento = document.getElementById("elemento")
    if (elemento==null) {
        println("Elemento nao encontrado")
        return;
    }
    elemento.innerHTML = ""
    for (c in 1..10)
       elemento.innerHTML += "<CENTER>Bom dia para todos $c</CENTER>"
    elemento.innerHTML += "<hr>O programa em <B>kotlin</B> modificou a página HTML"

}

