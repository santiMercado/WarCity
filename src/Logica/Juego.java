package Logica;

import Interfaz.GUI;
import Modulos.IA;
import Modulos.Mapa;
import Obstaculos.Obstaculo;
import Obstaculos.PowerUp;
import Tanque.Enemigo;
import Tanque.Jugador;
import Tanque.Shot;
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
  protected int vidasJugador;
 
  
  public Juego(GUI interf){
	 puntaje=0;
	 vidasJugador=4;
	 Player= new Jugador(320,560,this);
	 map= new Mapa(Player);
	 E= (Enemigo[]) new Enemigo[4];
	 cant=0;
	 interfaz=interf;
	 interfaz.añadirAPanel(Player.obtenerGrafico().getJLabel());
	
  }
  
  public Mapa getMap(){return map;}
  
  public int getPuntaje(){return puntaje;}
  
  public Jugador getJugador(){ return Player;}
  
  public void restarVida(){
	  vidasJugador--;
	  /*
	   * if(vidasJugador==0) {
	   * GameOver();
	   * }
	   */
  }
  
  public void sumarVida(){
	  if(vidasJugador<4) vidasJugador++;
  }
  
  public Enemigo crearEnemigo()	{//El chequeo del arreglo lo hago en la GUI
	 
	  
	  Enemigo t=null;
	  
	if(map.getEnemigos().size()<4){  
	  Random  rnd = new Random();
	  IA Intelig;
	  int n =rnd.nextInt(4);
	  
	switch(n)	{
				case 0:
					t= new TanqueBasico(0,0,this); //1 100
					map.agregarEnemigo(t);
					interfaz.añadirAPanel(t.obtenerGrafico().getJLabel());
					Intelig= new IA(t,this);
					t.setIA(Intelig);
					
					break;
				case 1:
					t= new TanqueRapido(19*40,14*40,this);//1 200
					map.agregarEnemigo(t);
					interfaz.añadirAPanel(t.obtenerGrafico().getJLabel());
					Intelig= new IA(t,this);
					t.setIA(Intelig);
					break;
				case 2:
					t= new TanqueDePoder(19*40,0,this);//1 300
					map.agregarEnemigo(t);
					interfaz.añadirAPanel(t.obtenerGrafico().getJLabel());
					Intelig= new IA(t,this);
					t.setIA(Intelig);
					break;
				case 3:
					t= new TanqueBlindado(0,11*40,this);//4 400
					map.agregarEnemigo(t);
					interfaz.añadirAPanel(t.obtenerGrafico().getJLabel());
					Intelig= new IA(t,this);
					t.setIA(Intelig);
					
				}
	  	//E[cant++]=t;
	    map.agregarEnemigo(t);  	
	}
	 return t;
	}
  
  public void eliminarEnemigo(Enemigo g){
	 
	 map.removeEnemigo(g.obtenerX(), g.obtenerY());
	 g.obtenerGrafico().setVisible(false);
	 interfaz.remove(g.obtenerGrafico().getJLabel());
	 sumarPuntaje(g.getPuntos());
	 
   }
  
  public void sumarPuntaje(int i){
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
  
  /*private Enemigo destruirEnemigo(Enemigo t){
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
	}*/
  
   public boolean mover(Tanque t,int dir){
	   t.setDir(dir);
	   t.obtenerGrafico().setImage(dir);
	   
       return map.moverTanque(t,dir);
   }
   
   public void agregarDisparo(Shot s){
	   interfaz.añadirAPanel(s.obtenerGrafico().getJLabel());
	   interfaz.getPanelGeneral().setComponentZOrder(s.obtenerGrafico().getJLabel(),1);
	   repaint();
	   
   }
   
   
   public void agregarObstaculo(Obstaculo o){
	   map.agregarObstaculo(o);
	   interfaz.añadirAPanel(o.obtenerGrafico().getJLabel());
   }
   
   public void eliminarObstaculo(Obstaculo o){
	   if(o!=null){
	   o.obtenerGrafico().setVisible(false);
	   interfaz.remove(o.obtenerGrafico().getJLabel());
	   map.removeObstaculo(o.obtenerX(), o.obtenerY());
           }
   }
   
   public void agregarPowerUp(PowerUp p){
	   map.agregarPowerUp(p);
	   interfaz.añadirAPanel(p.obtenerGrafico().getJLabel());
	   interfaz.getPanelGeneral().setComponentZOrder(p.obtenerGrafico().getJLabel(),0);
	   repaint();
	   
   }
   
   public GUI getInterfaz(){ 
	   return interfaz;
   }
   
   public void repaint(){
	   interfaz.repaint();
   }
}

