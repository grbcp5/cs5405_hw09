/*
 * CS5405
 * Grant Broadwater (grbcp5)
 *
 * MultiMediaController.java
 */

package code;


import javafx.scene.layout.BorderPane;
import javafx.beans.value.ObservableValue;
import java.io.File;


public abstract class MediaController extends BorderPane {

  private MediaListView mediaListView;
  private MediaPlayerPane mediaPlayerPane;

  protected MediaController(String mediaFileExtension, String... possibleMediaDirectories) {
    super();

    this.mediaListView = new MediaListView(mediaFileExtension, possibleMediaDirectories);
    this.mediaListView.selectedMediaFileProperty().addListener(this::newMediaFileSelected);
    this.setLeft(this.mediaListView);

    this.mediaPlayerPane = new MediaPlayerPane();
    this.setCenter(this.mediaPlayerPane);
  }


  public void newMediaFileSelected(ObservableValue value, Object oldValue, Object newValue) {
    File newMediaFile = this.mediaListView.getSelectedMediaFile();
    this.mediaPlayerPane.setMedia(newMediaFile);
  }
}