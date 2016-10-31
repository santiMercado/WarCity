package Tanque;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaz.GUI;
import Logica.Juego;
import Modulos.ElementoGrafico;
import Modulos.GameObject;
import Obstaculos.Obstaculo;

public class Disparo extends GameObject implements Runnable{
	protected boolean controlWhile;
	protected Thread hilo;
    protected Tanque tank;
    protected int direccion;
    
   public Disparo(int x, int y,Tanque t,Juego g) {
		super(x, y, g);
		rect=new Rectangle(x,y,9,9);
	    graf= new ElementoGrafico(x,y,10,10);
		graf.addImage(0, new ImageIcon(GUI.class.getResource("/Graficos/balasimple.png")));
		graf.addImage(1, new ImageIcon(GUI.class.getResource("/Graficos/balasimple.png")));
		graf.addImage(2, new ImageIcon(GUI.class.getResource("/Graficos/balasimple.png")));
		graf.addImage(3, new ImageIcon(GUI.class.getResource("/Graficos/balasimple.png")));
		tank=t;
		direccion=t.getDir();
		graf.setImage(direccion);
		graf.setVisible(true);
		
	    controlWhile=true;
	    
	}
   
   public void iniciarDisparo(){
	   hilo= new Thread(this,"shot");
	   hilo.start();
   }
   
   public int obtenerDireccion(){return direccion;}
   
   public void afectar(Obstaculo o){}
   
   public void afectar(Enemigo e){}
   
   public void afectar(Jugador j){}
   
   public void moverBala(){
		
	   if(direccion==0){
			if(x<=0){ 
				graf.setVisible(false);
				game.getInterfaz().remove(graf.getJLabel());
				terminate();
			}	
			setX(x-1);
			rect.setBounds(x,y,9,9);
			graf.setX(x);
			
			System.out.println("rect x= "+rect.x+" y= "+rect.y);
			System.out.println("graf x= "+graf.getX()+" y= "+graf.getY() );
		                }
		
		if(direccion==1){
			if(x>800){
				graf.setVisible(false);
				game.getInterfaz().remove(graf.getJLabel());
				terminate();
			}
			setX(x+1);	
			rect.setBounds(x,y,9,9);
			graf.setX(x);
			System.out.println("rect x= "+rect.x+" y= "+rect.y);
			System.out.println(
					"graf x= "+graf.getX()+" y= "+graf.getY() );
		}
		if(direccion==2){
			if((x==0)&&(y>600)) {
				graf.setVisible(false);
				game.getInterfaz().remove(graf.getJLabel());
				terminate();
			}
			else{
				if(y>600) {
					graf.setVisible(false);
					game.getInterfaz().remove(graf.getJLabel());
					terminate(); 

				}
			}
			setY(y+1);
			rect.setBounds(x, y, 9, 9);
			graf.setY(y);
			System.out.println("rect x= "+rect.x+" y= "+rect.y);
			System.out.println("graf x= "+graf.getX()+" y= "+graf.getY() );
		}
		if(direccion==3){
			if((x==0)&&(y==0)) {
				graf.setVisible(false);
				game.getInterfaz().remove(graf.getJLabel());
				terminate(); 
			}
			else{
				if(y<0) {
					graf.setVisible(false);
					game.getInterfaz().remove(graf.getJLabel());
					terminate(); 	  
				}
			}

			setY(y-1);
			rect.setBounds(x, y, 9, 9);
			graf.setY(y);
			System.out.println("rect x= "+rect.x+" y= "+rect.y);
			System.out.println("graf x= "+graf.getX()+" y= "+graf.getY() );
		}
	}
   
   
   public void terminate(){controlWhile=false;}
   
   public void run(){
	  try{
	   while(controlWhile){
		  
		  game.getMap().chocaDisparo(this);
		  moverBala();
		  game.repaint();
		  Thread.sleep(10); 
		   
		   
	   }
	   
	  }catch(InterruptedException e){}
  
   }
   
   

	
  
	
}
