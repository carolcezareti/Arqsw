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

//variaveis barco inimigo 1
	var posX1  = 700;
	var posY1  = 430;
	var larg1  = 53;
	var altu1  = 80;
//Variaveis barco inimigo 2
	var posX2  = 350;
	var posY2  = 430;
	var larg2  = 53;
	var altu2  = 80;

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
	var QuantVidas = 8;//Quantidade de vidas
	var life = 40 * QuantVidas; //6 vidas;
	var lifesize = 40 * QuantVidas + 4;

	var numero = 0;
	
//variaveis da parabola	
	var velocidade = 5;
	//definimos o valor da origem do plano cartesiano	
	var origemX = 40;
	var origemY = 500;
	
	//indicamos os valores do ctx
	var A = -0.005;
	var B = 3;
	var C = 0;
		//criamos para auxiliar nas contas
	var delta;
	var x1;
	var x2;
	var y;			
			
	var distancia = 0;
			
	//calculamos o delta 
	delta = Math.pow(B,2) - 4 * A * C;
			
	//calculamos as raizes
	x1 = (- B + Math.sqrt(delta)) / (2 * A);
	x2 = (- B - Math.sqrt(delta)) / (2 * A);
			
	//atribuimos a primeira raiz encontrada .... acreditando que x1 < x2
	distancia = x1;	
	


	
//Movimentação
	document.addEventListener('keydown', function(evento){
	//atirar
	if (evento.keyCode == 32){//teste 
	numero += 1;
	}
	if(evento.keyCode==37){A += 0.001}
	if(evento.keyCode==39){A -= 0.001}
	if(evento.keyCode==38){B += 0.1}
	if(evento.keyCode==40){B -= 0.1}
	//velocidade
	if(evento.keyCode==88){velocidade+=1}
	if(evento.keyCode==90 && velocidade>0){velocidade-=1}
	});


	//LoopingGame
	var ligarGameLooping = setInterval(function () {GameLooping()},40);

	function GameLooping (){


	if(numero==0){MainMenu()}
	if(numero==1){DesenhaCenario()}
	if(numero==2){GameOver()}
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
	var botaoStyle = "#ddf";
  //botao iniciar
	ctx.beginPath();
	ctx.fillStyle = botaoStyle;
	ctx.fillRect((w - largbotao)/2,225,largbotao,altubotao);
	ctx.fillStyle = "#000";
	ctx.rect((w - largbotao)/2,225,largbotao,altubotao);
	ctx.stroke();
	//Texto iniciar
	ctx.fillStyle = "black";
	ctx.font = "50px Verdana";
	ctx.fillText("Começar!",(w - largbotao)/2 + 30,altubotao+190);
	
	//Hover botão iniciar
		document.addEventListener('mousemove', function (event){
		var mX = event.clientX - c.offsetLeft;
		var mY = event.clientY - c.offsetTop;
		if(mX>=(w - largbotao)/2 && mX<= (w - largbotao)/2 + largbotao && mY<=200+altubotao && mY>=200){
		numero = 1}
			
			})
	//Clicar no botão iniciar
	document.addEventListener('mousedown', function (event){
			var mX = event.clientX - c.offsetLeft;
			var mY = event.clientY - c.offsetTop;
			if(mX>=(w - largbotao)/2 && mX<= (w - largbotao)/2 + largbotao && mY<=200+altubotao && mY>=200){
			numero = 1}
			
			
			})
	}
	


	function DesenhaCenario (){
//Dados

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

//Animação do barco inimigo 1 
	var NI1 = new Image();
	NI1.src = "NI.png";
	ctx.drawImage(NI1,posX1,posY1,larg1,altu1);
	if(posX1 > NPTamX + NPX){
	posX1 -= 1}
	else{
	posX1 = 900 + larg1;
	life -= 40 * 1;
	}
//Animação do barco inimigo 2
	var NI2 = new Image();
	NI2.src = "NI.png";
	ctx.drawImage(NI2,posX2,posY2,larg2,altu2);
	if(posX2 > NPTamX + NPX){
	posX2 -= 1}
	else{
	posX2 = 900 + larg2;
	life -= 40 * 1;
	}
	
	if(life==-40){numero=2}
	

//mar onda1
	var OndaUm = new Image();
	OndaUm.src = "onda1.png";
	ctx.drawImage(OndaUm,posXOnda1,495,900,60);
	if(troca ==0){posXOnda1 -= 0};
	if(troca ==1){posXOnda1 += 0};
		
//Parabola
	ctx.beginPath();
	//exibe o conteúdo anterior na tela
	ctx.stroke();	
	ctx.fillStyle = "black";
	//configuração de escrita de texto na tela
	ctx.font="11px Arial";
	ctx.fillText("valor delta: " + delta + "   valor x1: " + x1 + "   valor x2: "+ x2 + "   dist:" + distancia + "      Variaveis Parabola:  " + "A: " + A + " | " + "B: " + B, 50, 100);

	
	
	ctx.beginPath();
	ctx.fillStyle = 'black';
			
	//queremos o valor de y em função de x (neste caso a distância)
	y = A * (Math.pow(distancia,2)) + (B * distancia) + C;				
				
	//desenha uma espera exatamente no ponto x e y
				
	ctx.arc((distancia + 40) , (500 - y) , 5, 0.0 * Math.PI, 2.0 * Math.PI, false);
	

	//(distancia + 40) -> + 40 por conta do início do eixo x (não começa em 0!)
	//(380 - y) -> garantimos que o gráfico suba...considerando 380 o eixo y
								
	//desenha na tela 
	ctx.fill();	
	distancia += velocidade;		
	if(y<=-20){distancia=0}	
//Colisao do tiro em relação ao barco inimigo 1
	if(posX1<=(distancia + 40) && posX1 + larg1>=(distancia + 40) && (posY1 + 40) <= (500-y)){
	posX1= w + larg1 
		
	}
//Colisao do tiro em relação ao barco inimigo 2			
	if(posX2<=(distancia + 40) && posX2 + larg2>=(distancia + 40) && (posY2 + 40) <= (500-y)){
	posX2= w + larg2 
		
	}


}


function GameOver(){
if(life == -40 ){

	ctx.fillStyle = "#fff";
	ctx.font = "100px Georgia";
	ctx.fillText("Você perdeu!", 200,300);
	ctx.fillRect();


}



}
