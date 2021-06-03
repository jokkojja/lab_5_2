package com.company.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.company.model.People;
import com.company.model.PeopleDAO;

import java.awt.*;
import java.sql.SQLException;

public class SortAndSearchAndSelectAllController extends PeopleDAO {
    @FXML
    private TextField Search;

    @FXML
    private TableColumn<People, Integer> ID;

    @FXML
    private TableColumn<People, String> LastName;

    @FXML
    private TableColumn<People, String> firstName;

    @FXML
    private TableColumn<People, Integer> Age;

    @FXML
    private TableView peopleTable;


    //    private void SelectAll (ActiveEvent event) throws SQLException, ClassNotFoundException{
    @FXML
    private void initialize() throws Exception{

        ID.setCellValueFactory(cellData -> cellData.getValue().getPersonId().asObject());
        LastName.setCellValueFactory(cellData -> cellData.getValue().geLastName());
        firstName.setCellValueFactory(cellData -> cellData.getValue().getPersonFirstName());
        Age.setCellValueFactory(cellData -> cellData.getValue().getPersonAge().asObject());
        ObservableList<People> peoplist = PeopleDAO.getAllRecords();
        populateTable(peoplist);

    }

    private void populateTable(ObservableList<People> peoplist) {


        peopleTable.setItems(peoplist);


    }

}
