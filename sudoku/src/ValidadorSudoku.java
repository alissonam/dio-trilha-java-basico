public class ValidadorSudoku {

    public static boolean podeInserir(int[][] tab, int linha, int col, int num) {
        return !linhaContem(tab, linha, num) &&
                !colunaContem(tab, col, num) &&
                !blocoContem(tab, linha - linha % 3, col - col % 3, num);
    }

    private static boolean linhaContem(int[][] tab, int linha, int num) {
        for (int i = 0; i < 9; i++) {
            if (tab[linha][i] == num)
                return true;
        }
        return false;
    }

    private static boolean colunaContem(int[][] tab, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (tab[i][col] == num)
                return true;
        }
        return false;
    }

    private static boolean blocoContem(int[][] tab, int linhaIni, int colIni, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[linhaIni + i][colIni + j] == num)
                    return true;
            }
        }
        return false;
    }
}
