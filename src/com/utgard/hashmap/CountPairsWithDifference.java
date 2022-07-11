package com.utgard.hashmap;

import java.util.*;

public class CountPairsWithDifference {
    public int countPairsWithDifference (int[] numbers, int k) {
        Set<Integer> set = new HashSet<>();
        int counter = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i] + k))
                counter++;
            if (set.contains(numbers[i] - k))
                counter++;
            set.add(numbers[i]);
        }
        return counter;


    }

    public int[][] countPairsWithDifferenceMy (int [] numbers, int k) {
        int[][] result = new int[2][numbers.length];
        int complement;
        int counter = 0;
        Set<Integer> set = new HashSet<>();
        for (int number : numbers)
            set.add(number);

        for (int i = 0; i < numbers.length; i++) {
            complement = numbers[i] - k;
            if (set.contains(complement)) {
                result[0][counter] = complement;
                result[1][counter++] = numbers[i];
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result;
    }
}
