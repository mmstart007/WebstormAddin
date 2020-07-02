package command;

import org.bouncycastle.util.Strings;

public interface command {
    public boolean Add (String strRepositoryFolder, String  strLocalPath, String strRepository);

    public boolean RememberLogin (String strHost, String strUser, String strPassword, String strRepository);

    public boolean Connection(String strHost, String strUser, String strPassword);

    public boolean AddRepository (String strRepositoryName);

    public boolean AddUser (String strUsername, String strPassword, String strEmailaddress);

    public boolean Batch (String strFileName);

    public boolean Blame (String strReposPath, float linenumber);

    public boolean Branch (String strComment, String strCommit, String strRepositoryFolder, String strToRepositoryFolder);

    public boolean CheckIn (String strCheckInfile, String strComment, String strRepositoryPath);

    public boolean CheckIn (String[] strCheckInFiles, String strComment, String strRepositoryPath);

    public boolean CheckOut (String strCheckOutFile, String strMerge, String strSetFileTime, String strRepositoryPath);

    public boolean CheckOut (String[] strCheckOutFiles, String strMerge, String strSetFileTime, String strRepositoryPath);

    public boolean Cloak (String strRepositoryFolder);

    public boolean Commit (String[] strOptions, String strRepositoryPath);

    public boolean CopyLabel (String[] strOptions, String strRepositoryPath, String strSrclabelname, String strNewLabelName,
                              float ftVersion_number, String path_of_source_label);

    public boolean CreateFolder (String[] strOptions, String strRepositoryPath);

    public boolean CreateHtmlHelp ();

    public boolean Create_fca (String[] strOptions, String strRepositoryPath);

    public boolean Delete (String strFile, String[] strOptions, String strRepositoryPath);

    public boolean DeletLabel (String strFile, String strRepositoryPath, String strLabel_Name);

    public boolean Diff (String[] strOptions, String strRepositoryPath);

    public boolean FindInFils (String[] strOptions, String strSearchString, String[] strRepositoryPath_files, String strRepositoryPath_filen);

    public boolean FindFolder (String[] strOptions, String strSearchString, String strRepositoryPath);

    public boolean ForgetLogin ();

    public boolean Get (String[] strOptions, String strRepositoryPath);

    public boolean Getable(String[] strOptions, String strRepositoryPath, String strLabel, String strLabelPath);

    public boolean GetLabelDiffs();

    public boolean GetVersion(String[] strOptions,float flVersion, String strItem, String strDestination_folder);

    public boolean GetWildCard(String[] strOptions, String strRepositoryFolder, String strWildCard);

    public boolean Help (String strCommand);

    public boolean HelpHtml (String strCommand);

    public boolean History (String[] strOptions, String strRepositorypath);

    public boolean Label (String strOptions, String strRepositoryPath, String strLabelName, String version);

    public boolean ListChangeSet (String strOption);

    public String[] ListCheckOuts ();

    public boolean ListFolder (String strNoRecursive, String strRepositoryFolder);

    public boolean ListObjectProperties (String strPath);

    public boolean ListProjects();

    public String[] ListRepositories();

    public boolean ListUsers(String strOptions);

    public boolean ListWorkingFolders();

    public boolean Move (String[] strOptions, String strRepositoryPath, String strDestRepositoryFolder);

    public boolean Obliterate (String strYesiamsure, String strRepositoryPath);

    public boolean Pin (String[] strOptions, String strRepositoryPath, float version);

    public boolean Rename (String[] strOptions, String strRepositoryPath, String strDestRepositoryPath);

    public boolean RenameLabel (String[] strOptions, String strRepositorypath, String strOld_label_name, String strNew_label_name);

    public boolean SetWorkingFolder (String strOptions, String strRepositoryFolder, String strLocalFolder);

    public boolean Share (String[] strOptions, String strRepositoryPath, String strDestRepositoryFolder);

    public boolean Uncloak (String strRepositoryFolder);

    public boolean UnDoChangeSetItem (String strChangeSetItem);

    public boolean UnDoCheckOut (String[] strOptions, String strRepositoryPath);

    public boolean Unpin (String[] strOptions, String strRepositoryPath);

    public boolean Unsetworkingfolder (String strOptions, String strRepositoryFolder);

    public boolean VersionHistory (String[] strOptions, String strRepositoryFolder);


}
