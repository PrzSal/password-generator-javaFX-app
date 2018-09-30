package com.przcode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
        root.setTop(menuLoader.load());
        FXMLLoader sampleLoader = new FXMLLoader(getClass().getResource("/content.fxml"));
        root.setCenter(sampleLoader.load());
        primaryStage.setTitle("Password Generator");
        Scene scene = new Scene(root, 550, 400);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("/style.css");
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }
    public static void main( String[] args )
    {
        launch(args);
    }
}
