/*
 * CS5405
 * Homework 05
 * Grant Broadwater (grbcp5)
 * October 16, 2018
 *
 * ReferencePane.java
 */

package code;


public class ReferencePane extends LabelPane {

  public static final String REFERENCE_TEXT 
    = "Resources used include lecuture notes, the textbook, as well as Oracle Java Documentation.\n(https://docs.oracle.com/javase/8/docs/)";

  public ReferencePane() {
    super(ReferencePane.REFERENCE_TEXT);
  }

}
