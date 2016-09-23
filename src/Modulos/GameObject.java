package Modulos;

public class GameObject {
 protected int x;
 protected int y;
 protected boolean colision;
 protected int resistencia;
 
 public GameObject(int x, int y){
	 this.x=x;
	 this.y=y;
 }
 
 public int obtenerX(){ return x;}
 
 public int obtenerY(){ return y;}
 
 public boolean collide(){
	 return colision;
 }
 
 public int obtenerResistencia(){
	 return resistencia;
 }
 
}
