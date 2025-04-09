import javax.swing.*;
import java.awt.*;

public class TabuleiroSudoku extends JPanel {
    private static TabuleiroSudoku instancia;
    private final CelulaSudoku[][] celulas = new CelulaSudoku[9][9];
    private final int[][] estado = new int[9][9];
    private final int[][] solucao;

    public TabuleiroSudoku(int[][] tabuleiro, int[][] solucao) {
        instancia = this;
        this.solucao = solucao;
        setLayout(new GridLayout(9, 9));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                CelulaSudoku celula = new CelulaSudoku(tabuleiro[i][j], tabuleiro[i][j] != 0);
                celula.setPosicao(i, j);
                celulas[i][j] = celula;
                estado[i][j] = tabuleiro[i][j];

                JPanel wrapper = new JPanel(new BorderLayout());
                wrapper.add(celula, BorderLayout.CENTER);

                int top = i % 3 == 0 ? 2 : 1;
                int left = j % 3 == 0 ? 2 : 1;
                int bottom = (i + 1) % 3 == 0 ? 2 : 1;
                int right = (j + 1) % 3 == 0 ? 2 : 1;
                wrapper.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));

                add(wrapper);
            }
        }
    }

    public static TabuleiroSudoku getInstancia() {
        return instancia;
    }

    public void atualizarEstadoCelula(int linha, int coluna, int valor) {
        estado[linha][coluna] = valor;
        limparCores();
        verificarPreenchidos();
    }

    public void limparCores() {
        for (CelulaSudoku[] linha : celulas) {
            for (CelulaSudoku cel : linha) {
                cel.limparErro();
            }
        }
    }

    public void verificarPreenchidos() {
        for (int i = 0; i < 9; i++) {
            if (estaCompleta(contarValores(estado[i]))) {
                pintarLinha(i);
            }
        }

        for (int j = 0; j < 9; j++) {
            int[] coluna = new int[9];
            for (int i = 0; i < 9; i++)
                coluna[i] = estado[i][j];
            if (estaCompleta(contarValores(coluna))) {
                pintarColuna(j);
            }
        }

        for (int bloco = 0; bloco < 9; bloco++) {
            int lin = (bloco / 3) * 3;
            int col = (bloco % 3) * 3;
            int[] blocoValores = new int[9];
            int idx = 0;
            for (int i = lin; i < lin + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    blocoValores[idx++] = estado[i][j];
                }
            }
            if (estaCompleta(contarValores(blocoValores))) {
                pintarBloco(lin, col);
            }
        }
    }

    private int[] contarValores(int[] valores) {
        int[] contagem = new int[10];
        for (int v : valores)
            contagem[v]++;
        return contagem;
    }

    private boolean estaCompleta(int[] contagem) {
        for (int k = 1; k <= 9; k++) {
            if (contagem[k] != 1)
                return false;
        }
        return true;
    }

    private void pintarLinha(int i) {
        for (int j = 0; j < 9; j++) {
            celulas[i][j].setBackground(new Color(180, 255, 200));
        }
    }

    private void pintarColuna(int j) {
        for (int i = 0; i < 9; i++) {
            celulas[i][j].setBackground(new Color(200, 255, 180));
        }
    }

    private void pintarBloco(int linhaIni, int colIni) {
        for (int i = linhaIni; i < linhaIni + 3; i++) {
            for (int j = colIni; j < colIni + 3; j++) {
                celulas[i][j].setBackground(new Color(220, 240, 255));
            }
        }
    }

    public void verificar() {
        limparCores();
        boolean houveErro = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int valor = celulas[i][j].getValor();
                if (valor != 0) {
                    if (valor == solucao[i][j]) {
                        celulas[i][j].marcarAcerto();
                    } else {
                        celulas[i][j].marcarErro();
                        houveErro = true;
                    }
                }
            }
        }
        verificarPreenchidos();
        if (!houveErro) {
            JOptionPane.showMessageDialog(this, "✅ Tudo certo! Sudoku resolvido!");
        }
    }

    public void resolver() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                celulas[i][j].setValor(solucao[i][j]);
                celulas[i][j].setBackground(new Color(220, 255, 255));
            }
        }
        verificarPreenchidos();
    }
}
