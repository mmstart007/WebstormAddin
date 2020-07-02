*************************************************
* Using the Vault Java Command Line Client *
*************************************************

GETTING STARTED

On Windows
==========

1. Unzip the contents of the archive in a location other than Program Files.

2. Start up a command line. (start > run > cmd)

3. Type “ java” and hit enter. If it returns information about Java usage and options, your machine is ready to run the Java CLC. Most java installations are in the system path, so this step generally works.

4. From a command prompt, cd to the directory where you unzipped the Vault Java CLC files.

5. Type “vault help” if you are using Vault Standard or   “vaultpro help” if you are using Vault Professional

6. For help with a specific command, run 'vault HELP commandname' or 'vaultpro HELP commandname'

7. Command Examples:

   a. ADD

   i. vault ADD –host myservername –user myuser –password mypassword –repository “Initial Repository” $/Folder1 “C:\Users\Me\Documents\Document1.txt”
   ii. vaultpro  ADD –host myservername –user myuser –password mypassword –repository “Initial Repository” $/Folder1 “C:\Users\Me\Documents\Document1.txt”

   b. SETWORKINGFOLDER

   i. vault SETWORKINGFOLDER –host myservername –user myuser –password mypassword –repository “Initial Repository” $/Folder1 “C:\Users\Me\Documents”
   ii. vaultpro SETWORKINGFOLDER  –host myservername –user myuser –password mypassword –repository “Initial Repository” $/Folder1 “C:\Users\Me\Documents”
   
8. If you prefer to run the command from the Vault directory, then put the CLC directory on the PATH variable.

See http://windows7tips.com/environment-variables-windows-vista-7.html  or http://vlaurie.com/computers2/Articles/environment.htm

On LINUX
========

1) Extract to a directory
2) Change the permissions on vault to be executable using chmod.
3) Go into the VaultJavaCLC directory and type java.  If you receive a response, then java is working.
4) Type ./vault help to receive a list of commands.  If that responds, then you can continue forward with same command examples as above.

Vault HELP
==========

--- For usage details of these commands, go to http://download.sourcegear.com/misc/vault/help/client/clc.htm.
--- For examples see: http://support.sourcegear.com/viewtopic.php?f=13&t=15235

usage: vault commandname [options] [parameters]
usage: vaultpro commandname [options] [parameters]

This is a list of possible commands:
  ADD                   Add files or folders to the repository.
  ADDREPOSITORY         Add a new repository to the server.
  ADDUSER               Add a new user to the server.
  BATCH                 Place the command line client in batch mode.
  BLAME                 Determine the user that modified a given line.
  BRANCH                Create a branch for a repository folder.
  CHECKIN               Commit items in the pending changeset.
  CHECKOUT              Checkout files from the repository.
  CLOAK                 Cloak repository folders.
  COMMIT                Commit items in the pending changeset.
  CREATEFOLDER          Create a new folder in the repository.
  DELETE                Delete files or folders from the repository.
  DELETELABEL           Delete a label that was applied to a file or folder.
  DIFF                  Diff a working file or folder.
  FORGETLOGIN           Remove locally stored login information.
  GET                   Retrieve files or folders from the repository.
  GETLABEL              Retrieve files or folders specified by label.
  GETLABELDIFFS         This command has been deprecated.  Use HISTORY instead.
  GETVERSION            Retrieve files or folder at a specified version.
  GETWILDCARD           Retrieve files whose names match a wildcard.
  HELP                  Displays this page or help for a specific command.
  HELPHTML              Displays this page or help for a specific command in HTML format.
  HISTORY               Shows history for an item in the repository.
  LABEL                 Applies labelname to version of repositorypath.
  LISTCHANGESET         Show the contents of the pending changeset.
  LISTCHECKOUTS         Show all check out items for the current repository.
  LISTFOLDER            Show contents and status of a repository folder.
  LISTOBJECTPROPERTIES  Show properties of a file or folder on the server.
  LISTPROJECTS          List available work item tracking projects on the server (Fortress only).
  LISTREPOSITORIES      List available repositories on the server.
  LISTUSERS             List all users on the server.
  LISTWORKINGFOLDERS    List local working folder associations.
  MOVE                  Move a file or folder to a different folder.
  OBLITERATE            Obliterate a deleted item.
  PIN                   Pin a file or folder.
  REMEMBERLOGIN         Store authentication information.
  RENAME                Rename a file or folder.
  RENAMELABEL           Rename a file or folder label.
  SETWORKINGFOLDER      Set a working folder association.
  SHARE                 Share a file or folder into a different folder.
  UNCLOAK               Uncloak a folder.
  UNDOCHANGESETITEM     Remove an item from the change set.
  UNDOCHECKOUT          Undo checkout (revert changes).
  UNPIN                 Unpin a file or folder.
  UNSETWORKINGFOLDER    Remove a working folder association.
  VERSIONHISTORY        Shows version history for a folder in the repository.

For help with a specific command, run 'vaultpro HELP commandname' or 'vault HELP commandname'
