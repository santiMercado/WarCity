package Modulos;

import java.awt.Rectangle;
import java.util.ArrayList;

import Obstaculos.Obstaculo;
import Tanque.Disparo;
import Tanque.DisparoJugador;
import Tanque.Enemigo;
import Tanque.Jugador;
import Tanque.Tanque;


public class Mapa {

	protected Jugador player;	
	protected ArrayList<Enemigo> enemigos;
	protected ArrayList<Obstaculo> obstaculos;


	public Mapa(Jugador p){
		player=p;
		enemigos= new ArrayList<Enemigo>();
		obstaculos=new ArrayList<Obstaculo>();
	}

	public boolean moverTanque(Tanque t,int dir){
		switch(dir){

		case 0:{ if(t.obtenerX()==0){ return false;}
		else{ 
			if(!choca(t.obtenerX()-10,t.obtenerY(),t)){
				t.mover(dir);
				return true;
			}
		}  
		break;}

		case 1:{ if(t.obtenerX()==760){ return false;}
		else{
			if(!choca(t.obtenerX()+10,t.obtenerY(),t)){
				t.mover(dir);
				return true;
			}}
		break;}



		case 2: {if((t.obtenerX()==0)&&(t.obtenerY()==560)) return false;
		else{
			if(t.obtenerY()==560) return false;
			else{
				if(!choca(t.obtenerX(),t.obtenerY()+10,t)){
					t.mover(dir);
					return true;
				}
			}} break;}

		case 3: { if((t.obtenerX()==0)&&(t.obtenerY()==0)) return false;
		else{
			if(t.obtenerY()==0) return false;
			else{
				if(!choca(t.obtenerX(),t.obtenerY()-10,t)){  
					t.mover(dir);
					return true;
				}
			}

		} 

		}
		}
		return false;
	}



	public boolean choca(int x, int y,GameObject t){

		Rectangle r= new Rectangle(x,y,40,40);


		boolean aux=false;
		ArrayList<GameObject> lista=new ArrayList<GameObject>();


		if(!t.equals(player)){
			if(player.getRectangle().intersects(r))
				lista.add(player);
		}

		for(int i=0;i<enemigos.size();i++){
			if((enemigos.get(i).getRectangle().intersects(r))&&(!enemigos.get(i).equals(t))){
				lista.add(enemigos.get(i));
			}
		}

		for(int z=0;z<obstaculos.size();z++){
			if(obstaculos.get(z).getRectangle().intersects(r))
				lista.add(obstaculos.get(z));
		}

		for(int v=0;v<lista.size();v++){
			aux=(aux||lista.get(v).collide());
		}

		return aux;
	}

	public void agregarEnemigo(Enemigo e){
		enemigos.add(e);
	}

	public Obstaculo agregarObstaculo(Obstaculo o){
		obstaculos.add(o);
		return o;
	}

	public int removeEnemigo(int x, int y){

		for(int i=0;i<enemigos.size();i++){
			if((enemigos.get(i).obtenerX()==x)&&(enemigos.get(i).obtenerY()==y)){
				return enemigos.remove(i).getPuntos();
			}
		}
		return 0;
	}

	public void removeObstaculo(int x,int y){

		for(int i=0;i<obstaculos.size();i++){
			if((obstaculos.get(i).obtenerX()==x)&&(obstaculos.get(i).obtenerY()==y)){
				obstaculos.remove(i);  
			}
		}
	}

	public ArrayList<Obstaculo> getObstaculos(){
		return obstaculos;
	}

	public void chocaDisparo(Disparo d){
        
		
		Rectangle r=new Rectangle(d.obtenerX(),d.obtenerY(),9,9);

		if(player.getRectangle().intersects(r)){
			System.out.println("intersecte con jugador");
			d.afectar(player);
			
		}

		for(int i=0;i<enemigos.size();i++){
			if(enemigos.get(i).getRectangle().intersects(r)){
				System.out.println("intersecte con enemigo");
				d.afectar(enemigos.get(i));
				
			}
		}

		for(int j=0;j<obstaculos.size();j++){
			if(obstaculos.get(j).getRectangle().intersects(r)||r.intersects(obstaculos.get(j).getRectangle())) {   
				System.out.println("intersecte con obstaculo");
				d.afectar(obstaculos.get(j));
				
			}
		}

	}
}





