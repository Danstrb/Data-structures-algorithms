package com.utgard.graph;

import java.util.*;
import java.util.stream.Collectors;

public class GraphMy {
    private class Node {
        String label;
        public Node(String label) {
            this.label = label;
        }
    }
    private int size = 0;

    private Node[] nodes = new Node[10];
    private LinkedList<Node>[] linkedLists = new LinkedList[10];
    private Map<String, Integer> indexTable = new HashMap<>();

    public void addNode (String label) {
        nodes[size] = new Node(label);
        linkedLists[size] = (new LinkedList<>());
        indexTable.put(label, size++);
    }

    public void removeNode (String label) {
        if (!indexTable.containsKey(label))
            return;

        var index = indexTable.get(label);
        for (var linkedList : linkedLists)
            if (linkedList != null)
                linkedList.remove(nodes[index]);
        indexTable.remove(label);
        linkedLists[index] = null;
        nodes[index] = null;
        size--;
    }

    public void addEdge (String from, String to) {
        var indexFrom = indexTable.get(from);
        var indexTo = indexTable.get(to);

        if (indexFrom == null || indexTo == null || linkedLists[indexFrom].contains(nodes[indexTo]))
            return;

        linkedLists[indexFrom].add(nodes[indexTo]);
    }

    public void removeEdge (String from, String to) {
        var indexFrom = indexTable.get(from);
        var indexTo = indexTable.get(to);

        linkedLists[indexFrom].remove(nodes[indexTo]);
    }
    public void print () {
        for (String name : indexTable.keySet()) {
            System.out.println(name + " is connected to " +
                    Arrays.toString(linkedLists[indexTable.get(name)]
                    .stream()
                    .map(node -> node.label)
                    .collect(Collectors.toList()).toArray()));
        }
    }
}

