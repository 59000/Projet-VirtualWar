package Menu;

import ia.Aleatoire;
import ia.IA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

import Constante.Constante;
import Plateau.Cellule;
import Plateau.Coordonnees;
import Plateau.Plateau;
import Robot.Char;
import Robot.Piegeur;
import Robot.Robot;
import Robot.Tireur;
import Constante.gameState;

@SuppressWarnings("serial")
public class TestGraphic extends JWindow {

	// | Attributs : |
	/** Le plateau de jeu */
	Plateau p;
	/** Le plateau qui s'affichent aÂ  l'ecran */
	JLabel[][] cellule;
	Robot[] equipe1;
	Robot[] equipe2;

	// | Constructeurs : |
	/**
	 * Constructeurs du menu
	 */
	public TestGraphic() {
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		int hauteur = (int) (tailleEcran.getHeight());
		int largeur = (int) (tailleEcran.getWidth() * 0.70);
		// Pourcentage d'obstacles
		Cellule.pourcentage = ConfigPlateau.slider1.getValue();
		// Cree le plateau (taille fixe pour test)
		p = new Plateau(ConfigPlateau.slider.getValue(),
				ConfigPlateau.slider.getValue());
		// Cree le plateau affichable en fonction du plateau de jeu
		cellule = new JLabel[p.plateau.length][p.plateau[0].length];

		// Place les bases
		p.plateau[0][0].base = Constante.BASE1;
		p.plateau[p.plateau.length - 1][p.plateau[0].length - 1].base = Constante.BASE2;
		// Cree les obstacles
		p.genere_obstacle(p.plateau[0][0]);

		if (MenuGraphic.choix == 1) {
			for (int i = 0; i < ConfigEquipePvP.equipe1.length; i++) {
				ConfigEquipePvP.equipe1[i].setCoord(new Coordonnees(1, 1));
				ConfigEquipePvP.equipe2[i].setCoord(new Coordonnees(
						p.plateau.length - 1, p.plateau[0].length - 1));

			}
		}

		else if (MenuGraphic.choix == 2) {
			for (int i = 0; i < ConfigEquipePvIA.equipe1.length; i++) {
				ConfigEquipePvIA.equipe1[i].setCoord(new Coordonnees(0, 0));
				ConfigEquipePvIA.equipe2[i].setCoord(new Coordonnees(
						p.plateau.length - 1, p.plateau[0].length - 1));
			}

		} else {
			Random rdm = new Random();
			IA ia1 = new Aleatoire(0);
			IA ia2 = new Aleatoire(1);
			int nombre = 1 + rdm.nextInt(5);
			equipe1 = ia1.constitution_equipes(nombre);
			equipe2 = ia2.constitution_equipes(nombre);
			for (int i = 0; i < equipe1.length; i++) {
				equipe1[i].setCoord(new Coordonnees(0, 0));
				equipe2[i].setCoord(new Coordonnees(p.plateau.length - 1,
						p.plateau[0].length - 1));
			}
		}

		// gestion des borderPanel
		JPanel vieEquipe1 = new JPanel();
		JPanel vieEquipe2 = new JPanel();
		JWindow WindowEquipe1 = new JWindow();
		JWindow WindowEquipe2 = new JWindow();

		// parametrage de vieEquipe1
		vieEquipe1.setPreferredSize(new Dimension(270, hauteur));
		vieEquipe1.setBackground(Color.RED);
		BorderLayout layoutEquipe1 = new BorderLayout();
		vieEquipe1.setLayout(layoutEquipe1);
		JLabel nomEquipe1 = new JLabel();
		if (MenuGraphic.choix == 1) {
			nomEquipe1 = new JLabel(ConfigEquipePvP.textNomEquipe1.getText(),
					JLabel.CENTER);
		} else if (MenuGraphic.choix == 2) {
			nomEquipe1 = new JLabel(ConfigEquipePvIA.textNomEquipe1.getText(),
					JLabel.CENTER);
		} else {
			nomEquipe1 = new JLabel("IA 1", JLabel.CENTER);
		}

		nomEquipe1.setFont(new Font("Arial", Font.BOLD, 42));
		nomEquipe1.setForeground(Color.white);

		vieEquipe1.add(nomEquipe1, layoutEquipe1.NORTH);
		vieEquipe1.setOpaque(false);
		JLabel[] infoRobotEquipe1 = new JLabel[42]; // la reponse a l'univers
		if (MenuGraphic.choix == 1) {
			infoRobotEquipe1 = new JLabel[ConfigEquipePvP.equipe1.length];
		} else if (MenuGraphic.choix == 2) {
			infoRobotEquipe1 = new JLabel[ConfigEquipePvIA.equipe1.length];
		}

		JPanel pancentreEquipe1 = new JPanel();
		pancentreEquipe1.setBackground(Color.green);
		pancentreEquipe1.setLayout(null);
		pancentreEquipe1.setOpaque(false);
		JLabel legende = new JLabel("Robot         Vie      Mines");
		legende.setFont(new Font("Arial", Font.BOLD, 15));
		legende.setForeground(Color.white);
		legende.setBounds(45, 124, 270, 30);
		pancentreEquipe1.add(legende);

		if (MenuGraphic.choix == 1) {
			for (int i = 0; i < ConfigEquipePvP.equipe1.length; i++) {

				if (ConfigEquipePvP.equipe1[i] instanceof Piegeur) {
					Piegeur temp = (Piegeur) ConfigEquipePvP.equipe1[i];
					infoRobotEquipe1[i] = new JLabel(temp.toString() + "      "
							+ temp.getEnergie() + "        " + temp.nbMine);
				} else {
					infoRobotEquipe1[i] = new JLabel(
							ConfigEquipePvP.equipe1[i].toString() + "       "
									+ ConfigEquipePvP.equipe1[i].getEnergie());
				}
				infoRobotEquipe1[i].setFont(new Font("Arial", Font.BOLD, 16));
				infoRobotEquipe1[i].setForeground(Color.white);
				infoRobotEquipe1[i].setBounds(45, (i * 60 + 150), 200, 30);
				pancentreEquipe1.add(infoRobotEquipe1[i]);

			}
		} else if (MenuGraphic.choix == 2) {
			for (int i = 0; i < ConfigEquipePvIA.equipe1.length; i++) {

				if (ConfigEquipePvIA.equipe1[i] instanceof Piegeur) {
					Piegeur temp = (Piegeur) ConfigEquipePvIA.equipe1[i];
					infoRobotEquipe1[i] = new JLabel(temp.toString() + "      "
							+ temp.getEnergie() + "        " + temp.nbMine);
				} else {
					infoRobotEquipe1[i] = new JLabel(
							ConfigEquipePvIA.equipe1[i].toString() + "       "
									+ ConfigEquipePvIA.equipe1[i].getEnergie());
				}
				infoRobotEquipe1[i].setFont(new Font("Arial", Font.BOLD, 16));
				infoRobotEquipe1[i].setForeground(Color.white);
				infoRobotEquipe1[i].setBounds(45, (i * 60 + 150), 200, 30);
				pancentreEquipe1.add(infoRobotEquipe1[i]);
			}
		} else {
			for (int i = 0; i < equipe1.length; i++) {

				if (equipe1[i] instanceof Piegeur) {
					Piegeur temp = (Piegeur) equipe1[i];
					infoRobotEquipe1[i] = new JLabel(temp.toString() + "      "
							+ temp.getEnergie() + "        " + temp.nbMine);
				} else {
					infoRobotEquipe1[i] = new JLabel(equipe1[i].toString()
							+ "       " + equipe1[i].getEnergie());
				}
				infoRobotEquipe1[i].setFont(new Font("Arial", Font.BOLD, 16));
				infoRobotEquipe1[i].setForeground(Color.white);
				infoRobotEquipe1[i].setBounds(45, (i * 60 + 150), 200, 30);
				pancentreEquipe1.add(infoRobotEquipe1[i]);
			}
		}

		JButton quitter = new JButton("Quitter");
		quitter.setBounds((int) (largeur * 0.05), (int) (hauteur * 0.95), 150,
				25);
		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		vieEquipe1.add(quitter);

		vieEquipe1.add(pancentreEquipe1, layoutEquipe1.CENTER);
		// paramtrage vieEquipe2

		vieEquipe2.setOpaque(false);
		vieEquipe2.setPreferredSize(new Dimension(270, hauteur));
		vieEquipe2.setBackground(Color.yellow);
		BorderLayout layoutEquipe2 = new BorderLayout();
		vieEquipe2.setLayout(layoutEquipe2);
		JLabel nomEquipe2 = new JLabel();
		if (MenuGraphic.choix == 1) {
			nomEquipe2 = new JLabel(ConfigEquipePvP.textNomEquipe2.getText(),
					JLabel.CENTER);
		} else if (MenuGraphic.choix == 2) {
			nomEquipe2 = new JLabel("Ia", JLabel.CENTER);
		} else {
			nomEquipe2 = new JLabel("Ia 2", JLabel.CENTER);
		}

		nomEquipe2.setFont(new Font("Arial", Font.BOLD, 42));
		nomEquipe2.setForeground(Color.white);
		vieEquipe2.add(nomEquipe2, layoutEquipe2.NORTH);
		JLabel[] infoRobotEquipe2 = new JLabel[42];
		if (MenuGraphic.choix == 1) {
			infoRobotEquipe2 = new JLabel[ConfigEquipePvP.equipe1.length];
		} else if (MenuGraphic.choix == 2) {
			infoRobotEquipe2 = new JLabel[ConfigEquipePvIA.equipe1.length];
		} else {
			// rien
		}

		JPanel pancentreEquipe2 = new JPanel();
		pancentreEquipe2.setBackground(Color.ORANGE);
		pancentreEquipe2.setOpaque(false);
		pancentreEquipe2.setLayout(null);
		JLabel legende2 = new JLabel("Robot          Vie      Mines");
		legende2.setFont(new Font("Arial", Font.BOLD, 15));
		legende2.setBounds(45, 124, 270, 30);
		legende2.setForeground(Color.white);
		pancentreEquipe2.add(legende2);
		if (MenuGraphic.choix == 1) {
			for (int i = 0; i < ConfigEquipePvP.equipe1.length; i++) {

				if (ConfigEquipePvP.equipe2[i] instanceof Piegeur) {
					Piegeur temp = (Piegeur) ConfigEquipePvP.equipe2[i];
					infoRobotEquipe2[i] = new JLabel(temp.toString() + "      "
							+ temp.getEnergie() + "        " + temp.nbMine);
				} else {
					infoRobotEquipe2[i] = new JLabel(
							ConfigEquipePvP.equipe2[i].toString() + "       "
									+ ConfigEquipePvP.equipe2[i].getEnergie());
				}

				infoRobotEquipe2[i].setFont(new Font("Arial", Font.BOLD, 16));
				infoRobotEquipe2[i].setForeground(Color.white);
				infoRobotEquipe2[i].setBounds(45, (i * 60 + 150), 200, 30);
				pancentreEquipe2.add(infoRobotEquipe2[i]);

			}
		} else if (MenuGraphic.choix == 2) {
			for (int i = 0; i < ConfigEquipePvIA.equipe1.length; i++) {

				if (ConfigEquipePvIA.equipe2[i] instanceof Piegeur) {
					Piegeur temp = (Piegeur) ConfigEquipePvIA.equipe2[i];
					infoRobotEquipe2[i] = new JLabel(temp.toString() + "      "
							+ temp.getEnergie() + "        " + temp.nbMine);
				} else {
					infoRobotEquipe2[i] = new JLabel(
							ConfigEquipePvIA.equipe2[i].toString() + "       "
									+ ConfigEquipePvIA.equipe2[i].getEnergie());
				}

				infoRobotEquipe2[i].setFont(new Font("Arial", Font.BOLD, 16));
				infoRobotEquipe2[i].setForeground(Color.white);
				infoRobotEquipe2[i].setBounds(45, (i * 60 + 150), 200, 30);
				pancentreEquipe2.add(infoRobotEquipe2[i]);

			}
		} else {
			for (int i = 0; i < equipe1.length; i++) {

				if (equipe2[i] instanceof Piegeur) {
					Piegeur temp = (Piegeur) equipe2[i];
					infoRobotEquipe2[i] = new JLabel(temp.toString() + "      "
							+ temp.getEnergie() + "        " + temp.nbMine);
				} else {
					infoRobotEquipe2[i] = new JLabel(equipe2[i].toString()
							+ "       " + equipe2[i].getEnergie());
				}

				infoRobotEquipe2[i].setFont(new Font("Arial", Font.BOLD, 16));
				infoRobotEquipe2[i].setForeground(Color.white);
				infoRobotEquipe2[i].setBounds(45, (i * 60 + 150), 200, 30);
				pancentreEquipe2.add(infoRobotEquipe2[i]);
			}
		}

		vieEquipe2.add(pancentreEquipe2, layoutEquipe2.CENTER);

		WindowEquipe1.setContentPane(new PanelFond());
		WindowEquipe1.add(vieEquipe1);
		WindowEquipe1.setPreferredSize(new Dimension((int) (tailleEcran
				.getWidth() * 0.15), hauteur));
		WindowEquipe1.setLocation(0, 0);
		WindowEquipe1.pack();
		WindowEquipe1.setVisible(true);

		WindowEquipe2.setContentPane(new PanelFond());
		WindowEquipe2.add(vieEquipe2);
		WindowEquipe2.setPreferredSize(new Dimension((int) (tailleEcran
				.getWidth() * 0.15), hauteur));
		WindowEquipe2.setLocation((int) (tailleEcran.getWidth() * 0.85), 0);
		WindowEquipe2.pack();
		WindowEquipe2.setVisible(true);

		this.setPreferredSize(new Dimension(largeur, hauteur));
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

					if (ConfigEquipePvP.equipe1[i].getCoord().equals(
							new Coordonnees(0, 0))) {

					}
				}
			}
		});

		gameState.equipe1 = equipe1;
		gameState.equipe2 = equipe2;

		// Parametre pour afficher le plateau
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		this.getContentPane().add(pan, layout.CENTER);
		this.setLocation((int) (tailleEcran.getWidth() * 0.15), 0);
		// this.setResizable(false);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
		p.plateau[2][2].deplaceSur(new Char(0, 1));
		
		gameLoop();

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

	public void gameLoop() {
		while (gameState.gameRunning) {
			if (!verifyEquipeAlive(equipe1)) {
				gameState.gameRunning = false;
				JOptionPane.showMessageDialog(null, "L'�quipe  a gagn�e !");
			} else if (!verifyEquipeAlive(equipe2)) {
				gameState.gameRunning = false;
				JOptionPane.showMessageDialog(null, "L'�quipe  a gagn�e !");
			} else if (gameState.finTour) {
				if (gameState.currentEquipe.equals(equipe1)) {
					gameState.currentEquipe = equipe2;
				} else {
					gameState.currentEquipe = equipe1;
				}
			}
			updatePlateau(cellule, p.plateau);
		}
	}

	public boolean verifyEquipeAlive(Robot[] equipe) {
		for (int i = 0; i < equipe.length; i++) {
			if (equipe[i] != null) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Met aÃ‚Â  jour le plateau affichable aÃ‚Â  partir des
	 * informations du plateau de jeu
	 * 
	 * @param cellule
	 *            : le plateau affichable aÃ‚Â  mettre aÃ‚Â  jour
	 * @param p
	 *            : le plateau de jeu
	 * @return cellule : le plateau affichable mis aÃ‚Â  jour
	 */
	public JLabel[][] updatePlateau(JLabel[][] cellule, Cellule[][] plateau) {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				// La cellule est une base de l'equipe 1
				if (plateau[i][j].estBase() == 1) {
					cellule[i][j] = new ClickableLabel("images/base.png", p, i,
							j);
				}
				// La cellule est une base de l'equipe 2
				else if (plateau[i][j].estBase() == 2) {
					cellule[i][j] = new ClickableLabel("images/base2.png", p,
							i, j);
				}
				// La cellule est un obstavle
				else if (plateau[i][j].estObstacle() == true) {
					cellule[i][j] = new ClickableLabel("images/Block.png", p,
							i, j);
				}
				// La cellule est une mine de l'equipe 1
				else if (plateau[i][j].contienMine() == 1) {
					cellule[i][j] = new ClickableLabel("images/mine1.png", p,
							i, j);
				}
				// La cellule est une mine de l'equipe 2
				else if (plateau[i][j].contienMine() == 2) {
					cellule[i][j] = new ClickableLabel("images/mine2.png", p,
							i, j);
				}
				// La cellule contient un robot
				else if (plateau[i][j].getContenu() != null) {
					// La cellule contient un robot de l'equipe 1
					if (plateau[i][j].getContenu().getEquipe() == 1) {
						// La cellue contient un tireur
						if (plateau[i][j].getContenu() instanceof Tireur) {
							cellule[i][j] = new ClickableLabel(
									"images/tireur1.png", p, i, j);
						}
						// La cellule contient un piegeur
						else if (plateau[i][j].getContenu() instanceof Piegeur) {
							cellule[i][j] = new ClickableLabel(
									"images/piegeur1.png", p, i, j);
						}
						// La cellule contient un char
						else {
							cellule[i][j] = new ClickableLabel(
									"images/char1.png", p, i, j);
						}
					}
					// La cellule contient un robot de l'equipe 2
					else if (plateau[i][j].getContenu().getEquipe() == 2) {
						// La cellue contient un tireur
						if (plateau[i][j].getContenu() instanceof Tireur) {
							cellule[i][j] = new ClickableLabel(
									"images/tireur2.png", p, i, j);
						}
						// La cellule contient un piegeur
						else if (plateau[i][j].getContenu() instanceof Piegeur) {
							cellule[i][j] = new ClickableLabel(
									"images/piegeur2.png", p, i, j);
						}
						// La cellule contient un char
						else {
							cellule[i][j] = new ClickableLabel(
									"images/char2.png", p, i, j);
						}
					}
				}
				// Sinon
				else {
					cellule[i][j] = new ClickableLabel(null, p, i, j);
				}
			}
		}

		return cellule;
	}

}
