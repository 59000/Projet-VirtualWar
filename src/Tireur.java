import java.util.List;

public class Tireur extends Robot {

	List<Coordonnees> coord;
	public Tireur(int equipe,int numero) {/*implÃ©menter*/
		
		/*faire les methodes peutTirer() et getDeplacement()*/
		super(equipe,numero, 40);
	}
	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return Constante.COUTTIRERTIREUR;
	}

	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return Constante.COUTAVANCERTIREUR;
	}

	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return Constante.DEGATTIREUR;
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

	@Override
	public boolean peutTirer(Coordonnees c) {
		// TODO Auto-generated method stub
		Coordonnees resultat = this.getCoord().soustrait(c);
		boolean portee_haute = (resultat.getHauteur() <=Constante.PORTEETIREUR && resultat.getLargeur() == 0) ? true:false;
		boolean portee_basse = (resultat.getHauteur() >=-Constante.PORTEETIREUR && resultat.getLargeur() == 0) ? true:false;
		boolean portee_gauche= (resultat.getLargeur() >=-Constante.PORTEETIREUR && resultat.getHauteur() == 0) ? true:false;
		boolean portee_droite= (resultat.getLargeur() <=Constante.PORTEETIREUR && resultat.getHauteur() == 0) ? true:false;
		
		if (portee_haute||portee_basse||portee_gauche||portee_droite)
		{
			return true;
		}
			return false;

		
	}

}
