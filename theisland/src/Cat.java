import java.util.List;

public class Cat extends Carnivore {

	private String name;
	private static int counter = 0;
	private int id = counter++;

	public Cat(int x, int y, String species, int energy, char symbol, String name, int id, int thirstLevel) {
		super(x, y, species, symbol, energy, thirstLevel);
		this.name = name;
		this.id = id;
		setSpecies("Cat");
		setSymbol('C');
		setEnergy(20);
	}

	public Cat(int x, int y, char symbol, int energy, int thirstLevel) {
		super(x, y, symbol, 0);
		setEnergy(20);
	}

	protected String smellFood(Island island) {

		List<Rodent> nearbyRodents = island.getRodentInRange(getX(), getY(), 6);
		nearbyRodents.sort(new NearestRodentComparator(getX(), getY()));
		nearbyRodents.remove(this);
		if (super.getEnergy() <= 18) { //cat gets hungry
			if (nearbyRodents.size() > 0) {
				Rodent ro = nearbyRodents.get(0);
				if (ro.getX() < getX())
					return "W";
				if (ro.getX() > getX())
					return "E";
				if (ro.getY() < getY())
					return "N";
				if (ro.getY() > getY())
					return "S";
				ro.setEnergy(0);
			}
		}
		return super.smellFood(island);
	}
	
	public void move(String dir) {
		if ("N".equals(dir))
			setY(getY() - 4);
		if ("S".equals(dir))
			setY(getY() + 4);
		if ("W".equals(dir))
			setX(getX() - 4);
		if ("E".equals(dir))
			setX(getX() + 4);
	}

}
