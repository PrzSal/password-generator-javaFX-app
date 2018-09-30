package com.przcode.controller;

import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MenuController {

    @FXML
    private MenuBar menuBar;

    @FXML
    public void saveFile() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(menuBar.getScene().getWindow());

        if (file != null) {
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(file);
                fileWriter.write(ContentController.contentController.passwordField.getText());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void configPrint() {
        TextField fullPasswordField = ContentController.contentController.passwordField;
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            boolean showDialog = job.showPrintDialog(menuBar.getScene().getWindow());
            if (showDialog) {
                boolean success = job.printPage(fullPasswordField);
                if (success) {
                    job.endJob();
                }
            }
        }
    }
}
