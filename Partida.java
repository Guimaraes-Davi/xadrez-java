import java.util.List;

public class Partida {
    
    private static final String BRANCAS = "branco";
    private static final String PRETAS = "preto";
    private String turno = BRANCAS;
    private Tabuleiro tabuleiro = new Tabuleiro();

        public String getTurno() {
        return turno;
    }

    
    private void alternarTurno() {
        if (turno.equals(BRANCAS)) {
            turno = PRETAS;
        } else {
            turno = BRANCAS;
        }
    }
    
    public void jogar(Posicao origem, Posicao destino) {
        Peca pecaOrigem = tabuleiro.getPeca(origem);
        if (pecaOrigem == null) {
            System.out.println("Não há peça na posição de origem.");
            return;
        }
        if (!pecaOrigem.getCor().equals(turno)) {
            System.out.println("Não é sua vez");
            return;
        }

        List<Posicao> movimentos = pecaOrigem.movimentosValidos(tabuleiro);
        if (!movimentos.contains(destino)) {
            System.out.println("Movimento inválido.");
        return;
        }
        tabuleiro.mover(origem, destino);
        alternarTurno();

    }


}
