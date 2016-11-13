package Tanque;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;
import Modulos.GameObject;
import Musica.Disparo;
import Obstaculos.Obstaculo;

public class Shot extends GameObject implements Runnable {
	private volatile boolean execute;
	protected int direccion;
	protected Tanque t;
	protected Thread hilo;
	protected int velocidad;

	public Shot(int x,int y,Tanque t,Juego g){
		super(x,y,g);
		this.t=t;
		hilo= new Thread(this,"shot");
		graf=new ElementoGrafico(x,y,10,10);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/fuegoizq.gif")));
		graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/fuegoder.gif")));
		graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/fuegoab.gif")));
		graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/fuegoarr.gif")));
		direccion=t.getDir();
		velocidad=t.getVelocidadD();
		
		graf.setImage(direccion);
		graf.setVisible(true);
	}



	public void iniciarDisparo(){
		execute=true;
		game.getInterfaz().agregarAPanel(graf.getJLabel());
		hilo.start();
	}

	public void terminate(){execute=false;}

	public boolean afectar(Jugador j){return false;}
	public boolean afectar(Obstaculo o){
		return o.recibirDisparo(this);

	}
	public boolean afectar(Enemigo e){return false;}

	public int getDir(){return direccion;}
	public int getVelocidad(){return velocidad;}

	public void moverDisparo(){

		if(direccion==0){  if(x<=0){ 
			t.terminoDisparo();
			graf.setVisible(false);
			game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
			terminate();
		}
		x=x-velocidad;
		graf.setX(x);
		}

		if(direccion==1){   
		  if(x>=800){
			t.terminoDisparo();
			graf.setVisible(false);
			game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
			terminate();
			}

		x=x+velocidad;
		graf.setX(x);}

		if(direccion==2){ 
			if((x<=0)||(y>=600)){
				t.terminoDisparo();
				graf.setVisible(false);
				game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
				terminate();
			}
			y=y+velocidad;
			graf.setY(y);
		}
		if(direccion==3){ 
			if((x<=0)||(y<=0)){
				t.terminoDisparo();
				graf.setVisible(false);
				game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
				terminate();
			}

			y=y-velocidad;
			graf.setY(y);
		}

		game.getInterfaz().repintar();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub


		while(execute){
			try{	
				if(game.getMap().chocaDisparo(this)){
					graf.setVisible(false);
					game.getInterfaz().getPanelGeneral().remove(graf.getJLabel());
                    t.terminoDisparo();
					terminate();
				}

				if(execute){
					moverDisparo();
				}


				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}



}
