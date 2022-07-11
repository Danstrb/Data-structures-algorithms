package com.utgard.searching_algorithms;

public class SearchingPractice {
    public void practice() {
//        var practice = new LinearSearch();
//        int[] array0 = {};
//        int[] array1 = {1};
//        int[] array2 = {2,1};
//        int[] array3 = {2,1,4,3};
//        int[] array4 = {8,4,2,1,3,7,6,5};
//        int[] array5 = {0,6,3,7,12,2,8,9,10,5,3,16};
//
//        int[][] testArrays = { array0, array1, array2, array3, array4, array5 };
//        for (int[] array : testArrays) {
//            var result = practice.findItemIndex(array,3);
//            System.out.println(result);
//        }

        var practiceBinary = new ExponentialSearch();
        int[] arrayBinary = {0,1,3,4,6,8,9,11,12,13,15,16,17};
        System.out.println(practiceBinary.findIndex(arrayBinary, 17));
//        var result = practice.findItemIndex(array, 3);
//        System.out.println(result);
    }
}
