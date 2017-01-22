import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 *
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 * @see Shape
 */

public class Segment extends Shape
{
    // YOU FILL IN INSTANCE VARIABLES AND METHODS.

    //------------------------------------------------------- Yazan Barhoush Start

    private int left, top; // left and top of Ellipse
    private int width, height; // Ellipse's height and width
    private static final int tolerance = 3;
    /**
     * Constructor just saves the parameters in the instance variables.
     *
     * @param left x coordinate of the top-left corner
     * @param top y coordinate of the top-left corner
     * @param width the width
     * @param height the height
     * @param color the color
     */
    public Segment(int left, int top, int width, int height, Color color)
    {
        super(color);
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    /**
     * Have the segment draw itself.
     *
     * @param page the page you wish to draw on
     */
    public void drawShape(Graphics page)
    {
        page.drawLine(left, top, width, height);
    }

    /**
     * Return true if the Segment contains Point p, false otherwise.
     *
     * @param p point tested for containment
     */
    public boolean containsPoint(Point p)
    {
        return false;
    }

    /**
     * Have the Segment move itself.
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
     * Return the Segment's center.
     *
     * @return the center of the Ellipse
     */
    public Point getCenter()
    {
        return new Point(left + (width / 2), top + (height / 2));
    }

    //------------------------------------------------------- Yazan Barhoush End

    // Helper method that returns true if Point p is within a tolerance of a
    // given bounding box. Here, the bounding box is given by the coordinates of
    // its left, top, right, and bottom.
    private static boolean almostContainsPoint(Point p, int left, int top,
                                               int right, int bottom, double tolerance) {
        return p.x >= left - tolerance && p.y >= top - tolerance
                && p.x <= right + tolerance && p.y <= bottom + tolerance;
    }

    // Helper method that returns the distance from Point p to the line
    // containing a line segment whose endpoints are given.
    private static double distanceToPoint(Point p, int x1, int y1, int x2,
                                          int y2) {
        if (x1 == x2) // vertical segment?
            return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
        else if (y1 == y2) // horizontal segment?
            return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
        else {
            // Here, we know that the segment is neither vertical nor
            // horizontal.
            // Compute m, the slope of the line containing the segment.
            double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

            // Compute mperp, the slope of the line perpendicular to the
            // segment.
            double mperp = -1.0 / m;

            // Compute the (x, y) intersection of the line containing the
            // segment and the line that is perpendicular to the segment and that
            // contains Point p.
            double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
                    / (mperp - m);
            double y = m * (x - x1) + y1;

            // Return the distance between Point p and (x, y).
            return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
        }
    }


}
