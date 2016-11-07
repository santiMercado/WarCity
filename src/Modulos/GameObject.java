package Modulos;

import java.awt.Rectangle;

import Logica.Juego;


public class GameObject {
 
 protected Juego game;	
 protected int x;
 protected int y;
 protected boolean colision;
 //protected int resistencia;
 protected ElementoGrafico graf;
 protected Rectangle rect;
 
 public GameObject(int x, int y,Juego g){
	 game=g;
	 this.x=x;
	 this.y=y;
	 //rect= new Rectangle(x,y,40,40); //40 es dimensión
 }
 public Juego obtenerJuego(){return game;}
 
 public int obtenerX(){ return x;}
 
 public int obtenerY(){ return y;}
 
 public void setX(int x){this.x=x;}
 
 public void setY(int y){this.y=y;}
 
 public boolean collide(){
	 return colision;
 }
 
 //public int obtenerResistencia(){
//	 return resistencia;
// }
 
 public ElementoGrafico obtenerGrafico(){
	 return graf;
 }
 
 public Rectangle getRectangle(){ return rect;}

 public boolean recibirDisparo(){
	 return true;
 }
 
 
}
