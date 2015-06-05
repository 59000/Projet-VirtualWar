package Menu;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Plateau.Coordonnees;
import Plateau.Plateau;
import Constante.gameState;

public class ClickableLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Plateau plateau;
	private int i;
	private int j;

	public ClickableLabel(String url, Plateau plateau, int i, int j) {
		super();
		ImageIcon img = new ImageIcon(url);
		this.setIcon(img);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (!gameState.robotSelectionne) {
					if (plateau.plateau[i][j].estBase() != 0) {
						while (!gameState.robotSelectionne) {
							String message = JOptionPane
									.showInputDialog(null,
											"Veuillez sélectionne le robot que vous souhaitez sortir:");
							int robot = Integer.parseInt(message);
							if (gameState.currentEquipe[robot] != null) {
								gameState.robotSelectionne = true;
								gameState.currentRobot = plateau.plateau[i][j]
										.getContenu();
								gameState.finTour = true;
								surlignage();
							}
						}
					} else {
						gameState.robotSelectionne = true;
						gameState.currentRobot = plateau.getCellule(
								new Coordonnees(i, j)).getContenu();
						gameState.finTour = true;
						surlignage();
					}
				} else {
					if (!plateau.getCellule(new Coordonnees(i, j))
							.contientRobot()) {
						plateau.plateau[i][j]
								.deplaceSur(gameState.currentRobot);
						gameState.robotSelectionne = false;
						gameState.currentRobot = null;
						gameState.finTour = true;
						surlignage();
					} else {
						
					}
				}
			}
		});
	}

	public void surlignage() {
		if (!gameState.robotSelectionne) {
			this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2, false));
		} else {
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
}
