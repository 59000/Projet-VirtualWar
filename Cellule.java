public /*abstract*/ class Cellule extends Coordonnees {//pas sur qu'on ai besoin du abstract
	protected int mine;
	protected int base;
	protected Robot robot;
	//String image; //inutile pour le moment

	public Cellule(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	public int contienMine() {
		return mine;
	}
	
	/*public void set_mine(int mine)
	{
		this.mine=mine;
	}*/

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
		return "Cellule [mine=" + mine + ", base=" + base /*+ ", image=" + image*/ + ", robot=" + robot+ "]";
	}

	
	void deplaceSur(Robot robot) {
		if (robot.getCoord() == this.getCoordonnees()) {
			this.robot = robot;
		}

	}

	/*
	 * 
	 * 
	 * abstract void ajout(int equipes);
	 * 
	 * abstract void videCase();
	 */// pas sur qu'on ai besoin du abstract
}
