public class Coordonnees {
	/*Classe terminÃ© : gg c'est la seule classe fini*/
	
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

	/** retourne les coordonnÃ©e sous la forme "[x;y]" */
	public String toString() {
		return "[" + this.largeur + ";" + this.hauteur + "]";
	}

	/** ajoute des coordonnÃ©es aux coordonnÃ©es courantes */
	public Coordonnees ajout(Coordonnees coord) {
		int l = (this.largeur + coord.getLargeur());
		int h = (this.hauteur + coord.getHauteur());

		return new Coordonnees(l, h);
	}

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
	}

	public void setHauteur(int i) {
		// TODO Auto-generated method stub
		this.hauteur = i;
	}
	
	public void setLargeur (int i) {
		// TODO Auto-generated method stub
		this.largeur = i;
	}
		
}
