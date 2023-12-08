package com.dotrundad.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrebuchetLinesTest {
    
    TrebuchetLines trebuchetLines;

    @BeforeEach
    public void setup() {
        trebuchetLines = new TrebuchetLines();    
    }
    
    @Test
    public void testCalibrateWithTest1() throws Exception {
        List<String> lines = readFile("src/test/resources/test1.txt");

        int answer = 142;
        assertEquals(answer, trebuchetLines.calibrateLines(lines));
    }

    @Test
    public void testCalibrateWithTest2() throws Exception {
        List<String> lines = readFile("src/test/resources/test2.txt");

        int answer = 281;
        assertEquals(answer, trebuchetLines.calibrateLines(lines));
    }
    
    @Test
    public void testCalibrateWithSamplePartOne() throws Exception {
        List<String> lines = readFile("src/test/resources/partOneFullSample.txt");
        
        System.out.println(trebuchetLines.calibrateLines(lines));
    }

    @Test
    public void testCalibrateWithSamplePartTwo() throws Exception {
        List<String> lines = readFile("src/test/resources/partTwoSample.txt");

        System.out.println(trebuchetLines.calibrateLines(lines));
    }

    private List<String> readFile(String filename) throws FileNotFoundException {
        List<String> result = new ArrayList<>();
        
        try (Scanner s = new Scanner(new FileReader(filename))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
            return result;
        }
    }
}