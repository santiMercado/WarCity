package Tanque;

import Logica.Juego;
import Musica.DispFuego;

public class ShotEnemigo extends Shot {
  
	public ShotEnemigo(int x,int y,Enemigo e,Juego g){
		super(x,y,e,g);
		DispFuego disp = new DispFuego();
	}
	
	 public boolean afectar(Jugador j){
		 return j.recibirDisparo(this);
	 }
	
	 public boolean afectar(Enemigo e){
		 return false;
	 }
}
