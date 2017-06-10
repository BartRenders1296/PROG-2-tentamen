package app.Views;

import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


/**
 * Created by Bart Renders on 10-6-2017.
 */
public class PineTreePainter extends TreePainter {

    private Tree tree;

    private final double SCREEN_WIDTH = 800;
    private final double SCREEN_HEIGHT = 600;
    private final Color TREE_TRUNK = Color.rgb(170,69,2);

    public PineTreePainter(Tree tree) {
        this.tree = tree;
    }

    public void paintTree(GraphicsContext gc) {
        double xpos = (SCREEN_WIDTH / 100 * tree.getRelX());

        if(xpos < (tree.getSize().getLeafSize() / 2) || xpos - (tree.getSize().getLeafSize() * 2) > SCREEN_WIDTH){
            paintTree(tree, gc);
        } else {
            double ypos = (SCREEN_HEIGHT / 100 * tree.getRelY()) - (tree.getSize().getTotalHeight());

            gc.setFill(TREE_TRUNK);
            gc.fillRect(xpos - (tree.getSize().getTrunkWidth() / 2), ypos, tree.getSize().getTrunkWidth(), tree.getSize().getTrunkHeight());
            gc.strokeRect(xpos - (tree.getSize().getTrunkWidth() / 2), ypos, tree.getSize().getTrunkWidth(), tree.getSize().getTrunkHeight());

            gc.setFill(tree.getColor());

            double[] doubleX = {
                    xpos - tree.getSize().getLeafSize() / 2 - tree.getSize().getTrunkWidth() / 2,
                    xpos + tree.getSize().getLeafSize() / 2 + tree.getSize().getTrunkWidth() * 1.5,
                    xpos + tree.getSize().getTrunkWidth() / 2
            };

            double[] doubleY = {
                    ypos - tree.getSize().getTrunkHeight() / 100 + 30,
                    ypos - tree.getSize().getTrunkHeight() / 100 + 30,
                    ypos - tree.getSize().getTrunkHeight() - tree.getSize().getLeafSize() + 30
            };

            gc.fillPolygon(doubleX, doubleY, 3);
            gc.strokePolygon(doubleX, doubleY, 3);
        }
    }
}
