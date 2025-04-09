import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CelulaSudoku extends JTextField {
    private final boolean fixa;
    private int linha, coluna;

    public CelulaSudoku(int valor, boolean fixa) {
        super(valor == 0 ? "" : String.valueOf(valor));
        this.fixa = fixa;

        setHorizontalAlignment(JTextField.CENTER);
        setFont(new Font("Arial", Font.BOLD, 20));
        setOpaque(true);
        setBackground(fixa ? new Color(220, 220, 220) : Color.WHITE);
        setEditable(false);
        setForeground(fixa ? Color.BLACK : new Color(50, 50, 200));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!fixa) {
                    int atual = getValor();
                    int proximo = atual == 9 ? 1 : atual + 1;
                    setText(String.valueOf(proximo));
                    TabuleiroSudoku.getInstancia().atualizarEstadoCelula(linha, coluna, proximo);
                }
            }
        });
    }

    public boolean isFixa() {
        return fixa;
    }

    public int getValor() {
        String txt = getText().trim();
        try {
            return Integer.parseInt(txt);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setValor(int valor) {
        setText(valor == 0 ? "" : String.valueOf(valor));
    }

    public void marcarErro() {
        if (!fixa)
            setBackground(new Color(255, 150, 150));
    }

    public void marcarAcerto() {
        if (!fixa)
            setBackground(new Color(150, 255, 150));
    }

    public void limparErro() {
        if (!fixa)
            setBackground(Color.WHITE);
    }

    public void setPosicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}
