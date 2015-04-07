public class Coordonnees {
	/*Classe terminé : gg c'est la seule classe fini*/
	
	private int largeur;
	private int hauteur;

	public Coordonnees(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	/** retourne la composante x */
	public int getLargeur() {
		return largeur;
	}

	/** retourne la composante y */
	public int getHauteur() {
		return hauteur;
	}

	/** retourne les coordonnée sous la forme "[x;y]" */
	public String toString() {
		return "[" + this.largeur + ";" + this.hauteur + "]";
	}

	/** ajoute des coordonnées aux coordonnées courantes */
	public Coordonnees ajout(Coordonnees coord) {
		int l = (this.largeur + coord.getLargeur());
		int h = (this.hauteur + coord.getHauteur());

		return new Coordonnees(l, h);
	}

	/** soustrait des coordonnées aux coordonnées courantes */
	public Coordonnees soustrait(Coordonnees coord) {
		int l = (this.largeur - coord.getLargeur());
		int h = (this.hauteur - coord.getHauteur());

		return new Coordonnees(l, h);
	}
}
