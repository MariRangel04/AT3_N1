package hotel;

import java.lang.Thread;
import java.util.ArrayList;

public class Hospedes extends Thread{
	private String nome;
	private int qtdPessoas;
	private ArrayList<Quartos> quartos;

	public Hospedes(String nome, int qtdPessoas, ArrayList<Quartos> quartos) {
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

	public ArrayList<Quartos> getQuartos() {
		return quartos;
	}

	public void setQuartos(ArrayList<Quartos> quartos) {
		this.quartos = quartos;
	}
	
	@Override
	public void run() {
		System.out.println("Iniciei Thread: " + this.getNome());
	}
}