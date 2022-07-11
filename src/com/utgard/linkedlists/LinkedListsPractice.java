package com.utgard.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListsPractice {
    public static void linkedLists () {
        LinkedListFinal list = new LinkedListFinal();
//        LinkedListMy list = new LinkedListMy();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);

        list.printMiddle();

        var array = list.toArray();
        System.out.println(Arrays.toString(array));
    }
}
