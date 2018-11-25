/*
 * CS5405
 * Homework 05
 * Grant Broadwater (grbcp5)
 * October 16, 2018
 *
 * ButtonMenu.java
 */

package code;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ButtonMenu extends HBox {


  public static final double DEFAULT_SPACING = 20.0;


  public ButtonMenu() {
    this(ButtonMenu.DEFAULT_SPACING);
  }


  public ButtonMenu(double spacing) {
    this(spacing, null, new ButtonContent[0]);
  }


  public ButtonMenu(EventHandler<ActionEvent> handler, String... buttonTitles) {
    this(ButtonMenu.DEFAULT_SPACING, handler, buttonTitles);
  }


  public ButtonMenu(EventHandler<ActionEvent> handler, ButtonContent... contents) {
    this(ButtonMenu.DEFAULT_SPACING, handler, contents);
  }


  public ButtonMenu(double spacing, EventHandler<ActionEvent> handler, String... buttonTitles) {
    super(spacing);

    this.setPadding(new Insets(10, 10, 10, 10));

    this.setButtons(handler, buttonTitles);
  }


  public ButtonMenu(double spacing, EventHandler<ActionEvent> handler, ButtonContent... contents) {
    super(spacing);

    this.setPadding(new Insets(10, 10, 10, 10));

    this.setButtons(handler, contents);
  }


  public void setButtons(EventHandler<ActionEvent> handler, String... buttonTitles) {
    ButtonContent[] contents = new ButtonContent[buttonTitles.length];

    for(int i = 0; i < buttonTitles.length; i++) {
      contents[i] = new ButtonContent(buttonTitles[i], (String) null);
    }

    this.setButtons(handler, contents);
  }


  public void setButtons(EventHandler<ActionEvent> handler, ButtonContent... contents) {
    this.removeAllButtons();

    for(int i = 0; i < contents.length; i++) {
      this.addButton(handler, contents[i]);
    }
  }


  public void addButton(EventHandler<ActionEvent> handler, ButtonContent content) {
      
      Button b;
      if (content.imageInputStream == null) {
        b = new Button(content.title);
      } else {
        ImageView imageView = new ImageView(new Image(content.imageInputStream));
        imageView.setFitHeight(24);
        imageView.setFitWidth(24);
        b = new Button(
          content.title, 
          imageView
        );
      }
      b.setOnAction(handler);
      b.setMaxWidth(Double.MAX_VALUE);
      HBox.setHgrow(b, Priority.ALWAYS);
      this.getChildren().add(b);
  }


  public void removeAllButtons() {
    this.getChildren().clear();
  }
}





