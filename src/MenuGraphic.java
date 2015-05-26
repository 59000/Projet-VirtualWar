package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
		fen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fen.setResizable(false);

		JLabel motd = new JLabel("VIRTUAL WAR ", JLabel.CENTER);
		motd.setForeground(Color.LIGHT_GRAY);
		motd.setBackground(new Color(35, 25, 15, 255));
		motd.setOpaque(true);
		motd.setFont(new Font("arial", Font.PLAIN, 50));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 1));

		JButton boutton1 = new JButton();
		boutton1.setLayout(new GridLayout());
		boutton1.setPreferredSize(new Dimension(200, 30));
		boutton1.setText("PVP");
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

		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(new PanelFond());
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());
		pan1.add(new PanelFond());
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		pan2.add(new PanelFond());

		panel.add(motd);
		panel.add(pan);
		panel.add(boutton1);
		panel.add(pan1);
		panel.add(boutton2);
		panel.add(pan2);
		panel.add(boutton3);

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
