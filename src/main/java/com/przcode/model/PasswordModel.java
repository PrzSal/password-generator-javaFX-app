package com.przcode.model;

import javafx.beans.DefaultProperty;

public class PasswordModel {

    private String password;
    private Long passwordLength;
    private Boolean isLowerCase;
    private Boolean isUpperCase;
    private Boolean isMixLowerAndUpperCase;
    private Boolean isSpecialCharacter;
    private Boolean isDigit;

    public PasswordModel(Long passwordLength, Boolean isLowerCase, Boolean isUpperCase, Boolean isMixLowerAndUpperCase, Boolean isSpecialCharacter, Boolean isDigit) {
        this.passwordLength = passwordLength;
        this.isLowerCase = isLowerCase;
        this.isUpperCase = isUpperCase;
        this.isMixLowerAndUpperCase = isMixLowerAndUpperCase;
        this.isSpecialCharacter = isSpecialCharacter;
        this.isDigit = isDigit;
    }

    @ChooseMethodAnnotations(methodName = "no choose")
    public String getPassword() {
        return password;
    }

    @ChooseMethodAnnotations(methodName = "no choose")
    public void setPassword(String password) {
        this.password = password;
    }

    @ChooseMethodAnnotations(methodName = "no choose")
    public Long getPasswordLength() {
        return passwordLength;
    }

    @ChooseMethodAnnotations(methodName = "choose")
    public Boolean isLowerCase() {
        return isLowerCase;
    }

    @ChooseMethodAnnotations(methodName = "choose")
    public Boolean isUpperCase() {
        return isUpperCase;
    }

    @ChooseMethodAnnotations(methodName = "choose")
    public Boolean isMixLowerAndUpperCase() {
        return isMixLowerAndUpperCase;
    }

    @ChooseMethodAnnotations(methodName = "choose")
    public Boolean isSpecialCharacter() {
        return isSpecialCharacter;
    }

    @ChooseMethodAnnotations(methodName = "choose")
    public Boolean isDigit() {
        return isDigit;
    }
}
