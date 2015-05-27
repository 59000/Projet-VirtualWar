package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Robot.*;

public class ConfigEquipePvP {

	public ConfigEquipePvP() {
		JFrame fen = new JFrame();
		fen.setPreferredSize(new Dimension(700, 500));
		Dimension ecran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur_ecran = (int) ecran.getHeight();
		int largeur_ecran = (int) ecran.getWidth();
		fen.setLocation((int) (largeur_ecran * 0.20),
				(int) (hauteur_ecran * 0.30));

		fen.setResizable(false);
		fen.setLayout(new GridBagLayout());
		fen.setContentPane(new PanelFond());

		/** panneau principal */
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.setPreferredSize(new Dimension(700, 500));
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setOpaque(false);
		/** panneau gauche */
		JPanel panGauche = new JPanel();
		panGauche.setLayout(new GridLayout(7, 1));
		panGauche.setPreferredSize(new Dimension(350, 500));
		panGauche.setBackground(new Color(0, 0, 0, 0));
		panGauche.setOpaque(false);

		/** titre set nom equipe 1 */
		JPanel equipeGauche = new JPanel();
		equipeGauche.setLayout(new BorderLayout());
		equipeGauche.setPreferredSize(new Dimension(200, 50));
		equipeGauche.setBackground(Color.BLUE);

		JLabel labelTitreGauche = new JLabel("Equipe 1 :", JLabel.CENTER);
		labelTitreGauche.setForeground(Color.LIGHT_GRAY);

		/** textfield equipe 1 */

		final JTextField textNomEquipe1 = new JTextField(
				"Equipe 1 : Entrez un nom ");
		textNomEquipe1.setFont(new Font("arial", Font.PLAIN, 18));
		textNomEquipe1.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textNomEquipe1.setText("");
			}
		});

		textNomEquipe1.setPreferredSize(new Dimension(50, 5));
		textNomEquipe1.setHorizontalAlignment(JTextField.CENTER);
		textNomEquipe1.setVisible(true);

		/** Combobox equipe gauche */

		JComboBox<Robot> gaucheR0 = new JComboBox<Robot>();

		((JLabel) gaucheR0.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR0.addItem(null);
		gaucheR0.addItem(new Tireur(0, 0));
		gaucheR0.addItem(new Piegeur(0, 0));
		gaucheR0.addItem(new Char(0, 0));

		JComboBox<Robot> gaucheR1 = new JComboBox<Robot>();

		((JLabel) gaucheR1.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR1.addItem(null);
		gaucheR1.addItem(new Tireur(0, 1));
		gaucheR1.addItem(new Piegeur(0, 1));
		gaucheR1.addItem(new Char(0, 1));

		JComboBox<Robot> gaucheR2 = new JComboBox<Robot>();

		((JLabel) gaucheR2.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR2.addItem(null);
		gaucheR2.addItem(new Tireur(0, 2));
		gaucheR2.addItem(new Piegeur(0, 2));
		gaucheR2.addItem(new Char(0, 2));

		JComboBox<Robot> gaucheR3 = new JComboBox<Robot>();

		((JLabel) gaucheR3.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR3.addItem(null);
		gaucheR3.addItem(new Tireur(0, 3));
		gaucheR3.addItem(new Piegeur(0, 3));
		gaucheR3.addItem(new Char(0, 3));

		JComboBox<Robot> gaucheR4 = new JComboBox<Robot>();

		((JLabel) gaucheR4.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR4.addItem(null);
		gaucheR4.addItem(new Tireur(0, 4));
		gaucheR4.addItem(new Piegeur(0, 4));
		gaucheR4.addItem(new Char(0, 4));

		equipeGauche.add(textNomEquipe1);
		panGauche.add(equipeGauche, BorderLayout.NORTH);
		equipeGauche.add(labelTitreGauche, BorderLayout.NORTH);
		panGauche.add(gaucheR0);
		panGauche.add(gaucheR1);
		panGauche.add(gaucheR2);
		panGauche.add(gaucheR3);
		panGauche.add(gaucheR4);

		/** panneau droite */
		JPanel panDroit = new JPanel();
		panDroit.setLayout(new GridLayout(7, 1));
		panDroit.setPreferredSize(new Dimension(350, 500));
		panDroit.setBackground(new Color(0, 0, 0, 0));
		panDroit.setOpaque(false);
		/** set nom equipe 2 */

		JPanel equipeDroit = new JPanel();
		equipeDroit.setLayout(new BorderLayout());
		equipeDroit.setPreferredSize(new Dimension(200, 50));
		/*
		 * equipeDroit.setBackground(new Color(0,0,0,0));
		 * equipeDroit.setOpaque(false);
		 */
		equipeDroit.setBackground(new Color(255,90,0));
		panDroit.add(equipeDroit, BorderLayout.NORTH);

		JLabel labelTitreDroite = new JLabel("Equipe 2 ", JLabel.CENTER);
		labelTitreDroite.setForeground(Color.LIGHT_GRAY);

		/** titre equipe 2 */

		final JTextField textNomEquipe2 = new JTextField(
				"Equipe 2 : Entrez un nom ");
		textNomEquipe2.setFont(new Font("arial", Font.PLAIN, 18));
		textNomEquipe2.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textNomEquipe2.setText("");
			}
		});

		textNomEquipe2.setPreferredSize(new Dimension(50, 5));
		textNomEquipe2.setHorizontalAlignment(JTextField.CENTER);
		textNomEquipe2.setVisible(true);

		/** Combobox equipe droit */

		JComboBox<Robot> droitR0 = new JComboBox<Robot>();

		((JLabel) droitR0.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR0.addItem(null);
		droitR0.addItem(new Tireur(1, 0));
		droitR0.addItem(new Piegeur(1, 0));
		droitR0.addItem(new Char(1, 0));

		JComboBox<Robot> droitR1 = new JComboBox<Robot>();

		((JLabel) droitR1.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR1.addItem(null);
		droitR1.addItem(new Tireur(1, 1));
		droitR1.addItem(new Piegeur(1, 1));
		droitR1.addItem(new Char(1, 1));

		JComboBox<Robot> droitR2 = new JComboBox<Robot>();

		((JLabel) droitR2.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR2.addItem(null);
		droitR2.addItem(new Tireur(1, 2));
		droitR2.addItem(new Piegeur(1, 2));
		droitR2.addItem(new Char(1, 2));

		JComboBox<Robot> droitR3 = new JComboBox<Robot>();

		((JLabel) droitR3.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR3.addItem(null);
		droitR3.addItem(new Tireur(1, 3));
		droitR3.addItem(new Piegeur(1, 3));
		droitR3.addItem(new Char(1, 3));

		JComboBox<Robot> droitR4 = new JComboBox<Robot>();

		((JLabel) droitR4.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR4.addItem(null);
		droitR4.addItem(new Tireur(1, 4));
		droitR4.addItem(new Piegeur(1, 4));
		droitR4.addItem(new Char(1, 4));

		panDroit.add(equipeDroit, BorderLayout.NORTH);
		equipeDroit.add(textNomEquipe2);
		equipeDroit.add(labelTitreDroite, BorderLayout.NORTH);
		panDroit.add(droitR0);
		panDroit.add(droitR1);
		panDroit.add(droitR2);
		panDroit.add(droitR3);
		panDroit.add(droitR4);

		/** Boutton valider et retour */

		JButton valider = new JButton("Valider");
		valider.setBackground(new Color(0, 0, 0, 0));
		valider.setOpaque(false);
		valider.setForeground(Color.GREEN);
		valider.addMouseListener(new MouseListener() {

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
				/*
				 * Mettre toutes les conditions pour jouer : mettre un nom
				 * dequipe, avoir le meme nombre de robot de chaque cote
				 */
				int cptEquipe1 = 0;
				int cptEquipe2 = 0;

				Robot[][] equipe = new Robot[2][5];
				if (gaucheR0.getSelectedItem() != null) {
					equipe[0][0] = (Robot) gaucheR0.getSelectedItem();
					cptEquipe1++;
				}
				if (gaucheR1.getSelectedItem() != null) {
					equipe[0][1] = (Robot) gaucheR1.getSelectedItem();
					cptEquipe1++;
				}
				if (gaucheR2.getSelectedItem() != null) {
					equipe[0][2] = (Robot) gaucheR2.getSelectedItem();
					cptEquipe1++;
				}
				if (gaucheR3.getSelectedItem() != null) {
					equipe[0][3] = (Robot) gaucheR3.getSelectedItem();
					cptEquipe1++;
				}
				if (gaucheR4.getSelectedItem() != null) {
					equipe[0][4] = (Robot) gaucheR4.getSelectedItem();
					cptEquipe1++;
				}

				if (droitR0.getSelectedItem() != null) {
					equipe[1][0] = (Robot) droitR0.getSelectedItem();
					cptEquipe2++;
				}
				if (droitR1.getSelectedItem() != null) {
					equipe[1][1] = (Robot) droitR1.getSelectedItem();
					cptEquipe2++;
				}
				if (droitR2.getSelectedItem() != null) {
					equipe[1][2] = (Robot) droitR2.getSelectedItem();
					cptEquipe2++;
				}
				if (droitR3.getSelectedItem() != null) {
					equipe[1][3] = (Robot) droitR3.getSelectedItem();
					cptEquipe2++;
				}
				if (droitR4.getSelectedItem() != null) {
					equipe[1][4] = (Robot) droitR4.getSelectedItem();
					cptEquipe2++;
				}

				if (cptEquipe1 == cptEquipe2
						&& !textNomEquipe1.getText().equals(
								"Equipe 1 : Entrez un nom ")
						&& !textNomEquipe1.getText().equals("")
						&& !textNomEquipe2.getText().equals(
								"Equipe 2 : Entrez un nom ")
						&& !textNomEquipe2.getText().equals("")
						&& cptEquipe1 != 0
						&& cptEquipe2 != 0
						&& !textNomEquipe1.getText().equals(
								textNomEquipe2.getText())) {
					fen.dispose();
					new TestGraphic();
				} else {
					JOptionPane.showMessageDialog(null,
							"Nom incorrect et/ou equilibrer les equipes !");

				}

			}
		});

		JButton retour = new JButton("Retour");
		retour.setBackground(new Color(0, 0, 0, 0));
		retour.setOpaque(false);
		retour.setForeground(Color.RED);
		retour.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent arg0) {

				fen.dispose();
				new ConfigPlateau();
			}
		});

		JPanel panCentre = new JPanel();
		panCentre.setLayout(new GridLayout(7, 1));
		panCentre.setBackground(new Color(0, 0, 0, 0));
		panCentre.setOpaque(false);

		JPanel panCentreValider = new JPanel();
		panCentreValider.setLayout(new GridLayout(1, 3));
		panCentreValider.setBackground(new Color(0, 0, 0, 0));
		panCentreValider.setOpaque(false);
		panCentreValider.add(new PanelFond());
		panCentreValider.add(valider);
		panCentreValider.add(new PanelFond());

		JPanel panCentreRetour = new JPanel();
		panCentreRetour.setLayout(new GridLayout(1, 3));
		panCentreRetour.setBackground(new Color(0, 0, 0, 0));
		panCentreRetour.setOpaque(false);
		panCentreRetour.add(new PanelFond());
		panCentreRetour.add(retour);
		panCentreRetour.add(new PanelFond());

		panCentre.add(new PanelFond());
		panCentre.add(new PanelFond());
		panCentre.add(panCentreValider);
		panCentre.add(new PanelFond());
		panCentre.add(panCentreRetour);
		panCentre.add(new PanelFond());
		panCentre.add(new PanelFond());

		panel.add(panGauche);
		panel.add(panCentre);
		panel.add(panDroit);

		fen.getContentPane().add(panel);

		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);

	}

}
