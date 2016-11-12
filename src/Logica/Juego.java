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

import javax.management.timer.Timer;

public class Juego {
  protected int puntaje;	
  protected Mapa map;
  protected Jugador Player;
  protected int cant;
  protected GUI interfaz;
  protected int vidasJugador;
  protected FabricaPW factorypw;
  protected FabEnemigos factoryenemies;
  protected int enemigosEliminados;
  
  
  public Juego(GUI interf){
	 puntaje=0;
	 vidasJugador=4;
	 enemigosEliminados=0;
	 Player= new Jugador(320,560,this);
	 map= new Mapa(Player);
	 cant=0;
	 interfaz=interf;
	 factoryenemies= new FabEnemigos(this);
	 factorypw= new FabricaPW(this);
	 solicitarEnemigo();
	 solicitarEnemigo();
	 solicitarEnemigo();
	 solicitarEnemigo();
	 factoryenemies.iniciar();
	 
  }
  
  public Mapa getMap(){return map;}
  
  public int getPuntaje(){return puntaje;}
  
  public Jugador getJugador(){ return Player;}
  
  public void restarVida(){
	  vidasJugador--;
	  Player.obtenerGrafico().setVisible(false);
	  
	  if(vidasJugador==0) GameOver();
	   else{
		   Enemigo g;
	     for(int i=0;i<map.getEnemigos().size();i++){
	    	
		    g=map.removeEnemigo(map.getEnemigos().get(i).obtenerX(),map.getEnemigos().get(i).obtenerY());
		    g.obtenerGrafico().setVisible(false);
		    interfaz.remove(g.obtenerGrafico().getJLabel());
		    g.getIA().terminate();
		    
      }
	     Player.setX(320);
	     Player.setY(560);
	     Player.getRectangle().setBounds(320, 560, 39, 39);
	     Player.obtenerGrafico().setX(320);
	     Player.obtenerGrafico().setY(560);
	     Player.obtenerGrafico().setVisible(true);
	     Player.reiniciar();
	     
	     solicitarEnemigo();
	     solicitarEnemigo();
	
	     interfaz.repintar();
	     
  }
  }
  public void sumarVida(){
	  if(vidasJugador<4) vidasJugador++;
  }
  
  public void solicitarEnemigo(){
	 Enemigo en=factoryenemies.crearEnemigo(); 
	 interfaz.agregarAPanel(en.obtenerGrafico().getJLabel());
	 IA intelig= new IA(en,this);
	 en.setIA(intelig);
	 en.getIA().iniciar();
  }
  
  public void eliminarEnemigo(Enemigo g){
	 g.obtenerGrafico().setVisible(false);
     interfaz.remove(g.obtenerGrafico().getJLabel());
	 map.removeEnemigo(g.obtenerX(), g.obtenerY());
	 sumarPuntaje(g.getPuntos());
	 g.getIA().terminate();
	 
	 enemigosEliminados++;
	 if(enemigosEliminados%4==0) factorypw.crearPW();
	 if(map.getEnemigos().size()<2)solicitarEnemigo();
	 
	 
	 
   }
  
  
  public void sumarPuntaje(int i){
	  puntaje=puntaje+i;
	  interfaz.actualizarPuntaje(puntaje);
  }
  
  public int obtenerCantEnemigos(){
	return cant;
  }
  
  public void imprimirPuntaje(){
	System.out.println(puntaje);
  }
  
 
  
   public boolean mover(Tanque t,int dir){
	  if(t.getDir()!=dir){
		  t.setDir(dir);
		  t.obtenerGrafico().setImage(dir);
		  interfaz.repintar();
		  return true;
	  }
	  else{
	   t.setDir(dir);
	   t.obtenerGrafico().setImage(dir);
	   interfaz.repintar();
       return map.moverTanque(t,dir);
   }
   }
   
   public void agregarDisparo(Shot s){
	   interfaz.agregarAPanel(s.obtenerGrafico().getJLabel());
	   interfaz.getPanelGeneral().setComponentZOrder(s.obtenerGrafico().getJLabel(),1);
	   interfaz.repintar();
	   
   }
   
   
   public void agregarObstaculo(Obstaculo o){
	   map.agregarObstaculo(o);
	   interfaz.agregarAPanel(o.obtenerGrafico().getJLabel());
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
	   interfaz.agregarAPanel(p.obtenerGrafico().getJLabel());
	   interfaz.getPanelGeneral().setComponentZOrder(p.obtenerGrafico().getJLabel(),0);
	   interfaz.repintar();
	   
   }
   
   public void GameOver(){
	   
	   factoryenemies.terminate();
	   factorypw.terminate();
	   for(int i=0;i<map.getEnemigos().size();i++){
		    map.getEnemigos().get(i).getIA().terminate();
       }
	   
	   interfaz.gameover();
	   
   }
   
   public GUI getInterfaz(){ 
	   return interfaz;
   }
   
  
}

