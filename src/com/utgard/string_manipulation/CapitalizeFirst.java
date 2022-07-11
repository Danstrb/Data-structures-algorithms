package com.utgard.string_manipulation;

public class CapitalizeFirst {
    public String execute (String string) {
        var words = string.split(" ");
        StringBuilder result = new StringBuilder();

        for (var word : words) {
            StringBuilder buffer = new StringBuilder();
            word = buffer.append(word)
                    .replace(0, 1, Character.toString(word.charAt(0)).toUpperCase())
                    .toString();
            result.append(word).append(" ");
        }

        return result.toString().trim();
    }

    public String executeMosh(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")
                .split(" ");

        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }
}
