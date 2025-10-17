package cassdrugii;
import java.util.Scanner;
public class Pravugaonik {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		double a = sc.nextDouble(); 
		double b = sc.nextDouble();
		
		double p = a*b;
		double o = 2*a+2*b;
	
		System.out.printf("Povrsina je:%.2f O=%.2f%n",p,o);
//Ovo %.2f znaci da preuzmemo broj gore upisan i da ga zaokruzimo na dvije decimale
		
	}

}
