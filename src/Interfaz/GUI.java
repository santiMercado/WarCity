package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;


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

public class GUI extends JFrame {

	/**
	 * Launch the application.
	 */
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
		setBounds(100, 100, 800, 600);
		JPanel panelGeneral = new JPanel();
		panelGeneral.setBounds(100, 100, 800, 600);
		panelGeneral.setBackground(new Color(0,0,0));
		getContentPane().add(panelGeneral);
		panelGeneral.setLayout(null);
		JLabel[] arr= new JLabel[300];
		
	    BufferedReader lector = null;
	//	JLabel lblNewLabel = new JLabel("");
		
		
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
		    					arr[j+(i*20)]=new JLabel("");
		    					arr[j+(i*20)].setBounds(x, y, 40, 40);
		    					x=x+40;
		    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/vacio.png")));
		    					panelGeneral.add(arr[j+(i*20)]);
		    					arr[j+(i*20)].setVisible(true);
		    				}
		    				else {
		    					if (linea.charAt(j) == '1'){
			    					arr[j+(i*20)]=new JLabel("");
			    					arr[j+(i*20)].setBounds(x, y, 40, 40);
			    					x=x+40;
			    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/ladrillo.png")));
			    					panelGeneral.add(arr[j+(i*20)]);
			    					arr[i].setVisible(true);
		    					}
		    					else {
		    						if (linea.charAt(j) == '2'){
				    					arr[j+(i*20)]=new JLabel("");
				    					arr[j+(i*20)].setBounds(x, y, 40, 40);
				    					x=x+40;
				    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/agua.png")));
				    					panelGeneral.add(arr[j+(i*20)]);
				    					arr[j+(i*20)].setVisible(true);
		    						}
		    						else {
		    							if (linea.charAt(j) == '3'){
		    		    					arr[j+(i*20)]=new JLabel("");
		    		    					arr[j+(i*20)].setBounds(x, y, 40, 40);
		    		    					x=x+40;
		    		    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/acero.png")));
		    		    					panelGeneral.add(arr[j+(i*20)]);
		    		    					arr[j+(i*20)].setVisible(true);
		    						    }
		    							else {
		    								if (linea.charAt(j) == '4'){
			    		    					arr[j+(i*20)]=new JLabel("");
			    		    					arr[j+(i*20)].setBounds(x, y, 40, 40);
			    		    					x=x+40;
			    		    					arr[j+(i*20)].setIcon(new ImageIcon(GUI.class.getResource("/Graficos/aguila.png")));
			    		    					panelGeneral.add(arr[j+(i*20)]);
			    		    					arr[j+(i*20)].setVisible(true);
			    						    }
		    								else {
		    									if (linea.charAt(j) == '5'){
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
}


