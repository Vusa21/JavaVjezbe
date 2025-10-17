package VjezbeIII;

import java.util.Scanner;

public class heltidvorca {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long D = sc.nextLong();
		long HD = sc.nextShort();
		long KA = sc.nextLong();
		int brojprijetnji = sc.nextInt();

		for (double i = 0; i < N; i++) {

			long x = sc.nextLong();
			long y = sc.nextLong();

			long menheten = Math.abs(x) + Math.abs(y);

			if (menheten <= D) {
				brojprijetnji++;

			}

		}
		long totalDamage = brojprijetnji * KA;
		System.out.println(brojprijetnji);
		System.out.println(totalDamage);

		sc.close();
	}

}
