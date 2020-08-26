# API automation tests demo project  ![TeamCity Status Build](http://134.249.164.109/app/rest/builds/buildType:AfjSolutionTest_Check/statusIcon.svg)

## Table of contents
  * [Preconditions](#preconditions)
    * [Windows](#windows)
    * [Mac OS](#macos)
  * [Run using IDE](#idea)
  * [Run using command line](#command-line)
  * [Run on the Team City](#team-city)

## Preconditions
## Windows
##### Install and Setup Java
1. Install Java 8 or higher on your local machine. To download Java 8 jdk click on [that](https://java.com/ru/download/) and install java for Windows.
1. To set up JAVA_HOME follow next steps:
    1. Click left button of the mouse on the 'My computer' icon and choose 'Settings' in the drop-down list;
    1. In the 'System' window click 'Additional parameters of the system';
    1. Click on button 'Environment variables';
    1. In the modal window 'System variables' click button 'Add';
    1. In the field 'Variable name' fill 'JAVA_HOME';
    1. In the field 'Variable value' fill <path to jdk>;
    1. Click 'OK' button;
    1. Open 'PATH' in the 'System variables';
    1. In the bottom of the list add %JAVA_HOME%\lib, %JAVA_HOME%\bin and %JAVA_HOME%\jre;
1. To check the acceptance of changes, open the command line of your machine and run the following 'path' command, at the end of the change you need to set <path to jdk>\lib,<path to jdk>\bin and <path to jdk>\jre
## Mac OS
1. Install with Homebrew
    1. Install Homebrew using the command (*if the homebrew already installed into you mac os skip that step*) ``/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"``
    1. Install java 8 using command `brew tap adoptopenjdk/openjdk && brew cask install adoptopenjdk8`
    1. Set JAVA_HOME using command `export JAVA_HOME=/path/to/java` (*usually for homebrew install it would be /Library/Java/JavaVirtualMachines/jdk/Contents/Home*)
    1. Set JAVA_HOME to the patch using command `PATH=$JAVA_HOME/lib:$JAVA_HOME/bin:$JAVA_HOME/jre:$PATH`
    
## Run using IDE
* Install `IntelliJ IDEA` IDE
* Install _Lombok Plugin_: `IntelliJ IDEA > Preferences > Plugins > Browse repositories > Lombok Plugin`
* _Enable annotation processing_: `IntelliJ IDEA > Preferences > Build, Execution, Deployment > Compiler > Annotation Processors > Enable annotation processing`
* Checkout project from git
* Start import as `Gradle` project
 * Go to the `src/test/java/com/gombosh/tomash/api` click on the right button and click ``Run 'Test' in 'com.gombosh...'``
 
 ## Run using command line
 * Checkout project from git
 * Go to the checkout folder using ``cd java-api-test-demo``
 * Start test using command for Windows: ``gradlew clean test`` for macOS: ``./gradlew clean test``
 * After test finished to generate the report using next command for Windows ``gradlew allureReport && gradlew allureServe`` 
 for macOS: ``./gradlew allureReport && ./gradlew allureServe``  
 
 ## Run on the Team City
 * Go to the [Team City server](http://134.249.164.109/)
 * Login to the server (*To get credential to the server please contact [me](https://github.com/TomashGombosh)*)