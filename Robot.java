public abstract class Robot {
	/*Supprimer les methodes inutiles et Rajouter les methodes abstract de l'uml sauf getType ainsi que les void  */
	
	private Coordonnees coord;
	private int equipe;
	private int energie;
	private final int numero;//le numero qui identifie le robot dans l'équipe

	public Robot(int equipe,int numero, int energie) {
		setCoord(new Coordonnees(0, 0));
		this.setEquipe(equipe);
		this.setEnergie(energie);
		this.numero=numero;
	}

	/** deplace le robot selon une direction */
	//enlever cette fonction dans les classes filles 
	abstract void deplacement(int direction);

	/** augmente l'energie du robot en base de 2 */
	//ajouter l'enregie avec la constante REGENENBASE
	void regeneration() {
		setEnergie(getEnergie()
				+ (this.getCoord().equals(new Coordonnees(0, 0)) ? 2 : 0));
	
	}

	/** diminue l'energie du robot */
	//enlever cette fonction dans les classes filles 
	abstract void degat(String cause);

	/** attaque la cible de coordonnee c (pour piegeur) */
	//enlever cette fonction dans les classes filles 
	abstract boolean attaque(Coordonnees c);

	/** attaque la cible (pour tireur,char) */
	//enlever cette fonction dans les classes filles 
	boolean attaque(Robot cible) {
		if (verifier_portee(cible.getCoord())) {
			cible.degat("cible");
			return true;
		}

		return false;
	}
	//Enlever cette fonction dans les classe filles 
	abstract protected boolean verifier_portee(Coordonnees c);

	public Coordonnees getCoord() {
		return coord;
	}

	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	public int getNumero() 
	{
		return numero;
	}
	abstrat public boolean peutTirer();
	abstract public int getCoutAction();
	abstract public int getCoutDep();
	abstract public int getDegatTir();
	abstract public int getDegatMine();
	abstract public List<Coordonnees> getDeplacement();
	
	public String toString(){
		return null;
	}
	public void subitTir(){
		
	}
	public void subitMine(){
		
	}

}
