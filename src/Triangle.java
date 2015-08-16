import java.awt.Color;

public class Triangle implements Shape2D {
    Vertex v1;
    Vertex v2;
    Vertex v3;
    Color color;

    public Triangle(Vertex vertex1, Vertex vertex2, Vertex vertex2, Color color) {
        v1 = vertex1;
        v2 = vertex2;
        v3 = vertex3;
        this.color = color;
    }

    public void draw(Graphics2D graphics) {
        Path2D path = new Path2D.Double();
        path.moveTo(v1.x, v1.y);
        path.lineTo(v2.x, v2.y);
        path.lineTo(v3.x, v3.y);
        path.closePath();
        graphics.draw(path);
    }
}
