package Tanque;

import javax.swing.ImageIcon;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;



public class Jugador extends Tanque{
	protected Nivel	lv;
	protected int powerups;
    
	public Jugador(int n,int m,Juego g){
		super(n,m,g);
		lv = new Nivel1();
        powerups=0;
		graf=new ElementoGrafico(n,m,40,40);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/nave0.gif")));
		graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/aangm1.gif")));
		graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/nave2.gif")));
		graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/nave3.gif")));
		graf.setImage(3);
		graf.setVisible(true);

	}
	
	
	public void agarrepowerup(){
		powerups++;
		if(powerups%4==0) Mejorar();	
	}

	public void Mejorar(){
		lv.subirNivel(this);
	}

	public void setNivel(Nivel n){
		lv=n;
	}

	public Nivel getNivel(){	
		return lv;
	}

	public void setResistencia(int i){
		lv.setResistencia(i);
	}
	
	public int getResistencia(){
		return lv.getResistencia();
	}

	public int getVelocidadD(){
		return lv.getVelocidadd()*5;}

	public int getVelocidadM(){
		return lv.getVelocidadm()*5;
	}
	
	public int getDisparosS(){
		return lv.getdispSimultaneos();}

	
	public boolean recibirDisparo(ShotEnemigo s){
		lv.restarResistencia();	
		if(lv.getResistencia()==0) game.restarVida();
		
		 return true;
	 }
	
	public void reiniciar(){
		lv=new Nivel1();
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
	if(disparosActuales<lv.getdispSimultaneos())	{
	
   disparosActuales++;		
	
		
		lv.disparar(x, y, direccion, game);
		
	}
	}

	@Override
	public void terminoDisparo() {
	   disparosActuales--;
	  
	}

}
