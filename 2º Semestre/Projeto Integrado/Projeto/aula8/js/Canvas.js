// variáveis
var c     = document.getElementById("myCanvas");
var ctx   = c.getContext("2d");
var borda = 0;
var w     = c.width  - borda;
var h     = c.height - borda;

// criar retângulo
ctx.fillStyle = "#FF0000";             // cor do preenchimento
var ret = ctx.fillRect(0, 0, 80, 100); // cria retângulo

// criar circunferência / círculo / arco
var raio             = 50;             // raio da circunferência
var startAngle       = 0.0 * Math.PI;  // ângulo inicial
var endAngle         = 2.0 * Math.PI;  // ângulo final
var counterClockwise = false;           // sentido horário
var cir = ctx.arc(250, 150, raio, startAngle, endAngle, counterClockwise); // cria arco
ctx.fillStyle   = "#a4a";  // cor do preenchimento
ctx.fill();
ctx.lineWidth   = 10;      // espessura da linha
ctx.strokeStyle = '#4a4';  // cor da linha

ctx.stroke();  // desenha no canvas

// insere uma imagem
var posX  = 400;
var posY  =   0;
var larg  = 200;
var altu  = 137;
var bomba = new Image();
bomba.onload = function() {
	ctx.drawImage(bomba, posX, posY, larg, altu);
};
bomba.src = "./images/nave.png";

// faz a imagem descer na tela (variar o exio Y)
anima = setInterval (function() {
    // tira imagem da tela
	ctx.clearRect(400, posY, larg, altu);
    // coloca imagem da tela
	ctx.drawImage(bomba, posX, posY, larg, altu);
	if (posY < h - altu) posY+=5;
	else {
		clearInterval(anima);
		// troca imagem
		bomba.src = "./images/boom.jpg";
	}
}, 25);