package Menu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	/** Image de fond du pannel */
	private Image bg;

	/** Surcharge de la fonction paintComponent() pour afficher notre image */
	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}

	/** Constructeurs */
	public Panel() {
		try {
			bg = ImageIO.read(new File("images/2011-10-30_163044.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
