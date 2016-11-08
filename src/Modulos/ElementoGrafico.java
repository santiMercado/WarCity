package Modulos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ElementoGrafico {
 protected JLabel etiqueta;
 protected ImageIcon[] imagenes;
 
 protected int lasti=-1;
 
 public ElementoGrafico(int x,int y,int w,int h){
	 etiqueta=new JLabel();
	 etiqueta.setBounds(x,y,w,h);
	 imagenes= new ImageIcon[4];
 }
 
 public void setVisible(boolean visibilidad){ 
	 etiqueta.setVisible(visibilidad);
 }
 
 public void addImage(int i,ImageIcon imagen){
	 if(i<4)
	 imagenes[i]=imagen;
 }
 
 public void setImage(int i){
	 if(i<4){
	 
	 etiqueta.setIcon(imagenes[i]);
	 }
	 
 }
 
 public JLabel getJLabel(){return etiqueta;}
 
 public int getX(){return etiqueta.getX();}
 
 public int getY(){return etiqueta.getY();}
 
 public void setX(int i){
	 etiqueta.setBounds(i,etiqueta.getY(),etiqueta.getHeight(),etiqueta.getWidth());
	
 }
		 
 
 public void setY(int i){
	 etiqueta.setBounds(etiqueta.getX(),i,etiqueta.getHeight(),etiqueta.getWidth());
	 
 
 }

}
