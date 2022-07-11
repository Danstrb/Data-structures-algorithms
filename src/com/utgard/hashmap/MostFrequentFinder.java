package com.utgard.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentFinder {

    public int findMostFrequent (int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = -1;
        int max = -1;
        for (int number : array) {
            if (map.get(number) == null)
                map.put(number, 1);
            else
                map.put(number, map.get(number)+1);
        }

        for (var item : map.entrySet())
            if (item.getValue() > counter) {
                counter = item.getValue();
                max = item.getKey();
            }
        return max;
    }
}
