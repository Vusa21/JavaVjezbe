public class Kuvar extends Zaposleni {

	public Kuvar(int id, String prezime, double satnica, double ukupanBrojSatiSedmicno) {
		super(id, prezime, prezime, satnica, ukupanBrojSatiSedmicno);

	}

	@Override
	public double izracunajNedeljnuPlatu() {

		return getUkupanBrojSatiSedmicno() * getSatnica();
	}

	@Override
	public double izracunajMjesecnuPlatu() {
		return 1500.0 + 4.0 * getUkupanBrojSatiSedmicno() * getSatnica();
	}

	@Override
	public String toString() {
		return String.format("Kuvar - %s Mjesecna: %.2f", super.toString(), izracunajMjesecnuPlatu());
	}
}