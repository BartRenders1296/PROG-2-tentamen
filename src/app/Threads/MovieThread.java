package app.Threads;

import app.Models.Tree;
import app.Views.PaintingPanel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class MovieThread extends Thread {

    private List<Tree> trees;
    private boolean active;
    private PaintingPanel paintingPanel;

    public MovieThread() {
        active = false;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public void setPaintingPanel(PaintingPanel paintingPanel){
        this.paintingPanel = paintingPanel;
    }

    public void run() {
        while(true){
            System.out.print("");
            if(active){

                List<Tree> treess = new ArrayList<>();

                trees.forEach(Tree -> {
                    Tree.move();
                    treess.add(Tree);
                });

                paintingPanel.paintComponent(treess);

                try {
                    Thread.sleep( 1000/24);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void toggle()
    {
        if(active){
            active = false;
        } else {
            active = true;
        }
    }

}
