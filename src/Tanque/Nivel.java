package Tanque;

import Logica.Juego;

public abstract class Nivel {
	protected int resistencia;
	protected int velocidadm;
	protected int velocidadd;
	protected int dispSimultaneos;
	

	public abstract void subirNivel(Jugador pj); //antes decia TANQUE 
	 
	public int getResistencia() {return resistencia;}
	
	public int getVelocidadm(){return velocidadm;}
	
	public int getVelocidadd(){return velocidadd;}
	
	public int getdispSimultaneos(){return dispSimultaneos;}
	
	public void restarResistencia(){
		resistencia--;
	}
	
    public void setResistencia(int i){
    	resistencia=i;
    }
    
    public void disparar(int x,int y,int dir,Juego g) {
		// TODO Auto-generated method stub
	
	int xx=x;
	int yy=y;
	
	if(dir==0){yy=yy+14;}
	if(dir==1){xx=xx+40; yy=yy+15;}
	if(dir==2){xx=xx+16; yy=yy+40;}
	if(dir==3) {xx=xx+15; yy=yy-10;}
	
	
	Shot s=new ShotJugador(xx,yy,g);
	g.agregarDisparo(s);
	s.iniciarDisparo();
	}
	}
			



