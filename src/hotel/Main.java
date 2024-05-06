package hotel;



public class Main {
	
	private static int NUMERO_QUARTOS = 10;
	private static int NUMERO_HOSPEDES = 50;
	
	public static void main(String[] args) {
		
        for (int i = 0; i < NUMERO_HOSPEDES; i++) {
            new Hospedes("Hóspede " + (i + 1), 1, null).start(); // Crie e inicie 50 Hóspedes
        }
        
        Quartos[] quartos = new Quartos[NUMERO_QUARTOS];
        for (int i = 0; i < NUMERO_QUARTOS; i++) {
            quartos[i] = new Quartos(i + 1); // Os números dos quartos começam em 1
        }

	}

}