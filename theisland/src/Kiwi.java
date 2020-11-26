
public class Kiwi extends Omnivore{

	private String name;
	private static int counter = 0;
	private int id = counter++;
	
	
	public Kiwi(int x, int y, String species, int energy, char symbol,String name, int id, int thirstLevel) {
		super(x, y, species, symbol, energy, thirstLevel);
		this.name = name;
		this.id = id;
		setSpecies("Kiwi");
		setSymbol('K');
		setEnergy(14);
	}
	
	public Kiwi(int x, int y, char symbol, int energy, int thirstLevel) {
		super(x, y, symbol, 0);
		setEnergy(14);
		}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static int getCounter() {
		return counter;
	}


	public static void setCounter(int counter) {
		Kiwi.counter = counter;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
}
