package hotel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Main {
	
	private static int NUMERO_QUARTOS = 10;
	private static int NUMERO_HOSPEDES = 50;
	
	public static void main(String[] args) {
		
		//ArrayBlockingQueue: Permite que várias threads adicionem elementos à fila ou removam elementos dela sem se corromperem mutuamente.
        BlockingQueue<Hospedes> espera = new ArrayBlockingQueue<>(NUMERO_HOSPEDES);
        BlockingQueue<Quartos> quartosLivre = new ArrayBlockingQueue<>(NUMERO_QUARTOS);
        BlockingQueue<Quartos> limpezaQuarto = new ArrayBlockingQueue<>(NUMERO_QUARTOS);
        
        Quartos[] quartos = new Quartos[NUMERO_QUARTOS];
        for (int i = 0; i < NUMERO_QUARTOS; i++) {
            quartos[i] = new Quartos(i + 1); 
        }


        //comeca a execucao do Thread
        for (int i = 0; i < 5; i++) {
            new Recepcionistas(espera, quartosLivre, limpezaQuarto).start(); 
        }

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   
        for (int i = 0; i < NUMERO_HOSPEDES; i++) {
            new Hospedes("Hóspede " + (i + 1), 1, quartos).start(); 
        }
	}
}