package org.example.groupproject;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class SurveyCreatorRegister {

    @FXML
    private Label userINFO;

    @FXML
    private TextField creatorName;

    @FXML
    private TextField creatorEmail;

    @FXML
    private TextField creatorUsername;

    @FXML
    private ChoiceBox<String> creatorGender;

    @FXML
    public void initialize(){
        if(creatorGender != null){
            creatorGender.getItems().addAll("male", "female", "others");
        } else{
            System.err.println("error");
        }
    }

    @FXML
    private TextField creatorFaculty;

    @FXML
    private TextField creatorNo;

    @FXML
    private PasswordField creatorPassword;

    @FXML
    private PasswordField creatorConfirmPassword;

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

    String pathToCSVCreator = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\Creator.csv";

    public void buttonForCreatorRegister(ActionEvent event) {
        String CreatorName = creatorName.getText();
        String CreatorEmail = creatorEmail.getText();
        String CreatorUsername = creatorUsername.getText();
        String CreatorGender = creatorGender.getValue();
        String CreatorFaculty = creatorFaculty.getText();
        String CreatorNo = creatorNo.getText();
        String CreatorPassword = creatorPassword.getText();
        String CreatorConformPassword = creatorConfirmPassword.getText();
        try {
            FileWriter fileWriter = new FileWriter(pathToCSVCreator, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {CreatorName, CreatorEmail, CreatorUsername, CreatorGender, CreatorFaculty, CreatorNo, CreatorPassword, CreatorConformPassword};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
        } catch (Exception e) {
            userINFO.setText(e.getMessage());
        }
    }

    public void buttonForCreatorLogin()throws IOException {
        loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
    }
}
