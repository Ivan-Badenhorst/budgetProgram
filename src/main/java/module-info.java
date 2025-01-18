module com.personal.budget {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens com.personal.budget to javafx.fxml;
    exports com.personal.budget;
    exports com.personal.budget.gui;
    opens com.personal.budget.gui to javafx.fxml;
}