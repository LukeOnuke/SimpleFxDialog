package com.lukeonuke.simplefxdialog;

import org.junit.jupiter.api.Test;


public class DialogTest {
    @Test
    public void run(){
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            TestApp.main(new String[]{});
        }
    }
}
