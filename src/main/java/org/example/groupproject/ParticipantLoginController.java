package org.example.groupproject;

import com.opencsv.CSVReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;

public class ParticipantLoginController {
    @FXML
    private Label LoginINFO;

    @FXML
    private TextField ParticipantEmail;

    @FXML
    private PasswordField ParticipantPassword;

    String pathOfCSVParticipant = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\Participant.csv";

    public void buttonForParticipantSignUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ParticipantSignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = StageUtils.extractStageFromEvent(event);
        stage.setScene(scene);
    }

    public void buttonForParticipantLogin(ActionEvent event){
        String emailText = ParticipantEmail.getText();
        String passwordText = ParticipantPassword.getText();
        try {
            FileReader fileReader = new FileReader(pathOfCSVParticipant);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] rows;
            boolean found = false;
            while ((rows = csvReader.readNext()) != null){
                if (rows.length >= 7 && emailText.equals(rows[1]) && passwordText.equals(rows[6])){ // Check row length before accessing
                    //if (emailText.equals(rows[1]) && passwordText.equals(rows[6])){
                    LoginINFO.setText("Login Successful");
                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EnterSuvey.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = StageUtils.extractStageFromEvent(event);
                    stage.setScene(scene);
                    found = true;
                    break;
                }
            }
            if (!found) {
                LoginINFO.setText("Invalid Credentials");
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public void buttonForParticipantCancel(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = StageUtils.extractStageFromEvent(event);
        stage.setScene(scene);
    }
}
