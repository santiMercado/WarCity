package Logica;

import java.util.Random;

import javax.management.timer.Timer;


import Modulos.Mapa;
import Obstaculos.Casco;
import Obstaculos.Estrella;
import Obstaculos.Granada;
import Obstaculos.LifeUp;
import Obstaculos.Pala;
import Obstaculos.PowerUp;
import Obstaculos.TimerPW;


public class FabricaPW implements Runnable {	
 protected Thread hilo;
 protected Mapa map;
 protected Juego game;
 protected Random n,pos;
 protected Par[] posiciones;
 protected boolean execute;
 protected Timer showPW;
 protected PowerUp p;
	public FabricaPW(Juego g){
		game=g;
		map=g.getMap();
	}
	
	public void terminate(){
		execute=false;
	}
	
	public void crearPW(){
		Random pw= new Random();
		Random pwX= new Random();
		Random pwY= new Random();
		int posX= pwX.nextInt(761);
		int posY= pwY.nextInt(561);
		int choose= pw.nextInt(6);
		
		
		switch(choose)	{
		case 0:
			p= new Casco(posX,posY,game); //1 100
			game.agregarPowerUp(p);
			break;
		case 1:
			p= new Estrella(posX,posY,game); //1 100
			game.agregarPowerUp(p);
			break;
			
		case 2:
			p= new Granada(posX,posY,game); //1 100
			game.agregarPowerUp(p);
			break;
		case 3:
			p= new LifeUp(posX,posY,game); //1 100
			game.agregarPowerUp(p);
			break;
		case 4:
			p= new Pala(posX,posY,game); //1 100
			game.agregarPowerUp(p);
			break;	
		case 5:
			p= new TimerPW(posX,posY,game); //1 100
			game.agregarPowerUp(p);
		}
		execute=true;
		hilo= new Thread(this,"fabpw");
		hilo.start();
		}
	
	public void run() {
	  	
		while(execute){
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(map.removePowerUp(p.obtenerX(),p.obtenerY())!=null){
			p.obtenerGrafico().setVisible(false);
			game.getInterfaz().getPanelGeneral().remove(p.obtenerGrafico().getJLabel());
			}  
		    execute=false;
		
	                  }
	}	
	
	

}
