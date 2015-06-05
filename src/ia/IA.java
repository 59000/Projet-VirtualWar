package ia;

import Robot.Piegeur;
import Robot.Robot;

public abstract class IA {
	int equipe;
	Robot[] robots;
	/**Cree une instance IA en fonction de equipe
	 * @param equipe */
	public IA(int equipe) {
		this.equipe = equipe;
	}

	public abstract Robot[] constitution_equipes(int nb_robot);

	public abstract int selection_action();

	public abstract Robot selection_robot_actif();

	public abstract String selection_direction_deplacement(Robot robot);

	public abstract String selection_direction_attaque(Piegeur p);

	public abstract int selection_robot_cible(Robot robot);
}
