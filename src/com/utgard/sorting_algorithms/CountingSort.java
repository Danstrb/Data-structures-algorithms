package com.utgard.sorting_algorithms;

import java.util.Arrays;

public class CountingSort {
    public void sort (int[] array) {
        if (array.length <= 1)
            return;

        int max = Integer.MIN_VALUE;
        for (var number : array)
            if (number > max)
                max = number;
        int [] counter = new int[max+1];

        for (int i : array)
            counter[i] += 1;

        int border = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] > 0) {
                array[border++] = i;
                counter[i]--;
            }
        }
    }
}
