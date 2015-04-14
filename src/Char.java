import java.util.List;

public class Char extends Robot {/*implÃ©menter*/

<<<<<<< HEAD
	List<Coordonnees> coord;
=======
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	/*faire les methodes peutTirer() et getDeplacement()*/
	public Char(int equipe,int numero) {
		super(equipe,numero, Constante.ENERGIECHAR);
	}

	@Override
<<<<<<< HEAD
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
=======
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		return false;
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	}

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
<<<<<<< HEAD
		return coord;
=======
		return null;
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	}
}
