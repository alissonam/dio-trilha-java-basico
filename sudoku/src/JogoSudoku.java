import javax.swing.*;
import java.awt.*;

public class JogoSudoku {
    private static JFrame frame;
    private static JPanel painelPrincipal;
    private static Cronometro cronometro;
    private static TabuleiroSudoku tabuleiroSudoku;
    private static JPanel painelBotoes;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Sudoku");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(550, 650);
            frame.setLocationRelativeTo(null);

            painelPrincipal = new JPanel();
            painelPrincipal.setLayout(new BorderLayout(10, 10));

            JPanel topo = new JPanel(new BorderLayout());
            JPanel menu = criarMenuDificuldade();
            cronometro = new Cronometro();

            topo.add(menu, BorderLayout.WEST);
            topo.add(cronometro, BorderLayout.EAST);
            painelPrincipal.add(topo, BorderLayout.NORTH);

            painelBotoes = criarPainelBotoes();
            painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

            iniciarJogo(Dificuldade.FACIL);

            frame.setContentPane(painelPrincipal);
            frame.setVisible(true);
        });
    }

    private static JPanel criarMenuDificuldade() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JLabel label = new JLabel("Dificuldade:");
        JComboBox<Dificuldade> combo = new JComboBox<>(Dificuldade.values());
        combo.setSelectedItem(Dificuldade.FACIL);

        JButton novo = new JButton("Novo Jogo");
        novo.addActionListener(e -> iniciarJogo((Dificuldade) combo.getSelectedItem()));

        painel.add(label);
        painel.add(combo);
        painel.add(novo);

        return painel;
    }

    private static JPanel criarPainelBotoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JButton verificar = new JButton("Verificar");
        verificar.addActionListener(e -> TabuleiroSudoku.getInstancia().verificar());

        JButton resolver = new JButton("Resolver");
        resolver.addActionListener(e -> TabuleiroSudoku.getInstancia().resolver());

        painel.add(verificar);
        painel.add(resolver);

        return painel;
    }

    private static void iniciarJogo(Dificuldade dificuldade) {
        if (painelPrincipal.getComponentCount() > 2) {
            painelPrincipal.remove(1); // Remove tabuleiro antigo
        }

        int[][] tabuleiro = GeradorSudoku.gerar(dificuldade);
        int[][] copia = new int[9][9];

        for (int i = 0; i < 9; i++)
            System.arraycopy(tabuleiro[i], 0, copia[i], 0, 9);

        resolver(copia);

        tabuleiroSudoku = new TabuleiroSudoku(tabuleiro, copia);
        painelPrincipal.add(tabuleiroSudoku, BorderLayout.CENTER);

        painelPrincipal.revalidate();
        painelPrincipal.repaint();
        cronometro.resetar();
    }

    private static boolean resolver(int[][] tab) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tab[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
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
}
