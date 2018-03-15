package dijkstra.self;

import java.util.Random;

public class GraphBuilder {

    /**
     * Function to generate a random graph
     * @param size
     * @param maxDistance
     * @return
     */
    Graph BuildRandomGraph(int size, int maxDistance) {
        Graph g = new Graph();
        Random r = new Random();
        int n = r.nextInt(size) + 2; //min 2 max X
        char[] chars = new char[n];
        Vertex[] vertices = new Vertex[n];
        for (int i=0; i<n; i++) {
            chars[i] = (char) (65 + i);
        }
        for (int i=0; i<n; i++) {
            vertices[i] = new Vertex("" + chars[i]);
        }
        for (Vertex v : vertices) {
            for (int i = 0; i < n / 2; i++)
                g.addEdge(v, vertices[r.nextInt(n)], r.nextInt(maxDistance) + 1); // minimal 0
        }
        return g;
    }

    /**
     * Example function of building a graph
     * @return
     */
    public Graph buildCustomGraph() {
        Graph g = new Graph();
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");
        Vertex vertexG = new Vertex("G");
        Vertex vertexH = new Vertex("H");
        Vertex vertexI = new Vertex("I");
        Vertex vertexJ = new Vertex("J");
        Vertex vertexL = new Vertex("L");
        Vertex vertexM = new Vertex("M");
        Vertex vertexN = new Vertex("N");
        Vertex vertexO = new Vertex("O");
        g.addEdge(vertexA, vertexB, 3);
        g.addEdge(vertexB, vertexC, 4);
        g.addEdge(vertexB, vertexD, 1);
        g.addEdge(vertexA, vertexE, 2);
        g.addEdge(vertexE, vertexD, 6);
        g.addEdge(vertexE, vertexF, 8);
        g.addEdge(vertexE, vertexG, 2);
        g.addEdge(vertexF, vertexH, 7);
        g.addEdge(vertexG, vertexH, 3);
        g.addEdge(vertexD, vertexJ, 5);
        g.addEdge(vertexD, vertexI, 2);
        g.addEdge(vertexJ, vertexL, 4);
        g.addEdge(vertexI, vertexL, 6);
        g.addEdge(vertexI, vertexM, 1);
        g.addEdge(vertexN, vertexM, 1);
        g.addEdge(vertexL, vertexN, 9);
        g.addEdge(vertexL, vertexO, 3);
        return g;
    }
}
