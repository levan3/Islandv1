
public class Water  extends Thing {
	private int size;
	
	

	public Water(int x, int y, char symbol, int size) {

		super(x, y, symbol);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}

