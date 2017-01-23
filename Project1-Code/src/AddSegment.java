/**
 * AddSegment Class
 * adding Segment to the Drawing
 * Created by fedora on 1/21/17.
 */

import java.awt.*;

public class AddSegment extends Command {
    private Point pressedPoint;				                                //point clicked by user
    private int numOfDrags;		                                            // # of times executeDrag is called

    public AddSegment()
    {
        pressedPoint = null;
        numOfDrags = 0;
    }

    /**
     * When pressed
     * get the point clicked
     * and reset numOfDrags
     */
    public void executePress(Point p, Drawing dwg)
    {
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
            dwg.listOfShapes.add(new Segment(
                    pressedPoint.x,
                    pressedPoint.y,
                    p.x,
                    p.y,
                    dwg.getColor()));
        }
        else {
            dwg.listOfShapes.remove(dwg.listOfShapes.size() - 1);
            dwg.listOfShapes.add(new Segment(
                    pressedPoint.x,
                    pressedPoint.y,
                    p.x,
                    p.y,
                    dwg.getColor()));
        }
        numOfDrags++;
    }
}