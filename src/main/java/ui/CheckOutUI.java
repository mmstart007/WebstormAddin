package ui;

import com.intellij.openapi.vfs.VirtualFile;
import command.CommandRun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOutUI {

    public String strMerge;
    public String strSetFileTime;

    private Cursor waitCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) ;
    private Cursor defaultCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

    public void CreatUI(VirtualFile file,String strProjectFilePath) {
        JFrame frame = new JFrame("Check Out");

        JLabel lbOption = new JLabel("File Options");
        lbOption.setBounds(10, 10, 100, 25);

        CheckIconProvider cip = new CheckIconProvider();

        JLabel lbFileTime = new JLabel("Set File Time:");
        lbFileTime.setBounds(40, 40, 100, 25);

        String strFileTime[] = {"current", "modification", "checkin"};
        JComboBox cbFileTime = new JComboBox(strFileTime);
        cbFileTime.setBounds(180, 40, 250, 25);

        JLabel lbModified = new JLabel("Modified Local File:");
        lbModified.setBounds(40, 90, 120, 25);

        String strModifiedLocalFile[] = {"automatic", "later", "overwrite"};
        JComboBox cbModified = new JComboBox(strModifiedLocalFile);
        cbModified.setBounds(180, 90, 250, 25);

        JButton btCheckOut = new JButton();
        btCheckOut.setText("OK");
        btCheckOut.setBounds(200, 140, 100, 25);

        JButton btCancel = new JButton();
        btCancel.setText("Cancel");
        btCancel.setBounds(330, 140, 100, 25);

        frame.add(lbOption);
        frame.add(lbFileTime);
        frame.add(cbFileTime);
        frame.add(lbModified);
        frame.add(cbModified);
        frame.add(btCheckOut);
        frame.add(btCancel);

        frame.setLayout(null);
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        CommandRun cmr = new CommandRun();
        CheckIconProvider checkIconProvider = new CheckIconProvider();

        btCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strMerge = cbModified.getSelectedItem().toString();
                strSetFileTime = cbFileTime.getSelectedItem().toString();

                frame.setCursor(waitCursor);

                boolean blCheckOut = cmr.CheckOut(strProjectFilePath, strMerge,strSetFileTime,RepositoryUi.strRepos);

                frame.setCursor(defaultCursor);

                if (blCheckOut == true)
                {
                    JOptionPane.showMessageDialog(frame, "File checkout success");
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "File checkout failure");
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
