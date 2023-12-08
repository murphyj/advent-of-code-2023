package com.dotrundad.day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrebuchetLines {

    private Trebuchet trebuchet = new Trebuchet();
    
    public int calibrateLines(List<String> lines) {
        
        int count = 0;
        for (String line: lines) {
            int answer = Integer.valueOf(trebuchet.calibrate(line));
            count += answer;
        }
        return count;
    }
}
