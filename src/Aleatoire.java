package ia;

import java.util.Random;

import Constante.Constante;
import Plateau.Coordonnees;
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
	public Coordonnees selection_direction_deplacement(Robot robot) {
		if (robot instanceof Char) {
			switch (r.nextInt(4)) {
			case 0:
				return Constante.HAUT;
			case 1:
				return Constante.BAS;
			case 2:
				return Constante.GAUCHE;
			case 3:
				return Constante.DROIT;
			}
		} else {
			switch (r.nextInt(8)) {
			case 0:
				return Constante.HAUT;
			case 1:
				return Constante.BAS;
			case 2:
				return Constante.GAUCHE;
			case 3:
				return Constante.DROIT;
			case 4:
				return Constante.HAUTGAUCHE;
			case 5:
				return Constante.HAUTDROIT;
			case 6:
				return Constante.BASGAUCHE;
			case 7:
				return Constante.BASDROIT;
			}
		}
		return null;// compilateur autoritaire
	}

	@Override
	public Coordonnees selection_direction_attaque(Piegeur p) {
		return selection_direction_deplacement(p);
	}

	@Override
	public int selection_robot_cible(Robot robot) {
		return r.nextInt(robots.length);
	}

}
