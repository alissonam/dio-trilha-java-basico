import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IncrementadorValor extends MouseAdapter {
    private final CelulaSudoku celula;
    private final TabuleiroSudoku tabuleiro;

    public IncrementadorValor(CelulaSudoku celula, TabuleiroSudoku tabuleiro) {
        this.celula = celula;
        this.tabuleiro = tabuleiro;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!celula.isFixa()) {
            int atual = celula.getValor();
            int novo = atual % 9 + 1;
            celula.setValor(novo);
            tabuleiro.atualizarEstadoCelula(celula.getLinha(), celula.getColuna(), novo);
        }
    }
}