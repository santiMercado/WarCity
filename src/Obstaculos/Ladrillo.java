package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;


public class Ladrillo extends Obstaculo {
  
	public Ladrillo(int n, int m,Juego g){
		super(n,m,g);
		resistencia=4;
		colision=true;
	    
	    graf=new ElementoGrafico(x,y,40,40);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/ladrillo.png")));
		graf.setImage(0);
		graf.setVisible(true);
	}
	
	public boolean recibirDisparo(){
		if(resistencia==0) return false;
		resistencia--;
		if(resistencia==0){
			colision=false;
			game.eliminarObstaculo(this);
		}
			
		return true;
	}
	
	
}