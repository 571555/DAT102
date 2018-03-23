package HanoiTaarn;

public class TowersOfHanoi {

	private int totalDisks;
	public int count;
	
	public TowersOfHanoi(int disks) {
		totalDisks = disks;
		count = 0;
	}
	
	public void solve() {
		moveTower(totalDisks, 1, 3, 2);
	}
	private void moveTower (int numDisks, int start, int end, int temp) {
		if(numDisks == 1) {
			moveOneDisk (start, end);
		} else {
			moveTower (numDisks-1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks-1, temp, end, start);
		}
	}
	private void moveOneDisk(int start, int end ) {
		//System.out.println("Move one disk from " + start + " to " + end);
		count++;
	}
}
