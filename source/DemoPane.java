/*
 * CS5405
 * Grant Broadwater (grbcp5)
 *
 * DemoPane.java
 */

package code;

import javafx.scene.layout.Pane;


public class DemoPane extends ButtonSegmentController implements ButtonSegmentControllerDataSource {

  public static final String AUDIO_MENU_TITLE = "AUDIO";
  public static final String VIDEO_MENU_TITLE = "VIDEO";

  public static final String AUDIO_RESOURCE_PATH = "/img/volumeUp.png";
  public static final String VIDEO_RESOURCE_PATH = "/img/video.png";

  private static ButtonContent[] menuButtonContent;

  private Pane audioPane;
  private Pane videoPane;

  public DemoPane() {
    super(null);

    this.menuButtonContent = new ButtonContent[] {
      new ButtonContent(AUDIO_MENU_TITLE, AUDIO_RESOURCE_PATH),
      new ButtonContent(VIDEO_MENU_TITLE, VIDEO_RESOURCE_PATH)
    };

    super.dataSource = this;
    super.reloadData();
  }


  /* ButtonSegmentControllerDataSource */

  public int getNumberOfSegments() {
    return this.menuButtonContent.length;
  }


  public ButtonContent getContentForSegment(int segmentIndex) {
    return this.menuButtonContent[segmentIndex];
  }


  public Pane getPaneForSegment(String segmentTitle) {
    if (segmentTitle.equals(AUDIO_MENU_TITLE)) {
      if (this.audioPane == null) {
        this.audioPane = new AudioPane();
      }
      return this.audioPane;
    } else if (segmentTitle.equals(VIDEO_MENU_TITLE)) {
      if (this.videoPane == null) {
        this.videoPane = new VideoPane();
      }
      return this.videoPane;
    } else {
      System.out.println("Request for unknown segment " + segmentTitle);
      return null;
    }
  }

}