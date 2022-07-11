package com.utgard.avltree;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value=" + this.value;
        }
    }

    private AVLNode root = null;

    public void insert(int value) {
        root = insert(value, root);
    }
    private AVLNode insert(int value, AVLNode root) {
        if (root == null)
            return new AVLNode(value);
        if (value < root.value)
            root.leftChild = insert(value, root.leftChild);
        else
            root.rightChild = insert(value, root.rightChild);

        setHeight(root);
//        root.height = Math.max(
//                height(root.leftChild),
//                height(root.rightChild)) + 1;
//        if (root.leftChild == null)
//            root.height = root.rightChild.height + 1;
//        else if (root.rightChild == null)
//            root.height = root.leftChild.height + 1;
//        else if (root.leftChild == null && root.rightChild == null)
//            root.height = 0;
//        else
//            root.height = Math.max(root.leftChild.height, root.rightChild.height) + 1;
        return balance(root);
    }


    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced (AVLNode root) {
        if (root == null)
            return true;
        return height(root.leftChild) - height(root.rightChild) >= -1 && height(root.leftChild) - height(root.rightChild) <= 1
                && isBalanced(root.leftChild)
                && isBalanced(root.rightChild);
    }

    public boolean isPerfect () {
        double numberOfItems = 0;
        for (int i = root.height; i >= 0; i--)
            numberOfItems += Math.pow(2, i);
        return numberOfNodes(root) == numberOfItems;
    }

    private int numberOfNodes (AVLNode node) {
        if (node == null)
            return 0;
        return numberOfNodes(node.leftChild) + numberOfNodes(node.rightChild) + 1;
    }

    private AVLNode balance (AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            root = rotateRight(root);
        }

        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            root = rotateLeft(root);
        }

        return root;
    }

    private AVLNode rotateRight (AVLNode root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateLeft (AVLNode root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private int height (AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private int setHeight (AVLNode node) {
        return node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }

    private boolean isLeftHeavy (AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy (AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor (AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

//    public void insertMy (int value) {
//        insertMy(value, root);
//    }
//    private void insertMy (int value, AVLNode node) {
//        if (root == null)
//            root = new AVLNode(value);
//        else if (value < node.value && node.leftChild == null)
//            node.leftChild = new AVLNode(value);
//        else if (value < node.value)
//            insertMy(value, node.leftChild);
//        else if (value > node.value && node.rightChild == null)
//            node.rightChild = new AVLNode(value);
//        else if (value > node.value)
//            insertMy(value, node.rightChild);
//     }
}
