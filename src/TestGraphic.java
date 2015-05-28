	package Menu;
	
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.GridLayout;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	
	import javax.swing.BorderFactory;
	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JList;
	import javax.swing.JPanel;
	
	import Constante.Constante;
	import Plateau.Cellule;
	import Plateau.Coordonnees;
	import Plateau.Plateau;
	import Robot.Piegeur;
	import Robot.Tireur;
	
	@SuppressWarnings("serial")
	public class TestGraphic extends JFrame {
	
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
					ConfigEquipePvP.equipe1[i].setCoord(new Coordonnees(0, 0));
					ConfigEquipePvP.equipe2[i].setCoord(new Coordonnees(p.plateau.length - 1,p.plateau[0].length - 1));
				}
			}
			
			else if(MenuGraphic.choix ==2){
				for (int i = 0; i < ConfigEquipePvIA.equipe1.length ; i++) {
					ConfigEquipePvIA.equipe1[i].setCoord(new Coordonnees(0, 0));
					
				}
			}
			
	
			
					
					
					
			this.setPreferredSize(new Dimension(p.plateau.length * 52,
					p.plateau[0].length * 52));
			// Cree la JPanel qui contient le plateau affichable
			JPanel pan = updatePanel(cellule, p.plateau);
	
			/** Jlist de robot sur la base 1 */
			cellule[0][0].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					JFrame fen1 = new JFrame();
					fen1.setPreferredSize(new Dimension(200,200));
					fen1.setLayout(new GridLayout(3,3));
					
					JPanel pan1 = new JPanel();
					JPanel pan2 = new JPanel();
					JPanel pan3 = new JPanel();
					JPanel pan4 = new JPanel();
					JPanel pan5 = new JPanel();
					
					for (int i = 0; i < ConfigEquipePvP.equipe1.length; i++) {
						
						if(ConfigEquipePvP.equipe1[i].getCoord().equals(new Coordonnees(0, 0))){
							 
						}
					}
					
					
					
				}
			});
			
			// Parametre pour afficher le plateau
			this.add(pan);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		 * Met a  jour le plateau affichable a  partir des informations du plateau
		 * de jeu
		 * 
		 * @param cellule
		 *            : le plateau affichable a  mettre a  jour
		 * @param p
		 *            : le plateau de jeu
		 * @return cellule : le plateau affichable mis a  jour
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
						ImageIcon img = new ImageIcon("images/block.png");
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
