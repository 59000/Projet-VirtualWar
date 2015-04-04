public class Char extends Robot {

	public Char(int equipe,int numero) {
		super(equipe,numero, 60);
	}

	/**
	 * direction selon le pavé numérique (5 est le centre) 2 le bas , 8 le haut ...
	 */
	void deplacement(int direction) {
		switch (direction) {
		case 2:
			super.setCoord(super.getCoord().ajout(new Coordonnees(0, -2)));// bas
			break;
		case 4:
			super.setCoord(super.getCoord().ajout(new Coordonnees(-2, 0)));// gauche
			break;
		case 6:
			super.setCoord(super.getCoord().ajout(new Coordonnees(2, super.getCoord().getHauteur())));// droite
			break;
		case 8:
			super.setCoord(super.getCoord().ajout(new Coordonnees(0, 2)));// haut
			break;
		default:

			break;
		}
	}

	protected boolean verifier_portee(Coordonnees c) {
		Coordonnees resultat = super.getCoord().soustrait(c);
		boolean portee_haute = (resultat.getHauteur() <= 10 && resultat.getLargeur() == 0) ? true : false;
		boolean portee_basse = (resultat.getHauteur() >= -10 && resultat.getLargeur() == 0) ? true : false;
		boolean portee_gauche = (resultat.getLargeur() >= -10 && resultat.getHauteur() == 0) ? true : false;
		boolean portee_droite = (resultat.getLargeur() <= 10 && resultat.getHauteur() == 0) ? true : false;

		if (portee_haute || portee_basse || portee_gauche || portee_droite) {
			return true;
		}
		return false;
	}

	@Override
	void degat(String cause) {
		switch (cause) {
		case "attaque":
			super.setEnergie(super.getEnergie() - 1);
			break;
		case "cible":
			super.setEnergie(super.getEnergie() - 6);
			break;
		case "avance":
			super.setEnergie(super.getEnergie() - 5);
			break;

		default:
			break;
		}
	}

	@Override
	boolean attaque(Coordonnees c) {
		if (verifier_portee(c)) {

			return true;
		}

		return false;
	}

}
