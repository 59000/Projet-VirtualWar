package Menu;

import ia.Aleatoire;
import ia.IA;
import ia.RST_ia;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Constante.Constante;
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

	/** Lance le mode de jeu Joueur Contre IA */
	public static void joueurVsIa() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenue Dans VIRTUAL WAR !");
		int taille = 0;
		while (taille < 5 || taille > 10) {
			System.out
					.println("Tout d'abord, veuillez fixez la taille du plateau de combat.");
			taille = scan.nextInt();
		}
		int obs = -1;
		while (obs < 0 || obs > 100) {
			System.out
					.println("Combien de pourcentages d'obstacles voulez vous ?");
			obs = scan.nextInt();
		}
		Cellule.pourcentage = obs;

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
		IA ia;
		if(Cellule.pourcentage == 0){
			
			String diff;
			do {
				System.out
						.println("Selection du mode de difficulte (facile ou normal)");
				diff = scan.next();
			} while (!diff.equals("facile") && !diff.equals("normal"));
			
			
			
			if (diff.equals("facile")) {
				ia = new Aleatoire(2);
			} else { 
				ia = new RST_ia(2);
			}
		}
		else{
		ia = new Aleatoire(2);
		}
		Robot[][] equipeRobot = {
				Menu.constituer_equipe(scan, p.plateau.length,
						p.plateau[0].length, nb_robot_voulu, 1),
				ia.constitution_equipes(nb_robot_voulu) };
		for (int i = 0; i < equipeRobot[0].length; i++) {
			equipeRobot[0][i].setCoord(new Coordonnees(0, 0));
			equipeRobot[1][i].setCoord(new Coordonnees(taille - 1, taille - 1));
		}
		boolean jeu = true;

		int equipe_passive = 0;
		int equipe_active = 0;
		while (jeu) {
			boolean changementDequipe = true;
			System.out.println(p);

			System.out
					.println("+---------------------------------------------------------------++---------------------------------------------------------------+");
			for (int j = 0; j < equipeRobot[0].length; j++) {
				if (equipeRobot[1][j] == null && equipeRobot[0][j] == null) {
					System.out.println("|                  robot " + j
							+ " mort                                 |"
							+ "|                  robot " + j
							+ " mort                                 |");

				} else if (equipeRobot[1][j] == null) {
					System.out.println("| " + equipeRobot[0][j].toString()
							+ "|" + "|                  robot " + j
							+ " mort                                 |");
				} else if (equipeRobot[0][j] == null) {
					System.out.println("|                  robot " + j
							+ " mort                                 |" + "| "
							+ equipeRobot[1][j].toString() + "|");
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
			int i;
			if (equipe_active == 0) {
				i = scan.nextInt();
			} else {
				i = ia.selection_action();
			}
			if (i == 1) {
				boolean flag = true;
				while (flag) {
					System.out.println("Equipe " + (equipe_active + 1)
							+ ": Quel Robot (numero) voulez-vous deplacer ?");

					try {
						if (equipe_active == 0) {
							i = scan.nextInt();
						} else {
							i = ia.selection_robot_actif().getNumero();
						}
						if (equipeRobot[equipe_active][i] != null) {
							equipeRobot[equipe_active][i].getNumero();
						} else {
							System.err.println("Ce Robot est mort !");
							changementDequipe = false;
						}
						flag = false;
					} catch (InputMismatchException e) {
						System.err.println("Erreur : Entier attendu");
						changementDequipe = false;
						flag = true;
						i = 0;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println("Erreur : Robot non existant");
						changementDequipe = false;
						flag = true;
						i = 0;
					}
				}
				if (equipeRobot[equipe_active][i] != null) {
					System.out
							.println("Equipe "
									+ (equipe_active + 1)
									+ ": Dans quel direction ? (haut,bas,gauche,droit,hautgauche,hautdroit,basgauche,basdroit)");
					String msg;
					if (equipe_active == 0) {
						msg = scan.next();
					} else {
						msg = ia.selection_direction_deplacement(equipeRobot[equipe_active][i]);// scan.next();
					}
					switch (msg) {
					case "haut":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUT)) {
							changementDequipe = false;
						}
						break;
					case "bas":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BAS)) {
							changementDequipe = false;
						}
						break;
					case "gauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.GAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "droit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.DROIT)) {
							changementDequipe = false;
						}
						break;
					case "hautgauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUTGAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "hautdroit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUTDROIT)) {
							changementDequipe = false;
						}
						break;
					case "basgauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BASGAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "basdroit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BASDROIT)) {
							changementDequipe = false;
						}
						break;

					}
				}

			} else if (i == 3) {
				System.out.println("Fin du jeu !");
				jeu = false;
			} else if (i == 2) {
				System.out.println("Equipe " + (equipe_active + 1)
						+ ": Quel Robot (numero) voulez-vous faire attaquer ?");
				Robot attaquant;
				if (equipe_active == 0) {
					attaquant = equipeRobot[equipe_active][scan.nextInt()];
				} else {
					attaquant = equipeRobot[equipe_active][ia
							.selection_robot_actif().getNumero()];
				}

				if (attaquant != null) {
					if (p.plateau[attaquant.getCoord().getLargeur()][attaquant
							.getCoord().getHauteur()].estBase() == attaquant
							.getEquipe()) {
						System.err
								.println("Erreur : une attaque depuis une base est impossible");
						changementDequipe = false;
					} else {
						if (attaquant instanceof Piegeur) {
							System.out
									.println("Equipe "
											+ (equipe_active + 1)
											+ ": dans quelle direction le piegeur doit il poser sa mine ?(haut,bas,gauche,droit,basgauche,basdroit,hautgauche,hautdroit)");
							Cellule cell_attaquant = p.plateau[attaquant
									.getCoord().getLargeur()][attaquant
									.getCoord().getHauteur()];
							String dir;
							if (equipe_active == 0) {
								dir = scan.next();
							} else {
								dir = ia.selection_direction_attaque((Piegeur) attaquant);// scan.next();
							}
							switch (dir) {
							case "haut":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0) {

									p.plateau[cell_attaquant.ajout(
											Constante.HAUT).getLargeur()][cell_attaquant
											.ajout(Constante.HAUT).getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "bas":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.BAS).getLargeur()][cell_attaquant
											.ajout(Constante.BAS).getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;

							case "gauche":
								if (cell_attaquant.ajout(Constante.GAUCHE)
										.getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.GAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.GAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "droit":
								if (cell_attaquant.ajout(Constante.DROIT)
										.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.DROIT).getLargeur()][cell_attaquant
											.ajout(Constante.DROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "hautgauche":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0
										&& cell_attaquant.ajout(
												Constante.GAUCHE).getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.HAUTGAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.HAUTGAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;

							case "hautdroit":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0
										&& cell_attaquant
												.ajout(Constante.DROIT)
												.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.HAUTDROIT).getLargeur()][cell_attaquant
											.ajout(Constante.HAUTDROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "basgauche":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1
										&& cell_attaquant.ajout(
												Constante.GAUCHE).getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.BASGAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.BASGAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "basdroit":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1
										&& cell_attaquant
												.ajout(Constante.DROIT)
												.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.BASDROIT).getLargeur()][cell_attaquant
											.ajout(Constante.BASDROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;

							}

						} else {

							System.out
									.println("Equipe "
											+ (equipe_active + 1)
											+ ": Quel Robot adverse (numero) sera la cible de l'attaque ?");
							Robot cible;
							if (equipe_active == 0) {
								cible = equipeRobot[equipe_passive][scan
										.nextInt()];
							} else {
								cible = equipeRobot[equipe_passive][ia
										.selection_robot_cible(attaquant)];
							}
							if (attaquant instanceof Tireur && cible != null) {
								if (attaquant.peutTirer(cible.getCoord())
										&& !p.tir_travers_obstacle(attaquant,
												cible)) {
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTTIRERTIREUR);
									cible.setEnergie(cible.getEnergie()
											+ Constante.DEGATTIREUR);
								} else {
									System.err
											.println("Erreur : Tir impossible");
									changementDequipe = false;
								}
							} else if (attaquant instanceof Char
									&& cible != null) {
								if (attaquant.peutTirer(cible.getCoord())
										&& !p.tir_travers_obstacle(attaquant,
												cible)) {
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTTIRERCHAR);
									cible.setEnergie(cible.getEnergie()
											+ Constante.DEGATCHAR);
								} else {
									System.err
											.println("Erreur : Tir impossible");
									changementDequipe = false;
								}
							}
						}
					}
				} else {
					System.err.println("Ce Robot est mort !");
					changementDequipe = false;
				}
			} else {
				System.out.println("Non Disponible");
				changementDequipe = false;
			}
			if (changementDequipe) {
				equipe_passive = equipe_active;
				equipe_active = ++equipe_active % 2;
			}
			miseAJourJeu(equipeRobot, p.plateau);
			jeu = finDeJeu(equipeRobot);

		}

	}

	/** Lance le mode de jeu IA Contre IA */
	public static void iaVsIa() {
		/**
		 * --------------------------------------------------------------------
		 * -------------
		 */
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenue Dans VIRTUAL WAR !");
		int taille = 0;
		while (taille < 5 || taille > 10) {
			System.out
					.println("Tout d'abord, veuillez fixez la taille du plateau de combat.");
			taille = scan.nextInt();
		}
		int obs = -1;
		while (obs < 0 || obs > 100) {
			System.out
					.println("Combien de pourcentages d'obstacles voulez vous ?");
			obs = scan.nextInt();
		}
		Cellule.pourcentage = obs;

		Plateau p = new Plateau(taille, taille);

		p.plateau[0][0].base = Constante.BASE1;
		p.plateau[taille - 1][taille - 1].base = Constante.BASE2;
		p.genere_obstacle(p.plateau[0][0]);

		int nb_robot_voulu;
		do {
			nb_robot_voulu = r.nextInt(5) + 1;
		} while (nb_robot_voulu > 5 || nb_robot_voulu < 1);

		scan.close();

		IA[] equipe = new IA[] { new Aleatoire(1), new Aleatoire(2) };

		Robot[][] equipeRobot = {
				equipe[0].constitution_equipes(nb_robot_voulu),
				equipe[1].constitution_equipes(nb_robot_voulu) };

		for (int i = 0; i < equipeRobot[0].length; i++) {
			equipeRobot[0][i].setCoord(new Coordonnees(0, 0));
			equipeRobot[1][i].setCoord(new Coordonnees(taille - 1, taille - 1));
		}

		boolean jeu = true;
		int equipe_passive = 0;
		int equipe_active = 0;
		while (jeu) {
			boolean changementDequipe = true;
			System.out.println(p);

			System.out
					.println("+---------------------------------------------------------------++---------------------------------------------------------------+");
			for (int j = 0; j < equipeRobot[0].length; j++) {
				if (equipeRobot[1][j] == null && equipeRobot[0][j] == null) {
					System.out.println("|                  robot " + j
							+ " mort                                 |"
							+ "|                  robot " + j
							+ " mort                                 |");

				} else if (equipeRobot[1][j] == null) {
					System.out.println("| " + equipeRobot[0][j].toString()
							+ "|" + "|                  robot " + j
							+ " mort                                 |");
				} else if (equipeRobot[0][j] == null) {
					System.out.println("|                  robot " + j
							+ " mort                                 |" + "| "
							+ equipeRobot[1][j].toString() + "|");
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

			int i = equipe[equipe_active].selection_action();// scan.nextInt();

			if (i == 1) {
				boolean flag = true;
				while (flag) {
					System.out.println("Equipe " + (equipe_active + 1)
							+ ": Quel Robot (numero) voulez-vous deplacer ?");

					try {
						i = equipe[equipe_active].selection_robot_actif()
								.getNumero();// scan.nextInt();
						if (equipeRobot[equipe_active][i] != null) {
							equipeRobot[equipe_active][i].getNumero();
						} else {
							System.err.println("Ce Robot est mort !");
							changementDequipe = false;
						}
						flag = false;
					} catch (InputMismatchException e) {
						System.err.println("Erreur : Entier attendu");
						changementDequipe = false;
						flag = true;
						i = 0;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println("Erreur : Robot non existant");
						changementDequipe = false;
						flag = true;
						i = 0;

					}
				}

				if (equipeRobot[equipe_active][i] != null) {
					System.out
							.println("Equipe "
									+ (equipe_active + 1)
									+ ": Dans quel direction ? (haut,bas,gauche,droit,hautgauche,hautdroit,basgauche,basdroit)");
					String msg = equipe[equipe_active]
							.selection_direction_deplacement(equipeRobot[equipe_active][i]);// scan.next();

					switch (msg) {
					case "haut":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUT)) {
							changementDequipe = false;
						}
						break;
					case "bas":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BAS)) {
							changementDequipe = false;
						}
						break;
					case "gauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.GAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "droit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.DROIT)) {
							changementDequipe = false;
						}
						break;
					case "hautgauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUTGAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "hautdroit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUTDROIT)) {
							changementDequipe = false;
						}
						break;
					case "basgauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BASGAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "basdroit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BASDROIT)) {
							changementDequipe = false;
						}
						break;

					}
				}

			} else if (i == 3) {
				System.out.println("Fin du jeu !");
				jeu = false;
			} else if (i == 2) {
				System.out.println("Equipe " + (equipe_active + 1)
						+ ": Quel Robot (numero) voulez-vous faire attaquer ?");
				Robot attaquant = equipeRobot[equipe_active][equipe[equipe_active]
						.selection_robot_actif().getNumero()];
				if (attaquant != null) {
					if (p.plateau[attaquant.getCoord().getLargeur()][attaquant
							.getCoord().getHauteur()].estBase() == attaquant
							.getEquipe()) {
						System.err
								.println("Erreur : une attaque depuis une base est impossible");
						changementDequipe = false;
					} else {
						if (attaquant instanceof Piegeur) {
							System.out
									.println("Equipe "
											+ (equipe_active + 1)
											+ ": dans quelle direction le piegeur doit il poser sa mine ?(haut,bas,gauche,droit,basgauche,basdroit,hautgauche,hautdroit)");
							Cellule cell_attaquant = p.plateau[attaquant
									.getCoord().getLargeur()][attaquant
									.getCoord().getHauteur()];
							String dir = equipe[equipe_active]
									.selection_direction_attaque((Piegeur) attaquant);// scan.next();
							switch (dir) {
							case "haut":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0) {

									p.plateau[cell_attaquant.ajout(
											Constante.HAUT).getLargeur()][cell_attaquant
											.ajout(Constante.HAUT).getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "bas":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.BAS).getLargeur()][cell_attaquant
											.ajout(Constante.BAS).getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;

							case "gauche":
								if (cell_attaquant.ajout(Constante.GAUCHE)
										.getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.GAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.GAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "droit":
								if (cell_attaquant.ajout(Constante.DROIT)
										.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.DROIT).getLargeur()][cell_attaquant
											.ajout(Constante.DROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "hautgauche":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0
										&& cell_attaquant.ajout(
												Constante.GAUCHE).getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.HAUTGAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.HAUTGAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;

							case "hautdroit":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0
										&& cell_attaquant
												.ajout(Constante.DROIT)
												.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.HAUTDROIT).getLargeur()][cell_attaquant
											.ajout(Constante.HAUTDROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "basgauche":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1
										&& cell_attaquant.ajout(
												Constante.GAUCHE).getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.BASGAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.BASGAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "basdroit":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1
										&& cell_attaquant
												.ajout(Constante.DROIT)
												.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.BASDROIT).getLargeur()][cell_attaquant
											.ajout(Constante.BASDROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							}

						} else {

							System.out
									.println("Equipe "
											+ (equipe_active + 1)
											+ ": Quel Robot adverse (numero) sera la cible de l'attaque ?");
							Robot cible = equipeRobot[equipe_passive][equipe[equipe_active]
									.selection_robot_cible(attaquant)];
							if (attaquant instanceof Tireur && cible != null) {
								if (attaquant.peutTirer(cible.getCoord())
										&& !p.tir_travers_obstacle(attaquant,
												cible)) {
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTTIRERTIREUR);
									cible.setEnergie(cible.getEnergie()
											+ Constante.DEGATTIREUR);
								} else {
									System.err
											.println("Erreur : Tir impossible");
									changementDequipe = false;
								}
							} else if (attaquant instanceof Char
									&& cible != null) {
								if (attaquant.peutTirer(cible.getCoord())
										&& !p.tir_travers_obstacle(attaquant,
												cible)) {
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTTIRERCHAR);
									cible.setEnergie(cible.getEnergie()
											+ Constante.DEGATCHAR);
								} else {
									System.err
											.println("Erreur : Tir impossible");
									changementDequipe = false;
								}
							}
						}
					}
				} else {
					System.err.println("Ce Robot est mort !");
					changementDequipe = false;
				}
			} else {
				System.out.println("Non Disponible");
				changementDequipe = false;
			}
			if (changementDequipe) {
				equipe_passive = equipe_active;
				equipe_active = ++equipe_active % 2;
			}
			miseAJourJeu(equipeRobot, p.plateau);
			jeu = finDeJeu(equipeRobot);

		}

	}

	/** Lance le mode de jeu Joueur Contre Joueur */
	public static void joueurVsJoueur() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenue Dans VIRTUAL WAR !");
		int taille = 0;
		while (taille < 5 || taille > 10) {
			System.out
					.println("Tout d'abord, veuillez fixez la taille du plateau de combat.");
			
			taille = scan.nextInt();
		}
		int obs = -1;
		while (obs < 0 || obs > 100) {
			System.out
					.println("Combien de pourcentages d'obstacles voulez vous ?");
		
				obs = scan.nextInt();
			
			
		}
		Cellule.pourcentage = obs;

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
			boolean changementDequipe = true;
			System.out.println(p);

			System.out
					.println("+---------------------------------------------------------------++---------------------------------------------------------------+");
			for (int j = 0; j < equipeRobot[0].length; j++) {
				if (equipeRobot[1][j] == null && equipeRobot[0][j] == null) {
					System.out.println("|                  robot " + j
							+ " mort                                 |"
							+ "|                  robot " + j
							+ " mort                                 |");

				} else if (equipeRobot[1][j] == null) {
					System.out.println("| " + equipeRobot[0][j].toString()
							+ "|" + "|                  robot " + j
							+ " mort                                 |");
				} else if (equipeRobot[0][j] == null) {
					System.out.println("|                  robot " + j
							+ " mort                                 |" + "| "
							+ equipeRobot[1][j].toString() + "|");
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
							System.err.println("Ce Robot est mort !");
							changementDequipe = false;
						}
						flag = false;
					} catch (InputMismatchException e) {
						System.err.println("Erreur : Entier attendu");
						changementDequipe = false;
						flag = true;
						i = 0;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println("Erreur : Robot non existant");
						changementDequipe = false;
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
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUT)) {
							changementDequipe = false;
						}
						break;
					case "bas":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BAS)) {
							changementDequipe = false;
						}
						break;
					case "gauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.GAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "droit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.DROIT)) {
							changementDequipe = false;
						}
						break;
					case "hautgauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUTGAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "hautdroit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.HAUTDROIT)) {
							changementDequipe = false;
						}
						break;
					case "basgauche":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BASGAUCHE)) {
							changementDequipe = false;
						}
						break;
					case "basdroit":
						if (p.deplaceRobot(equipeRobot[equipe_active][i],
								Constante.BASDROIT)) {
							changementDequipe = false;
						}
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
						System.err
								.println("Erreur : une attaque depuis une base est impossible");
						changementDequipe = false;
					} else {
						if (attaquant instanceof Piegeur) {
							System.out
									.println("Equipe "
											+ (equipe_active + 1)
											+ ": dans quelle direction le piegeur doit il poser sa mine ?(haut,bas,gauche,droit,basgauche,basdroit,hautgauche,hautdroit)");
							Cellule cell_attaquant = p.plateau[attaquant
									.getCoord().getLargeur()][attaquant
									.getCoord().getHauteur()];
							String dir = scan.next();
							switch (dir) {
							case "haut":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0) {

									p.plateau[cell_attaquant.ajout(
											Constante.HAUT).getLargeur()][cell_attaquant
											.ajout(Constante.HAUT).getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "bas":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.BAS).getLargeur()][cell_attaquant
											.ajout(Constante.BAS).getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;

							case "gauche":
								if (cell_attaquant.ajout(Constante.GAUCHE)
										.getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.GAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.GAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "droit":
								if (cell_attaquant.ajout(Constante.DROIT)
										.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.DROIT).getLargeur()][cell_attaquant
											.ajout(Constante.DROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "hautgauche":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0
										&& cell_attaquant.ajout(
												Constante.GAUCHE).getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.HAUTGAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.HAUTGAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;

							case "hautdroit":
								if (cell_attaquant.ajout(Constante.HAUT)
										.getHauteur() >= 0
										&& cell_attaquant
												.ajout(Constante.DROIT)
												.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.HAUTDROIT).getLargeur()][cell_attaquant
											.ajout(Constante.HAUTDROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "basgauche":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1
										&& cell_attaquant.ajout(
												Constante.GAUCHE).getLargeur() >= 0) {
									p.plateau[cell_attaquant.ajout(
											Constante.BASGAUCHE).getLargeur()][cell_attaquant
											.ajout(Constante.BASGAUCHE)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
								break;
							case "basdroit":
								if (cell_attaquant.ajout(Constante.BAS)
										.getHauteur() <= p.plateau.length - 1
										&& cell_attaquant
												.ajout(Constante.DROIT)
												.getLargeur() <= p.plateau[0].length - 1) {
									p.plateau[cell_attaquant.ajout(
											Constante.BASDROIT).getLargeur()][cell_attaquant
											.ajout(Constante.BASDROIT)
											.getHauteur()]
											.setMine(equipe_active + 1);
									attaquant.setEnergie(attaquant.getEnergie()
											+ Constante.COUTMINER);
									((Piegeur) attaquant).nbMine -= 1;
								} else {
									System.err
											.println("La mine doit etre dans le plateau");
									changementDequipe = false;
								}
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
									System.err
											.println("Erreur : Tir impossible");
									changementDequipe = false;
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
									System.err
											.println("Erreur : Tir impossible");
									changementDequipe = false;
								}
							}
						}
					}
				} else {
					System.err.println("Ce Robot est mort !");
					changementDequipe = false;
				}
			} else {
				System.out.println("Non Disponible");
				changementDequipe = false;
			}
			if (changementDequipe) {

				equipe_passive = equipe_active;
				equipe_active = ++equipe_active % 2;
			}
			miseAJourJeu(equipeRobot, p.plateau);
			jeu = finDeJeu(equipeRobot);

		}
		scan.close();
	}

	/**
	 * Permet de constituer equipe manuellement @param scan @param
	 * plateau_1er_dim @param plateau_2em_dim @param nb_robot_voulu @param
	 * equipe
	 */
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
					System.err
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
					System.err
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
					System.err
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
					p[equipe[i][j].getCoord().getLargeur()][equipe[i][j]
							.getCoord().getHauteur()].videCase();
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

	/** Detecte si le jeu est fini et declare equipe gagnante @param equipe */
	public static boolean finDeJeu(Robot[][] equipe) {
		for (int i = 0; i < equipe.length; i++) {
			int nbMort = 0;
			for (int j = 0; j < equipe[i].length; j++) {
				if (equipe[i][j] == null) {
					nbMort++;
				}
			}
			if (nbMort == equipe[i].length) {
				if (i == 0) {
					System.out.println("L'equipe 2 Gagne");
					System.exit(0);
				
				} else if (i == 1) {
					System.out.println("L'equipe 1 Gagne");
					System.exit(0);
				}
			}
		}
		return true;
	}
}
