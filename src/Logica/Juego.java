package Logica;

import Interfaz.GUI;
import Modulos.IA;
import Modulos.Mapa;
import Obstaculos.Obstaculo;
import Tanque.Disparo;
import Tanque.DisparoJugador;
import Tanque.Enemigo;
import Tanque.Jugador;
import Tanque.Tanque;
import Tanque.TanqueBasico;
import Tanque.TanqueBlindado;
import Tanque.TanqueDePoder;
import Tanque.TanqueRapido;

import java.util.Random;

public class Juego {
  protected int puntaje;	
  protected Mapa map;
  protected Jugador Player;
  protected Enemigo[] E;
  protected int cant;
  protected GUI interfaz;
  
 
  
  public Juego(GUI interf){
	 puntaje=0;
	 Player= new Jugador(320,560,this);
	 map= new Mapa(Player);
	 E= (Enemigo[]) new Enemigo[4];
	 cant=0;
	 interfaz=interf;
	 interfaz.a�adirAPanel(Player.obtenerGrafico().getJLabel());
	
  }
  
  public Mapa getMap(){return map;}
  
  public int getPuntaje(){return puntaje;}
  
  public Jugador getJugador(){ return Player;}
  
  public Enemigo crearEnemigo()	{//El chequeo del arreglo lo hago en la GUI
	  Enemigo t=null;
	  Random  rnd = new Random();
	  IA Intelig;
	  int n =rnd.nextInt(4);
	  
	switch(n)	{
				case 0:
					t= new TanqueBasico(0,0,this); //1 100
					map.agregarEnemigo(t);
					interfaz.a�adirAPanel(t.obtenerGrafico().getJLabel());
					Intelig= new IA(t,this);
					break;
				case 1:
					t= new TanqueRapido(19*40,14*40,this);//1 200
					map.agregarEnemigo(t);
					interfaz.a�adirAPanel(t.obtenerGrafico().getJLabel());
					Intelig= new IA(t,this);
					break;
				case 2:
					t= new TanqueDePoder(19*40,0,this);//1 300
					map.agregarEnemigo(t);
					interfaz.a�adirAPanel(t.obtenerGrafico().getJLabel());
					Intelig= new IA(t,this);
					break;
				case 3:
					t= new TanqueBlindado(0,11*40,this);//4 400
					map.agregarEnemigo(t);
					interfaz.a�adirAPanel(t.obtenerGrafico().getJLabel());
					Intelig= new IA(t,this);
					
					break;
				}
	  	E[cant++]=t;
	  	
	 return t;
	}
  
  public void eliminarEnemigo(Enemigo g){
	 
	 map.removeEnemigo(g.obtenerX(), g.obtenerY());
	 g.obtenerGrafico().setVisible(false);
	 interfaz.remove(g.obtenerGrafico().getJLabel());
	 destruirEnemigo(g);
	 
   }
  
  private void sumarPuntaje(int i){
	  puntaje=puntaje+i;
  }
  
  public int obtenerCantEnemigos(){
	return cant;
  }
  
  public Enemigo obtenerEnemigo(int n){// PARA TESTEO!!!!!!!!!!!!!!!!!!!
	return E[n];
  }
  
  public void imprimirPuntaje(){
	System.out.println(puntaje);
  }
  
  private Enemigo destruirEnemigo(Enemigo t){
   boolean encontre=false;
   Enemigo tan=null;
   Enemigo aux=null;
		for(int i=0; ((i<4)&&(!encontre)) ; i++){
			if(E[i]==t)	{//-> ESTO ESTA BIEN???
				encontre=true;
				tan=t;
				E[i]=null;
				cant--;
				while(i<3)	{
					aux=E[i+1];
					E[i+1]=E[i];
					E[i]=aux;
					i++;
				}
			}
		}
	  sumarPuntaje(tan.getPuntos());
	 return  tan;
	}
  
   public boolean mover(Tanque t,int dir){
	   t.setDir(dir);
	   t.obtenerGrafico().setImage(dir);
	   
       return map.moverTanque(t,dir);
   }
   
  /* public boolean da�arMapaPJ(int dx,int dy){
	   return map.da�arObjetoPJ(dx,dy);
   }*/
   
   
   public void agregarDisparo(Disparo d){
	   
	   interfaz.a�adirAPanel(d.obtenerGrafico().getJLabel());
	   interfaz.setComponentZOrder(d.obtenerGrafico().getJLabel(), 0);
   }
   
   
   public void agregarObstaculo(Obstaculo o){
	   map.agregarObstaculo(o);
	   interfaz.a�adirAPanel(o.obtenerGrafico().getJLabel());
   }
   
   public void eliminarObstaculo(Obstaculo o){
	   o.obtenerGrafico().setVisible(false);
	   interfaz.remove(o.obtenerGrafico().getJLabel());
	   map.removeObstaculo(o.obtenerX(), o.obtenerY());
	   
   }
   
   public GUI getInterfaz(){ 
	   return interfaz;
   }
   
   public void repaint(){
	   interfaz.repaint();
   }
}

