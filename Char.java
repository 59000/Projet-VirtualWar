
public class Char extends Robot
{

	public Char(int equipe) 
	{
		super(equipe, 60);
	}

	/**
	 * diréction de 2 a 8 (2 en bas,8 en haut) comme sur un
	 * pavé numérique
	 */
	void deplacement(int direction) 
	{
		switch (direction) 
		{
			case 2:
				super.getCoord().ajout(new Coordonnees(0, -2));// bas
			break;
			case 4:
				super.getCoord().ajout(new Coordonnees(-2, 0));// gauche
			break;
			case 6:
				super.getCoord().ajout(new Coordonnees(2, 0));// droite
			break;
			case 8:
				super.getCoord().ajout(new Coordonnees(0, 2));// haut
			break;
		default:

			break;
		}
	}

		
	protected boolean verifier_portée(Coordonnees c)
	{
		Coordonnees resultat = super.getCoord().soustrait(c);
		boolean portée_haute = (resultat.getHauteur() <=10 && resultat.getLargeur() == 0) ? true:false;
		boolean portée_basse = (resultat.getHauteur() >=-10 && resultat.getLargeur() == 0) ? true:false;
		boolean portée_gauche= (resultat.getLargeur() >=-10 && resultat.getHauteur() == 0) ? true:false;
		boolean portée_droite= (resultat.getLargeur() <=10 && resultat.getHauteur() == 0) ? true:false;
		
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
				super.setEnergie(super.getEnergie()-1);
			break;
			case "cible":
				super.setEnergie(super.getEnergie()-6);
			break;
			case "avance":
				super.setEnergie(super.getEnergie()-5);
			break;

		default:
			break;
		}
	}

	@Override
	boolean attaque(Coordonnees c) 
	{
		if(verifier_portée(c))
		{
			//metre une mine sur la case c;
			return true;
		}
		
		return false;
	}

}
