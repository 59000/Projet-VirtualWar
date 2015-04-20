package Action;
import Constante.Constante;
import Plateau.Coordonnees;
import Robot.Char;
import Robot.Piegeur;
import Robot.Robot;
import Robot.Tireur;

public class Deplacement extends Action {
	/**Deplace le robot selon sa portÃ©e de deplacement*/
	public Deplacement(Robot robot, Coordonnees coord) {
		super(robot, coord);
	
		this.coord.setHauteur((int) this.coord.getHauteur());
		this.coord.setLargeur((int) this.coord.getLargeur());
		
		this.agit();
	}
	
	/**Methode qui permet le deplacement du robot appelÃ© par le constructeur */
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
