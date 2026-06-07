

public class Posicao {
    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    public int getLinha() { return this.linha;}
    public int getColuna() { return this.coluna;}

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Posicao)) return false;
        Posicao outra = (Posicao) obj;
        return this.linha == outra.linha && this.coluna == outra.coluna;
    }

}