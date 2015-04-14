import java.util.List;

public abstract class Robot {
<<<<<<< HEAD
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
		// condition foireuse si la base est pas en 0.0 mais comment on rÃ©cupÃ©re les coordonÃ© de la base ?
		
=======
	/*implÃ©menter les fonctions prÃ©sentes*/
	
	private Coordonnees coord;
	private int equipe;
	private int energie;
	private final int numero;//le numero qui identifie le robot dans l'Ã©quipe

	public Robot(int equipe,int numero, int energie) {
		setCoord(new Coordonnees(0, 0));
		this.setEquipe(equipe);
		this.setEnergie(energie);
		this.numero=numero;
	}

	

	/** augmente l'energie du robot en base de 2 */
	void regeneration() {
		setEnergie(getEnergie()+ (this.getCoord().equals(new Coordonnees(0, 0)) ? Constante.REGENENBASE : 0));
		// condition foireuse si la base est pas en 0.0 mais comment on rÃ©cupÃ©re les coordonÃ© de la base ?
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
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

<<<<<<< HEAD
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
=======
	public int getNumero() 
	{
		return numero;
	}
	abstract public boolean peutTirer();
	abstract public int getCoutAction();
	abstract public int getCoutDep();
	abstract public int getDegatTir();
	abstract public int getDegatMine();
	abstract public List<Coordonnees> getDeplacement();
	
	
	@Override
	public String toString() {
		return "Robot [coord=" + coord + ", equipe=" + equipe +  ", numero=" + numero + ", energie="
				+ energie + "]";
	}



	public void subitTir(Robot robot ) {
		if(robot instanceof Char){
			setEnergie(getEnergie()-Constante.DEGATCHAR);
		}
		else if (robot instanceof Tireur){
			setEnergie(getEnergie()-Constante.DEGATTIREUR);
		}
	}
	public void subitMine() {
		setEnergie(getEnergie()-Constante.DEGATPIEGEUR);
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	}

}
