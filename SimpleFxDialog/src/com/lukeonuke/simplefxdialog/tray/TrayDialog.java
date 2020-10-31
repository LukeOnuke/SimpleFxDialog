/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lukeonuke.simplefxdialog.tray;

import com.lukeonuke.simplefxdialog.exception.NotSupportedException;
import com.lukeonuke.simplefxdialog.Dialog;
import com.lukeonuke.simplefxdialog.img.DialogImage;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 * Tray dialogs and Notifications. Mainly called notifications.
 * @author lukak
 */
public class TrayDialog {

     /**
     * Display native Tray Notification, but with system icons, use MessageType.
     * <b>Beware, since it creates a notification it will run even though its "closed" (JavaFx known issue) so use a on close request <code>System.exit(0);</code></b>
     * @param dialogImage The icon, used for awt reasons.
     * @param title Title.
     * @param text The text in it.
     * @param messageType The type of message, makes the coresponding sound and places the system default icon.
     * @throws AWTException General exception.
     * @throws NotSupportedException When system tray is not supported.
     */
    public static void displayTrayNotification(DialogImage dialogImage, String title, String text, MessageType messageType) throws AWTException, NotSupportedException {
        if (SystemTray.isSupported()) {
            SystemTray systemTray = SystemTray.getSystemTray();
            TrayIcon trayIcon = new TrayIcon(SwingFXUtils.fromFXImage(new Image(DialogImage.class.getResourceAsStream(Dialog.imageResovler(dialogImage))), null), title);

            //Set tooltip text for the tray icon
            trayIcon.setToolTip(title);
            systemTray.add(trayIcon);

            trayIcon.displayMessage(title, text, messageType);
        } else {
            throw new NotSupportedException("System tray not supported.");
        }
    }
}
