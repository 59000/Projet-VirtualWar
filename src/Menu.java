import java.util.Scanner;

public class Menu 
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenue Dans VIRTUAL WAR !");
		int taille = 0;
		while (taille < 5 || taille > 10) {
			System.out
					.println("Tout d'abord, veuillez fixez la taille du plateau de combat.");
			taille = 5;//scan.nextInt();--------------------------------------------------------------------------------------------------------------------------------------------------------------
		}

		Plateau p = new Plateau(taille, taille);

		p.plateau[0][0].base = 1;
		p.plateau[taille - 1][taille - 1].base = 2;
		
		/*int test =0;
		while(p.ya_chemin(p.plateau[0][0])&&test<50000)
		{
			p.genere_obstacle();
			System.out.println(test);
			test++;
		}*/

		int nb_robot_voulu;
		do
		{
			System.out.println("combien de robot voulez vous dans vos équipes ?");
			nb_robot_voulu = scan.nextInt();
		}while (nb_robot_voulu > 5||nb_robot_voulu<1);
		
		 Robot[][] equipeRobot = {Menu.constituer_equipe(scan,p.plateau.length,p.plateau[0].length,nb_robot_voulu,1),Menu.constituer_equipe(scan,p.plateau.length,p.plateau[0].length,nb_robot_voulu,2)};
		// Robot[] equipe2Robot = Menu.constituer_equipe(scan,p.plateau.length,p.plateau[0].length,nb_robot_voulu,2);

		boolean jeu = true;
		int equipe_pasive =0;
		int equipe_active =0;
		while (jeu) 
		{
			System.out.println(p);

			System.out.println("+---------------------------------------------------------------++---------------------------------------------------------------+");
			for (int j = 0; j < equipeRobot[0].length; j++) 
			{
				
				System.out.println("| " + equipeRobot[0][j].toString() + "|"+"| " + equipeRobot[1][j].toString() + "|");
			}
			System.out.println("+---------------------------------------------------------------++---------------------------------------------------------------+");

			System.out.println("Equipe "+(equipe_active+1)+": Quel action souhaitez-vous ? \n - 1. Deplacement \n "
							+ "- 2. Attaquez \n - 3. Quittez le jeu.");

			int i = scan.nextInt();

			if (i == 1) {
				System.out.println("Equipe "+(equipe_active+1)+": Quel Robot (numero) voulez-vous deplacer ?");
				i = scan.nextInt();
				System.out.println("Equipe "+(equipe_active+1)+": Dans quel direction ? (haut,bas,gauche,droit,hautgauche,hautdroit,basgauche,basdroit)");
				String msg = scan.next();
				switch (msg) {
				case "haut":
					p.deplaceRobot(equipeRobot[equipe_active][i], Constante.HAUT);
					break;
				case "bas":
					p.deplaceRobot(equipeRobot[equipe_active][i], Constante.BAS);
					break;
				case "gauche":
					p.deplaceRobot(equipeRobot[equipe_active][i], Constante.GAUCHE);
					break;
				case "droit":
					p.deplaceRobot(equipeRobot[equipe_active][i], Constante.DROIT);
					break;
				case "hautgauche":
					p.deplaceRobot(equipeRobot[equipe_active][i], Constante.HAUTGAUCHE);
					break;
				case "hautdroit":
					p.deplaceRobot(equipeRobot[equipe_active][i], Constante.HAUTDROIT);
					break;
				case "basgauche":
					p.deplaceRobot(equipeRobot[equipe_active][i], Constante.BASGAUCHE);
					break;
				case "basdroit":
					p.deplaceRobot(equipeRobot[equipe_active][i], Constante.BASDROIT);
					break;
				}
			} else if (i == 3) {
				System.out.println("Fin du jeu !");
				jeu = false;
			}else if (i == 2) 
			{
				System.out.println("Equipe "+equipe_active+": Quel Robot (numero) voulez-vous faire attaquer ?");
				Robot attaquant = equipeRobot[equipe_active][scan.nextInt()];
				if(p.plateau[attaquant.getCoord().getLargeur()][attaquant.getCoord().getHauteur()].estBase()==attaquant.getEquipe())
				{
					System.out.println("Erreur : une attaque depuis une base est impossible");
				}
				else
				{
					if( attaquant instanceof Piegeur)
					{
						System.out.println("Equipe "+(equipe_active+1)+": dans quelle direction le piégeur doit il poser sa mine ?(haut,bas,gauche,droit)");
						Cellule cell_attaquant =p.plateau[attaquant.getCoord().getLargeur()][attaquant.getCoord().getHauteur()];
						String dir = scan.next();
						switch (dir) 
						{
						case "haut":
							p.plateau[cell_attaquant.ajout(Constante.HAUT).getLargeur()][cell_attaquant.ajout(Constante.HAUT).getHauteur()].setMine(equipe_active+1);
							attaquant.setEnergie(attaquant.getEnergie()+Constante.COUTMINER);
							((Piegeur) attaquant).nbMine-=1;
							break;
						case "bas":
							p.plateau[cell_attaquant.ajout(Constante.BAS).getLargeur()][cell_attaquant.ajout(Constante.BAS).getHauteur()].setMine(equipe_active+1);
							attaquant.setEnergie(attaquant.getEnergie()+Constante.COUTMINER);
							break;
						case "gauche":
							p.plateau[cell_attaquant.ajout(Constante.GAUCHE).getLargeur()][cell_attaquant.ajout(Constante.GAUCHE).getHauteur()].setMine(equipe_active+1);
							attaquant.setEnergie(attaquant.getEnergie()+Constante.COUTMINER);
							break;
						case "droit":
							p.plateau[cell_attaquant.ajout(Constante.DROIT).getLargeur()][cell_attaquant.ajout(Constante.DROIT).getHauteur()].setMine(equipe_active+1);
							attaquant.setEnergie(attaquant.getEnergie()+Constante.COUTMINER);
							break;
						}
					}
					else
					{
						
							System.out.println("Equipe "+(equipe_active+1)+": Quel Robot adverse (numero) sera la cible de l'attaque ?");
							Robot cible = equipeRobot[equipe_pasive][scan.nextInt()];
							System.out.println(cible);//-----------------------------------------------------------------------------------------------reste cettte attque la a faire mais 1h30 alr dodo
							//---------------------------------------------reste aussi a gerer les exception et le menu sera je pense fini
							//-------------------------------a non regen de energie et mines et supr le robot qui a energie <=0
					}
				}
			}
			else {
				System.out.println("Non Disponible");
			}
			equipe_pasive=equipe_active;
			equipe_active=++equipe_active%2;
		}
		scan.close();
	}
	
	static Robot[] constituer_equipe(Scanner scan,int plateau_1er_dim,int plateau_2em_dim,int nb_robot_voulu, int equipe)
	{
		Coordonnees base = (equipe == 1) ? new Coordonnees(0, 0):new Coordonnees(plateau_1er_dim-1, plateau_2em_dim-1);
		Robot[] areturn = new Robot[nb_robot_voulu];
		int nbrRobotEquipe = 0;
		while (nbrRobotEquipe < nb_robot_voulu) 
		{
			System.out.println(" Constituez l'equipe "+equipe+" ! \n - 1. Tireur \n - 2. Piegeur \n - 3.Char \n\n Il reste "
					+ (nb_robot_voulu - nbrRobotEquipe) + " robots aÂ  placer.");
			int robot = scan.nextInt();
			int i;
			switch (robot) {
			case 1:
				System.out.println("Combien de Tireur souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > nb_robot_voulu) {
					System.out.println("Erreur, vous n'avez pas le bon nombre de robot, Recommencez !");
					break;
				}
				for (int j = 0; j < i; j++) {
					areturn[nbrRobotEquipe + j] = new Tireur(equipe,nbrRobotEquipe + j);
					areturn[nbrRobotEquipe + j].setCoord(base);
				}
				nbrRobotEquipe += i;
				break;
			
			case 2:
				System.out.println("Combien de Piegeur souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > nb_robot_voulu) {
					System.out.println("Erreur, vous n'avez pas le bon nombre de robot, Recommencez !");
					break;
				}
				for (int j = 0; j < i; j++) {
					areturn[nbrRobotEquipe + j] = new Piegeur(equipe,nbrRobotEquipe + j);
					areturn[nbrRobotEquipe + j].setCoord(base);
				}
				nbrRobotEquipe += i;
				break;
			
			case 3:
				System.out.println("Combien de Char souhaitez-vous ?");
				i = scan.nextInt();
				if (nbrRobotEquipe + i > nb_robot_voulu) {
					System.out.println("Erreur, vous n'avez pas le bon nombre de robot, Recommencez !");
					break;
				}
				for (int j = 0; j < i; j++) 
				{
					areturn[nbrRobotEquipe + j] = new Char(equipe,nbrRobotEquipe + j);
					areturn[nbrRobotEquipe + j].setCoord(base);
				}
				nbrRobotEquipe += i;
				break;
			}
		}
		return areturn;
	}
}
