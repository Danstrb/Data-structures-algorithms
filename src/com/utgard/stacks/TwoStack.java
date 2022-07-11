package com.utgard.stacks;


public class TwoStack {
    private int count1 = 0;
    private int count2 = 1;
    private int[] items = new int[5];


    public void push1 (int item) {
        if (isOutOfBounds(count1))
            throw new StackOverflowError();

        items[count1] = item;
        count1 = count1 + 2;
    }

    public void push2 (int item) {
        if (isOutOfBounds(count2))
            throw new StackOverflowError();

        items[count2] = item;
        count2 = count2 + 2;
    }

    public int pop1 () {
        if (count1 == 0)
            throw new IllegalStateException();
        count1 -= 2;
        return items[count1];
    }

    public int pop2 () {
        if (count2 == 1)
            throw new IllegalStateException();
        count2 -= 2;
        return items[count2];
    }

    private boolean isOutOfBounds (int countX) {
        return countX == items.length || countX-1 == items.length;
    }

    public boolean isEmpty1 () {
        return count1 == 0;
    }

    public boolean isEmpty2 () {
        return count2 == 1;
    }

    public boolean isFull1 () {
        return isOutOfBounds(count1);
    }

    public boolean isFull2 () {
        return isOutOfBounds(count2);
    }

//    @Override
//    public String toString () {
//        var content = Arrays.copyOfRange(items,0, count-1);
//        return Arrays.toString(content);
    }
//}

