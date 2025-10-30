import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Vozilo> vozila = new ArrayList<>();

		vozila.add(new Automobil("Golfara", 2015, "Siva", 1999, 4, "Benzin"));
		vozila.add(new Kamion("MAN", 2005, "Bijela", 5000, 10_000, true));
		vozila.add(new Kombi("Fiat", 2012, "Plava", 2200, 8));

		System.out.println("Automobil: " + vozila.get(0).CijenaRegistracije() + " €");
		System.out.println("Kamion: " + vozila.get(1).CijenaRegistracije() + " €");
		System.out.println("Kombi: " + vozila.get(2).CijenaRegistracije() + " €");

		for (Vozilo vozilo : vozila) {
			System.out.println("\nInformacije o vozilu:");
			vozilo.prikaziInfo();
		}

	}
}