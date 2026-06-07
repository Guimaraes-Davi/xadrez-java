import java.util.ArrayList;
import java.util.List;

/**
 * Representa o Rei no xadrez.
 * Move-se uma casa em qualquer direção (horizontal, vertical ou diagonal).
 */
public class Rei extends Peca{

    /**
     * Cria um Rei com a posição e cor fornecidas.
     *
     * @param posicao posição inicial no tabuleiro
     * @param cor     cor da peça ("branco" ou "preto")
     */
    public Rei(Posicao posicao, String cor){
        super(posicao,cor);
    }

    /**
     * Retorna os movimentos válidos do Rei: uma casa em qualquer das oito direções,
     * desde que a casa esteja vazia ou ocupada por peça adversária.
     *
     * @param tabuleiro estado atual do tabuleiro
     * @return lista de posições válidas de destino
     */
    @Override
    public List<Posicao> movimentosValidos(Tabuleiro tabuleiro) {
        List<Posicao> movimentos = new ArrayList<>();
        Posicao posicaoAtual = getPosicao();

        int[][] direcoes = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};

        for (int[] direcao : direcoes) {
            int linha  = posicaoAtual.getLinha() + direcao[0];
            int coluna = posicaoAtual.getColuna() + direcao[1];

            if (new Posicao(linha, coluna).isValida()) {
                Posicao proxima = new Posicao(linha, coluna);
                Peca pecaNaCasa = tabuleiro.getPeca(proxima);

                if (pecaNaCasa == null) {
                    movimentos.add(proxima);

                } else if (!pecaNaCasa.getCor().equals(getCor())) {
                    movimentos.add(proxima);
                }
            }
        } 
        return movimentos;
    }
}
