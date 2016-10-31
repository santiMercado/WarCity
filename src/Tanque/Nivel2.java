package Tanque;

public class Nivel2 extends Nivel{
	
	public Nivel2(){
     resistencia=1;
	 velocidadm=3;
	 velocidadd=2;
	 dispSimultaneos=1;
	}
	public void subirNivel(Jugador pj) { //antes decia TANQUE
		
		Nivel lv= new Nivel3();
		pj.setNivel(lv);
	}

	
}
