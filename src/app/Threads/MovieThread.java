package app.Threads;

import app.Models.Tree;
import app.Models.World;
import app.Views.PaintingPanel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class MovieThread extends Thread {

    private boolean active = true;
    private World world;

    public MovieThread(World world) {
        this.world = world;
    }

    public void run() {
        while(active){
            try {
                world.moveTrees();

                Thread.sleep( 1000/24);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void toggle() {
        active = !active;
    }

}
