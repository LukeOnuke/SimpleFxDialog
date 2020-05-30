/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplefxdialog;

import java.util.concurrent.atomic.AtomicInteger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author lukak
 */
public class Dialog {

    private static String imageResovler(int image) {
        String imageName;

        switch (image) {

            case 0:
                imageName = "ERROR.png";
                break;

            case 1:
                imageName = "WARNING.png";
                break;

            case 2:
                imageName = "INFO_BLUE.png";
                break;

            case 3:
                imageName = "INFO_BLUE_EXCLAMATION.png";
                break;

            case 4:
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
     * @param dialogImage The integer indentifier of the image that is displayed
     * on the dialog, for simpler usage use the class DialogImage
     * @param title The title of the dialog
     * @param text The text displayed in the dialog
     * @return A boolean that is true if the user pressed ok and false if the
     * user exited or pressed cancel
     */
    public static boolean okCancelDialog(int dialogImage, String title, String text) {
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
        Image img = new Image(simplefxdialog.img.DialogImage.class.getResourceAsStream(imageResovler(dialogImage)));
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
     * @param dialogImage The integer indentifier of the image that is displayed
     * on the dialog, for simpler usage use the class DialogImage
     * @param title The title of the dialog
     * @param text The text displayed in the dialog
     * @return A boolean that is true if the user pressed ok and false if the
     * user exited
     */
    public static boolean okDialog(int dialogImage, String title, String text) {
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
        Image img = new Image(simplefxdialog.img.DialogImage.class.getResourceAsStream(imageResovler(dialogImage)));
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
     * @param dialogImage The integer indentifier of the image that is displayed
     * on the dialog, for simpler usage use the class DialogImage
     * @param title The title of the dialog
     * @param text The text displayed in the dialog
     * @return String of what has been typed into the message box, if it is
     * canceled it returns null.
     */
    public static String formDialog(int dialogImage, String title, String text) {
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
        Image img = new Image(simplefxdialog.img.DialogImage.class.getResourceAsStream(imageResovler(dialogImage)));
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
     * @param dialogImage The integer indentifier of the image that is displayed
     * on the dialog, for simpler usage use the class DialogImage
     * @param buttonText A array of names for the buttons
     * @param title The title of the dialog
     * @param text The text displayed in the dialog
     * @return A int that is 1 if the user pressed the right button 2 if the user pressed the left button and 0 if the user exited
     */
    public static int custom2ButtonDialog(int dialogImage, String[] buttonText, String title, String text) {
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
        Image img = new Image(simplefxdialog.img.DialogImage.class.getResourceAsStream(imageResovler(dialogImage)));
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

}
