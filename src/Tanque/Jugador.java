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
		// TODO Auto-generated method stub
	int xx=x;
	int yy=y;
	
	if(direccion==0){xx=xx-10; yy=yy+14;}
	if(direccion==1){xx=xx+40; yy=yy+15;}
	if(direccion==2){xx=xx+16; yy=yy+40;}
	if(direccion==3) {xx=xx+15; yy=yy-10;}
	
	System.out.println(direccion);
	Shot s=new ShotJugador(xx,yy,game);
	game.agregarDisparo(s);
	s.iniciarDisparo();
	}

	




}
