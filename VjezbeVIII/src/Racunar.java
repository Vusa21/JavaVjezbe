public class Racunar extends Eproizvodi {
	private String procesor;
	private int memorijaGB;

	public Racunar(String opisProizvoda, String sifraProizvoda, double uvoznaCijena, String procesor, int memorijaGB) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.procesor = procesor;
		this.memorijaGB = memorijaGB;
	}

	public String getProcesor() {
		return procesor;
	}

	public int getMemorijaGB() {
		return memorijaGB;
	}

	public void setProcesor(String procesor) {
		this.procesor = procesor;
	}

	public void setMemorijaGB(int memorijaGB) {
		this.memorijaGB = memorijaGB;
	}

}
