/*
 * CS5405
 * Homework 05
 * Grant Broadwater (grbcp5)
 * October 16, 2018
 *
 * ButtonContent.java
 */
package code;


import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;

public class ButtonContent {

  public String title;
  public InputStream imageInputStream;

  public ButtonContent(String title, String imageInputStreamPath) {
    this.title = title;

    if (imageInputStreamPath == null) {
      this.imageInputStream = null;
    } else {
      this.imageInputStream = ResourceLoader.load(imageInputStreamPath);
    }
  }

  public ButtonContent(String title, InputStream imageInputStream) {
    this.title = title;
    this.imageInputStream = imageInputStream;
  }
}