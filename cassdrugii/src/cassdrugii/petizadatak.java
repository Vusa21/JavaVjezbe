package cassdrugii;
import java.util.Scanner;
public class petizadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double x1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double y2 = sc.nextDouble();
		double x3 = x2 + 2;
		double y3 = y2 - 3;
		
		double a  = Math.abs(x1 - x3);
		double b  = Math.abs(y3 - y1);
		
		
		double c = Math.sqrt(a * a + b * b);
		
		System.out.printf("Udaljenost je: " + c);
		
		sc.close();
		
		//%n koristimo da bi dodali novi red kada printamo nesto

	}

}
