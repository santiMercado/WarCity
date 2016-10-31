package Tanque;

public class Nivel1 extends Nivel {
	
	public Nivel1(){
		resistencia=1;
		velocidadm=2;
		velocidadd=1;
		dispSimultaneos=1;
	}
	
	public void subirNivel(Jugador pj) { //antes la variable era de tipo TANQUE
		// TODO Auto-generated method stub
		Nivel lv=new Nivel2();
		pj.setNivel(lv);
	}
  
	
	
}
