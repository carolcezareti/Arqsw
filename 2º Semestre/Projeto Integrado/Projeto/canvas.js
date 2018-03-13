var c= document.getElementById("myCanvas");
var ctx = c.getContext("2d");
var posX  = 0;
var posY  = 508;
var largura  = 50;
var altura  = 50;
var bomba = new Image();
var gravidade = 1.5;
var velocidade = 0;
bomba.onload = function() {
ctx.drawImage(bomba, posX, posY, largura, altura);
};
bomba.src = "bomba.png";

ctx.fillStyle = "#006";             // cor do preenchimento
var ret = ctx.fillRect(0, 550, 800, 800);
