/*
 * CS5405
 * Homework 05
 * Grant Broadwater (grbcp5)
 * October 16, 2018
 *
 * ButtonSegmentControllerDataSource.java
 */

package code;

import javafx.scene.layout.Pane;

interface ButtonSegmentControllerDataSource {

  public int getNumberOfSegments();
  public ButtonContent getContentForSegment(int segmentIndex);
  public Pane getPaneForSegment(String segmentTitle);

}