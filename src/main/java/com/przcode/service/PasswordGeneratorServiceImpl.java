package com.przcode.service;

import com.przcode.model.ChooseMethodAnnotations;
import com.przcode.model.PasswordModel;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class PasswordGeneratorServiceImpl implements PasswordGeneratorService {

    private ArrayList<String> choosingChars;

    public PasswordGeneratorServiceImpl() {
        this.choosingChars = new ArrayList<>();
    }

    @Override
    public PasswordModel addPassword(PasswordModel passwordModel) {

        this.createAllCharInPass(passwordModel);
        return passwordModel;
    }

}
