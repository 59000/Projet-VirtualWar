
public abstract class Action {
	/*Il reste a faire la methode getDirection qui renvoit un chemin pour aller a l'objectif*/
	protected Coordonnees coord ;
	protected Robot robot ;
	
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
