package com.utgard.stacks;

public class MinStack {
    private int count1 = 0;
    private int count2 = 1;
    private int[] items = new int[10];
    private int min;

    public int min () {
        return min;
    }

    public void push(int item) {
        if (isOutOfBounds(count1))
            throw new StackOverflowError();

        if (item <= min || count1 == 0) {
            min = item;
            push2(min);
        }

        items[count1] = item;
        count1 += 2;
    }

    public int pop() {
        if (count1 == 0)
            throw new IllegalStateException();

        count1 -= 2;

        if (min == peek()) {
            pop2();
            if (!isEmpty2())
                min = items[count2-2];
            else min = -1;
            }

        return peek();
    }

    public boolean isEmpty() {
        return count1 == 0;
    }

    private int peek() {
        return items[count1];
    }

    public boolean isFull () {
        return isOutOfBounds(count1);
    }

    private boolean isOutOfBounds(int countX) {
        return countX == items.length || countX - 1 == items.length;
    }

    private void push2(int item) {
        if (isOutOfBounds(count2))
            throw new StackOverflowError();

        items[count2] = item;
        count2 = count2 + 2;
    }

    private int pop2() {
        if (count2 == 1)
            throw new IllegalStateException();
        count2 -= 2;
        return items[count2];
    }

    private int peek2() {
        return items[count2];
    }

    private boolean isEmpty2() {
        return count2 == 1;
    }

    private boolean isFull2 () {
        return isOutOfBounds(count2);
    }
}