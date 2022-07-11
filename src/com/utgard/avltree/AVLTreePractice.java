package com.utgard.avltree;

public class AVLTreePractice {
    public void practice () {
        var tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);







        System.out.println(tree.isPerfect());
        System.out.println("Done");

    }
}
