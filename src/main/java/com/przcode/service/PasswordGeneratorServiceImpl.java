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
    
    private void createAllCharInPass(PasswordModel passwordModel) {
        Method[] methods = passwordModel.getClass().getDeclaredMethods();
        String methodNameAndUserAnswer;
        for (Method method : methods) {
            if (method.getAnnotation(ChooseMethodAnnotations.class).methodName().equals("choose")) {
                try {
                    methodNameAndUserAnswer = method.getName() + method.invoke(passwordModel).toString();
                    System.out.println(methodNameAndUserAnswer);
                    this.choosingCharFromRequirement(methodNameAndUserAnswer);
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                } catch (InvocationTargetException f) {
                    System.out.println(f);
                }
            }
        }
    }
}
