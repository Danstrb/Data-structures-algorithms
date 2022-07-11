package com.utgard.stacks;

public class StackMy {
    private int count = 0;
    private int size = 10;
    private int[] items = new int[size];


    public void push (int item) {
        if (count == size) {
            int[] newArray = new int[size * 2];
            for (int i : items)
                newArray[i-1] = items[i-1];
            items = newArray;
            }

        items[count++] = item;
    }

    public int pop () {
        int poppedNumber = items[--count];
        items[count] = 0;

        return poppedNumber;
    }

    public int peek () {
        if (count == 0)
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty () {
        return count == 0;
    }
}
