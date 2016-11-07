package Obstaculos;



import java.util.ArrayList;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;
import Tanque.Enemigo;


public class Granada extends PowerUp{
  protected boolean execute;
  
	public Granada(int x,int y,Juego g){
		super(x,y,g);
		graf= new ElementoGrafico(x,y,39,39);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/granada.gif")));
		graf.setImage(0);
		graf.setVisible(true);
		
	}
	
	public void activar(){
		graf.setVisible(false);
		game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
		ArrayList<Enemigo> lista= new ArrayList<Enemigo>();
		for(int i=0;i<game.getMap().getEnemigos().size();i++){
			lista.add(game.getMap().getEnemigos().get(i));
		}
		for(int i=0;i<lista.size();i++){
			game.eliminarEnemigo(lista.get(i));
		}
		
		game.getMap().removePowerUp(x, y);
	}
	
}
