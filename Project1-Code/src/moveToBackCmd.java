/**
 * Created by fedora on 1/21/17.
 */
import java.awt.*;

public class moveToBackCmd extends Command
{

    /**
     *
     */
    public void executeClick(Point p, Drawing dwg)
    {
        dwg.moveToBack(dwg.getFrontmostContainer(p));
    }
}