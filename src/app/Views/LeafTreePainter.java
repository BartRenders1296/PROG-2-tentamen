package app.Views;

import app.Enums.TreeSize;
import app.Enums.TreeType;
import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Random;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class LeafTreePainter extends TreePainter {

    private Tree tree;

    private final double SCREEN_WIDTH = 800;
    private final double SCREEN_HEIGHT = 600;
    private final Color TREE_TRUNK = Color.rgb(170,69,2);

    public LeafTreePainter(Tree tree) {
        this.tree = tree;
    }

    public void paintTree(GraphicsContext gc) {
        double xpos = (SCREEN_WIDTH / 100 * tree.getRelX());

        if(xpos < (tree.getSize().getLeafSize() / 2) || xpos - (tree.getSize().getLeafSize() * 2) > SCREEN_WIDTH){
            paintTree(tree, gc);
        } else {
            double ypos = (SCREEN_HEIGHT / 100 * tree.getRelY()) - (tree.getSize().getTotalHeight());

            gc.setFill(TREE_TRUNK);
            gc.fillRect(xpos - (tree.getSize().getTrunkWidth() / 2), ypos - 5, tree.getSize().getTrunkWidth(), tree.getSize().getTrunkHeight());
            gc.strokeRect(xpos - (tree.getSize().getTrunkWidth() / 2), ypos - 5, tree.getSize().getTrunkWidth(), tree.getSize().getTrunkHeight());

            gc.setFill(tree.getColor());
            gc.fillOval(xpos - (tree.getSize().getLeafSize() / 2), ypos - tree.getSize().getLeafSize(), tree.getSize().getLeafSize(), tree.getSize().getLeafSize());
            gc.strokeOval(xpos - (tree.getSize().getLeafSize() / 2), ypos - tree.getSize().getLeafSize(), tree.getSize().getLeafSize(), tree.getSize().getLeafSize());
        }
    }

}
