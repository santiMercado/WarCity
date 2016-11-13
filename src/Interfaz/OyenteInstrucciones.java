package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OyenteInstrucciones implements ActionListener {

	protected MenuPrincipal men;
	
	public OyenteInstrucciones(MenuPrincipal m) {
		men = m;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		men.getEtiInstru().setVisible(true);	
	}

}
