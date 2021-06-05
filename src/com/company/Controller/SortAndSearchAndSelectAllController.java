package com.company.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.company.model.People;
import com.company.model.PeopleDAO;
import javafx.scene.control.TextField;

import java.awt.*;
import java.sql.SQLException;

public class SortAndSearchAndSelectAllController extends PeopleDAO {
    public javafx.scene.control.TextField SearchPerID;
    public TextField SearchPerAge;

    @FXML
    private TextField idForDelete;

    @FXML
    private TextField idForUpdate;

    @FXML
    private TextField ageForApdate;

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtAge;
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

     @FXML
     private void insert(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

         PeopleDAO.insert(txtFirstName.getText(), txtLastName.getText(), Integer.parseInt(txtAge.getText()));

    }

    @FXML
    private void update(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{

        try {

            PeopleDAO.update(Integer.parseInt(idForUpdate.getText()), Integer.parseInt(ageForApdate.getText()));

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void delete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{

        try {

            PeopleDAO.delete(Integer.parseInt(idForDelete.getText()));

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

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
    @FXML
    public void searchPersonById(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{


       ObservableList<People> list =  PeopleDAO.searchPersonById(SearchPerID.getText());
       populateTable(list);
    }

    @FXML
    public void searchPersonByAge(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{


        ObservableList<People> list =  PeopleDAO.searchPersonByAge(SearchPerAge.getText());
        populateTable(list);
    }
    @FXML
    public void SortByID(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{


        ObservableList<People> list =  PeopleDAO.SortByID();
        populateTable(list);
    }
    @FXML
    public void SortByFirstName(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{


        ObservableList<People> list =  PeopleDAO.SortByFirstName();
        populateTable(list);
    }
    @FXML
    public void SortByLastName(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{


        ObservableList<People> list =  PeopleDAO.SortByLastName();
        populateTable(list);
    }
    @FXML
    public void SortByAge(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{


        ObservableList<People> list =  PeopleDAO.SortByAge();
        populateTable(list);
    }



}
