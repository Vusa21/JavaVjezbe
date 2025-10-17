package zadacizavjezbu;

import java.util.Scanner;

public class rastojanjekancelarija {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double rastojanje = sc.nextDouble();
		double metri = rastojanje / 100;

		System.out.printf("Rastojanje u metrima je:%.0f ", metri);

		sc.close();

	}

}
