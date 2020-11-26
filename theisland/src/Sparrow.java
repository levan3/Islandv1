
import java.util.List;

	public class Sparrow extends Carnivore {

		private String name;
		private static int counter = 0;
		private int id = counter++;

		public Sparrow(int x, int y, String species, int energy, char symbol, String name, int id, int thirstLevel) {
			super(x, y, species, symbol, energy, thirstLevel);
			this.name = name;
			this.id = id;
			setSpecies("Cat");
			setSymbol('C');
			setEnergy(9);
		}

		public Sparrow(int x, int y, char symbol, int energy, int thirstLevel) {
			super(x, y, symbol, 0);
			setEnergy(9);
		}

		protected String smellFood(Island island) {

			List<Worm> nearbyWorms = island.getWormInRange(getX(), getY(), 6);
			nearbyWorms.sort(new BestWormComparator(getX(), getY()));
			nearbyWorms.remove(this);
			if (super.getEnergy() == 6) { //cat gets hungry
				if (nearbyWorms.size() > 0) {
					Worm wo = nearbyWorms.get(0);
					if (wo.getX() < getX())
						return "W";
					if (wo.getX() > getX())
						return "E";
					if (wo.getY() < getY())
						return "N";
					if (wo.getY() > getY())
						return "S";
					wo.setEnergy(0);
				}
			}
			return super.smellFood(island);
		}
		
		public void move(String dir) {
			if ("N".equals(dir))
				setY(getY() - 8);
			if ("S".equals(dir))
				setY(getY() + 8);
			if ("W".equals(dir))
				setX(getX() - 8);
			if ("E".equals(dir))
				setX(getX() + 8);
		}

		
		public void tick(Island island) {
			
			int y = super.getY();
			int x = super.getX();
			
			int oldX = x;
			int oldY = y;
			String dir = this.smellFood(island);
			this.move(dir);
			int i = 0;
			while (i < 10 && (x < 0 || x >= island.getWidth() || y < 0 || y >= island.getHeight()
					|| this.avoidCat(island))) {
				x = oldX;
				y = oldY;
				this.moveRandom();
				i++;
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
				
				int i = 0;
				while (i < 10 && (x < 0 || x >= island.getWidth() || y < 0 || y >= island.getHeight()
						|| this.avoidCat(island))) {
					x = oldX;
					y = oldY;
					this.moveRandom();
					i++;
				}
			}
		}
			
			protected boolean avoidCat(Island island) {
				return island.catNearby(super.getX(), super.getY());
			}
	}

	

