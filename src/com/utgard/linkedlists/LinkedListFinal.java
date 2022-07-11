package com.utgard.linkedlists;

import java.util.NoSuchElementException;

public class LinkedListFinal {
    private class Node {
        private int value;
        private Node next;

        public Node (int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast (int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
         last.next = node;
         last = node;
        }

        size++;
    }

    public void addFirst (int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast () {
        if (isEmpty())
            throw new NoSuchElementException();
        else if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            previous.next = null;
            last = previous;
            }
        size--;
    }

    public int size() {
        return size;
    }

    public void reverseOrder () {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;

            last = first;
            last.next = null;
            previous = last;
        }
    }

    public int getKthFromTheEnd (int k) {
//          WITH SIZE IN PLAY
//        if (k < 1 || k > size) return -1;
//        Node pointer = first;
//        for (int i = 0; i < size-k; i++)
//            pointer = pointer.next;
//        System.out.println(pointer.value);
//        return pointer.value;
        if (isEmpty())
            throw new IllegalStateException();

        Node a = first;
        Node b = first;
        while (b != last) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b.next != null) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public void printMiddle () {
        if (isEmpty() || first.next == last)
            return;

        var a = first;
        var b = first.next;

        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last) {
            System.out.println(a.value);
            System.out.println(a.next.value);
        }
        else
            System.out.println(a.next.value);
    }

    public boolean hasLoop () {
        Node a = first;
        Node b = first;

        while (b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b)
                return true;
        }
        return false;
    }

    public void setLoop () {
        last.next = first;
    }

    public int[] toArray () {
        int[] array = new int[size]; // int[size]
        var current = first;
        var index = 0;

        while (current != null)
//        for (int i = 0; i < size; i++) // i < size
        {
            array[index++] = current.value;
            current = current.next;
            }
        return array;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty () {
        return first == null;
    }
}
