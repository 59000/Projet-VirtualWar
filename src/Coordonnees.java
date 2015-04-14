public class Coordonnees {
	
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
	

	/** retourne les coordonnÃƒÂ©e sous la forme "[x;y]" */
	public String toString() {
		return "[" + this.largeur + ";" + this.hauteur + "]";
	}

	/** ajoute des coordonnÃ©es aux coordonnÃ©es courantes */
	public Coordonnees ajout(Coordonnees coord) {
		int l = (this.largeur + coord.getLargeur());
		int h = (this.hauteur + coord.getHauteur());

		return new Coordonnees(l, h);
	}
	
	public Coordonnees soustrait(Coordonnees coord) {
		int l = this.largeur - coord.getLargeur();
		int h = this.hauteur - coord.getHauteur();

		return new Coordonnees(l, h);


	public void setHauteur(int i) {
		// TODO Auto-generated method stub
		this.hauteur = i;
	}

	public void setLargeur (int i) {
		// TODO Auto-generated method stub
		this.largeur = i;
	}
		
}
