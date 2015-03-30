
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
	
	//pas fini de reflechir
}
