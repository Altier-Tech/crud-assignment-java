package tech.altier.crudassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import tech.altier.Main;
import tech.altier.dba.Connector;

public class MainController {
    @FXML
    private TableView tableView;

    @FXML
    public void initialize() {
        // need to populate the table view with the items from the database

        // query the database
        Connector.getAllItems();

        // create an array of items

        // populate the table view with the items

    }

    public void handleExit(ActionEvent actionEvent) {
    }

    public void handleAbout(ActionEvent actionEvent) {
    }

    public void handleCreate(ActionEvent actionEvent) {
    }

    public void handleRead(ActionEvent actionEvent) {
    }

    public void handleUpdate(ActionEvent actionEvent) {
    }

    public void handleDelete(ActionEvent actionEvent) {
    }
}