package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;

public class Estrella extends PowerUp  {

	public Estrella(int x, int y, Juego g) {
		super(x, y, g);
		graf= new ElementoGrafico(x,y,39,39);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/powerupdeprueba.png")));
		graf.setImage(0);
		graf.setVisible(true);
	}

	@Override
	public void activar() {
	   graf.setVisible(false);
	   game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
	   game.getMap().removePowerUp(x, y);
	   game.sumarPuntaje(400);
	   game.getJugador().Mejorar();	
	}
	
	
	

	
}
