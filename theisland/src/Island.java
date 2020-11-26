import java.util.ArrayList;
import java.util.List;

public class Island {

	private ArrayList<Rabbit> rabbits = new ArrayList<Rabbit>();
	private ArrayList<Kiwi> kiwis = new ArrayList<Kiwi>();
	private ArrayList<Sparrow> sparrows = new ArrayList<Sparrow>();
	private ArrayList<Cat> cats = new ArrayList<Cat>();
	private ArrayList<Rodent> rodents = new ArrayList<Rodent>();
	private ArrayList<Worm> worms = new ArrayList<Worm>();

	private ArrayList<Grass> grass = new ArrayList<Grass>();
	private ArrayList<Appletree> appletrees = new ArrayList<Appletree>();
	
	
	private ArrayList<Water> water = new ArrayList<Water>();
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private ArrayList<Plant> plants = new ArrayList<Plant>();
	
	
	private ArrayList<Thing> things = new ArrayList<Thing>();
	

	private int width;
	private int height;

	public Island(int w, int h) {
		width = w;
		height = h;
		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			char symbol = 'R';
			int energy = 15;
			int thirstLevel = 0;
			if (Math.random() < 0.5) {
				rabbits.add(new Rabbit(x, y, symbol, energy, thirstLevel));
				animals.add(new Rabbit(x, y, symbol, energy, thirstLevel));
				things.add(new Rabbit(x, y, symbol, energy, thirstLevel));
			}
		}

		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			int size = (int) (Math.random() * 10);
			char symbol = 'G';
			grass.add(new Grass(x, y, symbol, size));
			things.add(new Grass(x, y, symbol, size));
		}

		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			int size = (int) (Math.random() * 10);
			water.add(new Water(x, y, 'W', size));
			things.add(new Water(x, y, 'W', size));
		}

		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			char symbol = 'K';
			int energy = 14;
			int thirstLevel = 0;
			if (Math.random() < 0.5) {
				kiwis.add(new Kiwi(x, y, symbol, energy, thirstLevel));
				animals.add(new Kiwi(x, y, symbol, energy, thirstLevel));
				things.add(new Kiwi(x, y, symbol, energy, thirstLevel));

			}
		}

		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			char symbol = 'C';
			int energy = 20;
			int thirstLevel = 0;
			if (Math.random() < 0.5) {
				cats.add(new Cat(x, y, symbol, energy, thirstLevel));
				animals.add(new Cat(x, y, symbol, energy, thirstLevel));
				things.add(new Cat(x, y, symbol, energy, thirstLevel));

			}

		}

		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			char symbol = 'r';
			int energy = 20;
			int thirstLevel = 0;
			if (Math.random() < 0.5) {
				rodents.add(new Rodent(x, y, symbol, energy, thirstLevel));
				animals.add(new Rodent(x, y, symbol, energy, thirstLevel));
				things.add(new Rodent(x, y, symbol, energy, thirstLevel));

			}

		}

		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			char symbol = 'w';
			int energy = 3;
			int thirstLevel = 0;
			if (Math.random() < 0.5) {
				worms.add(new Worm(x, y, symbol, energy, thirstLevel));
				animals.add(new Worm(x, y, symbol, energy, thirstLevel));
				things.add(new Worm(x, y, symbol, energy, thirstLevel));

			}

		}

		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			char symbol = 'S';
			int energy = 9;
			int thirstLevel = 0;
			if (Math.random() < 0.5) {
				sparrows.add(new Sparrow(x, y, symbol, energy, thirstLevel));
				animals.add(new Sparrow(x, y, symbol, energy, thirstLevel));
				things.add(new Sparrow(x, y, symbol, energy, thirstLevel));

			}

		}
		
		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			int size = (int) (Math.random() * 10);
			char symbol = 'A';
			appletrees.add(new Appletree(x, y, symbol, size));
			plants.add(new Appletree(x, y, symbol, size));
			things.add(new Appletree(x, y, symbol, size));
		}
	}

	public void drawIsland() {

		System.out.print('+');
		for (int i = 0; i < width; i++)
			System.out.print('-');
		System.out.println('+');
		for (int y = 0; y < height; y++) {
			System.out.print('|');
			for (int x = 0; x < width; x++) {
				Rabbit foundRabbit = null;
				Grass foundGrass = null;
				Water foundWater = null;
				Kiwi foundKiwi = null;
				Cat foundCat = null;
				Rodent foundRodent = null;
				Worm foundWorm = null;
				Sparrow foundSparrow = null;
				Appletree foundAppletree = null;

				int i;
				for (i = 0; i < rabbits.size(); i++) {
					Rabbit r = rabbits.get(i);
					if (r.contains(x, y)) {
						foundRabbit = r;
						break;
					}
				}
				i = 0;
				for (; i < grass.size(); i++) {
					Grass g = grass.get(i);
					if (g.getX() == x && g.getY() == y) {
						foundGrass = g;
						break;
					}
				}

				i = 0;
				for (; i < water.size(); i++) {
					Water w = water.get(i);
					if (w.getX() == x && w.getY() == y) {
						foundWater = w;
						break;
					}
				}

				i = 0;
				for (; i < kiwis.size(); i++) {
					Kiwi k = kiwis.get(i);
					if (k.getX() == x && k.getY() == y) {
						foundKiwi = k;
						break;
					}
				}

				i = 0;
				for (; i < cats.size(); i++) {
					Cat c = cats.get(i);
					if (c.getX() == x && c.getY() == y) {
						foundCat = c;
						break;
					}
				}

				i = 0;
				for (; i < rodents.size(); i++) {
					Rodent r = rodents.get(i);
					if (r.getX() == x && r.getY() == y) {
						foundRodent = r;
						break;
					}
				}

				i = 0;
				for (; i < worms.size(); i++) {
					Worm wo = worms.get(i);
					if (wo.getX() == x && wo.getY() == y) {
						foundWorm = wo;
						break;
					}
				}

				i = 0;
				for (; i < sparrows.size(); i++) {
					Sparrow s = sparrows.get(i);
					if (s.getX() == x && s.getY() == y) {
						foundSparrow = s;
						break;
					}
				}
				
				i = 0;
				for (; i < appletrees.size(); i++) {
					Appletree a = appletrees.get(i);
					if (a.getX() == x && a.getY() == y) {
						foundAppletree = a;
						break;
					}
				}

				if (foundRabbit != null)
					System.out.print(foundRabbit.getSymbol());
				else if (foundGrass != null)
					System.out.print(foundGrass.getSymbol());
				else if (foundWater != null)
					System.out.print(foundWater.getSymbol());
				else if (foundKiwi != null)
					System.out.print(foundKiwi.getSymbol());
				else if (foundCat != null)
					System.out.print(foundCat.getSymbol());
				else if (foundRodent != null)
					System.out.print(foundRodent.getSymbol());
				else if (foundWorm != null)
					System.out.print(foundWorm.getSymbol());
				else if (foundSparrow != null)
					System.out.print(foundSparrow.getSymbol());
				else if (foundAppletree != null)
					System.out.print(foundAppletree.getSymbol());
				else
					System.out.print(' ');

			}
			System.out.println('|');
		}
		System.out.print('+');
		for (int i = 0; i < width; i++)
			System.out.print('-');
		System.out.println('+');
	}

	public void addRabbit(Rabbit r) {
		if (r.getX() < 0 || r.getX() >= width || r.getY() < 0 || r.getY() >= height) {
			return;
		}
		rabbits.add(r);
		animals.add(r);
		things.add(r);
	}

	public void addGrass(Grass g) {
		if (g.getX() < 0 || g.getX() >= width || g.getY() < 0 || g.getY() >= height) {
			return;
		}
		grass.add(g);
		plants.add(g);
		things.add(g);
	}

	public void addWater(Water w) {
		if (w.getX() < 0 || w.getX() >= width || w.getY() < 0 || w.getY() >= height) {
			return;
		}
		water.add(w);
		things.add(w);
	}

	public void addKiwi(Kiwi k) {
		if (k.getX() < 0 || k.getX() >= width || k.getY() < 0 || k.getY() >= height) {
			return;
		}
		kiwis.add(k);
		animals.add(k);
		things.add(k);
	}

	public void addCat(Cat c) {
		if (c.getX() < 0 || c.getX() >= width || c.getY() < 0 || c.getY() >= height) {
			return;
		}
		cats.add(c);
		animals.add(c);
		things.add(c);
	}

	public void addRodent(Rodent ro) {
		if (ro.getX() < 0 || ro.getX() >= width || ro.getY() < 0 || ro.getY() >= height) {
			return;
		}
		rodents.add(ro);
		animals.add(ro);
		things.add(ro);
	}

	public void addWorm(Worm wo) {
		if (wo.getX() < 0 || wo.getX() >= width || wo.getY() < 0 || wo.getY() >= height) {
			return;
		}
		worms.add(wo);
		animals.add(wo);
		things.add(wo);
	}

	public void addSparrow(Sparrow s) {
		if (s.getX() < 0 || s.getX() >= width || s.getY() < 0 || s.getY() >= height) {
			return;
		}
		sparrows.add(s);
		animals.add(s);
		things.add(s);
	}

	public void addAppletree(Appletree a) {
		if (a.getX() < 0 || a.getX() >= width || a.getY() < 0 || a.getY() >= height) {
			return;
		}
		appletrees.add(a);
		plants.add(a);
		things.add(a);
	}
	
	
	// herbivore find grass

	public List<Grass> getGrassInRange(int x, int y, int r) {
		List<Grass> ret = new ArrayList<Grass>();
		for (Grass g : grass) {
			int d = Math.abs(g.getX() - x) + Math.abs(g.getY() - y);
			if (d <= r)
				ret.add(g);
		}
		return ret;
	}

	// animals find water

	public List<Water> getWaterInRange(int x, int y, int r) {
		List<Water> ret = new ArrayList<Water>();
		for (Water w : water) {
			int d = Math.abs(w.getX() - x) + Math.abs(w.getY() - y);
			if (d <= r)
				ret.add(w);
		}
		return ret;
	}

	// find rodents

	public List<Rodent> getRodentInRange(int x, int y, int r) {
		List<Rodent> ret = new ArrayList<Rodent>();
		for (Rodent ro : rodents) {
			int d = Math.abs(ro.getX() - x) + Math.abs(ro.getY() - y);
			if (d <= r)
				ret.add(ro);
		}
		return ret;
	}

	// find worms

	public List<Worm> getWormInRange(int x, int y, int r) {
		List<Worm> ret = new ArrayList<Worm>();
		for (Worm wo : worms) {
			int d = Math.abs(wo.getX() - x) + Math.abs(wo.getY() - y);
			if (d <= r)
				ret.add(wo);
		}
		return ret;
	}

	// creatures move random without seeking food

	public void updateIsland1() {

		rabbitMoveRandom(); // move random
		growGrass(); // grow grass with every move
		kiwiMoveRandom();
		catMoveRandom();
		rodentMoveRandom();
		wormMoveRandom();
		sparrowMoveRandom();
		

	}

	// Cat nearby?

	public boolean catNearby(int x, int y) {
		for (Cat c : cats) {
			if (c.getX() == x && c.getY() == y)
				return true;
		}
		return false;
	}

	
	// update Island with creatures seeking food, water, grass growing, creatures removing once energy source exhausted

	public void updateIsland() {
		for (Animal animal : animals) {
			if (animal instanceof Rabbit) {

				if (animal.getThirstLevel() < 5) { // rabbit thirsty
					animal.tick2(this);
					animal.setThirstLevel(animal.getThirstLevel()+1);
				}

				else if (animal.getEnergy() < 12) { // rabbit hungry...assuming food is secondary to water
					animal.tick(this);
					
				}

				
					rabbitMoveRandom();
			}

			if (animal instanceof Kiwi) {

				if (animal.getThirstLevel() < 3) { // kiwi thirsty
					animal.tick2(this);
					animal.setThirstLevel(animal.getThirstLevel()+1);
				} 
					kiwiMoveRandom();

				animal.setEnergy(14); // kiwis find food at every tick hence energy always full

			}

			if (animal instanceof Cat) {

				if (animal.getThirstLevel() < 8) {
					animal.tick2(this);
					animal.setThirstLevel(animal.getThirstLevel()+1);
					
				}

				else if (animal.getEnergy() < 18) {
					animal.tick(this);
					animal.setEnergy(animal.getEnergy() + 5);
				}

				
					catMoveRandom();
			}

			if (animal instanceof Rodent) {

				if (animal.getThirstLevel() < 3) {
					animal.tick(this);
					animal.setThirstLevel(animal.getThirstLevel()+1);
				}

				else if (animal.getEnergy() < 3) { // tick method avoid cat
					animal.tick2(this);
					animal.setEnergy(animal.getEnergy() + 3);

				}

				
					rodentMoveRandom();
			}

			if (animal instanceof Sparrow) {

				if (animal.getThirstLevel() < 4) {
					animal.tick2(this);
					animal.setThirstLevel(animal.getThirstLevel()+1);
				}

				else if (animal.getEnergy() < 8) {
					animal.tick(this);
					animal.setEnergy(animal.getEnergy() + 3);
				}

				
					sparrowMoveRandom();
			}

			if (animal instanceof Worm) {

				wormMoveRandom();
			}

		}
		growGrass();
		growAppletree();
		

	}

	public void growGrass() {
		for (Grass g : grass) {
			g.setSize(g.getSize() + 1);
		}
	}
	
	public void growAppletree() {
		for (Appletree a : appletrees) {
			a.setSize(a.getSize() + 1);
		}
	}

	public void rabbitMoveRandom() {
		for (Rabbit r : rabbits) {
			r.moveRandom();
			if (r.getX() < 0)
				r.setX(0);
			if (r.getX() >= width)
				r.setX(width - 1);
			if (r.getY() < 0)
				r.setY(0);
			if (r.getY() >= height)
				r.setY(height - 1);
			// r.setEnergy(r.getEnergy() - 1);
		}
	}

	public void kiwiMoveRandom() {
		for (Kiwi k : kiwis) {
			k.moveRandom();
			if (k.getX() < 0)
				k.setX(0);
			if (k.getX() >= width)
				k.setX(width - 1);
			if (k.getY() < 0)
				k.setY(0);
			if (k.getY() >= height)
				k.setY(height - 1);

		}
	}

	public void catMoveRandom() {
		for (Cat c : cats) {
			c.moveRandom();
			if (c.getX() < 0)
				c.setX(0);
			if (c.getX() >= width)
				c.setX(width - 1);
			if (c.getY() < 0)
				c.setY(0);
			if (c.getY() >= height)
				c.setY(height - 1);

		}
	}

	public void rodentMoveRandom() {
		for (Rodent ro : rodents) {
			ro.moveRandom();
			if (ro.getX() < 0)
				ro.setX(0);
			if (ro.getX() >= width)
				ro.setX(width - 1);
			if (ro.getY() < 0)
				ro.setY(0);
			if (ro.getY() >= height)
				ro.setY(height - 1);

		}
	}

	public void wormMoveRandom() {
		for (Worm wo : worms) {
			wo.moveRandom();
			if (wo.getX() < 0)
				wo.setX(0);
			if (wo.getX() >= width)
				wo.setX(width - 1);
			if (wo.getY() < 0)
				wo.setY(0);
			if (wo.getY() >= height)
				wo.setY(height - 1);

		}
	}

	public void sparrowMoveRandom() {
		for (Sparrow s : sparrows) {
			s.moveRandom();
			if (s.getX() < 0)
				s.setX(0);
			if (s.getX() >= width)
				s.setX(width - 1);
			if (s.getY() < 0)
				s.setY(0);
			if (s.getY() >= height)
				s.setY(height - 1);

		}
	}
	
	public void listAnimal() {
		for(Animal a : animals) {
			if (a.getEnergy() == 0) {
				
				if (a instanceof Rabbit) {
					rabbits.remove(a);
				}
				
				else if ( a instanceof Kiwi){
					kiwis.remove(a);
				}
				else if ( a instanceof Cat){
					cats.remove(a);
				}
				else if ( a instanceof Sparrow){
					sparrows.remove(a);
				}
				
				else if ( a instanceof Rodent){
					rodents.remove(a);
				}
				
				else if ( a instanceof Worm){
					worms.remove(a);
				}
			}
			
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		listAnimal();
		return "Island [Rabbit, Kiwi, Cat, Rodent, Worm, Sparrow] = [" + this.rabbits.size() + ", " + this.kiwis.size()
				+ ", " + this.cats.size() + ", " + this.rodents.size() + ", " + this.worms.size() + ", "
				+ this.sparrows.size() + "]";
	}

	public ArrayList<Rabbit> getRabbits() {
		return rabbits;
	}

	public ArrayList<Grass> getGrass() {
		return grass;
	}

	public ArrayList<Water> getWater() {
		return water;
	}

	public ArrayList<Kiwi> getKiwis() {
		return kiwis;
	}

}