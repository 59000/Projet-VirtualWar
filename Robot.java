public abstract class Robot 
{
	private Coordonnees coord;
	private int equipe;
	private int energie;
	
	public Robot(int equipe,int energie) 
	{
		setCoord(new Coordonnees(0, 0));
		this.equipe = equipe;
		this.energie = energie;
	}
	
	/** deplace le robot selon une diréction*/
	abstract void deplacement(int direction);
	
	/**augmente l'energie du robot en base de 2*/
	void regeneration()
	{
		energie += this.getCoord().equals(new Coordonnees(0, 0)) ? 2:0;
		/*if(this.getCoord().equals(new Coordonnees(0, 0)))
		{
			energie+=2;
		}*/
	}
	
	/**diminue l'energie du robot*/
	void dégat(int valeur)
	{
		energie -= valeur;
	}
	
	/**attaque la cible de coordonnée c*/
	abstract boolean attaque(Coordonnees c);

	public Coordonnees getCoord() 
	{
		return coord;
	}

	public void setCoord(Coordonnees coord) 
	{
		this.coord = coord;
	}
	
}
