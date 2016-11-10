package Logica;

import java.util.Random;

import Modulos.IA;
import Modulos.Mapa;
import Tanque.Enemigo;
import Tanque.TanqueBasico;
import Tanque.TanqueBlindado;
import Tanque.TanqueDePoder;
import Tanque.TanqueRapido;

public class FabricaEnemigos implements Runnable {
 protected Thread hilo;
 protected boolean execute;
 protected Juego game;
 protected Mapa map;
 protected Random n,pos;
 protected Par[] posiciones;
  
 public FabricaEnemigos(Juego g){
	 game=g;
	 map=g.getMap();
	 
	 
	    n= new Random();
		pos=new Random();
		posiciones= new Par[4];
		posiciones[0]=new Par(0,0);
		posiciones[1]= new Par(760,0);
		posiciones[2]= new Par(400,40);
	    posiciones[3]= new Par(80,120);
 }
 
 public void iniciar(){
	 crearEnemigo();
	 crearEnemigo();
	 crearEnemigo();
	 crearEnemigo();
	 
	 hilo=new Thread(this,"fabenemigos");
	 execute=true;
	 hilo.start();
 }
 
 public void terminate(){
	 execute=false;
 }

 public Enemigo crearEnemigo(){
		
	 if(map.getEnemigos().size()<4){
		 
		int enemy=n.nextInt(4);
		int posicion=pos.nextInt(4);
	    boolean noencontre=true;
	    Enemigo e=new TanqueBasico(0,0,game);
	    IA Intelig;
	while(noencontre){	
		switch(posicion){
		 
		case 0: {
			if(!map.choca(posiciones[posicion].getX(),posiciones[posicion].getY(), e)){
				noencontre=false;
			}
			else{
			posicion=pos.nextInt(4);}
			break;
		}
		case 1: {
			if(!map.choca(posiciones[posicion].getX(),posiciones[posicion].getY(), e)){
				noencontre=false;
			}
			else{
			posicion=pos.nextInt(4);}
			break;
		}
		case 2: {
			if(!map.choca(posiciones[posicion].getX(),posiciones[posicion].getY(), e)){
				noencontre=false;}
				else{
					posicion=pos.nextInt(4);}
			
			break;
		}
		case 3: {
			if(!map.choca(posiciones[posicion].getX(),posiciones[posicion].getY(), e)){
				noencontre=false;
			}
			else{
				posicion=pos.nextInt(4);}
			break;
		}
		
	   }
	}

	switch(enemy)	{
	case 0:
		e= new TanqueBasico(posiciones[posicion].getX(),posiciones[posicion].getY(),game); //1 100
		map.agregarEnemigo(e);
		game.getInterfaz().agregarAPanel(e.obtenerGrafico().getJLabel());
		Intelig= new IA(e,game);
		e.setIA(Intelig);
		
		break;
	case 1:
		e= new TanqueRapido(posiciones[posicion].getX(),posiciones[posicion].getY(),game);
		map.agregarEnemigo(e);
		game.getInterfaz().agregarAPanel(e.obtenerGrafico().getJLabel());
		Intelig= new IA(e,game);
		e.setIA(Intelig);
		break;
	case 2:
		e= new TanqueDePoder(posiciones[posicion].getX(),posiciones[posicion].getY(),game);
		map.agregarEnemigo(e);
		game.getInterfaz().agregarAPanel(e.obtenerGrafico().getJLabel());
		Intelig= new IA(e,game);
		e.setIA(Intelig);
		break;
	case 3:
		e= new TanqueBlindado(posiciones[posicion].getX(),posiciones[posicion].getY(),game);
		map.agregarEnemigo(e);
		game.getInterfaz().agregarAPanel(e.obtenerGrafico().getJLabel());
		Intelig= new IA(e,game);
		e.setIA(Intelig);
		
	}
	return e;
	}
	return null;
	 
	}
 
	public void run() {
		while(execute){
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(map.getEnemigos().size()<4) crearEnemigo();
		//if(map.getEnemigos().size()<2) crearEnemigo();
	}

	}
}
