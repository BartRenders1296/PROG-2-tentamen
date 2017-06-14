package app.Threads;

import app.Models.World;
import javafx.application.Platform;

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
        while (active) {
            try {
                Platform.runLater(() -> world.moveTrees());

                Thread.sleep(1000 / 24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void toggle() {
        active = !active;
    }

}
