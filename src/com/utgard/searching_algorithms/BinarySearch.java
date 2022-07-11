package com.utgard.searching_algorithms;

public class BinarySearch {
    public int findItemIndex(int[] array, int target) {
        if (array.length == 0)
            return -1;

//        return findItemIndexRecursive(array, target, 0, array.length - 1);
        return findItemIndexIterative(array, target);
    }

    private int findItemIndexRecursive(int[] array, int target, int start, int end) {
        int middleIndex = (start + end) / 2;
        int middle = array[middleIndex];

        if (target == middle)
            return middleIndex;
        if (start == end)
            return -1;

        if (target < middle)
            return findItemIndexRecursive(array, target, start, middleIndex - 1);
        else
            return findItemIndexRecursive(array, target, middleIndex + 1, end);
    }

    private int findItemIndexIterative(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middleIndex = (start + end) / 2;
            int middle = array[middleIndex];

            if (middle == target)
                return middleIndex;
            else if (target < middle)
                end = middleIndex - 1;
            else
                start = middleIndex + 1;
        }

        return -1;
    }
}
