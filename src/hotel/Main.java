package hotel;

public class Main {
	
	private static int NUMERO_QUARTOS = 10;
	private static int NUMERO_HOSPEDES = 50;
	
	public static void main(String[] args) {	
		// Crie e inicie as threads para os Hóspedes
        for (int i = 0; i < 50; i++) {
            new Hospedes("Hóspede " + (i + 1), 1, null).start(); // Crie e inicie 50 Hóspedes
        }
	}
}