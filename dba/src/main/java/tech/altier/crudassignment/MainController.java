package tech.altier.crudassignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import tech.altier.dba.Connector;
import tech.altier.dba.Item;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Objects;

public class MainController {
    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableColumn<Item, String> idColumn;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, Integer> quantityColumn;
    @FXML
    private TableColumn<Item, Double> priceColumn;

    @FXML
    public void initialize() throws SQLException {
        populate();
    }

    private void populate() throws SQLException {
        Item[] items = Connector.getAllItems();

        idColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));

        for (int i = 0; i< Objects.requireNonNull(items).length; i++) {
            tableView.getItems().set(i, items[i]);
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Connector.closeConnection();
        MainApplication.getStage().close();
    }

    public void handleAbout(ActionEvent actionEvent) {
    }
}