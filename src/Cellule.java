import java.util.Random;

public class Cellule extends Coordonnees {

	/*
	 * essayer de corriger les methodes deplacerSur ainsi que viderCase et le
	 * void ajout
	 */
	/** @param int mine */
	protected int mine;
	/** @param int base */
	protected int base;
	/**
	 * @param Robot
	 *            robot
	 */
	protected Robot robot;
	/** @param pourcentage */
	double pourcentage = 15;
	/** @param ran */
	Random ran = new Random();

	// String image; //inutile pour le momant
	/**
	 * Cree une instance de la classe Cellule en precisant ses coordonnees
	 * 
	 * @param largeur
	 * @param hauteur
	 */
	public Cellule(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	/** @return mine */
	public int contienMine() {
		return this.mine;
	}

	/** Remettre le nombre de mine au nombre desire */
	public void setMine(int mine) {
		this.mine = mine;
	}

	/** @return new Coordonnees */
	public Coordonnees getCoordonnees() {
		return new Coordonnees(super.getLargeur(), super.getHauteur());
	}

	/** @return robot */
	public Robot getContenu() {
		return robot;
	}

	@Override
	public String toString() {
		return "Cellule [mine=" + mine + ", base=" + base /* + ", image=" + image */
				+ ", robot=" + robot + "]";
	}

	/** Deplace le robot sur la celulle actuelle */
	public void deplaceSur(Robot robot) {
		// if (robot.getCoord() == this.getCoordonnees()) {
		this.robot = robot;
		// }

	}

	/** Permet de vider la case actuelle */
	public void videCase() {
		this.mine = 0;
		this.robot = null;
	}

	/** Ajoute un robot a l'equipe */
	public void ajout(int equipe) {
		this.robot.setEquipe(equipe);
	}

	/** Permet de Crée une base */
	void creeBase(boolean b) {

		if (b) {
			this.base = Constante.BASE1;

		} else if (!b) {
			this.base = Constante.BASE2;
		}
	}

	/** Teste si la cellule est une base en fonction des coordonnées */
	public int estBase(Coordonnees c) {
		return this.base;

	}

	/** Teste si la cellule actuelle est une base */
	public int estBase() {
		return this.base;
	}

	/** Verifie si la case actuelle est un obstacle */
	public boolean estObstacle() {
		if (this.ran.nextInt(100) <= pourcentage) {
			return true;
		}
		return false;
	}
}
