var c = document.getElementById("mCanvas");
var ctx = c.getContext("2d");

var posX  = 0;
var posY  = 358;
var maxX;
var maxY;
var largura  = 50;
var altura  = 50;
var bomba = new Image();
var gravidade = 1.5;
var velocidade = 0;
bomba.onload = function() {
ctx.drawImage(bomba, posX, posY, largura, altura);
};
bomba.src = "bomba.png";

//Mar
ctx.fillStyle = "#22f";
ctx.fillRect(0,400,800,400);

ctx.stroke();
//Ceu
ctx.fillStyle = "#0aF";
ctx.fillRect(0,0,800,400);

ctx.stroke();
//Sol
ctx.beginPath();
ctx.arc(700,80,100,0,2*Math.PI);
ctx.fillStyle = "#ff0";
ctx.fill();
ctx.stroke();

bomba = {
  
}
