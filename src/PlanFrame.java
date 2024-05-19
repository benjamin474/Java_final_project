import javax.swing.*;
import java.awt.*;

public class PlanFrame extends JFrame {
    private JPanel panel;
    private PomodoroPanel pomodoroPanel;

    public PlanFrame(String name) {
        super(name);
        panel = new PlanPanel();
        pomodoroPanel = new PomodoroPanel();

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(pomodoroPanel, BorderLayout.EAST);
    }
}
