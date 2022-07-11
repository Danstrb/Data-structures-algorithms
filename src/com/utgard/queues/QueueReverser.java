package com.utgard.queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    private int k;
    private Queue<Integer> queue;

    public QueueReverser (int k, Queue<Integer> queue) {
        this.queue = queue;
        this.k = k;
    }

    public void reverse () {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queueTemporary = new ArrayDeque<>();
        while (k > 0) {
            stack.push(queue.remove());
            k--;
        }
        while (!queue.isEmpty())
            queueTemporary.add(queue.remove());
        while (!stack.empty())
            queue.add(stack.pop());
        while (!queueTemporary.isEmpty())
            queue.add(queueTemporary.remove());
    }
}
