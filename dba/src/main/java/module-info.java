module tech.altier.crudassignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.j;
    requires java.sql;

    opens tech.altier.crudassignment to javafx.fxml;
    exports tech.altier.crudassignment;
}