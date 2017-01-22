
import java.util.ArrayList;
import java.awt.*;

/**
 * This class stores a drawing as an ordered list of Shape objects.
 * Created by fedora on 1/14/17.
 *
 * @author Yazan Barhoush
 */



public class Drawing {
    public ArrayList<Shape> listOfShapes;      //list of Shapes

    /**
     * A constructor, which creates an empty drawing
     * called by: init method in Editor.java
     *
     * @param initialColor: default color, starts as red according to Editor.java
     */
    public Drawing(Color initialColor) {
        listOfShapes = new ArrayList<>();
    }

    /**
     * Add a new shape to the ArrayList listOfShapes
     *
     * @param shape
     */
    public void addShape(Shape shape) {
        listOfShapes.add(shape);
    }

    /**
     * Have each Shape in Drawing.java draw itself, given a reference to a Graphics object
     * -- Draw all shapes
     * called by: paintComponent method in CanvasPanel class in Editor.java
     *
     * @params g
     */
    public void draw(Graphics g) {
        for (Shape shape : listOfShapes) {
            shape.draw(g);
        }
    }

    /**
     * returns the frontmost Shape in the drawing that contains the Point
     * or null if no Shape contains the Point, given a reference to a Point
     * called by: executeClick method in ExchangeCmd.java
     *
     * @return front most shape contains the point or null if no shape is found
     * @params p: the point under which you wish to find the frontmost shape
     */
    public Shape getFrontmostContainer(Point p) {
        ArrayList<Shape> shapesAtPoint = new ArrayList<>();         //ArrayList of all shapes at reference point
        int sizeOfShapesAtPoint;                                    //size of shapesAtPoint
        int index;

        for (index = 0; index < listOfShapes.size(); index++)       //iterate through indices of listOfShapes Array
        {
            if (listOfShapes.get(index).containsPoint(p))           // if Shape contains Point p, returns the Shape
                // at the specified position in listOfShapes... Then
                shapesAtPoint.add(listOfShapes.get(index));         //add shape to shapesAtPoint
        }

        sizeOfShapesAtPoint = shapesAtPoint.size();                 //get the size of shapesAtPoint
        if (sizeOfShapesAtPoint != 0)                               //if shapesAtPoint contains the Point
            return shapesAtPoint.get(shapesAtPoint.size() - 1);       //return the frontmost Shape in the drawing
        else
            return null;                                            //or null if no Shape contains the Point

    }
//---------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------

    /**
     * Replace the frontmost shape with a new shape.
     * called by: Add'Shape'.java
     *
     * @param shape
     */
    public void replaceFront(Shape shape) {
        listOfShapes.remove(listOfShapes.size() - 1);
        listOfShapes.add(shape);
    }

    /**
     * Removes a shape from the drawing.
     * called by: DeleteCmd.java
     *
     * @param shape
     */
    public void deleteShape(Shape shape) {
        if (shape != null)                                          //Check if shape is not null
        {
            listOfShapes.remove(listOfShapes.indexOf(shape));       //Remove shape
        }
    }

//----------------------------------------------------------------
//----------------------------------------------------------------

    /**
     * Moves a shape to the front
     * called by: moveToFrontCmd.java
     * @param shape
     */
    public void moveToFront(Shape shape)
    {
        if (shape != null)
        {
            deleteShape(shape);
            addShape(shape);
        }
    }

    /**
     * Moves a shape to the back
     * called by: moveToBackCmd.java
     * @param shape
     */
    public void moveToBack(Shape shape)
    {
        if (shape != null)
        {
            deleteShape(shape);
            listOfShapes.add(0, shape);
        }
    }
}