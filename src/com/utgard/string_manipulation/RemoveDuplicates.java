package com.utgard.string_manipulation;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public String execute(String string) {
        if (string == null)
            return "";

        StringBuffer result = new StringBuffer();
        Set<Character> set = new HashSet();
        for (char ch : string.toCharArray())
            if (!set.contains(ch)) {
                set.add(ch);
                result.append(ch);
            }

        return result.toString();
    }
}
