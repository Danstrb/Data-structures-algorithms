package com.utgard.queues;

import java.util.LinkedList;

public class LinkedListQueue {
    private Node head;
    private Node tail;
    private int counter = 0;

    public class Node {
        private Node next;
        private int value;
    }


    public void enqueue(int item) {
        Node node = new Node();
        node.value = item;
        node.next = null;

        if (counter == 0) {
            head = node;
            tail = node;
        }

        else{
            tail.next = node;
            tail = node;
        }
        counter++;
    }

    public int dequeue () {
        if (isEmpty())
            throw new IllegalStateException();

        int headValue = head.value;
        var next = head.next;
        head.next = null;
        head = next;
        counter--;
        return headValue;
    }

    public int peek () {
        return head.value;
    }

    public int size () {
        return counter;
    }

    public boolean isEmpty() {
        return counter == 0;
    }
}
