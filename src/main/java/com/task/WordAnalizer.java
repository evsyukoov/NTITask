package com.task;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordAnalizer {
    private LinkedHashMap<Character, Integer> frequency;
    private String param;

    Map.Entry<Character, Integer> result;

    public WordAnalizer(String param) {
        frequency = new LinkedHashMap<>();
        this.param = param;
    }

    public  int     findSymbol() {
        for (int i = param.length() - 1; i >= 0; i--)
        {
            if (frequency.containsKey(param.charAt(i)))
                frequency.put(param.charAt(i), frequency.get(param.charAt(i)) + 1);
            else
                frequency.put(param.charAt(i), 1);
        }
        findMax();
        return (1);
    }

    private void findMax()
    {
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> entry : frequency.entrySet())
        {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry;
            }
        }
    }

    public Map.Entry<Character, Integer> getResult() {
        return result;
    }
}
