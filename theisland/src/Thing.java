
public class Thing {
	
	private int x; // x coordination
	private int y; // y coordination
	private char symbol;
	
	
	public Thing(int x, int y, char symbol) {
		super();
		this.x = x;
		this.y = y;
		this.symbol = symbol;
		
	}
	
	
	public Thing(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	

	/** Returns true if this bug contains the point (x, y). **/
	public boolean contains(int x, int y) {
		return x == this.x && y == this.y;
	}

}
