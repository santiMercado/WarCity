package Modulos;

import java.util.Random;

import Logica.Juego;
import Tanque.Enemigo;

//DE FRANCO

public class IA implements Runnable {
 protected Juego game;
 protected Thread t;
 protected Enemigo enemigo; 
 protected boolean dormir;
 protected boolean controldeWhile;
 
 public IA(Enemigo en,Juego g){
	 
	 enemigo=en;
	 game=g;
	 dormir=false;
	 t= new Thread(this,"IA");
	 t.start();
 } 
 
 public void dormir(){
	dormir=true;
 }

 public void run(){
   try{
	   
	   controldeWhile=true;
	   Random rnd= new Random();
	   int n1=0;
	   n1=rnd.nextInt(4);
	   boolean aux=true;
	   while(controldeWhile){ 
		  if(dormir){
			  Thread.sleep(5000);
			  dormir=false;
		  }
		  
		  aux=game.mover(enemigo,n1);
		  enemigo.disparar();
		  if(!aux) n1=rnd.nextInt(4);
		  
	      Thread.sleep(200);
 
	   
          }
   }
      catch(InterruptedException e){}
   
   }
 
 public void terminate(){
	 controldeWhile=false;
 }
}
