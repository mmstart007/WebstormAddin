import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import command.CommandRun;
import ui.CheckInUI;

public class CheckIn extends AnAction {

    CommandRun CMR = new CommandRun();

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        VirtualFile file = (VirtualFile) e.getDataContext().getData(DataConstants.VIRTUAL_FILE);
        String  strProjectFilePath = file.getPath();
        String strFilePath = strProjectFilePath.replace('/', '\\');

        CheckInUI CiUi = new CheckInUI();
        CiUi.CreatUI(strFilePath);
    }
}
