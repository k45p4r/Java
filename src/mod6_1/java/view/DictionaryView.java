
package view;


import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class DictionaryView extends Application {

    private TextField wordfield = new TextField();
    private TextField meaningfield = new TextField();
    private DictionaryController controller;
    private TextArea resultarea = new TextArea();

    public void start(Stage stage) {

        Button addButton = new Button("Add");
        Button searchButton = new Button("Search");
        FlowPane pane = new FlowPane();

        stage.setTitle("Dictionary Library");

        Insets insets = new Insets(10, 10, 10, 10);
        pane.setMargin(addButton, insets);
        pane.setMargin(searchButton, insets);
        pane.setMargin(wordfield, insets);
        pane.setMargin(meaningfield, insets);
        pane.setMargin(resultarea, insets);

        pane.getChildren().add(wordfield);
        pane.getChildren().add(meaningfield);
        pane.getChildren().add(addButton);
        pane.getChildren().add(searchButton);
        pane.getChildren().add(resultarea);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    String word = wordfield.getText();
                    String meaning = meaningfield.getText();
                    controller.add(word, meaning);
                    resultarea.setText("Word added");
                } catch (Exception e) {
                    resultarea.setText("Invalid input");
                }
            }
        });
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    String word = wordfield.getText();
                    String result = controller.search(word);
                    resultarea.setText(result);
                } catch (Exception e) {
                    resultarea.setText("Word not found");
                }
            }
        });

        stage.show();
    }

    public void init() {
        controller = new DictionaryController(this);
    }


    public void setResult(int result) {
        this.meaningfield.setText(String.valueOf(result));
    }
}

