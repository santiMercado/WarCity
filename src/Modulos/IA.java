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
 protected int direccion;
 protected int repeticion;
 
 public IA(Enemigo en,Juego g){
	 
	 enemigo=en;
	 game=g;
	 dormir=false;
	 repeticion=0;
	 //t= new Thread(this,"IA");
	 //t.start();
 }
 
 public void iniciar(){
	 controldeWhile=true;
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
			  Thread.sleep(20000);
			  dormir=false;
		  }
		  
		  aux=game.mover(enemigo,n1);
		  enemigo.disparar();
		  if(!aux){
			  n1=rnd.nextInt(4);
			  repeticion=0;
		  }
		  else{
			  repeticion++;
			  if(repeticion==10) {
				  n1=rnd.nextInt(4);
				  repeticion=0;
			  }
		     }
	      Thread.sleep(200);
 
	   
          }
   }
      catch(InterruptedException e){}
   
   }
 
 public void terminate(){
	 controldeWhile=false;
 }
}
