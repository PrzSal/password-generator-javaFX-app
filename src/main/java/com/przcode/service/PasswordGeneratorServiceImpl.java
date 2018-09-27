package com.przcode.service;

import com.przcode.model.ChooseMethodAnnotations;
import com.przcode.model.PasswordModel;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class PasswordGeneratorServiceImpl implements PasswordGeneratorService {

    private ArrayList<String> choosingChars;

    public PasswordGeneratorServiceImpl() {
        this.choosingChars = new ArrayList<>();
    }

    @Override
    public PasswordModel addPassword(PasswordModel passwordModel) {
        this.createAllCharInPass(passwordModel);
        String generatePassword = this.generatePassword(passwordModel);
        System.out.println(generatePassword);
        passwordModel.setPassword(generatePassword);
        return passwordModel;
    }

    private void createAllCharInPass(PasswordModel passwordModel) {
        Method[] methods = passwordModel.getClass().getDeclaredMethods();
        String methodNameAndUserAnswer;
        for (Method method : methods) {
            if (method.getAnnotation(ChooseMethodAnnotations.class).methodName().equals("choose")) {
                try {
                    methodNameAndUserAnswer = method.getName() + method.invoke(passwordModel).toString();
                    this.choosingCharFromRequirement(methodNameAndUserAnswer);
                } catch (IllegalAccessException e) {
                    System.out.println(e);
                } catch (InvocationTargetException f) {
                    System.out.println(f);
                }
            }
        }
    }

    private void choosingCharFromRequirement(String typeRequirement) {
        if (typeRequirement.contains("true")) {
            choosingChars.add(PasswordCharCreator.valueOf(typeRequirement).addChars());
        }
    }

    private String generatePassword(PasswordModel passwordModel) {
        Character guessChar;
        String generatePassword = new String();
        String partPassChar;
        Random random = new Random();

        while (passwordModel.getPasswordLength() != generatePassword.length()) {
            partPassChar = choosingChars.get(random.nextInt(choosingChars.size()));
            guessChar = partPassChar.charAt(random.nextInt(partPassChar.length()));
            if (generatePassword.length() == 0) {
                generatePassword += guessChar;
            }
            if(generatePassword.length() > 0 && generatePassword.charAt(generatePassword.length()-1) != guessChar) {
                generatePassword += guessChar;
            }
        }
        return generatePassword;
    }
}
