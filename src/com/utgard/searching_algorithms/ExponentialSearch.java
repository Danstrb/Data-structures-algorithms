package com.utgard.searching_algorithms;

public class ExponentialSearch {
    public int findIndex(int[] array, int target) {
        if (array.length == 0)
            return -1;
        if (array.length == 1 && array[0] == target)
            return 0;
        else if (array.length == 1)
            return -1;

        int bound = 1;
        while (array[bound] < target) {
            bound *= 2;
            if (bound > array.length)
                bound = array.length-1;
        }

        for (int i = bound / 2; i <= bound; i++)
            if (array[i] == target)
                return i;
        return -1;
    }
}
