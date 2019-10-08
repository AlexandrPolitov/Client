package code.FXControllers;

import code.models.Dialogue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class MainPage {
    @FXML
    Button send;
    @FXML
    TextField msgText;
    @FXML
    TextArea msgList;
    @FXML
   private VBox listDialogues;

    @FXML
    public void initialize(){

    }
    @FXML
    public void onEnter() {
        addDialogue(new Dialogue(1, "sdf"));
    }

    public void addDialogue(Dialogue dialogue) {
        Pane pane = new Pane();
        pane.setPrefHeight(40);
        pane.setStyle("-fx-background-color: #ECF0F1;");

        Label label = new Label();
        label.setText(dialogue.getName());
        pane.getChildren().add(label);

        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        listDialogues.getChildren().add(pane);
    }
}
