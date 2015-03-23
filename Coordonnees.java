public class Coordonnees {
	private int largeur;
	private int hauteur;

	public Coordonnees(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public String toString() {
		return "[" + largeur + ";" + hauteur + "]";
	}

	public Coordonnees ajout(Coordonnees coord) {
		int l = this.largeur + coord.getLargeur();
		int h = this.hauteur + coord.getHauteur();

		return new Coordonnees(l, h);
	}
}
