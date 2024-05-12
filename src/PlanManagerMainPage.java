import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PlanManagerMainPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("計畫管理器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);




        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        //Create table
        JTable table = new JTable(model);

        //add sorter and its rules
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        sorter.setSortable(2, true);
        sorter.toggleSortOrder(2);

        // set scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);


        frame.setVisible(true);
    }
}