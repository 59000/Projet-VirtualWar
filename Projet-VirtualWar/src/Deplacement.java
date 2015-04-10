public class Deplacement extends Action {
	/* Classe à tester */

	/**
	 * Initialise un deplacement
	 * 
	 * @param robot
	 *            le robot que l'on souhaite deplacer
	 * @param coord
	 *            /!\ appel d'une des constantes de DEPLACEMENT
	 */
	public Deplacement(Robot robot, Coordonnees coord) {
		super(robot, coord);
	}

	@Override
	public void agit() {
		if (this.robot instanceof Char) {
			this.coord.setHauteur(this.coord.getHauteur()
					* Constante.PORTEECHAR);
			this.coord.setLargeur(this.coord.getHauteur()
					* Constante.PORTEECHAR);
		} else if (this.robot instanceof Tireur) {
			this.coord.setHauteur(this.coord.getHauteur()
					* Constante.PORTEETIREUR);
			this.coord.setLargeur(this.coord.getHauteur()
					* Constante.PORTEETIREUR);
		} else if (this.robot instanceof Piegeur) {
			this.coord.setHauteur(this.coord.getHauteur()
					* Constante.PORTEEPIEGEUR);
			this.coord.setLargeur(this.coord.getHauteur()
					* Constante.PORTEEPIEGEUR);
		}
	}
}
