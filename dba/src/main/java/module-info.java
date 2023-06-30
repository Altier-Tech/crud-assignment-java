module tech.altier.crudassignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens tech.altier.crudassignment to javafx.fxml;
    exports tech.altier.crudassignment;
}