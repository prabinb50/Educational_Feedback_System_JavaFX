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

public class ParticipantSignUpController {
    @FXML
    private Label userINFO;

    @FXML
    private Label LoginINFO;

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
    private TextField participantSignUpName;

    @FXML
    private TextField participantSignUpEmail;

    @FXML
    private TextField participantSignUpUsername;

    @FXML
    private TextField participantSignUpFaculty;

    @FXML
    private TextField participantSignUpNo;

    @FXML
    private PasswordField participantSignUpPassword;

    @FXML
    private PasswordField participantSignUpConfirmPassword;

    String pathOfCSVParticipant = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\Participant.csv";

    public void buttonForParticipantSignUpRegister(ActionEvent event) {
        String ParticipantName = participantSignUpName.getText();
        String ParticipantEmail = participantSignUpEmail.getText();
        String ParticipantUsername = participantSignUpUsername.getText();
        String ParticipantGender = creatorGender.getValue();
        String ParticipantFaculty = participantSignUpFaculty.getText();
        String ParticipantNo = participantSignUpNo.getText();
        String ParticipantPassword = participantSignUpPassword.getText();
        String ParticipantConformPassword = participantSignUpConfirmPassword.getText();
        try {
            FileWriter fileWriter = new FileWriter(pathOfCSVParticipant, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {ParticipantName, ParticipantEmail, ParticipantUsername, ParticipantGender, ParticipantFaculty, ParticipantNo, ParticipantPassword, ParticipantConformPassword};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
        } catch (Exception e) {
            userINFO.setText(e.getMessage());
        }
    }

    public void buttonForParticipantSignUpLogin()throws IOException {
        loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
    }

    public void buttonForParticipantSignUpCancel()throws IOException {
        loadStage("/org/example/groupproject/hello-view.fxml");
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
