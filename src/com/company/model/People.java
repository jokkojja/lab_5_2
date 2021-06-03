package com.company.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class People {

    private IntegerProperty idProperty;
    private StringProperty firstNameProperty;
    private StringProperty lastNameProperty;
    private IntegerProperty ageProperty;

    public People()
    {
        this.idProperty = new SimpleIntegerProperty();
        this.lastNameProperty = new SimpleStringProperty();
        this.firstNameProperty = new SimpleStringProperty();
        this.ageProperty = new SimpleIntegerProperty();
    }

    //getter setter for id
    public int getId(){

        return idProperty.get();

    }

    public void setId(int id)
    {

        this.idProperty.set(id);

    }

    public IntegerProperty getPersonId(){
        return idProperty;
    }

    //getter setter for last name
    public String getLastName(){

        return lastNameProperty.get();

    }

    public void setLastName(String LastName)
    {

        this.lastNameProperty.set(LastName);

    }

    public StringProperty geLastName(){
        return lastNameProperty;
    }

    //getter setter for first name
    public String getFirstName(){

        return firstNameProperty.get();

    }

    public void setFirstName(String FirstName)
    {

        this.firstNameProperty.set(FirstName);

    }

    public StringProperty getPersonFirstName(){
        return firstNameProperty;
    }

    //getter setter for age
    public int getAge(){

        return ageProperty.get();

    }

    public void setAge(int age)
    {

        this.ageProperty.set(age);

    }

    public IntegerProperty getPersonAge(){
        return ageProperty;
    }

}