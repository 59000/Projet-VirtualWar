public abstract class Cellule extends Coordonnees {
	protected int mine;
	protected int base;
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
		// je vois pas comment on detecte si return un robot dc ...
		return null;
	}

	@Override
	public String toString() {
		return "Cellule [mine=" + mine + ", base=" + base + ", image=" + image
				+ "]";
	}

	abstract void deplaceSur(Robot robot);

	abstract void ajout(int equipes);

	abstract void videCase();
}
