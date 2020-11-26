import java.util.Comparator;

public class BestWormComparator implements Comparator<Worm> {
	private int x, y;
	
	public BestWormComparator(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private int distance(int ox, int oy) {
		return Math.abs(ox - x) + Math.abs(oy - y);
	}
	
	@Override
	public int compare(Worm arg0, Worm arg1) {
		// First find bigger
		if (arg0.getEnergy() > arg1.getEnergy())
			return -1;
		if (arg0.getEnergy() < arg1.getEnergy()) //assuming biggest worm has highest energy
			return 1;
		// Then find nearer
		int d1 = distance(arg0.getX(), arg0.getY());
		int d2 = distance(arg1.getX(), arg1.getY());
		if (d1 < d2)
			return -1;
		if (d1 > d2)
			return 1;
		// It's a tie
		return 0;
	}


}
