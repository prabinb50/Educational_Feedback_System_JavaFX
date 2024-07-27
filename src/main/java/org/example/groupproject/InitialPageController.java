package org.example.groupproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InitialPageController {

    @FXML
    private Label userINFO;

    public void buttonForAdminSignIn() throws IOException {
        loadStage("/org/example/groupproject/Admin.fxml");
    }

    public void buttonForCreatorSignIn() throws IOException{
        loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
    }

    public void buttonForParticipantSignIn() throws IOException{
        loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
    }

    @FXML
    public void loadStage(String sceneName) throws IOException{
        try {
            System.out.println("Loading FXML file: " + sceneName);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) userINFO.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            userINFO.setText("Failed to load scene: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
