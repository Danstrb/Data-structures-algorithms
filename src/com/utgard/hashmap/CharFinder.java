package com.utgard.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();

        for (var ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put (ch, count + 1);
        }

        for (var item : chars)
            if (map.get(item) == 1)
                return item;

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatingChar(String str) {
        Set<Character> set = new HashSet<>();
        var chars = str.toCharArray();

        for (char ch : chars) {
            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }

        return Character.MIN_VALUE;
    }


    public char findFirstRepeatingCharMy(String str) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();

        for (char ch : chars) {
            int counter = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch,counter+1);
            }

        for (char ch : chars) {
            if (map.get(ch) > 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }
}
// findFirstNonRepeatingChar
//  METHOD ONE
//        var trial = "ra gwraen pgpne";
//        trial = trial.replaceAll(" ", "");
//
//        Map<Integer, Character> map = new HashMap<>();
//        Map<Integer, Character> mapCopy = new HashMap<>();
//
//        for (int i = 0; i < trial.length(); i++) {
//            map.put(i, trial.charAt(i));
//            mapCopy.put(i, trial.charAt(i));
//        }
//
//        for (var item : map.entrySet()) {
//            mapCopy.remove(item.getKey());
//
//            if (!mapCopy.containsValue(item.getValue()))
//                return item.getValue();
//            else
//                mapCopy.put(item.getKey(), item.getValue());
//        }
//        return ' ';

//METHOD TWO
//        for (var item : map.entrySet()) {
//            if (item.getValue() < resultNumber) {
//                resultNumber = item.getValue();
//                result = item.getKey();
//            }
//        }

//        while (trial.length() > 0) {
//            if (trial.length() == 1)
//                return trial.charAt(0);
//            for (int l = 1; l < trial.length(); l++)
//                if (trial.charAt(0) == trial.charAt(l)) {
//                    trial = trial.replaceAll(Character.toString(trial.charAt(0)), "");
//                    break;
//                } else if (l == trial.length() - 1)
//                    return trial.charAt(0);
//        }
//        return ' ';
