package com.utgard.queues;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int size = 0;
    private int counter = size;

    public void push (int item) {
        queue1.add(item);
        size++;
    }

    public int pop () {
        while (!queue1.isEmpty()) {
            for (int i = counter; i > 1; i--)
                queue1.add(queue1.remove());
            queue2.add(queue1.remove());
            counter--;
        }
        size--;
        return queue2.remove();
    }

    public int peek () {
        if (queue1.isEmpty() && queue2.isEmpty())
            throw new IllegalStateException();

        while (!queue1.isEmpty()) {
            for (int i = counter; i > 1; i--)
                queue1.add(queue1.remove());
            queue2.add(queue1.remove());
            counter--;
        }
        return queue2.peek();
    }

    public int size () {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
