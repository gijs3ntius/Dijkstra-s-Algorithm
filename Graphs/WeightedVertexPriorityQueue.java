package dijkstra.self;

import java.util.*;

class WeightedVertexPriorityQueue {
    private LinkedList<Vertex> vertices;
    private int size;

    WeightedVertexPriorityQueue() {
        this.vertices = new LinkedList<>();
        this.size = 0;
    }

    void insert(Vertex n) {
        boolean inserted = false;
        if (vertices.contains(n)) { // if it is already in the list
            return;
        }
        for (Vertex vertex: vertices) {
            if (n.getWeight() < vertex.getWeight()) {
                vertices.add(vertices.indexOf(vertex), n);
                inserted = true;
            }
        }
        if (!inserted) {
            vertices.addLast(n);
        }
        size++;
    }

    void update(Vertex v) {
        if (v.isVisited()) {
            vertices.remove(v);
            vertices.addLast(v);
            return;
        }
        if (!vertices.contains(v)) { // if it is already in the list
            return;
        }
        vertices.remove(v);
        for (int i=0; i<vertices.size(); i++) {
            if (v.getWeight() < vertices.get(i).getWeight()) {
                vertices.add(i, v);
                break;
            }
        }
    }

    int getSize() {
        return size;
    }

    Vertex getVertex(int n) {
        return this.vertices.get(n);
    }

    Vertex getVertex(String name) {
        for (Vertex v : vertices) {
            if (name.equals(v.getName())) {
                return v;
            }
        }
        return null;
    }

    List<Vertex> getVertices() {
        return this.vertices;
    }

    Vertex pullSmallest() {
        if (!isEmpty()) {
            return vertices.peekFirst(); // use for pulling the smallest weighted vertex
        } else {
            return null;
        }
    }

    boolean isNotVisitedLeft() {
        // check if there are unweighted elements left
        for (Vertex vertex: vertices)
            if (!vertex.isVisited())
                return true;
        return false;
    }

    private boolean isEmpty() {
        return vertices.size() < 1;
    }

    boolean contains(Object o) {
        return o instanceof Vertex && vertices.contains(o);
    }
}
