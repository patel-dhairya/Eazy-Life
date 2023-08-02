module com.personal.easylife {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires jdk.jsobject;


    opens com.personal.easylife to javafx.fxml;
    exports com.personal.easylife;
}