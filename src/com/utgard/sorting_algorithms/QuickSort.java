package com.utgard.sorting_algorithms;


public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length-1);
    }


    private void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        int border = partition(array, start, end);
        sort(array, start, border - 1);
        sort(array, border + 1, end);

    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int border = start - 1;

        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot)
                swap(array, ++border, i);
        }
        return border;
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}