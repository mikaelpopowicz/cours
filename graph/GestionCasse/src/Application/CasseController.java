package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import VIews.Accueil;
import VIews.Ajout;
import VIews.Bar;
import VIews.Liste;
import VIews.Supprimer;

import Entities.Constructeur;
import Entities.Vehicule;
import Library.BDD;
import Library.ConstructeurManager;
import Library.VehiculeManager;

public class CasseController extends JFrame implements ActionListener {

	private LinkedList<Vehicule> vehicules = new LinkedList<Vehicule>();
	private JPanel container = new JPanel(new BorderLayout());
	private Accueil accueil = new Accueil(new BorderLayout());
	private Ajout ajout = new Ajout(new BorderLayout());
	private Liste liste = new Liste(new BorderLayout());
	private Supprimer suppr = new Supprimer(new BorderLayout());
	private Bar barre = new Bar();
	private BDD maBDD = new BDD("localhost", "casse", "root", "toor");
	private VehiculeManager manV = new VehiculeManager(maBDD);
	private ConstructeurManager manC = new ConstructeurManager(maBDD);
	
	public CasseController() {
		this.setTitle("Gestion de la casse");
		this.setSize((int)getToolkit().getScreenSize().getWidth()/2, ((int)getToolkit().getScreenSize().getHeight()/2));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(this.getContainer());
		this.setJMenuBar(this.getBarre());
		initAction();
	}

	public LinkedList<Vehicule> getVehicules() { return this.vehicules; }
	public JPanel getContainer() { return this.container; }
	public Accueil getAccueil() { return this.accueil; }
	public Ajout getAjout() { return this.ajout; }
	public Bar getBarre() { return this.barre; }

	public void initAction() {
		
		for(JButton bouton : this.accueil.getBoutons()) {
			bouton.addActionListener(this);
		}
		for(JButton bouton : this.ajout.getBoutons()) {
			bouton.addActionListener(this);
		}
		for(JButton bouton : this.suppr.getBoutons()) {
			bouton.addActionListener(this);
		}
		for(JMenuItem item : this.barre.getItems()) {
			item.addActionListener(this);
		}
		this.loadConstruct();
		this.loadMat();
		this.loadVeh();
		this.container.add(accueil);
	}
	
	public void setPanel(JPanel panel) {
		this.container.setVisible(false);
		this.container.removeAll();
		this.container.add(panel);
		this.container.validate();
		this.container.repaint();
		this.container.revalidate();
		this.container.setVisible(true);
	}
	
	public void exit() {
		int retour;
        retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.OK_CANCEL_OPTION);
        if(retour == 0) {
        	this.dispose();
        }
	}
	
	public void loadConstruct() {
		LinkedList<Constructeur> liste = this.manC.getList();
		for(Constructeur cons : liste) {
			this.ajout.addConstruct(cons.getId() + " - " + cons.getNom());
		}
	}
	
	public void loadMat() {
		LinkedList<Vehicule> liste = this.manV.getList();
		for(Vehicule veh : liste) {
			this.suppr.addListe(""+veh.getMatricule());
		}
	}
	
	public void loadVeh() {
		this.vehicules = this.manV.getList();
	}
	
	public void addVehicule(String id, String matricule, String couleur, int km) {
		String id_const[] = id.split(" - ");
		//System.out.println(id_const[0]);
		Vehicule unV = new Vehicule(matricule, couleur, km, Integer.parseInt(id_const[0]));
		//System.out.println(unV.getMatricule()+" "+unV.getCouleur()+" "+unV.getNbKm()+" "+unV.getId_const());
		this.manV.add(unV);
	}
	
	public void delVehicule(String mat) {
		for(Vehicule veh : this.vehicules) {
			if (veh.getMatricule().equals(mat)) {
				this.manV.del(veh);
			}
		}
		this.suppr.delListe();
		this.loadMat();
		this.setPanel(suppr);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.barre.getItems().get(0) || e.getSource() == this.ajout.getBoutons().get(0) || e.getSource() == this.suppr.getBoutons().get(0)) {
			setPanel(this.accueil);
		} else if(e.getSource() == this.barre.getItems().get(1) || e.getSource() == this.accueil.getBoutons().get(4) || e.getSource() == this.ajout.getBoutons().get(2) || e.getSource() == this.suppr.getBoutons().get(2)) {
			this.exit();
		} else if(e.getSource() == this.barre.getItems().get(3) || e.getSource() == this.accueil.getBoutons().get(1)) {
			setPanel(this.ajout);
		} else if(e.getSource() == this.ajout.getBoutons().get(1)) {
			Boolean test = false;
			for(JTextField field : this.ajout.getFields()) {
				if (field.getText().equals("")) {
					field.setBorder(BorderFactory.createLineBorder(Color.RED));
					test = true;
				} else {
					field.setBorder(BorderFactory.createEtchedBorder());
				}
			}
			if (test == false) {
				this.addVehicule(this.ajout.getConstruct().getSelectedItem().toString(), this.ajout.getFields().get(0).getText(), this.ajout.getFields().get(1).getText(), Integer.parseInt(this.ajout.getFields().get(2).getText()));
				this.setPanel(accueil);
			}
		} else if(e.getSource() == this.barre.getItems().get(2) || e.getSource() == this.accueil.getBoutons().get(0)) {
			this.setPanel(this.liste);
		} else if(e.getSource() == this.barre.getItems().get(4) || e.getSource() == this.accueil.getBoutons().get(2)) {
			this.setPanel(suppr);
		} else if(e.getSource() == this.suppr.getBoutons().get(1)) {
			this.delVehicule(this.suppr.getListe().getSelectedItem().toString());
		}
	}
	
	public static void main(String args[]) {
		if(System.getProperty("os.name").contains("Mac")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new CasseController().setVisible(true);
				
			}
		});
		
	}
	
	
}
