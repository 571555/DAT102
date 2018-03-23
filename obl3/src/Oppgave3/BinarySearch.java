package Oppgave3;

public class BinarySearch {
	
	public static void main(String[] args) {

		int[] data = { 2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30 };

		//Ville bare se hvor lang tid det tok.
		float start = System.currentTimeMillis();
		System.out.println(binarySearchRecursive(8, data, 0, data.length-1));
		float slutt = System.currentTimeMillis() - start;
		System.out.println(slutt);
	}

	public static int binarySearchRecursive(int search, int[] array, int start, int end) {

		
		//Middle finner tabellens midtepunkt, altså lengden på tabellen delt på 2
		int middle = (start + end) / 2;

		// hvis man setter inn en "ugyldig" verdi, så blir det også returnert 0.
		if (end < start) {
			return -1;
		}
		
		//Hvis verdien i tabellen er mindre enn den verdien vi vil finne, så finner den et nytt midtpunkt og gjør det samme igjen og igjen.
		if (search < array[middle]) {
			return binarySearchRecursive(search, array, start, middle - 1);
		}
		//Samme som oppe, bare omvendt.
		if (search > array[middle]) {
			return binarySearchRecursive(search, array, middle + 1, end);
		}
		//Hvis søket er lik midten så returnerer man nr i tabellen.
		if (search == array[middle]) {
			return middle;
		}
		//Hvis man ikke finner noe så retuneres -1.
		return -1;
	}

}
