//package ui;
//
//import com.intellij.openapi.actionSystem.AnAction;
//import com.intellij.openapi.actionSystem.AnActionEvent;
//import com.intellij.openapi.project.Project;
//import command.CommandRun;
//
//public class SetWorking extends AnAction {
//
//    public String strProjectPath;
//    CommandRun CMR = new CommandRun();
//
//    @Override
//    public void actionPerformed(AnActionEvent e) {
//        // TODO: insert action logic here
//        Project curretntProject = e.getProject();
//        strProjectPath = curretntProject.getBasePath();
//        boolean blSetWork = CMR.SetWorkingFolder();
//    }
//}
