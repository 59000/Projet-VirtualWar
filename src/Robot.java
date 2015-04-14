import java.util.List;

public abstract class Robot {
	/* implÃ©menter les fonctions prÃ©sentes */

	protected Coordonnees coord;
	protected int equipe;
	protected int energie;
	protected final int numero;// le numero qui identifie le robot dans l'Ã©quipe
	Cellule cellule;

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

	public void subitTir(Robot robot) {
		if (robot instanceof Char) {
			setEnergie(getEnergie() - Constante.DEGATCHAR);
		} else if (robot instanceof Tireur) {
			setEnergie(getEnergie() - Constante.DEGATTIREUR);
		}
	}

	public void subitMine() {
		setEnergie(getEnergie() - Constante.DEGATPIEGEUR);
	}

}
