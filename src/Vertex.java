package dijkstra.self;

import java.util.*;

public class Vertex extends Observable {
    private Set<Edge> edges;
    private List<Vertex> connections;

    private int weight;
    private boolean visited;
    private Vertex parent;
    private String name;

    Vertex(String name) {
        this.edges = new HashSet<>();
        this.connections = new LinkedList<>();
        this.weight = Integer.MAX_VALUE;
        this.parent = null;
        this.name = name;
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    Vertex getParent() {
        return parent;
    }

    void setParent(Vertex parent) {
        this.parent = parent;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited() {
        this.visited = true;
    }

    void addEdge(Vertex v, int distance) {
        if (!connections.contains(v)) {
            connections.add(v);
            edges.add(new Edge(this, v, distance));
        }
    }

    List<Edge> getEdges() {
        if (edges.size() > 0) {
            List temp = new LinkedList<>();
            temp.addAll(edges);
            return temp;
        }
        return null;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + '{' + "connections=" + edges.size() + ", " + "Weight=" + weight  + '}';
    }
}
