import java.util.ArrayList;

public class Eproizvodi {
	private String opisProizvoda;
	private String sifraProizvoda;
	private double uvoznaCijena;

	public Eproizvodi(String opisProizvoda, String sifraProizvoda, double uvoznaCijena) {
		this.opisProizvoda = opisProizvoda;
		this.sifraProizvoda = sifraProizvoda;
		this.uvoznaCijena = uvoznaCijena;
	}

	public String getOpisProizvoda() {
		return opisProizvoda;
	}

	public String getSifraProizvoda() {
		return sifraProizvoda;
	}

	public double getUvoznaCijena() {
		return uvoznaCijena;
	}

	public void setOpisProizvoda(String opisProizvoda) {
		this.opisProizvoda = opisProizvoda;
	}

	public void setSifraProizvoda(String sifraProizvoda) {
		this.sifraProizvoda = sifraProizvoda;
	}

	public void setUvoznaCijena(double uvoznaCijena) {
		this.uvoznaCijena = uvoznaCijena;
	}

	public String getKategorija() {
		if (sifraProizvoda == null || sifraProizvoda.length() < 2) {
			return "Nepoznata";
		}
		String pref = sifraProizvoda.substring(0, 2).toUpperCase();
		switch (pref) {
		case "RA":
			return "Racunari";
		case "TE":
			return "Telefoni";
		case "TV":
			return "Televizori";
		default:
			return "Nepoznata";
		}
	}

	public double izracunajMaloprodajnuCijenu() {
		double cijena = this.uvoznaCijena * 1.05;

		if (this instanceof Racunar) {
			cijena *= 1.05;
		} else if (this instanceof Telefon) {
			Telefon t = (Telefon) this;
			if (t.getEkranInch() > 6.0) {
				cijena *= 1.03;
			}
		} else if (this instanceof Televizor) {
			Televizor tv = (Televizor) this;
			if (tv.getEkranInch() > 65.0) {
				cijena *= 1.10;
			}
		}

		return cijena;
	}

	public static Eproizvodi[] dohvatiProizvodePoTipu(Eproizvodi[] proizvodi, String tip) {
		if (proizvodi == null || tip == null) {
			return new Eproizvodi[0];
		}
		ArrayList<Eproizvodi> pronadjeni = new ArrayList<>();
		String tipUpper = tip.trim().toUpperCase();
		for (Eproizvodi p : proizvodi) {
			if (p == null) {
				continue;
			}

			boolean poklapaSe = false;
			String kategorija = p.getKategorija();
			if (kategorija != null && kategorija.equalsIgnoreCase(tip)) {
				poklapaSe = true;
			}
			String sifra = p.getSifraProizvoda();
			if (!poklapaSe && sifra != null && sifra.length() >= 2) {
				String pref = sifra.substring(0, 2).toUpperCase();
				if (pref.equals(tipUpper)) {
					poklapaSe = true;
				}
			}
			if (poklapaSe) {
				pronadjeni.add(p);
			}
		}

		return pronadjeni.toArray(new Eproizvodi[0]);
	}

}