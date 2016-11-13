package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class OyenteInicio implements ActionListener{
	
	protected MenuPrincipal men;
	
	public OyenteInicio(MenuPrincipal m) {
		men = m;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		men.getBotIni().setVisible(false);
		men.remove(men.getBotIni());
		GUI juego = new GUI();
		men.dispose();
		juego.setVisible(true);
		
	}
	
	
}
