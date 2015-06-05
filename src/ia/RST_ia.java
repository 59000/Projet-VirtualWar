package ia;

import Robot.Piegeur;
import Robot.Robot;
import Robot.Tireur;

public class RST_ia extends IA {
	/*
	 * cette ia ne marche que en equipe 2 et sans obstacles
	 */

	/*
	 * accessible dans ia int equipe; Robot[] robots;
	 */
	private int compteur;
	private int compteur2 = 0;

	/**
	 * Cree une ia en fonction de equipe
	 * 
	 * @param equipe
	 */
	public RST_ia(int equipe) {
		super(equipe);
		compteur = 0;
	}

	/**
	 * Constitue aleatoirement les equipe avec un nombre de robot
	 * 
	 * @param nb_robot
	 */
	@Override
	public Robot[] constitution_equipes(int nb_robot) {
		Robot[] mon_equipe = new Robot[nb_robot];

		if (nb_robot == 1) {
			// juste un tireur
			mon_equipe[0] = new Tireur(equipe, 0);
		} else if (nb_robot == 2) {
			// piegeur et tireur
			mon_equipe[0] = new Tireur(equipe, 0);
			mon_equipe[1] = new Piegeur(equipe, 1);
		} else {
			// piegeur et tireur et bourage tireur
			mon_equipe[0] = new Tireur(equipe, 0);
			mon_equipe[1] = new Piegeur(equipe, 1);
			for (int i = 2; i < nb_robot; i++) {
				mon_equipe[i] = new Tireur(equipe, i);
			}
		}

		robots = mon_equipe;
		return mon_equipe;
	}

	/** Selection d action : soit deplacement , soit attaque */
	@Override
	public int selection_action() {
		/*
		 * 1 dep 2 att
		 */
		if (robots.length >= 2) {
			int action = 0;
			if (compteur == 0) {
				action = 1;
			} else if (compteur < 6) {
				action = 2;
			} else if (compteur < 8) {
				action = 1;
			} else {
				int compteur2 = (compteur - 8) % (robots.length + 1);
				if (compteur2 < robots.length) {
					if (robots[0] != null) {
						action = 2;
					} else {
						action = 1;
					}
				} else {
					action = 1;
				}
			}
			return action;
		} else {
			return (compteur % 2 == 0) ? 1 : 2;
		}
	}

	/** Selection du robot qui va jouer dans equipe aleatoirement */
	@Override
	public Robot selection_robot_actif() {
		if (robots.length >= 2) {
			Robot areturn = null;
			if (compteur == 0) {
				areturn = robots[1];
			} else if (compteur < 6) {
				areturn = robots[1];
			} else if (compteur == 6) {
				areturn = robots[1];
			} else if (compteur == 7) {
				areturn = robots[0];
			} else {
				if (robots[0] != null) {
					areturn = robots[0];
				} else {
					for (int i = 2; i < robots.length; i++) {
						if (robots[i] != null) {
							areturn = robots[i];
						}
					}
					if (areturn == null) {
						areturn = robots[1];
					}
				}
			}
			return areturn;
		} else {
			return robots[0];
		}
	}

	/**
	 * Selection de la direction du deplacement du robot si selection_action = 1
	 */
	@Override
	public String selection_direction_deplacement(Robot robot) {
		if (robots.length >= 2) {
			String areturn = "";
			if (compteur == 0) {
				areturn = "hautgauche";
				compteur++;
			} else if (compteur == 6) {
				areturn = "basdroit";
				compteur++;
			} else if (compteur == 7) {
				areturn = "gauche";
				compteur++;
			} else {
				switch (compteur2 % 4) {
				case 0:
					areturn = "haut";
					break;
				case 1:
					areturn = "droit";
					break;
				case 2:
					areturn = "gauche";
					break;
				case 3:
					areturn = "bas";
					break;
				}
				compteur2++;
				compteur++;
			}
			return areturn;
		} else {
			String areturn = "";
			switch (compteur2 % 11) {
			case 0:
				areturn = "hautgauche";
				break;
			case 1:// et maintenant
				areturn = "haut";
				break;
			case 2:
				areturn = "haut";
				break;
			case 3:
				areturn = "bas";
				break;
			case 4:
				areturn = "bas";
				break;
			case 5:
				areturn = "gauche";
				break;
			case 6:
				areturn = "droit";
				break;
			case 7:
				areturn = "gauche";
				break;
			case 8:
				areturn = "droit";// A
				break;// B
			// START
			// hum konami code non ? ;-)
			}
			compteur2++;
			compteur++;
			return areturn;
		}
	}

	/**
	 * Selection de la direction de lattaque si selection_action = 2 et que le
	 * robot est un Piegeur
	 */
	@Override
	public String selection_direction_attaque(Piegeur p) {
		if (robots.length >= 2) {
			if (compteur == 1) {
				compteur++;
				return "basgauche";
			}
			if (compteur == 2) {
				compteur++;
				return "gauche";
			}
			if (compteur == 3) {
				compteur++;
				return "hautgauche";
			}
			if (compteur == 4) {
				compteur++;
				return "haut";
			}
			if (compteur == 5) {
				compteur++;
				return "hautdroit";
			}
		} else {
			compteur++;
			return "hautgauche";// pas de piegeur dans ce cas ...
		}
		return null;
	}

	/** Selection de la direction de lattaque si selection_action = 2 */
	@Override
	public int selection_robot_cible(Robot robot) {
		if (robots.length >= 2) {
			compteur++;
			return (compteur - 8) % (robots.length);
		} else {
			compteur++;
			return 0;
		}
	}

}
