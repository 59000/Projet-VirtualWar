package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGraphic  {
	/*NORAJ DE MON CODAGE !!*/
	ImageIcon img = new ImageIcon("fond.png");
	
	/** Cree un menu graphique avec 3 boutons disponibles et qui lance le mode de jeu correspondant*/
	public MenuGraphic() {
		final JFrame fen = new JFrame("VirtalWar");
		Dimension ecran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur_ecran = (int)ecran.getHeight();
		int largeur_ecran  = (int)ecran.getWidth(); 
		fen.setLocation((int)(largeur_ecran*0.20),(int)(hauteur_ecran*0.30));
		fen.setContentPane(new PanelFond());
		fen.setPreferredSize(new Dimension(850,500));
		fen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fen.setResizable(false);

		JLabel motd = new JLabel("VIRTUAL WAR ",JLabel.CENTER);
		motd.setForeground(Color.LIGHT_GRAY);
		motd.setBackground(new Color(25,15,2,255));
		motd.setOpaque(true);
		motd.setFont(new Font("arial", Font.PLAIN, 50));
		
		
		
		
		
		
		
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(7,1));
	
		
		JButton boutton1= new JButton();
		boutton1.setLayout(new GridLayout());
		boutton1.setPreferredSize(new Dimension(200,30));
		boutton1.setText("PVP");
		boutton1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
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
				if(e.getButton() == MouseEvent.BUTTON1){
					fen.setVisible(false);
					Menu.joueurVsJoueur();
					
				}
			}
		});
		
		JButton boutton2= new JButton();
		boutton2.setLayout(new GridLayout());
		boutton2.setPreferredSize(new Dimension(200,30));
		boutton2.setText("PvIA");
		boutton2.addMouseListener(new MouseListener() {
			
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
				if(e.getButton() == MouseEvent.BUTTON1){
					fen.setVisible(false);
					Menu.joueurVsIa();
				}
			}
		});

		JButton boutton3= new JButton();
		boutton3.setLayout(new GridLayout());
		boutton3.setPreferredSize(new Dimension(200,30));
		boutton3.setText("IAvIA");
		boutton3.addMouseListener(new MouseListener() {
			
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
				if(e.getButton() == MouseEvent.BUTTON1){
					fen.setVisible(false);
					Menu.iaVsIa();
				}
			}
		});
		
		
		JLabel labs = new JLabel();
		labs.setBackground(new Color(25,15,2,255));
		labs.setOpaque(true);
		JLabel labs1 = new JLabel();
		labs1.setBackground(new Color(25,15,2,255));
		labs1.setOpaque(true);
		JLabel labs2= new JLabel();
		labs2.setBackground(new Color(25,15,2,255));
		labs2.setOpaque(true);
		
		panel.add(motd);
		panel.add(labs);
		panel.add(boutton1);
		panel.add(labs1);
		panel.add(boutton2);
		panel.add(labs2);
		panel.add(boutton3);
		
	/*	final JPanel panel1 = new JPanel();
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
				panel1.setBackground(Color.white);
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
		
		JPanel panel_remplissage = new JPanel();
		panel_remplissage.setBackground(new Color(25,15,2,255));
		panel_remplissage.setPreferredSize(new Dimension(50,50));
		panel.add(panel_remplissage);
				
		final JPanel panel2 = new JPanel();
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
				panel2.setBackground(Color.white);
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
		panel_remplissage2.setBackground(new Color(25,15,2,255));	
		panel_remplissage2.setPreferredSize(new Dimension(50,50));
		panel.add(panel_remplissage2);
		
		final JPanel panel3 = new JPanel();
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
				panel3.setBackground(Color.white);
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
		panel.add(panel3);*/
		
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

