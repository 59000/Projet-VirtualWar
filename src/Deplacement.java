public class Deplacement extends Action {
	/* Il faut finir la methode agit */
	/**Deplace le robot selon sa portée de deplacement*/
	public Deplacement(Robot robot, Coordonnees coord) {
		super(robot, coord);
		
		int porte = 1;
		
		if (this.robot instanceof Char) {
			porte = Constante.DEPLACEMENTCHAR;
		} else if (this.robot instanceof Tireur) {
			porte = Constante.DEPLACEMENTTIREUR;
		} else if (this.robot instanceof Piegeur) {
			porte = Constante.DEPLACEMENTPIEGEUR;
		}
		
		this.coord.setHauteur((int) this.coord.getHauteur()*porte);
		this.coord.setLargeur((int) this.coord.getLargeur()*porte);
		
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
