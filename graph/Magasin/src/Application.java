import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Menus.MyMenu;
import Panels.Configuration;
import Panels.DashBoard;


public class Application extends JFrame implements ActionListener, KeyListener {

	private Magasin magasin = new Magasin();
	private MyMenu menubar = new MyMenu();
	private JPanel container = new JPanel(new BorderLayout());
	private JPanel header = new JPanel(new BorderLayout());
	private JPanel content = new JPanel(new FlowLayout());
	private String info = "";
	private Configuration config = new Configuration();
	private DashBoard tbd = new DashBoard();
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}
	
	public void setInfo(String info) {
		this.info = "";
		this.info = info;
	}
	
	public Magasin getMagasin() { return this.magasin; }
	public String getInfo() { return this.info; }
	
	

	public Application() {
		configurer(0);
		initMenu();
		initHeader();
		initFrame();
		this.setJMenuBar(menubar);
		this.setContentPane(container);
	}
	
	public void configurer(int choix) {
		if(this.magasin.getConfigured()) {
			this.container.removeAll();
			this.setInfo("Configuration");
			this.initHeader();
			this.content.removeAll();
			this.config.setTitle("Configuration du magasin");
			this.content.add(config);
			this.content.repaint();
			this.content.revalidate();
			this.container.add(content);
			this.container.repaint();
			this.container.revalidate();
			
			this.container.add(new JLabel("Ca ne marche pas !"), BorderLayout.CENTER);
		} else {
			this.config.setTitle("Bienvenue dans l'application de gestion, veuillez effectuer la configuration initiale");
			this.content.add(config);
			this.setInfo("Première configuration");
			this.config.getValidate().addActionListener(this);
		}
		if(choix == 1) {
			this.magasin.setName(this.config.getNom().getText());
			this.magasin.setAdresse(this.config.getAdresse().getText());
			this.magasin.setVille(this.config.getVille().getText());
			this.magasin.setCp(this.config.getCp().getText());
			this.magasin.setTel(this.config.getTel().getText());
			this.magasin.setConfigured(true);
			this.toDashBoard();
		}
	}
	
	public void initFrame() {
		this.container.add(content, BorderLayout.CENTER);
		this.setSize((int)getToolkit().getScreenSize().getWidth()/10*7, ((int)getToolkit().getScreenSize().getHeight()/10*7));
		this.setResizable(false);
		this.setTitle(this.config.getNom().getText());
		this.setLocationRelativeTo(null);	
	}
	
	public void initMenu() {
		for(JMenuItem item : this.menubar.getItems()) {
			item.addActionListener(this);
		}
	}
	
	public void initHeader() {
		this.header.removeAll();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		String laDateDuJour = sdf.format(new java.util.Date());
		JLabel heure = new JLabel("Nous sommes le "+laDateDuJour+"\t ");
		this.header.add(new JLabel(" "+this.getInfo()), BorderLayout.WEST);
		this.header.add(heure, BorderLayout.EAST);
		this.header.repaint();
		this.header.revalidate();
		this.container.add(header, BorderLayout.NORTH);
	}
	
	public void quitter() {
		int retour;
        retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.OK_CANCEL_OPTION);
        if(retour == 0) {
        	this.dispose();
        }
	}
	
	public void toDashBoard() {
		this.container.removeAll();
		this.setInfo("Tableau de bord");
		initHeader();
		this.content.removeAll();
		this.content.add(this.tbd);
		this.content.repaint();
		this.content.revalidate();
		this.container.add(content);
		this.container.repaint();
		this.container.revalidate();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.menubar.getItems().get(0)) {
			this.toDashBoard();
		} else if(ae.getSource() == this.menubar.getItems().get(1)) {
			//
		} else if(ae.getSource() == this.menubar.getItems().get(2)) {
			this.quitter();
		} else if(ae.getSource() == this.menubar.getItems().get(7)) {
			this.configurer(0);
		} else if(ae.getSource() == this.menubar.getItems().get(8)) {
			JOptionPane.showMessageDialog(this, "Gestion de magasin\nVersion 1.0\nDéveloppée par Popowicz Mikaël", "A propos", JOptionPane.INFORMATION_MESSAGE);
		} else if(ae.getSource() == this.config.getValidate()) {
			this.configurer(1);
		}
		
	}
	
	
	public static void main(String args[]) {
		if(System.getProperty("os.name").contains("Mac")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Application().setVisible(true);
				
			}
		});
	}
}
