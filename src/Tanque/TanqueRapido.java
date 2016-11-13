package Tanque;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;

public class TanqueRapido extends Enemigo{

	public TanqueRapido(int x, int y,Juego g) {
		super(x,y,g);
		resistencia=1;
		puntos=200;
		velocidadm=3*5;
		velocidadd=2*5;
		// TODO Auto-generated constructor stub
		
		graf=new ElementoGrafico(x,y,40,40);
		 graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/E3_LEFT.gif")));
		 graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/E3_RIGHT.gif")));
		 graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/E3_DOWN.gif")));
		 graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/E3_UP.gif")));
		 graf.setImage(3);
		 graf.setVisible(true);
   }
	

	@Override
	public int getPuntos() {
		// TODO Auto-generated method stub
		return puntos;
	}


}
