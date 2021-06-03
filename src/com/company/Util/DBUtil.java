package com.company.Util;

import java.sql.*;
import com.sun.rowset.CachedRowSetImpl;



public class DBUtil {

    private static final String JDBC_DRIVER = "org.sqlite.JDBC";

    private static Connection connection = null;

    private static final String url = "jdbc:sqlite:C:\\SQLiteStudio\\laba5.db";

    //connect to database
    public static void connect(String url) {

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //disconnect
    public static void disconnect() {

        try {
            connection.close();
            System.out.println("Connection close");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //for insert, delete and update operation

    public static void ExecuteQuery(String sqlStatement) throws SQLException {

        Statement statement = null;

        try {
            connect(url);
            connection.createStatement();
            statement.executeUpdate(sqlStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            disconnect();
        }
    }

    //for retriving records from database
    public static ResultSet Execute(String SqlQuery) throws ClassNotFoundException, SQLException {

        Statement statement = null;
        ResultSet res = null;
        CachedRowSetImpl set = null;

        try {
            connect(url);
            statement = connection.createStatement();
            res = statement.executeQuery(SqlQuery);
            set = new CachedRowSetImpl();
            set.populate(res);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }

            if (statement != null) {
                statement.close();
            }

            disconnect();

        }
        return set;
    }
}
