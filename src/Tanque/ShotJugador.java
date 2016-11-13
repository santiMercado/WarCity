package Tanque;

import Logica.Juego;
import Musica.Disparo;
import Obstaculos.Obstaculo;

public class ShotJugador extends Shot {

	public ShotJugador(int x,int y,Juego g){
		super(x,y,g.getJugador(),g);
		Disparo disp = new Disparo();
	}
	
	 public boolean afectar(Jugador j){return false;}
	
	 public boolean afectar(Enemigo e){
		 return e.recibirDisparo(this);
	 }
	 
	 
	
	
}
