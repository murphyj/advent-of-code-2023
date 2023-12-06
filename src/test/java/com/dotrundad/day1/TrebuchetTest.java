package com.dotrundad.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrebuchetTest {

    Trebuchet trebuchet;
    
    @BeforeEach
    public void setup() {
        trebuchet = new Trebuchet();    
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "1a1", "1abc1d", "a1ab1d", "aa1d"})
    public void testCalibrateWithSameDigit(String line) {
        String answer = "11";
        assertEquals(answer, trebuchet.calibrate(line));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"12", "112", "1a2", "1abc2d", "a1ab2d", "aa12d"})
    public void testCalibrateWithTwoDifferentDigits(String line) {
        String answer = "12";
        assertEquals(answer, trebuchet.calibrate(line));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"234", "2a3d4", "a23bc4", "23abc4"})
    public void testCalibrateWithThreeDifferentDigits(String line) {
        String answer = "24";
        assertEquals(answer, trebuchet.calibrate(line));
    }
}