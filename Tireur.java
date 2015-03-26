public class Tireur extends Robot 
{

	public Tireur(int equipe) 
	{
		super(equipe, 40);
	}

	/**
	 * diréction de 1 a 9 (1 en bas a droite,9 en haut a gauche) comme sur un
	 * pavé numérique
	 */
	void deplacement(int direction) 
	{
		switch (direction) 
		{
			case 1:
				super.getCoord().ajout(new Coordonnees(-1, -1));// bas gauche
			break;
			case 2:
				super.getCoord().ajout(new Coordonnees(0, -1));// bas
			break;
			case 3:
				super.getCoord().ajout(new Coordonnees(1, -1));// bas droite
			break;
			case 4:
				super.getCoord().ajout(new Coordonnees(-1, 0));// gauche
			break;
			case 6:
				super.getCoord().ajout(new Coordonnees(1, 0));// droite
			break;
			case 7:
				super.getCoord().ajout(new Coordonnees(-1, 1));// haut gauche
			break;
			case 8:
				super.getCoord().ajout(new Coordonnees(0, 1));// haut
			break;
			case 9:
				super.getCoord().ajout(new Coordonnees(1, 1));// haut droite
			break;

		default:

			break;
		}
	}

		
	protected boolean verifier_portée(Coordonnees c)
	{
		Coordonnees resultat = super.getCoord().soustrait(c);
		boolean portée_haute = (resultat.getHauteur() <=3 && resultat.getLargeur() == 0) ? true:false;
		boolean portée_basse = (resultat.getHauteur() >=-3 && resultat.getLargeur() == 0) ? true:false;
		boolean portée_gauche= (resultat.getLargeur() >=-3 && resultat.getHauteur() == 0) ? true:false;
		boolean portée_droite= (resultat.getLargeur() <=3 && resultat.getHauteur() == 0) ? true:false;
		
		if (portée_haute||portée_basse||portée_gauche||portée_droite)
		{
			return true;
		}
			return false;
	}

	@Override
	void dégat(String cause) 
	{
		switch (cause) 
		{
			case "attaque":
				super.setEnergie(super.getEnergie()-2);
			break;
			case "cible":
				super.setEnergie(super.getEnergie()-3);
			break;
			case "avance":
				super.setEnergie(super.getEnergie()-1);
			break;

		default:
			break;
		}
	}

	@Override
	boolean attaque(Coordonnees c) 
	{
		return false;
	}

}
