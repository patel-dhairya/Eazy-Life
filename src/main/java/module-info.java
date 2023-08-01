module eazyLife {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires jdk.jsobject;

    opens com.jdojo.intro to javafx.graphics, javafx.base;
}