import javax.swing.*;
import java.awt.*;

public class Renderer {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        // slider to control horizontal rotation
        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        // slider to control vertical rotation
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);

        // panel to display render results
        JPanel renderPanel = new JPanel() {
                public void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setColor(Color.BLACK);
                    g2.fillRect(0, 0, getWidth(), getHeight());

                    g2.translate(getWidth() / 2, getHeight() / 2);
                    g2.setColor(Color.WHITE); // start off simple
                    Color[] colors = { Color.WHITE, Color.RED, Color.GREEN, Color.BLUE };
                    TetrahedronShape shape = new TetrahedronShape(100, 100, 100, colors);
                    shape.draw(g2);
                }
            };
        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
