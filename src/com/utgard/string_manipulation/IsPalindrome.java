package com.utgard.string_manipulation;

public class IsPalindrome {
    public boolean execute (String string) {
        if (string == null)
            return false;

        String reversed =
                new StringBuilder()
                .append(string)
                .reverse()
                .toString();

        return string.equals(reversed);
    }

    public boolean executeFaster (String string) {
        if (string == null)
            return false;

        int leftPointer = 0;
        int rightPointer = string.length()-1;
        string = string.toLowerCase(); //if case sensitive

        while (leftPointer < rightPointer)
            if (string.charAt(leftPointer++) != string.charAt(rightPointer--))
                return false;

        return true;
    }
}
