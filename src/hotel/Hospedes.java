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

	@Override
	public void run() {
		System.out.println("Iniciei Thread: " + this.getNome());
		try {
			Quartos quartos = getQDisponiveis();
			if(quartos != null) {
				synchronized (quartos) {
					if (!quartos.Ocupado() && quartos.DevolucaoChave()) {
						quartos.setOcupado(true);
						quartos.setDevolucaoChave(false);
						System.out.println("\033[32m\033[1m*------------------------------------------------------------*\033[0m\033[0m");
						System.out.println("\033[32m\033[1m| "+ nome + " fez CHECKIN no quarto " + quartos.getNumero()+"|\033[0m\033[0m");
						System.out.println("\033[32m\033[1m*------------------------------------------------------------*\033[0m\033[0m");
						Thread.sleep(2000);
						quartos.setOcupado(false);
						quartos.setDevolucaoChave(true);
						quartos.setDevolucaoChave(true);
						System.out.println("\\033[32m\\033[1m*------------------------------------------------------------*\\033[32m\\033[1m");
						System.out.println("\\033[32m\\033[1m| "+ nome + " fez CHECKOUT no quarto " + quartos.getNumero()+"|\\033[32m\\033[1m");
						System.out.println("\\033[32m\\033[1m*------------------------------------------------------------*\\033[32m\\033[1m");
						limparQuarto(quartos);;
					}
					else {
						System.out.println("\\033[32m\\033[1m*------------------------------------------------------------*\\033[32m\\033[1m");
						System.out.println("\\033[32m\\033[1m|"+nome +" nao possui quarto para CHECKIN" +"|\\033[32m\\033[1m");
						System.out.println("\\033[32m\\033[1m*------------------------------------------------------------*\\033[32m\\033[1m");
					}
				}
			}else {
				System.out.println("\\033[32m\\033[1m*------------------------------------------------------------*\\033[32m\\033[1m");
				System.out.println("\\033[32m\\033[1m|"+nome +" nao  conseguio uma reserva" +"|\\033[32m\\033[1m");
				System.out.println("\\033[32m\\033[1m*------------------------------------------------------------*\\033[32m\\033[1m");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	//verificando se a quartos disponiveis 
	private Quartos getQDisponiveis() {
		for(Quartos quarto : quartos) {
			if (!quarto.Ocupado()&& quarto.DevolucaoChave()) {
				return quarto;
			}
		}
		return null;
	}
	//limparndo o quarto 
	private void limparQuarto(Quartos quartos) {
		System.out.println("\\03331m*------------------------------------------------------------*\\033[0m");
		System.out.println("\\033[32m\\033[1m| Serviso de quarto :"+quartos.getNumero()+"|\\033[32m\\033[1m");
		System.out.println("\\033[32m\\033[1m*------------------------------------------------------------*\\033[32m\\033[1m");
        // quarto esta disponivel para alocação novo hospede
        quartos.setDevolucaoChave(true);
        quartos.setOcupado(false);
        System.out.println("\nPRONTO:");
        System.out.println("Quarto " + quartos.getNumero() + " limpo e pronto para ocupação.");
		
	}
}
