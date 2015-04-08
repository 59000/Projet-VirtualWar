import java.util.List;

public class Tireur extends Robot {

	public Tireur(int equipe,int numero) {/*implémenter*/
		super(equipe,numero, 40);
	}

	@Override
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Coordonnees> getDeplacement() {
		// TODO Auto-generated method stub
		return null;
	}

}
