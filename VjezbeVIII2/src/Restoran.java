import java.util.ArrayList;
import java.util.List;

public class Restoran {
	private String naziv;
	private String adresa;
	private String pib;
	private List<Zaposleni> zaposleni;
	private List<Smjena> smjene;

	public Restoran(String naziv, String adresa, String pib) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.pib = pib;
		this.zaposleni = new ArrayList<>();
		this.smjene = new ArrayList<>();
	}

	public String getNaziv() { return naziv; }
	public String getAdresa() { return adresa; }
	public String getPib() { return pib; }

	public void addZaposleni(Zaposleni z) { if (z != null) zaposleni.add(z); }
	public boolean removeZaposleniById(int id) {
		Zaposleni z = findZaposleniById(id);
		return z != null && zaposleni.remove(z);
	}
	public Zaposleni findZaposleniById(int id) {
		for (Zaposleni z : zaposleni) if (z.getId() == id) return z;
		return null;
	}

	public double ukupniTrosakPlata(double localPerEur) {
		double sum = 0.0;
		for (Zaposleni z : zaposleni) sum += z.izracunajMjesecnuPlatu();
		return sum / localPerEur;
	}
	public double ukupniTrosakPlata() { return ukupniTrosakPlata(1.0); }

	public List<Zaposleni> getZaposleni() { return new ArrayList<>(zaposleni); }

	public void addSmjena(Smjena s) { if (s != null) smjene.add(s); }
	public boolean removeSmjena(Smjena s) { return smjene.remove(s); }
	public List<Smjena> getSmjene() { return new ArrayList<>(smjene); }

	public double ukupnoSatiZaposlenogUMjesecu(int id, int godina, int mjesec) {
		double sum = 0.0;
		for (Smjena sm : smjene) if (sm.umjesecu(godina, mjesec)) sum += sm.satiZaZaposlenogPoId(id);
		return sum;
	}

	public void generisiMjesecniObracun(double localPerEur) {
		System.out.println("Mesečni obračun");
		System.out.printf("%-4s %-12s %-12s %-10s %-8s %-12s %10s\n", "ID", "Ime", "Prezime", "Tip", "Sati", "Prek/BONUS", "Plata(EUR)");
		double totalLocal = 0.0;
		for (Zaposleni z : zaposleni) {
			double monthlyLocal = z.izracunajMjesecnuPlatu();
			String extra = "-";
			if (z instanceof Konobar) {
				Konobar k = (Konobar) z;
				double overtimeMonthly = (k.getPrekovremeniSati() * k.getSatnica() * 1.20) * 4.0;
				extra = String.format("%.2fh/%.2f", k.getPrekovremeniSati() * 4.0, overtimeMonthly);
			} else if (z instanceof Menadzer) {
				extra = String.format("%.2f", ((Menadzer) z).getBonusMjesecno());
			} else if (z instanceof Kuvar) {
				double baseMonthly = z.izracunajNedeljnuPlatu() * 4.0;
				extra = String.format("%.2f", monthlyLocal - baseMonthly);
			}
			totalLocal += monthlyLocal;
			double monthlyEur = monthlyLocal / localPerEur;
			System.out.printf("%-4d %-12s %-12s %-10s %-8.2f %-12s %10.2f\n",
				z.getId(), z.getIme(), z.getPrezime(), z.getClass().getSimpleName(), z.getUkupanBrojSatiSedmicno(), extra, monthlyEur);
		}
		System.out.printf("Ukupni trosak plata (EUR): %.2f\n", totalLocal / localPerEur);
	}

	public void generisiMjesecniObracunPoSmjenama(int godina, int mjesec, double localPerEur) {
		System.out.printf("Mjesecni obračun po smjenama %d-%02d\n", godina, mjesec);
		System.out.printf("%-4s %-12s %-12s %-10s %-8s %-12s %10s\n", "ID", "Ime", "Prezime", "Tip", "Sati", "Prek/BONUS", "Plata(EUR)");
		double totalLocal = 0.0;
		for (Zaposleni z : zaposleni) {
			double worked = ukupnoSatiZaposlenogUMjesecu(z.getId(), godina, mjesec);
			double monthlyLocal = 0.0;
			String extra = "-";
			if (z instanceof Konobar) {
				double expected = z.getUkupanBrojSatiSedmicno() * 4.0;
				double overtime = Math.max(0.0, worked - expected);
				monthlyLocal = (worked - overtime) * z.getSatnica() + overtime * z.getSatnica() * 1.20;
				extra = String.format("%.2fh/%.2f", overtime, overtime * z.getSatnica() * 1.20);
			} else if (z instanceof Menadzer) {
				monthlyLocal = 1300.0 + worked * z.getSatnica() + ((Menadzer) z).getBonusMjesecno();
				extra = String.format("%.2f", ((Menadzer) z).getBonusMjesecno());
			} else if (z instanceof Kuvar) {
				monthlyLocal = 1500.0 + worked * z.getSatnica();
				extra = String.format("%.2f", monthlyLocal - worked * z.getSatnica());
			} else {
				monthlyLocal = worked * z.getSatnica();
			}
			totalLocal += monthlyLocal;
			double monthlyEur = monthlyLocal / localPerEur;
			System.out.printf("%-4d %-12s %-12s %-10s %-8.2f %-12s %10.2f\n",
				z.getId(), z.getIme(), z.getPrezime(), z.getClass().getSimpleName(), worked, extra, monthlyEur);
		}
		System.out.printf("Ukupni trosak plata (EUR): %.2f\n", totalLocal / localPerEur);
	}
}