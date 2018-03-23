package Oppgave1;

public class Oppgave1 {
	
	public static void main(String [] args) {
			
		System.out.println(sn(100));
		System.out.println(an(10));
	}

	public static int sn(int tall) {
		if (tall == 1) {
			return 1;
		} else {
			return sn(tall-1) + tall;
		}
		
	}

	public static int an(int tall) {
		if(tall == 0) {
			return 2;
		} else if (tall == 1) {
			return 5;
		} else {
			return 5*an(tall-1) - 6*an(tall-2) + 2;
		}
	}

	
}
