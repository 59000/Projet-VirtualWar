package ia;

import Robot.Piegeur;
import Robot.Robot;

public abstract class IA 
{
	int equipe;
	Robot[] robots;
	
	public IA(int equipe)
	{
		this.equipe=equipe;
	}
	
	public abstract Robot[] constitution_equipes(int nb_robot);
	/** @return 1 deplacement,2 attaque*/
	public abstract int selection_action();
	public abstract Robot selection_robot_actif();
	public abstract String selection_direction_deplacement(Robot robot);
	public abstract String selection_direction_attaque(Piegeur p);
	/**@return numero du robot cible*/
	public abstract int selection_robot_cible(Robot robot);
}


