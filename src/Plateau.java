import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plateau {

	private double pourcentage = 6.66;
	public Cellule[][] plateau;
	private Random Ran = new Random(100);

	public Plateau(int largeur, int hauteur) {
		plateau = new Cellule[largeur][hauteur];

		for (int h = 0; h < plateau.length; h++) {
			for (int l = 0; l < plateau[h].length; l++) {
				plateau[l][h] = new Cellule(l, h);
			}
		}
	}
	
	boolean ya_chemin(Cellule base1)
	{
		List<Cellule> li = new ArrayList<Cellule>();
		for (int h = 0; h < this.plateau.length; h++) 
		{
			for (int l = 0; l < this.plateau[h].length; l++) 
			{
				
				if(!this.plateau[h][l].estObstacle())
				{
					li.add(this.plateau[h][l]);
				}
			}
		}
		
		for (Cellule cellule : li) 
		{
			
			Cellule temp =cellule.getCellule(cellule.getCoordonnees().ajout(Constante.DROIT));
			Cellule vois_droit = cette_case_est_valide(temp) ? temp : cellule;
			
			temp =cellule.getCellule(cellule.getCoordonnees().ajout(Constante.BAS));
			Cellule vois_bas = cette_case_est_valide(temp) ? temp : cellule;
			
			temp =cellule.getCellule(cellule.getCoordonnees().ajout(Constante.GAUCHE));
			Cellule vois_gauche  = cette_case_est_valide(temp) ? temp : cellule;
			
			temp =cellule.getCellule(cellule.getCoordonnees().ajout(Constante.HAUT));
			Cellule vois_haut = cette_case_est_valide(temp) ? temp : cellule;
			
			if(vois_haut.estBase()==Constante.BASE2||vois_bas.estBase()==Constante.BASE2||vois_droit.estBase()==Constante.BASE2||vois_gauche.estBase()==Constante.BASE2)
			{
				return true;
			}
		}
		
		return false;
	}
	
	static private boolean cette_case_est_valide(Cellule c)
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
		return false;//compil auto
	}

	void genere_obstacle()
	{
		for (int h = 0; h < plateau.length; h++) {
			for (int l = 0; l < plateau[h].length; l++) {
				if(plateau[l][h].estBase()==0)
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
	 * Appelle les fonctions qui permettent de modéliser les déplacements. Si
	 * Char = déplacement de 2 ou 1 si bloqué par un obstacles. Sinon =
	 * déplacement de 1.
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
				System.out
						.println("Erreur : Un char ne peut se déplacer diagonalement");
			}
			// Sinon, fonctionnement normal de la fonction
			else {
				// Si le premier déplacement n'amène pas au dehors des bords du
				// plateau
				if (r.getCoord().getLargeur() + mvt.getLargeur() >= 0
						&& r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau.length) {
					// Et si le premier déplacement n'envoie pas le char sur un
					// obstacle
					if (!this.plateau[r.getCoord().getLargeur()
							+ mvt.getLargeur()][r.getCoord().getHauteur()
							+ mvt.getHauteur()].estObstacle()) {

						// 1er déplacement du char
						this.plateau[r.getCoord().getLargeur()][r.getCoord()
								.getHauteur()].videCase();
						new Deplacement(r, mvt);
						this.plateau[r.getCoord().getLargeur()][r.getCoord()
								.getHauteur()].deplaceSur(r);

						// Si le robot se déplace sur une mine
						this.deplaceSurMine(r);

						// 2éme déplacement
						// Si le second déplacement n'amène pas au dehors des
						// bords du
						// plateau
						if (r.getCoord().getLargeur() + mvt.getLargeur() >= 0
								&& r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau.length) {
							// Et si le second déplacement n'envoie pas le char
							// sur un
							// obstacle
							if (!this.plateau[r.getCoord().getLargeur()
									+ mvt.getLargeur()][r.getCoord()
									.getHauteur() + mvt.getHauteur()]
									.estObstacle()) {

								// 2éme déplacement du char
								this.plateau[r.getCoord().getLargeur()][r
										.getCoord().getHauteur()].videCase();
								new Deplacement(r, mvt);
								this.plateau[r.getCoord().getLargeur()][r
										.getCoord().getHauteur()].deplaceSur(r);
							} else {
								// Sinon, un obstacle empêche le second
								// déplacement
								System.out
										.println("Event : Le char a rencontrée un obstacle sur son chemin et a dûs se stopper.");
							}

						} else {
							// Sinon, les limites du plateau empêche le second
							// déplacement
							System.out
									.println("Event : Le char a dûs s'arrêter pour ne pas tomber.");
						}

					} else {
						// Sinon, un obstacle empêche le déplacement
						System.out
								.println("Erreur : Un obstacle bloque le déplacement, déplacement annulée.");
					}

				} else {
					// Sinon, les limites du plateau empêche le déplacement
					System.out
							.println("Erreur : Déplacement en dehors des limites de la map.");
				}
			}
		}

		// Si le robot est autre qu'un char, fonctionnement normale de
		// la fonction
		else {
			// Si le déplacement de 1 n'amène pas au dehors des bords du
			// plateau
			if (r.getCoord().getLargeur() + mvt.getLargeur() >= 0
					&& r.getCoord().getLargeur() + mvt.getLargeur() < this.plateau.length) {
				// Si le déplacement n'envoie pas le robot sur un obstacle
				if (!this.plateau[r.getCoord().getLargeur() + mvt.getLargeur()][r
						.getCoord().getHauteur() + mvt.getHauteur()]
						.estObstacle()) {

					this.plateau[r.getCoord().getLargeur()][r.getCoord()
							.getHauteur()].videCase();
					new Deplacement(r, mvt);
					this.plateau[r.getCoord().getLargeur()][r.getCoord()
							.getHauteur()].deplaceSur(r);

				} else {
					// Sinon, message d'érreur et annulation du déplacement
					System.out
							.println("Erreur : Un obstacle bloque le déplacement, déplacement annulée.");
				}
				// Sinon, les limites de la map emêchent le déplacement
			} else {
				System.out
						.println("Erreur : Les limites de la map empêchent le déplacement.");
			}
		}

		// Si le robot se déplace sur une mine
		this.deplaceSurMine(r);
	}

	/**
	 * Permet de provoquer les dégats sur le robot si la cellule sur laquelle
	 * elle se déplace est une mine
	 * 
	 * @param r
	 *            robot
	 */
	public void deplaceSurMine(Robot r) {
		// Si le robot se déplace qur une cellule miné
		if (this.plateau[r.getCoord().getLargeur()][r.getCoord().getHauteur()]
				.contienMine() != 0) {
			// Le robot se prend les dégats et la mine disparaît
			r.subitMine();
			this.plateau[r.getCoord().getLargeur()][r.getCoord().getHauteur()]
					.setMine(0);
		}
	}

	public static void main(String[] args) {
		Plateau p = new Plateau(10, 10);
		p.plateau[0][0].base = 1;
		p.plateau[9][9].base = 2;
		
		int test =0;
		while(p.ya_chemin(p.plateau[0][0])&&test<50000)
		{
			p.genere_obstacle();
			//System.out.println(test);
			test++;
		}

		Robot t1 = new Piegeur(0, 0);
		// Setter les coordonnées IMPÉRATIVEMENT
		t1.setCoord(new Coordonnees(4, 4));

		p.plateau[t1.getCoord().getLargeur()][t1.getCoord().getHauteur()].deplaceSur(t1);
		
		p.plateau[1][1].cree_Obstacle();
		
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
