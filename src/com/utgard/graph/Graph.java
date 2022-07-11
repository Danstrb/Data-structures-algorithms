package com.utgard.graph;

import java.util.*;

public class Graph {
    private class Node {
        private String label;
        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (var source :adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets. isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;

        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthRecursive(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;

        traverseDepthRecursive(node, new HashSet<>());
    }

    private void traverseDepthRecursive(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (Node adjacentNode : adjacencyList.get(root))
            if (!visited.contains(adjacentNode))
                traverseDepthRecursive(adjacentNode, visited);
    }

    public void traverseDepthIterative(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;

        Stack<Node> stack = new Stack<>();
        Set<Node> visitedNodes = new HashSet<>();
        stack.push(node);

        while (!stack.empty()) {
            var current = stack.pop();

            if (visitedNodes.contains(current)) // Redundant? But Mosh had it
                continue;

            System.out.println(current);
            visitedNodes.add(current);

            for (Node adjacentNode : adjacencyList.get(current))
                if (!visitedNodes.contains(adjacentNode))
                    stack.push(adjacentNode);
        }
    }

    public void traverseBreadthIterative(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;

        Set<Node> visitedNodes = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            var current = queue.poll();

            if (visitedNodes.contains(current)) // Redundant? But Mosh had it
                continue;

            System.out.println(current);
            visitedNodes.add(current);

            for (Node adjacentNode : adjacencyList.get(current))
                if (!visitedNodes.contains(adjacentNode))
                    queue.offer(adjacentNode);
        }
    }

    public List<String> topologicalSort() {
        Stack<String> reversedOrder = new Stack<>();
        Set<Node> visitedNodes = new HashSet<>();

        for (Node node : adjacencyList.keySet()) {
            if (node == null || visitedNodes.contains(node))
                continue;
            topologicalSort(node, visitedNodes, reversedOrder);
        }

        List<String> result = new ArrayList<>();
        while (!reversedOrder.empty())
            result.add(reversedOrder.pop());

        return result;
    }

    private void topologicalSort(Node root, Set<Node> visitedNodes, Stack<String> reversedOrder) {
        visitedNodes.add(root);
        for (Node current : adjacencyList.get(root))
            if (!visitedNodes.contains(current))
                topologicalSort(current, visitedNodes, reversedOrder);
        reversedOrder.push(root.label);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;
            if (visiting.contains(neighbour))
                return true;

            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }

    public boolean isCyclicalMy() {
        Map<String, Node> allNodes = new HashMap<>();
        Map<String, Node> visitingNodes = new HashMap<>();
        Map<String, Node> visitedNodes = new HashMap<>();
        boolean result;
        for (var node : adjacencyList.keySet())
            allNodes.put(node.label, node);

        for (var node : adjacencyList.keySet()) {
            if (!visitedNodes.containsKey(node)) {
                result = isCyclicalMy(node, allNodes, visitingNodes, visitedNodes);
                if (result)
                    return true;
            }
        }
        return false;
    }

    private boolean isCyclicalMy(Node root, Map<String, Node> allNodes, Map<String, Node> visitingNodes, Map<String, Node> visitedNodes) {
        if (visitingNodes.containsValue(root))
            return true;
        if (adjacencyList.get(root).isEmpty() && !visitedNodes.containsValue(root)) {
            visitedNodes.put(allNodes.remove(root.label).label, root);
            return false;
        }

        boolean result = false;
        if (allNodes.containsValue(root))
        visitingNodes.put(allNodes.remove(root.label).label, root);

        for (var node : adjacencyList.get(root)) {
            result = isCyclicalMy(node, allNodes, visitingNodes, visitedNodes);
            if (result)
                return true;
        }

        visitedNodes.putAll(visitingNodes);
        visitingNodes.clear();

        return result;
    }
}
