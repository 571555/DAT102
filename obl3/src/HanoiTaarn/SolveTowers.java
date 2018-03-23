package HanoiTaarn;

public class SolveTowers {

	public static void main (String [] args) {
		
		
		TowersOfHanoi towers = new TowersOfHanoi(16);
		long startTime = System.currentTimeMillis();
		towers.solve();
		long endTime = System.currentTimeMillis() - startTime;
	
		
		System.out.println("Total amount of moves: " + towers.count+ "\nTotal time used: " + endTime + "ms");
	}

}
