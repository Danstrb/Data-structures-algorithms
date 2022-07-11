package com.utgard.hashmap;

import java.util.LinkedList;

public class HashTableMy {

    private class KeyValuePair {
        int key;
        String value;

        private KeyValuePair (int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private int k;
    private LinkedList<KeyValuePair>[] linkedLists = new LinkedList[5];

    public void put (int k, String v) {
        this.k = k;
        LinkedList<KeyValuePair> newList;


        if (linkedListsSpecificIndex() == null) {
            newList = new LinkedList<>();
            newList.addFirst(new KeyValuePair(k, v));
            linkedLists[k % linkedLists.length] = newList;
        }
        else
            linkedListsSpecificIndex().addLast(new KeyValuePair(k, v));
    }

    public String get (int k) {
        if (linkedListsSpecificIndex() == null)
            throw new IllegalStateException();

        for (var item : linkedListsSpecificIndex()) {
            if (item.key == k)
                return item.value;
        }
        return "";
    }

    public void remove (int k) {
        if (linkedListsSpecificIndex() == null)
            throw new IllegalStateException();

        for (var item : linkedListsSpecificIndex()) {
            if (item.key == k)
                linkedListsSpecificIndex().remove(item);
        }
    }

    private LinkedList<KeyValuePair> linkedListsSpecificIndex() {
        return linkedLists[k % linkedLists.length];
    }
}

//    public String get (int k) {
////        var ble = linkedLists[k % linkedLists.length].lastIndexOf(this);
//        for (var item : linkedLists) {
//            if (linkedLists[k % linkedLists.length].peek().key == k)
//                return linkedLists[k % linkedLists.length].peek().value;
//            else if (linkedLists[k % linkedLists.length].get(0).key == k) ;
//        }
//        return "";
//    }
