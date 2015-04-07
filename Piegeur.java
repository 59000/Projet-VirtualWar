
public class Piegeur extends Robot {
	/*Supprimer les methdes inutiles et utiliser les methodes des classes attaques et deplacement*/
	public Piegeur(int equipe,int numero) {
		super(equipe,numero, 50);
	}

	/**
	 * direction comme sur la pavé numérique (5 est le centre) 2 le bas , 8 le haut ...
	 */
	void deplacement(int direction) {
		switch (direction) {
		case 1:
			super.setCoord(super.getCoord().ajout(new Coordonnees(-1, -1)));// bas gauche
			break;
		case 2:
			super.setCoord(super.getCoord().ajout(new Coordonnees(0, -1)));// bas
			break;
		case 3:
			super.setCoord(super.getCoord().ajout(new Coordonnees(1, -1)));// bas droite
			break;
		case 4:
			super.setCoord(super.getCoord().ajout(new Coordonnees(-1, 0)));// gauche
			break;
		case 6:
			super.setCoord(super.getCoord().ajout(new Coordonnees(1, 0)));// droite
			break;
		case 7:
			super.setCoord(super.getCoord().ajout(new Coordonnees(-1, 1)));// haut gauche
			break;
		case 8:
			super.setCoord(super.getCoord().ajout(new Coordonnees(0, 1)));// haut
			break;
		case 9:
			super.setCoord(super.getCoord().ajout(new Coordonnees(1, 1)));// haut droite
			break;
			
		default:

			break;
		}
	}

	/** verifie si l'ennemi est a portee de tir */
	protected boolean verifier_portee(Coordonnees c) {
		Coordonnees resultat = super.getCoord().soustrait(c);
		boolean portee_haute = (resultat.getHauteur() <= 1 && resultat.getLargeur() == 0) ? true : false;
		boolean portee_basse = (resultat.getHauteur() >= -1 && resultat.getLargeur() == 0) ? true : false;
		boolean portee_gauche = (resultat.getLargeur() >= -1 && resultat.getHauteur() == 0) ? true : false;
		boolean portee_droite = (resultat.getLargeur() <= 1 && resultat.getHauteur() == 0) ? true : false;

		if (portee_haute || portee_basse || portee_gauche || portee_droite) {
			return true;
		}
		return false;
	}

	@Override
	void degat(String cause) {
		switch (cause) {
		case "attaque":
			super.setEnergie(super.getEnergie() - 2);
			break;
		case "cible":
			super.setEnergie(super.getEnergie() - 2);
			break;
		case "avance":
			super.setEnergie(super.getEnergie() - 2);
			break;

		default:
			break;
		}
	}

	@Override
	boolean attaque(Coordonnees c) {
		if (verifier_portee(c)) {
			// mettre une mine sur la case c;
			return true;
		}
		return false;
	}
}
