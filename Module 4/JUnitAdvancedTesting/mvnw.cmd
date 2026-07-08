@echo off
setlocal enabledelayedexpansion
set "SCRIPT_DIR=%~dp0"
set "WRAPPER_DIR=%SCRIPT_DIR%.mvn\wrapper"
set "MAVEN_DIST=%WRAPPER_DIR%\apache-maven-3.9.9-bin.zip"
set "MAVEN_HOME=%WRAPPER_DIR%\apache-maven-3.9.9"

if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
    if not exist "%MAVEN_DIST%" (
        powershell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest -Uri 'https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.9/apache-maven-3.9.9-bin.zip' -OutFile '%MAVEN_DIST%'"
    )
    if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
        powershell -NoProfile -ExecutionPolicy Bypass -Command "Expand-Archive -Path '%MAVEN_DIST%' -DestinationPath '%WRAPPER_DIR%' -Force"
    )
)

if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
    echo Maven installation could not be prepared. 1>&2
    exit /b 1
)

call "%MAVEN_HOME%\bin\mvn.cmd" %*
