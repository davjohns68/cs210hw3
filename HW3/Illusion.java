// CS210 Assignment #3 "Circles"
// David Johnson
// Draws an Ehrenstein Illusion to a drawing panel

import java.awt.*;

public class Illusion {

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(500,400);
        panel.setBackground(Color.CYAN);
        Graphics g = panel.getGraphics();
        //top-left (0,0) 90 x 90, 3 circles
        drawCircles(g, 0, 0, 90, 90, 3);
        // top-second-left (120,10), 90 x 90, 3 circles
        drawCircles(g, 120, 10, 90, 90, 3);
        // top-middle (250, 50), 80 x 80, 5 circles
        drawCircles(g, 250, 50, 80, 80, 5);
        // top-right (350, 20), 40 x 40, 5 circes, 3 x 3 grid
        drawSquare(g, 350, 20, 40 * 3, 40 * 3);
        drawGrid(g, 350, 20, 40, 40, 3, 3, 5);
        // bottom-left (10,120), 100 x 100, 10 circles, 2 x 2 grid
        drawSquare(g, 10, 120, 100 * 2, 100 * 2);
        drawGrid(g, 10, 120, 100, 100, 2, 2, 10);
        // bottom-right (240, 160), 50 x 50, 5 circles, 4 x 4 grid
        drawSquare(g, 240, 160, 50 * 4, 50 * 4);
        drawGrid(g, 240, 160, 50, 50, 4, 4, 5);
    }
    
    public static void drawGrid(Graphics g, int x, int y, int width, int height, int rows, int cols, int n) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                drawCircles(g, x + ((i - 1) * width), y + ((j - 1) * height), width, height, n);
            }
        }
    }

    public static void drawCircles(Graphics g, int x, int y, int width, int height, int n) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
        /*
        Concentric circle math was quite challenging!
        Considering that the start point (x,y) is not the center of the circle, it took quite
        come time to figure out how the math should work on each iteration.  It ends up that
        the start position must increase by i / <number of circles - 1> each time and the size
        must decrease by the same ratio each time
        */
        for (int i = 1; i <= n - 1; i++) {
            g.drawOval(x + width * i / n / 2, y + height * i / n / 2, width - width * i / n, height - height * i / n);  
        }
        int[] xPoints = { x, x + (width / 2), x + width, x + (width / 2) };
        int[] yPoints = { y + (height / 2), y, y  + (height / 2), y + height };
        g.drawPolygon(xPoints, yPoints, 4);
    }
   
    public static void drawSquare(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
        g.setColor(Color.RED);
        g.drawRect(x, y, width, height);
    }
}