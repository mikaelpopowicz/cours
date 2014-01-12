package VIews;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Liste extends JPanel {
	
	

	public Liste(LayoutManager layout) {
		super(layout);
		initListe();
	}
	
	
	public void initListe() {
		this.setName("Liste");
		
		// Définition du titre
		JLabel title = new JLabel("Liste des véhicules");
		JPanel panTitle = new JPanel();
		panTitle.add(title);
		this.add(panTitle, BorderLayout.NORTH);
				
		// Ajout de contenu vide sur les cotés
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(new JPanel(), BorderLayout.EAST);
	}

}
