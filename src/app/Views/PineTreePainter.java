package app.Views;

import app.Models.Tree;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * Created by Bart Renders on 10-6-2017.
 */
public class PineTreePainter extends TreePainter {

    public PineTreePainter(Tree tree) {
        setTree(tree);
    }

    public void paintTree(GraphicsContext gc) {
        calcSize();

        double xpos = calcX();
        double ypos = calcY();

        gc.setFill(getTREE_TRUNK());
        gc.fillRect(xpos, ypos, trunkWidth, totalHeight);
        gc.strokeRect(xpos, ypos, trunkWidth, totalHeight);

        gc.setFill(getTree().getColor());
        double[] doubleX = {
            xpos - totalHeight / 2 / 1.9 - totalHeight / 2 / 1.9,
            xpos + totalHeight / 2 + trunkWidth * 1.5,
            xpos + trunkWidth / 2
        };

        double[] doubleY = {
            ypos - (totalHeight - leafSize) / 100 + 20,
            ypos - (totalHeight - leafSize) / 100 + 20,
            ypos - (totalHeight - leafSize) - totalHeight + 20
        };

        gc.fillPolygon(doubleX, doubleY, 3);
        gc.strokePolygon(doubleX, doubleY, 3);

//        double xpos = calcX(getTree());
//
//        if(xpos < (getTree().getTreeSize().getLeafSize() / 2) || xpos - (getTree().getTreeSize().getLeafSize() * 2) > getSCREEN_WIDTH()){
//            paintTree(getTree(), gc);
//        } else {
//            double ypos = calcY(getTree());
//
//            gc.setFill(getTREE_TRUNK());
//            gc.fillRect(xpos - (getTree().getTreeSize().getTrunkWidth() / 2), ypos, getTree().getTreeSize().getTrunkWidth(), getTree().getTreeSize().getTrunkHeight());
//            gc.strokeRect(xpos - (getTree().getTreeSize().getTrunkWidth() / 2), ypos, getTree().getTreeSize().getTrunkWidth(), getTree().getTreeSize().getTrunkHeight());
//
//            gc.setFill(getTree().getColor());
//
//            double[] doubleX = {
//                    xpos - getTree().getTreeSize().getLeafSize() / 2 - getTree().getTreeSize().getTrunkWidth() / 2,
//                    xpos + getTree().getTreeSize().getLeafSize() / 2 + getTree().getTreeSize().getTrunkWidth() * 1.5,
//                    xpos + getTree().getTreeSize().getTrunkWidth() / 2
//            };
//
//            double[] doubleY = {
//                    ypos - getTree().getTreeSize().getTrunkHeight() / 100 + 20,
//                    ypos - getTree().getTreeSize().getTrunkHeight() / 100 + 20,
//                    ypos - getTree().getTreeSize().getTrunkHeight() - getTree().getTreeSize().getLeafSize() + 20
//            };
//
//            gc.fillPolygon(doubleX, doubleY, 3);
//            gc.strokePolygon(doubleX, doubleY, 3);
//        }
    }
}
