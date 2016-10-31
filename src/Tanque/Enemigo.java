package Tanque;

import Logica.Juego;

public abstract class Enemigo extends Tanque {
   protected int puntos;
   
	public Enemigo(int x, int y,Juego g) {
		super(x, y,g);
		// TODO Auto-generated constructor stub
	}
  
	public abstract int getPuntos();
	
	
	 public boolean recibirDisparo(){
		 resistencia--;
		 if(resistencia==0)
			game.eliminarEnemigo(this);
		 
		 return true;
	 }
	
	
}
