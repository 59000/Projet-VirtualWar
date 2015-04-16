public class Deplacement extends Action {
	/**Deplace le robot selon sa portée de deplacement*/
	public Deplacement(Robot robot, Coordonnees coord) {
		super(robot, coord);
	
		this.coord.setHauteur((int) this.coord.getHauteur());
		this.coord.setLargeur((int) this.coord.getLargeur());
		
		this.agit();
	}
	
	/**Methode qui permet le deplacement du robot appelé par le constructeur */
	@Override
	public void agit() {
		if (this.robot instanceof Char) {
			this.robot.setCoord(this.robot.getCoord().ajout(coord));
			this.robot.setEnergie(this.robot.getEnergie()+Constante.COUTAVANCERCHAR);
		} else if (this.robot instanceof Tireur) {
			this.robot.setCoord(this.robot.getCoord().ajout(coord));
			this.robot.setEnergie(this.robot.getEnergie()+Constante.COUTAVANCERTIREUR);
		} else  if (this.robot instanceof Piegeur) {
			this.robot.setCoord(this.robot.getCoord().ajout(coord));
			this.robot.setEnergie(this.robot.getEnergie()+Constante.COUTAVANCERPIEGEUR);
		}

	}
}
