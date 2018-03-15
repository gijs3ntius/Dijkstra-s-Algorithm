package dijkstra.self;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Graph {
    private WeightedVertexPriorityQueue vertices;

    Graph() {
        vertices = new WeightedVertexPriorityQueue();
    }

    List<Vertex> getVertices() {
        return vertices.getVertices();
    }

    List<Vertex> FindShortestPathDijkstra(Vertex source, Vertex target) {
        if (!vertices.contains(target) || !vertices.contains(source))
            return null;
        if (source == target) {
            return null;
        }
        source.setWeight(0);
        vertices.update(source);
        int shortestPath = Integer.MAX_VALUE;
        while (vertices.isNotVisitedLeft()) {
            Vertex smallest = vertices.pullSmallest();
            if (smallest.getWeight() > shortestPath) {
                break; // stop checking because shortest path is already found
            }
            for (Edge edge: smallest.getEdges()) {
                Vertex neighbour = edge.getDifferentNode(smallest);
                int tempWeight = smallest.getWeight() + edge.getCost();
                if (neighbour.getWeight() > tempWeight) {
                    neighbour.setWeight(tempWeight);
                    neighbour.setParent(smallest);
                    vertices.update(neighbour);
                }
            }
            smallest.setVisited();
            vertices.update(smallest);
            if (target.isVisited()) {
                shortestPath = target.getWeight();
            }
        }
        if (shortestPath < Integer.MAX_VALUE) { // path is found if smaller than MAX_VALUE
            LinkedList<Vertex> vertices = new LinkedList<>();
            vertices.addFirst(target);
            while (target.getParent() != null) {
                target = target.getParent();
                vertices.addFirst(target);
            }
            return vertices;
        } else {
            return null; // there is no path
        }
    }

    Vertex getRandomVertex() {
        Random r = new Random();
        return vertices.getVertex(r.nextInt(vertices.getSize()));
    }

    Vertex getVertex(String name) {
        return vertices.getVertex(name);
    }

    void addEdge(Vertex a, Vertex b, int distance) {
        if (a == b) {
            return;
        }
        vertices.insert(a);
        vertices.insert(b);
        a.addEdge(b, distance);
        b.addEdge(a, distance);
    }
}
