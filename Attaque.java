 
public class Attaque extends Action {
	/*Classe non terminé, la methode agit est censé contenir plus de chose*/


	public Attaque(Robot robot, Coordonnees coord) {
		super(robot, coord);
		// TODO Auto-generated constructor stub
	}


	

	@Override
	public void agit(Robot robot) {
		// TODO Auto-generated method stub
		if(this.robot instanceof Char ){
			robot.setEnergie(robot.getEnergie()-Constante.DEGATCHAR);
		}
		else if (this.robot instanceof Tireur){
			robot.setEnergie(robot.getEnergie()-Constante.DEGATTIREUR);
		}
		else if (this.robot instanceof Piegeur){
			robot.setEnergie(robot.getEnergie()-Constante.DEGATPIEGEUR);
		}
	}




	
}
