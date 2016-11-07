package Tanque;

import Logica.Juego;
import Obstaculos.Acero;
import Obstaculos.Ladrillo;
import Obstaculos.PowerUp;

public class Pala extends PowerUp implements Runnable{
 protected Thread hilo;
 protected boolean execute;
	public Pala(int x, int y, Juego g) {
		super(x, y, g);
		hilo=new Thread(this);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activar() {
		
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
			
			execute=false;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}

	
