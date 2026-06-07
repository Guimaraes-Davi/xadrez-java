/**
 * Representa uma posição no tabuleiro de xadrez, identificada por linha e coluna (0 a 7).
 */
public class Posicao {
    private int linha;
    private int coluna;

    /**
     * Cria uma posição com a linha e coluna especificadas.
     *
     * @param linha  índice da linha (0 a 7)
     * @param coluna índice da coluna (0 a 7)
     */
    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    public int getLinha() { return this.linha;}
    public int getColuna() { return this.coluna;}

    /**
     * Verifica se a posição está dentro dos limites do tabuleiro.
     *
     * @return {@code true} se linha e coluna estão entre 0 e 7
     */
    public boolean isValida()
    {
        return
        this.linha >= 0 && this.linha <= 7 &&
        this.coluna >= 0 && this.coluna <= 7;
    }

    @Override
    public int hashCode() {
        return 8 * this.linha + this.coluna;
    }

    /**
     * Compara esta posição com outro objeto pela igualdade de linha e coluna.
     *
     * @param obj objeto a comparar
     * @return {@code true} se {@code obj} é uma {@code Posicao} com mesma linha e coluna
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Posicao)) return false;
        Posicao outra = (Posicao) obj;
        return this.linha == outra.linha && this.coluna == outra.coluna;
    }

}