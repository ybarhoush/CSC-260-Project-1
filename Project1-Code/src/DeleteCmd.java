/**
 * Delete Cmd Class
 * Created by fedora on 1/21/17.
 */
import java.awt.*;

public class DeleteCmd extends Command {

    /**
     * remove the frontmost shape from the drawing when reference point os clicked!
     */
    public void executeClick(Point p, Drawing dwg)
    {
        dwg.deleteShape(dwg.getFrontmostContainer(p));
    }
}