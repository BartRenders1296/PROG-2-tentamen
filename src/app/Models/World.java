package app.Models;

import app.Enums.TreeType;

import java.util.*;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class World extends Observable {

    private List<Tree> trees = new ArrayList<>();

    public void addTree(TreeType treeType) {
        Tree tree = new Tree();

        if (treeType.equals(TreeType.LEAF)) {
            tree.setType(TreeType.LEAF);
        } else {
            tree.setType(TreeType.PINE);
        }

        tree.setRelX(tree.randomRelX());
        tree.setRelY(tree.randomRelY());
        tree.setSize();
        tree.setSpeed();

        trees.add(tree);

        sortList();
        notifyObserver();
    }

    public void addTree(Tree tree) {
        trees.add(tree);
        sortList();
        notifyObserver();
    }

    private void notifyObserver() {
        setChanged();
        notifyObservers();
    }

    public void moveTrees() {
        trees.forEach(Tree -> Tree.move());
        notifyObserver();
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
