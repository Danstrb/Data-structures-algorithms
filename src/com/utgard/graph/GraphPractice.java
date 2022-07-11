package com.utgard.graph;

public class GraphPractice {
    public void practice () {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "B", 2);
        graph.addEdge("C", "D", 5);
        graph.addEdge("B", "D", 42);

        System.out.println("Done");
        graph.print();

        graph.getLowestTree().print();
        System.out.println("done");

    }
}
