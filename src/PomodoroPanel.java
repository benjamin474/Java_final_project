import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class PomodoroPanel extends JPanel {
    private static final int WORK_TIME = 25 * 60; // 25 分鐘
    private static final int BREAK_TIME = 5 * 60; // 5 分鐘

    private JLabel timerLabel;
    private JButton startButton;
    private JButton resetButton;
    private Timer timer;
    private int timeLeft;
    private boolean isWorkTime;

    public PomodoroPanel() {
        setLayout(new BorderLayout());

        timerLabel = new JLabel("25:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Serif", Font.BOLD, 48));
        add(timerLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("開始");
        resetButton = new JButton("重置");
        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new StartButtonListener());
        resetButton.addActionListener(new ResetButtonListener());

        resetTimer();
    }

    private void resetTimer() {
        if (timer != null) {
            timer.cancel();
        }
        timeLeft = WORK_TIME;
        isWorkTime = true;
        updateTimerLabel();
        startButton.setEnabled(true);
    }

    private void updateTimerLabel() {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startButton.setEnabled(false);
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (timeLeft > 0) {
                        timeLeft--;
                        updateTimerLabel();
                    } else {
                        timer.cancel();
                        if (isWorkTime) {
                            timeLeft = BREAK_TIME;
                            isWorkTime = false;
                            JOptionPane.showMessageDialog(null, "工作時間結束，休息一下吧！");
                        } else {
                            timeLeft = WORK_TIME;
                            isWorkTime = true;
                            JOptionPane.showMessageDialog(null, "休息結束，開始新的工作吧！");
                        }
                        updateTimerLabel();
                        startButton.setEnabled(true);
                    }
                }
            }, 0, 1000);
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetTimer();
        }
    }
}
