public abstract class Zaposleni {
	private int id;
	private String ime;
	private String prezime;
	private double satnica;
	private double ukupanBrojSatiSedmicno;

	public Zaposleni(int id, String ime, String prezime, double satnica, double ukupanBrojSatiSedmicno) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.satnica = satnica;
		this.ukupanBrojSatiSedmicno = ukupanBrojSatiSedmicno;
	}

	public int getId() {
		return id;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public double getSatnica() {
		return satnica;
	}

	public double getUkupanBrojSatiSedmicno() {
		return ukupanBrojSatiSedmicno;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setSatnica(double satnica) {
		this.satnica = satnica;
	}

	public void setUkupanBrojSatiSedmicno(double ukupanBrojSatiSedmicno) {
		this.ukupanBrojSatiSedmicno = ukupanBrojSatiSedmicno;
	}

	public abstract double izracunajNedeljnuPlatu();

	public double izracunajMjesecnuPlatu() {
		return izracunajNedeljnuPlatu() * 4.0;
	}

	@Override
	public String toString() {
		return String.format("ID:%d Ime:%s Prezime:%s Satnica:%.2f Sati/sedmica:%.2f", id, ime, prezime, satnica,
				ukupanBrojSatiSedmicno);
	}

}
