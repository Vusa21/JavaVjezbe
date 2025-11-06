public class Telefon extends Eproizvodi {
	private String operativniSistem;
	private double ekranInch;

	public Telefon(String opisProizvoda, String sifraProizvoda, double uvoznaCijena, String operativniSistem,
			double ekranInch) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.operativniSistem = operativniSistem;
		this.ekranInch = ekranInch;
	}

	public String getOperativniSistem() {
		return operativniSistem;
	}

	public double getEkranInch() {
		return ekranInch;
	}

	public void setOperativniSistem(String operativniSistem) {
		this.operativniSistem = operativniSistem;
	}

	public void setEkranInch(double ekranInch) {
		this.ekranInch = ekranInch;
	}

}