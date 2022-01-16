module com.team97.team_97_project_ {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.team97.team97project to javafx.fxml;
    exports com.team97.team97project;
}