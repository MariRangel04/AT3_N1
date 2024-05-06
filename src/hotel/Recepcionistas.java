package hotel;

public class Recepcionistas extends Thread {
//stributos - listas
    private Hospedes espera;
    private Quartos quartoLivre;
    private Quartos limpezaQuarto;
    
    //construtores
    public Recepcionistas(Hospedes espera, Quartos quartoLivre, Quartos limpezaQuarto) {
        this.setEspera(espera);
        this.setQuartoLivre(quartoLivre);
        this.setLimpezaQuarto(limpezaQuarto);
    }

	public Hospedes getEspera() {
		return espera;
	}

	public void setEspera(Hospedes espera) {
		this.espera = espera;
	}

	public Quartos getQuartoLivre() {
		return quartoLivre;
	}

	public void setQuartoLivre(Quartos quartoLivre) {
		this.quartoLivre = quartoLivre;
	}

	public Quartos getLimpezaQuarto() {
		return limpezaQuarto;
	}

	public void setLimpezaQuarto(Quartos limpezaQuarto) {
		this.limpezaQuarto = limpezaQuarto;
	}
}
