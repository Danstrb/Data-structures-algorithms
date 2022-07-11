package com.utgard.linkedlists;

public class Node {
    private int value;
    private Node next;
//    private Node previous;

    public Node (int value) {
        this.value = value;
    }

    public Node (int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

//

}
