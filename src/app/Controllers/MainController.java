package app.Controllers;

import app.Enums.TreeType;
import app.Models.World;
import app.Threads.MovieThread;
import app.Views.LeafTreePainter;
import app.Views.PaintingFrame;
import app.Views.PineTreePainter;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

import java.awt.event.ActionEvent;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class MainController {

    private PaintingFrame paintingFrame;
    private World world;

    MovieThread movieThread;

    public MainController() {
        paintingFrame = new PaintingFrame();
        paintingFrame.show();
        world = new World();
        movieThread = new MovieThread();
        init();
    }

    private void init() {
        paintingFrame.getExit().setOnAction(actionEvent -> Platform.exit());

        paintingFrame.getAddLeaf().setOnAction(ActionEvent -> {
            world.addTree(TreeType.LEAF);
            paintingFrame.getPaintingPanel().paintComponent(world.getTrees());
        });

        paintingFrame.getAddPine().setOnAction(ActionEvent -> {
            world.addTree(TreeType.PINE);
            paintingFrame.getPaintingPanel().paintComponent(world.getTrees());
        });

        paintingFrame.getAddhundred().setOnAction(ActionEvent -> {
            for(int i = 0; i < 100; i++){
                world.addTree(TreeType.getRandomType());
            }
            paintingFrame.getPaintingPanel().paintComponent(world.getTrees());
        });

        paintingFrame.getArial().setSelected(true);
        paintingFrame.getArial().setOnAction(ActionEvent -> {
            paintingFrame.getAutograph().setFont(Font.font("Arial", paintingFrame.getAutograph().getFont().getSize()));
        });

        paintingFrame.getCourier().setOnAction(ActionEvent -> {
            paintingFrame.getAutograph().setFont(Font.font("Courier", paintingFrame.getAutograph().getFont().getSize()));
            paintingFrame.getCourier().setSelected(true);
        });

        paintingFrame.getHelvetica().setOnAction(ActionEvent -> {
            paintingFrame.getAutograph().setFont(Font.font("Helvetica", paintingFrame.getAutograph().getFont().getSize()));
            paintingFrame.getHelvetica().setSelected(true);
        });

        paintingFrame.getTimesNewRoman().setOnAction(ActionEvent -> {
            paintingFrame.getAutograph().setFont(Font.font("Times New Roman", paintingFrame.getAutograph().getFont().getSize()));
            paintingFrame.getTimesNewRoman().setSelected(true);
        });

        paintingFrame.getPlay().setOnAction(ActionEvent -> {
           movieThread.setTrees(world.getTrees());
           movieThread.toggle();
        });
    }
}
