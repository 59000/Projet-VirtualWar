package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.setPreferredSize(new Dimension(700,500));
		panel.setBackground(new Color(0,0,0,0));	
		panel.setOpaque(false);
		
		JPanel panGauche = new JPanel();
		panGauche.setLayout(new BorderLayout());
		panGauche.setPreferredSize(new Dimension(350,500));
		panGauche.setBackground(new Color(0,0,0,0));
		panGauche.setOpaque(false);
		
		
		JPanel equipeGauche = new JPanel();
		equipeGauche.setLayout(new BorderLayout());
		equipeGauche.setPreferredSize(new Dimension(200,50));
		equipeGauche.setBackground(Color.GREEN);
		panGauche.add(equipeGauche,BorderLayout.NORTH);
		
		
		JLabel labelTitreGauche = new JLabel("Nom :");
		
		equipeGauche.add(labelTitreGauche);
		
		


		JPanel panDroit = new JPanel();
		panDroit.setLayout(new BorderLayout());
		panDroit.setPreferredSize(new Dimension(350,500));
		panDroit.setBackground(new Color(0,0,0,0));
		panDroit.setOpaque(false);
		
		JPanel equipeDroit = new JPanel();
		equipeDroit.setLayout(new BorderLayout());
		equipeDroit.setPreferredSize(new Dimension(200,50));
		equipeDroit.setBackground(Color.RED);
		
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
