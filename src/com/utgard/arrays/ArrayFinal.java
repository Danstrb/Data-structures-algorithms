package com.utgard.arrays;

import java.util.Arrays;

public class ArrayFinal {
    private int counter;
    private int[] items;


    public ArrayFinal(int lenght) {
        this.items = new int[lenght];
    }

    public void insert (int item) {

        if (counter < items.length)
            items[counter] = item;
        else
            items = Arrays.copyOf(items, items.length * 2);
            items[counter] = item;

        counter++;
    }

    public void print () {
        for (int i = 0; i < counter; i++) {
            System.out.println(items[i]);
        }
    }

    public void removeAt (int index) {
        if (index >= 0 && index < items.length)
        {
            counter--;
            int[] newNumbers = new int[counter];

            for (int i = 0; i < counter; i++) {
                if (i < index)
                    newNumbers[i] = items[i];
                else if (i >= index)
                    newNumbers[i] = items[i + 1];
            }
            items = newNumbers;
        }
    }

    public int indexOf (int item) {
        for (int i = 0; i < counter; i++)
         if (items[i] == item)
             return i;
        return -1;
    }

    public int max () {
        int max = 0;
        for (int i = 0; i < counter; i++)
            if (items[i] > max)
                max = items[i];
        return max;
    }

    public int[] intersect (int[] comparator) {
        int intersectCounter = 0;
        int [] intersect = new int[counter];
        for (int i = 0; i < counter; i++)
            for (int k = 0; k < comparator.length; k++)
                if (items[i] == comparator [k]) {
                    intersect[intersectCounter] = items[i];
                    intersectCounter++;
                }
        int [] result = new int[intersectCounter];
                for (int j = 0; j < result.length; j++)
                    result[j] = intersect [j];
        return result;
    }

    public int[] reverse () {
        int [] reverse = new int[counter];
        for (int i = 0; i < reverse.length; i++)
            reverse[i] = items[--counter];
        return reverse;
    }

    public int[] insertAt(int item, int index) {
        if (index < 0 || index >= counter)
            throw new IllegalArgumentException();
        if (counter == items.length)
            items = Arrays.copyOf(items, items.length * 2);

        for (int i = counter; i > index; i--)
            items[i] = items[i-1];
        items[index] = item;

        counter++;

        return items;
    }
}
