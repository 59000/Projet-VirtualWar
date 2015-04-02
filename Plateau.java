
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
				if(plateau[l][h].estBase()!=0)
				{
					areturn+="B";
				}
				else if(plateau[l][h].contienMine()!=0)
				{
					areturn+="M";
				}
				else if(plateau[l][h].getContenu()!=null)
				{
					areturn+="R";
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
		Plateau p = new Plateau(5, 5);
		p.plateau[2][2].
		
		System.out.println(p);
		
	}
}
