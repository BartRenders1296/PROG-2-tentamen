package app.Models;

import app.Enums.TreeType;
import app.Threads.MovieThread;

import java.util.*;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class World extends Observable {

    List<Tree> trees = new ArrayList<>();

    public void addTree(TreeType treeType) {
        if(treeType.equals(TreeType.LEAF)){
            Tree tree = new Tree();
            tree.setType(TreeType.LEAF);
            tree.setRelX(tree.randomRelX());
            tree.setRelY(tree.randomRelY());
            tree.setSize();

            trees.add(tree);
        } else {
            Tree tree = new Tree();
            tree.setType(TreeType.PINE);
            tree.setRelX(tree.randomRelX());
            tree.setRelY(tree.randomRelY());
            tree.setSize();

            trees.add(tree);
        }

        sortList();
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    private void sortList() {
        Collections.sort(trees, new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                if (o1.getRelY() > o2.getRelY()) {
                    return 1;
                }
                if (o1.getRelY() < o2.getRelY()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public List<Tree> getTrees() {
        return trees;
    }
}
