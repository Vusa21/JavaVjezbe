package vjezbanjesam;

import java.util.Scanner;

public class ocjenestudenata {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Unesi osvojeni broj bodova:");
		double brojbodova = sc.nextDouble();

		if (brojbodova >= 90 && brojbodova <= 100) {
			System.out.printf("Polozili ste ispit vasa ocjena je 10");
		} else if (brojbodova >= 80) {
			System.out.printf("Polozii ste ispit vasa ocjena je 9");
		} else if (brojbodova >= 70) {
			System.out.printf("Polozii ste ispit vasa ocjena je 8");
		} else if (brojbodova >= 60) {
			System.out.printf("Polozii ste ispit vasa ocjena je 7");
		} else if (brojbodova >= 50) {
			System.out.printf("Polozii ste ispit vasa ocjena je 6");
		} else if (brojbodova < 50) {
			System.out.printf("Nazalonst niste polozili");
		} else {
			System.out.printf("Unos je pogresan");
		}
		sc.close();

	}
}
