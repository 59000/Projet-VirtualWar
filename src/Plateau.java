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
	 * Appelle les fonctions qui permettent de modÃƒÆ’Ã‚Â©liser les dÃƒÆ’Ã‚Â©placements. Si
	 * Char = dÃƒÆ’Ã‚Â©placement de 2 ou 1 si bloquÃƒÆ’Ã‚Â© par un obstacles. Sinon =
	 * dÃƒÆ’Ã‚Â©placement de 1.
	 * 
	 * Si le robot arrive sur une mine, il se prend les dÃƒÆ’Ã‚Â©gats.
	 * 
	 * @param t1
	 *            robot
	 * @param mvt
	 *            Constante de dÃƒÆ’Ã‚Â©placement
	 */
	public void deplaceRobot(Robot r, Coordonnees mvt) {
		// Si le robot est un Char
		if (r instanceof Char) {
			// Et que le mouvement demandÃƒÆ’Ã‚Â©e est un mouvement diagonales
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
					// Si le premier deplacement n'amene pas au dehors des bords du plateau
				if ((r.getCoord().getLargeur() + mvt.getLargeur() >= 0 && r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau[0].length)
						&&(r.getCoord().getHauteur() + mvt.getHauteur() >= 0 && r.getCoord().getHauteur() + mvt.getHauteur() < this.plateau.length)) {
					// Et si le premier dÃƒÆ’Ã‚Â©placement n'envoie pas le char sur un
					// obstacle
					if (!this.plateau[r.getCoord().getLargeur()+ mvt.getLargeur()][r.getCoord().getHauteur()+ mvt.getHauteur()].estObstacle()) {

						// 1er dÃƒÆ’Ã‚Â©placement du char
						this.plateau[r.getCoord().getLargeur()][r.getCoord()
								.getHauteur()].videCase();
						new Deplacement(r, mvt);
						this.plateau[r.getCoord().getLargeur()][r.getCoord()
								.getHauteur()].deplaceSur(r);

						// Si le robot se dÃƒÆ’Ã‚Â©place sur une mine
						this.deplaceSurMine(r);

						// 2eme deplacement
						// Si le second deplacement n'amene pas au dehors des bords du plateau
						if ((r.getCoord().getLargeur() + mvt.getLargeur() >= 0 && r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau[0].length)
								&&(r.getCoord().getHauteur() + mvt.getHauteur() >= 0 && r.getCoord().getHauteur() + mvt.getHauteur() < this.plateau.length)) {
							// Et si le second deplacement n'envoie pas le char
							// sur un
							// obstacle
							if (!this.plateau[r.getCoord().getLargeur()+ mvt.getLargeur()][r.getCoord().getHauteur() + mvt.getHauteur()].estObstacle()) 
							{

								// 2ÃƒÆ’Ã‚Â©me dÃƒÆ’Ã‚Â©placement du char
								this.plateau[r.getCoord().getLargeur()][r
										.getCoord().getHauteur()].videCase();
								new Deplacement(r, mvt);
								this.plateau[r.getCoord().getLargeur()][r
										.getCoord().getHauteur()].deplaceSur(r);
							} else {
								// Sinon, un obstacle empeche le second
								// deplacement
								System.out
										.println("Event : Le char a rencontre un obstacle sur son chemin et a du se stopper.");
							}

						} else {
							// Sinon, les limites du plateau empÃƒÆ’Ã‚Âªche le second
							// deplacement
							System.out
									.println("Event : Le char a du s'arreter pour ne pas fuir.");
						}

					} else {
						// Sinon, un obstacle empÃƒÆ’Ã‚Âªche le dÃƒÆ’Ã‚Â©placement
						System.out
								.println("Erreur : Un obstacle bloque le deplacement, deplacement annule.");
					}

				} else {
					// Sinon, les limites du plateau empÃƒÆ’Ã‚Âªche le dÃƒÆ’Ã‚Â©placement
					System.out
							.println("Erreur : Deplacement en dehors des limites de la map.");
				}
			}
		}

		// Si le robot est autre qu'un char, fonctionnement normale de
		// la fonction
		else {
			// Si le dÃƒÆ’Ã‚Â©placement de 1 n'amÃƒÆ’Ã‚Â¨ne pas au dehors des bords du
			// plateau
			if ((r.getCoord().getLargeur() + mvt.getLargeur() >= 0 && r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau[0].length)
					&&(r.getCoord().getHauteur() + mvt.getHauteur() >= 0 && r.getCoord().getHauteur() + mvt.getHauteur() < this.plateau.length)) {
				// Si le dÃƒÆ’Ã‚Â©placement n'envoie pas le robot sur un obstacle
				if (!this.plateau[r.getCoord().getLargeur() + mvt.getLargeur()][r
						.getCoord().getHauteur() + mvt.getHauteur()]
						.estObstacle()) {

					this.plateau[r.getCoord().getLargeur()][r.getCoord()
							.getHauteur()].videCase();
					new Deplacement(r, mvt);
					this.plateau[r.getCoord().getLargeur()][r.getCoord()
							.getHauteur()].deplaceSur(r);

				} else {
					// Sinon, message d'ÃƒÆ’Ã‚Â©rreur et annulation du dÃƒÆ’Ã‚Â©placement
					System.out
							.println("Erreur : Un obstacle bloque le deplacement, deplacement annule.");
				}
				// Sinon, les limites de la map emÃƒÆ’Ã‚Âªchent le dÃƒÆ’Ã‚Â©placement
			} else {
				System.out
						.println("Erreur : Les limites de la map empechent le deplacement.");
			}
		}

		// Si le robot se dÃƒÆ’Ã‚Â©place sur une mine
		this.deplaceSurMine(r);
	}

	/**
	 * Permet de provoquer les dÃƒÆ’Ã‚Â©gats sur le robot si la cellule sur laquelle
	 * elle se dÃƒÆ’Ã‚Â©place est une mine
	 * 
	 * @param r
	 *            robot
	 */
	public void deplaceSurMine(Robot r) {
		// Si le robot se deplace qur une cellule mine'
		if (this.plateau[r.getCoord().getLargeur()][r.getCoord().getHauteur()]
				.contienMine() != 0) {
			// Le robot se prend les degats et la mine disparaet
			r.subitMine();
			this.plateau[r.getCoord().getLargeur()][r.getCoord().getHauteur()].setMine(0);
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
	
	public boolean tir_travers_obstacle(Robot attaquant,Robot cible)
	{
		int porte_attaquant = (attaquant instanceof Tireur) ?Constante.PORTEETIREUR : Constante.PORTEECHAR;
		Coordonnees variables;
		if(attaquant.getCoord().getLargeur()==cible.getCoord().getLargeur())
		{
			if(attaquant.getCoord().getHauteur()<cible.getCoord().getHauteur())//bas
			{
				for (int i = 1; i <= porte_attaquant; i++) 
				{
					variables = new Coordonnees(attaquant.getCoord().getHauteur()+i, attaquant.getCoord().getLargeur());
					if(this.getCellule(variables).estObstacle() || this.getCellule(variables).getContenu()!=null)
					{
						return true;
					}
				}
			}
			else if(attaquant.getCoord().getHauteur()>cible.getCoord().getLargeur())//haut
			{
				for (int i = 1; i <= porte_attaquant; i++) 
				{
					variables = new Coordonnees(attaquant.getCoord().getHauteur()-i, attaquant.getCoord().getLargeur());
					if(this.getCellule(variables).estObstacle() || this.getCellule(variables).getContenu()!=null)
					{
						return true;
					}
				}
			}
		}
		else
		{
			if(attaquant.getCoord().getLargeur()<cible.getCoord().getLargeur())//droite
			{
				for (int i = 1; i <= porte_attaquant; i++) 
				{
					variables = new Coordonnees(attaquant.getCoord().getHauteur(), attaquant.getCoord().getLargeur()+i);
					if(this.getCellule(variables).estObstacle() || this.getCellule(variables).getContenu()!=null)
					{
						return true;
					}
				}
			}
			else if(attaquant.getCoord().getLargeur()>cible.getCoord().getLargeur())//gauche
			{
				for (int i = 1; i <= porte_attaquant; i++) 
				{
					variables = new Coordonnees(attaquant.getCoord().getHauteur(), attaquant.getCoord().getLargeur()-i);
					if(this.getCellule(variables).estObstacle() || this.getCellule(variables).getContenu()!=null)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
