
public class Kamion extends Vozilo {
	private double KapacitetTovara;
	private boolean Prikolica;

	public Kamion(String proizvodjac, int godinaProizvodnje, String boja, double kubikaza, double kapacitetTovara,
			boolean prikolica) {
		super(proizvodjac, godinaProizvodnje, boja, kubikaza);
		KapacitetTovara = kapacitetTovara;
		Prikolica = prikolica;
	}

	public double getKapacitetTovara() {
		return KapacitetTovara;
	}

	public void setKapacitetTovara(double kapacitetTovara) {
		KapacitetTovara = kapacitetTovara;
	}

	public boolean isPrikolica() {
		return Prikolica;
	}

	public void setPrikolica(boolean prikolica) {
		Prikolica = prikolica;
	}

	@Override
	public void prikaziInfo() {
		super.prikaziInfo();
		System.out.println("Kapacitet tovara: " + KapacitetTovara + " tona");
		System.out.println("Ima prikolicu: " + (Prikolica ? "Da" : "Ne"));
	}

	@Override
	public double CijenaRegistracije() {
		double cijena = super.CijenaRegistracije();

		if (Prikolica) {
			cijena += 50;
		}
		return cijena;
	}
}
