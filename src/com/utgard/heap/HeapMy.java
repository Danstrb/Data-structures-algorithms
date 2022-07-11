package com.utgard.heap;

import java.util.Arrays;

public class HeapMy {
    private int[] array = new int[20];
    private int freeIndex = 0;

    public void insert(int value) {
        array[freeIndex] = value;
        bubbleUp(freeIndex, value);
        freeIndex++;
    }

    public void remove() {
        if (freeIndex == 0)
            throw new IllegalStateException();

        array[0] = array[freeIndex-1];
        bubbleDown(0);
        array[freeIndex-1] = 0;
        freeIndex--;
    }


    private void bubbleUp(int index, int value) {
        if (array[index] > array[parent(index)]) {
            array[index] = array[parent(index)];
            array[parent(index)] = value;
        }
        if (index > 0)
            bubbleUp(parent(index), value);
    }

    private void bubbleDown(int index) {
        int value = array[freeIndex-1];
        if (array[index] < array[leftChild(index)] || array[index] < array[rightChild(index)]) {
            if (array[rightChild(index)] > array[leftChild(index)]) {
                array[index] = array[rightChild(index)];
                array[rightChild(index)] = value;
            }
            else {
                array[index] = array[leftChild(index)];
                array[leftChild(index)] = value;
            }
        }
        if (index < freeIndex)
            if (array[leftChild(index)] > array[rightChild(index)])
                bubbleDown(leftChild(index));
            else
                bubbleDown(leftChild(index));
    }

    @Override
    public String toString() {
        var newArray = Arrays.copyOfRange(array, 0, freeIndex);
        return Arrays.toString(newArray);
//        return Arrays.toString(array);
    }

    private int parent (int index) {
        return (index - 1) / 2;
    }

    private int leftChild (int index) {
        return (index * 2 + 1);
    }

    private int rightChild (int index) {
        return (index * 2 + 2);
    }
}
