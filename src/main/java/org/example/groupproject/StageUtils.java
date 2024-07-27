package org.example.groupproject;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class StageUtils {
    public static Stage extractStageFromEvent(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage currentStage = (Stage) node.getScene().getWindow();
        return currentStage;
    }
}
