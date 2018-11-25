/*
 * CS5405
 * Homework 05
 * Grant Broadwater (grbcp5)
 * October 16, 2018
 *
 * AuthorPane.java
 */

package code;


public class AuthorPane extends LabelPane {

  public static final String AUTHOR_TEXT = "Program Author: Grant Broadwater" 
    + "\nEmail: grbcp5@mst.edu"
    + "\nStudent Id: 12425712" 
    + "\nPhone: (123) 456 - 7890" 
    + "\nCopyright: Grant Broadwater (Sole Proprietor)";

  public AuthorPane() {
    super(AuthorPane.AUTHOR_TEXT);
  }

}
