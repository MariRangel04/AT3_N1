package hotel;

import java.util.ArrayList;
import java.util.List;

public class Quartos {
	//atributos
	private int numero;
	private boolean estaestadoQuarto;
	private boolean chave;
	private int capacidade;
	private List<Hospedes> hospedes;

	//construtor
	public Quartos(int numero) {
		this.numero = numero;
		this.estaestadoQuarto = false;
		this.chave = true;
		this.hospedes = new ArrayList<>();
		this.setCapacidade(4);
	}

	//get e set
	public int getNumero() {
		return numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public boolean Ocupado() {
		return estaestadoQuarto;
	}
	public boolean DevolucaoChave() {
		return chave;
	}

	public synchronized int getNumeroHospedes() {
		return hospedes.size();
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public void setOcupado(boolean ocupado) {
		this.estaestadoQuarto = ocupado;
	}

	public void setDevolucaoChave(boolean devolucaoChave) {
		this.chave = devolucaoChave;
	}
}
