@echo off

setlocal ENABLEDELAYEDEXPANSION

set BASE_DIRECTORY=%~dp0

if not exist "%BASE_DIRECTORY%lib\vault.jar" goto missingCoreJar

set SG_CLASSPATH=.
for %%i in ("%BASE_DIRECTORY%lib\*.jar") do set SG_CLASSPATH=!SG_CLASSPATH!;"%%i"

setlocal DISABLEDELAYEDEXPANSION

java -Xmx1024M -cp %SG_CLASSPATH% "-Dlog4j.configuration=%BASE_DIRECTORY%log4j.properties" "-Dsourcegear.log.location=%BASE_DIRECTORY%_logs\VaultProJavaCLC.log" "-Djava.library.path=%BASE_DIRECTORY%native\win32\x86" VaultCmdLineClient.VaultCmdLineClient %*

set RETURN_VALUE=%errorlevel%
goto end

:missingCoreJar
echo Unable to find a required JAR: %BASE_DIRECTORY%lib\vault.jar does not exist
set RETURN_VALUE=1

:end
if "%SG_NON_INTERACTIVE%" NEQ "" exit %RETURN_VALUE%
exit /B %RETURN_VALUE%
