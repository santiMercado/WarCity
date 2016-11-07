package Obstaculos;

import java.awt.Rectangle;

import Logica.Juego;
import Modulos.GameObject;

abstract public class PowerUp extends GameObject {

	public PowerUp(int x,int y,Juego g){
		super(x,y,g);
		rect=new Rectangle(x,y,39,39);
	}
	
	abstract public void activar();
		

}
