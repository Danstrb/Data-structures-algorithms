package com.utgard.searching_algorithms;

public class LinearSearch {
    public int findItemIndex(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item)
                return i;
        }
        return -1;
    }
}
