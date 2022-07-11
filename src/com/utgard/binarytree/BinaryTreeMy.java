package com.utgard.binarytree;

public class BinaryTreeMy {
    private class Node {
        int value;
        Node leftChild;
        Node rightChild;
        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    public int count = 0;
    private Node current;

    public void insert (int value) {
        while (true) {
            if (checkIfEmptyThenCreate(value));
            else if (checkLeftIfNullThenCreate(value));
            else if (checkRightIfNullThenCreate(value));
            else return;
            }
    }

    public boolean find (int value) {
        while (true) {
            if (value <= current.value) {
                if (value == current.value)
                    return true;
                if (current.leftChild == null)
                    return false;
                current = current.leftChild;
            }
            if (value >= current.value) {
                if (value == current.value)
                    return true;
                if (current.rightChild == null)
                    return false;
                current = current.rightChild;
            }
        }
    }

    private boolean checkIfEmptyThenCreate (int value) {
        if (count == 0) {
            root = new Node(value);
            count++;
            current = root;
        }
        return count == 1;
    }

    private boolean checkLeftIfNullThenCreate(int value) {
        if (value < current.value) {
            if (current.leftChild == null) {
                current.leftChild = new Node(value);
                count++;
                current = root;
            }
            else
                current = current.leftChild;
        }
        return value < current.value;
    }

    private boolean checkRightIfNullThenCreate(int value) {
        if (value > current.value) {
            if (current.rightChild == null) {
                current.rightChild = new Node(value);
                count++;
                current = root;
            }
            else
                current = current.rightChild;
        }
        return value > current.value;
    }
}

