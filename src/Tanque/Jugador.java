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
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/aangm0.gif")));
		graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/aangm1.gif")));
		graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/aangm2.gif")));
		graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/aangm3.gif")));
		graf.addImage(4, new ImageIcon(GUI.class.getResource("/Graficos/aang0.png")));
		graf.addImage(5, new ImageIcon(GUI.class.getResource("/Graficos/aang1_0.png")));
		graf.addImage(6, new ImageIcon(GUI.class.getResource("/Graficos/aang2.png")));
		graf.addImage(7, new ImageIcon(GUI.class.getResource("/Graficos/aang3.png")));
		
		graf.setImage(7);
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
