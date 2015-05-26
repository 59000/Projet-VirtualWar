package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfigPlateau {

	public ConfigPlateau() {

		final JFrame fen = new JFrame("VirtualWar");
		JPanel panHautGauche = new JPanel(new GridLayout(1,4));
		JPanel pandroite = new JPanel();
		Dimension ecran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		JButton petit = new JButton("Petit");
		petit.setPreferredSize(new Dimension(100,50));
		JButton grand = new JButton("Grand");
		grand.setPreferredSize(new Dimension(100,50));
		JButton degage = new JButton("Degage");
		degage.setPreferredSize(new Dimension(100,50));
		JButton encombre = new JButton("Encombre");
		encombre.setPreferredSize(new Dimension(130,50));
		int hauteur_ecran = (int) ecran.getHeight();
		int largeur_ecran = (int) ecran.getWidth();

		fen.setLocation((int) (largeur_ecran * 0.20),
				(int) (hauteur_ecran * 0.30));
		fen.setPreferredSize(new Dimension(700, 500));
		fen.setResizable(false);
		fen.setLayout(new GridBagLayout());
		fen.setContentPane(new PanelFond());
		
		JLabel lab = new JLabel("Configuration Rapide :");
		lab.setForeground(Color.lightGray);

		/** panneau hautgauche */
		panHautGauche.setPreferredSize(new Dimension(500, 50));
		
		panHautGauche.add(petit);
		panHautGauche.add(grand);
		panHautGauche.add(degage);
		panHautGauche.add(encombre);

		/** panneau droit */

		pandroite.setPreferredSize(new Dimension(250,250));
		
	
		pandroite.setBackground(Color.GREEN);

		/** visibilitÃ© */
		fen.getContentPane().add(lab, BorderLayout.NORTH);
		fen.getContentPane().add(panHautGauche);
		fen.getContentPane().add(pandroite);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ConfigPlateau();
	}

}
