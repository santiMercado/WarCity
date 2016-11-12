package Obstaculos;
import java.awt.Rectangle;

import Logica.Juego;
import Modulos.*;
import Tanque.Shot;
import Tanque.ShotJugadorX;


public class Obstaculo extends GameObject {
 protected int resistencia;
	public Obstaculo(int x, int y,Juego g){
		super(x,y,g);
		rect= new Rectangle(x,y,39,39);
	}
	
	
	public boolean recibirDisparo(Shot s){
		return false;
	}
	
	public boolean recibirDisparoX(ShotJugadorX s){
		return false;
	}
      
}
