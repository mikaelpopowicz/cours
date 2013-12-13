package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

import VIews.Accueil;

import Entities.Vehicule;

public class CasseController implements ActionListener {

	private LinkedList<Vehicule> vehicules = new LinkedList<Vehicule>();
	private LinkedList<JPanel> panels = new LinkedList<JPanel>();
	
	public CasseController() {
		this.panels.add(new Accueil());
		this.panels.get(0).getB
		initAction();
	}

	public LinkedList<Vehicule> getVehicules() { return this.vehicules; }

	public void initAction() {
		
		for(JButton bouton : this.panels.get(0).getBoutons()) {
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
