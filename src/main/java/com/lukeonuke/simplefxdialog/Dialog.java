/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lukeonuke.simplefxdialog;

import java.util.concurrent.atomic.AtomicInteger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.lukeonuke.simplefxdialog.img.DialogImage;

/**
 *
 * @author lukak
 */
public class Dialog {

    public static String imageResovler(DialogImage image) {
        String imageName;
        
        switch (image) {
            case ERROR:
                imageName = "ERROR.png";
                break;
            case WARNING:
                imageName = "WARNING.png";
                break;
            case INFO:
                imageName = "INFO_BLUE.png";
                break;
            case INFO_EXCLAMATION:
                imageName = "INFO_BLUE_EXCLAMATION.png";
                break;
            case INFO_QUESTION:
                imageName = "INFO_BLUE_QUESTION.png";
                break;
            default:
                imageName = "ERROR.png";
                break;
        }
        return imageName;
    }

    /**
     * Shows a dialog with the options of ok and cancel
     *
     * @param dialogImage The enum indentifier of the image that is displayed
     * on the dialog, for simpler usage use the class DialogImage
     * @param title The title of the dialog
     * @param text The text displayed in the dialog
     * @return A boolean that is true if the user pressed ok and false if the
     * user exited or pressed cancel
     */
    public static boolean okCancelDialog(DialogImage dialogImage, String title, String text) {
        //setup return
        AtomicInteger state = new AtomicInteger(0);

        StackPane r = new StackPane();

        AnchorPane anchorPane;
        ImageView imageView;
        Button ok;
        Button cancel;
        TextFlow tf;

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        ok = new Button();
        cancel = new Button();
        tf = new TextFlow();

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);
        anchorPane.setPrefHeight(162.0);
        anchorPane.setPrefWidth(420.0);

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(64.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(20.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        ok.setDefaultButton(true);
        ok.setLayoutX(21.0);
        ok.setLayoutY(161.0);
        ok.setMnemonicParsing(false);
        ok.setText("Ok");

        cancel.setLayoutX(376.0);
        cancel.setLayoutY(161.0);
        cancel.setMnemonicParsing(false);
        cancel.setText("Cancel");

        tf.setLayoutX(159.0);
        tf.setLayoutY(20.0);
        tf.setPrefHeight(128.0);
        tf.setPrefWidth(275.0);

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(ok);
        anchorPane.getChildren().add(cancel);
        anchorPane.getChildren().add(tf);
        r.getChildren().add(anchorPane);

        //set the variables lel
        //text itself
        Text textF = new Text(text);

        textF.setFill(Color.BLACK);

        tf.getChildren().add(textF);

        //set image
        Image img = new Image(com.lukeonuke.simplefxdialog.img.DialogImage.class.getResourceAsStream(imageResovler(dialogImage)));
        imageView.imageProperty().set(img);

        //title and declare scene
        Stage stage = new Stage();
        stage.setTitle(title);
        //new stage show
        stage.setScene(new Scene(r, 448, 204));

        final Stage fstage = stage;
        //setup OnActionEvent's
        EventHandler<ActionEvent> okButtonPressed = (ActionEvent e) -> {
            state.set(1);
            fstage.close();
        };
        EventHandler<ActionEvent> cancelButtonPressed = (ActionEvent e) -> {
            state.set(0);
            fstage.close();
        };

        ok.setOnAction(okButtonPressed);
        cancel.setOnAction(cancelButtonPressed);

        double height;
        height = 234.0;
        double width;
        width = 450.0;

        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setMinHeight(height);
        stage.setMinWidth(width);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);

        //show stage
        stage.showAndWait();

        if (state.get() == 1) {
            return true;
        }
        return false;
    }

    /**
     * Shows a dialog with the option of ok
     *
     * @param dialogImage The enum indentifier of the image that is displayed
     * on the dialog, for simpler usage use the class DialogImage
     * @param title The title of the dialog
     * @param text The text displayed in the dialog
     * @return A boolean that is true if the user pressed ok and false if the
     * user exited
     */
    public static boolean okDialog(DialogImage dialogImage, String title, String text) {
        //setup return
        AtomicInteger state = new AtomicInteger(0);

        double height = 234;
        double width = 450;

        StackPane r = new StackPane();

        AnchorPane anchorPane;
        ImageView imageView;
        Button ok;
        TextFlow tf;

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        ok = new Button();
        tf = new TextFlow();

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);
        anchorPane.setPrefHeight(162.0);
        anchorPane.setPrefWidth(420.0);

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(64.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(20.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        ok.setDefaultButton(true);
        ok.setLayoutX(21.0);
        ok.setLayoutY(161.0);
        ok.setMnemonicParsing(false);
        ok.setText("Ok");

        tf.setLayoutX(159.0);
        tf.setLayoutY(20.0);
        tf.setPrefHeight(128.0);
        tf.setPrefWidth(275.0);

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(ok);
        anchorPane.getChildren().add(tf);
        r.getChildren().add(anchorPane);

        //set the variables lel
        //text itself
        Text textF = new Text(text);

        textF.setFill(Color.BLACK);

        tf.getChildren().add(textF);

        //set image
        Image img = new Image(com.lukeonuke.simplefxdialog.img.DialogImage.class.getResourceAsStream(imageResovler(dialogImage)));
        imageView.imageProperty().set(img);

        //title and declare scene
        Stage stage = new Stage();
        stage.setTitle(title);
        //new stage show
        stage.setScene(new Scene(r, width, height));

        final Stage fstage = stage;
        //setup OnActionEvent's
        EventHandler<ActionEvent> okButtonPressed = (ActionEvent e) -> {
            state.set(1);
            fstage.close();
        };

        /*        //dynamic sizeing
        textF.applyCss();
        AnchorPane.setBottomAnchor(ok, 20.0);
        double heightDiff = anchorPane.heightProperty().get() - 100;
        stage.setHeight(tf.heightProperty().get() + heightDiff + textF.getBoundsInLocal().getHeight());*/
        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setMinHeight(height);
        stage.setMinWidth(width);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);
        //set action
        ok.setOnAction(okButtonPressed);

        //show stage
        stage.showAndWait();

        if (state.get() == 1) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param dialogImage The enum indentifier of the image that is displayed
     * on the dialog, for simpler usage use the class DialogImage
     * @param title The title of the dialog
     * @param text The text displayed in the dialog
     * @return String of what has been typed into the message box, if it is
     * canceled it returns null.
     */
    public static String formDialog(DialogImage dialogImage, String title, String text) {
        //setup return
        AtomicInteger state = new AtomicInteger(0);

        StackPane r = new StackPane();

        AnchorPane anchorPane;
        ImageView imageView;
        Button ok;
        Button cancel;
        TextFlow tf;
        TextField imf; //IMput Field

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        ok = new Button();
        cancel = new Button();
        tf = new TextFlow();
        imf = new TextField();

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);
        anchorPane.setPrefHeight(162.0);
        anchorPane.setPrefWidth(420.0);

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(64.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(20.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        ok.setDefaultButton(true);
        ok.setLayoutX(21.0);
        ok.setLayoutY(161.0);
        ok.setMnemonicParsing(false);
        ok.setText("Ok");

        cancel.setLayoutX(376.0);
        cancel.setLayoutY(161.0);
        cancel.setMnemonicParsing(false);
        cancel.setText("Cancel");

        tf.setLayoutX(159.0);
        tf.setLayoutY(20.0);
        tf.setPrefHeight(128.0);
        tf.setPrefWidth(275.0);

        imf.setLayoutX(100.5);
        imf.setLayoutY(161.0);
        imf.setPrefWidth(250.0);

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(ok);
        anchorPane.getChildren().add(cancel);
        anchorPane.getChildren().add(tf);
        anchorPane.getChildren().add(imf);
        r.getChildren().add(anchorPane);

        //set the variables lel
        //text itself
        Text textF = new Text(text);

        textF.setFill(Color.BLACK);

        tf.getChildren().add(textF);

        //set image
        Image img = new Image(com.lukeonuke.simplefxdialog.img.DialogImage.class.getResourceAsStream(imageResovler(dialogImage)));
        imageView.imageProperty().set(img);

        //title and declare scene
        Stage stage = new Stage();
        stage.setTitle(title);
        //new stage show
        stage.setScene(new Scene(r, 448, 204));

        final Stage fstage = stage;
        //setup OnActionEvent's
        EventHandler<ActionEvent> okButtonPressed = (ActionEvent e) -> {
            state.set(1);
            fstage.close();
        };
        EventHandler<ActionEvent> cancelButtonPressed = (ActionEvent e) -> {
            state.set(0);
            fstage.close();
        };

        ok.setOnAction(okButtonPressed);
        cancel.setOnAction(cancelButtonPressed);

        double height;
        height = 234.0;
        double width;
        width = 450.0;

        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setMinHeight(height);
        stage.setMinWidth(width);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);

        //show stage
        stage.showAndWait();

        if (state.get() == 1) {
            return imf.getText();
        } else {
            return null;
        }
    }

    /**
     * Shows a dialog with the options of ok and cancel
     *
     * @param dialogImage The enum indentifier of the image that is displayed
     * on the dialog, for simpler usage use the class DialogImage
     * @param buttonText A array of names for the buttons
     * @param title The title of the dialog
     * @param text The text displayed in the dialog
     * @return A int that is 1 if the user pressed the right button 2 if the
     * user pressed the left button and 0 if the user exited
     */
    public static int custom2ButtonDialog(DialogImage dialogImage, String[] buttonText, String title, String text) {
        //setup return
        AtomicInteger state = new AtomicInteger(0);

        StackPane r = new StackPane();

        AnchorPane anchorPane;
        ImageView imageView;
        Button button1;
        Button button2;
        TextFlow tf;

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        button1 = new Button();
        button2 = new Button();
        tf = new TextFlow();

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);
        anchorPane.setPrefHeight(162.0);
        anchorPane.setPrefWidth(420.0);

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(64.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(20.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        button1.setDefaultButton(true);
        button1.setLayoutX(21.0);
        button1.setLayoutY(161.0);
        button1.setMnemonicParsing(false);
        button1.setText("Ok");

        button2.setLayoutX(376.0);
        button2.setLayoutY(161.0);
        button2.setMnemonicParsing(false);
        button2.setText("Cancel");

        tf.setLayoutX(159.0);
        tf.setLayoutY(20.0);
        tf.setPrefHeight(128.0);
        tf.setPrefWidth(275.0);

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(button1);
        anchorPane.getChildren().add(button2);
        anchorPane.getChildren().add(tf);
        r.getChildren().add(anchorPane);

        //set the variables lel
        //text itself
        Text textF = new Text(text);

        textF.setFill(Color.BLACK);

        tf.getChildren().add(textF);

        //set image
        Image img = new Image(com.lukeonuke.simplefxdialog.img.DialogImage.class.getResourceAsStream(imageResovler(dialogImage)));
        imageView.imageProperty().set(img);

        //title and declare scene
        Stage stage = new Stage();
        stage.setTitle(title);
        //new stage show
        stage.setScene(new Scene(r, 448, 204));

        final Stage fstage = stage;
        //setup OnActionEvent's
        EventHandler<ActionEvent> okButtonPressed = (ActionEvent e) -> {
            state.set(1);
            fstage.close();
        };
        EventHandler<ActionEvent> cancelButtonPressed = (ActionEvent e) -> {
            state.set(2);
            fstage.close();
        };

        button1.setOnAction(okButtonPressed);
        button2.setOnAction(cancelButtonPressed);

        button1.setText(buttonText[0]);
        button2.setText(buttonText[1]);

        double height;
        height = 234.0;
        double width;
        width = 450.0;

        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setMinHeight(height);
        stage.setMinWidth(width);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);

        //show stage
        stage.showAndWait();

        return state.get();
    }

    /**
     * Shows a about box type dialog with a ok button. To leave out a field in the about box just set the parameter to null.
     * 
     * @param image The image displayed in the imageView. Image size 200x200 .
     * @param titleText Title text. To leave out this field set this parameter to null.
     * @param authorText The name of the author or the authors corporations. To leave out this field set this parameter to null.
     * @param programText The name of the program. To leave out this field set this parameter to null.
     * @param licenceText The name of the licence used. To leave out this field set this parameter to null.
     * @param sofrwareUsedText Software used (used when software licences require mentioning of usage). To leave out this field set this parameter to null.
     */
    public static void aboutDialog(Image image, String titleText, String authorText, String programText, String licenceText, String sofrwareUsedText) {
        /*
        * |============================================================|
        * |setup stage (AKA the black box, do not tuch unless necesary)|
        * |============================================================|
        */
        AnchorPane anchorPane;
        StackPane r = new StackPane();

        ImageView imageView;
        Label about;
        Label author;
        Label program;
        Label licence;
        Label softwareu;
        Button button;

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        about = new Label();
        author = new Label();
        program = new Label();
        licence = new Label();
        softwareu = new Label();
        button = new Button();

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setMaxHeight(-1.0);
        anchorPane.setMaxWidth(-1.0);
        anchorPane.setPrefHeight(304.0);
        anchorPane.setPrefWidth(640.0);

        imageView.setFitHeight(200.0);
        imageView.setFitWidth(200.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        about.setLayoutX(208.0);
        about.setLayoutY(14.0);
        about.setText("About");
        about.setTextFill(javafx.scene.paint.Color.valueOf("#808080"));
        about.setFont(new Font(19.0));

        author.setLayoutX(208.0);
        author.setLayoutY(52.0);
        //set text if there is any
        if (authorText != null) {
            author.setText("Author : " + authorText);
        }

        program.setLayoutX(208.0);
        program.setLayoutY(81.0);
        //set text if there is any
        if (programText != null) {
            program.setText("Program : " + programText);
        }

        licence.setLayoutX(208.0);
        licence.setLayoutY(111.0);
        //set text if there is any
        if (licenceText != null) {
            licence.setText("Licence : " + licenceText);
        }

        softwareu.setLayoutX(208.0);
        softwareu.setLayoutY(140.0);
        //set text if there is any
        if (sofrwareUsedText != null) {
            softwareu.setText("Software Used : " + sofrwareUsedText);
        }

        button.setDefaultButton(true);
        button.setLayoutX(496.0);
        button.setLayoutY(159.0);
        button.setMnemonicParsing(false);
        button.setText("Ok");

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(about);
        anchorPane.getChildren().add(author);
        anchorPane.getChildren().add(program);
        anchorPane.getChildren().add(licence);
        anchorPane.getChildren().add(softwareu);
        anchorPane.getChildren().add(button);
        r.getChildren().add(anchorPane);
        
        /*
        * |==================|
        * | Setup stage done | 
        * |==================|
        */
        
        //title and declare scene
        Stage stage = new Stage();
        stage.setTitle(titleText);
        //new stage show
        stage.setScene(new Scene(r, 545.0, 200.0));

        //Make it not resizable and make it not display a icon
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);

        //Set the image
        imageView.setImage(image);

        final Stage fstage = stage;
        //setup OnActionEvent
        EventHandler<ActionEvent> okButtonPressed = (ActionEvent e) -> {
            fstage.close();
        };
        button.setOnAction(okButtonPressed);

        stage.showAndWait();
    }

}
