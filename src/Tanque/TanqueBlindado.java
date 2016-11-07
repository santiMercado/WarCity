package Tanque;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;

public class TanqueBlindado extends Enemigo {
 
	public TanqueBlindado(int x, int y,Juego g){
	 super(x,y,g);
	 resistencia=4;
	 puntos=400;
	 velocidadm=1*5;
	 velocidadd=2*5;
		
		
	 graf=new ElementoGrafico(x,y,40,40);
	 graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/blidadoIzq.png")));
	 graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/blindadoDer.png")));
	 graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/blindadoAbajo.png")));
	 graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/blindadoArriba.png")));
	 graf.setImage(3);
	 graf.setVisible(true);
		
	}

	@Override
	public int getPuntos() {
		// TODO Auto-generated method stub
		return puntos;
	}
	

}
