package com.utgard.graph;

import java.util.*;

public class WeightedGraph {
     class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();


        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        var nodeFrom = nodes.get(from);
        var nodeTo = nodes.get(to);

        if (nodeFrom == null || nodeTo == null)
            throw new IllegalArgumentException();

        nodeFrom.addEdge(nodeTo, weight);
        nodeTo.addEdge(nodeFrom, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var targets = node.getEdges();
            if (!targets.isEmpty())
                System.out.println(node + " is connected to " + targets);
        }
    }

    class NodeEntry {
        Node node;
        int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from, String to) {
        if (from == null || to == null)
            throw new IllegalArgumentException();
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        Set<Node> visitedNodes = new HashSet<>();

        Node nodeFrom = nodes.get(from);
        Node nodeTo = nodes.get(to);

        for (Node n : nodes.values())
            distances.putIfAbsent(n, Integer.MAX_VALUE);
        distances.put(nodeFrom, 0);

        Node current = nodeFrom;

        while (visitedNodes.size() != nodes.size()) {
            visitedNodes.add(current);
            for (Edge e : current.getEdges()) {
                if (e.weight + distances.get(e.from) < distances.get(e.to)) {
                    queue.add(new NodeEntry(e.to, e.weight + distances.get(e.from)));
                    distances.put(e.to, (e.weight + distances.get(e.from)));
                    previousNodes.put(e.to, current);
                }
            }
            if (!queue.isEmpty())
                current = queue.remove().node;
        }
        return distances.get(nodeTo);
    }

    public List<String> getShortestPath(String from, String to) {
        if (from == null || to == null)
            throw new IllegalArgumentException();
        Node nodeFrom = nodes.get(from);
        Node nodeTo = nodes.get(to);

        Map<Node, Integer> distances = new HashMap<>();
        for (Node n : nodes.values())
            distances.putIfAbsent(n, Integer.MAX_VALUE);
        distances.replace(nodeFrom, 0);

        Set<Node> visitedNodes = new HashSet<>();

        Map<Node, Node> previousNodes = new HashMap<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        Node current = nodeFrom;
        while (visitedNodes.size() != nodes.size()) {
            visitedNodes.add(current);
            for (Edge e : current.getEdges()) {
                if (e.weight + distances.get(e.from) < distances.get(e.to)) {
                    queue.add(new NodeEntry(e.to, e.weight + distances.get(e.from)));
                    distances.put(e.to, (e.weight + distances.get(e.from)));
                    previousNodes.put(e.to, current);
                }
            }
            if (!queue.isEmpty())
                current = queue.remove().node;
        }

        List<String> list = new ArrayList<>(); //shoudl be as a separate private method for filling the Path object
        Node current2 = nodeTo;                // Path object should return a List<>
        while (!list.contains(nodeFrom.label)) {
            list.add(current2.label);
            current2 = previousNodes.get(current2);
        }
        return list; //should return Path object
    }

    public boolean hasCycle() {
        return hasCycleRecursive();
    }

    private boolean hasCycleIterative() {
        Set<Node> remaining = new HashSet<>();
        for (Node node : nodes.values())
            remaining.add(node);
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> parents = new HashMap<>();

        Node current = remaining.iterator().next();
        stack.push(current);

        while (!remaining.isEmpty()) {
            current = stack.pop();
            if (remaining.contains(current)) {
                visiting.add(current);
                remaining.remove(current);

                for (Edge edge : current.getEdges()) {
                    if (visiting.contains(edge.to) && !edge.to.equals(parents.get(current)))
                        return true;
                    else if (remaining.contains(edge.to)) {
                        parents.put(edge.to, current);
                        stack.add(edge.to);
                    } else {
                        visiting.remove(current);
                        visited.add(current);
                    }
                }
            }
        }
        return false;
    }

    private boolean hasCycleRecursive() {
        Set<Node> visited = new HashSet<>();

        for (Node node : nodes.values()) {
            if (!visited.contains(node) && (hasCycleRecursive(node, null, new HashSet<>())));
                    return true;
        }

        return false;
    }

    private boolean hasCycleRecursive(Node node, Node parent, Set<Node> visited) {
        if (node.getEdges().size() == 1 && node.getEdges().get(0).to == parent) //redundant?
            return false;

        boolean childResult = false;
        visited.add(node);

        for (Edge edge : node.edges) {
            if (edge.to == parent)
                continue;
            if (visited.contains(edge.to) || hasCycleRecursive(edge.to, node, visited))
                return true;
        }
        return false;
    }

    public Tree getLowestTree () {
        WeightedGraph tree = new WeightedGraph();
        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        Node current = nodes.values().iterator().next();
        Node previous = current;
        int tempPriority = Integer.MAX_VALUE;
        tree.addNode(current.label);
        visited.add(current);

        while (tree.size() != nodes.size()) {
            for (Edge edge : current.getEdges())
                if (!visited.contains(edge.to))
                    queue.add(new NodeEntry(edge.to, edge.weight));

            previous = current;
            for (Edge edge : queue.peek().node.getEdges())
                if (edge.weight == tempPriority)
                    previous = edge.to;
            if (visited.contains(queue.peek().node))
                queue.remove();
            tempPriority = queue.peek().priority;
            current = queue.remove().node;
            tree.addNode(current.label);
            tree.addEdge(previous.label, current.label, tempPriority);
            visited.add(current);
        }

        return new Tree(tree);
    }

    public int size() {
        return nodes.size();
    }

    public class Tree {
        private WeightedGraph tree = new WeightedGraph();

        public Tree(WeightedGraph tree) {
            this.tree = tree;
        }

        public void print() {
            tree.print();
        }
//        public void print() {
//            Set<Node> visited = new HashSet<>();
//            Node node = tree.nodes.values().iterator().next();
//            visited.add(node);
//            Node nextNode = (node.getEdges().get(0).to.equals(node)) ? node.getEdges().get(1).to : node.getEdges().get(0).to;
//            visited.add(nextNode);
//            String result;
//            result = node + " -> " + nextNode;
//
//            for (int i = 0; i < tree.size()-2; i++) {
//                node = nextNode;
//                nextNode = (visited.contains(node.getEdges().get(0).to)) ? node.getEdges().get(1).to : node.getEdges().get(0).to;
//                visited.add(nextNode);
//                result += " -> " + nextNode;
//            }
//            System.out.print(result);
//        }
    }
}