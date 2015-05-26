package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigEquipePvP {

	public ConfigEquipePvP(){
		JFrame fen = new JFrame();
		fen.setPreferredSize(new Dimension(700,500));
		Dimension ecran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur_ecran = (int) ecran.getHeight();
		int largeur_ecran = (int) ecran.getWidth();
		fen.setLocation((int) (largeur_ecran * 0.20),
				(int) (hauteur_ecran * 0.30));
		
		fen.setResizable(false);
		fen.setLayout(new GridBagLayout());
		fen.setContentPane(new PanelFond());
		
		/** panneau principal*/
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.setPreferredSize(new Dimension(700,500));
		panel.setBackground(new Color(0,0,0,0));	
		panel.setOpaque(false);
		/** panneau gauche*/
		JPanel panGauche = new JPanel();
		panGauche.setLayout(new BorderLayout());
		panGauche.setPreferredSize(new Dimension(350,500));
		panGauche.setBackground(new Color(0,0,0,0));
		panGauche.setOpaque(false);
		
		/**titre set nom equipe 1*/
		JPanel equipeGauche = new JPanel();
		equipeGauche.setLayout(new GridLayout(5,1));
		equipeGauche.setPreferredSize(new Dimension(200,100));
		//equipeGauche.setBackground(new Color(0,0,0,0));
		//equipeGauche.setOpaque(false);
		equipeGauche.setBackground(Color.green);
		
		
		JLabel labelTitreGauche = new JLabel("Equipe 1 ",JLabel.CENTER);
		labelTitreGauche.setForeground(Color.LIGHT_GRAY);
		
		/**textfield equipe 1*/
		
		JTextField textNomEquipe1 = new JTextField("Equipe 1");
		textNomEquipe1.setPreferredSize(new Dimension(50,5));
		
		textNomEquipe1.setVisible(true);
		equipeGauche.add(textNomEquipe1, BorderLayout.CENTER);
		
		
		
		panGauche.add(equipeGauche,BorderLayout.NORTH);
		equipeGauche.add(labelTitreGauche, BorderLayout.NORTH);
		
		

		/** panneau droite*/
		JPanel panDroit = new JPanel();
		panDroit.setLayout(new BorderLayout());
		panDroit.setPreferredSize(new Dimension(350,500));
		panDroit.setBackground(new Color(0,0,0,0));
		panDroit.setOpaque(false);
		/**set nom equipe 2*/
		JPanel equipeDroit = new JPanel();
		equipeDroit.setLayout(new BorderLayout());
		equipeDroit.setPreferredSize(new Dimension(200,80));
		equipeDroit.setBackground(new Color(0,0,0,0));
		equipeDroit.setOpaque(false);
		panDroit.add(equipeDroit,BorderLayout.NORTH);
		
		
		JLabel labelTitreDroite = new JLabel("Equipe 2 ",JLabel.CENTER);
		labelTitreDroite.setForeground(Color.LIGHT_GRAY);
		
		
		equipeDroit.add(labelTitreDroite);
		panDroit.add(equipeDroit,BorderLayout.NORTH);
		panel.add(panGauche);
		panel.add(panDroit);
		
		
		
		
		fen.getContentPane().add(panel);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ConfigEquipePvP();
	}
}
