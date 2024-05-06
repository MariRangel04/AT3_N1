package hotel;

public class Camareiras extends Thread {
//atributos
    private Quartos[] quartos;
    
    //construtor
    public Camareiras(Quartos[] quartos) {
        this.quartos = quartos;
    }
 
    //metdodos
    //vai verificar se quarto esta vazio e a chave foi entregue na recepção para limpeza
    private Quartos getLimpezaQuarto() {
        for (Quartos quarto : quartos) {
            if (quarto.Ocupado() && !quarto.DevolucaoChave()) {
                return quarto;
            }
        }
        return null;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Quartos quarto = getLimpezaQuarto();
                if (quarto != null) {
                    limparQuarto(quarto);// Realiza a limpeza do quarto quando ele é liberado para ela
                    Thread.sleep(5000);// thread dorme para simular limpeza
                } else {
                    Thread.sleep(2000); // Se quatos estiverem limpos, thread espera e verifica dnv
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //
    private void limparQuarto(Quartos quarto) { // Começo limpeza e num quarto
    System.out.println("\nLIMPANDO:");
        System.out.println("Limpeza quarto: " + quarto.getNumero());

        // Mensagem quando limpeza é finalizada
        quarto.setOcupado(false);
        quarto.setDevolucaoChave(true);
        System.out.println("\nPRONTO:");
        System.out.println("Quarto " + quarto.getNumero() + " limpo e apto a hospedaagem!");
    }
}
