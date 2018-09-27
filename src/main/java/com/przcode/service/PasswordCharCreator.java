package com.przcode.service;

public enum PasswordCharCreator {
    isLowerCasetrue {
        @Override
        public String addChars() {
            return new String("abcdefghijklmnopqrstuwxyz");
        }

    }, isUpperCasetrue {
        @Override
        public String addChars() {
            return new String("ABCDEFGHIJKLMNOPQRSTUWXYZ");
        }

    },isMixLowerAndUpperCasetrue {
        @Override
        public String addChars() {
            return new String("abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ");
        }
    }, isSpecialCharactertrue {
        @Override
        public String addChars() {
            return new String("!@#$%^&*/\\");
        }
    }, isDigittrue {
        @Override
        public String addChars() {
            return new String("1234567890");
        }
    };
    public abstract String addChars();
}
