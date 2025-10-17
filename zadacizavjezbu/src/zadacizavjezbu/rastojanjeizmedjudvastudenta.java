package zadacizavjezbu;

import java.util.Scanner;

public class rastojanjeizmedjudvastudenta {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double x1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double y2 = sc.nextDouble();

		double x3 = (x1 + x2) / 2;
		double y3 = (y1 + y2) / 2;

		// 2️⃣ Izračunavanje rastojanja od početne tačke prvog studenta do tačke susreta
		double rastojanje1 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

		// (ako želiš i za drugog studenta)
		double rastojanje2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

		// 3️⃣ Ispis rezultata
		System.out.println("Tačka susreta je: (" + x3 + ", " + y3 + ")");
		System.out.println("Rastojanje prvog studenta do tačke susreta: " + rastojanje1);
		System.out.println("Rastojanje drugog studenta do tačke susreta: " + rastojanje2);

		sc.close();

	}

}
