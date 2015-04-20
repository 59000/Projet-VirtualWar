package Menu;
import Constante.Constante;

import java.util.InputMismatchException;
import java.util.Scanner;

import Plateau.Cellule;
import Plateau.Coordonnees;
import Plateau.Plateau;
import Robot.Char;
import Robot.Piegeur;
import Robot.Robot;
import Robot.Tireur;

public class Menu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenue Dans VIRTUAL WAR !");
		int taille = 0;
		while (taille < 5 || taille > 10) {
			System.out
					.println("Tout d'abord, veuillez fixez la taille du plateau de combat.");
			taille = scan.nextInt();
		}

		Plateau p = new Plateau(taille, taille);

		p.plateau[0][0].base = Constante.BASE1;
		p.plateau[taille - 1][taille - 1].base = Constante.BASE2;
		p.genere_obstacle(p.plateau[0][0]);

		int nb_robot_voulu;
		do {
			System.out
					.println("combien de robot voulez vous dans vos equipes ?");
			nb_robot_voulu = scan.nextInt();
		} while (nb_robot_voulu > 5 || nb_robot_voulu < 1);

		Robot[][] equipeRobot = {
				Menu.constituer_equipe(scan, p.plateau.length,
						p.plateau[0].length, nb_robot_voulu, 1),
				Menu.constituer_equipe(scan, p.plateau.length,
						p.plateau[0].length, nb_robot_voulu, 2) };

		boolean jeu = true;
		int equipe_passive = 0;
		int equipe_active = 0;
		while (jeu) {
			System.out.println(p);

			System.out
					.println("+---------------------------------------------------------------++---------------------------------------------------------------+");
			for (int j = 0; j < equipeRobot[0].length; j++) {
				if (equipeRobot[0][j] == null) {
					System.out.println("|                                   |"
							+ "| " + equipeRobot[1][j].toString() + "|");
				} else if (equipeRobot[1][j] == null) {
					System.out.println("| " + equipeRobot[0][j].toString()
							+ "|"
							+ "|                                            |");
				} else {
					System.out.println("| " + equipeRobot[0][j].toString()
							+ "|" + "| " + equipeRobot[1][j].toString() + "|");
				}
			}
			System.out
					.println("+---------------------------------------------------------------++---------------------------------------------------------------+");

			System.out.println("Equipe " + (equipe_active + 1)
					+ ": Quel action souhaitez-vous ? \n - 1. Deplacement \n "
					+ "- 2. Attaquez \n - 3. Quittez le jeu.");

			int i = scan.nextInt();

			if (i == 1) {
				boolean flag = true;
				while (flag) {
					System.out.println("Equipe " + (equipe_active + 1)
							+ ": Quel Robot (numero) voulez-vous deplacer ?");

					try {
						i = scan.nextInt();
						if (equipeRobot[equipe_active][i] != null) {
							equipeRobot[equipe_active][i].getNumero();
						} else {
							System.out.println("Ce Robot est mort !");
						}
						flag = false;
					} catch (InputMismatchException e) {
						System.out.println("Erreur : Entier attendu");
						flag = true;
						i = 0;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Erreur : Robot non existant");
						flag = true;
						i = 0;

					}
				}

				if (equipeRobot[equipe_active][i] != null) {
					System.out
							.println("Equipe "
									+ (equipe_active + 1)
									+ ": Dans quel direction ? (haut,bas,gauche,droit,hautgauche,hautdroit,basgauche,basdroit)");
					String msg = scan.next();

					switch (msg) {
					case "haut":
						p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUT);
						break;
					case "bas":
						p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BAS);
						break;
					case "gauche":
						p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.GAUCHE);
						break;
					case "droit":
						p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.DROIT);
						break;
					case "hautgauche":
						p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUTGAUCHE);
						break;
					case "hautdroit":
						p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUTDROIT);
						break;
					case "basgauche":
						p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BASGAUCHE);
						break;
					case "basdroit":
						p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BASDROIT);
						break;

					}
				}

			} else if (i == 3) {
				System.out.println("Fin du jeu !");
				jeu = false;
			} else if (i == 2) {
				System.out.println("Equipe " + (equipe_active + 1)
						+ ": Quel Robot (numero) voulez-vous faire attaquer ?");
				Robot attaquant = equipeRobot[equipe_active][scan.nextInt()];
				if (attaquant != null) {
					if (p.plateau[attaquant.getCoord().getLargeur()][attaquant
							.getCoord().getHauteur()].estBase() == attaquant
							.getEquipe()) {
						System.out
								.println("Erreur : une attaque depuis une base est impossible");
					} else {
						if (attaquant instanceof Piegeur) {
							System.out
									.println("Equipe "
											+ (equipe_active + 1)
											+ ": dans quelle direction le piÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â©geur doit il poser sa mine ?(haut,bas,gauche,droit,basgauche,basdroit,hautgauche,hautdroit)");
							Cellule cell_attaquant = p.plateau[attaquant
									.getCoord().getLargeur()][attaquant
									.getCoord().getHauteur()];
							String dir = scan.next();
							switch (dir) {
							case "haut":
								p.plateau[cell_attaquant.ajout(Constante.HAUT)
										.getLargeur()][cell_attaquant.ajout(
										Constante.HAUT).getHauteur()]
										.setMine(equipe_active + 1);
								attaquant.setEnergie(attaquant.getEnergie()
										+ Constante.COUTMINER);
								((Piegeur) attaquant).nbMine -= 1;
								break;
							case "bas":
								p.plateau[cell_attaquant.ajout(Constante.BAS)
										.getLargeur()][cell_attaquant.ajout(
										Constante.BAS).getHauteur()]
										.setMine(equipe_active + 1);
								attaquant.setEnergie(attaquant.getEnergie()
										+ Constante.COUTMINER);
								((Piegeur) attaquant).nbMine -= 1;
								break;
							case "gauche":
								p.plateau[cell_attaquant
										.ajout(Constante.GAUCHE).getLargeur()][cell_attaquant
										.ajout(Constante.GAUCHE).getHauteur()]
										.setMine(equipe_active + 1);
								attaquant.setEnergie(attaquant.getEnergie()
										+ Constante.COUTMINER);
								((Piegeur) attaquant).nbMine -= 1;
								break;
							case "droit":
								p.plateau[cell_attaquant.ajout(Constante.DROIT)
										.getLargeur()][cell_attaquant.ajout(
										Constante.DROIT).getHauteur()]
										.setMine(equipe_active + 1);
								attaquant.setEnergie(attaquant.getEnergie()
										+ Constante.COUTMINER);
								((Piegeur) attaquant).nbMine -= 1;
								break;
							case "hautgauche":
								p.plateau[cell_attaquant.ajout(
										Constante.HAUTGAUCHE).getLargeur()][cell_attaquant
										.ajout(Constante.HAUTGAUCHE)
										.getHauteur()]
										.setMine(equipe_active + 1);
								attaquant.setEnergie(attaquant.getEnergie()
										+ Constante.COUTMINER);
								((Piegeur) attaquant).nbMine -= 1;
								break;

							case "hautdroit":
								p.plateau[cell_attaquant.ajout(
										Constante.HAUTDROIT).getLargeur()][cell_attaquant
										.ajout(Constante.HAUTDROIT)
										.getHauteur()]
										.setMine(equipe_active + 1);
								attaquant.setEnergie(attaquant.getEnergie()
										+ Constante.COUTMINER);
								((Piegeur) attaquant).nbMine -= 1;
								break;
							case "basgauche":
								p.plateau[cell_attaquant.ajout(
										Constante.BASGAUCHE).getLargeur()][cell_attaquant
										.ajout(Constante.BASGAUCHE)
										.getHauteur()]
										.setMine(equipe_active + 1);
								attaquant.setEnergie(attaquant.getEnergie()
										+ Constante.COUTMINER);
								((Piegeur) attaquant).nbMine -= 1;
								break;
							case "basdroit":
								p.plateau[cell_attaquant.ajout(
										Constante.BASDROIT).getLargeur()][cell_attaquant
										.ajout(Constante.BASDROIT).getHauteur()]
										.setMine(equipe_active + 1);
								attaquant.setEnergie(attaquant.getEnergie()
										+ Constante.COUTMINER);
								((Piegeur) attaquant).nbMine -= 1;
								break;

							}

						} else {

							System.out
									.println("Equipe "
											+ (equipe_active + 1)
											+ ": Quel Robot adverse (numero) sera la cible de l'attaque ?");
							Robot cible = equipeRobot[equipe_passive][scan
									.nextInt()];
							if (attaquant instanceof Tireur) {
								if (attaquant.peutTirer(cible.getCoord())
										&& !p.tir_travers_obstacle(attaquant,
												cible)) {
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTTIRERTIREUR);
									cible.setEnergie(cible.getEnergie()
											+ Constante.DEGATTIREUR);
								} else {
									System.out
											.println("Erreur : Tir impossible");
								}
							} else if (attaquant instanceof Char) {
								if (attaquant.peutTirer(cible.getCoord())
										&& !p.tir_travers_obstacle(attaquant,
												cible)) {
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTTIRERCHAR);
									cible.setEnergie(cible.getEnergie()
											+ Constante.DEGATCHAR);
								} else {
									System.out
											.println("Erreur : Tir impossible");
								}
							}
						}
					}
				} else {
					System.out.println("Ce Robot est mort !");
				}
			} else {
				System.out.println("Non Disponible");
			}
			equipe_passive = equipe_active;
			equipe_active = ++equipe_active % 2;
			miseAJourJeu(equipeRobot, p.plateau);
		}
		scan.close();
	}

	static Robot[] constituer_equipe(Scanner scan, int plateau_1er_dim,
			int plateau_2em_dim, int nb_robot_voulu, int equipe) {
		Coordonnees base = (equipe == 1) ? new Coordonnees(0, 0)
				: new Coordonnees(plateau_1er_dim - 1, plateau_2em_dim - 1);
		Robot[] areturn = new Robot[nb_robot_voulu];
		int nbrRobotEquipe = 0;
		while (nbrRobotEquipe < nb_robot_voulu) {
			System.out
					.println(" Constituez l'equipe "
							+ equipe
							+ " ! \n - 1. Tireur \n - 2. Piegeur \n - 3.Char \n\n Il reste "
							+ (nb_robot_voulu - nbrRobotEquipe)
							+ " robots a placer.");
			int robot = scan.nextInt();
			int i;
			switch (robot) {
			case 1:
				System.out.println("Combien de Tireur souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > nb_robot_voulu) {
					System.out
							.println("Erreur, vous n'avez pas le bon nombre de robot, Recommencez !");
					break;
				}
				for (int j = 0; j < i; j++) {
					areturn[nbrRobotEquipe + j] = new Tireur(equipe,
							nbrRobotEquipe + j);
					areturn[nbrRobotEquipe + j].setCoord(base);
				}
				nbrRobotEquipe += i;
				break;

			case 2:
				System.out.println("Combien de Piegeur souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > nb_robot_voulu) {
					System.out
							.println("Erreur, vous n'avez pas le bon nombre de robot, Recommencez !");
					break;
				}
				for (int j = 0; j < i; j++) {
					areturn[nbrRobotEquipe + j] = new Piegeur(equipe,
							nbrRobotEquipe + j);
					areturn[nbrRobotEquipe + j].setCoord(base);
				}
				nbrRobotEquipe += i;
				break;

			case 3:
				System.out.println("Combien de Char souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > nb_robot_voulu) {
					System.out
							.println("Erreur, vous n'avez pas le bon nombre de robot, Recommencez !");
					break;
				}
				for (int j = 0; j < i; j++) {
					areturn[nbrRobotEquipe + j] = new Char(equipe,
							nbrRobotEquipe + j);
					areturn[nbrRobotEquipe + j].setCoord(base);
				}
				nbrRobotEquipe += i;
				break;
			}
		}
		return areturn;
	}

	/**
	 * Regenere ou detruit un robot
	 * 
	 * @param equipe
	 * @param p
	 */
	public static void miseAJourJeu(Robot[][] equipe, Cellule[][] p) {
		for (int i = 0; i < equipe.length; i++) {
			for (int j = 0; j < equipe[i].length; j++) {
				if (equipe[i][j] != null && equipe[i][j].robotMort()) {
					equipe[i][j] = null;
				} else if (equipe[i][j] != null
						&& i == 0
						&& equipe[i][j].getCoord()
								.equals(new Coordonnees(0, 0))) {
					equipe[0][j].regeneration(p);
				} else if (equipe[i][j] != null
						&& i == 1
						&& equipe[i][j].getCoord().equals(
								new Coordonnees(p.length - 1,
										p[p.length - 1].length - 1))) {
					equipe[1][j].regeneration(p);
				}
			}
		}
	}
}
