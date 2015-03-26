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
	
	/**augmente l'energie du robot en base*/
	abstract void regeneration();
	
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
