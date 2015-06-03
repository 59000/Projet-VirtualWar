	package Menu;
	
	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

import org.omg.CORBA.SystemException;

import Constante.Constante;
import Plateau.Cellule;
import Plateau.Coordonnees;
import Plateau.Plateau;
import Robot.Piegeur;
import Robot.Tireur;
	
	@SuppressWarnings("serial")
	public class TestGraphic extends JWindow {
	
		// | Attributs : |
		/** Le plateau de jeu */
		Plateau p;
		/** Le plateau qui s'affichent a  l'ecran */
		JLabel[][] cellule;
	
		// | Constructeurs : |
		/**
		 * Constructeurs du menu
		 */
		public TestGraphic() {
			Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			int hauteur = (int)(tailleEcran.getHeight());
			int largeur = (int)(tailleEcran.getWidth()*0.70);
			// Pourcentage d'obstacles
			Cellule.pourcentage = ConfigPlateau.slider1.getValue();
			// Cree le plateau (taille fixe pour test)
			p = new Plateau(ConfigPlateau.slider.getValue(), ConfigPlateau.slider.getValue());
			// Cree le plateau affichable en fonction du plateau de jeu
			cellule = new JLabel[p.plateau.length][p.plateau[0].length];
	
			// Place les bases
			p.plateau[0][0].base = Constante.BASE1;
			p.plateau[p.plateau.length - 1][p.plateau[0].length - 1].base = Constante.BASE2;
			// Cree les obstacles
			p.genere_obstacle(p.plateau[0][0]);
			
	
	
			if (MenuGraphic.choix == 1){
				for (int i = 0; i < ConfigEquipePvP.equipe1.length ; i++) {
					ConfigEquipePvP.equipe1[i].setCoord(new Coordonnees(1,1));
					ConfigEquipePvP.equipe2[i].setCoord(new Coordonnees(p.plateau.length - 1,p.plateau[0].length - 1));
					
				}
			}
			
			else if(MenuGraphic.choix ==2){
			    for (int i = 0; i < ConfigEquipePvIA.equipe1.length ; i++) {
					ConfigEquipePvIA.equipe1[i].setCoord(new Coordonnees(0, 0));
					
				}
				
			}
			
			// gestion des borderPanel
			JPanel vieEquipe1 = new JPanel();
			JPanel vieEquipe2 = new JPanel();
			JWindow equipe1 = new JWindow();
			JWindow equipe2 = new JWindow();
			
		
			
			//parametrage de vieEquipe1
			vieEquipe1.setPreferredSize(new Dimension(270,hauteur));
			vieEquipe1.setBackground(Color.RED);
			BorderLayout layoutEquipe1 = new BorderLayout();
			vieEquipe1.setLayout(layoutEquipe1);
			JLabel nomEquipe1 = new JLabel(ConfigEquipePvP.textNomEquipe1.getText(), JLabel.CENTER);
			nomEquipe1.setFont(new Font("Arial", Font.BOLD, 42));
			nomEquipe1.setForeground(Color.white);

			vieEquipe1.add(nomEquipe1, layoutEquipe1.NORTH);
			vieEquipe1.setOpaque(false);
			JLabel[] infoRobotEquipe1 = new JLabel[ConfigEquipePvP.equipe1.length];
			JPanel pancentreEquipe1 = new JPanel();
			pancentreEquipe1.setBackground(Color.green);
			pancentreEquipe1.setLayout(null);
			pancentreEquipe1.setOpaque(false);
			JLabel legende = new JLabel("Robot                   Vie        Mines");
			legende.setFont(new Font("Arial",Font.BOLD,15));
			legende.setForeground(Color.white);
			legende.setBounds(10,124,270,30);
			pancentreEquipe1.add(legende);
			
			
			for (int i = 0; i < ConfigEquipePvP.equipe1.length ; i++) {
			
				if(ConfigEquipePvP.equipe1[i] instanceof Piegeur){
					Piegeur temp = (Piegeur) ConfigEquipePvP.equipe1[i];
					infoRobotEquipe1[i] = new JLabel(temp.toString()+"    "+temp.getEnergie()+"    "+temp.nbMine);
				}
				else{
					infoRobotEquipe1[i] = new JLabel(ConfigEquipePvP.equipe1[i].toString()+"    "+ConfigEquipePvP.equipe1[i].getEnergie());
				}	
				infoRobotEquipe1[i].setFont(new Font("Arial", Font.BOLD, 16));
				infoRobotEquipe1[i].setForeground(Color.white);
				infoRobotEquipe1[i].setBounds(10, (i*60+150),200,30);
				pancentreEquipe1.add(infoRobotEquipe1[i]);
				
			}
			
			JButton quitter = new JButton("Quitter");
			quitter.setBounds((int)(largeur*0.05), (int)(hauteur*0.95), 150, 25);
			quitter.addActionListener(new ActionListener(
					) {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});
			vieEquipe1.add(quitter);
			
			vieEquipe1.add(pancentreEquipe1, layoutEquipe1.CENTER);
			//paramtrage vieEquipe2
			
			vieEquipe2.setOpaque(false);
			vieEquipe2.setPreferredSize(new Dimension(270,hauteur));
			vieEquipe2.setBackground(Color.yellow);
			BorderLayout layoutEquipe2 = new BorderLayout();
			vieEquipe2.setLayout(layoutEquipe2);
			JLabel nomEquipe2 = new JLabel(ConfigEquipePvP.textNomEquipe2.getText(), JLabel.CENTER);
			nomEquipe2.setFont(new Font("Arial", Font.BOLD, 42));
			nomEquipe2.setForeground(Color.white);
			vieEquipe2.add(nomEquipe2,layoutEquipe2.NORTH);
			JLabel[] infoRobotEquipe2 = new JLabel[ConfigEquipePvP.equipe1.length];
			JPanel pancentreEquipe2 = new JPanel();
			pancentreEquipe2.setBackground(Color.ORANGE);
			pancentreEquipe2.setOpaque(false);
			pancentreEquipe2.setLayout(null);
			JLabel legende2 = new JLabel("Robot                   Vie        Mines");
			legende2.setFont(new Font("Arial",Font.BOLD,15));
			legende2.setBounds(10,124,270,30);
			legende2.setForeground(Color.white);
			pancentreEquipe2.add(legende2);
			for (int i = 0; i < ConfigEquipePvP.equipe1.length ; i++) {
				
				if(ConfigEquipePvP.equipe2[i] instanceof Piegeur){
					Piegeur temp = (Piegeur) ConfigEquipePvP.equipe2[i];
					infoRobotEquipe2[i] = new JLabel(temp.toString()+"    "+temp.getEnergie()+"    "+temp.nbMine);
				}
				else{
					infoRobotEquipe2[i] = new JLabel(ConfigEquipePvP.equipe2[i].toString()+"    "+ConfigEquipePvP.equipe2[i].getEnergie());
				}
				
				infoRobotEquipe2[i].setFont(new Font("Arial", Font.BOLD, 16));	
				infoRobotEquipe2[i].setForeground(Color.white);
				infoRobotEquipe2[i].setBounds(10, (i*60+150),200,30);
				pancentreEquipe2.add(infoRobotEquipe2[i]);
				
			}
			
			vieEquipe2.add(pancentreEquipe2, layoutEquipe2.CENTER);
					
			
			equipe1.setContentPane(new PanelFond());	
			equipe1.add(vieEquipe1);
			equipe1.setPreferredSize(new Dimension((int)(tailleEcran.getWidth()*0.15),hauteur));
			equipe1.setLocation(0,0);
			equipe1.pack();
			equipe1.setVisible(true);
			
			
			
			
			equipe2.setContentPane(new PanelFond());
			equipe2.add(vieEquipe2);
			equipe2.setPreferredSize(new Dimension((int)(tailleEcran.getWidth()*0.15),hauteur));
			equipe2.setLocation((int)(tailleEcran.getWidth()*0.85), 0);
			equipe2.pack();
			equipe2.setVisible(true);
					
			this.setPreferredSize(new Dimension(largeur,
					hauteur));
			// Cree la JPanel qui contient le plateau affichable
			JPanel pan = updatePanel(cellule, p.plateau);
	
			/** Jlist de robot sur la base 1 */
			cellule[0][0].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
			
					
					for (int i = 0; i < ConfigEquipePvP.equipe1.length; i++) {
						
						if(ConfigEquipePvP.equipe1[i].getCoord().equals(new Coordonnees(0, 0))){
							
						}
					}
				}
			});
			
			// Parametre pour afficher le plateau
			BorderLayout layout = new BorderLayout();
			this.setLayout(layout);

			
			this.getContentPane().add(pan, layout.CENTER);
			this.setLocation((int)(tailleEcran.getWidth()*0.15), 0);
			//this.setResizable(false);
			//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
			this.setVisible(true);
	
		}
	
		// | Methodes : |
	
		public JPanel updatePanel(JLabel[][] cellule, Cellule[][] plateau) {
			JPanel pan = new JPanel();
			pan.setLayout(new GridLayout(p.plateau.length, p.plateau[0].length));
			pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
			updatePlateau(cellule, plateau);
	
			for (int i = 0; i < cellule.length; i++) {
				for (int j = 0; j < cellule[0].length; j++) {
					pan.add(cellule[i][j]);
				}
			}
	
			return pan;
		}
	
		/**
		 * Met aÂ  jour le plateau affichable aÂ  partir des informations du plateau
		 * de jeu
		 * 
		 * @param cellule
		 *            : le plateau affichable aÂ  mettre aÂ  jour
		 * @param p
		 *            : le plateau de jeu
		 * @return cellule : le plateau affichable mis aÂ  jour
		 */
		public JLabel[][] updatePlateau(JLabel[][] cellule, Cellule[][] plateau) {
			for (int i = 0; i < plateau.length; i++) {
				for (int j = 0; j < plateau[0].length; j++) {
					// La cellule est une base de l'equipe 1
					if (plateau[i][j].estBase() == 1) {
						cellule[i][j] = new JLabel();
						ImageIcon img = new ImageIcon("images/base.png");
						cellule[i][j].setIcon(img);
						cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
						cellule[i][j].setVerticalAlignment(JLabel.CENTER);
						cellule[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					}
					// La cellule est une base de l'equipe 2
					else if (plateau[i][j].estBase() == 2) {
						cellule[i][j] = new JLabel();
						ImageIcon img = new ImageIcon("images/base2.png");
						cellule[i][j].setIcon(img);
						cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
						cellule[i][j].setVerticalAlignment(JLabel.CENTER);
						cellule[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					}
					// La cellule est un obstavle
					else if (plateau[i][j].estObstacle() == true) {
						cellule[i][j] = new JLabel();
						ImageIcon img = new ImageIcon("images/Block.png");
						cellule[i][j].setIcon(img);
						cellule[i][j].setOpaque(true);
						cellule[i][j].setBackground(Color.BLACK);
					}
					// La cellule est une mine de l'equipe 1
					else if (plateau[i][j].contienMine() == 1) {
						cellule[i][j] = new JLabel();
						ImageIcon img = new ImageIcon("images/mine1.png");
						cellule[i][j].setIcon(img);
						cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
						cellule[i][j].setVerticalAlignment(JLabel.CENTER);
						cellule[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					}
					// La cellule est une mine de l'equipe 2
					else if (plateau[i][j].contienMine() == 2) {
						cellule[i][j] = new JLabel();
						ImageIcon img = new ImageIcon("images/mine2.png");
						cellule[i][j].setIcon(img);
						cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
						cellule[i][j].setVerticalAlignment(JLabel.CENTER);
						cellule[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					}
					// La cellule contient un robot
					else if (plateau[i][j].getContenu() != null) {
						// La cellule contient un robot de l'equipe 1
						if (plateau[i][j].getContenu().getEquipe() == 1) {
							// La cellue contient un tireur
							if (plateau[i][j].getContenu() instanceof Tireur) {
								cellule[i][j] = new JLabel("T");
								ImageIcon img = new ImageIcon("images/tireur1.png");
								cellule[i][j].setIcon(img);
								cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
								cellule[i][j].setVerticalAlignment(JLabel.CENTER);
								cellule[i][j].setBorder(BorderFactory
										.createLineBorder(Color.BLACK));
							}
							// La cellule contient un piegeur
							else if (plateau[i][j].getContenu() instanceof Piegeur) {
								cellule[i][j] = new JLabel("P");
								ImageIcon img = new ImageIcon("images/piegeur1.png");
								cellule[i][j].setIcon(img);
								cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
								cellule[i][j].setVerticalAlignment(JLabel.CENTER);
								cellule[i][j].setBorder(BorderFactory
										.createLineBorder(Color.BLACK));
							}
							// La cellule contient un char
							else {
								cellule[i][j] = new JLabel("C");
								ImageIcon img = new ImageIcon("images/char1.png");
								cellule[i][j].setIcon(img);
								cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
								cellule[i][j].setVerticalAlignment(JLabel.CENTER);
								cellule[i][j].setBorder(BorderFactory
										.createLineBorder(Color.BLACK));
							}
						}
						// La cellule contient un robot de l'equipe 2
						else if (plateau[i][j].getContenu().getEquipe() == 2) {
							// La cellue contient un tireur
							if (plateau[i][j].getContenu() instanceof Tireur) {
								cellule[i][j] = new JLabel("t");
								ImageIcon img = new ImageIcon("images/tireur2.png");
								cellule[i][j].setIcon(img);
								cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
								cellule[i][j].setVerticalAlignment(JLabel.CENTER);
								cellule[i][j].setBorder(BorderFactory
										.createLineBorder(Color.BLACK));
							}
							// La cellule contient un piegeur
							else if (plateau[i][j].getContenu() instanceof Piegeur) {
								cellule[i][j] = new JLabel("p");
								ImageIcon img = new ImageIcon("images/piegeur2.png");
								cellule[i][j].setIcon(img);
								cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
								cellule[i][j].setVerticalAlignment(JLabel.CENTER);
								cellule[i][j].setBorder(BorderFactory
										.createLineBorder(Color.BLACK));
							}
							// La cellule contient un char
							else {
								cellule[i][j] = new JLabel("c");
								ImageIcon img = new ImageIcon("images/char2.png");
								cellule[i][j].setIcon(img);
								cellule[i][j].setHorizontalAlignment(JLabel.CENTER);
								cellule[i][j].setVerticalAlignment(JLabel.CENTER);
								cellule[i][j].setBorder(BorderFactory
										.createLineBorder(Color.BLACK));
							}
						}
					}
					// Sinon
					else {
						cellule[i][j] = new JLabel("");
						cellule[i][j].setBorder(BorderFactory
								.createLineBorder(Color.BLACK));
					}
				}
			}
	
			return cellule;
		}
		
	
	
	
	}
