if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Programa'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Programa'.");
}var Programa = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main() {
    var divElemt = document.getElementById('mensagem');
    if (divElemt == null)
      return;
    divElemt.innerHTML = '\n   Este texto foi adicionado pelo programa em Kotlin que foi executado pelo navegador.\n   ';
    println('ola do kotlin');
  }
  _.main = main;
  main();
  Kotlin.defineModule('Programa', _);
  return _;
}(typeof Programa === 'undefined' ? {} : Programa, kotlin);
