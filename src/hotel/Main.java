package hotel;

<<<<<<< HEAD


public class Main {
    public static void main(String[] args) {
    	System.out.println("OI");

    }

=======

public class Main {
	
	private static int NUMERO_QUARTOS = 10;
	private static int NUMERO_HOSPEDES = 50;
	
	public static void main(String[] args) {
		
        for (int i = 0; i < NUMERO_HOSPEDES; i++) {
            new Hospedes("Hóspede " + (i + 1), 1, null).start(); // Crie e inicie 50 Hóspedes
        }
	}
>>>>>>> 73a8f8b3e4bdee6435167574c207c3aea281aed6
}