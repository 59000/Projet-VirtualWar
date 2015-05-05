package ia;

import Plateau.Coordonnees;
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
	
	abstract Robot[] constitution_equipes(int nb_robot);
	/** @return 1 deplacement,2 attaque*/
	abstract int selection_action();
	abstract Robot selection_robot_actif();
	abstract Coordonnees selection_direction_deplacement(Robot robot);
	abstract Coordonnees selection_direction_attaque(Piegeur p);
	/**@return numero du robot cible*/
	abstract int selection_robot_cible(Robot robot);
}

