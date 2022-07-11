package com.utgard.sorting_algorithms;

public class SelectionSort {

    public void sort (int[] array) {
        int lowestValue = Integer.MAX_VALUE;
        int lowestValueIndex = 0;
        if (array.length <= 1)
            return;

        for (int i = 0; i < array.length; i++) {
            lowestValueIndex = findMinIndex(array, i, lowestValue, lowestValueIndex);
            swap(array, i, lowestValueIndex);
        }
    }

    private int findMinIndex (int[] array, int i, int lowestValue, int lowestValueIndex) {
            lowestValue = Integer.MAX_VALUE;
            lowestValueIndex = i;
            for (int j = i; j < array.length; j++)
                if (array[j] < lowestValue) {
                    lowestValue = array[j];
                    lowestValueIndex = j;
                }
            return lowestValueIndex;
    }

    private void swap (int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
