@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.springframework.boot:spring-boot-starter-web:2.4.9")
@file:DependsOn("org.springframework.boot:spring-boot-starter-tomcat:2.4.9")

package meuServidor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.io.*


@SpringBootApplication
@RestController
open class Aplicacao {


    var numero_vezes = 0 //ler_do_arquivo.
    
    
    @PostMapping("oi.html")
    fun ola(nome:String?,idade:Int?) : String {
        if (nome==null || idade==null) {
            println("Recebi uma notificacao invalida");
            return """
            Chamada incorreta.
            """
        }
        numero_vezes++;
        //salvar no arquivo
        println("Recebi um ola de $nome. Já executei $numero_vezes vezes")
        return """
        <html>
        <title>Página gerada pelo servidor</title>
        <body>
        Ola $nome, <p>

        Aqui é o servidor Spring / Tomcat.<P>

        Você tem $idade anos<p>

        Este texto foi gerado por um programa em <b>kotlin</b> que 
        executou no servidor <p>
        Esta página foi acessada $numero_vezes vezes.       
        <div id="mensagem">
           
        </div>
        <svg width="100" height="100">
            <circle cx="50" cy="50" r="40" stroke="green" stroke-width="4" fill="yellow" />
        </svg>

        <script src="https://cdn.jsdelivr.net/npm/kotlin@1.5.21/kotlin.min.js"></script>
        <script src="Programa.js"></script>

        </body>
        </html>
        """
    }


    // Quadro de avisos na web:
    data class Mensagem(val autor:String, val mensagem:String)
    //var listaMensagens = mutableListOf(
    //    Mensagem("Luis Carlos", "Sejam bem vindos"),
    //    Mensagem("Luis Carlos", "Este é o quardro de avisos da disciplina")
    //)
    var listaMensagens = run {
        val texto = File("mensagens.txt").readText()
        val linhas = texto.split("\n")
        val mensagens = linhas.map {
            linha -> 
               val campos = linha.split(",")
               Mensagem(campos[0],campos[1])
        }
        mensagens.toMutableList()
    }

    @GetMapping("listaMensagens.html")
    fun listaMensagens():String {
        var msg = ""
        listaMensagens.forEach { m ->
            msg += "<b> ${m.autor} </b> disse: ${m.mensagem} <p>"
        }
        return """
        <html>
        <body>
        Mensagens recebidas:<p>
        $msg
        <hr>
        Digite sua mensagem:<br>
        <form action="enviaMensagem.html" method="GET">
            autor: <input name="autor"><p>
            conteudo da mensagem: <input name="conteudo"><p>
            <input type="submit" value="Mandar mensagem">
        </form>
        <a href="listaMensagens.html">Reload</a>
        </body>
        </html>
        """

    }
    
    @GetMapping("enviaMensagem.html")
    fun enviaMensagem(autor:String, conteudo:String) : String {
        listaMensagens.add(Mensagem(autor,conteudo))
        //File("mensagens.txt").writeText( listaMensagens.joinToString("\n") {
        //    msg -> msg.autor + "," + msg.mensagem
        //})
        File("mensagens.txt").appendText("\n"+autor+","+conteudo)
        return listaMensagens();
    }

}

println("Vou iniciar a aplicação Spring.io")
runApplication<Aplicacao>(*args)


