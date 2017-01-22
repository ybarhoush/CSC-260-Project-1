/**
 * Created by fedora on 1/21/17.
 */
import java.awt.*;

public class MoveToFrontCmd extends Command
{

    /**
     * move the frontmost shape clicked to the front
     */
    public void executeClick(Point p, Drawing dwg)
    {
        dwg.moveToFront(dwg.getFrontmostContainer(p));
    }
}