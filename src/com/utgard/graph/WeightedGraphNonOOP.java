package com.utgard.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraphNonOOP {
    private class Node {
        private String label;

        public Node (String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge (Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return  from + "->" + to;
        }
    }

    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        var nodeFrom = nodes.get(from);
        var nodeTo = nodes.get(to);

        if (nodeFrom == null || nodeTo == null)
            throw new IllegalArgumentException();

        adjacencyList.get(nodeFrom).add(new Edge(nodeFrom, nodeTo, weight));
        adjacencyList.get(nodeTo).add(new Edge(nodeTo, nodeFrom, weight));
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

//    public void printMy() {
//        for (Node n : adjacencyList.keySet()) {
//            adjacencyList.get(n);
//            for (Edge e : adjacencyList.get(n))
//                System.out.println(n.label+"->"+e.to.label);
//        }
//    }
}

