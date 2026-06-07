import java.util.List;

/**
 * Representa uma peça de xadrez genérica, com posição e cor definidas.
 * Subclasses concretas devem implementar {@link #movimentosValidos}.
 */
public abstract class Peca{

    private Posicao posicao;
    private String cor;


    /**
     * Cria uma peça com a posição e cor fornecidas.
     *
     * @param posicao posição inicial da peça no tabuleiro
     * @param cor     cor da peça ("branco" ou "preto")
     */
    public Peca(Posicao posicao, String cor) {
        this.posicao = posicao;
        this.cor = cor;
    }
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }
    public String getCor() {return cor;}
    public Posicao getPosicao() {return posicao;}
    

    /**
     * Retorna a lista de posições válidas para onde esta peça pode se mover.
     *
     * @param tabuleiro estado atual do tabuleiro, usado para verificar ocupação das casas
     * @return lista de posições válidas de destino
     */
    public abstract List<Posicao> movimentosValidos(Tabuleiro tabuleiro);
}
