package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;
import Tanque.Shot;




public class Aguila extends Obstaculo{
  public Aguila(int n,int m,Juego g){
	  super(n,m,g);
	  colision=true;
	  resistencia=1;
	  graf=new ElementoGrafico(x,y,40,40);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/agilaportal.gif")));
		graf.setImage(0);
		graf.setVisible(true);
  }
  
  
  public boolean recibirDisparo(Shot s){
	  
	  //aca va el game over
	  
	  return true;
  }
}
