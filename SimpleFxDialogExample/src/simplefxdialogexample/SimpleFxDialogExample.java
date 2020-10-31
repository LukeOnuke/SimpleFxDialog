/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplefxdialogexample;

import com.lukeonuke.simplefxdialog.Dialog;
import com.lukeonuke.simplefxdialog.exception.NotSupportedException;
import com.lukeonuke.simplefxdialog.img.DialogImage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.lukeonuke.simplefxdialog.tray.TrayDialog;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lukak
 */
public class SimpleFxDialogExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Press me lol");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Pressed!");
            try {
                TrayDialog.displayTrayNotification(DialogImage.INFO_EXCLAMATION, "Title", "Text text text", TrayIcon.MessageType.ERROR);
            } catch (AWTException ex) {
                Logger.getLogger(SimpleFxDialogExample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotSupportedException ex) {
                Logger.getLogger(SimpleFxDialogExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Example!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
