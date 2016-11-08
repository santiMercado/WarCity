package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;
import Tanque.Shot;
import Tanque.ShotJugadorX;


public class Acero extends Obstaculo{

	public Acero(int n,int m,Juego g){
		super(n,m,g);
		colision=true;
		resistencia=4;
		graf=new ElementoGrafico(x,y,40,40);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/acero2.png")));
		graf.setImage(0);
		graf.setVisible(true);
	}
	
	public boolean recibirDisparo(Shot s){
		return true;
	}
	
	public boolean recibirDisparo(ShotJugadorX s){
		if(resistencia==0) return false;
		resistencia--;
		if(resistencia==0){
			colision=false;
			game.eliminarObstaculo(this);
		}
		
		return true;
	}
}
