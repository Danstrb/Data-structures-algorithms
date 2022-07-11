package com.utgard.string_manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMostRepeatedChar {
    public List<Character> execute(String string) {
        if (string == null)
            return null;

        var mostRepetitions = 0;
        List<Character> result = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : string.toLowerCase().toCharArray()) {
            if (!map.containsKey(ch))
                map.putIfAbsent(ch, 1);
            else
                map.replace(ch, map.get(ch)+1);
            if (map.get(ch) > mostRepetitions)
                mostRepetitions++;
        }

        for (var key : map.keySet()) {
            if (map.get(key) == mostRepetitions)
                result.add(key);
        }
        return result;
    }

    public List<Character> executeWithoutMap(String string) {
        if (string == null)
            return null;

        String aplhabet = "abcdefghijklmnopqrstuvwxyz";
        List<Character> result = new ArrayList<>();
        int[] occurencies = new int[26];
        int mostOccurencies = 0;

        for (char ch : string.toLowerCase().toCharArray()) {
            occurencies[ch - 'a'] += 1;
            if (occurencies[ch - 'a'] > mostOccurencies)
                mostOccurencies = occurencies[ch - 'a'];
        }

        for (int i = 0; i < occurencies.length; i++)
            if (occurencies[i] == mostOccurencies)
                result.add(aplhabet.charAt(i));
        return result;
    }

    public char executeWithoutMapMosh(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];
        for (var ch : str.toCharArray())
            frequencies[ch]++;

        int max = 0;
        char result = ' ';
        for (var i = 0; i < frequencies.length; i++)
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }

        return result; //does not count with multiple same frequencies
    }
}
