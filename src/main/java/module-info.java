module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires lombok;

    opens com.example.javafxdemo to javafx.fxml;
    exports com.example.javafxdemo;
}