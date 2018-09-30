package com.przcode.controller;

import com.przcode.model.PasswordModel;
import com.przcode.service.PasswordGeneratorService;
import com.przcode.service.PasswordGeneratorServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ContentController implements Initializable {

    @FXML
    private CheckBox isDigit;
    @FXML
    private CheckBox isLowerCase;
    @FXML
    private CheckBox isUpperCase;
    @FXML
    TextField passwordField;
    @FXML
    private TextField lengthPassword;
    @FXML
    private CheckBox isSpecialChar;

    public static ContentController contentController;

    @FXML
    public void createPasswordModel() {
        boolean isDigitInPass = isDigit.isSelected();
        boolean isLowerCaseInPass = isLowerCase.isSelected();
        boolean isUpperCaseInPass = isUpperCase.isSelected();
        boolean isSpecialCharInPass = isSpecialChar.isSelected();
        Long lengthPass = new Long(lengthPassword.getCharacters().toString());
        PasswordModel passwordModel = new PasswordModel(lengthPass, isLowerCaseInPass, isUpperCaseInPass, isSpecialCharInPass, isDigitInPass);
        PasswordGeneratorService pGS = new PasswordGeneratorServiceImpl();
        passwordModel = pGS.addPassword(passwordModel);
        passwordField.setText(passwordModel.getPassword());
    }

    @FXML
    public void validateLengthPass () {

        lengthPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                lengthPassword.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contentController = this;
    }
}
