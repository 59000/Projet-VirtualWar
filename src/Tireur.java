import java.util.List;

public class Tireur extends Robot {
	/** @param coord */
	List<Coordonnees> coord;

	/**
	 * Cree un Tireur avec une equipe et un numero
	 * 
	 * @param equipe
	 * @param numero
	 */
	public Tireur(int equipe, int numero) {

		super(equipe, numero, Constante.ENERGIETIREUR);
	}

	/** Retourne le cout d'action du tireur */
	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return Constante.COUTTIRERTIREUR;
	}

	/** Retourne le cout du deplacement */
	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return Constante.COUTAVANCERTIREUR;
	}

	/** Retourne le nombre de degat du tireur */
	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return Constante.DEGATTIREUR;
	}

	/** @return 0 */
	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Retourne l'ensemble des deplacements pour acceder a une coordonnees
	 * 
	 * @return coord;
	 * */
	@Override
	public List<Coordonnees> getDeplacement() {
		// TODO Auto-generated method stub
		return coord;
	}

	/** Teste si le robot peut tirer sur une cellule */
	@Override
	public boolean peutTirer(Coordonnees c) {
		// TODO Auto-generated method stub
		Coordonnees resultat = this.getCoord().soustrait(c);
		boolean portee_haute = (resultat.getHauteur() <= Constante.PORTEETIREUR
				&& resultat.getLargeur() == 0 && c.getHauteur() < this
				.getCoord().getHauteur()) ? true : false;
		boolean portee_basse = (resultat.getHauteur() >= -Constante.PORTEETIREUR
				&& resultat.getLargeur() == 0 && c.getHauteur() > this
				.getCoord().getHauteur()) ? true : false;
		boolean portee_gauche = (resultat.getLargeur() <= Constante.PORTEETIREUR
				&& resultat.getHauteur() == 0 && c.getLargeur() < this
				.getCoord().getLargeur()) ? true : false;
		boolean portee_droite = (resultat.getLargeur() >= -Constante.PORTEETIREUR
				&& resultat.getHauteur() == 0 && c.getLargeur() > this
				.getCoord().getLargeur()) ? true : false;

		if (portee_haute || portee_basse || portee_gauche || portee_droite) {

			return true;
		}
		return false;

	}

	public String toString() {
		return "Tireur " + super.toString()+"         ";
	}

}
