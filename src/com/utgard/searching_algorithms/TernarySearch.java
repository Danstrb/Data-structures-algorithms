package com.utgard.searching_algorithms;

public class TernarySearch {
    public int findIndex(int[] array, int target) {
        return findIndex(array, target, 0, array.length-1);
    }

    private int findIndex(int[] array, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid1 = start + ((end - start) / 3);
        int mid2 = end - ((end - start) / 3);

        if (array[mid1] == target)
            return mid1;
        else if (array[mid2] == target)
            return mid2;
        else if (target < array[mid1])
            return findIndex(array, target, start, mid1-1);
        else if (target > array[mid1] && target < array[mid2])
            return findIndex(array, target, mid1 + 1, mid2 - 1);
        else
            return findIndex(array, target, mid2+1, end);
    }
}
