package VIews;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Supprimer extends JPanel {
	
	private JComboBox liste = new JComboBox();
	private LinkedList<JButton> boutons =  new LinkedList<JButton>();


	public Supprimer(LayoutManager arg0) {
		super(arg0);
		initSupp();
	}
	
	public JComboBox getListe() { return this.liste; }
	public LinkedList<JButton> getBoutons() { return this.boutons; }
	
	public void delListe() {
		this.liste = new JComboBox();
	}
	
	public void addListe(String str) {
		this.liste.addItem(str);
	}

	public void initSupp() {
		this.setName("Supprimer");
		
		// Définition du titre
		JLabel title = new JLabel("Suppression d'un véhicule");
		JPanel panTitle = new JPanel();
		panTitle.add(title);
		this.add(panTitle, BorderLayout.NORTH);
				
		// Ajout de contenu vide sur les cotés
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(new JPanel(), BorderLayout.EAST);
		
		// Ajout du contenu central
		JPanel panCenter = new JPanel(new GridLayout(2, 1));
		this.boutons.add(new JButton("Annuler"));
		this.boutons.add(new JButton("Supprimer"));
		panCenter.add(this.liste);
		JPanel panBT = new JPanel();
		for(JButton bt : this.boutons) {
			panBT.add(bt);
		}
		panCenter.add(panBT);
		this.add(panCenter, BorderLayout.CENTER);
		
		// Ajout d'un bouton quitter en bas
		this.boutons.add(new JButton("Quitter"));
		JPanel panFoo = new JPanel();
		for(JButton button : this.boutons) {
			if(button.getText().equals("Quitter")) {
				panFoo.add(button);
			}
		}
		this.add(panFoo, BorderLayout.SOUTH);
	}

}
