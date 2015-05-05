package Menu;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuGraphic  {
	//NORAJ DE MON CODAGE !!
	public MenuGraphic() {
		// TODO Auto-generated constructor stub
		int dimX = 500;
		int dimY = 500;
		JFrame fenetre = new JFrame("VirtalWar");
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth(); 
		fenetre.setLocation((int)(width*0.40),(int)(height*0.30));
		fenetre.setPreferredSize(new Dimension(dimX,dimY));
		JPanel panel = new JPanel();
		/*LEL*/JLabel lel = new JLabel("L'IHM SA SUCK", JLabel.CENTER);
		panel.add(lel);
		panel.setPreferredSize(new Dimension(100,100));
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		
		
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
				if(e.getButton() == e.BUTTON1){
					Menu.joueurVsJoueur();
					
				}
			}
		});
		
		
		
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
				if(e.getButton() == e.BUTTON1){
				//	Menu.joueurVsIa();
					JOptionPane.showMessageDialog(null, "Indisponible pour le moment");
				}
			}
		});
		
		
		
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
				if(e.getButton() == e.BUTTON1){
					Menu.iaVsIa();
				
					
					
				}
			}
		});
		
		
		panel.add(panel1,gbc);
		 panel.add(panel2,gbc);
		 panel.add(panel3,gbc);
	/*	gbc.gridx = 0;
		gbc.gridy = 0;
		
		
		gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    gbc.gridx = 2;
	    panel.add(panel1,gbc);
	    
	    gbc.gridx = 4;
	    
	    panel.add(panel2,gbc);
	    gbc.gridx = 6;
	    panel.add(panel3,gbc);
		*/
		fenetre.setContentPane(panel);
		
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.pack();
		
		fenetre.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/*String mode = JOptionPane
				.showInputDialog("1: Joueur Vs Joueur \n 2: Joueur Vs Ia \n 3: Ia vs Ia");
		try {
			if (mode.equals("1")) {
				Menu.joueurVsJoueur();
			} else if (mode.equals("2")) {
				// joueurVsIa();
				JOptionPane.showMessageDialog(null, "En travaux");
				main(args);
			} else if (mode.equals("3")) {
				// iaVsIa();
				JOptionPane.showMessageDialog(null, "En travaux");
				main(args);
			} else {
				JOptionPane.showMessageDialog(null, "Choix incorrect, veuillez recommencer");
				main(args);
			}
		} catch (NullPointerException e) {
			
				JOptionPane.showMessageDialog(null, "Vous avez choisis la pillule rouge...");
			System.exit(1);
			// TODO: handle exception
		}*/
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          new MenuGraphic();
	        }
	    });
		
		
		
	}
}

