package no.hib.dat102;

public class SoekingOgSortering {

	private static final int MIN = 10;
	/*************************************************************************************************/
	// Søkealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gjør et lineært søk i en tabell av usorterte data
	 * 
	 * @param data
	 *            er data som skal søkes i
	 * @param min
	 *            er startindeks
	 * @param maks
	 *            er sluttindeks
	 * @param el
	 *            er verdien vi søker etter
	 * @return sann om elementet ble funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekU(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks <= maks && !funnet) {
			if (data[indeks].compareTo(el) == 0)
				funnet = true;
			indeks++;
		} // while
		return funnet;
	}// metode

	/**
	 * Metoden gjør et lineært søk i en sortert tabell av data
	 * 
	 * @param data
	 *            er data som skal søkes i
	 * @param min
	 *            er startindeks
	 * @param maks
	 *            er sluttindeks
	 * @param el
	 *            verdien vi søker etter
	 * @return sann hvis funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekS(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks < maks && data[indeks].compareTo(el) < 0) {
			indeks++;
		} // while

		if (data[indeks].compareTo(el) == 0) {
			funnet = true;
		}

		return funnet;

	}// metode

	/**
	 * Metoden gjør et binært søk i en *sortert* tabell av data
	 * 
	 * @param data
	 *            er data som skal søkes i
	 * @param min
	 *            er startindeks
	 * @param maks
	 *            er sluttindeks
	 * @param el
	 *            er elementet vi søker etter
	 * @return sann om elementet ble funnet ellers usann.
	 */

	// Alt 1
	public static <T extends Comparable<T>> boolean binaerSoek(T[] data, int min, int maks, T element) {

		boolean funnet = false;
		int midtpunkt = (min + maks) / 2;
		if (data[midtpunkt].compareTo(element) == 0) {
			funnet = true;
		} else if (data[midtpunkt].compareTo(element) > 0) {
			if (min <= midtpunkt - 1) {
				funnet = binaerSoek(data, min, midtpunkt - 1, element);
			}
		} else if (midtpunkt + 1 <= maks) {
			funnet = binaerSoek(data, midtpunkt + 1, maks, element);
		}
		return funnet;
	}// metode

	// Alt 2
	public static <T extends Comparable<T>> boolean binaerSoek2(T[] data, int min, int maks, T el) {
		boolean funnet;
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (min > maks) { // basistilfelle, ingen element
			funnet = false;
		} else if (resultat == 0) {
			funnet = true;
		} else if (resultat < 0) {
			funnet = binaerSoek2(data, min, midtpunkt - 1, el);
		} else {
			funnet = binaerSoek2(data, midtpunkt + 1, maks, el);
		}

		return funnet;

	}

	/* Rekursiv binærsøk som returnerer indeks */
	// Alt 3
	public static <T extends Comparable<T>> int binaerSoek3(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		if (min > maks) { // basistilfelle, ingen element
			return -1;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) { // basistilfelle, finner elementet
			return midtpunkt;
		}
		if (resultat < 0) {// ( vil her også fungere med else if)
			return binaerSoek3(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek3(data, midtpunkt + 1, maks, el);
		}
	}// metode

	/* Ikke rekursiv binærsøk som returnerer indeks */
	// Alt 4
	public static <T extends Comparable<T>> int binaerSoek4(T[] data, int min, int maks, T el) {
		return maks;
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		// Fyll ut og kjør metoden
	}//

	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/

	/**
	 * Utvalgsortering
	 * 
	 * @param data
	 *            er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgSortering(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}
			} // indre for-løkke

			/** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre for-løkke
	}// metode

	/**
	 * Sortering ved innsetting
	 * 
	 * @param data
	 *            er data som skal sorteres
	 */
	 public static <T extends Comparable<T>>
	 void sorteringVedInnsetting2(T[] data, int forste, int siste) {
	 for (int indeks = forste + 1; indeks <= siste; indeks++) {
	
	 T nokkel = data[indeks];
	 int p = indeks;
	 // Forskyv større verdier mot høyre
	 while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
	 data[p] = data[p - 1];
	 p--;
	 }
	 data[p] = nokkel;
	 }// ytre
	}// metode
	 
	 /**
		 * kvikksort
		 * 
		 * @param data
		 *          vanlige kvikksortmetoden
		 */
		public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {
			int posPartisjon;
			if (min < maks) { // minst to element
				/** Lager partisjon */
				posPartisjon = finnPartisjon(data, min, maks);
				/** Sorterer venstre side */
				kvikkSort(data, min, posPartisjon - 1);
				/** Sorterer hÃ¸yre side */
				kvikkSort(data, posPartisjon + 1, maks);
			}
		}
	 
	 /**
		 * finnpartisjon
		 * 
		 * @param data
		 *          
		 */
	 private static <T extends Comparable<T>> int finnPartisjon(T[] data,
				int min, int maks) {
			int venstre, hoyre;
			T temp, pivot;
			pivot = data[min];// pivot som forste element
			venstre = min;
			hoyre = maks;
			while (venstre < hoyre) {// ytre løkke
				/** søker et element som er > enn pivot */
				/**
				 * OBS! Må ha testen venstre < hoyre for elles går vi utover
				 * tabellområdet når elementene er sortert på forhånd!
				 */
				while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0)
					venstre++;

				/** søker et element som er < enn pivot */
				while (data[hoyre].compareTo(pivot) > 0)
					hoyre--;
				/** bytter elementene */
				if (venstre < hoyre) {
					temp = data[venstre];
					data[venstre] = data[hoyre];
					data[hoyre] = temp;
				}
			}// while - ytre løkke

			/** flytter pivot til riktig og sin endelige plass */
			temp = data[min];
			data[min] = data[hoyre];
			data[hoyre] = temp;
			return hoyre;
		}// metode
	
	/**
	 * Kvikksortering NY
	 * 
	 * @param data
	 *            er data som skal sorteres med en ny kvikksort med få nøkler
	 */
	public static <T extends Comparable<T>> void kvikkSortNy(T[] data,
			 int min, int maks) {
			 kvikkSort2(data, min, maks);
			 sorteringVedInnsetting2(data, min, maks);
			}
			public static <T extends Comparable<T>> void kvikkSort2(T[] data,
			 int min, int maks) {
			 int posPartisjon;
			 if (maks - min +1 > MIN) {//antall elementer > MIN ?
			 /** Lager partisjon */
			 posPartisjon = finnPartisjon(data, min, maks);
			 /** Sorterer venstre side */
			 kvikkSort(data, min, posPartisjon - 1);
			 /** Sorterer høyre side */
			 kvikkSort(data, posPartisjon + 1, maks);
			 }
			 }// metode
	
	
}
