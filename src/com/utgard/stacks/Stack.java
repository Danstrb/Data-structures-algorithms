package com.utgard.stacks;

import java.util.Arrays;

public class Stack {
    private int count = 0;
    private int[] items = new int[5];


    public void push (int item) {
        if (count == items.length)
            throw new StackOverflowError();

        items[count++] = item;
    }

    public int pop () {
        if (count == 0)
            throw new IllegalStateException();

        return items[--count];
    }

    public int peek () {
        return items[--count];
    }

    public boolean isEmpty () {
        return count == 0;
    }

    @Override
    public String toString () {
        var content = Arrays.copyOfRange(items,0, count-1);
        return Arrays.toString(content);
    }
}
