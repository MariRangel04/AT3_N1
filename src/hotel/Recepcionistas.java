package hotel;

import java.util.concurrent.BlockingQueue;

public class Recepcionistas extends Thread {
    private BlockingQueue<Hospedes> espera;
    private BlockingQueue<Quartos> quartoLivre;
    private BlockingQueue<Quartos> limpezaQuarto;

    public Recepcionistas(BlockingQueue<Hospedes> espera, BlockingQueue<Quartos> quartoLivre, BlockingQueue<Quartos> limpezaQuarto) {
        this.espera = espera;
        this.quartoLivre = quartoLivre;
        this.limpezaQuarto = limpezaQuarto;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Hospedes hospede = espera.take();
                Quartos quarto = quartoLivre.take();
                synchronized (quarto) {
                    if (isQuartoDisponivel(quarto)) {
                        adicionarHospedeAoQuarto(hospede, quarto);
                    } else {
                        espera.offer(hospede);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isQuartoDisponivel(Quartos quarto) {
        return !quarto.Ocupado() && quarto.DevolucaoChave() && !quartoEmLimpeza(quarto);
    }

    private void adicionarHospedeAoQuarto(Hospedes hospede, Quartos quarto) throws InterruptedException {
        if (hospede.getQtdPessoas() <= (4 - quarto.getNumeroHospedes())) {
            quarto.AdicaoHospede(hospede);
            quarto.setOcupado(true);
            quarto.setDevolucaoChave(false);
            System.out.println("\u001B[32m--> Recepcionista RESERVOU o quarto " + quarto.getNumero() + " para: " + hospede.getNome() + "\u001B[0m");
        } else {
            dividirGrupoEmQuartos(hospede);
        }
    }

    private void dividirGrupoEmQuartos(Hospedes hospede) throws InterruptedException {
        while (hospede.getQtdPessoas() > 0) {
            Quartos novoQuarto = quartoLivre.take();
            synchronized (novoQuarto) {
                if (isQuartoDisponivel(novoQuarto)) {
                    int vagasRestantes = 4 - novoQuarto.getNumeroHospedes();
                    int pessoasNoGrupo = hospede.getQtdPessoas();
                    int pessoasParaAdicionar = Math.min(pessoasNoGrupo, vagasRestantes);
                    hospede.setQtdPessoas(pessoasNoGrupo - pessoasParaAdicionar);
                    novoQuarto.adicaoHospedeMedia(hospede, pessoasParaAdicionar);
                    novoQuarto.setOcupado(true);
                    novoQuarto.setDevolucaoChave(false);
                    System.out.println("\u001B[35m--> Recepcionista LIBEROU o quarto " + novoQuarto.getNumero() + " para parte do grupo de " + hospede.getNome() + "\u001B[0m");
                }
            }
        }
    }

    private boolean quartoEmLimpeza(Quartos quarto) {
        return limpezaQuarto.contains(quarto);
    }
}
