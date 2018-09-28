package com.przcode.service;

public enum PasswordCharCreator {
    isLowerCasetrue {
        @Override
        public String addChars() {
            return "abcdefghijklmnopqrstuwxyz";
        }

    }, isUpperCasetrue {
        @Override
        public String addChars() {
            return "ABCDEFGHIJKLMNOPQRSTUWXYZ";
        }

    }, isSpecialCharactertrue {
        @Override
        public String addChars() {
            return "!@#$%^&*/\\";
        }

    }, isDigittrue {
        @Override
        public String addChars() {
            return "1234567890";
        }
    };
    public abstract String addChars();
}
