package app.Views;

import app.Enums.TreeSize;
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
    private double leafWidth;
    private double leafHeight;
    private double trunkHeight;
    private double trunkWidth;

    protected void paintTree(Tree tree, GraphicsContext gc) {
    }

    protected double calcX() {
        return (SCREEN_WIDTH / 100 * tree.getRelX()) - leafWidth;
    }

    protected double calcY() {
        return (SCREEN_HEIGHT / 100.0 * tree.getRelY()) - trunkHeight;
    }

    protected void calcSize() {
        double distancePercentage = ((((tree.getRelY() - 50) * 90) / 50) + 10) / 100;
        switch (tree.getTreeSize()) {
            case S:
                trunkHeight = 30.0 * distancePercentage;
                trunkWidth = 7.0 * distancePercentage;
                leafHeight = 25.0 * distancePercentage;
                leafWidth = 25.0 * distancePercentage;
                totalHeight = trunkHeight + leafHeight;
                break;
            case M:
                trunkHeight = 50.0 * distancePercentage;
                trunkWidth = 11.0 * distancePercentage;
                leafHeight = 41.0 * distancePercentage;
                leafWidth = 41.0 * distancePercentage;
                totalHeight = trunkHeight + leafHeight;
                break;
            case L:
                trunkHeight = 70.0 * distancePercentage;
                trunkWidth = 15.0 * distancePercentage;
                leafHeight = 57.0 * distancePercentage;
                leafWidth = 57.0 * distancePercentage;
                totalHeight = trunkHeight + leafHeight;
                break;
            case XL:
                trunkHeight = 90.0 * distancePercentage;
                trunkWidth = 17.0 * distancePercentage;
                leafHeight = 74.0 * distancePercentage;
                leafWidth = 74.0 * distancePercentage;
                totalHeight = trunkHeight + leafHeight;
                break;
            case XXL:
                trunkHeight = 110.0 * distancePercentage;
                trunkWidth = 24.0 * distancePercentage;
                leafHeight = 90.0 * distancePercentage;
                leafWidth = 90.0 * distancePercentage;
                totalHeight = trunkHeight + leafHeight;
                break;
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

    public double getLeafWidth() {
        return leafWidth;
    }

    public double getLeafHeight() {
        return leafHeight;
    }

    public double getTrunkHeight() {
        return trunkHeight;
    }

    public double getTrunkWidth() {
        return trunkWidth;
    }
}
