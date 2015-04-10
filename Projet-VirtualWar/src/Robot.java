import java.util.List;

public abstract class Robot {
	/*implémenter les fonctions présentes*/
	
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

	

	/** augmente l'energie du robot en base de 2 */
	void regeneration() {
		setEnergie(getEnergie()+ (this.getCoord().equals(new Coordonnees(0, 0)) ? Constante.REGENENBASE : 0));
		// condition foireuse si la base est pas en 0.0 mais comment on récupére les coordoné de la base ?
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



	public void subitTir(){
		
	}
	public void subitMine() {
		setEnergie(getEnergie()-Constante.DEGATPIEGEUR);
	}

}
