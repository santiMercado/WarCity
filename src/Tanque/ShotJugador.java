package Tanque;

import Logica.Juego;
import Obstaculos.Obstaculo;

public class ShotJugador extends Shot {

	public ShotJugador(int x,int y,Juego g){
		super(x,y,g.getJugador(),g);
	}
	
	 public boolean afectar(Jugador j){return false;}
	
	 public boolean afectar(Enemigo e){
		 return e.recibirDisparo();
		 
	 }
	
	
}
