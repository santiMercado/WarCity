package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;

public class Casco extends PowerUp implements Runnable {
 protected int oldres;	
 protected boolean execute;
 protected Thread hilo;
	public Casco(int x, int y, Juego g) {
		super(x, y, g);
		graf= new ElementoGrafico(x,y,39,39);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/casco0.png")));
		graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/casco1.png")));
		graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/casco2.png")));
		graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/casco3.png")));
		graf.setImage(0);
		graf.setVisible(true);
		hilo=new Thread(this);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void activar() {
	   graf.setVisible(false);
	   game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
	   game.sumarPuntaje(400);
	   game.getMap().removePowerUp(x, y);
	   oldres=game.getJugador().getResistencia();
	   game.getJugador().setResistencia(9999);
	   execute=true;
	   hilo.start();	
	}
 

	@Override
	public void run() {
		while(execute){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		game.getJugador().setResistencia(oldres);
		execute=false;
	 }
	}

	

	
}
