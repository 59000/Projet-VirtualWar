public class Coordonnees {
<<<<<<< HEAD
	/* Classe terminÃ© : gg c'est la seule classe fini */

=======
	/*Classe terminÃƒÂ© : gg c'est la seule classe fini*/
	
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
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
<<<<<<< HEAD
	

	/** retourne les coordonnÃ©e sous la forme "[x;y]" */
=======

	/** retourne les coordonnÃƒÂ©e sous la forme "[x;y]" */
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	public String toString() {
		return "[" + this.largeur + ";" + this.hauteur + "]";
	}

<<<<<<< HEAD
	/** ajoute des coordonnÃ©es aux coordonnÃ©es courantes */
=======
	/** ajoute des coordonnÃƒÂ©es aux coordonnÃƒÂ©es courantes */
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	public Coordonnees ajout(Coordonnees coord) {
		int l = (this.largeur + coord.getLargeur());
		int h = (this.hauteur + coord.getHauteur());

		return new Coordonnees(l, h);
	}

<<<<<<< HEAD


	public Coordonnees soustrait(Coordonnees coord) {
		int l = this.largeur - coord.getLargeur();
		int h = this.hauteur - coord.getHauteur();

		return new Coordonnees(l, h);
=======
	int estBase(Coordonnees coord){
	/*	if(Cellule.base == Constante.PASUNEBASE){
			return 0;
		}else if(Cellule.base == Constante.BASE1 ){
			
			return 1;
		}else if(Cellule.base == Constante.BASE2){
			return 2;
		}
		return 0;*/
		return Cellule.base;
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
	}

	public void setHauteur(int i) {
		// TODO Auto-generated method stub
		this.hauteur = i;
	}
<<<<<<< HEAD
	public void setLargeur(int i) {
		this.largeur = i;
	}

=======
	
	public void setLargeur (int i) {
		// TODO Auto-generated method stub
		this.largeur = i;
	}
		
>>>>>>> b06ce68ea1a3d83492f6585fad7070a9e5a1fc7c
}
