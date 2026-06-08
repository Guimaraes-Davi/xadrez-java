# Xadrez em Java

Implementação de um jogo de xadrez em Java puro, construído do zero como estudo aprofundado de Programação Orientada a Objetos. A lógica de regras é totalmente independente da camada de apresentação, o que permite trocar o terminal por interface gráfica sem alterar o núcleo do jogo.

## Stack

- Java — linguagem principal, sem frameworks na camada de regras
- Swing — interface gráfica (em desenvolvimento)
- Git / GitHub — versionamento com Conventional Commits

## Arquitetura

O projeto separa três responsabilidades: regras de movimento (cada peça calcula seus próprios movimentos válidos), estado do tabuleiro (posicionamento, captura e consulta de casas) e coordenação da partida (controle de turno e validação de jogadas).

A decisão central é o uso de uma classe abstrata `Peca` com o método abstrato `movimentosValidos`, implementado de forma distinta por cada peça concreta. Isso aplica polimorfismo a um problema real: o mesmo método produz comportamentos diferentes para Bispo, Torre, Cavalo e demais peças, sem condicionais espalhadas pelo código.

A camada de regras não conhece a interface. O cálculo de movimentos, a validação e o estado do jogo funcionam de forma idêntica no terminal e na futura interface gráfica.

## Estrutura de classes

```
Posicao      Coordenada (linha, coluna) com validação e comparação
Peca         Classe abstrata: cor, posição e movimentosValidos (abstrato)
 ├── Rei
 ├── Rainha
 ├── Torre
 ├── Bispo
 ├── Cavalo
 └── Peao
Tabuleiro    Grade 8x8, inicialização, consulta e movimentação de peças
Partida      Turno atual, validação de jogada e alternância de jogadores
Main         Ponto de entrada e laço de jogo
```

Relações: `Peca` tem uma `Posicao` (composição); cada peça concreta é uma `Peca` (herança); `Tabuleiro` contém as peças.

## Funcionalidades

Implementado:

- Tabuleiro 8x8 com posicionamento inicial completo das 32 peças
- Movimentos válidos para as seis peças, incluindo regras específicas do peão (avanço duplo na primeira jogada e captura na diagonal)
- Detecção de peças aliadas e inimigas no cálculo de caminho
- Captura por sobreposição
- Controle de turno e bloqueio de jogadas fora de vez
- Validação de movimento contra as regras de cada peça

## Roadmap

- Interface gráfica com Swing
- Detecção de xeque e xeque-mate
- Oponente controlado por IA com níveis de dificuldade (algoritmo minimax)
- Multiplayer entre dois jogadores
- Deploy para partidas online
- Sistema de ranking

## Como executar

Requer JDK instalado.

```bash
git clone https://github.com/Guimaraes-Davi/xadrez-java.git
cd xadrez-java
javac *.java
java Main
```

Na versão de terminal, as jogadas são informadas por coordenadas de linha e coluna (0 a 7), pedidas em sequência para origem e destino.

## Autor

Davi Guimarães da Costa

