package com.sarah.library;


import org.tensorflow.lite.Interpreter;

import processing.core.PApplet;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template'
 * to your own library or tool naming convention.
 *
 <!-- * @example Hello  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class HelloLibrary {

  // myParent is a reference to the parent sketch
  PApplet myParent;

  int myVariable = 0;

  public final static String VERSION = "##library.prettyVersion##";

  /**
   * a Constructor, usually called in the setup() method in your sketch to
   * initialize and start the library.
   *
   <!-- * @example Hello -->
   * @param theParent
   *               The parent sketch.
   */
  public HelloLibrary(PApplet theParent) {
    myParent = theParent;
    welcome();

    System.out.println("--sarah start--");
    Interpreter.Options interpreter = new Interpreter.Options().setUseNNAPI(true);
    System.out.println(interpreter.toString());
    System.out.println("--sarah end--");
  }


  private void welcome() {
    System.out.println("##library.name## ##library.prettyVersion## by ##author##");
  }


  public String sayHello() {
    return "test! hello library.";
  }
  /**
   * return the version of the library.
   *
   * @return String
   */
  public static String version() {
    return VERSION;
  }

  /**
   *
   * @param theA
   *          the width of test
   * @param theB
   *          the height of test
   */
  public void setVariable(int theA, int theB) {
    myVariable = theA + theB;
  }

  /**
   *
   * @return int
   */
  public int getVariable() {
    return myVariable;
  }
}


