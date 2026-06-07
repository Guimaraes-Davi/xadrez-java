import java.util.ArrayList;
import java.util.List;

/**
 * Representa a Rainha no xadrez.
 * Move-se qualquer número de casas em qualquer direção (horizontal, vertical ou diagonal).
 */
public class Rainha extends Peca{

    /**
     * Cria uma Rainha com a posição e cor fornecidas.
     *
     * @param posicao posição inicial no tabuleiro
     * @param cor     cor da peça ("branco" ou "preto")
     */
    public Rainha(Posicao posicao, String cor){
        super(posicao,cor);
    }

    /**
     * Retorna os movimentos válidos da Rainha: desloca-se nas oito direções
     * até encontrar o limite do tabuleiro ou outra peça.
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

            while (new Posicao(linha, coluna).isValida()) {
                Posicao proxima = new Posicao(linha, coluna);
                Peca pecaNaCasa = tabuleiro.getPeca(proxima);

                if (pecaNaCasa == null) {
                    movimentos.add(proxima);

                } else if (!pecaNaCasa.getCor().equals(getCor())) {
                    movimentos.add(proxima);
                    break;
                } else {
                    break;
                }
                
                linha  += direcao[0];
                coluna += direcao[1];
            }
        } 
        return movimentos;
    }
}
