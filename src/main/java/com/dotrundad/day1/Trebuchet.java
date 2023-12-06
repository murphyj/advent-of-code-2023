package com.dotrundad.day1;

public class Trebuchet {
    
    public String calibrate(String line) {
        
        boolean firstDigitFound = false;
        char firstDigit = ' ';
        char lastDigit = ' ';
        
        for (int i = 0; i < line.length(); i++) {
           char character = line.charAt(i);
           if (Character.isDigit(character)) {
               if (!firstDigitFound) {
                   firstDigitFound = true;
                   firstDigit = character;
               }
               lastDigit = character;
           }
        }
        return Character.toString(firstDigit) + Character.toString(lastDigit);
    }
}
