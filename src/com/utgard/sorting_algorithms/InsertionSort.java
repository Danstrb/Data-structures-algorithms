package com.utgard.sorting_algorithms;

//        int[] array = {5,3,2,6,1,4,3};

public class InsertionSort {
    public void sort (int[] array) {
        int current;
        int freeIndex;
        int k;

        for (int i = 0; i < array.length; i++) {
            current = array[i];
            freeIndex = i;
            k = i-1;
            while (k >= 0 && array[k] > current) {
                replace(array, k, k+1);
                freeIndex = k--;
            }
            array[freeIndex] = current;
        }
    }

    private void replace(int[] array, int replacedObject, int replacedSubject) {
        array[replacedSubject] = array[replacedObject];
    }
}

// WORKS
//public class InsertionSort {
//    public void sort (int[] array) {
//        int current;
//        int freeIndex;
//        int k;
//
//        for (int i = 0; i < array.length; i++) {
//            current = array[i];
//            freeIndex = i;
//            k = i-1;
//            while (k >= 0 && array[k] > current) {
//                swap(array, k, k+1);
//                freeIndex = k--;
//            }
//            array[freeIndex] = current;
//        }
//    }
//
//    private void swap (int[] array, int index1, int index2) {
//        var temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }
//}
