import java.util.List;

public class Char extends Robot {

	/** @param coord */
	List<Coordonnees> coord;

	/* faire les methodes peutTirer() et getDeplacement() */

	/**
	 * Cree un Robot Char avec son numero et son equipe
	 * 
	 * @param equipe
	 * @param numero
	 */
	public Char(int equipe, int numero) {
		super(equipe, numero, Constante.ENERGIECHAR);
	}

	/** Teste si le robot peut tirer sur une certaine cellule */
	@Override
	public boolean peutTirer(Coordonnees c) {
		// TODO Auto-generated method stub
		Coordonnees resultat = this.getCoord().soustrait(c);
		boolean portee_haute = (resultat.getHauteur() <= Constante.PORTEECHAR
				&& resultat.getLargeur() == 0 && c.getHauteur() < this
				.getCoord().getHauteur()) ? true : false;
		boolean portee_basse = (resultat.getHauteur() >= -Constante.PORTEECHAR
				&& resultat.getLargeur() == 0 && c.getHauteur() > this
				.getCoord().getHauteur()) ? true : false;
		boolean portee_gauche = (resultat.getLargeur() <= Constante.PORTEECHAR
				&& resultat.getHauteur() == 0 && c.getLargeur() < this
				.getCoord().getLargeur()) ? true : false;
		boolean portee_droite = (resultat.getLargeur() >= -Constante.PORTEECHAR
				&& resultat.getHauteur() == 0 && c.getLargeur() > this
				.getCoord().getLargeur()) ? true : false;

		if (portee_haute || portee_basse || portee_gauche || portee_droite) {

			return true;
		}
		return false;

	}

	/** Retourne le cout d'action du char */
	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return Constante.COUTTIRERCHAR;
	}

	/** Retourne le cout de deplacement du char */
	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return Constante.COUTAVANCERCHAR;
	}

	/** Retourne les degats du char */
	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return Constante.DEGATCHAR;
	}

	/** @return 0 */
	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Retourne l'ensemble des deplacements pour acceder a une coordonnÃ©es
	 * 
	 * @return coord;
	 * */
	@Override
	public List<Coordonnees> getDeplacement() {
		// TODO Auto-generated method stub
		return coord;

	}

	@Override
	public String toString() {
		return "Char   " + super.toString();
	}

}
