package Plateau;
public class Coordonnees {
	
	/**@param largeur*/
	private int largeur;
	/**@param hauteur */
	private int hauteur;

	/**Cree des Coordoonnees
	 * 
	 * @param largeur
	 * @param hauteur
	 */
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
	

	/** retourne les coordonnees sous la forme "[x;y]" */
	public String toString() {
		return "[" + this.largeur + ";" + this.hauteur + "]";
	}

	/** ajoute des coordonnees aux coordonnees courantes */
	public Coordonnees ajout(Coordonnees coord) {
		int l = (this.largeur + coord.getLargeur());
		int h = (this.hauteur + coord.getHauteur());

		return new Coordonnees(l, h);
	}
	/** soustrait des coordonnees aux coordonnees courantes*/
	public Coordonnees soustrait(Coordonnees coord) {
		int l = this.largeur - coord.getLargeur();
		int h = this.hauteur - coord.getHauteur();

		return new Coordonnees(l, h);
	}
	/**Met la hauteur a celle mise en parametre*/
	public void setHauteur(int i) {
		// TODO Auto-generated method stub
		this.hauteur = i;
	}
	/**Met la Largeur a celle mise en parametre*/
	public void setLargeur (int i) {
		// TODO Auto-generated method stub
		this.largeur = i;
	}
	/** Verifie que deux coordonees sont egales */
	public boolean equals(Coordonnees coord) {
		// TODO Auto-generated method stub
		return (this.hauteur == coord.hauteur && this.largeur == coord.largeur);
	}
		
}
