package cassdrugii;
import java.util.Scanner;
public class dron {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 
		
		 System.out.print("Koliko paketa: ");
	        int n = sc.nextInt();

	        for (int i = 1; i <= n; i++) {
	            System.out.print("x = ");
	            double x = sc.nextDouble();
	            System.out.print("y = ");
	            double y = sc.nextDouble();

	            if (x > 0 && y > 0) {
	                double d = Math.sqrt((x * x) + (y * y));
	                System.out.println("Dron pokupio paket (" + x + ", " + y + ") distanca: " + d);
	            }
	        }
	}
