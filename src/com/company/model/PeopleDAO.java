package com.company.model;

import com.company.Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDAO {

    public static ObservableList<People> getAllRecords() throws ClassNotFoundException, SQLException{

        String sql = "Select * from people";
        ResultSet rsSet = DBUtil.Execute(sql);
        ObservableList<People> personList = getPeopleObjects(rsSet);


//        try {
//
//            return personList;
//
//
//        }
//
//        catch (SQLException e)
//        {
//
//            e.printStackTrace();
//
//        }
        return personList;

    }

    private static ObservableList<People> getPeopleObjects(ResultSet rsSet)throws ClassNotFoundException, SQLException {
        ObservableList<People> personList = FXCollections.observableArrayList();

        try {

            while(rsSet.next())
            {
                People person = new People();
                person.setId(rsSet.getInt("id"));
                person.setFirstName(rsSet.getString("first_name"));
                person.setLastName(rsSet.getString("last_name"));
                person.setAge(rsSet.getInt("age"));
                personList.add(person);

            }
            return personList;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return personList;

    }

}
