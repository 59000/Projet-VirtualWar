public abstract class Action {
	/*
	 * Il reste a faire la methode getDirection qui renvoit un chemin pour aller
	 * a l'objectif
	 */

	/** @param Coordoonnees coord */
	protected Coordonnees coord;
	/** @param Robot robot */
	protected Robot robot;

	/**
	 * Crée une instance de la classe action en precisant un robot et ses
	 * coordonnées
	 * 
	 * @param Robot robot
	 * @param Coodonnees coord
	 */
	public Action(Robot robot, Coordonnees coord) {
		this.robot = robot;
		this.coord = coord;
	}

	/** @return robot */
	public Robot getRobot() {
		return robot;
	}

	/*
	 * public Coordonnees getDirection(){ return null; }
	 */
	/**
	 * Retourne une case ciblé par le joueur pour attaquer ou se deplacer
	 * 
	 * @return Coordonnees
	 */
	public Coordonnees getObjectif() {
		return new Coordonnees(coord.getLargeur(), coord.getHauteur());
	}

	/** Abstract qui permet de faire les actions attaques et deplacement */
	public abstract void agit();

}
