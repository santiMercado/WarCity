package Modulos;

import Interfaz.GUI;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Jugador extends Tanque{
	public Jugador() {
		posX = 0;
		posY = 0;
		foto = new JLabel("");
		foto.setIcon(new ImageIcon(GUI.class.getResource("/Graficos/tanque.png"))); 
	}
}
