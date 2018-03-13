// variáveis globais
var c;                // canvas
var ctx;              // contexto
var naveX      = 0;   // posição X da nave
var naveY      = 0;   // posição Y da nave
var oldX       = 0;   // posição X em que a nave estava
var oldY       = 0;   // posição Y em que a nave estava
var maxX              // limite à direita do canvas
var maxY;             // limite abaixo do canvas
var naveTamX   =  30; // largura da nave
var naveTamY   =  30; // altura  da nave
var nave       = new Image(); // nave
var back       = new Image(); // imagem para usar quando chegar aos limites do canvas
var telaVazia  = new Image(); // imagem original da tela
// Esta função é chamada pela página HTML
function canvasSpaceGame() {
  // pega o objeto CANVAS do HTML
  c    = document.getElementById("myCanvas");
  ctx  = c.getContext("2d");
  maxX = c.width;  // limite à direita do canvas - largura
  maxY = c.height; // limite abaixo do canvas - altura
  // Cor de fundo
  ctx.fillStyle = "#000";
  ctx.rect(0, 0, maxX, maxY);
  ctx.fill();
  // armazena a imagem atual
  telaVazia = ctx.getImageData(0, 0, maxX, maxY);
  // desenha a nave
  desenhaNave();
  // joga o jogo até chegar ao fim
  // a cada 16 milissegundos executa a função doGameLoop
  gameLoop = setInterval(gameLoop, 16);
  // adiciona LISTENER do teclado
  window.addEventListener('keydown', qualTecla, true);
}
// desenha a nave
function desenhaNave() {
  // desenha parte de baixo da nave
  ctx.beginPath();
  ctx.moveTo(28.4, 16.9);
  ctx.bezierCurveTo(28.4, 19.7, 22.9, 22.0, 16.0, 22.0);
  ctx.bezierCurveTo(9.1, 22.0, 3.6, 19.7, 3.6, 16.9);
  ctx.bezierCurveTo(3.6, 14.1, 9.1, 11.8, 16.0, 11.8);
  ctx.bezierCurveTo(22.9, 11.8, 28.4, 14.1, 28.4, 16.9);
  ctx.closePath();
  ctx.fillStyle = "rgb(222, 103, 0)";
  ctx.fill();
  // desenha parte de cima da nave
  ctx.beginPath();
  ctx.moveTo(22.3, 12.0);
  ctx.bezierCurveTo(22.3, 13.3, 19.4, 14.3, 15.9, 14.3);
  ctx.bezierCurveTo(12.4, 14.3, 9.6, 13.3, 9.6, 12.0);
  ctx.bezierCurveTo(9.6, 10.8, 12.4, 9.7, 15.9, 9.7);
  ctx.bezierCurveTo(19.4, 9.7, 22.3, 10.8, 22.3, 12.0);
  ctx.closePath();
  ctx.fillStyle = "rgb(51, 190, 0)";
  ctx.fill();
  // armazena a nave no objeto 'nave'
  nave = ctx.getImageData(0, 0, naveTamX, naveTamY);
  // retorna a imagem antes de criar a nava
  ctx.putImageData(telaVazia, 0, 0);
  ctx.putImageData(nave, naveX, naveY);
}

// função de loop do jogo
function gameLoop() {
  // coloca a imagem original da tela para apagar a nave
  ctx.putImageData(telaVazia, maxX, maxY);
  // coloca a nave em nova posição
  ctx.putImageData(nave, naveX, naveY);
}

// função para "ouvir" (listener) o teclado
function qualTecla(evt) {
  // limpar campo de mensagem no HTML
  var msg = document.getElementById("msg");
  msg.innerHTML = "";
  // flag que indica se a nave chegou a algum dos 4 limites da tela
  // (superior, inferior, à esquerda ou à direita)
  var flag = 0;
  // armazena a posição da nave antes de movimentá-la
  oldX  = naveX;
  oldY  = naveY;
  back  = ctx.getImageData(0, 0, naveTamX, naveTamY);
  ctx.putImageData(telaVazia, 0, 0);
  // escolha das teclas
  if (evt.keyCode == 37) {
    // seta esquerda
    naveX = naveX - naveTamX;
    if (naveX < 0) {
      // se está no limite à esquerda
      msg.innerHTML = "<br><br>limite à ESQUERDA alcançdo!";
      naveX = 0;
      flag  = 1;
    }
  }
  else if (evt.keyCode == 39) {
    // seta direita
    naveX = naveX + naveTamX;
    if (naveX > maxX - naveTamX) {
      // se está no limite à direita
      msg.innerHTML = "<br><br>limite à DIREITA alcançdo!";
      naveX = maxX - naveTamX;
      flag  = 1;
    }
  }
  else if (evt.keyCode == 40) {
    // seta para baixo
    naveY = naveY + naveTamY;
    if (naveY > maxY - naveTamY) {
      // se está no limite inferior
      msg.innerHTML = "<br><br>limite INFERIOR alcançdo!";
      naveY = maxY - naveTamY;
      flag  = 1;
    }
  }
  else if (evt.keyCode == 38) {
    // Seta para cima
    naveY = naveY - naveTamY;
    if (naveY < 0) {
      // se chegou ao limite superior
      msg.innerHTML = "<br><br>limite a SUPERIOR alcançdo!";
      naveY = 0;
      flag  = 1;
    }
  }
  else if (evt.keyCode == 32) {
    // barra do espaço
    msg.innerHTML = "<br><br>Você apertou a barra do ESPAÇO!!!";
  }
  // se a flag == 1, a nave não deve se mexer, portanto,
  // volta as configurações da tela e da nave antes de mexer no teclado
  if (flag) {
    naveX = oldX;
    naveY = oldY;
    ctx.putImageData(back, 0, 0);
  }
}