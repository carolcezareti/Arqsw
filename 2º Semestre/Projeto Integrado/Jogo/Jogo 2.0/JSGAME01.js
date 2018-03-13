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
	var velocidadeDif = 1;
//Variaveis Dirigivel 1
	var posDX1  = w + 140;
	var posDY1  = 200;
	var largD1  = 140;
	var altuD1  = 85;
	var VidaD1 = 140;

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
	var life = 40 * QuantVidas; //8 vidas;
	var lifesize = 40 * QuantVidas + 4;
	var numero = 0;
//Score
	var Score = 0;
	
	
//variaveis da parabola	
	var velocidade = 5;
	//definimos o valor da origem do plano cartesiano	
	var origemX = 40;
	var origemY = 500;
	
//Tiro e movimentação do canhão
	var atirar = 0;
	//angulos do canhao
	var angulo = 1;
	var força = 0; 
	var Corforça = "rgba(0,0,0,0.7)";
	var Força0123 = 0;
	//Movimentação
	var AnguloCanhao = -0;
	

	//indicamos os valores do ctx
	var A;
	var B;
	var C = 0;
		//criamos para auxiliar nas contas
	var delta;
	var x1;
	var x2;
	var y;				
	var distancia = 0;
	
	//Botões Menu
	var largbotao = 300;
	var altubotao = 100;
	var botaoStyle = "#ddf";
	//dados
	var CorDados = "rgba(0,0,0,0.0)";
	

	
	

	
//Movimentação
	document.addEventListener('keydown', function(evento){
	//atirar
	if (evento.keyCode == 32){atirar = 1}
	if(evento.keyCode==37 && angulo<10 && distancia==0){angulo+=1;}
	if(evento.keyCode==39 && angulo>1 && distancia==0){angulo-=1;}
	if(evento.keyCode==38 && Força0123<4 && distancia==0){força -= -0.002;Força0123 += 1}
	if(evento.keyCode==40 && Força0123>0 && distancia==0){força += -0.002;Força0123 -= 1}
	//velocidade
	if(evento.keyCode==88){CorDados = "black"}
	if(evento.keyCode==90){CorDados = "rgba(0,0,0,0.0)"}
	});
	//Angulos
	A=-0.01; B=1.5
	//barra de força
	
	
	

	
	
	
	//LoopingGame
	var ligarGameLooping = setInterval(function () {GameLooping()},40);

	function GameLooping (){


	if(numero==0){MainMenu()}
	if(numero==1){DesenhaCenario()}
	if(numero==2){GameOver()}
	
	}
	
	function angulo(){
	
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
		botaoStyle = "#bbd"}
		else {botaoStyle = "#ddf"}
			
			})
	//Clicar no botão iniciar
	document.addEventListener('mousedown', function (event){
		var mX = event.clientX - c.offsetLeft;
		var mY = event.clientY - c.offsetTop;
		if(mX>=(w - largbotao)/2 && mX<= (w - largbotao)/2 + largbotao && mY<=200+altubotao && mY>=200){
		numero = 1}
			
			
			})
	}
	
	
	
	//calculamos o delta 
	delta = Math.pow(B,2) - 4 * A * C;
			
	//calculamos as raizes
	x1 = (- B + Math.sqrt(delta)) / (2 * A);
	x2 = (- B - Math.sqrt(delta)) / (2 * A);
			
	//atribuimos a primeira raiz encontrada .... acreditando que x1 < x2
	distancia = x1;	
	
	


	function DesenhaCenario (){
//angulos canhao
	//Angulos
	if(angulo==1){A=-0.01 + força * 1; B=1.5; velocidade=5; AnguloCanhao = -45}
	if(angulo==2){A=-0.03 + força * 3; B=2.5; velocidade=4.7; AnguloCanhao = -56}
	if(angulo==3){A=-0.05 + força * 5; B=3.5; velocidade=4.3; AnguloCanhao = -67}
	if(angulo==4){A=-0.07 + força * 7; B=4.5; velocidade=3.9; AnguloCanhao = -72}
	if(angulo==5){A=-0.09 + força * 9; B=5.5; velocidade=3.5; AnguloCanhao = -75}
	if(angulo==6){A=-0.11 + força * 11; B=6.5; velocidade=3.1; AnguloCanhao =-78}
	if(angulo==7){A=-0.13 + força * 13; B=7.5; velocidade=2.7; AnguloCanhao =-79}
	if(angulo==8){A=-0.15 + força * 15; B=8.5; velocidade=2.3; AnguloCanhao =-80}
	if(angulo==9){A=-0.17 + força * 17; B=9.5; velocidade=1.9; AnguloCanhao =-81}
	if(angulo==10){A=-0.19 + força * 19; B=10.5; velocidade=1.5; AnguloCanhao =-82}
	
	


//LimparCenario
	ctx.clearRect(0,0,w,h);

//Ceu
	var ceuImg = new Image();
	ceuImg.src = "sky.png";
	ctx.drawImage(ceuImg,-1,-1,900,550);

//Vidas
	ctx.fillStyle = "Black";
	ctx.font = "40px Verdana";
	ctx.fillText("Vidas ",420,40);
//Quantidade de vidas
	ctx.strokeStyle = "#000";
	ctx.lineWidth = 4;
	ctx.strokeRect(538,4,lifesize,44);
	ctx.fillStyle = "rgba(51,255,51,0.7)";
	ctx.fillRect(540,6,life,40);
	
//força
	ctx.fillStyle = "black";
	ctx.font = "40px Verdana";
	ctx.fillText("Força",20,40);
	if(Força0123==1){Corforça = "rgba(51,255,51,0.9)"}
	if(Força0123==2){Corforça = "rgba(255,255,0,0.9)"}
	if(Força0123==3){Corforça = "rgba(255,165,0,0.9)"}
	if(Força0123==4){Corforça = "rgba(255,0,0,0.9)"}
//Score
	ctx.fillStyle = "black";
	ctx.font = "40px Verdana";
	ctx.fillText("Score: " + Score,690,85);
	
	var TamBarra = 50 * Força0123;
	ctx.beginPath();
	ctx.strokeStyle = "black";
	ctx.strokeRect(148,4,200+4,44);
	ctx.stroke();
	ctx.beginPath();
	ctx.fillStyle = Corforça;
	ctx.fillRect(150,6,TamBarra,40);
	ctx.stroke();
//Canhão
	ctx.save();
	ctx.translate(35,490);
	ctx.rotate(AnguloCanhao*Math.PI/180);
	ctx.fillStyle = "black";
	ctx.fillRect(0,0,25,10)
	ctx.restore(); 
	
	
	
//mar onda2
	ctx.translate(0,0)
	var OndaDois = new Image();
	OndaDois.src = "onda2.png";
	ctx.drawImage(OndaDois,posXOnda2,490,900,60);
	if(posXOnda2<=50 && troca ==0){posXOnda2 += 0.2};
	if(posXOnda2>30){troca = 1};
	if(posXOnda2>=-30 && troca ==1){posXOnda2 -= 0.2};
	if(posXOnda2<=-20){troca = 0};


//navio principal
	var navio = new Image()
	if(life>QuantVidas * 40/2){
	navio.src = "NPgrande.png"}
	else{navio.src = "NPgrandedestruido.png"}
	
	ctx.drawImage(navio,-30,490-120,150,150);
	
	//Inimigos
		
//Animação do barco inimigo 1 
	var NI1 = new Image();
	NI1.src = "NI.png";
	ctx.drawImage(NI1,posX1,posY1,larg1,altu1);
	if(posX1 > NPTamX + NPX){
	posX1 -= velocidadeDif}
	else{
	posX1 = 900 + larg1;
	life -= 40 * 1;
	}
//Animação do barco inimigo 2
	var NI2 = new Image();
	NI2.src = "NI.png";
	ctx.drawImage(NI2,posX2,posY2,larg2,altu2);
	if(posX2 > NPTamX + NPX){
	posX2 -= velocidadeDif}
	else{
	posX2 = 900 + larg2;
	life -= 40 * 1;
	}
	
	if(life<=-20){numero=2}

	//Animação dirigivel1
	var Dir1 = new Image();
	Dir1.src = "dirigivel.png";
	ctx.drawImage(Dir1,posDX1,posDY1,largD1,altuD1);
	if(posDX1==w){velocidadeDif +=1}
	if(posDX1>40){posDX1 -= 0.5}
	else{posDY1 += 0.1;
	if(posDY1 > 370 ){numero=2}
	}
	//VidaDirigivel
	ctx.fillStyle = "rgba(51,255,51,0.9)";
	ctx.fillRect(posDX1,posDY1-10,VidaD1,10);
	ctx.stroke();
	
//Parabola
	
	ctx.beginPath();
	//exibe o conteúdo anterior na tela
	ctx.stroke();	
	ctx.fillStyle = CorDados;
	//configuração de escrita de texto na tela
	ctx.font="11px Arial";
	ctx.fillText("angulo: " + angulo + " | velocidade: " + velocidade, 50, 100);
	ctx.fillText("tam força: " + TamBarra + "  tam 0123: " + Força0123 + " Angulo: " + AnguloCanhao,50, 120)
	ctx.fillText("valor delta: " + delta + "   valor x1: " + x1 + "   valor x2: "+ x2 + " y: "+ y +"   dist:" + distancia + "      Variaveis Parabola:  " + "A: " + A + " | " + "B: " + B + " | C: " + C, 50, 140);
	
	ctx.beginPath();
	ctx.fillStyle = 'black';
			
	//queremos o valor de y em função de x (neste caso a distância)
	y = A * (Math.pow(distancia,2)) + (B * distancia) + C;				
				
	//desenha uma espera exatamente no ponto x e y
				
	ctx.arc((distancia + 40) , (500 - y) , 5, 0.0 * Math.PI, 2.0 * Math.PI, false);
	

	//(distancia + 40) -> + 40 por conta do início do eixo x (não começa em 0!)
	//(380 - y) -> garantimos que o gráfico suba...considerando 380 o eixo y
								
	//atirar
	if(atirar==1){
	//desenha na tela 
	ctx.fill();	
	distancia += velocidade;		
	if(y<=-20){distancia=0; atirar=0}
	}
	

//mar onda1
	var OndaUm = new Image();
	OndaUm.src = "onda1.png";
	ctx.drawImage(OndaUm,posXOnda1,495,900,60);
	if(troca ==0){posXOnda1 -= 0};
	if(troca ==1){posXOnda1 += 0};
		


//Colisao do tiro em relação ao barco inimigo 1
	if(posX1<=(distancia + 40) && posX1 + larg1>=(distancia + 40) && (posY1 + 40) <= (500-y)){
	posX1= w + larg1;  Score+=1;
		
	}
//Colisao do tiro em relação ao barco inimigo 2			
	if(posX2<=(distancia + 40) && posX2 + larg2>=(distancia + 40) && (posY2 + 40) <= (500-y)){
	posX2= w + larg2;  Score+=1;
		
	}
//Colisao do tiro em relação ao dirigivel1
	if(posDX1<=(distancia + 40) && posDX1 + largD1>=(distancia + 40) && posDY1 <= y){
	VidaD1-=7; distancia=0; atirar=0; Score+=1;
	if(VidaD1<=0){posDX1= w + largD1;VidaD1=140} 
		
	}


}


function GameOver(){
if(life == -40 ){


	var go = new Image();
	go.src = "GameOver.png";
	ctx.drawImage(go,0,0,w,h);

}



}
