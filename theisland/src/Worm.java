
public class Worm extends Herbivore{
	

	private String name;
	private static int counter = 0;
	private int id = counter++;
	
	
	
	
	public Worm(int x, int y, String species, int energy, char symbol,String name, int id, int thirstLevel) {
		super(x, y, species, symbol, energy, 0);
		this.name = name;
		this.id = id;
		setSpecies("Worm");
		setSymbol('w');
		setEnergy(3);
	}


	public Worm(int x, int y, char symbol, int energy, int thirstLevel) {
	super(x, y, symbol,0);
	setEnergy(3);
	}

}
