package tech.altier.crudassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import tech.altier.dba.Connector;
import tech.altier.dba.Item;

public class MainController {
    @FXML
    private TableView tableView;

    @FXML
    public void initialize() {
        populate();
    }

    private void populate() {
        // query the database
        Item[] items = Connector.getAllItems();

        // populate the table view with the items
        for (Item item : items) {
            tableView.getItems().add(item); // TODO: fix this
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Connector.closeConnection();
        MainApplication.getStage().close();
    }

    public void handleAbout(ActionEvent actionEvent) {
    }
}