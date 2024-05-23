import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton detailsButton, editButton, deleteButton, finishButton;

    public ButtonPanel(JTable table, PlanTableModel model) {
        detailsButton = new JButton("詳細");
        editButton = new JButton("編輯");
        deleteButton = new JButton("刪除");
        finishButton = new JButton("已完成");

        ButtonListener buttonListener = new ButtonListener();
        detailsButton.addActionListener(buttonListener);
        editButton.addActionListener(buttonListener);
        deleteButton.addActionListener(buttonListener);
        finishButton.addActionListener(buttonListener);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0 && confirmAction("您已完成此計畫了嗎？")) {
                    System.out.println("完成計畫:" + row);
                    // 新增至 "已完成" List當中

                }
            }
        });


        add(detailsButton);
        add(editButton);
        add(deleteButton);
        add(finishButton);
    }


//    public void actionPerformed(ActionEvent e){
//        if(e.getSource() == detailsButton){
//            int row = table.getSelectedRow();
//            if (row >= 0 && confirmAction("確定要刪除嗎？"))
//                model.removeRow(row);
//        }
//        if(e.getSource() == deleteButton){
//
//        }
//    }

    private boolean confirmAction(String text) {
        return JOptionPane.showConfirmDialog(this, text, "確認", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == deleteButton) {
//                int row = table.getSelectedRow();
                System.out.println("Delete Button");
                if (confirmAction("確定要刪除嗎？")) {
//                    model.removeRow(row);
                    System.out.println("Deleted");
                }
            }
            if (e.getSource() == editButton) {
                System.out.println("EditButton");
            }
            if (e.getSource() == detailsButton) {
                System.out.println("DetailsButton");
            }
            if (e.getSource() == finishButton) {
                System.out.println("FinishButton");
            }
        }
    }
}
