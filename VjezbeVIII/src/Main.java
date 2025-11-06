public class Main {
	public static void main(String[] args) {
		Eproizvodi[] proizvodi = new Eproizvodi[] {

				new Racunar("Laptop X", "RA001", 500.0, "Intel", 16),
				new Telefon("Phone A", "TE002", 200.0, "Android", 6.5),
				new Telefon("Phone B", "TE003", 150.0, "Android", 5.5), new Televizor("TV Ultra", "TV010", 800.0, 70.0),
				new Televizor("TV Small", "TV011", 300.0, 50.0) };

		System.out.println("Svi proizvodi:");

		System.out.println();
		System.out.println("Dohvati Racunari (prefix RA):");
		Eproizvodi.dohvatiProizvodePoTipu(proizvodi, "RA");

		System.out.println();
		System.out.println("Dohvati Telefoni (name 'Telefoni'):");
		Eproizvodi.dohvatiProizvodePoTipu(proizvodi, "Telefoni");

		System.out.println();
		System.out.println("Dohvati Televizori (prefix TV):");
		Eproizvodi.dohvatiProizvodePoTipu(proizvodi, "TV");

	}

}
