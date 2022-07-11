package com.utgard.string_manipulation;

public class ReverseString {
    public String execute (String string) {
        if (string == null)
            return "";

        StringBuilder reverseString = new StringBuilder();

        for (int i = string.length()-1; i >= 0; i--)
            reverseString.append(string.charAt(i));

        return reverseString.toString();
    }
}
