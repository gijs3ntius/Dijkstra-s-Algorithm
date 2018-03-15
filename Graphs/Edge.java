package dijkstra.self;

public class Edge {
    private int cost;
    private Vertex vertexA;
    private Vertex vertexB;

    Edge(Vertex a, Vertex b, int cost) {
        this.cost = cost;
        vertexA = a;
        vertexB = b;
    }

    int getCost() {
        return cost;
    }

    Vertex getDifferentNode(Vertex n) {
        if (n == null) {
            return null;
        }
        if (n == vertexA) {
            return vertexB;
        } else {
            return vertexA;
        }
    }

    @Override
    public String toString() {
//        return "Edge{ " + "cost=" + cost + ',' + vertexA + ', " + vertexB + " }";
        return "Edge {" + vertexA.getName() + "->" + vertexB.getName() + " = " + cost + '}';
    }

}
