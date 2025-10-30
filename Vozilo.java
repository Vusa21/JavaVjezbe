public class Vozilo {
	private String proizvodjac;
	private int godinaProizvodnje;
	private String boja;
	private double kubikaza;

	public Vozilo(String proizvodjac, int godinaProizvodnje, String boja, double kubikaza) {
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.boja = boja;
		this.kubikaza = kubikaza;

	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public double getKubikaza() {
		return kubikaza;
	}

	public void setKubikaza(double kubikaza) {
		this.kubikaza = kubikaza;
	}

	public void prikaziInfo() {
		System.out.println("Proizvođač: " + proizvodjac);
		System.out.println("Godina proizvodnje: " + godinaProizvodnje);
		System.out.println("Boja: " + boja);
		System.out.println("Kubikaža: " + kubikaza + " cm³");
	}

	public double CijenaRegistracije() {
		double cijena = 100;
		if (godinaProizvodnje < 2010) {
			cijena += 30;
		}
		if (kubikaza > 2000) {
			cijena += 50;
		}

		return cijena;
	}
}