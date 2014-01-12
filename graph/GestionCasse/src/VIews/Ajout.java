package VIews;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ajout extends JPanel {
	
	private LinkedList<JLabel> labels = new  LinkedList<JLabel>();
	private LinkedList<JPanel> panels = new LinkedList<JPanel>();
	private LinkedList<JTextField> fields = new LinkedList<JTextField>();
	private LinkedList<JButton> boutons = new LinkedList<JButton>();
	private JComboBox contruct = new JComboBox();

	

	public Ajout(LayoutManager arg0) {
		super(arg0);
		initAjout();
	}


	public LinkedList<JLabel> getLabels() { return this.labels; }
	public LinkedList<JPanel> getPanels() { return this.panels; }
	public LinkedList<JTextField> getFields() { return this.fields; }
	public LinkedList<JButton> getBoutons() { return this.boutons; }
	public JComboBox getConstruct() { return this.contruct; }
	
	public void addConstruct(String str) {
		this.contruct.addItem(str);
	}
	
	public void initJtext() {
		this.fields.remove();
		for(int i=0; i<3; i++) {
			this.fields.add(new JTextField());
		}
	}
	
	public void initAjout() {
		this.setName("Ajout");
		
		// DŽfinition du titre
		JLabel title = new JLabel("Ajout d'un vŽhicule");
		JPanel panTitle = new JPanel();
		panTitle.add(title);
		this.add(panTitle, BorderLayout.NORTH);
		
		// Ajout de contenu vide sur les cotŽs
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(new JPanel(), BorderLayout.EAST);
		
		// Ajout du contenu central
		JPanel panCenter = new JPanel(new GridLayout(2, 1));
		this.panels.add(new JPanel(new GridLayout(4, 4)));
		this.labels.add(new JLabel("Constructeur"));
		this.labels.add(new JLabel("Immatriculation"));
		this.labels.add(new JLabel("Couleur"));
		this.labels.add(new JLabel("Km"));
		for(int i = 0; i < 3; i++) {
			this.fields.add(new JTextField());
		}
		for(int i = 0; i < 4; i++) {
			this.panels.get(0).add(this.labels.get(i));
			if (i == 0) {
				this.panels.get(0).add(contruct);
			} else {
				this.panels.get(0).add(this.fields.get(i-1));
			}
		}
		panCenter.add(this.panels.get(0));
		this.panels.add(new JPanel());
		this.boutons.add(new JButton("Annuler"));
		this.boutons.add(new JButton("Ajouter"));
		for(JButton bt : this.boutons) {
			this.panels.get(1).add(bt);
		}
		panCenter.add(this.panels.get(1));
		this.add(panCenter, BorderLayout.CENTER);
		
		/// Ajout d'un bouton quitter en bas
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
