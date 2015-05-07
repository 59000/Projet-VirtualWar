package ia;

import java.util.Random;
import Robot.Char;
import Robot.Piegeur;
import Robot.Robot;
import Robot.Tireur;

public class Aleatoire extends IA {
	Random r = new Random();

	public Aleatoire(int equipe) {
		super(equipe);
	}

	@Override
	public Robot[] constitution_equipes(int nb_robot) {
		Robot[] areturn = new Robot[nb_robot];
		for (int i = 0; i < nb_robot; i++) {
			switch (r.nextInt(3)) {
			case 0:
				areturn[i] = new Tireur(equipe, i);
				break;
			case 1:
				areturn[i] = new Piegeur(equipe, i);
				break;
			case 2:
				areturn[i] = new Char(equipe, i);
				break;
			}
		}
		robots = areturn;
		return areturn;
	}

	@Override
	public int selection_action() {
		return (r.nextInt(2) + 1);
	}

	@Override
	public Robot selection_robot_actif() {
		int nbRobot = r.nextInt(robots.length);
		if (robots[nbRobot] == null) {
			return selection_robot_actif();
		}
		return robots[nbRobot];
	}

	@Override
	public String selection_direction_deplacement(Robot robot) {
		if (robot instanceof Char) {
			switch (r.nextInt(4)) {
			case 0:
				return "haut";
			case 1:
				return "bas";
			case 2:
				return "gauche";
			case 3:
				return "droit";
			}
		} else {
			switch (r.nextInt(8)) {
			case 0:
				return "haut";
			case 1:
				return "bas";
			case 2:
				return "gauche";
			case 3:
				return "droit";
			case 4:
				return "hautgauche";
			case 5:
				return "hautdroit";
			case 6:
				return "basgauche";
			case 7:
				return "basdroit";
			}
		}
		return null;// compilateur autoritaire
	}

	@Override
	public String selection_direction_attaque(Piegeur p) {
		return selection_direction_deplacement(p);
	}

	@Override
	public int selection_robot_cible(Robot robot) {
		return r.nextInt(robots.length);
	}

}
