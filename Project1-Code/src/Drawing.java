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
    private ArrayList<Shape> shapes;    //  list of Shape objects,  in order from front to back
    private Color currentColor;         // current default color

    /**
     * A constructor, which creates an empty drawing
     * -- with an initial default Color given as a parameter.
     *
     * The init method of the Editor class in Editor.java calls it.
     *
     * @params initialColor the initial drawing color
     */
    public Drawing(Color initialColor)
    {}

    /**
     * given a reference to a Graphics object, has each Shape in the drawing draw itself.
     *
     * The paintComponent method of the CanvasPanel class in Editor.java calls it.
     *
     * @params page the page you wish to draw the shapes on
     */
    public void draw(Graphics page)
    {}

    /**
     * given a reference to a Point:
     * returns the frontmost Shape in the drawing that contains the Point,
     * or null if no Shape contains the Point.
     * The executeClick method of ExchangeCmd calls it.
     *
     * @return the front most shape contains the point or null if no shape is found
     * @params p, the point under which you wish to find the frontmost shape
     */
    public Shape getFrontmostContainer(Point p)
    {
        return null;
    }
}