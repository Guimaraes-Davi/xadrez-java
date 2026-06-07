

import java.util.List;

public abstract class Peca{

    private Posicao posicao;
    private String cor;


    public Peca(Posicao posicao, String cor) {
        this.posicao = posicao;
        this.cor = cor;
    }
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }
    public String getCor() {return cor;}
    public Posicao getPosicao() {return posicao;}
    

    public abstract List<Posicao> movimentosValidos(Tabuleiro tabuleiro);
}
