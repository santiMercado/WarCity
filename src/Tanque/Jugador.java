package Tanque;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;



public class Jugador extends Tanque{
	protected Nivel	lv;

	public Jugador(int n,int m,Juego g){
		super(n,m,g);
		lv = new Nivel1();

		graf=new ElementoGrafico(n,m,40,40);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/tjugadorLEFT.png")));
		graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/tjugadorRIGHT.png")));
		graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/tjugadorDOWN.png")));
		graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/tjugadorUP.png")));
		graf.setImage(3);
		graf.setVisible(true);

	}

	public void Mejorar(){
		n.subirNivel(this);
	}

	public void setNivel(Nivel n){
		this.n=n;
	}

	public Nivel getNivel(){	
		return n;
	}

	public int getResistencia(){
		return lv.getResistencia();
	}

	public int getVelocidadd(){
		return lv.getVelocidadd();}

	public int getVelocidadm(){
		return lv.getVelocidadm();
	}

	@Override
	public void disparar() {
		
        if(direccion==0){
        	Disparo d = new DisparoJugador(x-10,y+15,game);
    		game.agregarDisparo(d);
    		d.iniciarDisparo();
		
		}
        
		if(direccion==1){
			Disparo d = new DisparoJugador(x+50,y+15,game);
    		game.agregarDisparo(d);
    		d.iniciarDisparo();
			
		}
		if(direccion==2){
			Disparo d = new DisparoJugador(x+15,y+40,game);
    		game.agregarDisparo(d);
    		d.iniciarDisparo();
			
		}
		if(direccion==3){
			Disparo d = new DisparoJugador(x+15,y+10,game);
    		game.agregarDisparo(d);
    		d.iniciarDisparo();
		}
		
	}




}
