package Obstaculos;
import java.awt.Rectangle;

import Logica.Juego;
import Modulos.*;
import Tanque.Disparo;

public class Obstaculo extends GameObject {
 
	public Obstaculo(int x, int y,Juego g){
		super(x,y,g);
		rect= new Rectangle(x,y,39,39);
	}
	
	
	public boolean recibirDisparo(){
		return false;
	}
}