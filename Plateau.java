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
				areturn = "+--";//pas fini et marche pas
			}
		}
		
		return areturn;
	}
	
	public static void main(String[] args) 
	{
		Plateau p = new Plateau(5, 5);
		
		System.out.println(p);
		
	}
}

