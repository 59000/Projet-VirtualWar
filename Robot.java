public abstract class Robot {
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
	abstract void deplacement(int direction);

	/** augmente l'energie du robot en base de 2 */
	void regeneration() {
		setEnergie(getEnergie()
				+ (this.getCoord().equals(new Coordonnees(0, 0)) ? 2 : 0));
		// pour la comprehension de tous : "identique aux lignes du dessous"

		/*
		 * if(this.getCoord().equals(new Coordonnees(0, 0))) { energie+=2; }
		 */
	}

	/** diminue l'energie du robot */
	abstract void degat(String cause);

	/** attaque la cible de coordonnee c (pour piegeur) */
	abstract boolean attaque(Coordonnees c);

	/** attaque la cible (pour tireur,char) */
	boolean attaque(Robot cible) {
		if (verifier_portee(cible.getCoord())) {
			cible.degat("cible");
			return true;
		}

		return false;
	}

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

}
