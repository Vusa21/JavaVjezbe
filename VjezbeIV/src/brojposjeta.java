
public class brojposjeta {

	import java.util.Scanner;
	public static double brojPosjeta(int[] niz) {
		int suma = 0;
		int broj = 0;
		int max = 0;
		for (int x : niz) {
			if (x > 0 && x % 2 == 0) {
				max = x;
				broj++;
			}
		}
		if (broj == 0) {
			return 0;
		}
		return max;
	}

public static void main(String[] args) {
	scanner sc = new Scanner(System.in);
	System.out.println("Unesite broj posjeta na utawkmici: \n");
	int[] niz = new int[10];
	for (int i = 0; i < niz.length; i++) {
		niz[i] = sc.nextInt();
		System.out.println("Najveci broj posjeta je" + max \n");
	}
}
