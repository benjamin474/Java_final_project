import javax.swing.*;
import java.awt.*;
public class PlanPanel extends JPanel {
    private JTable table;
    private PlanTableModel model;


    public PlanPanel(){
        setLayout(new BorderLayout());

        // Define the type of table
        String[] columnNames = {"計畫名稱", "計畫內容", "截止日期"};
        // Add some data to check
        Object[][] data = {
                {"Plan A", "Content A", "2024-5-19"},
                {"Plan B", "Content B", "2024-5-20"}
        };
        model = new PlanTableModel(data, columnNames);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);

        add(new ButtonPanel(table,model),BorderLayout.SOUTH);
    }

    public void addPlan(String planName, String planContent, String deadline){

    }



    // Add some other ways to manage data
}
