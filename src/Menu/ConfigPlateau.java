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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConfigPlateau {
	JLabel labelSlider = new JLabel("Taille : 5");
	JLabel labelSlider1 = new JLabel("Obstacle : 0");
	static JSlider slider = new JSlider(5, 10);
	static JSlider slider1 = new JSlider(0, 100);

	public ConfigPlateau() {

		final JFrame fen = new JFrame("VirtualWar");
		JPanel panHautGauche = new JPanel(new GridLayout(2, 2));
		JPanel panSlider = new JPanel();
		JPanel panSlider1 = new JPanel();
		Dimension ecran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		final JButton petit = new JButton("Petit");
		petit.setPreferredSize(new Dimension(100, 50));
		final JButton grand = new JButton("Grand");
		grand.setPreferredSize(new Dimension(100, 50));
		final JButton degage = new JButton("Degage");
		degage.setPreferredSize(new Dimension(100, 50));
		final JButton encombre = new JButton("Encombre");
		encombre.setPreferredSize(new Dimension(130, 50));
		int hauteur_ecran = (int) ecran.getHeight();
		int largeur_ecran = (int) ecran.getWidth();

		fen.setLocation((int) (largeur_ecran * 0.20),
				(int) (hauteur_ecran * 0.30));
		fen.setPreferredSize(new Dimension(700, 500));
		fen.setResizable(false);
		fen.setLayout(new GridBagLayout());
		fen.setContentPane(new PanelFond());

		JButton valide = new JButton("Valider");
		valide.setPreferredSize(new Dimension(75, 30));
		valide.setFont(new Font("arial", Font.PLAIN, 20));
		valide.setBackground(new Color(0, 0, 0, 0));
		valide.setOpaque(false);
		valide.setForeground(Color.GREEN);
		
		
		JButton retour = new JButton("Retour");
		retour.setPreferredSize(new Dimension(75, 30));
		retour.setFont(new Font("arial", Font.PLAIN, 20));
		retour.setBackground(new Color(0, 0, 0, 0));
		retour.setOpaque(false);
		retour.setForeground(Color.RED);

		JLabel lab = new JLabel("Configuration Rapide :");
		lab.setForeground(Color.lightGray);

		/** Slider dans le panneau */

		
		slider.setValue(5);
		labelSlider.setForeground(Color.LIGHT_GRAY);

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub

				labelSlider.setText("Taille : " + slider.getValue());
			}
		});
		slider.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (slider.getValue() == 5) {
					petit.setEnabled(false);
				} else if (slider.getValue() == 10) {
					grand.setEnabled(false);
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				grand.setEnabled(true);
				petit.setEnabled(true);
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

			}
		});

		/** Slider 2 dans le panneau */

		
		slider1.setValue(0);
		labelSlider1.setForeground(Color.LIGHT_GRAY);

		slider1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub

				labelSlider1.setText("Obstacle : " + slider1.getValue());
			}
		});

		/** panneau hautgauche */
		panHautGauche.setPreferredSize(new Dimension(500, 50));

		panHautGauche.add(petit);
		panHautGauche.add(grand);
		panHautGauche.add(degage);
		panHautGauche.add(encombre);

		/** panneau slider */

		panSlider.setPreferredSize(new Dimension(700, 30));
		panSlider.add(labelSlider);
		panSlider.add(slider);

		panSlider.setBackground(new Color(35, 25, 15, 0));
		panSlider.setOpaque(false);

		/** panneau slider2 */

		panSlider1.setPreferredSize(new Dimension(700, 30));
		panSlider1.add(labelSlider1);
		panSlider1.add(slider1);

		panSlider1.setBackground(new Color(35, 25, 15, 0));
		panSlider1.setOpaque(false);

		/** panneau invisible */

		JPanel paninvi = new JPanel();
		paninvi.setLayout(new BorderLayout());
		paninvi.setPreferredSize(new Dimension(700, 75));
		paninvi.add(new PanelFond());

		/** panneau invisible 2 */
		labelSlider.setFont(new Font("arial", Font.PLAIN, 20));
		labelSlider1.setFont(new Font("arial", Font.PLAIN, 20));
		JPanel paninvi1 = new JPanel();
		paninvi1.setLayout(new BorderLayout());
		paninvi1.setPreferredSize(new Dimension(350, 200));
		paninvi1.add(new PanelFond());
		paninvi1.setBackground(new Color(0, 0, 0, 0));
		paninvi1.setOpaque(false);
		
		JPanel panelValideRetour = new JPanel();
		panelValideRetour.setLayout(new GridLayout(1,2));
		panelValideRetour.setBackground(new Color(0,0,0,0));
		panelValideRetour.setOpaque(false);
		panelValideRetour.add(valide);
		panelValideRetour.add(retour);

		paninvi1.add(slider, BorderLayout.NORTH);
		paninvi1.add(panelValideRetour);
		
		paninvi1.add(slider1, BorderLayout.SOUTH);

		/** panneau plateau */
		JPanel plateau = new JPanel();
		plateau.setPreferredSize(new Dimension(250, 250));
		plateau.setBackground(new Color(0, 0, 0, 0));
		plateau.setOpaque(false);

		Image img = null;
		try {
			img = ImageIO.read(new File("images/plateau.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel labelImage = new JLabel(new ImageIcon(img));
		plateau.add(labelImage, BorderLayout.WEST);

		/** visibilite */

		fen.getContentPane().add(lab, BorderLayout.NORTH);
		fen.getContentPane().add(panHautGauche);
		fen.getContentPane().add(paninvi);
		fen.getContentPane().add(panSlider);
		fen.getContentPane().add(plateau);
		fen.getContentPane().add(paninvi1);
		fen.getContentPane().add(panSlider1);

		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);

		/** Evenement des Bouttons */

		petit.addMouseListener(new MouseListener() {

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
					petit.setEnabled(false);
					grand.setEnabled(true);
					slider.setValue(5);
				}
			}
		});

		grand.addMouseListener(new MouseListener() {

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
					grand.setEnabled(false);
					petit.setEnabled(true);
					slider.setValue(10);
				}
			}
		});

		slider1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (slider1.getValue() >= 70) {
					encombre.setEnabled(false);
					degage.setEnabled(true);
				} else if (slider1.getValue() <= 10) {
					degage.setEnabled(false);
					encombre.setEnabled(true);
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				encombre.setEnabled(true);
				degage.setEnabled(true);
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

			}
		});

		degage.addMouseListener(new MouseListener() {

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
					degage.setEnabled(false);
					encombre.setEnabled(true);
					slider1.setValue(0);
				}
			}
		});

		encombre.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					encombre.setEnabled(false);
					degage.setEnabled(true);
					slider1.setValue(70);
				}
			}
		});

		valide.addMouseListener(new MouseListener() {

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
					if(MenuGraphic.experimental.equals("2") && MenuGraphic.choix == 1){
						JOptionPane.showMessageDialog(null, "Le jeu est lance dans la console");
						fen.dispose();
						Menu.joueurVsJoueur();
						
					}else if(MenuGraphic.experimental.equals("2") && MenuGraphic.choix == 2){
						JOptionPane.showMessageDialog(null, "Le jeu est lance dans la console");
						fen.dispose();
						Menu.joueurVsIa();
					}else if(MenuGraphic.experimental.equals("2") && MenuGraphic.choix == 3){
						JOptionPane.showMessageDialog(null, "Le jeu est lance dans la console");
						fen.dispose();
						Menu.iaVsIa();
					}
					else{
						
						switch (MenuGraphic.choix) {
						case 1:
							fen.dispose();
							new ConfigEquipePvP();
	
							break;
						case 2:
							fen.dispose();
							 new ConfigEquipePvIA();
	
							break;
						case 3:
							fen.dispose();
							 new TestGraphic();
	
							break;
	
						}
					}
				}
			}
		});
		retour.addMouseListener(new MouseListener() {
			
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
				if(e.getButton()== MouseEvent.BUTTON1){
				
					fen.dispose();
					new MenuGraphic();
				}
			}
		});
	}

}
