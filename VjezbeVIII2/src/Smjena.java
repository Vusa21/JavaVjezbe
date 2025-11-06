import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Smjena {
	public enum TipSmjene {
		JUTARNJA, POPODNEVNA, NOCNA
	}

	private LocalDate datum;
	private LocalTime pocetak;
	private LocalTime kraj;
	private TipSmjene tip;
	private List<Zaposleni> zaposleni;

	public Smjena(LocalDate datum, LocalTime pocetak, LocalTime kraj, TipSmjene tip) {
		this.datum = datum;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.tip = tip;
		this.zaposleni = new ArrayList<>();
	}

	public LocalDate getDatum() {
		return datum;
	}

	public LocalTime getPocetak() {
		return pocetak;
	}

	public LocalTime getKraj() {
		return kraj;
	}

	public TipSmjene getTip() {
		return tip;
	}

	public List<Zaposleni> getZaposleni() {
		return Collections.unmodifiableList(zaposleni);
	}

	public void addZaposleni(Zaposleni z) {
		if (z != null && !zaposleni.contains(z)) {
			zaposleni.add(z);
		}
	}

	public boolean removeZaposleni(Zaposleni z) {
		return zaposleni.remove(z);
	}

	public double getDurationHours() {
		LocalDateTime start = datum.atTime(pocetak);
		LocalDateTime end = datum.atTime(kraj);
		if (!end.isAfter(start)) {
			end = end.plusDays(1);
		}
		Duration d = Duration.between(start, end);
		return d.toMinutes() / 60.0;
	}

	public double satiZaZaposlenogPoId(int id) {
		for (Zaposleni z : zaposleni) {
			if (z != null && z.getId() == id) {
				return getRadnoVrijeme();
			}
		}
		return 0.0;
	}

	private double getRadnoVrijeme() {
		return 0;
	}

	public boolean umjesecu(int godina, int mjesec) {
		return datum.getYear() == godina && datum.getMonthValue() == mjesec;
	}

	@Override
	public String toString() {
		return String.format("Smjena[%s %s-%s %s] (zaposlenih: %d)", datum, pocetak, kraj, tip, zaposleni.size());
	}
}