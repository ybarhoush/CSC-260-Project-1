/**
 * Color Cmd
 * Created by fedora on 1/22/17.
 */
import java.awt.*;

public class ColorCmd extends Command {

    /**
     * change Shape color to the Drawing object's current set color
     */
    public void executeClick(Point p, Drawing dwg) {
        Shape clickedShape = dwg.getFrontmostContainer(p);

        if (clickedShape != null)
        {
            clickedShape.setColor(dwg.getColor());
        }
    }
}