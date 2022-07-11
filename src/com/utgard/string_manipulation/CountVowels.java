package com.utgard.string_manipulation;

import java.util.ArrayList;
import java.util.List;

public class CountVowels {
    public int execute(String string) {
        if (string == null)
            return 0;

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int counter = 0;
        for (char ch : string.toLowerCase().toCharArray())
            if (vowels.contains(ch))
                counter++;
        return counter;
    }

    public int executeMosh(String str) {
        if (str == null)
            return 0;

        int counter = 0;
        String vowels = "aeiou"; //or use a Set
        for (char ch : str.toLowerCase().toCharArray())
            if (vowels.indexOf(ch) != -1)
                counter++;

        return counter;
    }
}
