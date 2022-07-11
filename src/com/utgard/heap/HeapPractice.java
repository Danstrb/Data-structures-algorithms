package com.utgard.heap;

import java.util.Arrays;

public class HeapPractice {
    public void practice() {
        var practice = new MinHeap();
        practice.insert(5);
        practice.insert(2);
        practice.insert(3);
        practice.insert(4);
        practice.insert(1);
        practice.insert(12);
        practice.insert(-3);
        practice.insert(9);
        practice.insert(0);
        System.out.println(practice);
        practice.remove();
        System.out.println(practice);
        practice.remove();
    }
}
