package com.utgard.heap;

public class MinHeap {
    private class Node {
        private int key;
        private String value;

        public Node (int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] array = new Node[20];
    private int size = 0;
    private int totalItemsAdded = 0; //new

    public void insert (int key, String value) {
        totalItemsAdded++; //new
        array[size++] = new Node(key, "value " + totalItemsAdded + " of priority " + key); //updated
        heapifyFromBotToTop();
    }

    public void remove () {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        array[0] = array[--size];
        hepifyFromTopToBot();
    }

    public void insert (int item) {
        array[size++] = new Node(item, "value " + item);
        heapifyFromBotToTop();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void hepifyFromTopToBot() {
        for (int i = 0; i <= size / 2 - 1; i++) {
            if (!hasRightChild(i)
                    && parentGreaterThanLeftChild(i))
                swapItemsInArray(i, leftChildIndex(i));
            else if (hasRightChild(i)
                    && (parentGreaterThanLeftChild(i) || parentGreaterThanRightChild(i)))
                swapItemsInArray(i, getLargerChildIndex(i));
        }
    }

    private void heapifyFromBotToTop() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            if (!hasRightChild(i)
                    && parentGreaterThanLeftChild(i))
                swapItemsInArray(i, leftChildIndex(i));
            else if (hasRightChild(i)
                    && (parentGreaterThanLeftChild(i) || parentGreaterThanRightChild(i)))
                swapItemsInArray(i, getLargerChildIndex(i));
        }
    }

    private int getLargerChildIndex(int index) {
        return (array[leftChildIndex(index)].key < array[rightChildIndex(index)].key) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasRightChild(int index) {
//        return result = array[rightChildIndex(index)] == null;
        return array[rightChildIndex(index)] != null;
    }

    private boolean parentGreaterThanLeftChild(int index) {
        return array[index].key > array[leftChildIndex(index)].key;
    }

    private boolean parentGreaterThanRightChild(int index) {
        return array[index].key > array[rightChildIndex(index)].key;
    }

    private void swap (Node first, Node second) {
        Node temp = second;
        second = first;
        first = temp;
    }

    private Node[] swapItemsInArray(int first, int second) {
        Node temp = array[second];
        array[second] = array[first];
        array[first] = temp;

        return array;
    }


    private int parent(int index) {
        return index / 2 - 1;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++)
//        for (Node node : array)
//            if (node != null)
//                result += node.key + ", ";
            result += array[i].key + ", ";
        return result;
    }

}
