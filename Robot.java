public abstract class Robot {
	private Coordonnees coord;
	private int equipe;
	private int energie;

	public Robot(int equipe, int energie) {
		setCoord(new Coordonnees(0, 0));
		this.setEquipe(equipe);
		this.setEnergie(energie);
	}

	/** deplace le robot selon une direction */
	abstract void deplacement(int direction);

	/** augmente l'énergie du robot de 2 en 2 */
	void regeneration() {
		setEnergie(getEnergie()
				+ (this.getCoord().equals(new Coordonnees(0, 0)) ? 2 : 0));
		// pour la compréhension de tous : "identique aux lignes du dessous"

		/*
		 * if(this.getCoord().equals(new Coordonnees(0, 0))) { energie+=2; }
		 */
	}

	/** diminue l'energie du robot */
	abstract void dégat(String cause);

	/** attaque la cible de coordonnée c (pour piégeur) */
	abstract boolean attaque(Coordonnees c);

	/** attaque la cible (pour tireur,char) */
	boolean attaque(Robot cible) {
		if (verifier_portée(cible.getCoord())) {
			cible.dégat("cible");
			return true;
		}

		return false;
	}
	
	/** vérifie si le robot a la portée nécessaire pour tirer */
	abstract protected boolean verifier_portée(Coordonnees c);

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
	
}
