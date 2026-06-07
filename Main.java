import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        Partida jogo = new Partida();
        
        while (true) {
            
            System.out.print("Linha origem ");
            int linhaOrigem = scanner.nextInt();
            System.out.println("Coluna origem");
            int colunaOrigem = scanner.nextInt();
            
            Posicao casaOrigem = new Posicao(linhaOrigem, colunaOrigem);
            
            System.out.print("Linha destino ");
            int linhaDestino = scanner.nextInt();
            System.out.println("Coluna destino");
            int colunaDestino = scanner.nextInt();
            
            Posicao casaDestino = new Posicao(linhaDestino, colunaDestino);
            
            String turno = jogo.getTurno();
            
            jogo.jogar(casaOrigem, casaDestino);

            // precisa verificar se o rei foi capturado para dar fim a partida
            // isso sem verificar cheque mate


        }
    }
}