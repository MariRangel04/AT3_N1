package hotel;

public class Hospedes extends Thread {
    //atributos
    private String nome;
    private int qtdPessoas;
    private Quartos[] quartos;

    //construtores
    public Hospedes(String nome, int qtdPessoas, Quartos[] quartos) {
        this.nome = nome;
        this.qtdPessoas = qtdPessoas;
        this.quartos = quartos;
    }

    @Override
    public void run() {
        try {
            Quartos quarto = getQuartoDisponivel();
            if (quarto != null) {
                synchronized (quarto) {
                    if (!quarto.Ocupado() && quarto.DevolucaoChave()) {
                        realizarCheckin(quarto);
                        Thread.sleep(2000);  // Simula estadia do hospede
                        realizarCheckout(quarto);
                        limparQuarto(quarto);
                    } else {
                        System.out.println("\n\033[0;31m" + nome + " não possui quarto para checkin\033[0m");
                    }
                }
            } else {
                System.out.println("\n\033[0;31m" + nome + " não conseguiu reservar um quarto.\033[0m");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    //metodos

    //verifica se quarto esta disponivel ou não
    private Quartos getQuartoDisponivel() {
        for (Quartos quarto : quartos) {
            if (!quarto.Ocupado() && quarto.DevolucaoChave()) {
                return quarto;
            }
        }
        return null;
    }

    // Realiza o check-in do hóspede
    private void realizarCheckin(Quartos quarto) {
        quarto.setOcupado(true);
        quarto.setDevolucaoChave(false);
        System.out.println("\n\033[0;32m->" + nome + " realizou CHECKIN no quarto " + quarto.getNumero() + "\033[0m");
    }

    // Realiza o check-out do hóspede
    private void realizarCheckout(Quartos quarto) {
        quarto.setOcupado(false);
        quarto.setDevolucaoChave(true);
        System.out.println("\n\033[0;32m->" + nome + " fez o CHECKOUT do quarto " + quarto.getNumero() + "\033[0m");
    }

    // Limpa o quarto após o check-out
    private void limparQuarto(Quartos quarto) {
        System.out.println("SENDO LIMPO:");
        System.out.println("Servico de quarto " + quarto.getNumero() + "");

        // quarto esta disponivel para alocação novo hospede
        quarto.setDevolucaoChave(true);
        quarto.setOcupado(false);
        System.out.println("\nPRONTO:");
        System.out.println("Quarto " + quarto.getNumero() + " limpo e pronto para ocupação.");
    }

    //get e sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }
}
