package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGraphic  {
	/*NORAJ DE MON CODAGE !!*/
	/** Cree un menu graphique avec 3 boutons disponibles et qui lance le mode de jeu correspondant*/
	public MenuGraphic() {
		JFrame fen = new JFrame("VirtalWar");
		Dimension ecran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur_ecran = (int)ecran.getHeight();
		int largeur_ecran  = (int)ecran.getWidth(); 
		fen.setLocation((int)(largeur_ecran*0.40),(int)(hauteur_ecran*0.30));
		fen.setPreferredSize(new Dimension(500,500));
		
		fen.getContentPane().setBackground(Color.black);
		JLabel motd = new JLabel("selectionner votre mode de jeu :",JLabel.CENTER);
		motd.setForeground(Color.LIGHT_GRAY);
		fen.getContentPane().add(motd,BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridBagLayout());
		
		JPanel panel1 = new JPanel();
		JLabel lab1 = new JLabel("PvP",JLabel.CENTER);
		panel1.setLayout(new GridLayout());
		panel1.setBackground(Color.yellow);
		panel1.setPreferredSize(new Dimension(50,50));
		panel1.add(lab1);
		panel1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				panel1.setBackground(Color.yellow);
			}
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				panel1.setBackground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				panel1.setBackground(Color.yellow);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				panel1.setBackground(Color.orange);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == MouseEvent.BUTTON1){
					fen.setVisible(false);
					Menu.joueurVsJoueur();
					
				}
			}
		});
		panel.add(panel1);
		/*NORAJ DE MON NOMAGE !!!*/
		JPanel panel_remplissage = new JPanel();
		panel_remplissage.setBackground(Color.black);
		panel_remplissage.setPreferredSize(new Dimension(50,50));
		panel.add(panel_remplissage);
				
		JPanel panel2 = new JPanel();
		JLabel lab2 = new JLabel("PvIa",JLabel.CENTER);
		panel2.setLayout(new GridLayout());
		panel2.setBackground(Color.YELLOW);
		panel2.setPreferredSize(new Dimension(50,50));
		panel2.add(lab2);
		
		panel2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				panel2.setBackground(Color.yellow);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				panel2.setBackground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				panel2.setBackground(Color.yellow);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				panel2.setBackground(Color.orange);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == MouseEvent.BUTTON1){
					fen.setVisible(false);
					Menu.joueurVsIa();
				}
			}
		});
		panel.add(panel2);
		JPanel panel_remplissage2 = new JPanel();
		panel_remplissage2.setBackground(Color.black);
		panel_remplissage2.setPreferredSize(new Dimension(50,50));
		panel.add(panel_remplissage2);
		
		JPanel panel3 = new JPanel();
		JLabel lab3 = new JLabel("IaVIa",JLabel.CENTER);
		panel3.setLayout(new GridLayout());
		panel3.setBackground(Color.yellow);
		panel3.setPreferredSize(new Dimension(50,50));
		panel3.add(lab3);
		
		panel3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				panel3.setBackground(Color.yellow);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				panel3.setBackground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				panel3.setBackground(Color.yellow);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				panel3.setBackground(Color.orange);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == MouseEvent.BUTTON1){
					fen.setVisible(false);
					Menu.iaVsIa();
				}
			}
		});
		panel.add(panel3);
		
		fen.getContentPane().add(panel,BorderLayout.CENTER);
		
		fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);
	}
	
	
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          new MenuGraphic();
	        }
	    });
	}
}

