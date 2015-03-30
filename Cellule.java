public /*abstract*/ class Cellule extends Coordonnees {//pas sur qu'on ai besoin du abstract
	protected int mine;
	protected int base;
	protected Robot robot;
	String image;

	public Cellule(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	public int contienMine() {
		return mine;
	}

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
		return "Cellule [mine=" + mine + ", base=" + base + ", image=" + image + ", robot=" + robot+ "]";
	}

	/*abstract void deplaceSur(Robot robot);

	abstract void ajout(int equipes);

	abstract void videCase();*///pas sur qu'on ai besoin du abstract
}
