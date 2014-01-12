package Application;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import VIews.Accueil;
import VIews.Bar;


public class GestionCasse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CasseController controller = new CasseController();
	
	
	
	public GestionCasse() {
		this.setTitle("Gestion de la casse");
		this.setSize((int)getToolkit().getScreenSize().getWidth()/2, ((int)getToolkit().getScreenSize().getHeight()/2));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(this.controller.getContainer());
		this.setJMenuBar(this.controller.getBarre());
	}

	
}
