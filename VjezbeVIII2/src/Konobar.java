public class Konobar extends Zaposleni {
	private double prekovremeniSati;

	public Konobar(int id, String ime, String prezime, double satnica, double ukupanBrojSatiSedmicno,
			double prekovremeniSati) {
		super(id, ime, prezime, satnica, ukupanBrojSatiSedmicno);
		this.prekovremeniSati = prekovremeniSati;
	}

	public double getPrekovremeniSati() {
		return prekovremeniSati;
	}

	public void setPrekovremeniSati(double prekovremeniSati) {
		this.prekovremeniSati = prekovremeniSati;
	}

	@Override
	public double izracunajNedeljnuPlatu() {
		double osnovna = getUkupanBrojSatiSedmicno() * getSatnica();
		double prekovremeni = prekovremeniSati * getSatnica() * 1.20;
		return osnovna + prekovremeni;
	}

	@Override
	public String toString() {
		return String.format("Konobar - %s Prekovremeni/sedmica: %.2f Mjesecna: %.2f", super.toString(),
				prekovremeniSati, izracunajMjesecnuPlatu());
	}
}