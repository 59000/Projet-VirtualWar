import java.util.Scanner;

public class Menu {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenue Dans VIRTUAL WAR !");
		int taille = 0;
		while (taille < 5 || taille > 10) {
			System.out
					.println("Tout d'abord, veuillez fixez la taille du plateau de combat.");
			taille = scan.nextInt();
		}

		Plateau p = new Plateau(taille, taille);

		p.plateau[0][0].base = 1;
		p.plateau[taille - 1][taille - 1].base = 2;
		
		int test =0;
		while(p.ya_chemin(p.plateau[0][0])&&test<50000)
		{
			p.genere_obstacle();
			//System.out.println(test);
			test++;
		}

		Robot[] equipeRobot = new Robot[5];

		int nbrRobotEquipe = 0;
		while (nbrRobotEquipe < 5) {
			System.out
					.println(" Constituez les equipes ! \n - 1. Tireur \n - 2. Piegeur \n - 3.Char \n\n Il reste "
							+ (5 - nbrRobotEquipe) + " robots à placer.");
			int robot = scan.nextInt();
			int i;
			switch (robot) {
			case 1:
				System.out.println("Combien de Tireur souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > 5) {
					System.out
							.println("Erreur, vous n'avez pas le bon nombre de robot, Recommancez !");
					break;
				}
				for (int j = 0; j < i; j++) {
					equipeRobot[nbrRobotEquipe + j] = new Tireur(1,
							nbrRobotEquipe + j);
					equipeRobot[nbrRobotEquipe + j].setCoord(new Coordonnees(0,
							0));
				}
				nbrRobotEquipe += i;
				break;

			case 2:
				System.out.println("Combien de Piegeur souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > 5) {
					System.out
							.println("Erreur, vous n'avez pas le bon nombre de robot, Recommancez !");
					break;
				}
				for (int j = 0; j < i; j++) {
					equipeRobot[nbrRobotEquipe + j] = new Piegeur(1,
							nbrRobotEquipe + j);
					equipeRobot[nbrRobotEquipe + j].setCoord(new Coordonnees(0,
							0));
				}
				nbrRobotEquipe += i;
				break;

			case 3:
				System.out.println("Combien de Char souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > 5) {
					System.out
							.println("Erreur, vous n'avez pas le bon nombre de robot, Recommancez !");
					break;
				}
				for (int j = 0; j < i; j++) {
					equipeRobot[nbrRobotEquipe + j] = new Char(1,
							nbrRobotEquipe + j);
					equipeRobot[nbrRobotEquipe + j].setCoord(new Coordonnees(0,
							0));
				}
				nbrRobotEquipe += i;
				break;
			}
		}

		boolean jeu = true;
		while (jeu) {
			System.out.println(p);

			System.out
					.println("+-------------------------------------------------------+");
			for (int j = 0; j < equipeRobot.length; j++) {
				System.out.println("| " + equipeRobot[j].toString() + " |");
			}
			System.out
					.println("+-------------------------------------------------------+");

			System.out
					.println("Quel action souhaitez-vous ? \n - 1. Deplacement \n "
							+ "- 2. Attaquez \n - 3. Quittez le jeu.");

			int i = scan.nextInt();

			if (i == 1) {
				System.out
						.println("Quel Robot (numéro) voulez-vous déplacer ?");
				i = scan.nextInt();
				System.out.println("Dans quel direction ?");
				String msg = scan.next();
				switch (msg) {
				case "haut":
					p.deplaceRobot(equipeRobot[i], Constante.HAUT);
					break;
				case "bas":
					p.deplaceRobot(equipeRobot[i], Constante.BAS);
					break;
				case "gauche":
					p.deplaceRobot(equipeRobot[i], Constante.GAUCHE);
					break;
				case "droit":
					p.deplaceRobot(equipeRobot[i], Constante.DROIT);
					break;
				case "hautgauche":
					p.deplaceRobot(equipeRobot[i], Constante.HAUTGAUCHE);
					break;
				case "hautdroit":
					p.deplaceRobot(equipeRobot[i], Constante.HAUTDROIT);
					break;
				case "basgauche":
					p.deplaceRobot(equipeRobot[i], Constante.BASGAUCHE);
					break;
				case "basdroit":
					p.deplaceRobot(equipeRobot[i], Constante.BASDROIT);
					break;
				}
			} else if (i == 3) {
				System.out.println("Fin du jeu !");
				jeu = false;
			} else {
				System.out.println("Non Disponible");
			}
		}
	}
}
