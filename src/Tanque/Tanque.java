package Tanque;

import java.awt.Rectangle;

import Logica.Juego;
import Modulos.GameObject;



public abstract class Tanque extends GameObject{
	protected Nivel n;
	protected int direccion;


	public Tanque(int x, int y,Juego g){
		super(x,y,g);
		colision=true;
		direccion=3;
		rect= new Rectangle(x,y,39,39);
		//n= new Nivel1();
	}

	public void mover(int dir){

		switch(dir){

		case 0: {x=x-10;
		rect.setBounds(x,y,39,39);
		graf.setX(x);
		break;}

		case 1: { x=x+10;
		rect.setBounds(x,y,39,39);
		graf.setX(x);
		break;}   

		case 2: { y=y+10; 
		rect.setBounds(x,y,39,39);
		graf.setY(y);
		break;}

		case 3: { y=y-10;
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

    public int getVelocidadD(){return n.getVelocidadd();}

    public int getVelocidadM(){return n.getVelocidadm();}
    
    public int getResistencia(){return n.getResistencia();}
    
    public int getDisparosS(){return n.getdispSimultaneos();}
    


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

