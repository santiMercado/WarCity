package Modulos;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public abstract class Tanque {
	protected int posX;
	protected int posY;
	protected JLabel foto;
	public void moverDer() {
		posX = posX + 10;
	}
	public void moverIzq() {
		posX = posX - 10;
	}
	public void moverAbajo() {
		posY = posY + 10;
	}
	public void moverArriba() {
		posY = posY - 10;
	}
	
}
