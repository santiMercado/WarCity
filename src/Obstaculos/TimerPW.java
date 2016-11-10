package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;

public class TimerPW extends PowerUp{

	public TimerPW(int x, int y, Juego g) {
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
		game.sumarPuntaje(400);
		for(int i=0;i<game.getMap().getEnemigos().size();i++){
			game.getMap().getEnemigos().get(i).getIA().dormir();
	    }
		
		game.getMap().removePowerUp(x, y);
	}

}