package Interfaz;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GraphicsEnvironment;



public class MenuPrincipal extends JFrame{
	
	protected JButton inicio; 
	protected JButton instruccionesB;
	protected JFrame juego;
	protected JPanelFondo panel;
	protected JLabel instrucciones;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MenuPrincipal()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		
		instrucciones = new JLabel("Flechas: moverse, F: Disparar");
		//instrucciones.setText("Flechas: moverse, F: Disparar");
		instrucciones.setBounds(0, 0, 300, 50);
		instrucciones.setFont(new Font("Flechas: moverse, F: Disparar", Font.PLAIN, 20));
		instrucciones.setVisible(false);
		
		panel = new JPanelFondo();
		panel.setLayout(null);
		panel.setBounds(100, 100, 1000, 650);   //800 600
		panel.setIcon(new ImageIcon(GUI.class.getResource("/Graficos/fondodeprueba.jpg")));
		
		OyenteInicio iniciar = new OyenteInicio(this);
		inicio = new JButton("Iniciar juego");
		inicio.setBounds(450, 270, 150, 30);
		inicio.addActionListener(iniciar);
		
		OyenteInstrucciones instru = new OyenteInstrucciones(this);
		instruccionesB = new JButton("Instrucciones");
		instruccionesB.setBounds(450, 370, 150, 30);
		instruccionesB.addActionListener(instru);
		
		panel.add(instruccionesB);
		panel.add(inicio);
		panel.add(instrucciones);
		getContentPane().add(panel);
		
	}
	
	public JButton getBotIni() {
		return inicio;
	}
	
	public JLabel getEtiInstru() {
		return instrucciones;
	}
}
