package com.utgard.string_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class IsAnagram {
    public boolean execute(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;

        List<Character> listFirst = new ArrayList<>();
        for (char ch : first.toLowerCase().toCharArray())
            listFirst.add(ch);
        listFirst.sort(Character::compareTo);

        List<Character> listSecond = new ArrayList<>();
        for (char ch : second.toLowerCase().toCharArray())
            listSecond.add(ch);
        listSecond.sort(Character::compareTo);

        return listFirst.equals(listSecond);
    }

//    O(n log n)
    public boolean executeMosh(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    // O(n)
    public boolean executeMoshHistogram(String first, String second) {
        if (first == null || second == null)
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase();
        for (var i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;

        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++) {
            var index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;
            frequencies[index]--;
        }

    return true;
    }
}
