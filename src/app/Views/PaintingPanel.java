package app.Views;

import app.Enums.TreeType;
import app.Models.Tree;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class PaintingPanel extends Canvas implements Observer {

    public PaintingPanel(int width, int height) {
        super(width, height);
    }

    public void paintComponent(List<Tree> trees) {

        clear();

        trees.forEach(Tree -> {
            if(Tree.getType().equals(TreeType.LEAF)){
                LeafTreePainter leafTreePainter = new LeafTreePainter(Tree);
                leafTreePainter.paintTree(getGraphicsContext2D());
            } else {
                PineTreePainter pineTreePainter = new PineTreePainter(Tree);
                pineTreePainter.paintTree(getGraphicsContext2D());
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void clear() {
        getGraphicsContext2D().clearRect(0,0, getGraphicsContext2D().getCanvas().getWidth(), getGraphicsContext2D().getCanvas().getHeight());
    }
}
