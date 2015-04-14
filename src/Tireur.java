import java.util.List;

public class Tireur extends Robot {

<<<<<<< HEAD
	List<Coordonnees> coord;
=======
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	public Tireur(int equipe,int numero) {/*implÃ©menter*/
		
		/*faire les methodes peutTirer() et getDeplacement()*/
		super(equipe,numero, 40);
	}

	@Override
<<<<<<< HEAD
=======
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
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
<<<<<<< HEAD
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
=======
		return null;
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	}

}
