/**
 * Created by fedora on 1/22/17.
 */
import java.awt.*;

public class MoveCmd extends Command {
    private Shape clickedShaped;						//shape that is clicked.
    private int centerOffsetX;	                        // Holds the distance from the click point to the
                                                        // center of the circle.
    private int centerOffsetY;	                        // Holds the distance from the click point to the
                                                        // center of the circle.

    /**
     * get the frontmost shape, and calculate the offsets (when press)
     */
    public void executePress(Point p, Drawing dwg)
    {
        clickedShaped = dwg.getFrontmostContainer(p);
        if (clickedShaped != null)
        {
            centerOffsetX = p.x - clickedShaped.getCenter().x;
            centerOffsetY = p.y - clickedShaped.getCenter().y;
        }
    }

    /**
     * move the shape relative to the offsets (when drag)
     */
    public void executeDrag(Point p, Drawing dwg)
    {
        if (clickedShaped != null)
        {
            clickedShaped.setCenter(new Point(p.x-centerOffsetX,p.y-centerOffsetY));
        }
    }
}