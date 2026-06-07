import java.util.ArrayList;
import java.util.List;

/**
 * Representa o Peão no xadrez.
 * Move-se uma casa à frente (ou duas a partir da posição inicial) e captura na diagonal.
 */
public class Peao extends Peca{

    /**
     * Cria um Peão com a posição e cor fornecidas.
     *
     * @param posicao posição inicial no tabuleiro
     * @param cor     cor da peça ("branco" ou "preto")
     */
    public Peao(Posicao posicao, String cor){
        super(posicao,cor);
    }

    /**
     * Retorna os movimentos válidos do Peão, considerando avanço simples, avanço duplo
     * na primeira jogada e captura diagonal de peça adversária.
     *
     * @param tabuleiro estado atual do tabuleiro
     * @return lista de posições válidas de destino
     */
    @Override
    public List<Posicao> movimentosValidos(Tabuleiro tabuleiro) {
        List<Posicao> movimentos = new ArrayList<>();
        Posicao posicaoAtual = getPosicao();

        int direcaoPeao = getCor().equals("branco") ? 1 : -1;
        
        int[][] direcoes = {{direcaoPeao,0}, {direcaoPeao,1}, {direcaoPeao,-1}};
        
        for (int[] direcao : direcoes) {
            int linha  = posicaoAtual.getLinha() + direcao[0];
            int coluna = posicaoAtual.getColuna() + direcao[1];

            if (new Posicao(linha, coluna).isValida()) {
                Posicao proxima = new Posicao(linha, coluna);
                Peca pecaNaCasa = tabuleiro.getPeca(proxima);

                if (direcao[1] == 0) {
                    if (pecaNaCasa == null) {
                        movimentos.add(proxima); 

                        boolean primeiraVez = getPosicao().getLinha() == 1 
                                        || getPosicao().getLinha() == 6;
                        if (primeiraVez) {
                            Posicao duasAFrente = new Posicao(
                                getPosicao().getLinha() + 2 * direcaoPeao, 
                                getPosicao().getColuna()
                            );
                            Peca pecaDuasAFrente = tabuleiro.getPeca(duasAFrente);
                            if (pecaDuasAFrente == null) {
                                movimentos.add(duasAFrente);
                            }
                        }
                    }
                } else {
                    if (pecaNaCasa != null && !pecaNaCasa.getCor().equals(getCor())) {
                        movimentos.add(proxima);
                    }
                }
            }
        } 
        return movimentos;
    }
}
