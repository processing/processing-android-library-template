These instructions will help you get started with developing a library for Processing Android using Eclipse. The steps walk you through three main tasks.

1. Setting up the project in Eclipse
1. Configuring the build properties so that your library can be built and packaged by Ant
1. Finding the library files produced by Ant for use in Processing and redistribution.

## Prerequisites

The following components must be installed in order to go through the Usage Instructions.

* Java-oriented version of [Eclipse](http://www.eclipse.org/) (such as the Eclipse IDE for Java Developers)
* Java JDK version 6 or higher
* [Processing 2.0a6](http://processing.org/download/) or later
* [Android SDK](http://developer.android.com/sdk/index.html) with the API level 10 or later.

## Usage Instructions

Based on the [[Eclipse Library Template|Eclipse-Library-Template]]

1. Download the latest version of the [Processing Android Library Template](https://github.com/processing/processing-android-library-template/releases). **Don't unzip the ZIP file yet.**
1. Create a new Java project in Eclipse.
  * From the menubar choose File → New → Java Project.
  * Give the project the name of your library.
  * Click "Finish".
1. Add the Processing and Android libraries to the Project build path to enable syntax highlighting and library reference in Eclipse.
  * Processing Android Core Library (`android-core.zip`). There are two main ways of doing this, depending on how bleeding-edge you want to be.
      1. Point to the android-core.zip that comes with the Processing application.
          * Open the Properties panel for your project (right-click/control-click on the project → Properties)
          * Click on Java Build Path → Libraries
          * Click the Add External JARs... button
          * Locate the `android-core.zip` file for your Processing installation:
              * OS X
                  1. Enter Command-Shift-G to open the "Go to the folder:" box.
                  1. Enter "/Applications/Processing.app/Contents/Resources/Java/modes/android" (assuming you installed Processing to Applications and didn't rename the application) and click Go.
                  1. Select the android-core.zip file.
                  1. Click Open.
              * Windows
                  1. Browse to the location of your Processing installation.
                  1. In the Processing application folder, browse to modes\android\.
                  1. Select the android-core.zip file.
                  1. Click Open.
              * (TODO) Linux
      1. (TODO) or Check out the latest code from the [Processing repository](https://github.com/processing/processing).
  * Android Platform Library (android.jar)
      1. Open the Properties panel for your project (right-click/control-click on the project → Properties)
      1. Click on Java Build Path → Libraries
      1. Click the Add External JARs... button
      1. Browse to the location of your Android SDK installation.
      1. From the main SDK folder, browse to platforms/android-10 (newer versions will work, too).
      1. Select the android.jar file and click Open. android.jar should now be listed in the Libraries tab of your project properties.
      1. (Optional) Add the Android documentation (if you included it when you installed the Android SDK)
          * Expand the android.jar entry in the Libraries tab.
          * Click the sub-entry labeled "Javadoc location: (none)".
          * Click Edit. A window titled "Javadoc For 'android.jar'" will appear.
          * Click the Browse button next to the Javadoc location path text box.
          * In the dialog, browse to the location of your Android SDK.
          * Click the "docs" folder.
          * Click Open.
          * Click OK. The path to the Javadocs for android.jar will now be listed.
      1. Close the Properties panel by clicking OK.
  * Import the Processing Android Library Template into the project.
      1. Select the project.
      1. Right-click/control-click → Import...
      1. Click General → Archive File → Next
      1. In the "From archive file" box, select the template .zip file that you downloaded in step 1.
      1. Ensure the checkbox next to the archive root (/) is checked.
      1. Click Finish. The directory structure and example code from the template will be added to your project.
  * Edit the resources/build.properties file to ensure the following fields are set correctly.
      * **sketchbook.location** is a quasi-optional field that should be set to the path of your Processing sketchbook folder. This field serves two main purposes in the Ant build. If you do not want either of these two things to happen when you build your library, set sketchbook.location to a path **other** than your actual sketchbook folder. **However**, be aware that the sketchbook.location path will be created if it does not exist.
          * Ant will automatically include anything in your sketchbook/libraries folder in the classpath, which is kind of handy if you are dependent on other libraries that you have installed.
          * When the build is complete, Ant will automatically deploy the library to the sketchbook/libraries path defined here (in addition to building a .zip distribution).
      * **classpath.local.location** should be the path of the android-core.zip file that you added to your project build path in step 3 (do not include the filename "android-core.zip" in this path).
android_platform.location should be the path of the android.jar that you specified in step 3 (do not include the filename "android-core.zip" in this path).
      * All of the fields in sections (4) and on are for metadata about your library. These values get put in the documentation files for the distribution.
  * In Eclipse, show the Ant panel (Window → Show View → Ant).
  * Drag the resources/build.xml file over to the Ant panel.
  * Select the task that is now listed in the Ant view and click the Run button in the Ant panel.
  * BUILD SUCCESSFUL. The library template will start to compile, control-messages will appear in the console window, warnings can be ignored. When finished it should say BUILD SUCCESSFUL. Congratulations, you are set and you can start writing your own library by making changes to the source code in folder "src".
  * BUILD FAILED. In case the compile process fails, check the output in the console which will give you a closer idea of what went wrong. Errors may have been caused by
      * Incorrect path settings in the "build.xml" file.
      * Error "Javadoc failed". if you are on Windows, make sure you are using a JDK instead of a JRE in order to be able to create the javadoc for your library. JRE does not come with the javadoc application, but it is required to create libraries from this template.

After having compiled and built your project successfully, you should be able to find your library in Processing's sketchbook folder, examples will be listed in Processing's sketchbook menu. Files that have been created for the distribution of the library are located in your Eclipse's "workspace/yourProject/distribution" folder. In there you will also find the "web" folder which contains the documentation, a zip file for downloading your library, a folder with examples as well as the "index.html" and CSS file.

## Notes

* Any .jar files in your lib/ folder will get put in the distribution archive. So if you want to develop with libraries that you don't intend to redistribute, don't put them in lib/.
* The distribution .zip doesn't appear to include installation instructions, a license doc, or a readme, so be sure to add those files if necessary.
