/**
 * Add Round Rectangle Class
 * adding Rectangle to the Drawing
 * Created by fedora on 1/21/17.
 */

import java.awt.*;

public class AddRoundRect extends Command
{
    private Point pressedPoint;				                                //point clicked by user
    private int numOfDragShapes;		                                    // # of times executeDrag is called

    public AddRoundRect()
    {
        pressedPoint = null;
        numOfDragShapes = 0;
    }

    /**
     * When pressed,
     * get the point clicked
     * and reset numOfDragShapes
     * @param dwg
     * @param p
     */
    public void executePress(Point p, Drawing dwg) {
        pressedPoint = p;
        numOfDragShapes = 0;
    }

    /**
     * When dragged,
     * if it is the first drag, add a new shape
     * else (more than one drag), delete that shape
     * and add the new shape to be the frontmost
     * @param dwg
     * @param p
     */
    public void executeDrag(Point p, Drawing dwg) {
        if (numOfDragShapes == 0) {
            dwg.listOfShapes.add(new RoundRectangle(
                    Math.min(pressedPoint.x,p.x),
                    Math.min(pressedPoint.y,p.y),
                        Math.abs(pressedPoint.x-p.x),
                        Math.abs(pressedPoint.y-p.y),

                    (int) (0.37*(Math.abs(pressedPoint.x-p.x))),
                    (int) (0.37*(Math.abs(pressedPoint.y-p.y))),

                    dwg.getColor()));
        } else {
            dwg.listOfShapes.remove(dwg.listOfShapes.size() - 1);
            dwg.listOfShapes.add(new RoundRectangle(
                    Math.min(pressedPoint.x,p.x),
                    Math.min(pressedPoint.y,p.y),
                    Math.abs(pressedPoint.x-p.x),
                    Math.abs(pressedPoint.y-p.y),

                    (int) (0.37*(Math.abs(pressedPoint.x-p.x))),
                    (int) (0.37*(Math.abs(pressedPoint.y-p.y))),

                    dwg.getColor()));
        }
        numOfDragShapes++;
    }


}

