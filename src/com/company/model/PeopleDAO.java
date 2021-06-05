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
        return personList;

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

    public static ObservableList<People> searchPersonById(String personID) throws ClassNotFoundException, SQLException{

        String sql = "select * from people where id = " + personID;

        try {

            ResultSet res = DBUtil.Execute(sql);
           ObservableList<People> list =  getPeopleObjects(res);
           return list;

        }catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }

    }

    public static ObservableList<People> searchPersonByAge(String personAge) throws ClassNotFoundException, SQLException{

        String sql = "select * from people where age = " + personAge;

        try {

            ResultSet res = DBUtil.Execute(sql);
            ObservableList<People> list =  getPeopleObjects(res);
            return list;

        }catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }

    }
    public static ObservableList<People> SortByID() throws ClassNotFoundException, SQLException{

        String sql = "select * from people order by id" ;

        try {

            ResultSet res = DBUtil.Execute(sql);
            ObservableList<People> list =  getPeopleObjects(res);
            return list;

        }catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }

    }
    public static ObservableList<People> SortByLastName() throws ClassNotFoundException, SQLException{

        String sql = "select * from people order by last_name" ;

        try {

            ResultSet res = DBUtil.Execute(sql);
            ObservableList<People> list =  getPeopleObjects(res);
            return list;

        }catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }

    }
    public static ObservableList<People> SortByFirstName() throws ClassNotFoundException, SQLException{

        String sql = "select * from people order by first_name" ;

        try {

            ResultSet res = DBUtil.Execute(sql);
            ObservableList<People> list =  getPeopleObjects(res);
            return list;

        }catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }

    }
    public static ObservableList<People> SortByAge() throws ClassNotFoundException, SQLException{

        String sql = "select * from people order by age" ;

        try {

            ResultSet res = DBUtil.Execute(sql);
            ObservableList<People> list =  getPeopleObjects(res);
            return list;

        }catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }

    }


}
