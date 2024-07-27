package org.example.groupproject;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SurveyCreatorNewPageController {
    @FXML
    private Label userINFO;

    public void buttonForCreateSurvey(ActionEvent event) throws IOException {
        userINFO.setText("Survey Created click on view survey");
        createCSVFile();
        FileWriter fileWriter1 = new FileWriter("C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\SurveyCode.csv",true);
        CSVWriter csvWriter1 = new CSVWriter(fileWriter1);
        String data1 = generateRandomWord();
        String[] data2 = {data1};
        csvWriter1.writeNext(data2);
        csvWriter1.close();
        userINFO.setText("data1");

        //load stage to survey questions
        //loadStage("/org/example/groupproject/SurveyQuestions.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyQuestions.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = StageUtils.extractStageFromEvent(event);
        stage.setScene(scene);

    }

    private static final String DIRECTORY_PATH = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\SurveyData\\"; // Change this to your desired directory
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final int WORD_LENGTH = 6;

    public static String generateRandomWord() {
        StringBuilder word = new StringBuilder(WORD_LENGTH);
        Random random = new Random();

        for (int i = 0; i < WORD_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            word.append(CHARACTERS.charAt(index));
        }
        return word.toString();
    }

    public static  int fileCounter = 0;
    public static void createCSVFile() {
        // Ensure the directory exists
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = DIRECTORY_PATH + "Survey_" + fileCounter + ".csv";
        try (FileWriter fileWriter = new FileWriter(fileName)) {

            System.out.println("CSV file created: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating CSV file: " + e.getMessage());
        }
        fileCounter++;
    }
}
