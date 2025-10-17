package cassdrugii;

import java.util.Scanner;

public class koordinate {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double x1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double y2 = sc.nextDouble();

		double a = Math.abs(y2 - x2);
		double b = Math.abs(y2 - y1);
		double p = a * b;
		double o = 2 * a + 2 * b;

		System.out.printf("Povrsina je:%.2f O=%.2f%n", p, o);
		sc.close();

	}

}
