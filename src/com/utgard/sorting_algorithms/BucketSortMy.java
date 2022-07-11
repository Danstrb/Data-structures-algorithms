package com.utgard.sorting_algorithms;

import java.util.LinkedList;

public class BucketSortMy {
    public void sort(int[] array) {
        if (array.length <= 1)
            return;

        int max = Integer.MIN_VALUE;
        for (int i : array)
            if (max < i)
                max = i;
        sort(array, max);
    }


    private void sort(int[] array, int max) {
        var buckets = createAndPopulateBuckets(array, max, 3);
        sortBuckets(buckets); //Potential for Threads but nvm for now
        rewriteArray(array, buckets);
    }

    private void rewriteArray(int[] array, LinkedList<Integer>[] buckets) {
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < buckets.length; j++)
                while (!buckets[j].isEmpty())
                    array[i++] = buckets[j].pop();
        }
    }

    private LinkedList<Integer>[] createAndPopulateBuckets(int[] array, int max, int approximateBucketSize) {
        var bucketsSize = (max <= approximateBucketSize) ? 1 : max/approximateBucketSize;
        LinkedList<Integer>[] buckets = new LinkedList[bucketsSize+1];
        for (var i = 0; i < buckets.length; i++)
            buckets[i] = new LinkedList<>();

        for (var number : array)
            buckets[number / approximateBucketSize].add(number);

        return buckets;
    }

    private void sortBuckets (LinkedList<Integer>[] buckets) {
        var quickSort = new QuickSort();
        int[] bucketArray;
        for (var bucket : buckets) {
            bucketArray = new int[bucket.size()];
            for (int i = 0; i < bucketArray.length; i++)
                bucketArray[i] = bucket.get(i);
            quickSort.sort(bucketArray);
            bucket.clear();
            for (int j : bucketArray)
                bucket.add(j);
        }
    }
}
//FIRST VERSION
//package com.utgard.sorting_algorithms;
//
//        import java.util.LinkedList;
//
//public class BucketSort {
//    public void sort(int[] array) {
//        var quickSort = new QuickSort();
//        LinkedList<Integer>[] buckets = new LinkedList[3];
//        for (var i = 0; i < buckets.length; i++)
//            buckets[i] = new LinkedList<>();
//
//        for (var number : array)
//            buckets[number / buckets.length].add(number);
//
//        sortBuckets(buckets);
////        int[] bucketArray;
////        for (var bucket : buckets) {
////            bucketArray = new int[bucket.size()];
////            for (int i = 0; i < bucketArray.length; i++)
////                bucketArray[i] = bucket.get(i);
////            quickSort.sort(bucketArray);
////            bucket.clear();
////            for (int j : bucketArray)
////                bucket.add(j);
////        }
//
//        int i = 0;
//        while (i < array.length) {
//            for (int j = 0; j < buckets.length; j++)
//                while (!buckets[j].isEmpty())
//                    array[i++] = buckets[j].pop();
//        }
//    }
