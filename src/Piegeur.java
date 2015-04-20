package Robot;
import java.util.List;

import Constante.Constante;
import Plateau.Cellule;
import Plateau.Coordonnees;

public class Piegeur extends Robot {
	/**@param coord */
	private List<Coordonnees> coord;
	/**@param NBMINE */
	public int nbMine = Constante.NBMINE;
	/*faire les methodes peutTirer() et getDeplacement()*/
	/**Cree un Robot piegeur avec son numero et son equipe */
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
	/**Retourne l'ensemble des deplacements pour acceder a une coordonnees
	 * @return coord;
	 *  */
	@Override
	public List<Coordonnees> getDeplacement() {
		// TODO Auto-generated method stub
		return coord;
	}
	/**Regeneration de la sante et des mines pour le piegeur */
	public void regeneration(Cellule[][] p){
		super.regeneration(p);
		nbMine = Constante.NBMINE;
	}
	public String toString(){
		return "Piegeur" +super.toString()+" mines="+nbMine;
	}
}
