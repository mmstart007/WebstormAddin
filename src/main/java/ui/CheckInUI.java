package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import command.CommandRun;

public class CheckInUI {

    public String strComment;

    private Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

    public void CreatUI(String strFilePath) {
        JFrame frame = new JFrame("Check In");

        JLabel lbOption = new JLabel("Change Set Comment:");
        lbOption.setBounds(20, 10, 150, 25);

        JTextArea taComment = new JTextArea();
        taComment.setBounds(16, 50, 450, 60);

        JButton btCheckIn = new JButton();
        btCheckIn.setText("OK");
        btCheckIn.setBounds(200, 140, 100, 25);

        JButton btCancel = new JButton();
        btCancel.setText("Cancel");
        btCancel.setBounds(330, 140, 100, 25);

        frame.add(lbOption);
        frame.add(taComment);
        frame.add(btCheckIn);
        frame.add(btCancel);

        frame.setLayout(null);
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        CommandRun cmr = new CommandRun();

        btCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strComment = taComment.getText();

                frame.setCursor(waitCursor);
                boolean blCheckIn = cmr.CheckIn(strFilePath, strComment,RepositoryUi.strRepos);
                frame.setCursor(defaultCursor);

                if (blCheckIn == true)
                {
                    JOptionPane.showMessageDialog(frame, "File checkin success");
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "File checkin failure");
                }
            }
        });

        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

}
