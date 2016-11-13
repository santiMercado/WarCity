package Interfaz;

import Logica.Juego;
import Musica.Musica;
import Musica.VidaExtra;
import Obstaculos.Acero;
import Obstaculos.Agua;
import Obstaculos.Aguila;
import Obstaculos.Casco;
import Obstaculos.Estrella;
import Obstaculos.Granada;
import Obstaculos.Ladrillo;
import Obstaculos.LifeUp;
import Obstaculos.Obstaculo;
import Obstaculos.Pala;
import Obstaculos.Selva;
import Obstaculos.TimerPW;

import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

















import javax.swing.JLayeredPane;









// Lectura de archivos
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GUI extends JFrame implements KeyListener {

	/**
	 * Launch the application.
	 */

	protected JLabel puntaje;
	protected JPanelFondo panelGeneral;
	private Juego game;
	private JLabel aux;
	protected JLabel gover;
	protected Musica music;
	

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
		setBounds(100, 100, 1000, 650);  //820 650
		panelGeneral = new JPanelFondo();
		panelGeneral.setLayout(null);
		panelGeneral.setBounds(100, 100, 1000, 650);   //800 600
		panelGeneral.setIcon(new ImageIcon(GUI.class.getResource("/Graficos/fondodeprueba.jpg")));

		//panelGeneral.setBackground(new Color(0,0,0));
		getContentPane().add(panelGeneral);



		JLabel[] arr= new JLabel[300];

		int cant=0;
		game= new Juego(this);

		
        
		
		JLabel score= new JLabel();
		score.setBounds(830, 0, 400, 100);
		score.setFont(new Font("3dventure", Font.PLAIN, 32)); 
		score.setForeground(Color.white);
		score.setText("SCORE:");
		score.setVisible(true);
		panelGeneral.add(score);


		puntaje= new JLabel();
		puntaje.setBounds(830, 30, 400, 100);
		puntaje.setFont(new Font("3dventure", Font.PLAIN, 32)); 
		puntaje.setForeground(Color.white);
		puntaje.setText(""+game.getPuntaje());
		puntaje.setVisible(true);
		panelGeneral.add(puntaje);

		gover= new JLabel();
		gover.setBounds(810, 110, 400, 100);
		gover.setFont(new Font("3dventure", Font.PLAIN, 32)); 
		gover.setForeground(Color.red);
		gover.setText("GAME OVER");
		gover.setVisible(false);
		panelGeneral.add(gover);

		agregarAPanel(game.getJugador().obtenerGrafico().getJLabel());

		Obstaculo oaux;


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
							oaux=new Ladrillo(x,y,game);
							game.agregarObstaculo(oaux);
							agregarAPanel(oaux.obtenerGrafico().getJLabel());
							x=x+40;

						}
						else {
							if (linea.charAt(j) == '2'){
								oaux=new Agua(x,y,game);
								game.agregarObstaculo(oaux);
								agregarAPanel(oaux.obtenerGrafico().getJLabel());
								x=x+40;

							}
							else {
								if (linea.charAt(j) == '3'){
									oaux=new Acero(x,y,game);
									game.agregarObstaculo(oaux);
									agregarAPanel(oaux.obtenerGrafico().getJLabel());
									x=x+40;

								}
								else {
									if (linea.charAt(j) == '4'){
										oaux=new Aguila(x,y,game);
										game.agregarObstaculo(oaux);
										agregarAPanel(oaux.obtenerGrafico().getJLabel());
										x=x+40;

									}
									else {
										if (linea.charAt(j) == '5'){
											oaux=new Selva(x,y,game);
											game.agregarObstaculo(oaux);
											agregarAPanel(oaux.obtenerGrafico().getJLabel());
											panelGeneral.setComponentZOrder(oaux.obtenerGrafico().getJLabel(), 1);
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
		
		music = new Musica();

	}



	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		switch( keyCode ) { 
		case KeyEvent.VK_UP:{
		   
			game.mover(game.getJugador(),3);

			break;}
		case KeyEvent.VK_DOWN:{

			
			game.mover(game.getJugador(),2);

			break;}
		case KeyEvent.VK_LEFT:{


			
			game.mover(game.getJugador(),0);

			break;}
		case KeyEvent.VK_RIGHT:{

			
			game.mover(game.getJugador(),1);

			break;
		}


		case KeyEvent.VK_F:
		{


			game.getJugador().disparar();
			break;
		}  
		case KeyEvent.VK_C:
		{

			LifeUp p = new LifeUp(300, 500, game);
			game.agregarPowerUp(p);;
			break;
		}   
		
		case KeyEvent.VK_P:
		{


			game.getJugador().Mejorar();
			game.getJugador().Mejorar();
			game.getJugador().Mejorar();
			
			break;
		}   

		}


	}



	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:

			game.getJugador().obtenerGrafico().setImage(6);
			break;
		case KeyEvent.VK_UP:
			game.getJugador().obtenerGrafico().setImage(7);
			break;
		case KeyEvent.VK_LEFT:
			game.getJugador().obtenerGrafico().setImage(4);

			break;
		case KeyEvent.VK_RIGHT:
			game.getJugador().obtenerGrafico().setImage(5);

		}
	}





	@Override
	public void keyTyped(KeyEvent e) {
	}







	public void agregarAPanel(JLabel j){
		panelGeneral.add(j);
	}

	public void actualizarPuntaje(int i){
		puntaje.setText(""+i);
	}



	public JPanel getPanelGeneral(){return panelGeneral;}

	public void gameover(){
		/*JLabel gover= new JLabel();

		gover.setBounds(830, 110, 100, 100);
	    gover.setFont(new Font("3dventure", Font.PLAIN, 32)); 
		gover.setForeground(Color.red);
		gover.setText("GAME OVER");*/
		gover.setVisible(true);

		//panelGeneral.add(gover);

		repintar();
	}
	
	public Musica getMusic() {
		return music;
	}
	
	public synchronized void repintar(){
		repaint();
	}

	
}