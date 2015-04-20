import java.util.List;

public abstract class Robot {

	/** @param coord */
	protected Coordonnees coord;
	/** @param equipe */
	protected int equipe;
	/** @param energie */
	protected int energie;
	/** @param numero */
	protected final int numero;
	/** @param cellule */
	protected Cellule cellule;

	/**
	 * Cree un robot avec equipe, numero et energie
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
	public void regeneration(Cellule[][] p) {
		if (this instanceof Char) {
			if (p[this.getCoord().getLargeur()][this.getCoord().getHauteur()]
					.estBase(this.getCoord()) == this.equipe
					&& getEnergie() < Constante.ENERGIECHAR) {
				setEnergie(getEnergie() + Constante.REGENENBASE);
			}
		} else if (this instanceof Tireur) {
			if (p[this.getCoord().getLargeur()][this.getCoord().getHauteur()]
					.estBase(this.getCoord()) == this.equipe
					&& getEnergie() < Constante.ENERGIETIREUR) {
				setEnergie(getEnergie() + Constante.REGENENBASE);
			}
		} else if (this instanceof Piegeur){
			if (p[this.getCoord().getLargeur()][this.getCoord().getHauteur()]
					.estBase(this.getCoord()) == this.equipe
					&& getEnergie() < Constante.ENERGIEPIEGEUR) {
				setEnergie(getEnergie() + Constante.REGENENBASE);
			}
		}
	}
	

	/** @return coord */
	public Coordonnees getCoord() {
		return coord;
	}

	/** Met les coordonnees placees en parametre */
	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}

	/** @return energie */
	public int getEnergie() {
		return energie;
	}

	/** Met l'energie placee en parametre */
	public void setEnergie(int energie) {
		this.energie = energie;
	}

	/** @return equipe */
	public int getEquipe() {
		return equipe;
	}

	/** Met l'equipe placee en parametre */
	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	/** @return numero */
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
		String s;
		if (energie < 10) {
			s = " [coord=" + coord + ", equipe=" + equipe + ", numero="
					+ numero + ", energie=" + energie + " ]";
		} else {
			s = " [coord=" + coord + ", equipe=" + equipe + ", numero="
					+ numero + ", energie=" + energie + "]";
		}
		return s;
	}

	/** Gere la perte de point de vie du robot par des tirs */
	public void subitTir(Robot robot) {
		if (robot instanceof Char) {
			setEnergie(getEnergie() + Constante.DEGATCHAR);
		} else if (robot instanceof Tireur) {
			setEnergie(getEnergie() + Constante.DEGATTIREUR);
		}
	}

	/** Gere la perte de point de vie du robot par des mines */
	public void subitMine() {
		setEnergie(getEnergie() + Constante.DEGATPIEGEUR);
	}
	public boolean  peutAction (Robot robot){
		if(robot instanceof Char){
			if(robot.getEnergie() <= Constante.COUTAVANCERCHAR || robot.getEnergie() <= Constante.COUTTIRERCHAR){
				return true;
			}				
			
		}
		else if(robot instanceof Tireur){
			if(robot.getEnergie() >= Constante.COUTAVANCERTIREUR || robot.getEnergie() >= Constante.COUTTIRERTIREUR){
				return true; 
			}
		}
		else if(robot instanceof Piegeur){
			if(robot.getEnergie() >= Constante.COUTAVANCERPIEGEUR || robot.getEnergie() >= Constante.COUTMINER){
				return true;
			}
		}
		return false;
	}	
	public boolean robotMort(){
		if(this.getEnergie() <= 0){
			return true;
		}
		return false;
	}
}
