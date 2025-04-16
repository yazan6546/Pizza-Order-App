/*
Name : yazan AbuAlown
ID : 1210145
Lecture Section : 3
Lab Section : 4L
 */


package com.example.project_1210145.pizzaapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {

    //overrides the start method in the application class
    @Override
    public void start(Stage stage) throws Exception {


        //creates the custom PizzaPane Object
        PizzaPane pane = new PizzaPane();

        //creates a scene and sets its pane, along with its inital width and height
        Scene scene = new Scene(pane, 424, 356);

        //sets the stage title
        stage.setTitle("Pizza Shop");

        //sets the scene in the stahe
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


