package com.testprvogcasa;
import java.util.Scanner;

public class DrugiPrimjer {

	public static void main(String[] args) {
		Scanner unos = new Scanner(System.in);
		
		int x1, x2, x3;
		double y1, y2, y3;
		
		System.out.print("Unijeti dva cijela broja: ");
		x1 = unos.nextInt();
		x2 = unos.nextInt();
		
		System.out.print("Unijeti dva realna broja: ");
		y1 = unos.nextInt();
		y2 = unos.nextInt();
		
		x3 = x1 + x2;
		y3 = y1 * y2;
		
		System.out.printf("Zbir %d + %d = %d,\ na proizvod %.2f * %.3f", x1, x2, x3, y1, y2, y3);
		}

}
