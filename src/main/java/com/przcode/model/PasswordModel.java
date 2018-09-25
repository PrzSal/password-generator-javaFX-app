package com.przcode.model;

public class PasswordModel {

    private String password;
    private Long passwordLength;
    private boolean isLowerCaseChar;
    private boolean isMixLowerAndUpperCase;
    private boolean isSpecialCharacter;
    private boolean isDigit;

    public PasswordModel(Long passwordLength, boolean isLowerCaseChar, boolean isMixLowerAndUpperCase, boolean isSpecialCharacter, boolean isDigit) {
        this.passwordLength = passwordLength;
        this.isLowerCaseChar = isLowerCaseChar;
        this.isMixLowerAndUpperCase = isMixLowerAndUpperCase;
        this.isSpecialCharacter = isSpecialCharacter;
        this.isDigit = isDigit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPasswordLength() {
        return passwordLength;
    }

    public boolean isLowerCaseChar() {
        return isLowerCaseChar;
    }

    public boolean isMixLowerAndUpperCase() {
        return isMixLowerAndUpperCase;
    }

    public boolean isSpecialCharacter() {
        return isSpecialCharacter;
    }

    public boolean isDigit() {
        return isDigit;
    }
}
