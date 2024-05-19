import javax.swing.*;

public class PlanFrame extends JFrame {
    JPanel panel;
    public PlanFrame(String name) {
        super(name);
        panel = new PlanPanel();
        add(panel);
    }


}
