import java.util.ArrayList;
import java.awt.*;

/**
 * This class stores a drawing as an ordered list of Shape objects.
 * Created by fedora on 1/14/17.
 *
 * @author Yazan Barhoush
 */

public class Drawing
{
    private ArrayList<Shape> listOfShapes;      //list of Shapes
    /**
     * A constructor, which creates an empty drawing
     * called by: init method in Editor.java
     * @param initialColor: default color, starts as red according to Editor.java
     */
    public Drawing(Color initialColor)
    {
        listOfShapes = new ArrayList<>();
    }

    /**
     * Add a new shape to the ArrayList listOfShapes
     * @param shape
     */
    public void addShape(Shape shape)
    {
        listOfShapes.add(shape);
    }

    /**
     * Have each Shape in Drawing.java draw itself, given a reference to a Graphics object
     * -- Draw all shapes
     * called by: paintComponent method in CanvasPanel class in Editor.java
     * @params g
     */
    public void draw(Graphics g)
    {
        for (Shape shape : listOfShapes)
        {
            shape.draw(g);
        }
    }

    /**
     * returns the frontmost Shape in the drawing that contains the Point
     * or null if no Shape contains the Point,
     * given a reference to a Point
     * called by: executeClick method in ExchangeCmd.java
     * @return front most shape contains the point or null if no shape is found
     * @params p: the point under which you wish to find the frontmost shape
     */
    public Shape getFrontmostContainer(Point p)
    {return null;}
}