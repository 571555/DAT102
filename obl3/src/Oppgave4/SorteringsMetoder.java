package Oppgave4;

import java.util.Random;
import Oppgave4.SokingOgSortering;

public class SorteringsMetoder {

	// BOBBLESORTERING
	public static <T extends Comparable<? super T>> void bobleSort(T[] data) {

		int p;
		int søk;
		T temp;

		for (p = data.length - 1; p >= 0; p--) {
			for (søk = 0; søk <= p - 1; søk++) {
				if (data[søk].compareTo(data[søk + 1]) > 0) {
					temp = data[søk];
					data[søk] = data[søk + 1];
					data[søk + 1] = temp;
				}
			}
		}
	}

	// SORTERING VED INNSETTING
	public static <T extends Comparable<? super T>> void sorteringVedInsetting(T[] data) {

		for (int indeks = 1; indeks < data.length; indeks++) {

			T nøkkel = data[indeks];
			int p = indeks;

			while (p > 0 && data[p - 1].compareTo(nøkkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nøkkel;
		}
	}

	// UTVALGS SORTERING
	public static <T extends Comparable<? super T>> void utvalgsSortering(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int søk = neste + 1; søk < data.length; søk++) {
				if (data[søk].compareTo(data[minste]) < 0) {
					minste = søk;
				}
			} /** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre
	}

	// KVIKKSORT
	public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {
		int posPartisjon;
		if (min < maks) { // minst to element
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikkSort(data, posPartisjon + 1, maks);
		}
	}

	// KVIKKSORT
	private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {

		int venstre, hoyre;
		T temp, pivot;
		// pivot som første element. Boka bruker midterste
		pivot = data[min];
		venstre = min;
		hoyre = maks;
		while (venstre < hoyre) {// ytre løkke
			/**
			 * Søker et element som er > enn pivot OBS! må ha venstre < hoyre for ellers går
			 * vi utover tabellområdet når elementene allerede er sorterte
			 */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}
			/** søker et element som er <= enn pivot */
			while (data[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			} /** bytter elementene */
			if (venstre < hoyre) {
				temp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = temp;
			}
		} // while – ytre løkke
		/** flytter pivot til riktig og sin endelige plass */
		temp = data[min];
		data[min] = data[hoyre];
		data[hoyre] = temp;
		return hoyre;
	}

	// FLETTESORTERING
	public static <T extends Comparable<T>> void fletteSort(T[] tabell, int første, int siste) {
		if (første < siste) {// minst to elementer
			int midten = (første + siste) / 2;
			// Sorter venstre halvdel tabell[første,midten];
			fletteSort(tabell, første, midten);
			// Sorter høyre halvdel tabell[midten+1,siste]
			fletteSort(tabell, midten + 1, siste);
			// Fletter de to halvdelene
			flette(tabell, første, midten, siste);
		}
	}

	// FLETTESORTERING
	private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {
		/*
		 * Fletter to sorterte deltabeller, tabell[første,midten] og
		 * tabell[midten+1,siste] til en sortert tabell Forkrav: første <= midten <=
		 * siste Deltabellene tabell[første,midten] og tabell[midten+1,siste] er hver
		 * sorterte i økende rekkefølge. ResultatIabell[første,siste] er sortert.
		 * Implementasjon : Denne metoden fletter to deltabeller til en hjelpetabell og
		 * kopierer resultatet til den originale tabellen.
		 */
		int stor = siste = forste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);
		// Initierer lokale indekser
		// start og slutt på venstre deltabell
		int forste1 = forste;
		int siste1 = midten;
		// start og slutt på høyre deltabell
		int forste2 = midten + 1;
		int siste2 = siste;
		/*
		 * Så lenge begge deltabellene ikke er tomme, kopier det minste elementet til
		 * hjelpetabellen.
		 */
		int indeks = 0;
		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (tabell[forste1].compareTo(tabell[forste2]) <= 0) {
				hjelpeTabell[indeks] = tabell[forste1];
				forste1++;
			} else {
				hjelpeTabell[indeks] = tabell[forste2];
				forste2++;
			}
			indeks++;
		}
		while (forste1 <= siste1) {
			hjelpeTabell[indeks] = tabell[forste1];
			forste1++;
			indeks++;
		} // while
			// kopiere resten av høyre del (kan være tom)
		while (forste2 <= siste2) {
			hjelpeTabell[indeks] = tabell[forste2];
			forste2++;
			indeks++;
		}
		// Kopier resultatet tilbake til den originale
		// tabellen
		int h = 0;
		for (indeks = forste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h++];
		}
	}

	/*Kvikksort2
	 *
	 * @param data
	 *
	 * En kvikksort metode som grovsorterer tabellen.
	 * Anta vi har brukt MIN = 10.
 		Etter kvikksortering ser tabellen slik ut der * betyr et element
 		|**********|**********|**********| …. .. |
 			1 			2 			3
 		Vi har satt '|' som symboliserer skille mellom deltabellene.
 		Alle elementene i deltabell 1 er mindre eller lik alle elementene i deltabell 2, osv.
 		Men elementene i deltabell 1 er ikke sortert og heller ikke elementene i de andre deltabellene.
	 *
	 */




	// MAIN
	public static void main(String[] args) {

		Integer b = 32000;
		Integer c = 64000;
		Integer d = 128000;
		
		Integer antall = 5;
		
	
	
		Integer[][] a = opprettTestData(c, antall);
		
		long start = System.currentTimeMillis();

		for (int i = 0; i < antall; i++) {

			SokingOgSortering.kvikkSortNy(a[i], 0, a[i].length-1);
//			Sortering.quick(a[i]);
		}
		System.out.println((System.currentTimeMillis() - start) / antall + "ms");

	}

	public static Integer[][] opprettTestData(int n, int antall) {

		Random tilfeldig = new Random();
		Integer[][] a = new Integer[antall][n];

		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt();
			}
		}

		return a;
	}

}
