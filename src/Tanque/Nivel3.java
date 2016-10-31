package Tanque;

public class Nivel3 extends Nivel {

	public Nivel3(){
	   resistencia=2;
	   velocidadm=2;
	   velocidadd=2;
	   dispSimultaneos=2;
	}
	public void subirNivel(Jugador pj) { //antes decia TANQUE
		// TODO Auto-generated method stub
		Nivel lv=new Nivel4();
		pj.setNivel(lv);
	}
 
	
	
}
