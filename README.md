# AT/N1 - Atividade pratica coletiva -Bimestre N1
Crie um projeto (em Java 17) que simule um sistema de reserva e controle de quartos em um hotel, utilizando
threads em Java. 
- Quarto :
    - No mínimo, devem existir 10 quartos;
- Hóspede:
    - Cada hóspede deve ser representado por uma thread;
    - No mínimo, devem existir 50 hóspedes;
- Camareira:
    - Cada camareira deve ser representada por uma thread;
    - No mínimo, devem existir 10 camareiras
- Recepcionista:
    - Cada recepcionista deve ser representado por uma thread;
    - No mínimo, devem existir 5 recepcionistas;

E deve se basear na seguintes regras:<br>
    - O hotel deve contar com vários recepcionistas, que trabalham juntos e **que devem alocar hóspedesapenas em quartos vagos**;<br>
    - O hotel deve contar com várias camareiras;<br>
    - Cada quarto possui capacidade para até 4 hóspedes e uma única chave;<br>
    - Caso um grupo ou uma família possua mais do que 4 membros, eles devem ser divididos em vários quartos;<br>
    - Quando os hóspedes de um quarto saem do hotel para passear, devem deixar a chave na recepção;<br>
    - Uma camareira só pode entrar em um quarto caso ele esteja vago ou os hóspedes não estejam nele,ou seja, a chave esteja na recepção;<br>
    - A limpeza dos quartos é feita sempre após a passagem dos hóspedes pelo quarto. Isso significa que toda vez que os hóspedes saem do 
    quarto (para passear ou terminando sua estadia), deve haver a entrada de uma camareira para limpeza do quarto e os hóspedes só podem 
    retornar após o fim da limpeza;<br>
    - Um quarto vago que passa por limpeza não pode ser alocado para um hóspede novo;<br>
    - Caso uma pessoa chegue e não tenha quartos vagos, ele deve esperar em uma fila até algum quarto
      ficar vago. Caso a espera demore muito, ele passeia pela cidade e retorna após um tempo para tentar
      alugar um quarto novamente;<br>
    - Caso a pessoa tente duas vezes alugar um quarto e não consiga, ele deixa uma reclamação e vai embora.<br>

**Observações:**<br>
    - Não há a possibilidade de, para um mesmo quarto, somente parte dos hóspedes saírem para passear.
Ou saem todos ou nenhum;<br>
    - **A implementação deve ser abrangente e simular várias situações:**  número diferentes de hóspedes
chegando, grupos com mais de 4 pessoas, todos os quartos lotados, etc.<br>
    - **Atentem-se para a descrição de cada regra!! Deve haver sincronia e coordenação entre as
entidades.**
    
    
    
    
    
  





