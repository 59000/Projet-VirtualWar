package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGraphic {
	/* NORAJ DE MON CODAGE !! */

	/**
	 * Cree un menu graphique avec 3 boutons disponibles et qui lance le mode de
	 * jeu correspondant
	 */
	public MenuGraphic() {
		final JFrame fen = new JFrame("VirtalWar");
		Dimension ecran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur_ecran = (int) ecran.getHeight();
		int largeur_ecran = (int) ecran.getWidth();
		fen.setLocation((int) (largeur_ecran * 0.20),
				(int) (hauteur_ecran * 0.30));
		fen.setContentPane(new PanelFond());
		fen.setPreferredSize(new Dimension(850, 500));
		fen.setResizable(false);

		JLabel motd = new JLabel("VIRTUAL WAR ", JLabel.CENTER);
		motd.setForeground(Color.LIGHT_GRAY);
		motd.setBackground(new Color(35, 25, 15, 0));
		motd.setOpaque(false);
		motd.setFont(new Font("arial", Font.PLAIN, 50));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 1));
		panel.setBackground(new Color(35,25,15,0));
		panel.setOpaque(false);

		JButton boutton1 = new JButton();
		boutton1.setLayout(new GridLayout());
		boutton1.setPreferredSize(new Dimension(200, 30));
		boutton1.setText("PvP");
		boutton1.addMouseListener(new MouseListener() {

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
				if (e.getButton() == MouseEvent.BUTTON1) {
					fen.setVisible(false);
					Menu.joueurVsJoueur();

				}
			}
		});

		JButton boutton2 = new JButton();
		boutton2.setLayout(new GridLayout());
		boutton2.setPreferredSize(new Dimension(200, 30));
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
				if (e.getButton() == MouseEvent.BUTTON1) {
					fen.setVisible(false);
					Menu.joueurVsIa();
				}
			}
		});

		JButton boutton3 = new JButton();
		boutton3.setLayout(new GridLayout());
		boutton3.setPreferredSize(new Dimension(200, 30));
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
				if (e.getButton() == MouseEvent.BUTTON1) {
					fen.setVisible(false);
					Menu.iaVsIa();
				}
			}
		});

		
		JButton regle = new JButton();
		regle.setText("Les Regles");
		regle.setPreferredSize(new Dimension(120,30));
		regle.addMouseListener(new MouseListener() {
			
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
				Desktop d = Desktop.getDesktop();
			    try {
			     d.open(new File("SFDvFinal_corigée.pdf"));
			    } catch (IOException e1) {
			     // TODO Auto-generated catch block
			     e1.printStackTrace();
			    }
			}
		});
		
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(new PanelFond());
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());
		pan1.add(new PanelFond());
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		pan2.add(new PanelFond());
		
		JPanel pan3 = new JPanel();
		pan3.setLayout(new GridLayout(1, 2));
		pan3.setBackground(new Color(0,0,0,0));
		pan3.setOpaque(false);
		
		JPanel pan4 = new JPanel();
		pan4.setLayout(new BorderLayout());
		pan4.add(new PanelFond());
		JPanel pan5 = new JPanel();
		pan5.add(regle);
		pan5.setBackground(new Color(0,0,0,0));
		pan5.setOpaque(false);
		
		pan3.add(pan4);
		pan3.add(pan5);

		
		panel.add(motd);
		panel.add(pan);
		panel.add(boutton1);
		panel.add(pan1);
		panel.add(boutton2);
		panel.add(pan2);
		panel.add(boutton3);
		panel.add(pan3);

		
		
		
		fen.getContentPane().add(panel, BorderLayout.CENTER);
		
		
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
