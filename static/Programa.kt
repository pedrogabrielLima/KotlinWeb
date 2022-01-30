import kotlinx.browser.*
import org.w3c.dom.*



fun main() {
   val divElemt = document.getElementById("mensagem") 
   if (divElemt == null) return
   divElemt.innerHTML = """
   Este texto foi adicionado pelo programa em Kotlin que foi executado pelo navegador.
   """
   println("ola do kotlin")
}