/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplefxdialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import simplefxdialog.img.DialogImage;

/**
 *
 * @author lukak
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String[] bb = new String[2];
        bb[0] = "aaaaa";
        bb[1] = "eeeee";
        System.out.println(Dialog.custom2ButtonDialog(DialogImage.error, bb, "aaaaaaaaaaa", "bbbbbbbbbbbbbbbb"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
