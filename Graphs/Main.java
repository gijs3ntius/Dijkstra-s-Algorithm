package dijkstra.self;

import java.util.List;

public class Main {

    private static void printList(Object[] list) {
        printList(list, "List:");
    }

    private static void printList(Object[] list, String id) {
        System.out.println(id);
        for (Object item : list) {
            System.out.println("\t" + item);
        }
        System.out.println();
    }

    private static void printGraph(Graph g) {
        System.out.println("Graph overview:");
        for (Vertex v : g.getVertices()) {
            for (Edge e : v.getEdges()) {
                System.out.println("\t" + e.toString());
            }
        }
        System.out.println();
        printList(g.getVertices().toArray());
    }

    public static void main(String[] args) {
        GraphBuilder gb = new GraphBuilder();
        Vertex s, e;
        Graph g = gb.buildCustomGraph();
//        Graph g = gb.BuildRandomGraph(10, 20);
        printGraph(g);
        s = g.getVertex("");
        e = g.getVertex("");
        if (s == null) {
            s = g.getRandomVertex();
        }
        if (e == null) {
            e = g.getRandomVertex();
        }
        System.out.println("Start: " + s);
        System.out.println("End: " + e);
        System.out.println();
        List path = g.FindShortestPathDijkstra(s, e);
        if (path != null) {
            printList(path.toArray(), "Path: ");
        } else {
            System.out.println("Path could not be found");
        }
    }
}
