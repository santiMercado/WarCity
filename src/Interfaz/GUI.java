package Interfaz;

import Logica.Juego;
import Modulos.GameObject;
import Modulos.IA;
import Obstaculos.Acero;
import Obstaculos.Agua;
import Obstaculos.Aguila;
import Obstaculos.Ladrillo;
import Obstaculos.Selva;
import Tanque.Enemigo;
import Tanque.Jugador;
import Tanque.Shot;
import Tanque.Tanque;
import Tanque.TanqueBasico;

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


	private JLabel enemigo;
	private JLabel enemigo1;
	private JLabel ladrillo;
	private JPanel panelGeneral;
	private Juego game;
	private JLabel aux;

	boolean esta=false;
	boolean estaLadrillo=false;


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
		panelGeneral = new JPanel();
		panelGeneral.setBounds(100, 100, 800, 600);
		panelGeneral.setBackground(new Color(0,0,0));
		getContentPane().add(panelGeneral);
		panelGeneral.setLayout(null);
		JLabel[] arr= new JLabel[300];


		game= new Juego(this);
		//getContentPane().add(game.getJugador().obtenerGrafico().getJLabel());
		ladrillo= new JLabel();
		enemigo=new JLabel();
		enemigo1=new JLabel();


		panelGeneral.add(enemigo);
		panelGeneral.add(ladrillo);
		panelGeneral.add(enemigo1);

		game.crearEnemigo();
		game.crearEnemigo();



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
					y = i*40;
					if (linea.charAt(j) == '0'){	

						x=x+40;

					}
					else {
						if (linea.charAt(j) == '1'){
							game.agregarObstaculo(new Ladrillo(x,y,game));

							x=x+40;

						}
						else {
							if (linea.charAt(j) == '2'){
								game.agregarObstaculo(new Agua(x,y,game));


								x=x+40;

							}
							else {
								if (linea.charAt(j) == '3'){

									game.agregarObstaculo(new Acero(x,y,game));

									x=x+40;

								}
								else {
									if (linea.charAt(j) == '4'){
										game.agregarObstaculo(new Aguila(x,y,game));

										x=x+40;

									}
									else {
										if (linea.charAt(j) == '5'){
											game.agregarObstaculo(new Selva(x,y,game));

											x=x+40;

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
		case KeyEvent.VK_UP:{
			//tanque.setIcon(new ImageIcon(GUI.class.getResource("/Graficos/tjugadorUP.png")));
			game.mover(game.getJugador(),3);

			//tanque.setBounds(game.getJugador().obtenerX(), game.getJugador().obtenerY(), 40, 40);//k.moverArriba();// handle up 
			break;}
		case KeyEvent.VK_DOWN:{
			//tanque.setIcon(new ImageIcon(GUI.class.getResource("/Graficos/tjugadorDOWN.png")));
			game.mover(game.getJugador(),2);
			//tanque.setBounds(game.getJugador().obtenerX(),game.getJugador().obtenerY(), 40, 40);
			//k.moverAbajo();// handle down
			break;}
		case KeyEvent.VK_LEFT:{
			//tanque.setIcon(new ImageIcon(GUI.class.getResource("/Graficos/tjugadorLEFT.png")));
			game.mover(game.getJugador(),0);
			//tanque.setBounds(game.getJugador().obtenerX(), game.getJugador().obtenerY(), 40, 40);
			//k.moverIzq();// handle left
			break;}
		case KeyEvent.VK_RIGHT:
		{
			//tanque.setIcon(new ImageIcon(GUI.class.getResource("/Graficos/tjugadorRIGHT.png")));
			if(game.mover(game.getJugador(),1)){}
			//tanque.setBounds(game.getJugador().obtenerX(), game.getJugador().obtenerY(), 40, 40);
			//k.moverDer();// handle right
			break;
		}   
		case KeyEvent.VK_F:
		{
			
		    
		    game.getJugador().disparar();
			
		}   

		}
		System.out.println("keyTyped");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void añadirAPanel(JLabel j){
		panelGeneral.add(j);
	}
	
	public JPanel getPanelGeneral(){return panelGeneral;}
}