import java.util.Comparator;

public class NearestRodentComparator implements Comparator<Rodent> {

	private int x, y;
	
	public NearestRodentComparator(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private int distance(int ox, int oy) {
		return Math.abs(ox - x) + Math.abs(oy - y);
	}
	
	@Override
	public int compare(Rodent o1, Rodent o2) {
		int d1 = distance(o1.getX(), o1.getY());
		int d2 = distance(o2.getX(), o2.getY());
		if (d1 < d2)
			return -1;
		if (d1 > d2)
			return 1;
		return 0;
	}

}
