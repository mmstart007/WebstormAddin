import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import command.CommandRun;

import javax.swing.*;
//import ui.CheckOutUI;

public class AddFile extends AnAction {

    public String strProjectPath;
    CommandRun CMR = new CommandRun();

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Project curretntProject = e.getProject();
        strProjectPath = curretntProject.getBasePath();
        boolean blConnect = CMR.Add("$", strProjectPath, "zDevTest");
        if (blConnect == true)
        {
            JOptionPane.showMessageDialog(null, "Additional success");
        }else {
            JOptionPane.showMessageDialog(null,"Additional failure");
        }
    }
}
