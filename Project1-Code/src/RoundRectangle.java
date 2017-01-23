/**
 * Round Rectangle Class
 * Created by fedora on 1/21/17.
 */
import java.awt.*;

public class RoundRectangle extends Shape
{
    private int left, top; // left and top of Rectangle's
    private int width, height;  // Rectangle's width and height
    private int arcWidth, arcHeight;  // Rectangle's arc width and height
    /**
     * Constructor just saves the parameters in the instance variables.
     *
     * @param left x coordinate of the top-left corner
     * @param top y coordinate of the top-left corner
     * @param width the width
     * @param height the height
     * @param color the color
     */
    public RoundRectangle(int left, int top, int width, int height,int arcWidth,int arcHeight, Color color)
    {
        super(color);
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    /**
     * Have the Rectangle draw itself.
     *
     * @param page the page you wish to draw on
     */
    public void drawShape(Graphics page)
    {
        page.fillRoundRect(left, top, width, height, arcWidth, arcHeight);
    }

    /**
     * Return true if the Rectangle contains Point p, false otherwise.
     *
     * @param p point tested for containment
     */
    public boolean containsPoint(Point p)
    {
        return pointInRectangle(p, left, top, width, height);
    }
    // Helper method that returns whether Point p is in an Rectangle with the given
    // top left corner and size.
    private static boolean pointInRectangle(Point p, int left, int top, int width, int height)
    {
        double a = width / 2.0; // half of the width
        double b = height / 2.0; // half of the height
        double centerx = left + a; // x-coord of the center
        double centery = top + b; // y-coord of the center
        double x = p.x - centerx; // horizontal distance between p and center
        double y = p.y - centery; // vertical distance between p and center

        // Now we just apply the standard geometry formula.
        // (See CRC, 29th edition, p. 178.)
        return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
    }

    /**
     * Have the Rectangle move itself.
     *
     * @param deltaX new x coordinate
     * @param deltaY new y coordinate
     */
    public void move(int deltaX, int deltaY)
    {
        left += deltaX;
        top += deltaY;
    }

    /**
     * Return the Rectangle's center.
     *
     * @return the center of the Rectangle
     */
    public Point getCenter()
    {
        return new Point(left + (width / 2), top + (height / 2));
    }
}