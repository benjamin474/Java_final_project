import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PlanManagerMainPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("計畫表");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        PlanPanel panel = new PlanPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}