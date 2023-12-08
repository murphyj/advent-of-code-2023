package com.dotrundad.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Trebuchet {

    private Map<String, Character> alphaNumbers = Map.of(
            "one", '1',
            "two", '2',
            "three", '3',
            "four", '4',
            "five", '5',
            "six", '6',
            "seven", '7',
            "eight", '8',
            "nine", '9'
    );

    private List<String> alphaNumbersList = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    private StringBuilder seekWord;
    public String calibrate(String line) {

        seekWord = new StringBuilder();

        boolean firstDigitFound = false;
        char firstDigit = ' ';
        char lastDigit = ' ';
        
        for (int i = 0; i < line.length(); i++) {
           char character = line.charAt(i);
           if (Character.isAlphabetic(character)) {
               // store character in seek
               seekWord.append(character);
               // check if current seek is a number as words
               // if it's a number as words set the first digit
               String seek = seekWord.toString();
               String alphaNumber = findAlphaNumber(seek);
               if (alphaNumber != null && !firstDigitFound) {
                   firstDigitFound = true;
                   firstDigit = alphaNumbers.get(alphaNumber);
                   seekWord = new StringBuilder();
               }
               if (alphaNumber != null && firstDigitFound) {
                   lastDigit = alphaNumbers.get(alphaNumber);
                   seekWord = new StringBuilder();
               }
           } else if (Character.isDigit(character)) {
               seekWord = new StringBuilder();
               if (!firstDigitFound) {
                   firstDigitFound = true;
                   firstDigit = character;
               }
               lastDigit = character;
           } else {
               seekWord = new StringBuilder();
           }
        }
        return Character.toString(firstDigit) + Character.toString(lastDigit);
    }

    private String findAlphaNumber(String seek) {
        for (int i = 0; i < alphaNumbersList.size(); i++) {
            String alphaNumber = alphaNumbersList.get(i);
            if (seek.contains(alphaNumber)) {
                return alphaNumber;
            }
        }
        return null;
    }
}
