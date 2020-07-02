package ui;

import command.CommandRun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepositoryUi {

    public static String strRepos;

    private Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    private boolean waitCursorIsShowing;

    public void createUi() {

        CommandRun cmr = new CommandRun();

        JFrame frame = new JFrame("Choose repository");

        JLabel lbRepos = new JLabel("Available Repositories : ");
        lbRepos.setBounds(100, 20, 150, 25);

        frame.setCursor(waitCursor);

        String[] strPath = cmr.ListRepositories();
        SpinnerModel value = new SpinnerListModel(strPath);
        JSpinner spRepos = new JSpinner(value);
        spRepos.setBounds(180, 50, 200, 25);

        frame.setCursor(defaultCursor);

        JButton btConnect = new JButton();
        btConnect.setText("OK");
        btConnect.setBounds(200, 100, 70, 25);

        JButton btCancel = new JButton();
        btCancel.setText("Cancel");
        btCancel.setBounds(300, 100, 70, 25);

        frame.add(lbRepos);
        frame.add(spRepos);
        frame.add(btConnect);
        frame.add(btCancel);

        frame.setLayout(null);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        btConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                strRepos = spRepos.getValue().toString();

                frame.setCursor(waitCursor);
                boolean blConnect = cmr.RememberLogin(AddinUI.strHost, AddinUI.strUser, AddinUI.strPass, strRepos);
                frame.setCursor(defaultCursor);

                if (blConnect == true)
                {
                    JOptionPane.showMessageDialog(frame, "User information was successfully archived.");
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "Repository connection failed");
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
