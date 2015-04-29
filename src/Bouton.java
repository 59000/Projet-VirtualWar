package Menu;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JButton;

public class Bouton extends JButton{
		
			/**
	 * Le code en dessous est "peut-etre" bon...
	 */
	private static final long serialVersionUID = 1L;

			Bouton(Icon icon){
				super(icon);
			    setBorderPainted(false);
			    setFocusPainted(false);
			    setContentAreaFilled(false);
			  }
			 
			  /**
			   * détermine si le point (x, y) est à l'intérieur de l'icône circulaire
			   */
			  public boolean contains(int x, int y) {
			    Dimension size = getSize();
			    float x0 = size.width / 2F;
			    float y0 = size.height / 2F;
			 
			    Icon icon = getIcon();
			    float w = icon.getIconWidth() / 2F;
			    float h = icon.getIconHeight() / 2F;
			 
			    return (x - x0) * (x - x0) + (y - y0) * (y - y0) <= w * h;
			  }
			
}
