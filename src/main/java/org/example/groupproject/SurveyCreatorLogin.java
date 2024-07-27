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

public class SurveyCreatorLogin {

    @FXML
    private Label LoginINFO;

    @FXML
    private TextField SurveyCreatorEmail;

    @FXML
    private PasswordField SurveyCreatorPassword;

    String pathToCSVCreator = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\Creator.csv";

    public void buttonForSurveyCreatorSignUp(ActionEvent event) throws IOException {
        // loadStage("AdminSignUp.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyCreatorSignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = StageUtils.extractStageFromEvent(event);
        stage.setScene(scene);
    }

    public void buttonForSurveyCreatorLogin(ActionEvent event){
        String emailText = SurveyCreatorEmail.getText();
        String passwordText = SurveyCreatorPassword.getText();
        try {
            FileReader fileReader = new FileReader(pathToCSVCreator);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] rows;
            boolean found = false;
            while ((rows = csvReader.readNext()) != null){
                if (emailText.equals(rows[1]) && passwordText.equals(rows[6])){
                    LoginINFO.setText("Login Successful");
                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyCreatorNewPage.fxml"));
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
}
