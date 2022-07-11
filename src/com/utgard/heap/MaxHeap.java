package com.utgard.heap;

public class MaxHeap {
    public static void heapify (int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (var i = lastParentIndex; i >= 0; i--)
            heapify(array, i);

    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length &&
                array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length &&
            array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap (int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for (var number : array)
            heap.insert(number);

        for (var i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }

    public static int kThLargestNumberMy (int[] array, int k) {
        if (k == 0)
            throw new IllegalStateException();

        Heap heap = new Heap();
        int result = Integer.MIN_VALUE;
        for (int number : array)
            heap.insert(number);
        for (int i = 0; i < k; i++)
            result = heap.remove();
        return result;
    }

    public static boolean isMaxHeap(int[] array) {
        for (int i = 0; i <= array.length / 2 - 1; i++) {
            if (array[i] < array[i * 2 + 1] || array[i] < array[i * 2 + 2])
                return false;
        }
        return true;
    }
}
