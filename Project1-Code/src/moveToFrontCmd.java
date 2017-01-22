/**
 * Created by fedora on 1/21/17.
 */
import java.awt.*;

public class moveToFrontCmd extends Command
{

    /**
     *
     */
    public void executeClick(Point p, Drawing dwg)
    {
        dwg.moveToFront(dwg.getFrontmostContainer(p));
    }
}