package Tanque;

import Logica.Juego;
import Obstaculos.Acero;
import Obstaculos.Obstaculo;

public class ShotJugadorX extends ShotJugador{

	public ShotJugadorX(int x,int y,Juego g){
		super(x,y,g);
	}
	
	public boolean afectar(Obstaculo o){
		 return o.recibirDisparoX(this);
	 }
	
}
