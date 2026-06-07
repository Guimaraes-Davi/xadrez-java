public class Tabuleiro {
    
    private Peca[][] casas = new Peca[8][8];

    public Tabuleiro() {
        inicializar();
    }

    public Peca getPeca(Posicao posicao) {
        int pecaLinha = posicao.getLinha();
        int pecaColuna = posicao.getColuna();
        return casas[pecaLinha][pecaColuna];
    }

public void mover(Posicao origem, Posicao destino) {
    if (destino.isValida()) {
        Peca pecaMovendo = getPeca(origem);
        casas[destino.getLinha()][destino.getColuna()] = pecaMovendo;
        casas[origem.getLinha()][origem.getColuna()] = null;
        pecaMovendo.setPosicao(destino);
    } else {
        System.out.println("Posição destino fora do tabuleiro");
    }
}

    public void inicializar() {
        for (int i = 0; i < 2; i++){
            String cor = "branco";
            if (i > 0){
                cor = "preto"; 
            }            
            int linhaBase = (i == 0) ? 0 : 7; 
            int linhaPeao = (i == 0) ? 1 : 6;

            for (int col = 0; col < 8; col++) {
                casas[linhaPeao][col] = new Peao(new Posicao(linhaPeao, col), cor);
            }
            for (int h = 0; h < 2; h++){
                int col = (h == 0) ? 0 : 7; 
                casas[linhaBase][col] = new Torre(new Posicao(linhaBase, col), cor);
                col = (h == 0) ? 1 : 6; 
                casas[linhaBase][col] = new Cavalo(new Posicao(linhaBase, col), cor);
                col = (h == 0) ? 2 : 5; 
                casas[linhaBase][col] = new Bispo(new Posicao(linhaBase, col), cor);
            }
            casas[linhaBase][3] = new Rainha(new Posicao(linhaBase, 3), cor);
            casas[linhaBase][4] = new Rei(new Posicao(linhaBase, 4), cor);
        }
    }
}