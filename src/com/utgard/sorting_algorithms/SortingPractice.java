package com.utgard.sorting_algorithms;

import java.util.Arrays;

public class SortingPractice {
    public void practice() {
        var sort = new BucketSort();
        int[] array0 = {};
        int[] array1 = {1};
        int[] array2 = {2,1};
        int[] array3 = {2,1,4,3};
        int[] array4 = {8,4,2,1,3,7,6,5};
        int[] array5 = {0,6,3,7,12,2,8,9,10,5,3,16};

        int[][] testArrays = { array0, array1, array2, array3, array4, array5 };
        for (int[] array : testArrays) {
            sort.sort(array);
            System.out.println(Arrays.toString(array));
        }

//        sort.sort(array5);
//        System.out.println(Arrays.toString(array5));
    }
}
