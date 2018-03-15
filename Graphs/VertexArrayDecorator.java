package dijkstra.self;

import java.util.Iterator;

public class VertexArrayDecorator implements Iterable{
    private int length;
    private int index;
    private Vertex[] vertices;

    public VertexArrayDecorator(Vertex[] vertices) {
        this.vertices = vertices;
        this.length = vertices.length;
        this.index = 0;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public Object next() {
                return vertices[index++];
            }
        };
    }
}
