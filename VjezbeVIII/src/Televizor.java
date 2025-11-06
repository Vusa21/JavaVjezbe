public class Televizor extends Eproizvodi {
	private double ekranInch;

	public Televizor(String opisProizvoda, String sifraProizvoda, double uvoznaCijena, double ekranInch) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.ekranInch = ekranInch;

	}

	public double getEkranInch() {
		return ekranInch;
	}

	public void setEkranInch(double ekranInch) {
		this.ekranInch = ekranInch;
	}

}
