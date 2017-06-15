package app.Views;

import app.Enums.TreeType;
import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public abstract class TreePainter {

    private Tree tree;

    private final double SCREEN_WIDTH = 800.0;
    private final double SCREEN_HEIGHT = 575.0;
    private final Color TREE_TRUNK = Color.rgb(170, 69, 2);
    private double totalHeight;
    private double leafSize;
    private double trunkHeight;
    private double trunkWidth;

    protected void paintTree(Tree tree, GraphicsContext gc) {
    }

    protected double calcX() {
        return (SCREEN_WIDTH / 100 * tree.getRelX());
    }

    protected double calcY() {
        return (SCREEN_HEIGHT / 100.0 * tree.getRelY()) - trunkHeight;
    }

    protected void calcSize() {
        totalHeight = tree.getRelY() * 1.5;

        if(tree.getType().equals(TreeType.LEAF)){
            leafSize = totalHeight / 2.0;
            trunkHeight = totalHeight - leafSize;
            trunkWidth = trunkHeight * 0.2;
        } else {

        }


    }

    protected double getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    protected double getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

    protected Color getTREE_TRUNK() {
        return TREE_TRUNK;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public double getTotalHeight() {
        return totalHeight;
    }

    public double getLeafSize() {
        return leafSize;
    }

    public double getTrunkHeight() {
        return trunkHeight;
    }

    public double getTrunkWidth() {
        return trunkWidth;
    }
}
