package app.Views;

import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class LeafTreePainter extends TreePainter {

    public LeafTreePainter(Tree tree) {
        setTree(tree);
    }

    public void paintTree(GraphicsContext gc) {
        Tree tree = getTree();
        calcSize();

        gc.setFill(getTREE_TRUNK());
        gc.strokeRect(calcX() + ((getLeafWidth() / 2.0) - (getTrunkWidth() / 2.0)), calcY() - 25.0, getTrunkWidth(), getTrunkHeight());
        gc.fillRect(calcX() + ((getLeafWidth() / 2.0) - (getTrunkWidth() / 2.0)), calcY() - 25.0, getTrunkWidth(), getTrunkHeight());

        gc.setFill(tree.getColor());
        gc.strokeOval(calcX(), calcY() - getTrunkHeight() - 20.0, getLeafWidth(), getLeafHeight());
        gc.fillOval(calcX(), calcY() - getTrunkHeight() - 20.0, getLeafWidth(), getLeafHeight());
    }
}
