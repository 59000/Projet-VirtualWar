public class Deplacement extends Action {
	/* Il faut finir la methode agit */
	public Deplacement(Robot robot, Coordonnees coord) {
		super(robot, coord);
	}

	@Override
	public void agit() {
		if (this.robot instanceof Char) {
			this.robot.setCoord(this.robot.getCoord().ajout(coord));
		} else if (this.robot instanceof Tireur) {
			this.robot.setCoord(this.robot.getCoord().ajout(coord));
		} else  if (this.robot instanceof Piegeur) {
			this.robot.setCoord(this.robot.getCoord().ajout(coord));
		}

	}
}
