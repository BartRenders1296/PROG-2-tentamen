package app.Views;

import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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

        if(xpos < (tree.getTreeSize().getLeafSize() / 2) || xpos - (tree.getTreeSize().getLeafSize() * 2) > SCREEN_WIDTH){
            paintTree(tree, gc);
        } else {
            double ypos = (SCREEN_HEIGHT / 100 * tree.getRelY()) - (tree.getTreeSize().getTotalHeight());

            gc.setFill(TREE_TRUNK);
            gc.fillRect(xpos - (tree.getTreeSize().getTrunkWidth() / 2), ypos - 5, tree.getTreeSize().getTrunkWidth(), tree.getTreeSize().getTrunkHeight());
            gc.strokeRect(xpos - (tree.getTreeSize().getTrunkWidth() / 2), ypos - 5, tree.getTreeSize().getTrunkWidth(), tree.getTreeSize().getTrunkHeight());

            gc.setFill(tree.getColor());
            gc.fillOval(xpos - (tree.getTreeSize().getLeafSize() / 2), ypos - tree.getTreeSize().getLeafSize(), tree.getTreeSize().getLeafSize(), tree.getTreeSize().getLeafSize());
            gc.strokeOval(xpos - (tree.getTreeSize().getLeafSize() / 2), ypos - tree.getTreeSize().getLeafSize(), tree.getTreeSize().getLeafSize(), tree.getTreeSize().getLeafSize());
        }
    }

}
