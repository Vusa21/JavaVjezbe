
public class nizcijelihbrojeva {
	public static void main(String[] args) {
		int[] niz = new int[10];
		for (int i = 0; i < niz.length; i++) {
			niz[i] = i + 1;
			System.out.println(niz[i]);
		}
		for (int i = niz.length - 1; i >= 0; i--) {
			System.out.println(niz[i]);
		}
	}
}
