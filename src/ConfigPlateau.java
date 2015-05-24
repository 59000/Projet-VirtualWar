package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConfigPlateau {

	public ConfigPlateau() {

		final JFrame fen = new JFrame("VirtalWar");
		JPanel panHautGauche = new JPanel(new GridLayout());
		JPanel pandroite = new JPanel();
		Dimension ecran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		JButton petit = new JButton("Petit");
		JButton grand = new JButton("Grand");
		JButton degage = new JButton("Degage");
		JButton encombre = new JButton("Encombre");
		int hauteur_ecran = (int) ecran.getHeight();
		int largeur_ecran = (int) ecran.getWidth();

		fen.setLocation((int) (largeur_ecran * 0.20),
				(int) (hauteur_ecran * 0.30));
		fen.setPreferredSize(new Dimension(700, 500));
		fen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fen.setResizable(false);
		fen.setLayout(new GridBagLayout());
		fen.setContentPane(new PanelFond());

		/** panneau hautgauche */
		panHautGauche.setPreferredSize(new Dimension(500 / 2, 500 / 2));

		panHautGauche.add(petit);
		panHautGauche.add(grand);
		panHautGauche.add(degage);
		panHautGauche.add(encombre);

		/** panneau droit */

		pandroite.setPreferredSize(new Dimension(500 / 2, 500 / 2));
		pandroite.setBackground(Color.GREEN);

		/** visibilité */
		fen.getContentPane().add(pandroite);
		fen.getContentPane().add(panHautGauche);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ConfigPlateau();
	}

}
