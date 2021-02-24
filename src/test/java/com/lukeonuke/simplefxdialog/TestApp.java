package com.lukeonuke.simplefxdialog;

import com.lukeonuke.simplefxdialog.img.DialogImage;
import javafx.application.Application;
import javafx.stage.Stage;

public class TestApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Dialog.okDialog(DialogImage.INFO_EXCLAMATION, "Title", "Text");
    }
}
