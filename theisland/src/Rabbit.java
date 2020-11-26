import java.util.List;

public class Rabbit extends Herbivore{
	
	private String name;
	private static int counter = 0;
	private int id = counter++;
	
	
	
	
	public Rabbit(int x, int y, String species, int energy, char symbol,String name, int id, int thirstLevel) {
		super(x, y, species, symbol, energy, 0);
		this.name = name;
		this.id = id;
		setSpecies("Rabbit");
		setSymbol('R');
		setEnergy(15);
	}


	public Rabbit(int x, int y, char symbol, int energy, int thirstLevel) {
	super(x, y, symbol,0);
	setEnergy(15);
	}

	
	public void move(String dir) {
		if ("N".equals(dir))
			setY(getY() - 2);
		if ("S".equals(dir))
			setY(getY() + 2);
		if ("W".equals(dir))
			setX(getX() - 2);
		if ("E".equals(dir))
			setX(getX() + 2);
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
		Rabbit.counter = counter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
