import java.util.List;

public class Herbivore extends Animal {

	public Herbivore(int x, int y, String species, char symbol, int energy, int thirstLevel) {
		super(x, y, species, symbol, energy, "Herbivore",0);
		// TODO Auto-generated constructor stub
	}

	public Herbivore(int x, int y, char symbol,int thirstLevel) {
		super(x, y, symbol,0);
	}

	
	//Overriding smellFood in Animal
	
	protected String smellFood(Island island) { 
		List<Grass> nearbyGrass = island.getGrassInRange(getX(), getY(), 5); //grass within 5 steps
		nearbyGrass.sort(new NearestGrassComparator(getX(), getY())); //sort within the grass list to find nearest
		
		if (nearbyGrass.size() > 0) { 
			Grass g = nearbyGrass.get(0);
			if (Math.random() < 0.5) { 
				if (g.getY() < getY())
					return "N";
				if (g.getY() > getY())
					return "S";
			}
			if (g.getX() < getX())
				return "W";
			if (g.getX() > getX())
				return "E";
			if (g.getY() < getY())
				return "N";
			if (g.getY() > getY())
				return "S";
			g.setSize(g.getSize()-1); //decrease size of grass
			
		}
		return super.smellFood(island);
	}
	
	
	
}
