import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PlanManager {
    public static void main(String[] args) {
        JFrame frame = new JFrame("計畫管理器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // type of table
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("計畫名稱");
        model.addColumn("計畫內容");
        model.addColumn("截止日期");

        // add data
        model.addRow(new Object[]{"Plan A", "Content A", "2024-5-19"});
        model.addRow(new Object[]{"Plan B", "Content B", "2024-5-19"});

        //add sorter
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // set scroll pane
        JScrollPane scrollPane = new JScrollPane();
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}