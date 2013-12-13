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
	private Casse maCasse;
	private JPanel container = new JPanel(new BorderLayout());
	private Bar maBarre = new Bar();
	private Accueil accueil = new Accueil(new BorderLayout());
	
	
	
	public GestionCasse() {
		this.setMaCasse(null);
		this.setTitle("Gestion de la casse");
		this.setSize((int)getToolkit().getScreenSize().getWidth()/2, ((int)getToolkit().getScreenSize().getHeight()/2));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.container.add(this.accueil);
		this.setContentPane(container);
		this.setJMenuBar(maBarre);
	}
	
	public GestionCasse(Casse uneCasse) {
		this.setMaCasse(uneCasse);
	}
	
	
	public Casse getMaCasse() { return this.maCasse; }
	
	public void setMaCasse(Casse uneCasse) {
		this.maCasse = uneCasse;
	}

	
	public static void main(String args[]) {
		if(System.getProperty("os.name").contains("Mac")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new GestionCasse().setVisible(true);
				
			}
		});
		
	}
	
}
