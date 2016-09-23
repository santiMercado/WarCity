package Modulos;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public abstract class Tanque extends GameObject{
	protected int direccion;
	protected int velocidadm;
	protected int velocidadd;
	
	public Tanque(int x, int y){
		super(x,y);
	}
	
	public void moverDer() {
		
		x = x + 10;
	}
	public void moverIzq() {
		x = x - 10;
	}
	public void moverAbajo() {
		y = y + 10;
	}
	public void moverArriba() {
		y = y - 10;
	}
	
	
}
