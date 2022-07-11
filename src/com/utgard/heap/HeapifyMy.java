package com.utgard.heap;

public class HeapifyMy {
    private int[] array;

    public HeapifyMy(int[] array) {
        this.array = array;
    }
    // { 5, 3, 8, 4, 1, 2 } ->  { 8, 4, 5, 3, 1, 2 }
    public int[] heapify () {
        int temp;

        for (int index = array.length / 2 - 1; index >= 0; index--)
            if (array[index] < leftChild(index) || array[index] < rightChild(index)) {
                temp = array[index];
                array[index] = array[largerChildIndex(index)];
                array[largerChildIndex(index)] = temp;
            }
        return array;
    }
//    public int[] heapify () {
//        int temp;
//
//        for (int index = 0; index * 2 + 1 < array.length; index++)
//            if (array[index] < leftChild(index) || array[index] < rightChild(index)) {
//                temp = array[index];
//                array[index] = array[largerChildIndex(index)];
//                array[largerChildIndex(index)] = temp;
//            }
//        return array;
//    }

    private int largerChildIndex(int index) {
        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int leftChild(int index) {
        if (index * 2 + 1 > array.length - 1)
            return Integer.MIN_VALUE;
        return array[index * 2 + 1];
    }

    private int rightChild(int index) {
        if (index * 2 + 2 > array.length - 1)
            return Integer.MIN_VALUE;
        return array[index * 2 + 2];
    }
}

