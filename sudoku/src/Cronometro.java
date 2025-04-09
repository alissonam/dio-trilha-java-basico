import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends JLabel {
    private int segundos = 0;
    private final Timer timer;

    public Cronometro() {
        setFont(new Font("Arial", Font.BOLD, 16));
        setHorizontalAlignment(SwingConstants.CENTER);
        atualizarTexto();

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                segundos++;
                SwingUtilities.invokeLater(Cronometro.this::atualizarTexto);
            }
        }, 1000, 1000);
    }

    private void atualizarTexto() {
        int minutos = segundos / 60;
        int seg = segundos % 60;
        setText(String.format("⏱ Tempo: %02d:%02d", minutos, seg));
    }

    public void resetar() {
        segundos = 0;
        atualizarTexto();
    }

    public void parar() {
        timer.cancel();
    }
}
