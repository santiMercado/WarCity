package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;
import Musica.VidaExtra;

public class LifeUp extends PowerUp{

	public LifeUp(int x, int y, Juego g) {
		super(x, y, g);
		graf= new ElementoGrafico(x,y,39,39);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/VidaExtra.png")));
		graf.setImage(0);
		graf.setVisible(true);
	}

	public void activar(){
		VidaExtra vid = new VidaExtra();
		graf.setVisible(false);
		game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
		game.getMap().removePowerUp(x, y);
		game.sumarPuntaje(400);
		game.sumarVida();
		
	}
}
