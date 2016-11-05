package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;




public class Aguila extends Obstaculo{
  public Aguila(int n,int m,Juego g){
	  super(n,m,g);
	  colision=true;
	  resistencia=1;
	  graf=new ElementoGrafico(x,y,40,40);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/aguila.png")));
		graf.setImage(0);
		graf.setVisible(true);
  }
  
  
  public boolean recibirDisparo(){
	  
	  //aca va el game over
	  
	  return true;
  }
}
