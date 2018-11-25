/*
 * CS5405
 * Homework 05
 * Grant Broadwater (grbcp5)
 * October 16, 2018
 *
 * Demo.java
 */

package code;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Demo extends Application implements ButtonSegmentControllerDataSource {

  public static final String AUTHOR_MENU_TITLE = "Author";
  public static final String PROBLEM_MENU_TITLE = "Problem";
  public static final String REFERENCE_MENU_TITLE = "Reference";
  public static final String DEMOS_MENU_TITLE = "Demos";

  public static final String AUTHOR_MENU_RESOURCE_PATH = "/img/author.png";
  public static final String PROBLEM_MENU_RESOURCE_PATH = "/img/question.png";
  public static final String REFERENCE_MENU_RESOURCE_PATH = "/img/list.png";
  public static final String DEMOS_MENU_RESOURCE_PATH = "/img/playCircle.png";

  private static ButtonContent[] menuButtonContent;

  private static Stage primaryStage;

  private ButtonSegmentController segmentController;
  private AuthorPane authorPane;
  private ProblemPane problemPane;
  private ReferencePane referencePane;
  private DemoPane demoPane;


  public static void main(String[] args) {

    System.out.println("CS5405");
    System.out.println("Homework 08");
    System.out.println("Grant Broadwater");
    System.out.println("October 15, 2018");
    System.out.println();

    System.out.println("Starting application.");
    Demo.launch(args);
    System.out.println("Terminating application.");

  }


  public static Stage getPrimaryStage() {
    return Demo.primaryStage;
  }


  public void start(Stage primaryStage) { 

    Demo.menuButtonContent = new ButtonContent[] {
      new ButtonContent(AUTHOR_MENU_TITLE, AUTHOR_MENU_RESOURCE_PATH),
      new ButtonContent(PROBLEM_MENU_TITLE, PROBLEM_MENU_RESOURCE_PATH),
      new ButtonContent(REFERENCE_MENU_TITLE, REFERENCE_MENU_RESOURCE_PATH),
      new ButtonContent(DEMOS_MENU_TITLE, DEMOS_MENU_RESOURCE_PATH)
    };

    Demo.primaryStage = primaryStage;

    this.authorPane = new AuthorPane();
    this.problemPane = new ProblemPane();
    this.referencePane = new ReferencePane();
    // this.demoPane = new DemoPane();
    this.segmentController = new ButtonSegmentController(this);

    Scene scene = new Scene(this.segmentController, 750, 600);
    primaryStage.setTitle("Homework 06");
    primaryStage.setScene(scene);
    primaryStage.show();
  }


  public int getNumberOfSegments() {
    return Demo.menuButtonContent.length;
  }


  public ButtonContent getContentForSegment(int segmentIndex) {
    return Demo.menuButtonContent[segmentIndex];
  }


  public Pane getPaneForSegment(String segmentTitle) {
    if (segmentTitle.equals(Demo.AUTHOR_MENU_TITLE)) {
      return this.authorPane;
    } else if (segmentTitle.equals(Demo.PROBLEM_MENU_TITLE)) {
      return this.problemPane;  
    } else if (segmentTitle.equals(Demo.REFERENCE_MENU_TITLE)) {
      return this.referencePane;
    } else if (segmentTitle.equals(Demo.DEMOS_MENU_TITLE)) {
      if (this.demoPane == null) {
        this.demoPane = new DemoPane();
      }
      return this.demoPane;
    } else {
      return null;
    }
  }
}
