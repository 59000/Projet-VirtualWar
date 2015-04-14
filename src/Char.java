import java.util.List;

public class Char extends Robot {/*implÃ©menter*/

	List<Coordonnees> coord;
	/*faire les methodes peutTirer() et getDeplacement()*/
	public Char(int equipe,int numero) {
		super(equipe,numero, Constante.ENERGIECHAR);
	}

	@Override
	public boolean peutTirer(Coordonnees c) {
		// TODO Auto-generated method stub
		Coordonnees resultat =  super.getCoord().soustrait(c);
		boolean portee_haute = (resultat.getHauteur() <=Constante.PORTEECHAR && resultat.getLargeur() == 0) ? true:false;
		boolean portee_basse = (resultat.getHauteur() >=-Constante.PORTEECHAR && resultat.getLargeur() == 0) ? true:false;
		boolean portee_gauche= (resultat.getLargeur() >=-Constante.PORTEECHAR && resultat.getHauteur() == 0) ? true:false;
		boolean portee_droite= (resultat.getLargeur() <=Constante.PORTEECHAR && resultat.getHauteur() == 0) ? true:false;
		
		if (portee_haute||portee_basse||portee_gauche||portee_droite)
		{
			return true;
		}
			return false;
			

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return Constante.COUTTIRERCHAR;
	}

	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return Constante.COUTAVANCERCHAR;
	}

	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return Constante.DEGATCHAR;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Coordonnees> getDeplacement() {
		// TODO Auto-generated method stub
		return coord;

	}
}
