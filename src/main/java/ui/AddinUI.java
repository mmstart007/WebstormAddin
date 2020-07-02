package ui;

import com.twelvemonkeys.imageio.metadata.Directory;
import command.CommandRun;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.*;
import java.io.FileInputStream;

public class AddinUI {

    public static String strHost;
    public static String strUser;
    public static String strPass;
    public static String strVault;
    String strInfoPath;

    private Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);



    public void createUI() {

        strInfoPath = System.getProperty("user.home") + "\\info.txt";

        CommandRun cmr = new CommandRun();

        JFrame frame = new JFrame("Connect to Server");

        JLabel lbUser = new JLabel("Username : ");
        lbUser.setBounds(100, 50, 75, 25);

        JTextField tfUser = new JTextField();
        tfUser.setBounds(180, 50, 200, 25);

        JLabel lbPass = new JLabel("Password : ");
        lbPass.setBounds(100, 100, 75, 25);

        JPasswordField psPass = new JPasswordField();
        psPass.setBounds(180, 100, 200, 25);

        JLabel lbHost = new JLabel("Vault Server : ");
        lbHost.setBounds(100, 150, 75, 25);

        JTextField tfHost = new JTextField();
        tfHost.setBounds(180, 150, 200, 25);

        JButton btVault = new JButton("VaultClient path");
        btVault.setBounds(50,200, 120, 25);

        JTextField tfVaultPath = new JTextField();
        tfVaultPath.setBounds(180, 200, 200, 25);

        JCheckBox checkBox = new JCheckBox("Remember username & server");
        checkBox.setBounds(95, 250, 280, 25);


        String strInfo = "";
        try {
            FileInputStream fin = new FileInputStream(strInfoPath);

            int i = 0;
            while ((i = fin.read()) != -1) {
                char ch = (char)i;
                strInfo += String.valueOf(ch);
            }
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] strInformation = strInfo.split("=");
        int n = strInformation.length;

        if (n == 1)
        {
            tfUser.setText("");
            tfHost.setText("");
            psPass.setText("");
            tfVaultPath.setText("");
        } else
        {
            tfUser.setText(strInformation[1]);
            tfHost.setText(strInformation[0]);
            psPass.setText("");
            tfVaultPath.setText(strInformation[3]);
        }

        JButton btConnect = new JButton();
        btConnect.setText("OK");
        btConnect.setBounds(200, 300, 70, 25);

        JButton btCancel = new JButton();
        btCancel.setText("Cancel");
        btCancel.setBounds(300, 300, 70, 25);

        frame.add(lbHost);
        frame.add(tfHost);
        frame.add(lbUser);
        frame.add(tfUser);
        frame.add(lbPass);
        frame.add(psPass);
        frame.add(btVault);
        frame.add(tfVaultPath);
        frame.add(btConnect);
        frame.add(btCancel);
        frame.add(checkBox);

        frame.setLayout(null);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        btVault.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
//                chooser.setCurrentDirectory();
                chooser.setDialogTitle("choose title");
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String str = chooser.getSelectedFile().toString();
                    tfVaultPath.setText(str);
                }
            }
        });



        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strHost = tfHost.getText();
                strUser = tfUser.getText();
                strPass = psPass.getText();
                strVault = tfVaultPath.getText();

                try {

                    FileOutputStream fout = new FileOutputStream(strInfoPath);

                    String strUserInfo = strHost + "=" + strUser + "=" + strPass + "=" + strVault;

                    byte b[] = strUserInfo.getBytes();

                    fout.write(b);
                    fout.close();

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        btConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                strHost = tfHost.getText();
                strUser = tfUser.getText();
                strPass = psPass.getText();
                strVault = tfVaultPath.getText();

                frame.setCursor(waitCursor);
                boolean blConnect = cmr.Connection(strHost, strUser, strPass);
                frame.setCursor(defaultCursor);

                if (blConnect == true)
                    {
                        JOptionPane.showMessageDialog(frame, "connection was successful");
                        frame.setVisible(false);

                        frame.setCursor(waitCursor);

                        RepositoryUi ru = new RepositoryUi();
                        ru.createUi();

                        frame.setCursor(defaultCursor);
                    } else {
                        JOptionPane.showMessageDialog(frame, "connection failed");
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
