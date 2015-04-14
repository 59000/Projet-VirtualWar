import java.util.List;

public abstract class Robot {
	/* implÃ©menter les fonctions prÃ©sentes */
	/**@param coord */
	protected Coordonnees coord;
	/**@param equipe */
	protected int equipe;
	/**@param energie */
	protected int energie;
	/**@param numero */
	protected final int numero;
	/**@param cellule*/
	Cellule cellule;

	/**Cree un robot avec equipe, numero et energie
	 * 
	 * @param equipe
	 * @param numero
	 * @param energie
	 */
	public Robot(int equipe, int numero, int energie) {
		setCoord(new Coordonnees(0, 0));
		this.setEquipe(equipe);
		this.setEnergie(energie);
		this.numero = numero;
	}

	/** augmente l'energie du robot en base de 2 */
	void regeneration() {
		if(cellule.estBase(this.getCoord())==this.equipe){
			setEnergie(Constante.REGENENBASE);
		}
	}	
	/**@return coord*/
	public Coordonnees getCoord() {
		return coord;
	}
	/**Met les coordonnees placees en parametre*/
	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}
	/**@return energie*/
	public int getEnergie() {
		return energie;
	}
	/**Met l'energie placee en parametre*/
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	/**@return equipe*/
	public int getEquipe() {
		return equipe;
	}
	/**Met l'equipe placee en parametre */
	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
	/**@return numero*/
	public int getNumero() {
		return numero;
	}

	abstract public boolean peutTirer(Coordonnees c);

	abstract public int getCoutAction();

	abstract public int getCoutDep();

	abstract public int getDegatTir();

	abstract public int getDegatMine();

	abstract public List<Coordonnees> getDeplacement();

	@Override
	public String toString() {
		return "Robot [coord=" + coord + ", equipe=" + equipe + ", numero="
				+ numero + ", energie=" + energie + "]";
	}
	/**Gere la perte de point de vie du robot par des tirs */
	public void subitTir(Robot robot) {
		if (robot instanceof Char) {
			setEnergie(getEnergie() - Constante.DEGATCHAR);
		} else if (robot instanceof Tireur) {
			setEnergie(getEnergie() - Constante.DEGATTIREUR);
		}
	}
	/**Gere la perte de point de vie du robot par des mines */
	public void subitMine() {
		setEnergie(getEnergie() - Constante.DEGATPIEGEUR);
	}

}
