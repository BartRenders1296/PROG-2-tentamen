package app.Views;

import app.Enums.TreeColor;
import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public abstract class TreePainter {

    private Tree tree;

    private final double SCREEN_WIDTH = 800.0;
    private final double SCREEN_HEIGHT = 575.0;
    private final Color TREE_TRUNK = Color.rgb(170,69,2);

    protected void paintTree(Tree tree, GraphicsContext gc) {
    }

    protected double calcX(Tree tree) {
        return (SCREEN_WIDTH / 100 * tree.getRelX());
    }

    protected double calcY(Tree tree) {
        return (SCREEN_HEIGHT / 100.0 * tree.getRelY()) - (tree.getTreeSize().getTotalHeight());
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
}
