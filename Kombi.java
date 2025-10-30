public class Kombi extends Vozilo {
	private double kapacitetPutnika;

	public Kombi(String proizvodjac, int godinaProizvodnje, String boja, double kubikaza, double kapacitetPutnika) {
		super(proizvodjac, godinaProizvodnje, boja, kubikaza);
		this.kapacitetPutnika = kapacitetPutnika;

	}

	public double getKapacitetPutnika() {
		return kapacitetPutnika;
	}

	public void setKapacitetPutnika(double kapacitetPutnika) {
		this.kapacitetPutnika = kapacitetPutnika;
	}

	@Override
	public void prikaziInfo() {
		super.prikaziInfo();
		System.out.println("Kapacitet putnika: " + kapacitetPutnika + " osoba");
	}

	@Override
	public double CijenaRegistracije() {
		double cijena = super.CijenaRegistracije();
		if (kapacitetPutnika > 8) {
			cijena += 30;
		}
		return cijena;
	}
}