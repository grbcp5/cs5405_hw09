/*
 * CS5405
 * Grant Broadwater (grbcp5)
 *
 * MediaPlayerPane.java
 */

package code;

import javafx.scene.layout.StackPane;
import java.io.File;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer.Status;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.util.Duration;
import javafx.beans.value.ObservableValue;

public class MediaPlayerPane extends StackPane {

  private MediaPlayer mediaPlayer;
  private Media media;

  public MediaPlayerPane() {
    super();

    this.mediaPlayer = null;
  }

  public void setMedia(File mediaFile) {

    if (this.mediaPlayer != null) {
      this.mediaPlayer.pause();
    }

    String mediaURI = mediaFile.toURI().toString();
    this.media = new Media(mediaURI);
    this.media.errorProperty().addListener(this::mediaPlayerErrorChanged);

    this.mediaPlayer = new MediaPlayer(media);
    this.mediaPlayer.currentTimeProperty().addListener(this::mediaCurrentTimeChanged);
    this.mediaPlayer.errorProperty().addListener(this::mediaPlayerErrorChanged);
    this.mediaPlayer.statusProperty().addListener(this::mediaPlayerStatusChanged);
    this.mediaPlayer.volumeProperty().addListener(this::mediaPlayerVolumeChanged);
    this.mediaPlayerVolumeChanged(null, null, null);
    this.mediaPlayer.setAutoPlay(true);
    MediaView mediaView = new MediaView(this.mediaPlayer);
    this.getChildren().clear();
    this.getChildren().add(mediaView);
    System.out.println("New media file: " + this.media.getSource());
  }


  private void mediaCurrentTimeChanged(ObservableValue value, Object oldValue, Object newValue) {
    System.out.println("Current Time: " + this.mediaPlayer.getCurrentTime());
  }

  private void mediaPlayerErrorChanged(ObservableValue value, Object oldValue, Object newValue) {
    System.out.println("Media player error: " + this.mediaPlayer.getError().toString());
    System.out.println("Media error: " + this.media.getError().toString());
  }

  private void mediaPlayerStatusChanged(ObservableValue value, Object oldValue, Object newValue) {
    System.out.println("Media player status: " + this.mediaPlayer.getStatus());
  }

  private void mediaPlayerVolumeChanged(ObservableValue value, Object oldValue, Object newValue) {
    System.out.println("Media player volume: " + this.mediaPlayer.getVolume());
  }
}