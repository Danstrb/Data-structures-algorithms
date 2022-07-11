package com.utgard.binarytree;

public class BinaryTreePractice {
    public void binaryTreePractice () {
        var tree = new BinaryTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.getAncestors(10));
    }
}
