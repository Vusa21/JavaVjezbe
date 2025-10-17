import java.util.Scanner;

public class sortiratiniz {

	public static void main(String[] args) {
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesite duzinu niza: ");
		int duzina = unos.nextInt();
		int[] niz = new int[duzina];

		System.out.println("Unesite elemente niza: \n");
		for (int i = 0; i < duzina; i++) {
			niz[i] = unos.nextInt();
		}
	}

	public static void sort(int[] niz) {
		int temp;
		for (int i = 0; i < niz.length; i++) {
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[i] > niz[j]) {
					temp = niz[i];
					niz[i] = niz[j];
					niz[j] = temp;

				}
				System.out.println("Unesite broj za provjeru: ");
				int broj = unos.nextInt();
				if (niz[i] == broj) {
					System.out.println("Broj je pronaden na poziciji: " + i);
				} else {
					System.out.println("Broj nije pronaden u nizu");
				}

			}
		}

	}
}