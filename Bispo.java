import java.util.ArrayList;
import java.util.List;

/**
 * Representa o Bispo no xadrez.
 * Move-se qualquer número de casas na diagonal.
 */
public class Bispo extends Peca{

    /**
     * Cria um Bispo com a posição e cor fornecidas.
     *
     * @param posicao posição inicial no tabuleiro
     * @param cor     cor da peça ("branco" ou "preto")
     */
    public Bispo(Posicao posicao, String cor){
        super(posicao,cor);
    }

    /**
     * Retorna os movimentos válidos do Bispo: desloca-se nas quatro diagonais
     * até encontrar o limite do tabuleiro ou outra peça.
     *
     * @param tabuleiro estado atual do tabuleiro
     * @return lista de posições válidas de destino
     */
    @Override
    public List<Posicao> movimentosValidos(Tabuleiro tabuleiro) {
        List<Posicao> movimentos = new ArrayList<>();
        Posicao posicaoAtual = getPosicao();

        int[][] direcoes = {{1,1}, {1,-1}, {-1,1}, {-1,-1}};

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