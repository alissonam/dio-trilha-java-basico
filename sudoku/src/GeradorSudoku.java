import java.util.Random;

public class GeradorSudoku {
    private static final int TAM = 9;

    public static int[][] gerar(Dificuldade dificuldade) {
        int[][] tabuleiro = new int[TAM][TAM];
        preencherDiagonal(tabuleiro);
        resolver(tabuleiro);
        removerCelulas(tabuleiro, dificuldade.getCelulasVazias());
        return tabuleiro;
    }

    private static void preencherDiagonal(int[][] tabuleiro) {
        for (int i = 0; i < TAM; i += 3) {
            preencherBloco(tabuleiro, i, i);
        }
    }

    private static void preencherBloco(int[][] tab, int linha, int col) {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = rand.nextInt(9) + 1;
                } while (!ValidadorSudoku.podeInserir(tab, linha + i, col + j, num));
                tab[linha + i][col + j] = num;
            }
        }
    }

    private static boolean resolver(int[][] tab) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (tab[i][j] == 0) {
                    for (int num = 1; num <= TAM; num++) {
                        if (ValidadorSudoku.podeInserir(tab, i, j, num)) {
                            tab[i][j] = num;
                            if (resolver(tab))
                                return true;
                            tab[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void removerCelulas(int[][] tab, int qtd) {
        Random rand = new Random();
        while (qtd > 0) {
            int i = rand.nextInt(TAM);
            int j = rand.nextInt(TAM);
            if (tab[i][j] != 0) {
                tab[i][j] = 0;
                qtd--;
            }
        }
    }
}
