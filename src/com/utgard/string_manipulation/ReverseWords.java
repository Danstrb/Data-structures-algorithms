package com.utgard.string_manipulation;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {
    public String execute(String string) {
        if (string == null)
            return "";

        var words = string.split(" ");
        StringBuffer newString = new StringBuffer();
        for (int i = words.length-1; i >=0; i--)
            newString.append(words[i] + " ");

        return newString.toString().trim();
    }

    public String executeMosh(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
