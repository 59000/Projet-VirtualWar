
public class Deplacement extends Action {
	
	public Deplacement (Robot robot, Coordonnees coord){
		super(robot,coord);
	}

	@Override
	public void agit(Robot robot) {
		if(this.robot instanceof Char){
			this.robot.setCoord(this.robot.getCoord().ajout(new Coordonnees(0, -2)));
			/* PAs du tout fini , c'etait juste un test pour voir si ça marche*/
		}
		
	}
	

}
