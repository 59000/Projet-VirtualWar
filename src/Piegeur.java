import java.util.List;

public class Piegeur extends Robot {/*implÃƒÂ©menter*/
	/**@param coord */
	private List<Coordonnees> coord;
	/**@param NBMINE */
	int nbMine = Constante.NBMINE;
	/*faire les methodes peutTirer() et getDeplacement()*/
	/**Crée un Robot piegeur avec son numéro et son equipe */
	public Piegeur(int equipe,int numero) {
		super(equipe,numero, Constante.ENERGIEPIEGEUR);
	}
	/**Teste si le robot peut poser une mine sur une certaine cellule*/
	@Override
	public boolean peutTirer(Coordonnees c) {
		// TODO Auto-generated method stub
		Coordonnees resultat = this.getCoord().soustrait(c);
		boolean portee_haute = (resultat.getHauteur() <=Constante.PORTEEPIEGEUR && resultat.getLargeur() == 0) ? true:false;
		boolean portee_basse = (resultat.getHauteur() >=-Constante.PORTEEPIEGEUR && resultat.getLargeur() == 0) ? true:false;
		boolean portee_gauche= (resultat.getLargeur() >=-Constante.PORTEEPIEGEUR && resultat.getHauteur() == 0) ? true:false;
		boolean portee_droite= (resultat.getLargeur() <=Constante.PORTEEPIEGEUR && resultat.getHauteur() == 0) ? true:false;
		
		if (portee_haute||portee_basse||portee_gauche||portee_droite)
		{
			return true;
		}
			return false;
	}
	/**Retourne le cout pour poser une mine */
	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return Constante.COUTMINER;
	}
	/**Retourne le cout pour se deplacer*/
	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return Constante.COUTAVANCERPIEGEUR;
	}
	/**@return 0 */
	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**Retourne les degats des mines du piegeur */
	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return Constante.DEGATPIEGEUR;
	}
	/**Retourne l'ensemble des deplacements pour acceder a une coordonnées
	 * @return coord;
	 *  */
	@Override
	public List<Coordonnees> getDeplacement() {
		// TODO Auto-generated method stub
		return coord;
	}
	/**Regeneration de la sante et des mines pour le piegeur */
	void regeneration(){
		super.regeneration();
		nbMine = Constante.NBMINE;
	}
	public String toString(){
		return "Piegeur" +super.toString()+"mines="+nbMine;
	}
}
