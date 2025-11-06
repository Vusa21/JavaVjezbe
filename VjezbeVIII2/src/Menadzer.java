public class Menadzer extends Zaposleni {
	private double bonusMjesecno;

	public Menadzer(int id, String ime, String prezime, double satnica, double ukupanBrojSatiSedmicno,
			double bonusMjesecno) {
		super(id, ime, prezime, satnica, ukupanBrojSatiSedmicno);
		this.bonusMjesecno = bonusMjesecno;
	}

	public double getBonusMjesecno() {
		return bonusMjesecno;
	}

	public void setBonusMjesecno(double bonusMjesecno) {
		this.bonusMjesecno = bonusMjesecno;
	}

	@Override
	public double izracunajNedeljnuPlatu() {
		return getUkupanBrojSatiSedmicno() * getSatnica();
	}

	@Override
	public double izracunajMjesecnuPlatu() {
		return 1300.0 + 4.0 * getUkupanBrojSatiSedmicno() * getSatnica() + bonusMjesecno;
	}

	@Override
	public String toString() {
		return String.format("Menadzer - %s Bonus/mjesec: %.2f Mjesecna: %.2f", super.toString(), bonusMjesecno,
				izracunajMjesecnuPlatu());
	}
}