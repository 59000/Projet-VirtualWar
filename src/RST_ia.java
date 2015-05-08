package ia;

import Robot.Piegeur;
import Robot.Robot;
import Robot.Tireur;

public class RST_ia extends IA //++++++++++++++++++++++cette ia ne marche que en equipe 2 et sans obstacles+++++++++++++++++++++++(pour l'instant)+++++++++
{
	/* accessible ds ia
	int equipe;
	Robot[] robots;*/
	private int compteur;
	private int compteur2=0;
	
	public RST_ia(int equipe) 
	{
		super(equipe);
		compteur=0;
	}

	@Override
	public Robot[] constitution_equipes(int nb_robot) 
	{
		Robot[] mon_equipe = new Robot[nb_robot];
		
		if(nb_robot == 1)
		{
			//juste un tireur
			mon_equipe[0]= new Tireur(equipe,0);
		}
		else if(nb_robot == 2)
		{
			// piegeur et tireur
			mon_equipe[0]= new Tireur(equipe,0);
			mon_equipe[1]= new Piegeur(equipe,1);
		}
		else
		{
			//piegeur et tireur et bourage tireur
			mon_equipe[0]= new Tireur(equipe,0);
			mon_equipe[1]= new Piegeur(equipe,1);
			for(int i=2;i<nb_robot;i++)
			{
				mon_equipe[i]=new Tireur(equipe,i);
			}
		}
		
		robots = mon_equipe;
		return mon_equipe;
	}

	@Override
	public int selection_action() 
	{
		/* 1 dep
		 * 2 att
		 */
		if(robots.length>=2)
		{
			int action=0;
			if(compteur==0)
			{
				action=1;
			}
			else if(compteur <6)
			{
				action = 2;
			}
			else if(compteur <8)
			{
				action = 1;
			}
			else
			{
				int compteur2=(compteur-8)%(robots.length+1);
				if(compteur2<robots.length)
				{
					action = 2;
				}
				else
				{
					action = 1;
				}
			}
			return action;
		}
		
		return -42;
	}

	@Override
	public Robot selection_robot_actif() 
	{
		if(robots.length>=2)
		{
			Robot areturn = null;
			if(compteur==0)
			{
				areturn = robots[1];
			}
			else if(compteur <6)
			{
				areturn = robots[1];
			}
			else if(compteur ==6)
			{
				areturn = robots[1];
			}
			else if(compteur ==7)
			{
				areturn = robots[0];
			}
			else
			{
				areturn = robots[0];
			}
			return areturn;
		}
		return null;
	}

	@Override
	public String selection_direction_deplacement(Robot robot) 
	{
		if(robots.length>=2)
		{
			String areturn = "";
			if(compteur==0)
			{
				areturn = "hautgauche";
				compteur++;
			}
			else if(compteur ==6)
			{
				areturn = "basdroit";
				compteur++;
			}
			else if(compteur ==7)
			{
				areturn = "gauche";
				compteur++;
			}
			else
			{
				System.out.println("**********************************************************************************************"+compteur2%4);
				switch (compteur2%4) 
				{
					case 0:
						areturn="haut";
					break;
					case 1:
						areturn="droit";
					break;
					case 2:
						areturn="gauche";
					break;
					case 3:
						areturn="bas";
					break;
				}
				compteur2++;
				compteur++;
			}
			return areturn;
		}
		return null;
	}

	@Override
	public String selection_direction_attaque(Piegeur p) 
	{
		if(robots.length>=2)
		{
			if(compteur ==1)
			{
				compteur++;
				return "basgauche";
			}
			if(compteur ==2)
			{
				compteur++;
				return "gauche";
			}
			if(compteur ==3)
			{
				compteur++;
				return "hautgauche";
			}
			if(compteur ==4)
			{
				compteur++;
				return "haut";
			}
			if(compteur ==5)
			{
				compteur++;
				return "hautdroit";
			}
		}
		return null;
	}

	@Override
	public int selection_robot_cible(Robot robot) 
	{
		compteur++;
		return (compteur-8)%(robots.length);
	}

}
