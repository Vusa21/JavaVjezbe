package cassdrugii;
import java.util.Scanner;

public class duzinatrake {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		double p = sc.nextDouble();
		
		double r=Math.sqrt(p / Math.PI);
		double o=2*r*Math.PI;
		System.out.printf("%.2f%n",o);
		sc.close();
	}

}
