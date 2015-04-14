import java.util.List;


<<<<<<< HEAD
public class Piegeur extends Robot {/*implÃ©menter*/
=======
public class Piegeur extends Robot {/*implÃƒÂ©menter*/
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	
	private List<Coordonnees> coord;
	int nbMine = Constante.NBMINE;
	/*faire les methodes peutTirer() et getDeplacement()*/
	public Piegeur(int equipe,int numero) {
		super(equipe,numero, 50);
	}

	@Override
<<<<<<< HEAD
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
=======
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		
		return false;
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	}

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return Constante.COUTMINER;
	}

	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return Constante.COUTAVANCERPIEGEUR;
	}

	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return Constante.DEGATPIEGEUR;
	}

	@Override
	public List<Coordonnees> getDeplacement() {
		// TODO Auto-generated method stub
		return coord;
	}
	
	void regeneration(){
		super.regeneration();
		nbMine = Constante.NBMINE;
	}
}
