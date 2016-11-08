package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;



public class Selva extends Obstaculo {
   public Selva(int n,int m,Juego g){
	   super(n,m,g);
	   resistencia=-1;
	   colision=false;
	   
	   graf=new ElementoGrafico(x,y,40,40);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/pastoraro.png")));
		graf.setImage(0);
		graf.setVisible(true);
		
   }
   
}
