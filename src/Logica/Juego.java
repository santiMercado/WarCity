package Logica;

import Modulos.GameObject;
import Modulos.Jugador;
import Modulos.Mapa;
import Modulos.Tanque;

public class Juego {
  protected int puntaje;	
  protected Mapa map;
  protected Tanque Player;
  
  public Juego(){
	 puntaje=0;
	 map= new Mapa(15,20);
	 Player= new Jugador(0,0);
  }
  
  public Mapa getMap(){return map;}
  
  public int getPuntaje(){return puntaje;}
  
  public Tanque getJugador(){ return Player;}
  
  
}
