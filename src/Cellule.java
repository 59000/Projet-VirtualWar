public class Cellule extends Coordonnees {

	/*
	 * essayer de corriger les methodes deplacerSur ainsi que viderCase et le
	 * void ajout
	 */

	protected int mine;
<<<<<<< HEAD
	protected int base;
=======
	protected static int base;
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	protected Robot robot;

	// String image; //inutile pour le momant

	public Cellule(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	public int contienMine() {
		return mine;
	}

	public void setMine(int mine) {
		this.mine = mine;
	}

<<<<<<< HEAD

=======
	public int estBase() {
		return base;
	}
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c

	public Coordonnees getCoordonnees() {
		return new Coordonnees(super.getLargeur(), super.getHauteur());
	}

	public Robot getContenu() {
		return robot;
	}

	@Override
	public String toString() {
		return "Cellule [mine=" + mine + ", base=" + base /* + ", image=" + image */
				+ ", robot=" + robot + "]";
	}

	public void deplaceSur(Robot robot) {
		// if (robot.getCoord() == this.getCoordonnees()) {
		this.robot = robot;
		// }

	}

	public void videCase() {
		this.mine = 0;
		this.robot = null;
	}

	public void ajout(int equipe) {
		this.robot.setEquipe(equipe);
	}

	void creeBase(boolean b) {
		/*
		 * 1 base en 0;0 et la deuxieme en x max y max 2 une base en x max y 0
		 * et la deuxieme en x 0 et y max
		 */
		if (b) {
<<<<<<< HEAD
			this.base = Constante.BASE1;

		} else if (!b) {
			this.base = Constante.BASE2;
		}
	}
	public int estBase(Coordonnees c){
		return this.base;
		
	}
	public int estBase(){
		return this.base;
	}


=======
			Cellule.base = Constante.BASE1;

		} else if (!b) {
			Cellule.base = Constante.BASE2;
		}
	}
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c

}
