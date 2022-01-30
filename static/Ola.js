if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Ola'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Ola'.");
}var Ola = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function limpaTela() {
    var elemento = document.getElementById('elemento');
    if (elemento == null) {
      println('Elemento nao encontrado');
      return;
    }elemento.innerHTML = '';
  }
  var conteudoSalvo;
  function salvaConteudo() {
    var elemento = document.getElementById('elemento');
    if (elemento == null) {
      println('Elemento nao encontrado');
      return;
    }conteudoSalvo = elemento.innerHTML;
  }
  function restauraConteudo() {
    var elemento = document.getElementById('elemento');
    if (elemento == null) {
      println('Elemento nao encontrado');
      return;
    }elemento.innerHTML = conteudoSalvo;
  }
  function botaoPressionado() {
    var elemento = document.getElementById('elemento');
    if (elemento == null) {
      println('Elemento nao encontrado');
      return;
    }f();
    elemento.innerHTML = elemento.innerHTML + '\n       <br>Ola usu\xE1rio\n       <div style="border-style:solid;">\n       Este texto est\xE1 dentro<br>\n       de um div com borda\n       <script>\n       Ola.f();\n       <\/script>\n       <\/div>\n    ';
  }
  function f() {
    println('Funcao f foi chamada');
  }
  function inserir() {
    var elemento = document.getElementById('gui');
    if (elemento == null) {
      println('GUI nao encontrado');
      return;
    }elemento.innerHTML = '\n    <CENTER>Inserir novo usu\xE1rio<\/CENTER>\n    Digite o nome do usuario: <input><\/input><p>\n    Digite o endere\xE7o do usu\xE1rio: <input><\/input><p>\n    Digite o telefone do usu\xE1rio: <input><\/input><p>\n    <CENTER><button>Inserir usuario<\/button> <button>Cancelar<\/button><\/CENTER>\n    ';
  }
  function main() {
    var elemento = document.getElementById('elemento');
    if (elemento == null) {
      println('Elemento nao encontrado');
      return;
    }elemento.innerHTML = '';
    for (var c = 1; c <= 10; c++)
      elemento.innerHTML = elemento.innerHTML + ('<CENTER>Bom dia para todos ' + c + '<\/CENTER>');
    elemento.innerHTML = elemento.innerHTML + '<hr>O programa em <B>kotlin<\/B> modificou a p\xE1gina HTML';
  }
  _.limpa = limpaTela;
  Object.defineProperty(_, 'conteudoSalvo', {
    get: function () {
      return conteudoSalvo;
    },
    set: function (value) {
      conteudoSalvo = value;
    }
  });
  _.salva = salvaConteudo;
  _.restaura = restauraConteudo;
  _.botaoPressionado = botaoPressionado;
  _.f = f;
  _.inserirNovo = inserir;
  _.main = main;
  conteudoSalvo = '';
  main();
  Kotlin.defineModule('Ola', _);
  return _;
}(typeof Ola === 'undefined' ? {} : Ola, kotlin);
