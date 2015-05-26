package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constante.Constante;
import Plateau.Cellule;
import Plateau.Plateau;
import Robot.Char;
import Robot.Piegeur;
import Robot.Tireur;

@SuppressWarnings("serial")
public class TestGraphic extends JFrame {

	// | Attributs : |
	/** Le plateau de jeu */
	Plateau p;
	/** Le plateau qui s'affichent ÃƒÂ  l'ÃƒÂ©cran */
	JLabel[][] cellule;

	// | Constructeurs : |
	/**
	 * Constructeurs du menu
	 */
	public TestGraphic() {
		// Pourcentage d'obstacles
		Cellule.pourcentage = 50;
		// CrÃƒÂ©e le plateau (taille fixe pour test)
		p = new Plateau(10, 10);
		// CrÃƒÂ©e le plateau affichable en fonction du plateau de jeu
		cellule = new JLabel[p.plateau.length][p.plateau[0].length];

		// Place les bases
		p.plateau[0][0].base = Constante.BASE1;
		p.plateau[p.plateau.length - 1][p.plateau[0].length - 1].base = Constante.BASE2;
		// CrÃƒÂ©e les obstacles
		p.genere_obstacle(p.plateau[0][0]);
		
	/*	p.plateau[2][2].deplaceSur(new Tireur(1, 0));
		p.plateau[2][3].deplaceSur(new Tireur(2, 0));
		p.plateau[2][4].deplaceSur(new Piegeur(1, 0));
		p.plateau[2][5].deplaceSur(new Piegeur(2, 0));
		p.plateau[2][6].deplaceSur(new Char(1, 0));
		p.plateau[2][7].deplaceSur(new Char(2, 0));
		
		p.plateau[5][5].setMine(1);
		p.plateau[5][6].setMine(2);*/

		// ParamÃƒÂ©tre la JFrame en une taille assez grande pour afficher le
		// plateau
		this.setPreferredSize(new Dimension(p.plateau.length * 52,
				p.plateau[0].length * 52));
		// CrÃƒÂ©e la JPanel qui contient le plateau affichable
		JPanel pan = updatePanel(cellule, p.plateau);

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
	 * Met ÃƒÂ  jour le plateau affichable ÃƒÂ  partir des informations du plateau
	 * de jeu
	 * 
	 * @param cellule
	 *            : le plateau affichable ÃƒÂ  mettre ÃƒÂ  jour
	 * @param p
	 *            : le plateau de jeu
	 * @return cellule : le plateau affichable mis ÃƒÂ  jour
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
					// La cellule contient un robot de l'ÃƒÂ©quipe 1
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
					// La cellule contient un robot de l'ÃƒÂ©quipe 2
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestGraphic();
	}

}
