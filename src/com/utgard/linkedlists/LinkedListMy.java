package com.utgard.linkedlists;

import java.util.ArrayList;

public class LinkedListMy {
    private Node first;
    private Node last;

    private int counter = 0;

    ArrayList<Node> nodeList = new ArrayList<Node>();
    ArrayList<Integer> valueList = new ArrayList<Integer>();

    public void addLast (int value) {
        var newNode = new Node(value);
        last = newNode;

        nodeList.add(newNode);
        valueList.add(value);

        if (nodeList.size() == 1)
            first = newNode;
        else
            nodeList.get(counter-1)
                    .setNext(newNode);

        counter++;
    }

    public void addFirst (int value) {
        var newNode = new Node(value);

        nodeList.add(0, newNode);
        valueList.add(0, value);

        if (nodeList.size() > 1)
            newNode.setNext(first);

        first = newNode;
        counter++;
    }

    public void deleteFirst () {
        Node second;
        second = first.getNext();

        first.setNext(null);

        first = second;

        nodeList.remove(0);
        valueList.remove(0);

        counter--;
    }

    public void deleteLast () {
        // 483 487 488 489
        Node marker = first;
        for (int i = 0; i < counter; i ++) {
            marker.getNext();
            if (marker.getNext() == last) {
                last = marker;
                marker.setNext(null);
            }
            else marker = marker.getNext();
        }

        nodeList.remove(counter-1);
        valueList.remove(counter-1);

        counter--;
    }

    public boolean contains (int item) {
        Node marker = first;

        for (int i = 0; i < counter; i++) {
            if (marker.getValue() == item)
                return true;
            else {
                marker = marker.getNext();
            }
        }
        return false;
    }

    public int indexOf (int item) {
        int index = -1;
        Node marker = first;

        for (int i = 0; i < counter; i++) {
            if (marker.getValue() == item)
                return i;
            else
                marker = marker.getNext();
            }
        return index;
    }

    public int size () {
        return counter;
    }

    public void print () {
            System.out.println(valueList);
//            System.out.println(first.getNext().getNext().getValue());
        }

    public int[] toArray () {
        int[] array = new int[counter];
        var current = first;
        var index = 0;

        for (int i = 0; i < counter; i++) {
            array[index++] = current.getValue();
            current = current.getNext();
        }
        return array;
    }

    public void reverseOrder () {
        var previous = first;
        var current = first.getNext();
        var next = current.getNext();

        while (current.getNext() != null) {
            if (previous == first) {
                last = previous;
                last.setNext(null);
            }

            current.setNext(previous);
            previous = current;
            current = next;
            next = current.getNext();

            if (current.getNext() == null) {
                current.setNext(previous);
                first = current;
                break;
            }
        }
    }
//    public void reverseOrderMy() {
//        var previous = first;
//        var current = first.getNext();
//
//        for (int i = 0; i < counter-1; i++) {
//                current.setPrevious(previous);
//                previous = previous.getNext();
//                current = current.getNext();
//        }
//        current = last;
//        previous = last.getPrevious();
//
//        for (int i = 0; i < counter-1; i++) {
//            if (current == last)
//                first = current;
//
//            if (previous == null) {
//                last = current;
//                last.setPrevious(null);
//            }
//
//            current.setNext(previous);
//
//            current.setPrevious(null);
//            current = previous;
//            previous = current.getPrevious();
//        }
//    }


    //   public void reverseOrderFail () { THE MEMORIAL OF FAILURE
//        var previous = first;
//        var current = first.next;
//
//
//        Node placeHolderPreviousNew = new Node(current.value);
//        placeHolderPreviousNew.next = previous;
//        Node placeHolderCurrent = new Node(current.value);
//        placeHolderCurrent.next = current.next;
//
//        for (int i = 0; i < size-1; i++) {
//
//            System.out.println(previous.value);
//            System.out.println(current.value);
//
//            if (previous == first) {
//                last = previous;
//                first = current;
//
//                previous = current;
//                current = current.next;
//                previous = placeHolderPreviousNew;
//                previous.next.next = null;
//            }
//
//            else if (current.next == null) {
//                first = current;
//                current.next = previous;
//                break;
//            }
//
//            else {
//                placeHolderPreviousNew.next = getPrevious(current);
//                placeHolderPreviousNew.value = current.value;
//
//                placeHolderCurrent.next = current.next;
//                placeHolderCurrent.value = current.value;
//
//                first = current;
//
//                previous = current;
//                current = current.next;
//                previous.next = placeHolderPreviousNew.next;
//            }
//        }
////        System.out.println(first.next.value);
//    }

    public int getFirstValue() {
        return first.getValue();
    }

    public int getLastValue() {
        return last.getValue();
    }
}
