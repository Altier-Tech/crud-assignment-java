package tech.altier.crudassignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import tech.altier.dba.Connector;
import tech.altier.dba.Item;

import java.util.Collections;

public class MainController {
    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item, Integer> idColumn;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, Integer> quantityColumn;
    @FXML
    private TableColumn<Item, Double> priceColumn;

    private ObservableList<Item> itemList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        populate();
    }

    private void populate() {
        // query the database
        Item[] items = Connector.getAllItems();

        // populate the table view with the items
        assert items != null;
        Collections.addAll(itemList, items);

        tableView.setItems(itemList);
    }

    public void handleExit(ActionEvent actionEvent) {
        Connector.closeConnection();
        MainApplication.getStage().close();
    }

    public void handleAbout(ActionEvent actionEvent) {
    }
}