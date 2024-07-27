package org.example.groupproject;

public class HelloController { }






//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//import com.opencsv.CSVWriter;
//import com.opencsv.CSVReader;

//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.security.cert.PolicyNode;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Stream;


// Admin.fxml for login
//    @FXML
//    private Label userINFO;
//
//    @FXML
//    private Label LoginINFO;

//    @FXML
//    private TextField email;
//
//    @FXML
//    private PasswordField password;




// for AdminSignUp.fxml
//    @FXML
//    private TextField adminName;
//
//    @FXML
//    private TextField adminEmail;
//
//    @FXML
//    private  TextField adminUsername;
//
//    @FXML
//    private PasswordField adminPassword;
//
//    @FXML
//    private PasswordField adminConfirmPassword;




// for Survery CreatorSignIn.fxml
//    @FXML
//    private TextField SurveyCreatorEmail;
//
//    @FXML
//    private PasswordField SurveyCreatorPassword;

// for SurveyCreatorSignUp.fxml
//    @FXML
//    private TextField creatorName;
//
//    @FXML
//    private TextField creatorEmail;
//
//    @FXML
//    private TextField creatorUsername;
//
//    @FXML
//    private ChoiceBox<String> creatorGender;
//
//    @FXML
//    public void initialize(){
//        if(creatorGender != null){
//            creatorGender.getItems().addAll("male", "female", "others");
//        } else{
//            System.err.println("error");
//        }
//    }
//
//    @FXML
//    private TextField creatorFaculty;
//
//    @FXML
//    private TextField creatorNo;
//
//    @FXML
//    private PasswordField creatorPassword;
//
//    @FXML
//    private PasswordField creatorConfirmPassword;



// for ParticipantSignIn.fxml
//    @FXML
//    private TextField ParticipantEmail;
//
//    @FXML
//    private PasswordField ParticipantPassword;

// for ParticipantSignUp.fxml
//    @FXML
//    private TextField participantSignUpName;
//
//    @FXML
//    private TextField participantSignUpEmail;
//
//    @FXML
//    private TextField participantSignUpUsername;
//
//    @FXML
//    private TextField participantSignUpFaculty;
//
//    @FXML
//    private TextField participantSignUpNo;
//
//    @FXML
//    private PasswordField participantSignUpPassword;
//
//    @FXML
//    private PasswordField participantSignUpConfirmPassword;




// for SurveyQuestions.fxml
//    @FXML
//    private AnchorPane dynamicBox;
//
//    @FXML
//    private Label SubmitL;


// path of csv files
//String pathToCSV = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\AdminData.csv";
//    String pathToCSVCreator = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\Creator.csv";
//String pathOfCSVParticipant = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\Participant.csv";



// for hello-view.fxml
//    public void buttonForAdminSignIn() throws IOException{
//        loadStage("/org/example/groupproject/Admin.fxml");
//    }
//
//    public void buttonForCreatorSignIn() throws IOException{
//        loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
//    }
//
//    public void buttonForParticipantSignIn() throws IOException{
//        loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
//    }




// for Admin.fxml........................................
//    public void buttonForAdminSignUp(ActionEvent event) throws IOException{
//        // loadStage("AdminSignUp.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminSignUp.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = StageUtils.extractStageFromEvent(event);
//        stage.setScene(scene);
//    }
//
//    public void buttonForLogin(ActionEvent event){
//        String emailText = email.getText();
//        String passwordText = password.getText();
//        try {
//            FileReader fileReader = new FileReader(pathToCSV);
//            CSVReader csvReader = new CSVReader(fileReader);
//            String[] rows;
//            boolean found = false;
//            while ((rows = csvReader.readNext()) != null){
//                if (emailText.equals(rows[1]) && passwordText.equals(rows[3])){
//                    LoginINFO.setText("Login Successful");
//                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = StageUtils.extractStageFromEvent(event);
//                    stage.setScene(scene);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                LoginINFO.setText("Invalid Credentials");
//            }
//        } catch (Exception e) {
//            System.out.println("error" + e);
//        }
//    }

// for AdminSignUp.fxml................................................
//    public void buttonForAdminRegister() {
//        String AdminName = adminName.getText();
//        String AdminEmail = adminEmail.getText();
//        String AdminUsername = adminUsername.getText();
//        String AdminPassword = adminPassword.getText();
//        String AdminConformPassword = adminConfirmPassword.getText();
//        try {
//            FileWriter fileWriter = new FileWriter(pathToCSV, true);
//            CSVWriter csvWriter = new CSVWriter(fileWriter);
//            String[] data = {AdminName, AdminEmail, AdminUsername, AdminPassword, AdminConformPassword};
//            csvWriter.writeNext(data);
//            csvWriter.close();
//            loadStage("/org/example/groupproject/Admin.fxml");
//
//        } catch (Exception e) {
//            userINFO.setText(e.getMessage());
//        }
//    }
//
//    public void buttonForAdminLogin()throws IOException{
//        loadStage("/org/example/groupproject/Admin.fxml");
//    }




// for Survery CreatorSignIn.fxml
//    public void buttonForSurveyCreatorSignUp(ActionEvent event) throws IOException{
//        // loadStage("AdminSignUp.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyCreatorSignUp.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = StageUtils.extractStageFromEvent(event);
//        stage.setScene(scene);
//    }
//
//    public void buttonForSurveyCreatorLogin(ActionEvent event){
//        String emailText = SurveyCreatorEmail.getText();
//        String passwordText = SurveyCreatorPassword.getText();
//        try {
//            FileReader fileReader = new FileReader(pathToCSVCreator);
//            CSVReader csvReader = new CSVReader(fileReader);
//            String[] rows;
//            boolean found = false;
//            while ((rows = csvReader.readNext()) != null){
//                if (emailText.equals(rows[1]) && passwordText.equals(rows[6])){
//                    LoginINFO.setText("Login Successful");
//                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyCreatorNewPage.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = StageUtils.extractStageFromEvent(event);
//                    stage.setScene(scene);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                LoginINFO.setText("Invalid Credentials");
//            }
//        } catch (Exception e) {
//            System.out.println("error" + e);
//        }
//    }

// for SurveyCreatorSignUp.fxml...........................................
//    public void buttonForCreatorRegister(ActionEvent event) {
//        String CreatorName = creatorName.getText();
//        String CreatorEmail = creatorEmail.getText();
//        String CreatorUsername = creatorUsername.getText();
//        String CreatorGender = creatorGender.getValue();
//        String CreatorFaculty = creatorFaculty.getText();
//        String CreatorNo = creatorNo.getText();
//        String CreatorPassword = creatorPassword.getText();
//        String CreatorConformPassword = creatorConfirmPassword.getText();
//        try {
//            FileWriter fileWriter = new FileWriter(pathToCSVCreator, true);
//            CSVWriter csvWriter = new CSVWriter(fileWriter);
//            String[] data = {CreatorName, CreatorEmail, CreatorUsername, CreatorGender, CreatorFaculty, CreatorNo, CreatorPassword, CreatorConformPassword};
//            csvWriter.writeNext(data);
//            csvWriter.close();
//            loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
//        } catch (Exception e) {
//            userINFO.setText(e.getMessage());
//        }
//    }
//
//    public void buttonForCreatorLogin()throws IOException{
//        loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
//    }





// for ParticipantSignIn.fxml................................
//    public void buttonForParticipantSignUp(ActionEvent event) throws IOException{
//        // loadStage("AdminSignUp.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ParticipantSignUp.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = StageUtils.extractStageFromEvent(event);
//        stage.setScene(scene);
//    }
//
//    public void buttonForParticipantLogin(ActionEvent event){
//        String emailText = ParticipantEmail.getText();
//        String passwordText = ParticipantPassword.getText();
//        try {
//            FileReader fileReader = new FileReader(pathOfCSVParticipant);
//            CSVReader csvReader = new CSVReader(fileReader);
//            String[] rows;
//            boolean found = false;
//            while ((rows = csvReader.readNext()) != null){
//                if (rows.length >= 7 && emailText.equals(rows[1]) && passwordText.equals(rows[6])){ // Check row length before accessing
//                //if (emailText.equals(rows[1]) && passwordText.equals(rows[6])){
//                    LoginINFO.setText("Login Successful");
//                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load());
//                    Stage stage = StageUtils.extractStageFromEvent(event);
//                    stage.setScene(scene);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                LoginINFO.setText("Invalid Credentials");
//            }
//        } catch (Exception e) {
//            System.out.println("error" + e);
//        }
//    }

// for ParticipantSignUp.fxml................................
//    public void buttonForParticipantSignUpRegister(ActionEvent event) {
//        String ParticipantName = participantSignUpName.getText();
//        String ParticipantEmail = participantSignUpEmail.getText();
//        String ParticipantUsername = participantSignUpUsername.getText();
//        String ParticipantGender = creatorGender.getValue();
//        String ParticipantFaculty = participantSignUpFaculty.getText();
//        String ParticipantNo = participantSignUpNo.getText();
//        String ParticipantPassword = participantSignUpPassword.getText();
//        String ParticipantConformPassword = participantSignUpConfirmPassword.getText();
//        try {
//            FileWriter fileWriter = new FileWriter(pathOfCSVParticipant, true);
//            CSVWriter csvWriter = new CSVWriter(fileWriter);
//            String[] data = {ParticipantName, ParticipantEmail, ParticipantUsername, ParticipantGender, ParticipantFaculty, ParticipantNo, ParticipantPassword, ParticipantConformPassword};
//            csvWriter.writeNext(data);
//            csvWriter.close();
//            loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
//        } catch (Exception e) {
//            userINFO.setText(e.getMessage());
//        }
//    }
//
//    public void buttonForParticipantSignUpLogin()throws IOException{
//        loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
//    }




// for SurveyCreatorNewPage.fxml......................................
//    public void buttonForCreateSurvey(ActionEvent event) throws IOException {
//        userINFO.setText("Survey Created click on view survey");
//        createCSVFile();
//        FileWriter fileWriter1 = new FileWriter("C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\SurveyCode.csv",true);
//        CSVWriter csvWriter1 = new CSVWriter(fileWriter1);
//        String data1 = generateRandomWord();
//        String[] data2 = {data1};
//        csvWriter1.writeNext(data2);
//        csvWriter1.close();
//        userINFO.setText("data1");
//
//        //load stage to survey questions
//        //loadStage("/org/example/groupproject/SurveyQuestions.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyQuestions.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = StageUtils.extractStageFromEvent(event);
//        stage.setScene(scene);
//
//    }
//
//    private static final String DIRECTORY_PATH = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\SurveyData\\"; // Change this to your desired directory
//    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
//    private static final int WORD_LENGTH = 6;
//
//    public static String generateRandomWord() {
//        StringBuilder word = new StringBuilder(WORD_LENGTH);
//        Random random = new Random();
//
//        for (int i = 0; i < WORD_LENGTH; i++) {
//            int index = random.nextInt(CHARACTERS.length());
//            word.append(CHARACTERS.charAt(index));
//        }
//        return word.toString();
//    }
//
//    public static  int fileCounter = 0;
//    public static void createCSVFile() {
//        // Ensure the directory exists
//        File directory = new File(DIRECTORY_PATH);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//
//        String fileName = DIRECTORY_PATH + "Survey_" + fileCounter + ".csv";
//        try (FileWriter fileWriter = new FileWriter(fileName)) {
//
//            System.out.println("CSV file created: " + fileName);
//        } catch (IOException e) {
//            System.err.println("Error creating CSV file: " + e.getMessage());
//        }
//        fileCounter++;
//    }




// for SurveyQuestions.fxml....................................
//    //adding new element
//    private int tQuestionCount = 0;
//    private int mcqCount = 0;
//    private int polarCount = 0;
//
//    @FXML
//    public void buttonForTextQuestions() { //buttonForTextQuestions
//        TextField newTextField = new TextField();
//        newTextField.setId("tquestion-" + tQuestionCount++);
//        Button addTquestionBtn = new Button("Add Tquestion");
//        Button polarQuestionsBtn = new Button("Polar Questions");
//        Button mcqBtn = new Button("MCQ");
//
//        newTextField.setPrefWidth(380);
//        newTextField.setPrefHeight(20);
//
//        addTquestionBtn.setOnAction(e -> buttonForTextQuestions());
//        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
//        mcqBtn.setOnAction(e -> addMCQ());
//
//        layoutTextField(newTextField);
//        layoutBelow(newTextField, addTquestionBtn);
//        layoutBelow(addTquestionBtn, polarQuestionsBtn);
//        layoutBelow(polarQuestionsBtn, mcqBtn);
//
//        dynamicBox.getChildren().addAll(newTextField, addTquestionBtn, polarQuestionsBtn, mcqBtn);
//    }
//
//    @FXML
//    public void addMCQ() {
//        TextField newTextField1 = new TextField();
//        newTextField1.setId("mcq-" + mcqCount++);
//        TextField newTextField2 = new TextField();
//        newTextField2.setId("mcq-" + mcqCount++);
//        TextField newTextField3 = new TextField();
//        newTextField3.setId("mcq-" + mcqCount++);
//        TextField newTextField4 = new TextField();
//        newTextField4.setId("mcq-" + mcqCount++);
//        TextField newTextField5 = new TextField();
//        newTextField5.setId("mcq-" + mcqCount++);
//
//        Button addTquestionBtn = new Button("Add Tquestion");
//        Button polarQuestionsBtn = new Button("Polar Questions");
//        Button mcqBtn = new Button("MCQ");
//
//        newTextField1.setPrefWidth(380);
//        newTextField1.setPrefHeight(20);
//        newTextField2.setPrefWidth(380);
//        newTextField2.setPrefHeight(20);
//        newTextField3.setPrefWidth(380);
//        newTextField3.setPrefHeight(20);
//        newTextField4.setPrefWidth(380);
//        newTextField4.setPrefHeight(20);
//        newTextField5.setPrefWidth(380);
//        newTextField5.setPrefHeight(20);
//
//        addTquestionBtn.setOnAction(e -> buttonForTextQuestions());
//        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
//        mcqBtn.setOnAction(e -> addMCQ());
//
//        layoutTextField(newTextField1);
//        layoutTextFieldBelow(newTextField2, newTextField1);
//        layoutTextFieldBelow(newTextField3, newTextField2);
//        layoutTextFieldBelow(newTextField4, newTextField3);
//        layoutTextFieldBelow(newTextField5, newTextField4);
//        layoutBelow(newTextField5, addTquestionBtn);
//        layoutBelow(addTquestionBtn, polarQuestionsBtn);
//        layoutBelow(polarQuestionsBtn, mcqBtn);
//
//        dynamicBox.getChildren().addAll(newTextField1, newTextField2, newTextField3, newTextField4, newTextField5, addTquestionBtn, polarQuestionsBtn, mcqBtn);
//    }
//
//    @FXML
//    public void addPolarQuestions() {
//        TextField newTextField = new TextField();
//        newTextField.setId("polar-" + polarCount++);
//        Button addTquestionBtn = new Button("Add Tquestion");
//        Button polarQuestionsBtn = new Button("Polar Questions");
//        Button mcqBtn = new Button("MCQ");
//
//        newTextField.setPrefWidth(380);
//        newTextField.setPrefHeight(20);
//
//        addTquestionBtn.setOnAction(e -> buttonForTextQuestions());
//        polarQuestionsBtn.setOnAction(e -> addPolarQuestions());
//        mcqBtn.setOnAction(e -> addMCQ());
//
//        layoutTextField(newTextField);
//        layoutBelow(newTextField, addTquestionBtn);
//        layoutBelow(addTquestionBtn, polarQuestionsBtn);
//        layoutBelow(polarQuestionsBtn, mcqBtn);
//
//        dynamicBox.getChildren().addAll(newTextField, addTquestionBtn, polarQuestionsBtn, mcqBtn);
//    }
//
//    private void layoutTextField(TextField textField) {
//        Node lastNode = dynamicBox.getChildren().get(dynamicBox.getChildren().size() - 1);
//        double layoutY = lastNode.getLayoutY();
//        textField.setLayoutX(50);
//        textField.setLayoutY(layoutY + lastNode.getBoundsInParent().getHeight() + 20);
//    }
//
//    private void layoutTextFieldBelow(TextField textField, Node aboveNode) {
//        double layoutY = aboveNode.getLayoutY();
//        textField.setLayoutX(50);
//        textField.setLayoutY(layoutY + aboveNode.getBoundsInParent().getHeight() + 20);
//    }
//
//    private void layoutBelow(Node aboveNode, Node belowNode) {
//        double layoutY = aboveNode.getLayoutY();
//        belowNode.setLayoutX(50);
//        belowNode.setLayoutY(layoutY + aboveNode.getBoundsInParent().getHeight() + 20);
//    }
//
//    @FXML
//    public void submitquestions() {
//        String baseDir = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\SurveyQuestions";
//        File newDir = createNewDirectory(baseDir);
//
//        saveTQuestions(newDir.getAbsolutePath());
//        savePolarQuestions(newDir.getAbsolutePath());
//        saveMCQs(newDir.getAbsolutePath());
//
//        SubmitL.setText("Saved");
//    }
//
//    private File createNewDirectory(String baseDir) {
//        File baseDirectory = new File(baseDir);
//        if (!baseDirectory.exists()) {
//            baseDirectory.mkdirs();
//        }
//
//        int nextNumber = 1;
//        try (Stream<Path> paths = Files.list(Paths.get(baseDir))) {
//            nextNumber = paths.filter(Files::isDirectory)
//                    .map(path -> path.getFileName().toString())
//                    .filter(name -> name.matches("\\d+SurveyQuestion"))
//                    .map(name -> Integer.parseInt(name.replace("SurveyQuestion", "")))
//                    .max(Comparator.naturalOrder())
//                    .orElse(0) + 1;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        File newDir = new File(baseDir, nextNumber + "SurveyQuestion");
//        if (!newDir.exists()) {
//            newDir.mkdirs();
//        }
//        return newDir;
//    }
//
//    @FXML
//    public void saveTQuestions(String dirPath) {
//        saveQuestionsToCSV("tquestion", dirPath + "/tquestions.csv");
//    }
//
//    @FXML
//    public void saveMCQs(String dirPath) {
//        saveQuestionsToCSV("mcq", dirPath + "/mcq.csv");
//    }
//
//    @FXML
//    public void savePolarQuestions(String dirPath) {
//        saveQuestionsToCSV("polar", dirPath + "/polar.csv");
//    }
//
//    private void saveQuestionsToCSV(String questionPrefix, String fileName) {
//        List<String> questions = new ArrayList<>();
//        for (Node node : dynamicBox.getChildren()) {
//            if (node instanceof TextField && node.getId() != null && node.getId().startsWith(questionPrefix)) {
//                questions.add(((TextField) node).getText());
//            }
//        }
//
//        try (FileWriter writer = new FileWriter(fileName)) {
//            for (String question : questions) {
//                writer.write(question + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    @FXML
//    public void loadStage(String sceneName) throws IOException{
//        try {
//            System.out.println("Loading FXML file: " + sceneName);
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
//            Parent root = fxmlLoader.load();
//            Stage stage = (Stage) userINFO.getScene().getWindow();
//            stage.setScene(new Scene (root));
//            stage.show();
//        }catch (IOException e){
//            userINFO.setText("Failed to load scene: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }