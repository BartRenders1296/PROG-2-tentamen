package app.Threads;

import app.Models.Tree;

import java.util.List;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class MovieThread extends Thread {

    private List<Tree> trees;
    private boolean active;

    public MovieThread() {
        active = false;
        start();
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public void run() {
        while(true){
            if(active){
                System.out.println(active);
                trees.forEach(Tree -> Tree.move());

//                try
//                {
//                    Thread.sleep(1000);
//                }
//                catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
            }
        }
    }

    public void toggle()
    {
        active = !active;
    }

}
