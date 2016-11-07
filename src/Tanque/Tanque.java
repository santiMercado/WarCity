package Tanque;

import java.awt.Rectangle;

import Logica.Juego;
import Modulos.GameObject;



public abstract class Tanque extends GameObject{
	
	protected int direccion;
    protected int disparosActuales;

	public Tanque(int x, int y,Juego g){
		super(x,y,g);
		colision=true;
		direccion=3;
		rect= new Rectangle(x,y,39,39);
		disparosActuales=0;
	}

	public void mover(int dir){

		switch(dir){

		case 0: {x=x-getVelocidadM();
		rect.setBounds(x,y,39,39);
		graf.setX(x);
		break;}

		case 1: { x=x+getVelocidadM();
		rect.setBounds(x,y,39,39);
		graf.setX(x);
		break;}   

		case 2: { y=y+getVelocidadM(); 
		rect.setBounds(x,y,39,39);
		graf.setY(y);
		break;}

		case 3: { y=y-getVelocidadM();
		rect.setBounds(x,y,39,39);
		graf.setY(y);
		break;}
		}

	}

	public void setDir(int i){ 
		if(i>=0 && i<4)
			direccion=i;
	}


	public int getDir() {return direccion;}


	abstract public void disparar();

    abstract public int getVelocidadD();

    abstract public int getVelocidadM();
    
    abstract public int getResistencia();
    
    abstract public int getDisparosS();
    
    abstract public void terminoDisparo();

}

/*public void Mejorar(){
		n.subirNivel(this);
		}

	public void setNivel(Nivel n){
		this.n=n;
	}

	public Nivel getNivel(){	
		return n;
	}

 */

