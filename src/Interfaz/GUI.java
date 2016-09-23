package Interfaz;

import Logica.Juego;
import Modulos.Acero;
import Modulos.Agua;
import Modulos.Aguila;
import Modulos.Jugador;
import Modulos.Ladrillo;
import Modulos.LugarVacio;
import Modulos.Selva;
import Modulos.Tanque;

import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;








// Lectura de archivos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GUI extends JFrame implements KeyListener {

	/**
	 * Launch the application.
	 */
	
	private JLabel tanque;
	private Juego game;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 650);
		JPanel panelGeneral = new JPanel();
		panelGeneral.setBounds(100, 100, 800, 600);
		panelGeneral.setBackground(new Color(0,0,0));
		getContentPane().add(panelGeneral);
		panelGeneral.setLayout(null);
		JLabel[] arr= new JLabel[300];
		tanque=new JLabel();
		game= new Juego();

		tanque.setBounds(game.getJugador().obtenerX(),game.getJugador().obtenerY(), 40, 40);
		tanque.setVisible(true);
		tanque.setIcon(new ImageIcon(GUI.class.getResource("/Graficos/tanque.png")));
		panelGeneral.add(tanque);
	    BufferedReader lector = null;
	    addKeyListener(this);
		
		
	    try {
			lector = new BufferedReader(new FileReader("bin/Graficos/map.txt"));
			String linea; // C:\\testing.txt, /Graficos/ladrillo.png, C:/map.txt
			int x = 0;
			int y = 0;
		    for(int i=0;i<15;i++){
		    	x = 0;
		    	linea = lector.readLine();
		    	for (int j = 0; j<linea.length(); j++) {
		    				y = 0+i*40;
		    				if (linea.charAt(j) == '0'){
		    					game.getMap().set(i, j, new LugarVacio(x,y));
		    					arr[j+(i*20)]=new JLabel("");
		    					arr[j+(i*20)].setBounds(x, y, 40, 40);
		    					x=x+40;
		    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/vacio.png")));
		    					panelGeneral.add(arr[j+(i*20)]);
		    					arr[j+(i*20)].setVisible(true);
		    				}
		    				else {
		    					if (linea.charAt(j) == '1'){
		    						game.getMap().set(i,j,new Ladrillo(x,y));
			    					arr[j+(i*20)]=new JLabel("");
			    					arr[j+(i*20)].setBounds(x, y, 40, 40);
			    					x=x+40;
			    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/ladrillo.png")));
			    					panelGeneral.add(arr[j+(i*20)]);
			    					arr[i].setVisible(true);
		    					}
		    					else {
		    						if (linea.charAt(j) == '2'){
		    							game.getMap().set(i,j,new Agua(x,y));
				    					arr[j+(i*20)]=new JLabel("");
				    					arr[j+(i*20)].setBounds(x, y, 40, 40);
				    					x=x+40;
				    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/agua.png")));
				    					panelGeneral.add(arr[j+(i*20)]);
				    					arr[j+(i*20)].setVisible(true);
		    						}
		    						else {
		    							if (linea.charAt(j) == '3'){
		    								game.getMap().set(i,j,new Acero(x,y));
		    		    					arr[j+(i*20)]=new JLabel("");
		    		    					arr[j+(i*20)].setBounds(x, y, 40, 40);
		    		    					x=x+40;
		    		    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/acero.png")));
		    		    					panelGeneral.add(arr[j+(i*20)]);
		    		    					arr[j+(i*20)].setVisible(true);
		    						    }
		    							else {
		    								if (linea.charAt(j) == '4'){
		    									game.getMap().set(i,j,new Aguila(x,y));
			    		    					arr[j+(i*20)]=new JLabel("");
			    		    					arr[j+(i*20)].setBounds(x, y, 40, 40);
			    		    					x=x+40;
			    		    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/aguila.png")));
			    		    					panelGeneral.add(arr[j+(i*20)]);
			    		    					arr[j+(i*20)].setVisible(true);
			    						    }
		    								else {
		    									if (linea.charAt(j) == '5'){
		    										game.getMap().set(i,j,new Selva(x,y));
				    		    					arr[j+(i*20)]=new JLabel("");
				    		    					arr[j+(i*20)].setBounds(x, y, 40, 40);
				    		    					x=x+40;
				    		    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/selva.png")));
				    		    					panelGeneral.add(arr[j+(i*20)]);
				    		    					arr[j+(i*20)].setVisible(true);
		    									}
		    								}
		    							}
		    			            }
	    		                }
		                     }
		    				}
		    		}
		}
	    catch(IOException e) {
			System.out.println("IO Exception");
		}
	    
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            game.getJugador().moverArriba();
	            tanque.setBounds(tanque.getX(), tanque.getY()-10, 40, 40);//k.moverArriba();// handle up 
	            break;
	        case KeyEvent.VK_DOWN:
	        	game.getJugador().moverAbajo();
	        	tanque.setBounds(tanque.getX()	, tanque.getY()+10, 40, 40);
	            //k.moverAbajo();// handle down
	            break;
	        case KeyEvent.VK_LEFT:
	        	game.getJugador().moverIzq();
	        	tanque.setBounds(tanque.getX()-10, tanque.getY(), 40, 40);
	            //k.moverIzq();// handle left
	            break;
	        case KeyEvent.VK_RIGHT :
	        	game.getJugador().moverDer();
	        	tanque.setBounds(tanque.getX()+10, tanque.getY(), 40, 40);
	            //k.moverDer();// handle right
	            break;
	    }
		System.out.println("keyTyped");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
