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





