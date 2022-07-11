package com.utgard.queues;

import java.util.Arrays;

public class PriorityQueueMy {
    private int[] items = new int[5];
    private int count = 0;
    private int front = 0;
    private int rear = 0;

    public void enqueue (int item) {
        if (count == items.length)
            throw new IllegalStateException();

        if (isEmpty()) {
            items[rear] = item;
            rear++;
        }
        else if (itemIsNotLargestNumberToRear(item)) {
            moveArrayToRearFromBack(item);
            rear++;
        }
        else if (itemIsLargestNumberToRear(item)) {
            items[rear] = item;
            rear++;
        }
        else if (itemIsNotSmallestNumberToFront(item)) {
            moveArrayToRearFromFront(item);
            front--;
        }
        else if (itemIsSmallestNumberToFront(item)) {
            items[--front] = item;
        }
        count++;
    }

    public int dequeue () {
        if (count == 0)
            throw new IllegalStateException();

        var frontItem = items[front];
        items[front++] = 0;
        count--;
        return frontItem;
    }

    public int peek () {
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull(){
        return rear == count && !isEmpty();
    }

    public String toString () {
        return Arrays.toString(items);
    }

    private boolean itemIsLargestNumberToRear(int item) {
        return rear != items.length && item >= items[rear-1];
    }
    private boolean itemIsNotLargestNumberToRear(int item) {
        return rear != items.length && item < items[rear - 1];
    }
    private boolean itemIsNotSmallestNumberToFront(int item) {
        return rear == items.length && item > items[front];
    }

    private boolean itemIsSmallestNumberToFront(int item) {
        return rear == items.length && item <= items[front];
    }

    private void moveArrayToRearFromBack(int item) {
        int i = rear - 1;
        while (i >= 0 && item < items[i]) {
            items[i + 1] = items[i];
            items[i] = item;
            i--;
        }
    }
    private void moveArrayToRearFromFront(int item) {
        int k = front;
        while (k < items.length && items[k] < item) {
            items[k - 1] = items[k];
            items[k] = item;
            k++;
        }
    }
//    private int iterateFrontForward () {
//        return front = (front + 1) % items.length;
//    }
//
//    private int iterateRearForward () {
//        return rear = (rear + 1) % items.length;
//    }
//
//    private int iterateFrontBackward () {
//        if (front != 0)
//            front = (front - 1) % items.length;
//        else
//            front = front - 1 + items.length;
//        return front;
//    }
//
//    private int iterateRearBackward () {
//        if (rear != 0)
//            rear = (rear - 1) % items.length;
//        else
//            rear = rear - 1 + items.length;
//        return rear;
//    }
}

