
public class Plateau 
{
	private Cellule[][] plateau;
	
	public Plateau(int largeur,int hauteur)
	{
		plateau= new Cellule[largeur][hauteur];
		
		for (int h = 0; h < plateau.length; h++) 
		{
			for (int l = 0; l < plateau[h].length; l++) 
			{
				plateau[l][h]= new Cellule(l, h);				
			}
		}
	}
	
	public String toString()
	{
		String areturn="";
		for (int h = 0; h < plateau.length; h++) 
		{
			for (int l = 0; l < plateau[h].length; l++) 
			{
				Cellule c = plateau[l][h];
				if(c.estBase()==1)
				{
					areturn+="B";
				}
				else if(c.estBase()==2)
				{
					areturn+="b";
				}
				else if(c.contienMine()==1)
				{
					areturn+="M";
				}
				else if(c.contienMine()==2)
				{
					areturn+="m";
				}
				else if(c.getContenu()!=null)
				{
					if(c.getContenu().getEquipe()==1)
					{
						if(c.getContenu() instanceof Char)
						{
							areturn+="C";
						}
						else if(c.getContenu() instanceof Tireur)
						{
							areturn+="T";
						}
						else if(c.getContenu() instanceof Piegeur)
						{
							areturn+="P";
						}
					}
					else
					{
						if(c.getContenu() instanceof Char)
						{
							areturn+="c";
						}
						else if(c.getContenu() instanceof Tireur)
						{
							areturn+="t";
						}
						else if(c.getContenu() instanceof Piegeur)
						{
							areturn+="p";
						}
					}
				}
				else
				{
					areturn+=".";
				}
			}
			areturn+="\n";
		}
		
		return areturn;
	}
	
	public static void main(String[] args) 
	{
		Plateau p = new Plateau(10, 10);
		p.plateau[0][0].base=1;
		p.plateau[9][9].base=2;
		System.out.println(p);
		try 
		{
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		Robot t1=new Tireur(1, 1);
		Robot t2=new Tireur(2, 1);
		
		System.out.println(p);
		
	}
}
