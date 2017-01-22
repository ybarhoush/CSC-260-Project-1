/**
 * AddSegment Class
 * adding Segment to the Drawing
 * Created by fedora on 1/21/17.
 */

import java.awt.*;

public class AddSegment extends Command {
    private Point pressedPoint;				// Where the user clicks
    private int numDrags;		// Number of times executeDrag is called

    public AddSegment() {
        pressedPoint = null;
        numDrags = 0;
    }

    /**
     * On press, get the click point and reset numDrags
     */
    public void executePress(Point p, Drawing dwg) {
        pressedPoint = p;
        numDrags = 0;
    }

    /**
     * On drag, add new shape if it's the first drag, and replace that shape with
     * a new shape if it's at least the second drag.
     */
    public void executeDrag(Point p, Drawing dwg) {
        if (numDrags == 0) {
            dwg.listOfShapes.add(new Segment(
                    pressedPoint.x,
                    pressedPoint.y,
                    p.x,
                    p.y,
                    dwg.getColor()));
        }
        else {
            dwg.replaceFront(new Segment(
                    pressedPoint.x,
                    pressedPoint.y,
                    p.x,
                    p.y,
                    dwg.getColor()));
        }
        numDrags++;
    }
}