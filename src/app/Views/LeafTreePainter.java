package app.Views;

import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class LeafTreePainter extends TreePainter {

    public LeafTreePainter(Tree tree) {
        setTree(tree);
    }

    public void paintTree(GraphicsContext gc) {
        double xpos = calcX(getTree());

        if (xpos < (getTree().getTreeSize().getLeafSize() / 2.0) || xpos - (getTree().getTreeSize().getLeafSize() * 2.0) > getSCREEN_WIDTH()) {
            paintTree(getTree(), gc);
        } else {
            double ypos = calcY(getTree());

            gc.setFill(getTREE_TRUNK());
            gc.fillRect(xpos - (getTree().getTreeSize().getTrunkWidth() / 2.0), ypos - 5.0, getTree().getTreeSize().getTrunkWidth(), getTree().getTreeSize().getTrunkHeight());
            gc.strokeRect(xpos - (getTree().getTreeSize().getTrunkWidth() / 2.0), ypos - 5.0, getTree().getTreeSize().getTrunkWidth(), getTree().getTreeSize().getTrunkHeight());

            gc.setFill(getTree().getColor());
            gc.fillOval(xpos - (getTree().getTreeSize().getLeafSize() / 2.0), ypos - getTree().getTreeSize().getLeafSize(), getTree().getTreeSize().getLeafSize(), getTree().getTreeSize().getLeafSize());
            gc.strokeOval(xpos - (getTree().getTreeSize().getLeafSize() / 2.0), ypos - getTree().getTreeSize().getLeafSize(), getTree().getTreeSize().getLeafSize(), getTree().getTreeSize().getLeafSize());
        }
    }
}
