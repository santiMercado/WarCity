package Tanque;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;
import Modulos.IA;

public class TanqueBasico extends Enemigo {
 protected IA inteligencia;  
 
	public TanqueBasico(int x, int y,Juego g) {
		super(x, y,g);
		puntos=100;
		resistencia=1;
		velocidadm=1*5;
		velocidadd=1*5;
		
		
		
		graf=new ElementoGrafico(x,y,40,40);
		 graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/E1_LEFT.gif")));
		 graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/E1_RIGHT.gif")));
		 graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/E1_DOWN.gif")));
		 graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/E1_UP.gif")));
		 graf.setImage(3);
		 graf.setVisible(true);
		// TODO Auto-generated constructor stub
	 }

	@Override
	public int getPuntos() {
		// TODO Auto-generated method stub
		return puntos;
	}
	
	
	
}
