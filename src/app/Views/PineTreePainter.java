package app.Views;

import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;


/**
 * Created by Bart Renders on 10-6-2017.
 */
public class PineTreePainter extends TreePainter {

    public PineTreePainter(Tree tree) {
        setTree(tree);
    }

    public void paintTree(GraphicsContext gc) {
        Tree tree = getTree();
        calcSize();

        gc.setFill(getTREE_TRUNK());

        gc.setFill(getTREE_TRUNK());
        gc.strokeRect(calcX(), calcY() - 25.0, getTrunkWidth(), getTrunkHeight());
        gc.fillRect(calcX(), calcY() - 25.0, getTrunkWidth(), getTrunkHeight());

        gc.setFill(tree.getColor());

        double[] doubleX = {
                calcX() - getLeafWidth() / 2 - getTrunkWidth() / 2,
                calcX() + getLeafWidth() / 2 + getTrunkWidth() * 1.5,
                calcX() + getTrunkWidth() / 2
        };

        double[] doubleY = {
                calcY() - getTrunkHeight() / 100 - 25,
                calcY() - getTrunkHeight() / 100 - 25,
                calcY() - getTrunkHeight() - getLeafHeight() - 25
        };

        gc.fillPolygon(doubleX, doubleY, 3);
        gc.strokePolygon(doubleX, doubleY, 3);
    }
}
