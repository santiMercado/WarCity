package Obstaculos;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;
import Musica.SonidoAcero;
import Obstaculos.Acero;
import Obstaculos.Ladrillo;
import Obstaculos.PowerUp;

public class Pala extends PowerUp implements Runnable{
 protected Thread hilo;
 protected boolean execute;
	public Pala(int x, int y, Juego g) {
		super(x, y, g);
		hilo=new Thread(this);
		graf= new ElementoGrafico(x,y,39,39);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/Pala.png")));
		graf.setImage(0);
		graf.setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activar() {
		SonidoAcero ac = new SonidoAcero();
		graf.setVisible(false);
		game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
		game.sumarPuntaje(400);
		game.eliminarObstaculo(game.getMap().obtenerObstaculo(360,560));
		game.eliminarObstaculo(game.getMap().obtenerObstaculo(360,520));
		game.eliminarObstaculo(game.getMap().obtenerObstaculo(400,520));
		game.eliminarObstaculo(game.getMap().obtenerObstaculo(440,520));
		game.eliminarObstaculo(game.getMap().obtenerObstaculo(440,560));
		
		game.agregarObstaculo(new Acero(360,560,game));
		game.agregarObstaculo(new Acero(360,520,game));
		game.agregarObstaculo(new Acero(400,520,game));
		game.agregarObstaculo(new Acero(440,520,game));
		game.agregarObstaculo(new Acero(440,560,game));
		
		execute=true;
		hilo.start();
		// TODO Auto-generated method stub
		game.getMap().removePowerUp(x, y);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(execute){
		try {
			Thread.sleep(5000);
			
			game.eliminarObstaculo(game.getMap().obtenerObstaculo(360,560));
			game.eliminarObstaculo(game.getMap().obtenerObstaculo(360,520));
			game.eliminarObstaculo(game.getMap().obtenerObstaculo(400,520));
			game.eliminarObstaculo(game.getMap().obtenerObstaculo(440,520));
			game.eliminarObstaculo(game.getMap().obtenerObstaculo(440,560));
			
			game.agregarObstaculo(new Ladrillo(360,560,game));
			game.agregarObstaculo(new Ladrillo(360,520,game));
			game.agregarObstaculo(new Ladrillo(400,520,game));
			game.agregarObstaculo(new Ladrillo(440,520,game));
			game.agregarObstaculo(new Ladrillo(440,560,game));
			
			game.getInterfaz().repintar();
			execute=false;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}

	
