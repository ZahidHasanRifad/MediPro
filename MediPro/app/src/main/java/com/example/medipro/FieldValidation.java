package com.example.medipro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidation {

    public boolean validateEmail(String email){
        String regex;
        regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePhonenumber(String phone){
        String regex;
        regex = "\\d{11}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
