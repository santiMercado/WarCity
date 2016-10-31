package Tanque;

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
	
			
}


