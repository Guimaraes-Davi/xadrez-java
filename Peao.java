import java.util.ArrayList;
import java.util.List;

public class Peao extends Peca{

    public Peao(Posicao posicao, String cor){
        super(posicao,cor);
    }

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
                Peca    pecaNaCasa = tabuleiro.getPeca(proxima);

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
