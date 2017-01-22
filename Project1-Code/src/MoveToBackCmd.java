/**
 * Created by fedora on 1/21/17.
 */
import java.awt.*;

public class MoveToBackCmd extends Command
{

    /**
     * move the frontmost shape clicked to the back
     */
    public void executeClick(Point p, Drawing dwg)
    {
        dwg.moveToBack(dwg.getFrontmostContainer(p));
    }
}