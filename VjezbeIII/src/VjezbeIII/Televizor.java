package VjezbeIII;

public class Televizor {
	private int brojKanala;
	private String nazivKanala;
	private int jacinaTona;

	// Konstruktor
	public Televizor(int brojKanala, String nazivKanala, int jacinaTona) {
        if (brojKanala >= 1) {
            this.brojKanala = brojKanala;
        } else {
            this.brojKanala = 1;
        }
        this.nazivKanala = nazivKanala;
        if (jacinaTona >= 0 && jacinaTona <= 10) {
            this.jacinaTona = jacinaTona;
        } else {
            this.jacinaTona = 0;
        }
        //metod za pojacavanje tona
            

	void pojacajTon() {
		if (jacinaTona < 10) {
			jacinaTona++;
		}
	}
	// ispis

	public void ispisi() {
		System.out.println("Broj kanala: " + brojKanala);
		System.out.println("Naziv kanala: " + nazivKanala);
		System.out.println("Jacina tona: " + jacinaTona);
	}

}

}
