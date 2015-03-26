
public abstract class Robot 
{
	private Coordonnees coord;
	private int equipe;
	private int energie;
	
	public Robot(int equipe,int energie) 
	{
		setCoord(new Coordonnees(0, 0));
		this.equipe = equipe;
		this.setEnergie(energie);
	}
	
	/** deplace le robot selon une diréction*/
	abstract void deplacement(int direction);
	
	/**augmente l'energie du robot en base de 2*/
	void regeneration()
	{
		setEnergie(getEnergie() + (this.getCoord().equals(new Coordonnees(0, 0)) ? 2:0));//pour la compréhansion de tous : "identique aux lignes du dessou"
		/*if(this.getCoord().equals(new Coordonnees(0, 0)))
		{
			energie+=2;
		}*/
	}
	
	/**diminue l'energie du robot*/
	abstract void dégat(String cause);
	
	
	/**attaque la cible de coordonnée c*/
	abstract boolean attaque(Coordonnees c);
	
	/**attaque la cible*/
	boolean attaque(Robot cible)
	{
		if(verifier_portée(cible.getCoord()))
		{
			cible.dégat("cible");
			return true;
		}
		
		return false;
	}
	
	abstract protected boolean verifier_portée(Coordonnees c);
	
	public Coordonnees getCoord() 
	{
		return coord;
	}

	public void setCoord(Coordonnees coord) 
	{
		this.coord = coord;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
}
