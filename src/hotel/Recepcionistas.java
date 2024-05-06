package hotel;

public class Recepcionistas extends Thread {
//stributos - listas
    private Hospedes espera;
    private Quartos quartoLivre;
    private Quartos limpezaQuarto;
    
    //construtores
    public Recepcionistas(Hospedes espera, Quartos quartoLivre, Quartos limpezaQuarto) {
        this.espera = espera;
        this.quartoLivre = quartoLivre;
        this.limpezaQuarto = limpezaQuarto;
    }
}
