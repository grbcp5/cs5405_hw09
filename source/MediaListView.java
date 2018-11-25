/*
 * CS5405
 * Grant Broadwater (grbcp5)
 *
 * MediaListView.java
 */

package code;

import javafx.scene.control.ListView;
import java.io.File;
import java.io.IOException;
import java.io.FilenameFilter;
import javafx.stage.DirectoryChooser;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;


public class MediaListView extends ListView<String> {

  private String mediaFileExtension;
  private File mediaDirectory;
  private File[] fileList;
  private File selectedFile;
  private ObjectProperty<Object> selectedFileObjectProperty;


  public MediaListView(String mediaFileExtension, String... possibleMediaDirectories) {
    super();

    this.mediaFileExtension = mediaFileExtension;
    this.mediaDirectory = this.getMediaDirectory(possibleMediaDirectories);
    this.fileList = this.getMediaFiles(this.mediaDirectory);

    this.selectedFile = null;
    this.selectedFileObjectProperty = new SimpleObjectProperty<Object>();

    super.setItems(
      FXCollections.observableArrayList(getFileNames(this.fileList))
    );
    super.getSelectionModel().selectedItemProperty().addListener(this::selectedItemChanged);
  }


  public File getSelectedMediaFile() {
    return this.selectedFile;
  }


  public ReadOnlyObjectProperty<Object> selectedMediaFileProperty() {
    return this.selectedFileObjectProperty;
  }


  private File getMediaDirectory(String[] possibleMediaDirectories) {

    File mediaDirectory = null;
    File[] fileList;

    for(String possibleDirectory: possibleMediaDirectories) {

      mediaDirectory = new File(possibleDirectory);
      fileList = mediaDirectory.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.toLowerCase().endsWith(mediaFileExtension);
        }
      });

      if (fileList == null || fileList.length == 0) {

        mediaDirectory = null;

      } else {

        break;
      }
    }

    if (mediaDirectory == null) {

      DirectoryChooser directoryChooser = new DirectoryChooser();
      directoryChooser.setInitialDirectory(new File("."));

      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Select " + this.mediaFileExtension + " Directory");
      alert.setHeaderText("Select " + this.mediaFileExtension + " Directory");
      alert.setContentText("Select directory conatining " + this.mediaFileExtension + " media files.");

      alert.showAndWait();

      mediaDirectory = directoryChooser.showDialog(Demo.getPrimaryStage());
    } 

    return mediaDirectory;
  }


  private File[] getMediaFiles(File mediaDirectory) {

    File[] fileList;

    if (mediaDirectory != null) {
      fileList = mediaDirectory.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.toLowerCase().endsWith(mediaFileExtension);
        }
      });

      if (fileList != null) {
        return fileList;
      }
    }

    return new File[0];
  }


  private String[] getFileNames(File[] fileList) {

    String[] fileNames = new String[fileList.length];

    for(int i = 0; i < fileList.length; i++) {
      fileNames[i] = fileList[i].getName();
    }

    return fileNames;
  }


  private void selectedItemChanged(ObservableValue value, String oldValue, String newValue) {
    this.selectedFile = this.fileList[super.getSelectionModel().getSelectedIndex()];
    this.selectedFileObjectProperty.setValue(this.selectedFile);
  }
}