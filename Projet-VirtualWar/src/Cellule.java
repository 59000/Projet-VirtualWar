public class Cellule extends Coordonnees {

/*essayer de corriger les methodes deplacerSur ainsi que viderCase et le void ajout*/
														
	protected int mine;
	protected int base;
	protected Robot robot;

	// String image; //inutile pour le momant

	public Cellule(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	public int contienMine() {
		return mine;
	}

	/*
	 * public void set_mine(int mine) { this.mine=mine; }
	 */

	public int estBase() {
		return base;
	}

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
		//if (robot.getCoord() == this.getCoordonnees()) {
			this.robot = robot;
		//}

	}
	public void videCase()
	{
		this.mine=0;
		this.robot=null;
	}
	public void ajout(int equipe){
		
	}
}
