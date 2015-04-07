
public abstract class Action {
	
	private Coordonnees coord ;
	private Robot robot ;
	
	public Action (Robot robot ,Coordonnees coord){
		this.robot=robot;
		this.coord=coord;
	}
	public  Robot getRobot(){
		return robot ;
	}
	
	/*public Coordonnees getDirection(){
		return null;
	}*/
	
	public Coordonnees getObjectif(){
		return new Coordonnees(coord.getLargeur(), coord.getHauteur());
	}
	
	public abstract void agit();
	
}
