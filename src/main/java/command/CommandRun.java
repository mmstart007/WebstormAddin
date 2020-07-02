package command;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import ui.AddinUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

public class CommandRun implements command{
    // = "C:\\Program Files (x86)\\SourceGear\\VaultPro Client\\vault.exe ";
    public Runtime runtime = Runtime.getRuntime();
    public Process process;
    public boolean blStatus;

//    String strVaultPath = AddinUI.strVault;


    @Override
    public boolean Add(String strRepositoryFolder, String strLocalPath, String strRepository) {
        try {
            process = runtime.exec(AddinUI.strVault + " ADD"  + " -commit " + strRepositoryFolder + " " +  strLocalPath + " -repository " + strRepository);

            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    public boolean RememberLogin(String strHost, String strUser, String strPass, String strRepos) {

        try {
            process = runtime.exec(AddinUI.strVault + " rememberlogin" + " -host " + strHost + " -user " + strUser + " -password " + strPass + " -repository " + strRepos);

            blStatus = this.RunCommand(process);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return blStatus;
    }


    @Override
    public boolean Connection(String strHost, String strUser, String strPass) {
        try {
            process = runtime.exec(AddinUI.strVault + " LISTREPOSITORIES  " + " -host " + strHost + " -user " + strUser + " -password " + strPass);
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }


    @Override
    public boolean AddRepository(String strRepositoryName) {
        try {
            process = runtime.exec(AddinUI.strVault + "ADDREPOSITORY" + " " + strRepositoryName);

            blStatus = this.RunCommand(process);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean AddUser(String strUsername, String strPassword, String strEmailaddress) {
        try {
            process = runtime.exec(AddinUI.strVault + "ADDUSER" + " " + strUsername + " " + strPassword + " " + strEmailaddress);
            blStatus = this.RunCommand(process);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean Batch(String strFileName) {
        return false;
    }

    @Override
    public boolean Blame(String strReposPath, float linenumber) {
        return false;
    }

    @Override
    public boolean Branch(String strComment, String strCommit, String strRepositoryFolder, String strToRepositoryFolder) {
        return false;
    }

    @Override
    public boolean CheckIn(String strCheckInfile, String strComment, String strRepositoryPath) {
        try {
            process = runtime.exec(AddinUI.strVault + " CHECKIN " + " " + strCheckInfile + " " + "-comment " + strComment + " " + "-repository" + " " + strRepositoryPath);

            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean CheckIn(String[] strCheckInFiles, String strComment, String strRepositoryPath) {
        try {
            for (int i = 0; i < strCheckInFiles.length; i++)
            {
                process = runtime.exec(AddinUI.strVault + " CHECKIN " + " " + strCheckInFiles[i] + " " + "-comment " + strComment + " " + "-repository" + strRepositoryPath);

                blStatus = this.RunCommand(process);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean CheckOut(String strCheckOutFile, String strMerge, String strSetFileTime, String strRepositoryPath) {
        try {
            process = runtime.exec(AddinUI.strVault + " CHECKOUT " + strCheckOutFile + " -merge " + strMerge + " -setfiletime " + strSetFileTime + " " + "-repository " + " "+ strRepositoryPath);
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean CheckOut(String[] strCheckOutFiles, String strMerge, String strSetFileTime, String strRepositoryPath) {
        try {
            for (int i = 0; i < strCheckOutFiles.length; i++)
            {
                process = runtime.exec(AddinUI.strVault + " CHECKOUT " + strCheckOutFiles[i] + " -merge " + strMerge + " -setfiletime " + strSetFileTime + " " + "-repository " + strRepositoryPath);
                blStatus = this.RunCommand(process);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean Cloak(String strRepositoryFolder) {
        try {
            process = runtime.exec(AddinUI.strVault + "CLOAK" + " " + strRepositoryFolder);

            blStatus = this.RunCommand(process);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean Commit(String[] strOptions, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean CopyLabel(String[] strOptions, String strRepositoryPath, String strSrclabelname, String strNewLabelName, float ftVersion_number, String path_of_source_label) {
        return false;
    }

    @Override
    public boolean CreateFolder(String[] strOptions, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean CreateHtmlHelp() {
        try {
            process = runtime.exec(AddinUI.strVault + "CREATEHTMLHELP");

            blStatus = this.RunCommand(process);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean Create_fca(String[] strOptions, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean Delete(String strFile, String[] strOptions, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean DeletLabel(String strFile, String strRepositoryPath, String strLabel_Name) {
        return false;
    }

    @Override
    public boolean Diff(String[] strOptions, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean FindInFils(String[] strOptions, String strSearchString, String[] strRepositoryPath_files, String strRepositoryPath_filen) {
        return false;
    }

    @Override
    public boolean FindFolder(String[] strOptions, String strSearchString, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean ForgetLogin() {
        try {
            process = runtime.exec(AddinUI.strVault + " FORGETLOGIN ");
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean Get(String[] strOptions, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean Getable(String[] strOptions, String strRepositoryPath, String strLabel, String strLabelPath) {
        return false;
    }

    @Override
    public boolean GetLabelDiffs() {
        try {
            process = runtime.exec(AddinUI.strVault + " GETLABELDIFFS ");
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean GetVersion(String[] strOptions, float flVersion, String strItem, String strDestination_folder) {
        return false;
    }

    @Override
    public boolean GetWildCard(String[] strOptions, String strRepositoryFolder, String strWildCard) {
        return false;
    }

    @Override
    public boolean Help(String strCommand) {
        try {
            process = runtime.exec(AddinUI.strVault + " HELP " + " " + strCommand);
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean HelpHtml(String strCommand) {
        try {
            process = runtime.exec(AddinUI.strVault + " HELPHTML " + " " + strCommand);
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean History(String[] strOptions, String strRepositorypath) {
        return false;
    }

    @Override
    public boolean Label(String strOptions, String strRepositoryPath, String strLabelName, String version) {
        try {
            if (strOptions.isEmpty()){
                process = runtime.exec(AddinUI.strVault + " LABEL " + strRepositoryPath + " " + strLabelName + " " + version);
            }else {
                process = runtime.exec(AddinUI.strVault + " LABEL " + " -comment " + strRepositoryPath + " " + strLabelName + " " + version);
            }
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean ListChangeSet(String strOption) {
        try {
            if (strOption.isEmpty()){
                process = runtime.exec(AddinUI.strVault + " LISTCHANGESET ");
            }else {
                process = runtime.exec(AddinUI.strVault + " LISTCHANGESET " + " -verbose ");
            }
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean ListFolder(String strNoRecursive, String strRepositoryFolder) {
        try {
            if (strNoRecursive.compareTo("norecursive") == 0) {
                process = runtime.exec(AddinUI.strVault + " LISTFOLDER " + strNoRecursive + " " + strRepositoryFolder);
            }else {
                process = runtime.exec(AddinUI.strVault + " LISTFOLDER " + " " + strRepositoryFolder);
            }
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean ListObjectProperties(String strPath) {
        return false;
    }

    @Override
    public boolean ListProjects() {
        return false;
    }

    @Override
    public String[] ListRepositories() {
        String[] arrRepos = null;
        try {
            process = runtime.exec(AddinUI.strVault + " LISTREPOSITORIES ");
            arrRepos = this.RunCommandRepos(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrRepos;
    }

    @Override
    public String[] ListCheckOuts() {
        String[] arrCheckOuts = null;
        try {
            process = runtime.exec(AddinUI.strVault + " LISTCHECKOUTS ");
            arrCheckOuts = this.RunCommandCheckOuts(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrCheckOuts;
    }

    @Override
    public boolean ListUsers(String strOptions) {
        return false;
    }

    @Override
    public boolean ListWorkingFolders() {
        try {
            process = runtime.exec(AddinUI.strVault + " LISTWORKINGFOLDERS ");
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }


    @Override
    public boolean Move(String[] strOptions, String strRepositoryPath, String strDestRepositoryFolder) {
        return false;
    }

    @Override
    public boolean Obliterate(String strYesiamsure, String strRepositoryPath) {
        try {
            if (!strYesiamsure.isEmpty()){
                process = runtime.exec(AddinUI.strVault + " OBLITERATE " + "-yesiamsure " + strRepositoryPath);
            } else {
                process = runtime.exec(AddinUI.strVault + " OBLITERATE "  + strRepositoryPath);
            }
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean Pin(String[] strOptions, String strRepositoryPath, float version) {
        return false;
    }

    @Override
    public boolean Rename(String[] strOptions, String strRepositoryPath, String strDestRepositoryPath) {
        return false;
    }

    @Override
    public boolean RenameLabel(String[] strOptions, String strRepositorypath, String strOld_label_name, String strNew_label_name) {
        return false;
    }


    @Override
    public boolean SetWorkingFolder(String strOptions, String strRepositoryFolder, String strLocalFolder) {
        try {
            if (strOptions.compareTo("forcesubfolderstoinherit") == 0){
                process = runtime.exec(AddinUI.strVault + " SETWORKINGFOLDER " + strOptions + " " + strRepositoryFolder + " " + strLocalFolder);
            }else {
                process = runtime.exec(AddinUI.strVault + " SETWORKINGFOLDER " + " " + strRepositoryFolder + " " + strLocalFolder);
            }
            blStatus = this.RunCommand(process);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean Share(String[] strOptions, String strRepositoryPath, String strDestRepositoryFolder) {
        return false;
    }

    @Override
    public boolean Uncloak(String strRepositoryFolder) {
        try {
            process = runtime.exec(AddinUI.strVault + " UNCLOAK " + strRepositoryFolder);
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean UnDoChangeSetItem(String strChangeSetItem) {
        try {
            process = runtime.exec(AddinUI.strVault + " UNDOCHANGESETITEM " + strChangeSetItem);
            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean UnDoCheckOut(String[] strOptions, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean Unpin(String[] strOptions, String strRepositoryPath) {
        return false;
    }

    @Override
    public boolean Unsetworkingfolder(String strOptions, String strRepositoryFolder) {
        try {if(strOptions.compareTo("recursiveunset") == 0)
              {
                process = runtime.exec(AddinUI.strVault + " UNSETWORKINGFOLDER " + "-recursiveunset" + " " + strRepositoryFolder);
              }else {
                process = runtime.exec(AddinUI.strVault + " UNSETWORKINGFOLDER " + " " + strRepositoryFolder);
                }

            blStatus = this.RunCommand(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blStatus;
    }

    @Override
    public boolean VersionHistory(String[] strOptions, String strRepositoryFolder) {
        return false;
    }



    public boolean RunCommand(Process process) {
        String strOut;
        String strStatus;

        StringBuffer stringBuffer = new StringBuffer();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        int numCharsRead = 0;
        char[] charArray = new char[1024];
        while (true) {
            try {
                if (!((numCharsRead = br.read(charArray)) > 0)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuffer.append(charArray, 0, numCharsRead);
        }
        strOut = stringBuffer.toString();

        Document doc = Jsoup.parse(strOut,"", Parser.xmlParser());
        strStatus = doc.select("success").text();

        if (strStatus.compareTo("True") == 0)
        {
            return true;
        }else
            return false;
    }

    public String[] RunCommandRepos(Process process){

        String strOut;

        StringBuffer stringBuffer = new StringBuffer();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        int numCharsRead = 0;
        char[] charArray = new char[1024];
        while (true) {
            try {
                if (!((numCharsRead = br.read(charArray)) > 0)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuffer.append(charArray, 0, numCharsRead);
        }
        strOut = stringBuffer.toString();

        Document doc = Jsoup.parse(strOut,"", Parser.xmlParser());
        int nCount = doc.select("name").size();
        int i;
        String[] strStatus = new String[nCount];
        for (i = 0; i < nCount;i ++) {
            strStatus[i] = doc.select("name").get(i).text();
        }
        return strStatus;
    }

    public String[] RunCommandCheckOuts(Process process) {
        String strOut;

        StringBuffer stringBuffer = new StringBuffer();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        int numCharsRead = 0;
        char[] charArray = new char[1024];
        while (true) {
            try {
                if (!((numCharsRead = br.read(charArray)) > 0)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuffer.append(charArray, 0, numCharsRead);
        }
        strOut = stringBuffer.toString();

        Document doc = Jsoup.parse(strOut,"", Parser.xmlParser());
        int nCount = doc.select("localpath").size();
        int i;
        String[] strStatus = new String[nCount];
        for ( i = 0; i < nCount;i ++) {
            strStatus[i] = doc.select("localpath").get(i).text();
        }
        return strStatus;
    }
}
