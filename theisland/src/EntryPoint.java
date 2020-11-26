import java.util.ArrayList;
import java.util.Scanner;

public class EntryPoint {
	
	public static void main(String[] args) {
		Island island = new Island(30, 30);
		for (int i = 0; i < 10; i++) {
			island.drawIsland();
			island.updateIsland();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("Creatures: " + island);
		
		
		Island island2 = new Island(20, 20);
		for (int i = 0; i < 10; i++) {
			island2.drawIsland();
			island2.updateIsland();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("Creatures: " + island2);
		
		
		
	}

}
