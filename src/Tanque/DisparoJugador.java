package Tanque;

import Logica.Juego;
import Obstaculos.Obstaculo;

public class DisparoJugador extends Disparo {
 
	public DisparoJugador(int xj,int yj,Juego g){
		super(xj,yj,g.getJugador(),g);
	}
	
	public void afectar(Obstaculo o) {
		if(o.recibirDisparo()){
			graf.setVisible(false);
			game.getInterfaz().remove(graf.getJLabel());
			terminate();
			
		}
	}
	
	public void afectar(Enemigo e) {
		if(e.recibirDisparo()){
			graf.setVisible(false);
			game.getInterfaz().remove(graf.getJLabel());
			terminate();
		}
	}
	
	public void afectar(Jugador j) {
		// TODO Auto-generated method stub

	}
	
	
	
	
}
