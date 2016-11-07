package Tanque;

import Logica.Juego;

public class ShotEnemigo extends Shot {
  
	public ShotEnemigo(int x,int y,Enemigo e,Juego g){
		super(x,y,e,g);
	}
	
	 public boolean afectar(Jugador j){
		 return j.recibirDisparo(this);
	 }
	
	 public boolean afectar(Enemigo e){
		 return false;
	 }
}
