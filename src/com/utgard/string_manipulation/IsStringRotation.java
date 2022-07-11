package com.utgard.string_manipulation;

public class IsStringRotation {
    public boolean execute(String first, String second) {
        if (first == null || second == null)
            return false;

        if (first.length() != second.length())
            return false;

        StringBuffer stringBuffer = new StringBuffer();
        var chars = first.split("");
        for (int i = 0; i < first.length(); i++) {
            int k = i;
            int counter = 0;
            stringBuffer.delete(0, chars.length);
            while (counter < chars.length) {
                stringBuffer.append(chars[k++]);
                if (k == chars.length)
                    k = 0;
                counter++;
            }
            if (stringBuffer.toString().equals(second))
                return true;
        }
        return false;
    }

    public boolean executeMosh(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length() &&
                str1.concat(str1).contains(str2));
    }
}
