/**
 * AddRectangle Class
 * adding Rectangle to the Drawing
 * Created by fedora on 1/21/17.
 */

import java.awt.*;

public class AddRectangle extends Command
{
    private Point pressedPoint;				                                // Where the user clicks
    private int numOfDrags;		                                        // Number of times executeDrag is called

    public AddRectangle()
    {
        pressedPoint = null;
        numOfDrags = 0;
    }

    /**
     * When pressed
     * get the point clicked
     * and reset numOfDrags
     */
    public void executePress(Point p, Drawing dwg) {
        pressedPoint = p;
        numOfDrags = 0;
    }

    /**
     * When dragged,
     * if it is the first drag, add a new shape
     * else (more than one drag), delete that shape
     * and add the new shape to be the frontmost
     */
    public void executeDrag(Point p, Drawing dwg) {
        if (numOfDrags == 0) {
            dwg.listOfShapes.add(new Rectangle(
                    Math.min(pressedPoint.x,p.x),
                    Math.min(pressedPoint.y,p.y),
                    Math.abs(pressedPoint.x-p.x),
                    Math.abs(pressedPoint.y-p.y),
                    dwg.getColor()));
        } else {
            dwg.listOfShapes.remove(dwg.listOfShapes.size() - 1);
            dwg.listOfShapes.add(new Rectangle(                         //Replace the frontmost shape with a new shape.
                    Math.min(pressedPoint.x,p.x),
                    Math.min(pressedPoint.y,p.y),
                    Math.abs(pressedPoint.x-p.x),
                    Math.abs(pressedPoint.y-p.y),
                    dwg.getColor()));
        }
        numOfDrags++;
    }
}

