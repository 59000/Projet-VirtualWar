import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plateau {

	public Cellule[][] plateau;

	public Plateau(int largeur, int hauteur) {
		plateau = new Cellule[largeur][hauteur];

		for (int h = 0; h < plateau.length; h++) {
			for (int l = 0; l < plateau[h].length; l++) {
				plateau[l][h] = new Cellule(l, h);
			}
		}
	}
	
	List<Cellule> ya_chemin(Cellule base1)
	{
		Random r = new Random();
		List<Cellule> areturn = new ArrayList<Cellule>();
		
		boolean base2_attainte=false;
		Cellule cellule_active = base1;
		
		while (!base2_attainte) 
		{
			int bd = r.nextInt(2)+1;
			if(bd == 1)
			{	
				if(this.cette_case_est_valide(this.getCellule(cellule_active.getCoordonnees().ajout(Constante.BAS))))
				{
					cellule_active=this.getCellule(cellule_active.getCoordonnees().ajout(Constante.BAS));
					areturn.add(cellule_active);
				}
			}
			
			if(bd == 2)
			{
				if(this.cette_case_est_valide(this.getCellule(cellule_active.getCoordonnees().ajout(Constante.DROIT))))
				{
					cellule_active=this.getCellule(cellule_active.getCoordonnees().ajout(Constante.DROIT));
					areturn.add(cellule_active);
				}
			}
			if(cellule_active.estBase() == Constante.BASE2)
			{
				base2_attainte = true;
			}
		}
		
		
		return areturn;
	}
	
	
	private boolean cette_case_est_valide(Cellule c)
	{
		try
		{
			if(c.estBase()==Constante.BASE2)
			{
				return true;
			}
		}catch(NullPointerException e)
		{
			return false;
		}
		return true;//compil auto
	}

	void genere_obstacle(Cellule base1)
	{
		List<Cellule> chemin = this.ya_chemin(base1);
		for (int h = 0; h < plateau.length; h++) 
		{
			for (int l = 0; l < plateau[h].length; l++) 
			{
				if(plateau[l][h].estBase()==0 && !chemin.contains(plateau[l][h]))
				{
					plateau[l][h].cree_Obstacle();
				}
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
				} else if (c.estObstacle() == true) {
					areturn += "X";
				} else {
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
	 * Appelle les fonctions qui permettent de modÃƒÂ©liser les dÃƒÂ©placements. Si
	 * Char = dÃƒÂ©placement de 2 ou 1 si bloquÃƒÂ© par un obstacles. Sinon =
	 * dÃƒÂ©placement de 1.
	 * 
	 * Si le robot arrive sur une mine, il se prend les dÃƒÂ©gats.
	 * 
	 * @param t1
	 *            robot
	 * @param mvt
	 *            Constante de dÃƒÂ©placement
	 */
	public void deplaceRobot(Robot r, Coordonnees mvt) {
		// Si le robot est un Char
		if (r instanceof Char) {
			// Et que le mouvement demandÃƒÂ©e est un mouvement diagonales
			if (mvt.equals(Constante.HAUTDROIT)
					|| mvt.equals(Constante.HAUTGAUCHE)
					|| mvt.equals(Constante.BASDROIT)
					|| mvt.equals(Constante.BASGAUCHE)) {
				// Renvoie un message d'erreur
				System.out
						.println("Erreur : Un char ne peut se deplacer diagonalement");
			}
			// Sinon, fonctionnement normal de la fonction
			else {
				// Si le premier dÃƒÂ©placement n'amÃƒÂ¨ne pas au dehors des bords du
				// plateau
				if (r.getCoord().getLargeur() + mvt.getLargeur() >= 0
						&& r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau.length) {
					// Et si le premier dÃƒÂ©placement n'envoie pas le char sur un
					// obstacle
					if (!this.plateau[r.getCoord().getLargeur()
							+ mvt.getLargeur()][r.getCoord().getHauteur()
							+ mvt.getHauteur()].estObstacle()) {

						// 1er dÃƒÂ©placement du char
						this.plateau[r.getCoord().getLargeur()][r.getCoord()
								.getHauteur()].videCase();
						new Deplacement(r, mvt);
						this.plateau[r.getCoord().getLargeur()][r.getCoord()
								.getHauteur()].deplaceSur(r);

						// Si le robot se dÃƒÂ©place sur une mine
						this.deplaceSurMine(r);

						// 2ÃƒÂ©me dÃƒÂ©placement
						// Si le second dÃƒÂ©placement n'amÃƒÂ¨ne pas au dehors des
						// bords du
						// plateau
						if (r.getCoord().getLargeur() + mvt.getLargeur() >= 0
								&& r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau.length) {
							// Et si le second dÃƒÂ©placement n'envoie pas le char
							// sur un
							// obstacle
							if (!this.plateau[r.getCoord().getLargeur()
									+ mvt.getLargeur()][r.getCoord()
									.getHauteur() + mvt.getHauteur()]
									.estObstacle()) {

								// 2ÃƒÂ©me dÃƒÂ©placement du char
								this.plateau[r.getCoord().getLargeur()][r
										.getCoord().getHauteur()].videCase();
								new Deplacement(r, mvt);
								this.plateau[r.getCoord().getLargeur()][r
										.getCoord().getHauteur()].deplaceSur(r);
							} else {
								// Sinon, un obstacle empÃƒÂªche le second
								// dÃƒÂ©placement
								System.out
										.println("Event : Le char a rencontre un obstacle sur son chemin et a du se stopper.");
							}

						} else {
							// Sinon, les limites du plateau empÃƒÂªche le second
							// dÃƒÂ©placement
							System.out
									.println("Event : Le char a du s'arrÃƒÂªter pour ne pas tomber.");
						}

					} else {
						// Sinon, un obstacle empÃƒÂªche le dÃƒÂ©placement
						System.out
								.println("Erreur : Un obstacle bloque le deplacement, deplacement annule.");
					}

				} else {
					// Sinon, les limites du plateau empÃƒÂªche le dÃƒÂ©placement
					System.out
							.println("Erreur : Deplacement en dehors des limites de la map.");
				}
			}
		}

		// Si le robot est autre qu'un char, fonctionnement normale de
		// la fonction
		else {
			// Si le dÃƒÂ©placement de 1 n'amÃƒÂ¨ne pas au dehors des bords du
			// plateau
			if (r.getCoord().getLargeur() + mvt.getLargeur() >= 0
					&& r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau.length) {
				// Si le dÃƒÂ©placement n'envoie pas le robot sur un obstacle
				if (!this.plateau[r.getCoord().getLargeur() + mvt.getLargeur()][r
						.getCoord().getHauteur() + mvt.getHauteur()]
						.estObstacle()) {

					this.plateau[r.getCoord().getLargeur()][r.getCoord()
							.getHauteur()].videCase();
					new Deplacement(r, mvt);
					this.plateau[r.getCoord().getLargeur()][r.getCoord()
							.getHauteur()].deplaceSur(r);

				} else {
					// Sinon, message d'ÃƒÂ©rreur et annulation du dÃƒÂ©placement
					System.out
							.println("Erreur : Un obstacle bloque le deplacement, deplacement annule.");
				}
				// Sinon, les limites de la map emÃƒÂªchent le dÃƒÂ©placement
			} else {
				System.out
						.println("Erreur : Les limites de la map empechent le deplacement.");
			}
		}

		// Si le robot se dÃƒÂ©place sur une mine
		this.deplaceSurMine(r);
	}

	/**
	 * Permet de provoquer les dÃƒÂ©gats sur le robot si la cellule sur laquelle
	 * elle se dÃƒÂ©place est une mine
	 * 
	 * @param r
	 *            robot
	 */
	public void deplaceSurMine(Robot r) {
		// Si le robot se dÃƒÂ©place qur une cellule minÃƒÂ©
		if (this.plateau[r.getCoord().getLargeur()][r.getCoord().getHauteur()]
				.contienMine() != 0) {
			// Le robot se prend les dÃƒÂ©gats et la mine disparaÃƒÂ®t
			r.subitMine();
			this.plateau[r.getCoord().getLargeur()][r.getCoord().getHauteur()]
					.setMine(0);
		}
	}
	
	Cellule getCellule(Coordonnees c)
	{
		for (int h = 0; h < this.plateau.length; h++) 
		{
			for (int l = 0; l < this.plateau[h].length; l++) 
			{
				if(this.plateau[l][h].getCoordonnees().equals(c))
				{
					return this.plateau[l][h];
				}
			}
		}
		return null;
	}
}
