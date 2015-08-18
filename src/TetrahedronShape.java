import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class TetrahedronShape implements Shape3D {

    private int bx;
    private int by;
    private int bz;
    private Color[] colors;

    public TetrahedronShape(int boundX, int boundY, int boundZ, Color[] colors) {
        bx = boundX;
        by = boundY;
        bz = boundZ;
        this.colors = Arrays.copyOf(colors, colors.length);
    }

    public void draw(Graphics2D graphics) {
        List<TriangleShape> tris = new ArrayList<TriangleShape>();
        tris.add(new TriangleShape(new Vertex(bx, by, bz), new Vertex(-bx, -by, bz), new Vertex(-bx, by, -bz), colors[0]));
        tris.add(new TriangleShape(new Vertex(bx, by, bz), new Vertex(-bx, -by, bz), new Vertex(bx, -by, -bz), colors[1]));
        tris.add(new TriangleShape(new Vertex(-bx, by, -bz), new Vertex(bx, -by, -bz), new Vertex(bx, by, bz), colors[2]));
        tris.add(new TriangleShape(new Vertex(-bx, by, -bz), new Vertex(bx, -by, -bz), new Vertex(-bx, -by, bz), colors[3]));

        // Render each triangle (side of the tetrahedron)
        for (TriangleShape triangle : tris) {
            triangle.draw(graphics);
        }
    }
}
