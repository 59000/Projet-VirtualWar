public class Plateau {

	/* Faire un joli Plateau comme dans l'exemple sur le jalon a rendre =- FAIT */
	private Cellule[][] plateau;

	public Plateau(int largeur, int hauteur) {
		plateau = new Cellule[largeur][hauteur];

		for (int h = 0; h < plateau.length; h++) {
			for (int l = 0; l < plateau[h].length; l++) {
				plateau[l][h] = new Cellule(l, h);
			}
		}
	}

	/**
	 * Lance le deplacement du Robot
	 * 
	 * @param d
	 */
	public void deplacement(Deplacement d) {
		// TODO FAIRE FONCTIONNER CETTE FONCTION DE M%@$% !!!!!!!
		Coordonnees coordD = d.robot.getCoord();

		plateau[coordD.getHauteur()][coordD.getLargeur()].robot = null;
		/*
		 * coordD.ajout(d.coord);
		 * plateau[coordD.getHauteur()][coordD.getLargeur(
		 * )].deplaceSur(d.robot);
		 */
	}

	public String toString() {
		String areturn = ""; // String contenant l'affichage du pateau
		for (int h = 0; h < plateau.length; h++) {
			// Haut du plateau
			for (int i = 0; i < plateau.length; i++)
				areturn += "+---";
			areturn += "+\n";

			// Cellules
			for (int l = 0; l < plateau[h].length; l++) {
				// Encadrement gauche des cellules
				areturn += "| ";
				// Contenus de la cellule
				Cellule c = plateau[l][h];
				if (c.estBase() == 1) {
					areturn += "B";
				} else if (c.estBase() == 2) {
					areturn += "b";
				} else if (c.contienMine() == 1) {
					areturn += "M";
				} else if (c.contienMine() == 2) {
					areturn += "m";
				} else if (c.getContenu() != null) {
					if (c.getContenu().getEquipe() == 1) {
						if (c.getContenu() instanceof Char) {
							areturn += "C";
						} else if (c.getContenu() instanceof Tireur) {
							areturn += "T";
						} else if (c.getContenu() instanceof Piegeur) {
							areturn += "P";
						}
					} else {
						if (c.getContenu() instanceof Char) {
							areturn += "c";
						} else if (c.getContenu() instanceof Tireur) {
							areturn += "t";
						} else if (c.getContenu() instanceof Piegeur) {
							areturn += "p";
						}
					}
				} else {
					areturn += ".";
				}
				// Encadrement Droit du plateau
				areturn += " ";
			}
			areturn += "|\n";
		}

		// Bas du plateau
		for (int i = 0; i < plateau.length; i++)
			areturn += "+---";
		areturn += "+\n";

		return areturn;
	}

	public static void main(String[] args) {
		Plateau p = new Plateau(10, 10);
		p.plateau[0][0].base = 1;
		p.plateau[9][9].base = 2;

		Robot t1 = new Tireur(1, 1);
		Robot t2 = new Tireur(2, 1);
		Robot c1 = new Char(1, 2);
		Robot c2 = new Char(2, 2);
		Robot p1 = new Piegeur(1, 3);
		Robot p2 = new Piegeur(2, 3);

		p.plateau[0][1].robot = t1;
		t1.setCoord(new Coordonnees(0, 1));
		p.plateau[0][2].robot = t2;
		p.plateau[0][3].robot = p1;
		p.plateau[0][4].robot = p2;
		p.plateau[0][5].robot = c1;
		p.plateau[0][6].robot = c2;

		System.out.println(p);
		try {
			Thread.sleep(1000);// dodo 1 sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		p.deplacement(new Deplacement(t1, Constante.DROIT));
	}
}
