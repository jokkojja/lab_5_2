package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.company.Util.DBUtil;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("D:\\intelej-project\\lab_5_2\\src\\com\\company\\Controller\\SortAndSearchAndSelectAllForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){

//        final String url = "jdbc:sqlite:C:\\SQLiteStudio\\laba5.db";
//        DBUtil test = new DBUtil();
//        test.connect(url);

        launch(args);

    }
}
