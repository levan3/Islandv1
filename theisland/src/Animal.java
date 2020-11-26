import java.util.List;

public class Animal extends Thing {

	private String species;
	private int energy;
	private String foodStrategy;
	private int thirstLevel;

	public Animal(int x, int y, String species, char symbol, int energy, String foodStrategy, int thirstLevel) {
		super(x, y, symbol);
		this.species = species;
		this.energy = energy;
		this.foodStrategy = foodStrategy;
		this.thirstLevel = thirstLevel;

	}

	public Animal(int x, int y, char symbol, int thirstLevel) {
		super(x, y, symbol);
		this.thirstLevel = thirstLevel;
	}

	public void move(String dir) {

		if ("N".equals(dir))
			setY(getY() - 1);

		if ("S".equals(dir))
			setY(getY() + 1);

		if ("W".equals(dir))
			setX(getX() - 1);

		if ("E".equals(dir))
			setX(getX() + 1);
	}

	public void tick(Island island) { //find food
		{
			int y = super.getY();
			int x = super.getX();

			int oldX = x;
			int oldY = y;
			
			String dir = this.smellFood(island);
			this.move(dir);
			
//			
//			int i = 0;
//			while (i < 10 && (x < 0 || x >= island.getWidth() || y < 0 || y >= island.getHeight())) {
//				x = oldX;
//				y = oldY;
//				this.moveRandom();
//				i++;
//			}
		}

	}
	
	public void tick2(Island island) { //find water
		{
			int y = super.getY();
			int x = super.getX();

			int oldX = x;
			int oldY = y;
			
			String dir = this.findWater(island);
			this.move(dir);
			setThirstLevel(getThirstLevel()+1);
//			
//			int i = 0;
//			while (i < 10 && (x < 0 || x >= island.getWidth() || y < 0 || y >= island.getHeight())) {
//				x = oldX;
//				y = oldY;
//				this.moveRandom();
//				i++;
//			}
		}

	}
	
	
	protected String smellFood(Island island) { // move random

		double d = Math.random();
		if (d < 0.25)
			return "N";
		else if (d < 0.5)
			return "S";
		else if (d < 0.75)
			return "W";
		else
			return "E";
	}

	
	protected String findWater(Island island) { 
		List<Water> nearbyWater = island.getWaterInRange(getX(), getY(), 5); //water within 5 steps
		nearbyWater.sort(new NearestWaterComparator(getX(), getY())); //sort within the grass list to find nearest
		
		if (nearbyWater.size() > 0) { 
			Water w = nearbyWater.get(0);
			if (Math.random() < 0.5) { 
				if (w.getY() < getY())
					return "N";
				if (w.getY() > getY())
					return "S";
			}
			if (w.getX() < getX())
				return "W";
			if (w.getX() > getX())
				return "E";
			if (w.getY() < getY())
				return "N";
			if (w.getY() > getY())
				return "S";
		}
		return smellFood(island); //move random
	}
	

	public void moveRandom() {
		double d = Math.random();
		if (d < 0.25)
			move("N");
		else if (d < 0.5)
			move("S");
		else if (d < 0.75)
			move("W");
		else
			move("E");

		this.setEnergy(this.getEnergy() - 1); // energy reduce by 1 per move
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public String getFoodStrategy() {
		return foodStrategy;
	}

	public void setFoodStrategy(String foodStrategy) {
		this.foodStrategy = foodStrategy;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public void setThirstLevel(int thirstLevel) {
		this.thirstLevel = thirstLevel;
	}

}
