package com.systelab.identity.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicalRecordNumberValidator {

    /*

    Format xxx-xx-xxxx, xxxxxxxxx, xxx-xxxxxx; xxxxx-xxxx:

    ^\\d{3}: Starts with three numeric digits.
    [- ]?: Followed by an optional "-"
    \\d{2}: Two numeric digits after the optional "-"
    [- ]?: May contain an optional second "-" character.
    \\d{4}: ends with four numeric digits.

    Examples: 879-89-8989; 869878789 etc.

    */
    public static boolean isValid(String number) {
        String expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";
        CharSequence inputStr = number;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    // Non real algorithm. Just for generate a compliant number
    public static String generateRandormNumber() {
        return generateRandormNumber(100,999)+"-"+generateRandormNumber(10,99)+"-"+generateRandormNumber(1000,9999);
    }

    private static int generateRandormNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
