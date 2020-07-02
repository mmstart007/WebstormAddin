import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import command.CommandRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ui.CheckOutUI;

import java.io.File;
import java.nio.charset.Charset;

public class CheckOut extends AnAction {

    CommandRun CMR = new CommandRun();
    public static VirtualFile file;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // TODO: insert action logic here

        file = (VirtualFile) e.getDataContext().getData(DataConstants.VIRTUAL_FILE);

        String  strProjectFilePath = file.getPath();

        String strFileName = file.getName();

        String str = strProjectFilePath.replace('/', '\\');

        CheckOutUI CoUi = new CheckOutUI();
        CoUi.CreatUI(file, str);
    }
}
