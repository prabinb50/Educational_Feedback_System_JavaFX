package org.example.groupproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EnterSurveyController {

    @FXML
    public TextField SCode;

    @FXML
    private Label validationLabel;

    private  String baseDir = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\SurveyQuestions";

    @FXML
    public void EnterSurvey() {
        String inputCode = SCode.getText();
        boolean isCodeVerified = false;

        try (Stream<Path> paths = Files.list(Paths.get(baseDir))) {
            for (Path path : (Iterable<Path>) paths::iterator) {
                if (Files.isDirectory(path) && path.getFileName().toString().matches("\\d+SurveyQuestion")) {
                    File randomCSVFile = new File(path.toString(), "0Survey_0.csv"); // Assuming this is the random generated CSV file

                    if (randomCSVFile.exists()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(randomCSVFile))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                if (line.trim().equals(inputCode)) {
                                    isCodeVerified = true;
                                    validationLabel.setText("Code verified. Reading other CSV files...");
                                    readOtherCSVFiles(path.toString());
                                    generateFXMLFromCSV(path.toString());
                                    break;
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                            validationLabel.setText("Error reading the random generated CSV file.");
                        }
                    }
                }
                if (isCodeVerified) {
                    break;
                }
            }

            if (!isCodeVerified) {
                validationLabel.setText("Invalid code. Please try again.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            validationLabel.setText("Error accessing directories.");
        }
    }

    private void readOtherCSVFiles(String directoryPath) {
        // Read mcq.csv
        readCSVFile(new File(directoryPath, "mcq.csv"));
        // Read polar.csv
        readCSVFile(new File(directoryPath, "polar.csv"));
        // Read tquestions.csv
        readCSVFile(new File(directoryPath, "tquestions.csv"));
    }

    private void readCSVFile(File csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Process the line read from the CSV file
                System.out.println("Read from " + csvFile.getName() + ": " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading " + csvFile.getName());
        }
    }
//    public void Back() throws IOException {
//        loadStage("/com/example/assignmentdraft2/hello-view.fxml");
//    }


    //Generating fxml
    private void generateFXMLFromCSV(String directoryPath) {
        List<String> tQuestions = readCSV(new File(directoryPath, "tquestion.csv"));
        List<MCQQuestion> mcqQuestions = readMCQCSV(new File(directoryPath, "mcq.csv"));
        List<String> polarQuestions = readCSV(new File(directoryPath, "polar.csv"));

        if (tQuestions.isEmpty() && mcqQuestions.isEmpty() && polarQuestions.isEmpty()) {
            System.out.println("No questions found in the CSV files.");
            return;
        }

        String fxmlContent = generateFXMLContent(tQuestions, mcqQuestions, polarQuestions);
        writeFXMLFile(fxmlContent, new File(directoryPath, "Questions.fxml"));
    }

    private List<String> readCSV(File csvFile) {
        List<String> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading " + csvFile.getName());
        }
        return questions;
    }

    private List<MCQQuestion> readMCQCSV(File csvFile) {
        List<MCQQuestion> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    String question = parts[0].trim();
                    List<String> options = new ArrayList<>();
                    for (int i = 1; i < parts.length; i++) {
                        options.add(parts[i].trim());
                    }
                    questions.add(new MCQQuestion(question, options));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading " + csvFile.getName());
        }
        return questions;
    }

    private String generateFXMLContent(List<String> tQuestions, List<MCQQuestion> mcqQuestions, List<String> polarQuestions) {
        StringBuilder fxmlBuilder = new StringBuilder();
        fxmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        fxmlBuilder.append("<?import javafx.scene.control.*?>\n");
        fxmlBuilder.append("<?import javafx.scene.layout.*?>\n");
        fxmlBuilder.append("<VBox xmlns=\"http://javafx.com/javafx/8\" xmlns:fx=\"http://javafx.com/fxml/1\" spacing=\"10\">\n");

        for (String question : tQuestions) {
            fxmlBuilder.append("    <VBox spacing=\"5\">\n");
            fxmlBuilder.append("        <Label text=\"").append(question).append("\" />\n");
            fxmlBuilder.append("        <TextField fx:id=\"").append(generateFXID(question)).append("\" />\n");
            fxmlBuilder.append("    </VBox>\n");
        }

        for (MCQQuestion mcq : mcqQuestions) {
            fxmlBuilder.append("    <VBox spacing=\"5\">\n");
            fxmlBuilder.append("        <Label text=\"").append(mcq.getQuestion()).append("\" />\n");
            for (String option : mcq.getOptions()) {
                fxmlBuilder.append("        <RadioButton text=\"").append(option).append("\" />\n");
            }
            fxmlBuilder.append("    </VBox>\n");
        }

        for (String question : polarQuestions) {
            fxmlBuilder.append("    <VBox spacing=\"5\">\n");
            fxmlBuilder.append("        <Label text=\"").append(question).append("\" />\n");
            fxmlBuilder.append("        <HBox spacing=\"10\">\n");
            fxmlBuilder.append("            <RadioButton text=\"Yes\" />\n");
            fxmlBuilder.append("            <RadioButton text=\"No\" />\n");
            fxmlBuilder.append("        </HBox>\n");
            fxmlBuilder.append("    </VBox>\n");
        }

        fxmlBuilder.append("</VBox>\n");
        return fxmlBuilder.toString();
    }

    private String generateFXID(String question) {
        return "tf_" + question.replaceAll("[^a-zA-Z0-9]", "");
    }

    private void writeFXMLFile(String content, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("FXML file written to: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing FXML file.");
        }
    }


    private static class MCQQuestion {
        private final String question;
        private final List<String> options;

        public MCQQuestion(String question, List<String> options) {
            this.question = question;
            this.options = options;
        }

        public String getQuestion() {
            return question;
        }

        public List<String> getOptions() {
            return options;
        }
    }

//    @FXML
//    public void loadStage(String sceneName) throws IOException{
//        try {
//            System.out.println("Loading FXML file: " + sceneName);
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
//            Parent root = fxmlLoader.load();
//            Stage stage = (Stage) userINFO.getScene().getWindow();
//            stage.setScene(new Scene(root));
//            stage.show();
//        }catch (IOException e){
//            userINFO.setText("Failed to load scene: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }






}
