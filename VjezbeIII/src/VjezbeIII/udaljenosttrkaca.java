package VjezbeIII;

import java.util.Scanner;

public class udaljenosttrkaca {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// koordinate kruga
		System.out.println("Unesite koordinate kruga:");
		double cx = sc.nextDouble();
		double cy = sc.nextDouble();

		System.out.println("Unesite poluprecnik prvog kruga:");
		double r1 = sc.nextDouble();

		System.out.println("Unesite poliprecnik drugog kruga:");
		double r2 = sc.nextDouble();

		System.out.println("Unesite broj trkaca:");
		int N = sc.nextInt();

		int unutrarstaze = 0;

		for (int i = 0; i <= N; i++) {

			System.out.println("Unesite x trkaca:");
			double xt = sc.nextDouble();
			System.out.println("Unesite y trkaca:");
			double yt = sc.nextDouble();

			double d = Math.sqrt(Math.pow(xt - cx, 2) + Math.pow(yt - cy, 2));

			if (d >= r1 && d <= r2 && yt >= cy) {

			}

		}
	}

}
