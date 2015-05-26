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

		JComboBox<String> gaucheR0 = new JComboBox<String>();

		((JLabel) gaucheR0.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR0.addItem("------------");
		gaucheR0.addItem("Tireur");
		gaucheR0.addItem("Piegeur");
		gaucheR0.addItem("Char");

		JComboBox<String> gaucheR1 = new JComboBox<String>();
		((JLabel) gaucheR1.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR1.addItem("------------");
		gaucheR1.addItem("Tireur");
		gaucheR1.addItem("Piegeur");
		gaucheR1.addItem("Char");

		JComboBox<String> gaucheR2 = new JComboBox<String>();
		((JLabel) gaucheR2.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR2.addItem("------------");
		gaucheR2.addItem("Tireur");
		gaucheR2.addItem("Piegeur");
		gaucheR2.addItem("Char");

		JComboBox<String> gaucheR3 = new JComboBox<String>();
		((JLabel) gaucheR3.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR3.addItem("------------");
		gaucheR3.addItem("Tireur");
		gaucheR3.addItem("Piegeur");
		gaucheR3.addItem("Char");

		JComboBox<String> gaucheR4 = new JComboBox<String>();
		((JLabel) gaucheR4.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		gaucheR4.addItem("------------");
		gaucheR4.addItem("Tireur");
		gaucheR4.addItem("Piegeur");
		gaucheR4.addItem("Char");

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
		equipeDroit.setBackground(Color.YELLOW);
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

		JComboBox<String> droitR0 = new JComboBox<String>();

		((JLabel) droitR0.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR0.addItem("------------");
		droitR0.addItem("Tireur");
		droitR0.addItem("Piegeur");
		droitR0.addItem("Char");

		JComboBox<String> droitR1 = new JComboBox<String>();
		((JLabel) droitR1.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR1.addItem("------------");
		droitR1.addItem("Tireur");
		droitR1.addItem("Piegeur");
		droitR1.addItem("Char");

		JComboBox<String> droitR2 = new JComboBox<String>();
		((JLabel) droitR2.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR2.addItem("------------");
		droitR2.addItem("Tireur");
		droitR2.addItem("Piegeur");
		droitR2.addItem("Char");

		JComboBox<String> droitR3 = new JComboBox<String>();
		((JLabel) droitR3.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR3.addItem("------------");
		droitR3.addItem("Tireur");
		droitR3.addItem("Piegeur");
		droitR3.addItem("Char");

		JComboBox<String> droitR4 = new JComboBox<String>();
		((JLabel) droitR4.getRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		droitR4.addItem("------------");
		droitR4.addItem("Tireur");
		droitR4.addItem("Piegeur");
		droitR4.addItem("Char");

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

				if (e.getButton() == MouseEvent.BUTTON1) {
					fen.dispose();
					new TestGraphic();
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
				// TODO Auto-generated method stub
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
