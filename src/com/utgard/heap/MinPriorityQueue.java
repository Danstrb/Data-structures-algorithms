package com.utgard.heap;

public class MinPriorityQueue extends MinHeap{
    MinHeap queue = new MinHeap();

    public void add (int priority, String value) {
//        queue.insert(priority, value);
        queue.insert(priority, value);
    }

    @Override
    public void remove() {
        queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
