package com.utgard.sorting_algorithms;

public class MergeSortMy {
    public void sort (int[] array) {
        sort(array, array);
    }

    private void sort(int[] originalArray, int[] currentArray) {
        if (currentArray.length <= 1)
            return;

        int[] newArray1 = createSubArrays(currentArray)[0];
        int[] newArray2 = createSubArrays(currentArray)[1];

        sort(originalArray, newArray1);
        sort(originalArray, newArray2);

        sortMergeArrays(newArray1, newArray2, currentArray);
    }

    private int[][] createSubArrays (int[] currentArray) {
        int secondArrayLenght = (currentArray.length % 2 == 1) ? currentArray.length / 2 + 1 : currentArray.length / 2;
        int[] newArray1 = new int[currentArray.length/2];
        for (int i = 0; i < newArray1.length; i++)
            newArray1[i] = currentArray[i];
        int[] newArray2 = new int[secondArrayLenght];
        for (int i = 0; i < newArray2.length; i++)
            newArray2[i] = currentArray[i + newArray1.length];
        int [][] result= {newArray1, newArray2};
        return result;
    }

    private void sortMergeArrays(int[] newArray1, int[] newArray2, int[] currentArray) {
        var array1Index = 0;
        var array2Index = 0;
        var currentArrayIndex = 0;

        while (currentArrayIndex < currentArray.length) {
            if (array1Index == newArray1.length)
                currentArray[currentArrayIndex++] = newArray2[array2Index++];
            else if (array2Index == newArray2.length)
                currentArray[currentArrayIndex++] = newArray1[array1Index++];
            else if (newArray1[array1Index] <= newArray2[array2Index]) {
                currentArray[currentArrayIndex++] = newArray1[array1Index++];
            }
            else if (newArray1[array1Index] >= newArray2[array2Index]) {
                currentArray[currentArrayIndex++] = newArray2[array2Index++];
            }
        }
    }
}
