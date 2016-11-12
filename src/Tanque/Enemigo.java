package Tanque;

import Logica.Juego;
import Modulos.IA;

public abstract class Enemigo extends Tanque {
   protected int puntos;
   protected int resistencia;
   protected int velocidadm;
   protected int velocidadd;
   protected int dispSimultaneos;
   protected IA inteligencia;
	
   public Enemigo(int x, int y,Juego g) {
		super(x,y,g);
		dispSimultaneos=1;
		// TODO Auto-generated constructor stub
	}
  
	public abstract int getPuntos();
	
	
	 public boolean recibirDisparo(ShotJugador s){
		 resistencia--;
		 if(resistencia==0)
			{
			 
			 game.eliminarEnemigo(this);
			}
		 return true;
	 }
	
	 public int getVelocidadD(){return velocidadd;}

	 public int getVelocidadM(){return velocidadm+4;}
	    
	 public int getResistencia(){return resistencia;}
	    
	 public int getDisparosS(){return dispSimultaneos;}
	 
	 public void setIA(IA intelig){
		 inteligencia=intelig;
	 }
	 public IA getIA(){
		 return inteligencia;
	 }
	 
	 public void disparar() {
			// TODO Auto-generated method stub
		
		 
		if(disparosActuales<dispSimultaneos)	{
		
	    disparosActuales++;		
		int xx=x;
		int yy=y;
		
		if(direccion==0){xx=xx; yy=yy+14;}
		if(direccion==1){xx=xx+40; yy=yy+15;}
		if(direccion==2){xx=xx+16; yy=yy+40;}
		if(direccion==3) {xx=xx+15; yy=yy-10;}
		
		
		Shot s=new ShotEnemigo(xx,yy,this,game);
		game.agregarDisparo(s);
		s.iniciarDisparo();
		}
		}
	 
	 public void terminoDisparo(){
		 disparosActuales--;
		
	 }
}
