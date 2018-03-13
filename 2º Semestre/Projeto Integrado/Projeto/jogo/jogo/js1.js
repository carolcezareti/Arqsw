var c = document.getElementById("mCanvas");
var ctx = c.getContext("2d");
//Mar
ctx.fillStyle = "#22f";
ctx.fillRect(0,400,800,450);

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
//arco
ctx.beginPath();
ctx.moveTo(0,400 - 0);
ctx.quadraticCurveTo(300,400 - 300,600,400-0);
ctx.stroke();
//barco
ctx.fillStyle = "black";
ctx.fillRect(0,400-20,100,40);
ctx.stroke();


function calcula (){
 var tA = document.getElementById("valA").value;
 var A = parseFloat(tA)
 var tB = document.getElementById("valB").value;
 var B = parseFloat(tB)
 var tC = document.getElementById("valC").value;
 var C = parseFloat(tC)

 var D1 = -4 * A * C
 var Dr = Math.pow(B,2) + D1;
 var D = document.getElementById("valDelta").value = Dr;


 var X1N = -B + Math.sqrt(Dr);
 var X1r = X1N / 2 * A;
 var X1 = document.getElementById("valX1").value = X1r;


 var X2N = -B - Math.sqrt(Dr);
 var X2r = X2N / 2 * A;
 var X2 = document.getElementById("valX2").value = X2r;

 var ValXvr = X1r - X2r;
 var valX = document.getElementById("valXv").value = ValXvr;

 var ValYvr = A * Math.pow(ValXvr,2) + B * ValXvr + C;
 var ValY = document.getElementById("valYv").value = ValYvr;
