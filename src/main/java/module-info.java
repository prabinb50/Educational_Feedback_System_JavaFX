module org.example.groupproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;


    opens org.example.groupproject to javafx.fxml;
    exports org.example.groupproject;
}