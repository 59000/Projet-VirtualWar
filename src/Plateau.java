import java.util.Random;

public class Plateau {

	/* Faire un joli Plateau comme dans l'exemple sur le jalon a rendre =- FAIT */
	private double pourcentage = 6.66;
	private Cellule[][] plateau;
	private Random Ran = new Random(100);
	
	public Plateau(int largeur, int hauteur) {
		plateau = new Cellule[largeur][hauteur];

		for (int h = 0; h < plateau.length; h++) {
			for (int l = 0; l < plateau[h].length; l++) {
				plateau[l][h] = new Cellule(l, h);
			}
		}
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
				} else if(c.estObstacle() == true) {
					areturn += "X";
				}else{
					areturn += " ";
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
	
	/**
	 * Appelle les fonctions qui permettent de modéliser les déplacements.
	 * Si Char = déplacement de 2 ou 1 si bloqué par un obstacles.
	 * Sinon = déplacement de 1.
	 * 
	 * Si le robot arrive sur une mine, il se prend les dégats.
	 * 
	 * @param t1
	 *            robot
	 * @param mvt
	 *            Constante de déplacement
	 */
	public void deplaceRobot(Robot r, Coordonnees mvt) {
		// Si le robot est un Char
		if (r instanceof Char) {
			// Et que le mouvement demandée est un mouvement diagonales
			if (mvt.equals(Constante.HAUTDROIT)
					|| mvt.equals(Constante.HAUTGAUCHE)
					|| mvt.equals(Constante.BASDROIT)
					|| mvt.equals(Constante.BASGAUCHE)) {
				// Renvoie un message d'erreur
				System.out.println("Erreur : Un char ne peut se déplacer diagonalement");
			}
			// Sinon, fonctionnement normal de la fonction
			else {
				// Si le premier déplacement n'envoie pas le char sur un
				// obstacle
				if (!this.plateau[r.getCoord().getLargeur() + mvt.getLargeur()]
								 [r.getCoord().getHauteur() + mvt.getHauteur()].estObstacle()) {
					// Et que le deuxiéme non plus
					if (!this.plateau[r.getCoord().getLargeur()+ (2 * mvt.getLargeur())]
									 [r.getCoord().getHauteur()+ (2 * mvt.getHauteur())].estObstacle()) {
						// Fonctionnement normale de la fonction
						this.plateau[r.getCoord().getLargeur()]
									[r.getCoord().getHauteur()].videCase();
						new Deplacement(r, mvt);
						this.plateau[r.getCoord().getLargeur()]
									[r.getCoord().getHauteur()].deplaceSur(r);
					} else {
					// Sinon, le déplacement se stoppe au premier déplacement
					this.plateau[r.getCoord().getLargeur()]
								[r.getCoord().getHauteur()].videCase();
					new Deplacement(r, mvt);
					r = Deplacement.charBloquee(r,mvt); // Appelle la fonction qui réajuste le déplacement du char
					this.plateau[r.getCoord().getLargeur()]
							[r.getCoord().getHauteur()].deplaceSur(r);
					// Et un message qui précise que ce cas à eu lieu
					System.out.println("Event : Le char a rencontrée un obstacle et a dû s'arrétée plus tôt.");
					}
				} else {
					// Sinon, message d'érreur
					System.out.println("Erreur : Un obstacle bloque le déplacement, déplacement annulée.");
				}
			}
		}
		
		// Si le robot est autre qu'un char, fonctionnement normale de
		// la fonction
		else {
			// Si le déplacement n'envoie pas le robot sur un obstacle
			if (!this.plateau[r.getCoord().getLargeur() + mvt.getLargeur()]
							 [r.getCoord().getHauteur() + mvt.getHauteur()].estObstacle()) {
				this.plateau[r.getCoord().getLargeur()]
							[r.getCoord().getHauteur()].videCase();
				new Deplacement(r, mvt);
				this.plateau[r.getCoord().getLargeur()]
							[r.getCoord().getHauteur()].deplaceSur(r);
			} else {
				// Sinon, message d'érreur et annulation du déplacement
				System.out.println("Erreur : Un obstacle bloque le déplacement, déplacement annulée.");
			}
		}
		
		// Si le robot se déplace qur une cellule miné
		if (this.plateau[r.getCoord().getLargeur()]
						[r.getCoord().getHauteur()].contienMine() != 0) {
			// Le robot se prend les dégats et la mine disparaît
			r.subitMine();
			this.plateau[r.getCoord().getLargeur()][r.getCoord().getHauteur()].setMine(0);
		}
	}

	public static void main(String[] args) {
		Plateau p = new Plateau(10, 10);
		p.plateau[0][0].base = 1;
		p.plateau[9][9].base = 2;

		Robot t1 = new Char(0, 0);
		// Setter les coordonnées IMPÉRATIVEMENT
		t1.setCoord(new Coordonnees(4, 4));

		p.plateau[t1.getCoord().getLargeur()][t1.getCoord().getHauteur()]
				.deplaceSur(t1);

		System.out.println(p);

		try {
			Thread.sleep(1000);// dodo 1 sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		p.deplaceRobot(t1, Constante.HAUT);

		System.out.println(p);		
	}
}
