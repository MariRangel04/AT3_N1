package hotel;

import java.lang.Thread;

public class Hospedes extends Thread{
	private String nome;
	private int qtdPessoas;
	private Quartos[] quartos;

	public Hospedes(String nome, int qtdPessoas, Quartos[] quartos) {
		this.setNome(nome);
		this.setQtdPessoas(qtdPessoas);
		this.setQuartos(quartos);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public Quartos[] getQuartos() {
		return quartos;
	}

	public void setQuartos(Quartos[] quartos) {
		this.quartos = quartos;
	}
	
	@Override
	public void run() {
		System.out.println("Iniciei Thread: " + this.getNome());
	}
}