
public class Automobil extends Vozilo {
	private int brojVrata;
	private String tipMotora;

	public Automobil(String proizvodjac, int godinaProizvodnje, String boja, double kubikaza, int brojVrata,
			String tipGoriva) {
		super(proizvodjac, godinaProizvodnje, boja, kubikaza);
		this.brojVrata = brojVrata;
		this.tipMotora = tipGoriva;

	}

	public int getBrojVrata() {
		return brojVrata;
	}

	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}

	public String getTipGoriva() {
		return tipMotora;
	}

	public void setTipGoriva(String tipGoriva) {
		this.tipMotora = tipGoriva;
	}

	@Override
	public void prikaziInfo() {
		super.prikaziInfo();
		System.out.println("Broj vrata: " + brojVrata);
		System.out.println("Tip motora: " + tipMotora);
	}

	@Override
	public double CijenaRegistracije() {
		double cijena = super.CijenaRegistracije();
		if (tipMotora.equalsIgnoreCase("Dizel")) {
			cijena += 20;
		}
		return cijena;
	}
}
