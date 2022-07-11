package com.utgard.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private Node root;
    private boolean equalsFalseTracker = true;

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }
    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public boolean containsTree(int item) {
        return containsTree(root, item);
    }
    private boolean containsTree(Node root, int item) {
        if (root == null)
            return false;
        return root.value == item
                || containsTree(root.leftChild, item)
                || containsTree(root.rightChild, item);
    }
    public boolean containsBinaryTree(int item) {
        return containsBinaryTree(item, root);
    }
    private boolean containsBinaryTree(int item, Node root) {
        if (root == null)
            return false;
        else if (item < root.value)
            return containsBinaryTree(item, root.leftChild);
        else if (item > root.value)
            return containsBinaryTree(item, root.rightChild);
        return true;
    }
    public boolean equals (BinaryTree tree) {
        if (tree == null)
            return false;

        return equals(this.root, tree.root);
    }
    private boolean equals (Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }
    public int size () {
        return size(root);
    }
    private int size(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }
//    public int size() {
//        var list = new ArrayList<Integer>();
//        size(root, list);
//        return list.size();
//    }
//
//    private ArrayList<Integer> size(Node root, ArrayList<Integer> list) {
//        if (root == null)
//            return null;
//        else {
//            list.add(root.value);
//            size(root.leftChild, list);
//            size(root.rightChild, list);
//            return list;
//        }
//    }
    public int countLeaves() {
        return countLeaves(root);
    }
    private int countLeaves(Node root) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }
    public boolean areSiblings(int item1, int item2) {
        return areSiblings(item1, item2, root);
    }
    private boolean areSiblings(int item1, int item2, Node root) {
        if (root.leftChild == null || root.rightChild == null || item1 == root.value || item2 == root.value)
            return false;
        var min = Math.min(item1, item2);
        var max = Math.max(item1, item2);

        if (root.leftChild.value == min && root.rightChild.value == max)
            return true;
        else if (min < root.value && max < root.value)
            return areSiblings(item1, item2, root.leftChild);
        else if (min > root.value && max > root.value)
            return areSiblings(item1, item2, root.rightChild);
        return false;
    }
//    private boolean areSiblings(int item1, int item2, Node root) {
//    GOOD BUT NOT OPTIMAL
//        if (root.leftChild == null || root.rightChild == null || item1 == root.value || item2 == root.value)
//            return false;
//
//        var min = Math.min(item1, item2);
//        var max = Math.max(item1, item2);
//
//        if (min < root.value)
//            areSiblings(item1, item2, root.leftChild);
//        else if (min > root.value)
//            areSiblings(item1, item2, root.rightChild);
//
//
//        return root.leftChild.value == min && root.rightChild.value == max
//                || areSiblings(item1, item2, root.leftChild)
//                || areSiblings(item1, item2, root.rightChild);
//    }
//    public int maxMy () {
//        return max(root);
//    }
//    private int maxMy(Node root) {
//        if (root == null)
//            return 0;
//        return Math.max(Math.max(maxMy(root.leftChild), maxMy(root.rightChild)), root.value);
//    }
    public int max() {
        if (root == null)
            throw new IllegalStateException();

        return max(root);
    }
    private int max(Node root) {
        if (root.rightChild == null)
            return root.value;

        return max(root.rightChild);
    }
    public void swapRoot () {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    public List<Integer> getAncestorsBinary(int item) {
        List<Integer> list = new ArrayList<>();
        return getAncestorsBinary(item, list, root);
    }
    private List<Integer> getAncestorsBinary(int item, List<Integer> list, Node root) {
        if (root == null)
            return null;
        list.add(root.value);
        if (item < root.value)
            return getAncestorsBinary(item, list, root.leftChild);
        else if (item > root.value)
            return getAncestorsBinary(item, list, root.rightChild);
        return list;
    }

    public List<Integer> getAncestors (int item) {
        List<Integer> list = new ArrayList<>();
        getAncestors(item, list, root);
        return list;
    }

    private boolean getAncestors (int item, List<Integer> list, Node root) {
        if (root == null)
            return false;
        if (getAncestors(item,list,root.leftChild) || getAncestors(item,list,root.rightChild)) {
            list.add(root.value);
            return true;
        }
        return root.value == item;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            System.out.println(root.value);
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance-1, list);
        getNodesAtDistance(root.rightChild, distance-1, list);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value-1)
            && isBinarySearchTree(root.rightChild, root.value+1, max);
    }
    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }
    public int min () {
        return min(root);
    }
    private int min (Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }
    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    public void traverseInOrder() {
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }
    public void traversePostOrder() {
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
    private boolean isLeaf(Node node) {
        return (node.rightChild == null && node.leftChild == null);
    }
    public int height() {
        return height(root);
    }
}

//    public boolean isBinaryTreeMy () {
//        return isBinaryTreeMy(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    private boolean isBinaryTreeMy (Node node, int min, int max) {
//        if (node == null)
//            return true;
//
//        return (node.value > min && node.value < max)
//                && isBinaryTreeMy(node.leftChild, min, node.value)
//                && isBinaryTreeMy(node.rightChild, node.value, max);
//    }

//    public void nodesAtDistance (int distance) {
//        nodesAtDistance(root, distance);
//    }
//
//    private void nodesAtDistance (Node root, int k) {
//        if (root == null)
//            return;
//
//        if (k == 0) {
//            System.out.println(root.value);
//            return;
//        }
//
//        nodesAtDistance(root.leftChild, k-1);
//        nodesAtDistance(root.rightChild, k-1);
//    }
//    public boolean equalsMy (BinaryTree tree) {
//        return equalsMy(tree, this.root, tree.root);
//    }
//
//    private boolean equalsMy (BinaryTree tree, Node thisnode, Node treenode) {
//        if (thisnode == null && treenode == null)
//            return true;
//        else if (((thisnode == null) || (treenode == null)) || (thisnode.value != treenode.value)) {
//            equalsFalseTracker = false;
//            return false;
//        }
//        else if (!equalsFalseTracker)
//            return false;
//        equals(tree, thisnode.leftChild, treenode.leftChild);
//        equals(tree, thisnode.rightChild, treenode.rightChild);
//        return equalsFalseTracker;
//    }

//    private int minMy (Node root) {
//        if (root == null)
//            return Integer.MAX_VALUE;
//
//        return Math.min(root.value, Math.min(min(root.leftChild), min(root.rightChild)));
//    }
