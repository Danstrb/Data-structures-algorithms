package com.utgard.searching_algorithms;

public class JumpSearch {
    public int findIndexMy(int[] array, int target) {
        int blockSize = (int)Math.sqrt(array.length);
        int start = 0;
        int next = start + blockSize;

        while (start < array.length) {
            if (next >= array.length) {
                next = array.length - 1;
                if (start == next && array[start] == target)
                    return start;
            }
            if (array[next - 1] >= target) {
                for (int i = start; i < next; i++)
                    if (array[i] == target)
                        return i;
                return -1;
            }
            start = next;
            next += blockSize;
        }
        return -1;
    }

    public int findIndex(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        while (start < array.length && array[next - 1] < target) {
            start = next;
            next += blockSize;
            if (next > array.length)
                next = array.length;
        }

        for (var i = start; i < next; i++)
            if (array[i] == target)
                return i;

        return -1;
    }
}
