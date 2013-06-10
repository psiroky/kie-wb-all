@ECHO OFF

setLocal EnableDelayedExpansion
set mainClass=org.drools.workbench.jcr2vfsmigration.Jcr2VfsMigrationApp

rem echo "Usage: runMigration.bat"
rem echo "For example: runMigration.bat"
rem echo "Some notes:"
rem echo "- Working dir should be the directory of this script."
rem echo "- Java is recommended to be JDK and java 6 for optimal performance"
rem echo "- The environment variable JAVA_HOME should be set to the JDK installation directory"
rem echo "  For example: set JAVA_HOME="C:\Program Files\Java\jdk1.6.0"
rem echo
rem echo "Starting migration app..."

rem You can use -Xmx128m or less too, but it might be slower
if exist %JAVA_HOME%\bin\java.exe (
    %JAVA_HOME%\bin\java -Xms256m -Xmx512m -server -cp ..\libs\*; %mainClass%
) else (
    java -Xms256m -Xmx512m -cp ..\libs\*; %mainClass%
)
