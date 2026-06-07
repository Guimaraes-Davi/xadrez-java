import java.util.ArrayList;
import java.util.List;

/**
 * Representa o Cavalo no xadrez.
 * Move-se em formato de "L": duas casas em uma direção e uma na perpendicular.
 */
public class Cavalo extends Peca{

    /**
     * Cria um Cavalo com a posição e cor fornecidas.
     *
     * @param posicao posição inicial no tabuleiro
     * @param cor     cor da peça ("branco" ou "preto")
     */
    public Cavalo(Posicao posicao, String cor){
        super(posicao,cor);
    }

    /**
     * Retorna os movimentos válidos do Cavalo: todas as oito posições em "L"
     * que estejam dentro do tabuleiro e não ocupadas por peça aliada.
     *
     * @param tabuleiro estado atual do tabuleiro
     * @return lista de posições válidas de destino
     */
    @Override
    public List<Posicao> movimentosValidos(Tabuleiro tabuleiro) {
        List<Posicao> movimentos = new ArrayList<>();
        Posicao posicaoAtual = getPosicao();

        int[][] direcoes = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

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
