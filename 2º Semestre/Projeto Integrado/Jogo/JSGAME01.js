//Variaveis Globais
	var c = document.getElementById("CanvasTeste");
	var ctx = c.getContext("2d");
	var w = c.width;
	var h = c.height;
	var rectX = 20;
	var rectY = 40;
	var posicaoX = 50;
	var posicaoY = 50;
	GameLooping ();


	var space = 0;
	var velocidadeRect = 10;

	//variaveis barco inimigo
	var posX  = 700;
	var posY  = 430;
	var larg  = 53;
	var altu  = 80;

	// Variáveis Navio Principal
	var NPX		=	0;
	var NPY		=	480;
	var NPTamX	=	100;
	var NPTamY  =	90;
	var PuxaTiro = 0;
	var AbaixaTiro = 0;

	// Variaveis Onda
	var posXOnda2 = 0;
	var posXOnda1 = 0;
	var troca = 0;


	//Vidas
	var QuantVidas = 2;//Quantidade de vidas
	var life = 40 * QuantVidas; //6 vidas;
	var lifesize = 40 * QuantVidas + 4;

	var numero = 0;
	//Movimentação
	document.addEventListener('keydown', function(evento){

	if (evento.keyCode == 32){


	//teste

	numero += 1;

	}
	document.getElementById("testando").innerHTML = numero + " | troca: " + troca + " | posXOnda2: " + posXOnda2;
	});


	//Main Menu



	//LoopingGame
	var ligarGameLooping = setInterval(function () {GameLooping()},40);

	function GameLooping (){


	if(numero==0){
	MainMenu();
	}
	else{
	DesenhaCenario();

	}
	}

	function MainMenu(){
//Background Menu
var menuImg = new Image();
menuImg.src = "sea.jpg";
ctx.drawImage(menuImg,0,0,900,550);
ctx.fillStyle = "rgba(20,100,250,0.2";
ctx.fillRect(0,0,w,h);
//Titulo
	ctx.fillStyle = "black";
	ctx.font = "100px Verdana";
	ctx.fillText("SHIP ATTACK", 120,100);
//Botões Menu
	var largbotao = 300;
	var altubotao = 100;
  //botao iniciar
	ctx.beginPath();
	ctx.fillStyle = "#ff0";
	ctx.fillRect((w - largbotao)/2,225,largbotao,altubotao);
	//Texto iniciar
	ctx.fillStyle = "black";
	ctx.font = "50px Verdana";
	ctx.fillText("Começar!",(w - largbotao)/2 + 30,altubotao+190);


		document.addEventListener('mousedown', function (event){
			var mX = event.clientX - c.offsetLeft;
			var mY = event.clientY - c.offsetTop;
			if(mX>=(w - largbotao)/2 && mX<= (w - largbotao)/2 + largbotao && mY<=200+altubotao && mY>=200){
			document.getElementById("MouseMove");
			MouseMove.innerHTML = "Dentro da posição!"
			numero += 1;
			}
		}
	)
	}

	function DesenhaCenario (){
//LimparCenario
	ctx.clearRect(0,0,w,h);

//Ceu
	var ceuImg = new Image();
	ceuImg.src = "sky.png";
	ctx.drawImage(ceuImg,-1,-1,900,550);

//Vidas
	ctx.fillStyle = "Black";
	ctx.font = "40px Verdana";
	ctx.fillText("Vidas ",20,40);
//Quantidade de vidas
	ctx.strokeStyle = "#000";
	ctx.lineWidth = 4;
	ctx.strokeRect(138,4,lifesize,44);
	ctx.fillStyle = "rgba(0,0,250,0.3)";
	ctx.fillStyle = "#33ff33";
	ctx.fillRect(140,6,life,40);

//Sol
	//ctx.beginPath();
	//ctx.arc(700,80,100,0,2*Math.PI);
	//ctx.fillStyle = "#ff0";
	//ctx.fill();
	//ctx.stroke();

//mar onda2
	var OndaDois = new Image();
	OndaDois.src = "onda2.png";
	ctx.drawImage(OndaDois,posXOnda2,490,900,60);
	if(posXOnda2<=50 && troca ==0){posXOnda2 += 0.2};
	if(posXOnda2>30){troca = 1};
	if(posXOnda2>=-30 && troca ==1){posXOnda2 -= 0.2};
	if(posXOnda2<=-20){troca = 0};


//navio principal
	var navio = new Image();
	navio.src = "NPgrande.png";
	ctx.drawImage(navio,-30,490-120,150,150);

//Animação do barco inimigo
	var NI = new Image();
	NI.src = "NI.png";
	ctx.drawImage(NI,posX,posY,larg,altu);
	if(posX > NPTamX + NPX){
	posX -= 10;

	}
	else{
	posX = 800;
	life -= 40 * 1;
	GameOver();
	}

//mar onda1
	var OndaUm = new Image();
	OndaUm.src = "onda1.png";
	ctx.drawImage(OndaUm,posXOnda1,495,900,60);
	if(troca ==0){posXOnda1 -= 0};
	if(troca ==1){posXOnda1 += 0};


}


function GameOver(){
if(life == 40 * 0 ){

	ctx.fillStyle = "#fff";
	ctx.font = "100px Georgia";
	ctx.fillText("Você perdeu!", 200,300);
	ctx.fillRect();
	numero=0;

}


}
