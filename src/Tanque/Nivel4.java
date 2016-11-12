package Tanque;

import Logica.Juego;

public class Nivel4 extends Nivel{

   public Nivel4(){	
	resistencia=4;
	velocidadm=2;
	velocidadd=3;
	dispSimultaneos=3;
   }
   
	public void subirNivel(Jugador pj) {	//antes decia TANQUE		
		
	}
	
	public void disparar(int x,int y,int dir,Juego g) {
		// TODO Auto-generated method stub
	
	int xx=x;
	int yy=y;
	
	if(dir==0){yy=yy+14;}
	if(dir==1){xx=xx+40; yy=yy+15;}
	if(dir==2){xx=xx+16; yy=yy+40;}
	if(dir==3) {xx=xx+15; yy=yy-10;}
	
	
	Shot s=new ShotJugadorX(xx,yy,g);
	g.agregarDisparo(s);
	s.iniciarDisparo();
	}

}
